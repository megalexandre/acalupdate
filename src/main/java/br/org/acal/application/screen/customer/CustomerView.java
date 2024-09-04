
package br.org.acal.application.screen.customer;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

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

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner non-commercial license
        tabbedPane1 = new JTabbedPane();
        panel2 = new JPanel();
        panel1 = new JPanel();
        scrollPane1 = new JScrollPane();
        table = new JTable();
        panel3 = new JPanel();
        label1 = new JLabel();
        textField1 = new JTextField();
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

                //======== panel3 ========
                {
                    panel3.setBorder(new EmptyBorder(5, 5, 5, 5));
                    panel3.setLayout(new HorizontalLayout());

                    //---- label1 ----
                    label1.setText("Name:");
                    panel3.add(label1);
                    panel3.add(textField1);

                    //---- buttonSeach ----
                    buttonSeach.setText("Consultar");
                    buttonSeach.addActionListener(e -> {
			seach(e);
			search(e);
		});
                    panel3.add(buttonSeach);
                }
                panel2.add(panel3, BorderLayout.SOUTH);
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
    private JPanel panel3;
    private JLabel label1;
    private JTextField textField1;
    private JButton buttonSeach;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
