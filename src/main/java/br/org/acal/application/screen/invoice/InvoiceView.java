
package br.org.acal.application.screen.invoice;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import br.org.acal.application.screen.render.StrippedTableCellRenderer;
import br.org.acal.domain.model.InvoicePaginate;
import br.org.acal.domain.usecase.invoice.InvoicePaginateUseCase;
import lombok.val;
import org.jdesktop.swingx.*;
import org.springframework.stereotype.Component;

import static java.util.stream.IntStream.range;

@Component
public class InvoiceView extends JPanel {
    private final InvoicePaginateUseCase paginate;

    public InvoiceView(
        InvoicePaginateUseCase paginate
    ) {
        initComponents();
        this.paginate = paginate;
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

        val render = new StrippedTableCellRenderer();
        table.setDefaultRenderer(String.class, render);
        range(0, table.getColumnCount()).forEach(i ->
                table.getColumnModel().getColumn(i).setCellRenderer(render)
        );
    }

    private InvoicePaginate createFilter(){
        return InvoicePaginate.builder().build();
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
        comboBox1 = new JComboBox();
        panel7 = new JPanel();
        label3 = new JLabel();
        comboBox2 = new JComboBox();
        panel8 = new JPanel();
        label4 = new JLabel();
        comboBox3 = new JComboBox();
        panel9 = new JPanel();
        label5 = new JLabel();
        comboBox4 = new JComboBox();
        panel10 = new JPanel();
        label6 = new JLabel();
        panel11 = new JPanel();
        comboBoxPeriodYear = new JComboBox();
        formattedTextFieldPeriodMonth = new JFormattedTextField();
        panel5 = new JPanel();
        buttonClear = new JButton();
        buttonSearch = new JButton();

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

                            //---- comboBox1 ----
                            comboBox1.setPreferredSize(new Dimension(150, 26));
                            comboBox1.setMinimumSize(new Dimension(150, 26));
                            panel6.add(comboBox1);
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

                            //---- comboBox2 ----
                            comboBox2.setMinimumSize(new Dimension(150, 26));
                            comboBox2.setPreferredSize(new Dimension(150, 26));
                            panel7.add(comboBox2);
                        }
                        panel4.add(panel7);

                        //======== panel8 ========
                        {
                            panel8.setLayout(new VerticalLayout());

                            //---- label4 ----
                            label4.setText("S\u00f3cio:");
                            panel8.add(label4);

                            //---- comboBox3 ----
                            comboBox3.setPreferredSize(new Dimension(150, 26));
                            comboBox3.setMinimumSize(new Dimension(150, 26));
                            panel8.add(comboBox3);
                        }
                        panel4.add(panel8);

                        //======== panel9 ========
                        {
                            panel9.setLayout(new VerticalLayout());

                            //---- label5 ----
                            label5.setText("Status:");
                            panel9.add(label5);

                            //---- comboBox4 ----
                            comboBox4.setMinimumSize(new Dimension(150, 26));
                            comboBox4.setPreferredSize(new Dimension(150, 26));
                            panel9.add(comboBox4);
                        }
                        panel4.add(panel9);

                        //======== panel10 ========
                        {
                            panel10.setMinimumSize(new Dimension(200, 42));
                            panel10.setPreferredSize(new Dimension(200, 42));
                            panel10.setLayout(new VerticalLayout());

                            //---- label6 ----
                            label6.setText("Periodo:");
                            panel10.add(label6);

                            //======== panel11 ========
                            {
                                panel11.setPreferredSize(new Dimension(250, 26));
                                panel11.setMinimumSize(new Dimension(250, 26));
                                panel11.setLayout(new HorizontalLayout());

                                //---- comboBoxPeriodYear ----
                                comboBoxPeriodYear.setMinimumSize(new Dimension(100, 26));
                                comboBoxPeriodYear.setPreferredSize(new Dimension(100, 26));
                                panel11.add(comboBoxPeriodYear);

                                //---- formattedTextFieldPeriodMonth ----
                                formattedTextFieldPeriodMonth.setMinimumSize(new Dimension(100, 26));
                                formattedTextFieldPeriodMonth.setPreferredSize(new Dimension(100, 26));
                                panel11.add(formattedTextFieldPeriodMonth);
                            }
                            panel10.add(panel11);
                        }
                        panel4.add(panel10);
                    }
                    panel2.add(panel4, BorderLayout.NORTH);

                    //======== panel5 ========
                    {
                        panel5.setLayout(new FlowLayout(FlowLayout.RIGHT));

                        //---- buttonClear ----
                        buttonClear.setText("Limpar");
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
    private JComboBox comboBox1;
    private JPanel panel7;
    private JLabel label3;
    private JComboBox comboBox2;
    private JPanel panel8;
    private JLabel label4;
    private JComboBox comboBox3;
    private JPanel panel9;
    private JLabel label5;
    private JComboBox comboBox4;
    private JPanel panel10;
    private JLabel label6;
    private JPanel panel11;
    private JComboBox comboBoxPeriodYear;
    private JFormattedTextField formattedTextFieldPeriodMonth;
    private JPanel panel5;
    private JButton buttonClear;
    private JButton buttonSearch;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
