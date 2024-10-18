package br.org.acal.application.screen.water.hydrometer;

import java.awt.*;
import javax.swing.*;
import org.jdesktop.swingx.*;
import org.springframework.stereotype.Component;

@Component
public class HydrometerView extends JPanel {

    public HydrometerView() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner non-commercial license
        panel3 = new JPanel();
        label1 = new JLabel();
        panel1 = new JPanel();
        panel4 = new JPanel();
        panel5 = new JPanel();
        formattedTextFieldPeriod = new JFormattedTextField();
        buttonCreate = new JButton();
        panel2 = new JPanel();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();

        //======== this ========
        setLayout(new BorderLayout());

        //======== panel3 ========
        {
            panel3.setLayout(new VerticalLayout());

            //---- label1 ----
            label1.setText("Hidrometros");
            panel3.add(label1);
        }
        add(panel3, BorderLayout.NORTH);

        //======== panel1 ========
        {
            panel1.setLayout(new BorderLayout());

            //======== panel4 ========
            {
                panel4.setLayout(new BorderLayout());

                //======== panel5 ========
                {
                    panel5.setLayout(new HorizontalLayout());

                    //---- formattedTextFieldPeriod ----
                    formattedTextFieldPeriod.setPreferredSize(new Dimension(100, 34));
                    panel5.add(formattedTextFieldPeriod);

                    //---- buttonCreate ----
                    buttonCreate.setText("Consultar");
                    panel5.add(buttonCreate);
                }
                panel4.add(panel5, BorderLayout.EAST);
            }
            panel1.add(panel4, BorderLayout.NORTH);
        }
        add(panel1, BorderLayout.SOUTH);

        //======== panel2 ========
        {
            panel2.setLayout(new BorderLayout());

            //======== scrollPane1 ========
            {
                scrollPane1.setViewportView(table1);
            }
            panel2.add(scrollPane1, BorderLayout.CENTER);
        }
        add(panel2, BorderLayout.CENTER);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner non-commercial license
    private JPanel panel3;
    private JLabel label1;
    private JPanel panel1;
    private JPanel panel4;
    private JPanel panel5;
    private JFormattedTextField formattedTextFieldPeriod;
    private JButton buttonCreate;
    private JPanel panel2;
    private JScrollPane scrollPane1;
    private JTable table1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
