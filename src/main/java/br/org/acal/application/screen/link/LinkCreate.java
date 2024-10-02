package br.org.acal.application.screen.link;

import org.jdesktop.swingx.VerticalLayout;

import javax.swing.*;

public class LinkCreate extends JPanel {
    public LinkCreate() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner non-commercial license
        label1 = new JLabel();
        comboBox1 = new JComboBox();
        label2 = new JLabel();
        comboBox2 = new JComboBox();
        label3 = new JLabel();
        textField1 = new JTextField();

        //======== this ========
        setLayout(new VerticalLayout());

        //---- label1 ----
        label1.setText("S\u00f3cio:");
        add(label1);
        add(comboBox1);

        //---- label2 ----
        label2.setText("Endere\u00e7o:");
        add(label2);
        add(comboBox2);

        //---- label3 ----
        label3.setText("Grupo:");
        add(label3);
        add(textField1);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner non-commercial license
    private JLabel label1;
    private JComboBox comboBox1;
    private JLabel label2;
    private JComboBox comboBox2;
    private JLabel label3;
    private JTextField textField1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
