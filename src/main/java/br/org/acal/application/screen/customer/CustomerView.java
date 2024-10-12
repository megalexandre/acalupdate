
package br.org.acal.application.screen.customer;

import br.org.acal.application.screen.address.model.AddressTableModel;
import br.org.acal.application.screen.customer.model.CustomerCreateRequest;
import br.org.acal.application.screen.customer.model.FindCustomer;
import br.org.acal.application.screen.render.StrippedTableCellRenderer;
import br.org.acal.domain.entity.Customer;
import br.org.acal.domain.usecase.customer.CustomerFindUseCase;
import br.org.acal.domain.usecase.customer.CustomerSaveUseCase;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.val;
import org.jdesktop.swingx.VerticalLayout;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.IntStream.range;
import static javax.swing.JOptionPane.showMessageDialog;

@Component
public class CustomerView extends JPanel {

   private final CustomerFindUseCase find;
   private final CustomerSaveUseCase save;
   private final Validator validator;

   private Customer customer;
   private static final int LIST_INDEX = 0;
   private static final int DETAIL_INDEX = 1;


   private String selectedIndex;

    public CustomerView(
            CustomerFindUseCase find,
            CustomerSaveUseCase save,
            Validator validator) {
        initComponents();
        this.find = find;
        this.save = save;
        this.validator = validator;
        startItems();
    }


