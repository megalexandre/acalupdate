
package br.org.acal.application.screen.invoice;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import br.org.acal.application.screen.customer.CustomerTable;
import br.org.acal.application.screen.customer.CustomerTableModel;
import br.org.acal.application.screen.render.StrippedTableCellRenderer;
import br.org.acal.domain.usecase.invoice.FindInvoice;
import lombok.val;
import org.springframework.stereotype.Component;

@Component
public class InvoiceView extends JPanel {

    private final FindInvoice find;
    public InvoiceView(
        FindInvoice find
    ) {
        initComponents();
        this.find = find;
    }

    private void search(ActionEvent e) {
        val invoices = find.execute(null);
        val tableModel = new InvoiceTableModel(invoices.stream().map(InvoiceTable::of).toList());
        table.setModel(tableModel);
        table.setDefaultRenderer(String.class, new StrippedTableCellRenderer());
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner non-commercial license
        tabbedPane1 = new JTabbedPane();
        panel1 = new JPanel();
        scrollPane1 = new JScrollPane();
        table = new JTable();
        panel2 = new JPanel();
        buttonSearch = new JButton();

        //======== this ========
        setLayout(new BorderLayout());

        //======== tabbedPane1 ========
        {

            //======== panel1 ========
            {
                panel1.setLayout(new BorderLayout());

                //======== scrollPane1 ========
                {
                    scrollPane1.setViewportView(table);
                }
                panel1.add(scrollPane1, BorderLayout.CENTER);

                //======== panel2 ========
                {
                    panel2.setLayout(new FlowLayout());

                    //---- buttonSearch ----
                    buttonSearch.setText("Consultar");
                    buttonSearch.addActionListener(e -> search(e));
                    panel2.add(buttonSearch);
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
    private JScrollPane scrollPane1;
    private JTable table;
    private JPanel panel2;
    private JButton buttonSearch;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
