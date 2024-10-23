
package br.org.acal.application.screen.invoice;

import br.org.acal.application.components.combobox.JComboBoxModel;
import br.org.acal.application.components.combobox.JComboBoxStatus;
import br.org.acal.application.screen.invoice.model.table.InvoiceTable;
import br.org.acal.application.screen.invoice.model.table.InvoiceTableModel;
import br.org.acal.application.screen.link.model.LinkTableModel;
import br.org.acal.application.screen.render.InvoiceTableCellRenderer;
import br.org.acal.application.screen.render.StrippedTableCellRenderer;
import br.org.acal.commons.enumeration.StatusPaymentInvoice;
import br.org.acal.domain.entity.Invoice;
import br.org.acal.domain.entity.InvoicePayment;
import br.org.acal.domain.model.InvoiceFilter;
import br.org.acal.domain.usecase.address.AddressFindUseCase;
import br.org.acal.domain.usecase.category.CategoryFindAllUseCase;
import br.org.acal.domain.usecase.customer.CustomerFindAllUseCase;
import br.org.acal.domain.usecase.invoice.InvoiceDeleteUseCase;
import br.org.acal.domain.usecase.invoice.InvoiceMakePaymentUseCase;
import br.org.acal.domain.usecase.invoice.InvoicePaginateUseCase;
import br.org.acal.domain.usecase.invoice.InvoiceSaveUseCase;
import br.org.acal.domain.usecase.invoice.InvoiceSearchPrintReportUseCase;
import br.org.acal.domain.usecase.invoice.PaymentDeleteInvoiceUseCase;
import lombok.val;
import org.jdesktop.swingx.HorizontalLayout;
import org.jdesktop.swingx.VerticalLayout;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static java.util.Arrays.stream;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import static javax.swing.JOptionPane.showMessageDialog;

@Component
public class InvoiceView extends JPanel {

    private final int LIST_INDEX = 0;
    private final int CREATE_INDEX = 1;

    private final Logger logger = LoggerFactory.getLogger(InvoiceView.class);
    private final InvoicePaginateUseCase paginate;
    private final AddressFindUseCase findAllAddress;
    private final CategoryFindAllUseCase categoryFindAll;
    private final CustomerFindAllUseCase customerFindAll;
    private final InvoiceSearchPrintReportUseCase invoiceSearchPrintReportUseCase;
    private final InvoiceCreateView invoiceCreateView;

    private final InvoiceMakePaymentUseCase makePayment;
    private final InvoiceDeleteUseCase deleteInvoice;
    private final PaymentDeleteInvoiceUseCase deletePayment;
    private final InvoiceSaveUseCase invoiceSave;
    private String selectedAddress;
    private String selectedCategory;
    private String selectedCustomer;
    private int pageNumber = 0;
    private Page<Invoice> page;
    private final String SELECT = "Selecione";
    private String selectedInvoiceToPrint = null;
    private boolean initilized = false;

    public InvoiceView(
        InvoicePaginateUseCase paginate,
        AddressFindUseCase findAllAddress,
        CategoryFindAllUseCase categoryFindAll,
        CustomerFindAllUseCase customerFindAll,
        InvoiceSearchPrintReportUseCase invoiceSearchPrintReport,
        InvoiceSaveUseCase invoiceSave,
        InvoiceCreateView invoiceCreateView,
        InvoiceDeleteUseCase deleteInvoice,
        PaymentDeleteInvoiceUseCase deletePayment,
        InvoiceMakePaymentUseCase makePayment
    ) {
        initComponents();
        this.paginate = paginate;
        this.findAllAddress = findAllAddress;
        this.categoryFindAll = categoryFindAll;
        this.customerFindAll = customerFindAll;
        this.invoiceSearchPrintReportUseCase = invoiceSearchPrintReport;
        this.invoiceSave = invoiceSave;
        this.invoiceCreateView = invoiceCreateView;
        this.deleteInvoice = deleteInvoice;
        this.deletePayment = deletePayment;
        this.makePayment = makePayment;

        startComponents();
        this.initilized = true;
    }

