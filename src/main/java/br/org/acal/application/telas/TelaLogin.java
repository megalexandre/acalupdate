package br.org.acal.application.telas;

import com.formdev.flatlaf.FlatLightLaf;


import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import java.util.Objects;

public class TelaLogin extends JFrame {

    public TelaLogin() {
        initComponents();
        setLocationRelativeTo(null);
    }
    private void initComponents() {

        JPanel jPanel1 = new JPanel();
        JLabel jLabel1 = new JLabel();
        JLabel jLabel2 = new JLabel();
        jTextFieldTelaLoginNome = new JTextField();
        JButton jButtonTelaLoginLogar = new JButton();
        jPasswordFieldTelaPrincipalSenha = new JPasswordField();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("/img/ico.png"))).getImage());
        setResizable(false);

        jPanel1.setBorder(BorderFactory.createTitledBorder("Seja bem vindo"));

        jLabel1.setText("Nome");

        jLabel2.setText("Senha");

        jTextFieldTelaLoginNome.setText("root");
        jTextFieldTelaLoginNome.addActionListener(this::jTextFieldTelaLoginNomeActionPerformed);

        jButtonTelaLoginLogar.setText("Logar");
        jButtonTelaLoginLogar.addActionListener(this::jButtonTelaLoginLogarActionPerformed);

        jPasswordFieldTelaPrincipalSenha.setText("123");
        jPasswordFieldTelaPrincipalSenha.addActionListener(this::jPasswordFieldTelaPrincipalSenhaActionPerformed);

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonTelaLoginLogar, GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldTelaLoginNome, GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                    .addComponent(jPasswordFieldTelaPrincipalSenha))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldTelaLoginNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jPasswordFieldTelaPrincipalSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jButtonTelaLoginLogar)
                .addContainerGap())
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    private void jButtonTelaLoginLogarActionPerformed(java.awt.event.ActionEvent evt) {
        comecar();
    }

    private void jPasswordFieldTelaPrincipalSenhaActionPerformed(java.awt.event.ActionEvent evt) {
        comecar();
    }

    private void jTextFieldTelaLoginNomeActionPerformed(java.awt.event.ActionEvent evt) {
        comecar();
    }
    private void comecar(){

        String log = jTextFieldTelaLoginNome.getText();
        String pass = new String(jPasswordFieldTelaPrincipalSenha.getPassword());

        if("root".equals(log) && "123".equals(pass)){
            new TelaPrincipal().setVisible(true);
            dispose();
        } else {
            jTextFieldTelaLoginNome.setText("");
            jPasswordFieldTelaPrincipalSenha.setText("");
            jTextFieldTelaLoginNome.setFocusable(true);
            jTextFieldTelaLoginNome.requestFocus();
            JOptionPane.showMessageDialog(this, "Verifique o nome do usuário e a senha", "Login", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            FlatLightLaf.setup();
            SwingUtilities.invokeLater(() -> {
                new TelaLogin().setVisible(true);
            });
        });
    }

    private JPasswordField jPasswordFieldTelaPrincipalSenha;
    private JTextField jTextFieldTelaLoginNome;
}
