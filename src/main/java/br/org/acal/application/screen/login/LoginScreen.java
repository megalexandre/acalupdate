package br.org.acal.application.screen.login;

import br.org.acal.application.screen.main.MainScreen;
import org.jdesktop.swingx.VerticalLayout;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
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
        panel1 = new JPanel();
        jLabel1 = new JLabel();
        name = new JTextField();
        panel2 = new JPanel();
        jLabel4 = new JLabel();
        password = new JPasswordField();
        panel3 = new JPanel();
        separator1 = new JSeparator();
        jButtonTelaLoginLogar = new JButton();

        //======== root ========
        {
            root.setBorder(new EmptyBorder(5, 5, 5, 5));
            root.setPreferredSize(new Dimension(190, 0));
            root.setLayout(new BorderLayout());

            //======== panel1 ========
            {
                panel1.setLayout(new VerticalLayout());

                //---- jLabel1 ----
                jLabel1.setText("Nome");
                jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
                panel1.add(jLabel1);

                //---- name ----
                name.setText("root");
                name.addActionListener(e -> jTextFieldTelaLoginNomeActionPerformed(e));
                panel1.add(name);
            }
            root.add(panel1, BorderLayout.NORTH);

            //======== panel2 ========
            {
                panel2.setLayout(new VerticalLayout());

                //---- jLabel4 ----
                jLabel4.setText("Senha");
                jLabel4.setHorizontalAlignment(SwingConstants.CENTER);
                panel2.add(jLabel4);

                //---- password ----
                password.setText("123");
                password.addActionListener(e -> jPasswordFieldTelaPrincipalSenhaActionPerformed(e));
                panel2.add(password);
            }
            root.add(panel2, BorderLayout.CENTER);

            //======== panel3 ========
            {
                panel3.setLayout(new VerticalLayout());
                panel3.add(separator1);

                //---- jButtonTelaLoginLogar ----
                jButtonTelaLoginLogar.setText("Logar");
                jButtonTelaLoginLogar.setMinimumSize(new Dimension(180, 30));
                jButtonTelaLoginLogar.setPreferredSize(new Dimension(180, 22));
                jButtonTelaLoginLogar.addActionListener(e -> jButtonTelaLoginLogarActionPerformed(e));
                panel3.add(jButtonTelaLoginLogar);
            }
            root.add(panel3, BorderLayout.SOUTH);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner non-commercial license
    private JPanel root;
    private JPanel panel1;
    private JLabel jLabel1;
    private JTextField name;
    private JPanel panel2;
    private JLabel jLabel4;
    private JPasswordField password;
    private JPanel panel3;
    private JSeparator separator1;
    private JButton jButtonTelaLoginLogar;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
