
package br.org.acal.application.screen.customer;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;
import javax.swing.border.*;

import br.org.acal.application.screen.address.AddressTableModel;
import br.org.acal.domain.usecase.customer.FindCustomer;
import lombok.val;
import org.jdesktop.swingx.*;
import org.springframework.stereotype.Component;

@Component
public class CustomerView extends JPanel {

   public FindCustomer find;

    public CustomerView(FindCustomer find) {
        initComponents();
        this.find = find;
    }

    private void search(ActionEvent e) {
        val customers = find.execute(null);
        val tableModel = new CustomerTableModel(customers.stream().map(CustomerTable::of).toList());
        table.setModel(tableModel);
    }

    private void seach(ActionEvent e) {

        // TODO add your code here
    }

    private void clear(ActionEvent e) {
        table.setModel(new AddressTableModel(List.of()));
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner non-commercial license
        tabbedPane1 = new JTabbedPane();
        panel2 = new JPanel();
        panel1 = new JPanel();
        scrollPane1 = new JScrollPane();
        table = new JTable();
        panelOptions = new JPanel();
        panel7 = new JPanel();
        panel6 = new JPanel();
        label2 = new JLabel();
        textFieldDocument = new JTextField();
        panel5 = new JPanel();
        label1 = new JLabel();
        textFieldName = new JTextField();
        panel4 = new JPanel();
        buttonClear = new JButton();
        buttonSeach = new JButton();

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
                        scrollPane1.setViewportView(table);
                    }
                    panel1.add(scrollPane1, BorderLayout.CENTER);
                }
                panel2.add(panel1, BorderLayout.CENTER);

                //======== panelOptions ========
                {
                    panelOptions.setBorder(new EmptyBorder(5, 5, 5, 5));
                    panelOptions.setLayout(new BorderLayout());

                    //======== panel7 ========
                    {
                        panel7.setLayout(new HorizontalLayout());

                        //======== panel6 ========
                        {
                            panel6.setLayout(new HorizontalLayout());

                            //---- label2 ----
                            label2.setText("Documento:");
                            panel6.add(label2);
                            panel6.add(textFieldDocument);
                        }
                        panel7.add(panel6);

                        //======== panel5 ========
                        {
                            panel5.setLayout(new HorizontalLayout());

                            //---- label1 ----
                            label1.setText("Name:");
                            panel5.add(label1);
                            panel5.add(textFieldName);
                        }
                        panel7.add(panel5);
                    }
                    panelOptions.add(panel7, BorderLayout.SOUTH);

                    //======== panel4 ========
                    {
                        panel4.setLayout(new HorizontalLayout());

                        //---- buttonClear ----
                        buttonClear.setText("Limpar");
                        buttonClear.addActionListener(e -> clear(e));
                        panel4.add(buttonClear);

                        //---- buttonSeach ----
                        buttonSeach.setText("Consultar");
                        buttonSeach.addActionListener(e -> {
			seach(e);
			search(e);
		});
                        panel4.add(buttonSeach);
                    }
                    panelOptions.add(panel4, BorderLayout.EAST);
                }
                panel2.add(panelOptions, BorderLayout.SOUTH);
            }
            tabbedPane1.addTab("Lista", panel2);
        }
        add(tabbedPane1);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner non-commercial license
    private JTabbedPane tabbedPane1;
    private JPanel panel2;
    private JPanel panel1;
    private JScrollPane scrollPane1;
    private JTable table;
    private JPanel panelOptions;
    private JPanel panel7;
    private JPanel panel6;
    private JLabel label2;
    private JTextField textFieldDocument;
    private JPanel panel5;
    private JLabel label1;
    private JTextField textFieldName;
    private JPanel panel4;
    private JButton buttonClear;
    private JButton buttonSeach;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
