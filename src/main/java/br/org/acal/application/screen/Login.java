package br.org.acal.application.screen;

import org.jdesktop.swingx.HorizontalLayout;
import org.jdesktop.swingx.VerticalLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.BorderLayout;

public class Login extends JPanel  {

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner non-commercial license
        panel1 = new JPanel();
        label1 = new JLabel();
        textField1 = new JTextField();
        panel2 = new JPanel();
        label2 = new JLabel();
        passwordField1 = new JPasswordField();
        panel3 = new JPanel();
        button1 = new JButton();

        //======== this ========
        setLayout(new BorderLayout());

        //======== panel1 ========
        {
            panel1.setLayout(new VerticalLayout());

            //---- label1 ----
            label1.setText("Senha:");
            panel1.add(label1);
            panel1.add(textField1);
        }
        add(panel1, BorderLayout.CENTER);

        //======== panel2 ========
        {
            panel2.setLayout(new VerticalLayout());

            //---- label2 ----
            label2.setText("Nome:");
            panel2.add(label2);
            panel2.add(passwordField1);
        }
        add(panel2, BorderLayout.NORTH);

        //======== panel3 ========
        {
            panel3.setLayout(new HorizontalLayout());

            //---- button1 ----
            button1.setText("Login");
            panel3.add(button1);
        }
        add(panel3, BorderLayout.SOUTH);
		// JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner non-commercial license
    private JPanel panel1;
    private JLabel label1;
    private JTextField textField1;
    private JPanel panel2;
    private JLabel label2;
    private JPasswordField passwordField1;
    private JPanel panel3;
    private JButton button1;
	// JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