    private void startComponents(){
        comboBoxAddress.addItem(JComboBoxModel.clearData());
        comboBoxAddress.addActionListener(e -> {
            var item = (JComboBoxModel) comboBoxAddress.getSelectedItem();
            if (item != null && !SELECT.equals(item.getName())) {
                selectedAddress = ((JComboBoxModel) comboBoxAddress.getSelectedItem()).getNumber();
            }
        });

        comboBoxCategory.addItem(JComboBoxModel.clearData());
        comboBoxCategory.addActionListener(e -> {
            var item = (JComboBoxModel) comboBoxCategory.getSelectedItem();
            if (item != null && !SELECT.equals(item.getName())) {
                selectedCategory = ((JComboBoxModel) comboBoxCategory.getSelectedItem()).getNumber();
            }
        });

        comboBoxCustomer.addItem(JComboBoxModel.clearData());
        comboBoxCustomer.addActionListener(e -> {
            var item = (JComboBoxModel) comboBoxCustomer.getSelectedItem();
            if (item != null && !SELECT.equals(item.getName())) {
                selectedCustomer = ((JComboBoxModel) comboBoxCustomer.getSelectedItem()).getNumber();
            }
        });

        comboBoxStatus.addItem(JComboBoxStatus.clearData());

        createMask();

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                showPopup(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                showPopup(e);
            }

            private void showPopup(MouseEvent e) {
                int row = table.rowAtPoint(e.getPoint());
                int column = table.columnAtPoint(e.getPoint());
                selectedInvoiceToPrint = (String) table.getValueAt(row, 3);

                if (e.isPopupTrigger() && e.getComponent() instanceof JTable) {
                    if (!table.isRowSelected(row)) {
                        table.setRowSelectionInterval(row, row);
                    }
                    if (!table.isColumnSelected(column)) {
                        table.setColumnSelectionInterval(column, column);
                    }

                    contextMenu.show(e.getComponent(), e.getX(), e.getY());

                }
            }
        });
    }


    private void createMask(){
        try {
            MaskFormatter maskFormatter = new MaskFormatter("##/####");
            maskFormatter.setPlaceholderCharacter('_');
            maskFormatter.install(formattedTextFieldPeriodMonth);
            formattedTextFieldPeriodMonth.setColumns(7);
        } catch (ParseException ignored) {
        }
    }
    private void search(ActionEvent e) {
        pageNumber = 0;
        search();
    }

    private void searchAction(ActionEvent e) {
        search();
    }

    private void search(){
        page = paginate.execute(createFilter());
        labelPageNumber.setText(String.valueOf(page.getNumber()) + 1);
        val invoices = page;
        val tableModel = new InvoiceTableModel(invoices.stream().map(InvoiceTable::of).toList());
        table.setModel(tableModel);
        table.setDefaultRenderer(String.class, new StrippedTableCellRenderer());

        labelHelp.setText(generatePageMessage(invoices));

        table.setDefaultRenderer(Object.class, new InvoiceTableCellRenderer());
    }

    public String generatePageMessage(Page<?> page) {
        int totalRecords = (int) page.getTotalElements();
        int firstElement = page.getNumber() * page.getSize() + 1;
        int lastElement = Math.min((page.getNumber() + 1) * page.getSize(), totalRecords);

        int currentPage = page.getNumber() + 1;
        int totalPages = page.getTotalPages();

        return String.format("Registro %d até %d de um total de %d, Pagina %d de um total de %d", firstElement, lastElement, totalRecords, currentPage, totalPages);
    }

    private InvoiceFilter createFilter(){
        return InvoiceFilter.builder()
            .selectedAddress(selectedAddress)
            .selectedCategory(selectedCategory)
            .selectedCustomer(selectedCustomer)
            .number("".equals(textFieldNumber.getText()) ? null: textFieldNumber.getText())
            .period(formattedTextFieldPeriodMonth.getText())
            .status(((JComboBoxStatus) Objects.requireNonNull(comboBoxStatus.getSelectedItem())).getStatus())
            .pageable(createPageable())
            .build();
    }


    private PageRequest createPageable(){
        var sort = Sort.by(
                Sort.Order.desc("period"),
                Sort.Order.desc("link.address.name"),
                Sort.Order.asc("link.customer.name")
        );

       return PageRequest.of(pageNumber, 100, sort);
    }



    private void comboBoxCategoryPopupMenuWillBecomeVisible(PopupMenuEvent e) {
        if(comboBoxCategory.getItemCount() <= 1){
            Optional.ofNullable(categoryFindAll.execute(null)).ifPresent(data ->
                data.forEach(item -> comboBoxCategory.addItem(JComboBoxModel.of(item)))
            );
        }
    }

    private void comboBoxAddressPopupMenuWillBecomeVisible(PopupMenuEvent e) {
        if(comboBoxAddress.getItemCount() <= 1){
            Optional.ofNullable(findAllAddress.execute(null)).ifPresent(data ->
                    data.forEach(item -> comboBoxAddress.addItem(JComboBoxModel.of(item)))
            );
        }
    }


    private void comboBoxCustomerPopupMenuWillBecomeVisible(PopupMenuEvent e) {
        if(comboBoxCustomer.getItemCount() <= 1){
            Optional.ofNullable(customerFindAll.execute(null)).ifPresent(data ->
                    data.forEach(item -> comboBoxCustomer.addItem(JComboBoxModel.of(item)))
            );
        }
    }

    private void comboBoxStatusPopupMenuWillBecomeVisible(PopupMenuEvent e) {
        if(comboBoxStatus.getItemCount() <= 1){
            stream(StatusPaymentInvoice.values()).forEach(it ->
                    comboBoxStatus.addItem(JComboBoxStatus.of (it))
            );
        }
    }

    private void clearAction(ActionEvent e) {
        clear();
    }

    private void clear(){
        selectedAddress = null;
        selectedCategory = null;
        selectedCustomer = null;

        comboBoxAddress.setSelectedIndex(0);
        comboBoxCategory.setSelectedIndex(0);
        comboBoxCustomer.setSelectedIndex(0);
        comboBoxStatus.setSelectedIndex(0);

        textFieldNumber.setText("");
        formattedTextFieldPeriodMonth.setValue("");
        createMask();

        table.setModel(new LinkTableModel(List.of()));
        pageNumber =0;
    }


    private void firstAction(ActionEvent e) {
        pageNumber = 0;
        search();
    }
    private void lastAction(ActionEvent e) {
        pageNumber = page.getTotalPages()-1;
        search();
    }
    private void nextAction(ActionEvent e) {
        if(pageNumber < page.getTotalPages()){
            pageNumber++;
            search();
        }
    }
    private void previousAction(ActionEvent e) {
        if(pageNumber > 0){
            pageNumber--;
            search();
        }
    }
    private void formattedTextFieldPeriodMonthKeyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            pageNumber = 0;
            search();
        }
    }
    private void textFieldNumberKeyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            pageNumber = 0;
            search();
        }
    }
    private void printAction(ActionEvent e) {
        try {
            textFieldNumber.setText(selectedInvoiceToPrint);
            invoiceSearchPrintReportUseCase.execute(createFilter());
        } catch (Exception ex){
            logger.error("Error when print report", ex);
            showMessageDialog(null, "An error occurred while generating the report: " + ex.getMessage(), "Error", INFORMATION_MESSAGE);
        }

    }

    private void buttonPrintAction(ActionEvent e) {
        try {
            invoiceSearchPrintReportUseCase.execute(createFilter());
        } catch (Exception ex){
            logger.error("Error when print report", ex);
            showMessageDialog(null, "An error occurred while generating the report: " + ex.getMessage(), "Error", INFORMATION_MESSAGE);
        }
    }

    private void receiverAction(ActionEvent e) {
        val invoice = page.getContent().stream()
                .filter(it -> it.getNumber().equals(selectedInvoiceToPrint))
                .findFirst().orElseThrow();

        val dialog = new InvoicePayView(SwingUtilities.getWindowAncestor(this), invoice);
        dialog.setSize(new Dimension(400, 400));
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
        val toSaveInvoice = dialog.getInvoice();
        val payment = InvoicePayment.builder().number(toSaveInvoice.getNumber()).payedAt(toSaveInvoice.getPayedAt()).build();

        makePayment.execute(payment);

        this.search();
    }

    private void tabbedPaneInvoiceStateChanged(ChangeEvent e) {

        if(initilized && (LIST_INDEX == tabbedPaneInvoice.getSelectedIndex())){
            clear();
        }

        if(CREATE_INDEX == tabbedPaneInvoice.getSelectedIndex()){
            invoiceCreateView.clear();
            panelCreate.add(invoiceCreateView);
        }

    }

    private void deleteAction(ActionEvent e) {

        int confirm = JOptionPane.showConfirmDialog(this,
                "Você deseja Apagar a Conta? " + selectedInvoiceToPrint, "Sim", YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            deleteInvoice.execute(selectedInvoiceToPrint);
            search();
        }
    }

    private void paymentDeleteAction() {
        int confirm = JOptionPane.showConfirmDialog(this,
                "Você remover o pagamento  da Conta? " + selectedInvoiceToPrint, "Sim", YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            deletePayment.execute(selectedInvoiceToPrint);
            search();
        }

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner non-commercial license
        tabbedPaneInvoice = new JTabbedPane();
        panel1 = new JPanel();
        panel3 = new JPanel();
        label1 = new JLabel();
        scrollPane1 = new JScrollPane();
        table = new JTable();
        panel2 = new JPanel();
        panel4 = new JPanel();
        panel6 = new JPanel();
        label2 = new JLabel();
        comboBoxAddress = new JComboBox<>();
        panel7 = new JPanel();
        label3 = new JLabel();
        comboBoxCategory = new JComboBox<>();
        panel8 = new JPanel();
        label4 = new JLabel();
        comboBoxCustomer = new JComboBox<>();
        panel9 = new JPanel();
        label5 = new JLabel();
        comboBoxStatus = new JComboBox<>();
        panel10 = new JPanel();
        label6 = new JLabel();
        formattedTextFieldPeriodMonth = new JFormattedTextField();
        panel14 = new JPanel();
        label7 = new JLabel();
        textFieldNumber = new JTextField();
        panel5 = new JPanel();
        button1 = new JButton();
        buttonClear = new JButton();
        buttonSearch = new JButton();
        panel11 = new JPanel();
        panel13 = new JPanel();
        labelHelp = new JLabel();
        panel12 = new JPanel();
        buttonFirst = new JButton();
        buttonPrevious = new JButton();
        labelPageNumber = new JLabel();
        buttonNext = new JButton();
        buttonLast = new JButton();
        panelCreate = new JPanel();
        contextMenu = new JPopupMenu();
        menuItemPrint = new JMenuItem();
        menuItemReceiver = new JMenuItem();
        menuItemPaymentDelete = new JMenuItem();
        menuItemDelete = new JMenuItem();

        //======== this ========
        setLayout(new BorderLayout());

        //======== tabbedPaneInvoice ========
        {
            tabbedPaneInvoice.addChangeListener(e -> tabbedPaneInvoiceStateChanged(e));

            //======== panel1 ========
            {
                panel1.setLayout(new BorderLayout());

                //======== panel3 ========
                {
                    panel3.setLayout(new FlowLayout());

                    //---- label1 ----
                    label1.setText("Faturas");
                    panel3.add(label1);
                }
                panel1.add(panel3, BorderLayout.NORTH);

                //======== scrollPane1 ========
                {
                    scrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

                    //---- table ----
                    table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                    scrollPane1.setViewportView(table);
                }
                panel1.add(scrollPane1, BorderLayout.CENTER);

                //======== panel2 ========
                {
                    panel2.setLayout(new BorderLayout());

                    //======== panel4 ========
                    {
                        panel4.setLayout(new HorizontalLayout());

                        //======== panel6 ========
                        {
                            panel6.setMinimumSize(new Dimension(150, 42));
                            panel6.setPreferredSize(new Dimension(150, 42));
                            panel6.setLayout(new VerticalLayout());

                            //---- label2 ----
                            label2.setText("Endere\u00e7o:");
                            panel6.add(label2);

                            //---- comboBoxAddress ----
                            comboBoxAddress.setPreferredSize(new Dimension(150, 26));
                            comboBoxAddress.setMinimumSize(new Dimension(150, 26));
                            comboBoxAddress.addPopupMenuListener(new PopupMenuListener() {
                                @Override
                                public void popupMenuCanceled(PopupMenuEvent e) {}
                                @Override
                                public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {}
                                @Override
                                public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
                                    comboBoxAddressPopupMenuWillBecomeVisible(e);
                                }
                            });
                            panel6.add(comboBoxAddress);
                        }
                        panel4.add(panel6);

                        //======== panel7 ========
                        {
                            panel7.setMinimumSize(new Dimension(150, 16));
                            panel7.setPreferredSize(new Dimension(150, 16));
                            panel7.setLayout(new VerticalLayout());

                            //---- label3 ----
                            label3.setText("Categoria:");
                            panel7.add(label3);

                            //---- comboBoxCategory ----
                            comboBoxCategory.setMinimumSize(new Dimension(150, 26));
                            comboBoxCategory.setPreferredSize(new Dimension(150, 26));
                            comboBoxCategory.addPopupMenuListener(new PopupMenuListener() {
                                @Override
                                public void popupMenuCanceled(PopupMenuEvent e) {}
                                @Override
                                public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {}
                                @Override
                                public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
                                    comboBoxCategoryPopupMenuWillBecomeVisible(e);
                                }
                            });
                            panel7.add(comboBoxCategory);
                        }
                        panel4.add(panel7);

                        //======== panel8 ========
                        {
                            panel8.setLayout(new VerticalLayout());

                            //---- label4 ----
                            label4.setText("S\u00f3cio:");
                            panel8.add(label4);

                            //---- comboBoxCustomer ----
                            comboBoxCustomer.setPreferredSize(new Dimension(150, 26));
                            comboBoxCustomer.setMinimumSize(new Dimension(150, 26));
                            comboBoxCustomer.addPopupMenuListener(new PopupMenuListener() {
                                @Override
                                public void popupMenuCanceled(PopupMenuEvent e) {}
                                @Override
                                public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {}
                                @Override
                                public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
                                    comboBoxCustomerPopupMenuWillBecomeVisible(e);
                                }
                            });
                            panel8.add(comboBoxCustomer);
                        }
                        panel4.add(panel8);

                        //======== panel9 ========
                        {
                            panel9.setLayout(new VerticalLayout());

                            //---- label5 ----
                            label5.setText("Status:");
                            panel9.add(label5);

                            //---- comboBoxStatus ----
                            comboBoxStatus.setMinimumSize(new Dimension(150, 26));
                            comboBoxStatus.setPreferredSize(new Dimension(150, 26));
                            comboBoxStatus.addPopupMenuListener(new PopupMenuListener() {
                                @Override
                                public void popupMenuCanceled(PopupMenuEvent e) {}
                                @Override
                                public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {}
                                @Override
                                public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
                                    comboBoxStatusPopupMenuWillBecomeVisible(e);
                                }
                            });
                            panel9.add(comboBoxStatus);
                        }
                        panel4.add(panel9);

                        //======== panel10 ========
                        {
                            panel10.setMinimumSize(new Dimension(150, 42));
                            panel10.setPreferredSize(new Dimension(150, 42));
                            panel10.setLayout(new VerticalLayout());

                            //---- label6 ----
                            label6.setText("Periodo:");
                            panel10.add(label6);

                            //---- formattedTextFieldPeriodMonth ----
                            formattedTextFieldPeriodMonth.setMinimumSize(new Dimension(150, 26));
                            formattedTextFieldPeriodMonth.setPreferredSize(new Dimension(150, 26));
                            formattedTextFieldPeriodMonth.addKeyListener(new KeyAdapter() {
                                @Override
                                public void keyPressed(KeyEvent e) {
                                    formattedTextFieldPeriodMonthKeyPressed(e);
                                }
                            });
                            panel10.add(formattedTextFieldPeriodMonth);
                        }
                        panel4.add(panel10);

                        //======== panel14 ========
                        {
                            panel14.setLayout(new VerticalLayout());

                            //---- label7 ----
                            label7.setText("N\u00famero:");
                            panel14.add(label7);

                            //---- textFieldNumber ----
                            textFieldNumber.setPreferredSize(new Dimension(150, 26));
                            textFieldNumber.setMinimumSize(new Dimension(150, 26));
                            textFieldNumber.addKeyListener(new KeyAdapter() {
                                @Override
                                public void keyPressed(KeyEvent e) {
                                    textFieldNumberKeyPressed(e);
                                }
                            });
                            panel14.add(textFieldNumber);
                        }
                        panel4.add(panel14);
                    }
                    panel2.add(panel4, BorderLayout.NORTH);

                    //======== panel5 ========
                    {
                        panel5.setLayout(new FlowLayout(FlowLayout.RIGHT));

                        //---- button1 ----
                        button1.setText("Imprimir");
                        button1.addActionListener(e -> buttonPrintAction(e));
                        panel5.add(button1);

                        //---- buttonClear ----
                        buttonClear.setText("Limpar");
                        buttonClear.addActionListener(e -> clearAction(e));
                        panel5.add(buttonClear);

                        //---- buttonSearch ----
                        buttonSearch.setText("Consultar");
                        buttonSearch.addActionListener(e -> {
			search(e);
			searchAction(e);
		});
                        panel5.add(buttonSearch);
                    }
                    panel2.add(panel5, BorderLayout.SOUTH);

                    //======== panel11 ========
                    {
                        panel11.setLayout(new VerticalLayout());

                        //======== panel13 ========
                        {
                            panel13.setLayout(new FlowLayout());
                            panel13.add(labelHelp);
                        }
                        panel11.add(panel13);

                        //======== panel12 ========
                        {
                            panel12.setLayout(new FlowLayout());

                            //---- buttonFirst ----
                            buttonFirst.setText("<< Primera");
                            buttonFirst.addActionListener(e -> firstAction(e));
                            panel12.add(buttonFirst);

                            //---- buttonPrevious ----
                            buttonPrevious.setText("< Anterior");
                            buttonPrevious.addActionListener(e -> previousAction(e));
                            panel12.add(buttonPrevious);

                            //---- labelPageNumber ----
                            labelPageNumber.setText("0");
                            panel12.add(labelPageNumber);

                            //---- buttonNext ----
                            buttonNext.setText("Proxima >");
                            buttonNext.addActionListener(e -> nextAction(e));
                            panel12.add(buttonNext);

                            //---- buttonLast ----
                            buttonLast.setText("Ultima >>");
                            buttonLast.addActionListener(e -> lastAction(e));
                            panel12.add(buttonLast);
                        }
                        panel11.add(panel12);
                    }
                    panel2.add(panel11, BorderLayout.CENTER);
                }
                panel1.add(panel2, BorderLayout.SOUTH);
            }
            tabbedPaneInvoice.addTab("Lista", panel1);

            //======== panelCreate ========
            {
                panelCreate.setLayout(new BorderLayout());
            }
            tabbedPaneInvoice.addTab("Gerar", panelCreate);
        }
        add(tabbedPaneInvoice, BorderLayout.CENTER);

        //======== contextMenu ========
        {

            //---- menuItemPrint ----
            menuItemPrint.setText("Imprimir");
            menuItemPrint.addActionListener(e -> printAction(e));
            contextMenu.add(menuItemPrint);

            //---- menuItemReceiver ----
            menuItemReceiver.setText("Receber");
            menuItemReceiver.addActionListener(e -> receiverAction(e));
            contextMenu.add(menuItemReceiver);

            //---- menuItemPaymentDelete ----
            menuItemPaymentDelete.setText("Deletar Pagamento");
            menuItemPaymentDelete.addActionListener(e -> paymentDeleteAction());
            contextMenu.add(menuItemPaymentDelete);

            //---- menuItemDelete ----
            menuItemDelete.setText("Deletar Conta");
            menuItemDelete.addActionListener(e -> deleteAction(e));
            contextMenu.add(menuItemDelete);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner non-commercial license
    private JTabbedPane tabbedPaneInvoice;
    private JPanel panel1;
    private JPanel panel3;
    private JLabel label1;
    private JScrollPane scrollPane1;
    private JTable table;
    private JPanel panel2;
    private JPanel panel4;
    private JPanel panel6;
    private JLabel label2;
    private JComboBox<JComboBoxModel> comboBoxAddress;
    private JPanel panel7;
    private JLabel label3;
    private JComboBox<JComboBoxModel> comboBoxCategory;
    private JPanel panel8;
    private JLabel label4;
    private JComboBox<JComboBoxModel> comboBoxCustomer;
    private JPanel panel9;
    private JLabel label5;
    private JComboBox<JComboBoxStatus> comboBoxStatus;
    private JPanel panel10;
    private JLabel label6;
    private JFormattedTextField formattedTextFieldPeriodMonth;
    private JPanel panel14;
    private JLabel label7;
    private JTextField textFieldNumber;
    private JPanel panel5;
    private JButton button1;
    private JButton buttonClear;
    private JButton buttonSearch;
    private JPanel panel11;
    private JPanel panel13;
    private JLabel labelHelp;
    private JPanel panel12;
    private JButton buttonFirst;
    private JButton buttonPrevious;
    private JLabel labelPageNumber;
    private JButton buttonNext;
    private JButton buttonLast;
    private JPanel panelCreate;
    private JPopupMenu contextMenu;
    private JMenuItem menuItemPrint;
    private JMenuItem menuItemReceiver;
    private JMenuItem menuItemPaymentDelete;
    private JMenuItem menuItemDelete;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
