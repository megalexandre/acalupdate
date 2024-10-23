
package br.org.acal.application.screen.customer;

import br.org.acal.application.screen.address.crud.create.AddressCreateView;
import br.org.acal.application.screen.address.model.AddressTableModel;
import br.org.acal.application.screen.customer.model.CustomerTable;
import br.org.acal.application.screen.customer.model.CustomerTableModel;
import br.org.acal.application.screen.customer.model.FindCustomer;
import br.org.acal.application.screen.render.StrippedTableCellRenderer;
import br.org.acal.domain.entity.Customer;
import br.org.acal.domain.usecase.customer.CustomerFindUseCase;
import br.org.acal.domain.usecase.customer.CustomerSaveUseCase;
import jakarta.validation.Validator;
import lombok.val;
import org.jdesktop.swingx.VerticalLayout;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.stream.IntStream.range;
import static javax.swing.SwingUtilities.getWindowAncestor;

@Component
public class CustomerView extends JPanel {

   private final CustomerFindUseCase find;
   private final CustomerSaveUseCase save;
   private final Validator validator;

   private Customer customer;
   private List<Customer> customers;
   private static final int DETAIL_INDEX = 1;

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
                val selectedIndex = (String) table.getValueAt(row, 1);
                customer = customers.stream().filter(it -> Objects.equals(it.getNumber(), selectedIndex)).findFirst().orElseThrow();
            }

        });
    }

    private void search(ActionEvent e) {
        search();
    }

    private void search(){
        customers = find.execute(createFilter());
        AtomicInteger counter = new AtomicInteger(1);

        CustomerTableModel tableModel = new CustomerTableModel(customers.stream().map(
                it -> CustomerTable.of(it, String.valueOf(counter.getAndIncrement()))).toList());

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
        val dialog = new CustomerCreateDialog(getWindowAncestor(this), customer, validator,   save, this::search);
        dialog.setVisible(true);
    }

    private void buttonSaveEvent() {
        val dialog = new CustomerCreateDialog(getWindowAncestor(this), null, validator,   save, this::search);
        dialog.setVisible(true);
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
        buttonCreate = new JButton();
        buttonClear = new JButton();
        buttonSeach = new JButton();
        contextMenu = new JPopupMenu();
        menuItemEdit = new JMenuItem();

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

                        //---- table ----
                        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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

                            //---- buttonCreate ----
                            buttonCreate.setText("Criar");
                            buttonCreate.addActionListener(e -> buttonSaveEvent());
                            panel3.add(buttonCreate, BorderLayout.CENTER);

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
        }
        add(tabbedPaneOptions);

        //======== contextMenu ========
        {

            //---- menuItemEdit ----
            menuItemEdit.setText("Editar");
            menuItemEdit.addActionListener(e -> editAction(e));
            contextMenu.add(menuItemEdit);
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
    private JButton buttonCreate;
    private JButton buttonClear;
    private JButton buttonSeach;
    private JPopupMenu contextMenu;
    private JMenuItem menuItemEdit;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