    private void startItems(){
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
                selectedIndex = (String) table.getValueAt(row, 0);
            }

        });
    }

    private void search(ActionEvent e) {
        search();
    }

    private void search(){
        val customers = find.execute(createFilter());
        val tableModel = new CustomerTableModel(customers.stream().map(CustomerTable::of).toList());
        table.setModel(tableModel);
        val render = new StrippedTableCellRenderer();
        table.setDefaultRenderer(String.class, render);

        range(0, table.getColumnCount()).forEach(i ->
                table.getColumnModel().getColumn(i).setCellRenderer(render)
        );
        setContextMenu();
    }


    private FindCustomer createFilter() {
        val filter = FindCustomer.builder();

        if(textFieldName.getText() != null){
            filter.name(textFieldName.getText());
        }
        if(textFieldDocument.getText() != null){
            filter.document(textFieldDocument.getText());
        }

        return filter.build();
    }

    private void setContextMenu(){
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
                if (e.isPopupTrigger() && e.getComponent() instanceof JTable) {
                    int row = table.rowAtPoint(e.getPoint());
                    int column = table.columnAtPoint(e.getPoint());

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

    private void clear(ActionEvent e) {
        table.setModel(new AddressTableModel(List.of()));
        textFieldDocument.setText(null);
        textFieldName.setText(null);
    }

    private void textFieldNameKeyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            search();
        }
    }

    private void textFieldDocumentKeyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            search();
        }
    }

    private void editAction(ActionEvent e) {
        customer = find.execute(FindCustomer.builder().id(selectedIndex).build()).getFirst();
        loadCustomerData();
        tabbedPaneOptions.setSelectedIndex(DETAIL_INDEX);
    }

    private void loadCustomerData(){
        textFieldDocumentNumber.setText(customer.getDocument().documentNumber());
        textFieldCustomerName.setText(customer.getName());
        textFieldCustomerNumber.setText(customer.getPhoneNumber());
    }

    private void saveAction(ActionEvent e) {
        val request = CustomerCreateRequest.builder()
                .name(getCustomerName())
                .document(getDocumentNumber())
                .partnerNumber(getPartnerName())
                .phoneNumber(getPhoneNumber())
                .build();

        val violations = validator.validate(request);

        if (!violations.isEmpty()) {
            showMessageDialog(this,
                violations.stream().map(ConstraintViolation::getMessage)
                        .collect(Collectors.joining("\n"))
            );

            return;
        }

        save.execute(request.toCustomer());
        this.clearForm();
        tabbedPaneOptions.setSelectedIndex(0);
    }

    private void clearForm(){
        textFieldCustomerName.setText("");
        textFieldDocumentNumber.setText("");
        textFieldCustomerNumber.setText("");
        textFieldPhoneNumber.setText("");
    }

    private String getCustomerName(){
        return textFieldCustomerName.getText();
    }

    private String getDocumentNumber(){
        return textFieldDocumentNumber.getText();
    }

    private String getPartnerName(){
        return textFieldCustomerNumber.getText();
    }

    private String getPhoneNumber(){
        return textFieldPhoneNumber.getText();
    }

    private String getCreation(){
        return textFieldCreation.getText();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner non-commercial license
        tabbedPaneOptions = new JTabbedPane();
        panelList = new JPanel();
        panel1 = new JPanel();
        scrollPane1 = new JScrollPane();
        table = new JTable();
        panel8 = new JPanel();
        label3 = new JLabel();
        panelOptions = new JPanel();
        panel7 = new JPanel();
        panel5 = new JPanel();
        label1 = new JLabel();
        textFieldName = new JTextField();
        panel6 = new JPanel();
        label2 = new JLabel();
        textFieldDocument = new JTextField();
        panel4 = new JPanel();
        panel3 = new JPanel();
        buttonClear = new JButton();
        buttonSeach = new JButton();
        panel14 = new JPanel();
        panel10 = new JPanel();
        panelName = new JPanel();
        label4 = new JLabel();
        textFieldCustomerName = new JTextField();
        panel13 = new JPanel();
        label8 = new JLabel();
        textFieldDocumentNumber = new JTextField();
        panelNumber = new JPanel();
        label6 = new JLabel();
        textFieldCustomerNumber = new JTextField();
        panelPhone = new JPanel();
        label5 = new JLabel();
        textFieldPhoneNumber = new JTextField();
        panel11 = new JPanel();
        label7 = new JLabel();
        textFieldCreation = new JTextField();
        panel15 = new JPanel();
        button1 = new JButton();
        contextMenu = new JPopupMenu();
        menuItemEdit = new JMenuItem();
        menuItem2 = new JMenuItem();
        menuItem3 = new JMenuItem();

        //======== this ========
        setLayout(new GridLayout());

        //======== tabbedPaneOptions ========
        {

            //======== panelList ========
            {
                panelList.setBorder(null);
                panelList.setLayout(new BorderLayout());

                //======== panel1 ========
                {
                    panel1.setBorder(new EmptyBorder(5, 5, 5, 5));
                    panel1.setLayout(new BorderLayout());

                    //======== scrollPane1 ========
                    {
                        scrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
                        scrollPane1.setViewportView(table);
                    }
                    panel1.add(scrollPane1, BorderLayout.CENTER);

                    //======== panel8 ========
                    {
                        panel8.setLayout(new FlowLayout());

                        //---- label3 ----
                        label3.setText("S\u00f3cios:");
                        panel8.add(label3);
                    }
                    panel1.add(panel8, BorderLayout.NORTH);
                }
                panelList.add(panel1, BorderLayout.CENTER);

                //======== panelOptions ========
                {
                    panelOptions.setBorder(new EmptyBorder(5, 5, 5, 5));
                    panelOptions.setLayout(new BorderLayout());

                    //======== panel7 ========
                    {
                        panel7.setLayout(new BorderLayout());

                        //======== panel5 ========
                        {
                            panel5.setMinimumSize(new Dimension(150, 38));
                            panel5.setLayout(new VerticalLayout());

                            //---- label1 ----
                            label1.setText("Nome:");
                            panel5.add(label1);

                            //---- textFieldName ----
                            textFieldName.setMinimumSize(new Dimension(150, 22));
                            textFieldName.setPreferredSize(new Dimension(150, 22));
                            textFieldName.addKeyListener(new KeyAdapter() {
                                @Override
                                public void keyPressed(KeyEvent e) {
                                    textFieldNameKeyPressed(e);
                                }
                            });
                            panel5.add(textFieldName);
                        }
                        panel7.add(panel5, BorderLayout.WEST);

                        //======== panel6 ========
                        {
                            panel6.setMinimumSize(new Dimension(150, 38));
                            panel6.setLayout(new VerticalLayout());

                            //---- label2 ----
                            label2.setText("Documento:");
                            panel6.add(label2);

                            //---- textFieldDocument ----
                            textFieldDocument.setMinimumSize(new Dimension(150, 22));
                            textFieldDocument.setPreferredSize(new Dimension(150, 22));
                            textFieldDocument.addKeyListener(new KeyAdapter() {
                                @Override
                                public void keyPressed(KeyEvent e) {
                                    textFieldDocumentKeyPressed(e);
                                }
                            });
                            panel6.add(textFieldDocument);
                        }
                        panel7.add(panel6, BorderLayout.EAST);
                    }
                    panelOptions.add(panel7, BorderLayout.WEST);

                    //======== panel4 ========
                    {
                        panel4.setLayout(new BorderLayout());

                        //======== panel3 ========
                        {
                            panel3.setLayout(new BorderLayout());

                            //---- buttonClear ----
                            buttonClear.setText("Limpar");
                            buttonClear.addActionListener(e -> clear(e));
                            panel3.add(buttonClear, BorderLayout.WEST);

                            //---- buttonSeach ----
                            buttonSeach.setText("Consultar");
                            buttonSeach.addActionListener(e -> search(e));
                            panel3.add(buttonSeach, BorderLayout.EAST);
                        }
                        panel4.add(panel3, BorderLayout.SOUTH);
                    }
                    panelOptions.add(panel4, BorderLayout.EAST);
                }
                panelList.add(panelOptions, BorderLayout.SOUTH);
            }
            tabbedPaneOptions.addTab("Lista:", panelList);

            //======== panel14 ========
            {
                panel14.setLayout(new BorderLayout());

                //======== panel10 ========
                {
                    panel10.setPreferredSize(new Dimension(1200, 0));
                    panel10.setAlignmentX(1.0F);
                    panel10.setAlignmentY(1.0F);
                    panel10.setMinimumSize(new Dimension(800, 124));
                    panel10.setLayout(new GridBagLayout());
                    ((GridBagLayout)panel10.getLayout()).columnWidths = new int[] {0, 0, 0, 0};
                    ((GridBagLayout)panel10.getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0};
                    ((GridBagLayout)panel10.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 1.0E-4};
                    ((GridBagLayout)panel10.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 1.0E-4};

                    //======== panelName ========
                    {
                        panelName.setLayout(new VerticalLayout());

                        //---- label4 ----
                        label4.setText("Nome:");
                        panelName.add(label4);

                        //---- textFieldCustomerName ----
                        textFieldCustomerName.setPreferredSize(new Dimension(500, 26));
                        textFieldCustomerName.setAlignmentX(1.0F);
                        textFieldCustomerName.setAlignmentY(1.0F);
                        panelName.add(textFieldCustomerName);
                    }
                    panel10.add(panelName, new GridBagConstraints(0, 0, 2, 1, 0.7, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //======== panel13 ========
                    {
                        panel13.setLayout(new VerticalLayout());

                        //---- label8 ----
                        label8.setText("Documento");
                        panel13.add(label8);
                        panel13.add(textFieldDocumentNumber);
                    }
                    panel10.add(panel13, new GridBagConstraints(2, 0, 1, 1, 0.3, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 0), 0, 0));

                    //======== panelNumber ========
                    {
                        panelNumber.setPreferredSize(new Dimension(400, 42));
                        panelNumber.setLayout(new VerticalLayout());

                        //---- label6 ----
                        label6.setText("N\u00famero de S\u00f3cio:");
                        panelNumber.add(label6);
                        panelNumber.add(textFieldCustomerNumber);
                    }
                    panel10.add(panelNumber, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //======== panelPhone ========
                    {
                        panelPhone.setPreferredSize(new Dimension(400, 42));
                        panelPhone.setLayout(new VerticalLayout());

                        //---- label5 ----
                        label5.setText("N\u00famero de Telefone:");
                        panelPhone.add(label5);
                        panelPhone.add(textFieldPhoneNumber);
                    }
                    panel10.add(panelPhone, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //======== panel11 ========
                    {
                        panel11.setLayout(new VerticalLayout());

                        //---- label7 ----
                        label7.setText("Data de Matr\u00edcula:");
                        panel11.add(label7);

                        //---- textFieldCreation ----
                        textFieldCreation.setEnabled(false);
                        panel11.add(textFieldCreation);
                    }
                    panel10.add(panel11, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 0), 0, 0));
                }
                panel14.add(panel10, BorderLayout.CENTER);

                //======== panel15 ========
                {
                    panel15.setLayout(new BorderLayout());

                    //---- button1 ----
                    button1.setText("Salvar");
                    button1.addActionListener(e -> saveAction(e));
                    panel15.add(button1, BorderLayout.EAST);
                }
                panel14.add(panel15, BorderLayout.SOUTH);
            }
            tabbedPaneOptions.addTab("Cadastro:", panel14);
        }
        add(tabbedPaneOptions);

        //======== contextMenu ========
        {

            //---- menuItemEdit ----
            menuItemEdit.setText("Editar");
            menuItemEdit.addActionListener(e -> editAction(e));
            contextMenu.add(menuItemEdit);

            //---- menuItem2 ----
            menuItem2.setText("Liga\u00e7\u00f5es");
            contextMenu.add(menuItem2);

            //---- menuItem3 ----
            menuItem3.setText("Faturas");
            contextMenu.add(menuItem3);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner non-commercial license
    private JTabbedPane tabbedPaneOptions;
    private JPanel panelList;
    private JPanel panel1;
    private JScrollPane scrollPane1;
    private JTable table;
    private JPanel panel8;
    private JLabel label3;
    private JPanel panelOptions;
    private JPanel panel7;
    private JPanel panel5;
    private JLabel label1;
    private JTextField textFieldName;
    private JPanel panel6;
    private JLabel label2;
    private JTextField textFieldDocument;
    private JPanel panel4;
    private JPanel panel3;
    private JButton buttonClear;
    private JButton buttonSeach;
    private JPanel panel14;
    private JPanel panel10;
    private JPanel panelName;
    private JLabel label4;
    private JTextField textFieldCustomerName;
    private JPanel panel13;
    private JLabel label8;
    private JTextField textFieldDocumentNumber;
    private JPanel panelNumber;
    private JLabel label6;
    private JTextField textFieldCustomerNumber;
    private JPanel panelPhone;
    private JLabel label5;
    private JTextField textFieldPhoneNumber;
    private JPanel panel11;
    private JLabel label7;
    private JTextField textFieldCreation;
    private JPanel panel15;
    private JButton button1;
    private JPopupMenu contextMenu;
    private JMenuItem menuItemEdit;
    private JMenuItem menuItem2;
    private JMenuItem menuItem3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
