package br.org.acal.application.telas;

import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.util.Objects;

public class TelaLogin extends javax.swing.JFrame {

    public TelaLogin() {
        initComponents();
        setLocationRelativeTo(null);
    }
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldTelaLoginNome = new javax.swing.JTextField();
        jButtonTelaLoginLogar = new javax.swing.JButton();
        jPasswordFieldTelaPrincipalSenha = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("/img/ico.png"))).getImage());
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Seja bem vindo"));

        jLabel1.setText("Nome");

        jLabel2.setText("Senha");

        jTextFieldTelaLoginNome.setText("root");
        jTextFieldTelaLoginNome.addActionListener(this::jTextFieldTelaLoginNomeActionPerformed);

        jButtonTelaLoginLogar.setText("Logar");
        jButtonTelaLoginLogar.addActionListener(this::jButtonTelaLoginLogarActionPerformed);

        jPasswordFieldTelaPrincipalSenha.setText("123");
        jPasswordFieldTelaPrincipalSenha.addActionListener(this::jPasswordFieldTelaPrincipalSenhaActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonTelaLoginLogar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldTelaLoginNome, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                    .addComponent(jPasswordFieldTelaPrincipalSenha))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldTelaLoginNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jPasswordFieldTelaPrincipalSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jButtonTelaLoginLogar)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            javax.swing.SwingUtilities.invokeLater(() -> {
                new TelaLogin().setVisible(true);
            });
        });

    }
    private javax.swing.JButton jButtonTelaLoginLogar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordFieldTelaPrincipalSenha;
    private javax.swing.JTextField jTextFieldTelaLoginNome;
}
