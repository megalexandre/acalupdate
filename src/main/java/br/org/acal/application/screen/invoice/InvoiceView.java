
package br.org.acal.application.screen.invoice;

import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.MaskFormatter;

import br.org.acal.application.screen.invoice.model.InvoiceTable;
import br.org.acal.application.screen.invoice.model.InvoiceTableModel;
import br.org.acal.application.screen.link.model.JComboBoxModel;
import br.org.acal.application.screen.link.model.JComboBoxStatus;
import br.org.acal.application.screen.link.model.LinkTableModel;
import br.org.acal.application.screen.render.StrippedTableCellRenderer;
import br.org.acal.commons.enumeration.StatusPaymentInvoice;
import br.org.acal.domain.model.InvoicePaginate;
import br.org.acal.domain.usecase.address.AddressFindAllUsecase;
import br.org.acal.domain.usecase.category.CategoryFindAllUseCase;
import br.org.acal.domain.usecase.customer.CustomerFindAllUseCase;
import br.org.acal.domain.usecase.invoice.InvoicePaginateUseCase;
import lombok.val;
import org.jdesktop.swingx.*;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import static java.util.stream.IntStream.range;

@Component
public class InvoiceView extends JPanel {
    private final InvoicePaginateUseCase paginate;
    private final AddressFindAllUsecase findAllAddress;
    private final CategoryFindAllUseCase categoryFindAll;
    private final CustomerFindAllUseCase customerFindAll;
    private String selectedAddress;
    private String selectedCategory;
    private String selectedCustomer;

    private final String SELECT = "Selecione";

    public InvoiceView(
        InvoicePaginateUseCase paginate,
        AddressFindAllUsecase findAllAddress,
        CategoryFindAllUseCase categoryFindAll,
        CustomerFindAllUseCase customerFindAll
    ) {
        initComponents();
        this.paginate = paginate;
        this.findAllAddress = findAllAddress;
        this.categoryFindAll = categoryFindAll;
        this.customerFindAll = customerFindAll;
        startComponents();
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
        search();
    }

    private void searchAction(ActionEvent e) {
        search();
    }

    private void search(){
        val invoices = paginate.execute(createFilter());
        val tableModel = new InvoiceTableModel(invoices.stream().map(InvoiceTable::of).toList());
        table.setModel(tableModel);
        table.setDefaultRenderer(String.class, new StrippedTableCellRenderer());

        labelHelp.setText(generatePageMessage(invoices));

        val render = new StrippedTableCellRenderer();
        table.setDefaultRenderer(String.class, render);
        range(0, table.getColumnCount()).forEach(i ->
            table.getColumnModel().getColumn(i).setCellRenderer(render)
        );
    }

    public String generatePageMessage(Page<?> page) {
        int totalRecords = (int) page.getTotalElements();
        int firstElement = page.getNumber() * page.getSize() + 1;
        int lastElement = Math.min((page.getNumber() + 1) * page.getSize(), totalRecords);

        int currentPage = page.getNumber() + 1;
        int totalPages = page.getTotalPages();

        return String.format("Registro %d até %d de um total de %d, Pagina %d de um total de %d", firstElement, lastElement, totalRecords, currentPage, totalPages);
    }

    private InvoicePaginate createFilter(){
        return InvoicePaginate.builder()
            .selectedAddress(selectedAddress)
            .selectedCategory(selectedCategory)
            .selectedCustomer(selectedCustomer)
            .period(formattedTextFieldPeriodMonth.getText())
            .status(((JComboBoxStatus) comboBoxStatus.getSelectedItem()).getStatus())
            .build();
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
            Arrays.stream(StatusPaymentInvoice.values()).forEach(it ->
                    comboBoxStatus.addItem(JComboBoxStatus.of (it))
            );
        }
    }


    private void comboBoxAddressPopupMenuWillBecomeInvisible(PopupMenuEvent e) {

    }

    private void clearAction(ActionEvent e) {
        selectedAddress = null;
        selectedCategory = null;
        selectedCustomer = null;

        comboBoxAddress.setSelectedIndex(0);
        comboBoxCategory.setSelectedIndex(0);
        comboBoxCustomer.setSelectedIndex(0);
        comboBoxStatus.setSelectedIndex(0);

        formattedTextFieldPeriodMonth.setValue("");
        createMask();

        table.setModel(new LinkTableModel(List.of()));
    }



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner non-commercial license
        tabbedPane1 = new JTabbedPane();
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
        panel5 = new JPanel();
        buttonClear = new JButton();
        buttonSearch = new JButton();
        panel11 = new JPanel();
        panel13 = new JPanel();
        labelHelp = new JLabel();
        panel12 = new JPanel();
        button3 = new JButton();
        button1 = new JButton();
        button2 = new JButton();
        button4 = new JButton();

        //======== this ========
        setLayout(new BorderLayout());

        //======== tabbedPane1 ========
        {

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
                                public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
                                    comboBoxAddressPopupMenuWillBecomeInvisible(e);
                                }
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
                            panel10.add(formattedTextFieldPeriodMonth);
                        }
                        panel4.add(panel10);
                    }
                    panel2.add(panel4, BorderLayout.NORTH);

                    //======== panel5 ========
                    {
                        panel5.setLayout(new FlowLayout(FlowLayout.RIGHT));

                        //---- buttonClear ----
                        buttonClear.setText("Limpar");
                        buttonClear.addActionListener(e -> clearAction(e));
                        panel5.add(buttonClear);

                        //---- buttonSearch ----
                        buttonSearch.setText("Consultar");
                        buttonSearch.setHorizontalAlignment(SwingConstants.LEFT);
                        buttonSearch.setVerticalAlignment(SwingConstants.BOTTOM);
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

                            //---- labelHelp ----
                            labelHelp.setText("Ajuda");
                            panel13.add(labelHelp);
                        }
                        panel11.add(panel13);

                        //======== panel12 ========
                        {
                            panel12.setLayout(new FlowLayout());

                            //---- button3 ----
                            button3.setText("<< Primera");
                            panel12.add(button3);

                            //---- button1 ----
                            button1.setText("< Anterior");
                            panel12.add(button1);

                            //---- button2 ----
                            button2.setText("Proxima >");
                            panel12.add(button2);

                            //---- button4 ----
                            button4.setText("Ultima >>");
                            panel12.add(button4);
                        }
                        panel11.add(panel12);
                    }
                    panel2.add(panel11, BorderLayout.CENTER);
                }
                panel1.add(panel2, BorderLayout.SOUTH);
            }
            tabbedPane1.addTab("Lista", panel1);
        }
        add(tabbedPane1, BorderLayout.CENTER);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner non-commercial license
    private JTabbedPane tabbedPane1;
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
    private JPanel panel5;
    private JButton buttonClear;
    private JButton buttonSearch;
    private JPanel panel11;
    private JPanel panel13;
    private JLabel labelHelp;
    private JPanel panel12;
    private JButton button3;
    private JButton button1;
    private JButton button2;
    private JButton button4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
