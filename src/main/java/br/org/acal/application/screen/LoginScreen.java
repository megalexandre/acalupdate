package br.org.acal.application.screen;

import br.org.acal.application.telas.TelaPrincipal;
import org.jdesktop.swingx.VerticalLayout;
import org.springframework.stereotype.Component;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

@Component
public class LoginScreen extends JFrame {
    private final TelaPrincipal telaPrincipal;
    private final MainScreen mainScreen;

    public LoginScreen(TelaPrincipal telaPrincipal, MainScreen mainScreen) {
        initComponents();
        setContentPane(root);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(220, 180);
        setLocationRelativeTo(null);
        this.telaPrincipal = telaPrincipal;
        this.mainScreen = mainScreen;
    }

    private void start(){

        String log = name.getText();
        String pass = new String(password.getPassword());

        if("root".equals(log) && "123".equals(pass)){
            mainScreen.setVisible(true);
            telaPrincipal.setVisible(true);
            dispose();
        } else {
            name.setText("");
            name.setFocusable(true);
            name.requestFocus();

            password.setText("");
            JOptionPane.showMessageDialog(this, "Verifique o nome do usuário e a senha", "Login", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void jTextFieldTelaLoginNomeActionPerformed(ActionEvent e) {
        start();
    }

    private void jPasswordFieldTelaPrincipalSenhaActionPerformed(ActionEvent e) {
        start();
    }

    private void jButtonTelaLoginLogarActionPerformed(ActionEvent e) {
        start();
    }

    private void createUIComponents() {

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner non-commercial license
        root = new JPanel();
        panel7 = new JPanel();
        panel8 = new JPanel();
        jLabel1 = new JLabel();
        name = new JTextField();
        panel9 = new JPanel();
        jLabel4 = new JLabel();
        password = new JPasswordField();
        panel6 = new JPanel();
        jButtonTelaLoginLogar = new JButton();

        //======== root ========
        {
            root.setBorder(new EmptyBorder(5, 5, 5, 5));
            root.setLayout(new BorderLayout());

            //======== panel7 ========
            {
                panel7.setToolTipText("Login:");
                panel7.setLayout(new BoxLayout(panel7, BoxLayout.Y_AXIS));

                //======== panel8 ========
                {
                    panel8.setLayout(new VerticalLayout());

                    //---- jLabel1 ----
                    jLabel1.setText("Nome");
                    panel8.add(jLabel1);

                    //---- name ----
                    name.setText("root");
                    name.addActionListener(this::jTextFieldTelaLoginNomeActionPerformed);
                    panel8.add(name);
                }
                panel7.add(panel8);

                //======== panel9 ========
                {
                    panel9.setLayout(new VerticalLayout());

                    //---- jLabel4 ----
                    jLabel4.setText("Senha");
                    jLabel4.setHorizontalAlignment(SwingConstants.LEFT);
                    panel9.add(jLabel4);

                    //---- password ----
                    password.setText("123");
                    password.addActionListener(this::jPasswordFieldTelaPrincipalSenhaActionPerformed);
                    panel9.add(password);
                }
                panel7.add(panel9);
            }
            root.add(panel7, BorderLayout.NORTH);

            //======== panel6 ========
            {
                panel6.setLayout(new BorderLayout());

                //---- jButtonTelaLoginLogar ----
                jButtonTelaLoginLogar.setText("Logar");
                jButtonTelaLoginLogar.setMinimumSize(new Dimension(180, 22));
                jButtonTelaLoginLogar.setPreferredSize(new Dimension(180, 22));
                jButtonTelaLoginLogar.addActionListener(this::jButtonTelaLoginLogarActionPerformed);
                panel6.add(jButtonTelaLoginLogar, BorderLayout.CENTER);
            }
            root.add(panel6, BorderLayout.SOUTH);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner non-commercial license
    private JPanel root;
    private JPanel panel7;
    private JPanel panel8;
    private JLabel jLabel1;
    private JTextField name;
    private JPanel panel9;
    private JLabel jLabel4;
    private JPasswordField password;
    private JPanel panel6;
    private JButton jButtonTelaLoginLogar;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
