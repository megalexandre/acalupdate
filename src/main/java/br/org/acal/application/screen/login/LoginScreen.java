package br.org.acal.application.screen.login;

import javax.swing.*;
import br.org.acal.application.screen.main.MainScreen;
import br.org.acal.application.telas.TelaPrincipal;
import org.jdesktop.swingx.VerticalLayout;
import org.springframework.stereotype.Component;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
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
import java.util.Objects;

@Component
public class LoginScreen extends JFrame {
    private final MainScreen mainScreen;

    public LoginScreen(MainScreen mainScreen) {
        initComponents();

        try{
            ImageIcon icon = new ImageIcon(Objects.requireNonNull(
                this.getClass().getResource("/images/logo.png"))
            );
            setIconImage(icon.getImage());

        }catch (Exception ignored){}

        setContentPane(root);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(200, 180);
        setLocationRelativeTo(null);
        this.mainScreen = mainScreen;
        this.jButtonTelaLoginLogar.setPreferredSize(new Dimension(jButtonTelaLoginLogar.getWidth(),30));
    }

    private void start(){

        String log = name.getText();
        String pass = new String(password.getPassword());

        if("root".equals(log) && "123".equals(pass)){
            mainScreen.setVisible(true);
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

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner non-commercial license
        root = new JPanel();
        panel7 = new JPanel();
        panel8 = new JPanel();
        jLabel1 = new JLabel();
        name = new JTextField();
        jLabel4 = new JLabel();
        password = new JPasswordField();
        separator1 = new JSeparator();
        jButtonTelaLoginLogar = new JButton();

        //======== root ========
        {
            root.setBorder(new EmptyBorder(5, 5, 5, 5));
            root.setLayout(new VerticalLayout());

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
                    name.addActionListener(e -> jTextFieldTelaLoginNomeActionPerformed(e));
                    panel8.add(name);

                    //---- jLabel4 ----
                    jLabel4.setText("Senha");
                    jLabel4.setHorizontalAlignment(SwingConstants.LEFT);
                    panel8.add(jLabel4);

                    //---- password ----
                    password.setText("123");
                    password.addActionListener(e -> jPasswordFieldTelaPrincipalSenhaActionPerformed(e));
                    panel8.add(password);
                    panel8.add(separator1);

                    //---- jButtonTelaLoginLogar ----
                    jButtonTelaLoginLogar.setText("Logar");
                    jButtonTelaLoginLogar.setMinimumSize(new Dimension(180, 30));
                    jButtonTelaLoginLogar.setPreferredSize(new Dimension(180, 22));
                    jButtonTelaLoginLogar.addActionListener(e -> jButtonTelaLoginLogarActionPerformed(e));
                    panel8.add(jButtonTelaLoginLogar);
                }
                panel7.add(panel8);
            }
            root.add(panel7);
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
    private JLabel jLabel4;
    private JPasswordField password;
    private JSeparator separator1;
    private JButton jButtonTelaLoginLogar;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
