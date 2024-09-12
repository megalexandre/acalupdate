
package br.org.acal.application.screen.customer;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.Optional;
import javax.swing.*;
import javax.swing.border.*;

import br.org.acal.application.screen.address.AddressTableModel;
import br.org.acal.application.screen.customer.model.FindCustomer;
import br.org.acal.application.screen.render.StrippedTableCellRenderer;
import br.org.acal.domain.usecase.customer.CustomerFindUseCase;
import lombok.val;
import org.jdesktop.swingx.*;
import org.springframework.stereotype.Component;

import static java.util.stream.IntStream.range;

@Component
public class CustomerView extends JPanel {

   private final CustomerFindUseCase find;

    public CustomerView(CustomerFindUseCase find) {
        initComponents();
        this.find = find;
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
            filter.name(Optional.of(textFieldName.getText()));
        }
        if(textFieldDocument.getText() != null){
            filter.document(Optional.of(textFieldDocument.getText()));
        }

        return filter.build();
    }

    private void seach(ActionEvent e) {
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

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner non-commercial license
        tabbedPane1 = new JTabbedPane();
        panel2 = new JPanel();
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
        contextMenu = new JPopupMenu();
        menuItem1 = new JMenuItem();
        menuItem2 = new JMenuItem();
        menuItem3 = new JMenuItem();

        //======== this ========
        setLayout(new GridLayout());

        //======== tabbedPane1 ========
        {

            //======== panel2 ========
            {
                panel2.setBorder(null);
                panel2.setLayout(new BorderLayout());

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
                panel2.add(panel1, BorderLayout.CENTER);

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
                            buttonSeach.addActionListener(e -> {
			seach(e);
			search(e);
		});
                            panel3.add(buttonSeach, BorderLayout.EAST);
                        }
                        panel4.add(panel3, BorderLayout.SOUTH);
                    }
                    panelOptions.add(panel4, BorderLayout.EAST);
                }
                panel2.add(panelOptions, BorderLayout.SOUTH);
            }
            tabbedPane1.addTab("Lista", panel2);
        }
        add(tabbedPane1);

        //======== contextMenu ========
        {

            //---- menuItem1 ----
            menuItem1.setText("Visualizar");
            contextMenu.add(menuItem1);

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
    private JTabbedPane tabbedPane1;
    private JPanel panel2;
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
    private JPopupMenu contextMenu;
    private JMenuItem menuItem1;
    private JMenuItem menuItem2;
    private JMenuItem menuItem3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
