package br.org.acal.application.telas;

import br.org.acal.application.TableModel.CaixaCompletoTableModel;
import br.org.acal.resouces.dao.view.DaoCaixaView;
import br.org.acal.resouces.dao.view.DaoEnderecoView;
import br.org.acal.resouces.dao.view.DaoSocioView;
import br.org.acal.resouces.entidades.EnderecoView;
import br.org.acal.resouces.entidades.SociosView;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class ContasEditor extends javax.swing.JFrame {

    private CaixaCompletoTableModel pModel;
   
    private final int aberta = 1;
    private final int paga   = 2;
    private final int vencida= 3;
   
    private final int _socio      = 1;
    private final int _logradouro = 2;
    private final int _status     = 4;
    
    private final int checkSocio              =1;
    private final int checkLogradouro         =2;
    private final int checkStatus             =4;
    private final int checkSocio_logradouro   =3;
    private final int checkSocio_status       =5;
    private final int checkLogradouro_status  =6;
    private final int check_todas             =7;
   
    public ContasEditor() {
        initComponents();
        jComboBoxSocio.setEnabled(false);
        jComboBoxLogradouro.setEnabled(false);
        jComboBoxStatus.setEnabled(false);
        getTableModel();
    }

    
    private void adicionarEventosTela(final JTable table ) {
    
     table.addMouseListener(new MouseListener() {
     @Override
     public void mouseClicked(MouseEvent e) 
     { 
        if (e.getClickCount() == 2){  
        
        }
     }
     @Override
     public void mousePressed(MouseEvent e) {}
     @Override
     public void mouseReleased(MouseEvent e){}
     @Override
     public void mouseEntered(MouseEvent e) {}
     @Override
     public void mouseExited(MouseEvent e)  {}
     
     
     });
    }         
    
    private void getTableModel(){
            pModel = new CaixaCompletoTableModel();
            jTableEditarConta.setModel(pModel);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jButtonBuscar = new javax.swing.JButton();
        jButtonExportar = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jCheckSocio = new javax.swing.JCheckBox();
        jCheckLogradouro = new javax.swing.JCheckBox();
        jCheckStatus = new javax.swing.JCheckBox();
        jComboBoxSocio = new javax.swing.JComboBox();
        jComboBoxLogradouro = new javax.swing.JComboBox();
        jComboBoxStatus = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableEditarConta = new JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButtonBuscar.setText("Buscar");
        jButtonBuscar.setPreferredSize(new java.awt.Dimension(100, 23));
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        jButtonExportar.setText("Salvar Alteraçãoes");
        jButtonExportar.setPreferredSize(new java.awt.Dimension(100, 23));
        jButtonExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExportarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonExportar, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                    .addComponent(jButtonBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(6, 6, 6))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jButtonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonExportar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jCheckSocio.setText("Socio");
        jCheckSocio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckSocioActionPerformed(evt);
            }
        });

        jCheckLogradouro.setText("Logradouro");
        jCheckLogradouro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckLogradouroActionPerformed(evt);
            }
        });

        jCheckStatus.setText("Status");
        jCheckStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckStatusActionPerformed(evt);
            }
        });

        jComboBoxSocio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { }));

        jComboBoxLogradouro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxLogradouroActionPerformed(evt);
            }
        });

        jComboBoxStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Aberta", "Paga", "Vencida" }));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckLogradouro)
                    .addComponent(jCheckStatus)
                    .addComponent(jCheckSocio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxSocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(485, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckSocio)
                    .addComponent(jComboBoxSocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckLogradouro))
                .addGap(5, 5, 5)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckStatus)
                    .addComponent(jComboBoxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 917, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 106, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTableEditarConta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTableEditarConta);

        jLabel1.setText("Modulo Editor");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jLabel1)
                .addGap(2, 2, 2))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 917, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed

        pModel.limpar();
        jTableEditarConta.removeAll();
        
        if(jCheckLogradouro.isSelected() || jCheckSocio.isSelected() || jCheckStatus.isSelected()){
            int ativos = 0;
            
            if(jCheckSocio.isSelected())      {ativos += _socio;}
            if(jCheckLogradouro.isSelected()) {ativos += _logradouro;}
            if(jCheckStatus.isSelected())     {ativos += _status;}
            
            switch(ativos){
                
            case(checkSocio):
                if(jComboBoxSocio.getSelectedIndex()==0){
                 JOptionPane.showMessageDialog(null, "Escolha um Socio"); jComboBoxSocio.requestFocus();
                }
                else{
                pModel.addListaDeConta(new DaoCaixaView().BuscarSocioNome(jComboBoxSocio.getSelectedItem().toString()));
                }
                break;
            case(checkLogradouro):
                if(jComboBoxLogradouro.getSelectedIndex()==0){
                 JOptionPane.showMessageDialog(null, "Escolha um endereco"); jComboBoxLogradouro.requestFocus();
                }
                else{
                pModel.addListaDeConta(new DaoCaixaView().BuscarLogradouro(jComboBoxLogradouro.getSelectedItem().toString()));
                }
                break;
            case(checkStatus):
                if  (jComboBoxStatus.getSelectedIndex()==0){
                    JOptionPane.showMessageDialog(null, "É preciso escolher a opção de status");
                    jComboBoxStatus.requestFocus();
                }
                else if (jComboBoxStatus.getSelectedIndex()==1){
                    pModel.addListaDeConta(new DaoCaixaView().BuscarStatus(aberta));
                }
                else if (jComboBoxStatus.getSelectedIndex()==2){
                    pModel.addListaDeConta(new DaoCaixaView().BuscarStatus(paga));
                }
                else if (jComboBoxStatus.getSelectedIndex()==3){
                    pModel.addListaDeConta(new DaoCaixaView().BuscarStatus(vencida));
                }
                break;
            case(checkSocio_logradouro):
                if(jComboBoxLogradouro.getSelectedIndex()==0){
                   JOptionPane.showMessageDialog(null, "Escolha um endereco");
                   jComboBoxLogradouro.requestFocus();
                }
                if(jComboBoxSocio.getSelectedIndex()==0){
                   JOptionPane.showMessageDialog(null, "Escolha um Socio");
                   jComboBoxSocio.requestFocus();
                }
                else{
                   pModel.addListaDeConta(new DaoCaixaView().BuscarSocioLogradouro(jComboBoxLogradouro.getSelectedItem().toString(),jComboBoxSocio.getSelectedItem().toString()));
                   
                }
                break;
            case(checkSocio_status):
                
                if(jComboBoxStatus.getSelectedIndex()==0){
                   JOptionPane.showMessageDialog(null, "Escolha um Status");
                   jComboBoxStatus.requestFocus();
                }
                if(jComboBoxSocio.getSelectedIndex()==0){
                   JOptionPane.showMessageDialog(null, "Escolha um Socio");
                   jComboBoxSocio.requestFocus();
                }
                else{
                    if     (jComboBoxStatus.getSelectedIndex()==0){
                        JOptionPane.showMessageDialog(null,"Escolha um Status");
                        jComboBoxStatus.requestFocus();
                    }
                    else if(jComboBoxStatus.getSelectedIndex()==1){
                        pModel.addListaDeConta(new DaoCaixaView().BuscarSocioStatus(aberta, jComboBoxSocio.getSelectedItem().toString()));
                    }
                    else if(jComboBoxStatus.getSelectedIndex()==2){
                         pModel.addListaDeConta(new DaoCaixaView().BuscarSocioStatus(paga, jComboBoxSocio.getSelectedItem().toString()));
                    }
                    else if(jComboBoxStatus.getSelectedIndex()==3){
                         pModel.addListaDeConta(new DaoCaixaView().BuscarSocioStatus(vencida, jComboBoxSocio.getSelectedItem().toString()));
                    }
                    
                }
                break;
            case(checkLogradouro_status):
                
                if(jComboBoxLogradouro.getSelectedIndex()==0){
                   JOptionPane.showMessageDialog(null, "Escolha um Endereco");
                   jComboBoxLogradouro.requestFocus();
                }
                else{
                    if     (jComboBoxStatus.getSelectedIndex()==0){
                        JOptionPane.showMessageDialog(null,"Escolha um Status");
                        jComboBoxStatus.requestFocus();
                    }
                    else if(jComboBoxStatus.getSelectedIndex()==1){
                        pModel.addListaDeConta(new DaoCaixaView().BuscarLogradouroStatus(aberta, jComboBoxLogradouro.getSelectedItem().toString()));
                    }
                    else if(jComboBoxStatus.getSelectedIndex()==2){
                        pModel.addListaDeConta(new DaoCaixaView().BuscarLogradouroStatus(paga, jComboBoxLogradouro.getSelectedItem().toString()));
                    }
                    else if(jComboBoxStatus.getSelectedIndex()==3){
                        pModel.addListaDeConta(new DaoCaixaView().BuscarLogradouroStatus(vencida, jComboBoxLogradouro.getSelectedItem().toString()));
                    }
                }
                break;
            case(check_todas):
                if(jComboBoxStatus.getSelectedIndex()==0){
                   JOptionPane.showMessageDialog(null, "Escolha um Status");
                   jComboBoxStatus.requestFocus();
                }
                if(jComboBoxSocio.getSelectedIndex()==0){
                   JOptionPane.showMessageDialog(null, "Escolha um Socio");
                   jComboBoxSocio.requestFocus();
                }
                if(jComboBoxLogradouro.getSelectedIndex()==0){
                    JOptionPane.showMessageDialog(null, "Escolha uma Endereco");
                    jComboBoxLogradouro.requestFocus();
                }
                else{
                
                    if(jComboBoxStatus.getSelectedIndex()==1){
                        pModel.addListaDeConta(new DaoCaixaView().BuscarTodosCriterios(aberta, jComboBoxSocio.getSelectedItem().toString(), jComboBoxLogradouro.getSelectedItem().toString()));
                    }
                    else if(jComboBoxStatus.getSelectedIndex()==2){
                        pModel.addListaDeConta(new DaoCaixaView().BuscarTodosCriterios(paga, jComboBoxSocio.getSelectedItem().toString(), jComboBoxLogradouro.getSelectedItem().toString()));
                    }
                    else if(jComboBoxStatus.getSelectedIndex()==3){
                        pModel.addListaDeConta(new DaoCaixaView().BuscarTodosCriterios(vencida, jComboBoxSocio.getSelectedItem().toString(), jComboBoxLogradouro.getSelectedItem().toString()));              
                    }
                }
                break;
            }
        }
        else{
        JOptionPane.showMessageDialog(null, "Escolha uma opção de busca.");
        }
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jButtonExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExportarActionPerformed

    }//GEN-LAST:event_jButtonExportarActionPerformed

    private void jCheckSocioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckSocioActionPerformed
        
        if(jComboBoxSocio.getItemCount() == 0){
            jComboBoxSocio.addItem("");
            List<SociosView> socios= new DaoSocioView().BuscarTodosSociosView();
            for(SociosView s : socios){
                jComboBoxSocio.addItem(s.getNome());
            }
            jComboBoxSocio.setEnabled(true);
        } 
        else{
        jComboBoxSocio.setSelectedIndex(0);
        jComboBoxSocio.setEnabled(false);
        }

    }//GEN-LAST:event_jCheckSocioActionPerformed

    private void jCheckLogradouroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckLogradouroActionPerformed

        if(jComboBoxLogradouro.getItemCount() == 0){
            jComboBoxLogradouro.addItem("");
            List<EnderecoView> enderecos= new DaoEnderecoView().BuscarTodosEnderecos();
            for(EnderecoView s : enderecos){
                jComboBoxLogradouro.addItem(s.getNome());
            }          
            jComboBoxLogradouro.setEnabled(true);
        }
        else{
            
            jComboBoxLogradouro.setSelectedIndex(0);
            jComboBoxLogradouro.setEnabled(false);
        }
       
    }//GEN-LAST:event_jCheckLogradouroActionPerformed

    private void jCheckStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckStatusActionPerformed
        jComboBoxStatus.setEnabled(jCheckStatus.isSelected());
        
    }//GEN-LAST:event_jCheckStatusActionPerformed

    private void jComboBoxLogradouroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxLogradouroActionPerformed
      
    }//GEN-LAST:event_jComboBoxLogradouroActionPerformed
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ContasEditor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonExportar;
    private javax.swing.JCheckBox jCheckLogradouro;
    private javax.swing.JCheckBox jCheckSocio;
    private javax.swing.JCheckBox jCheckStatus;
    private javax.swing.JComboBox jComboBoxLogradouro;
    private javax.swing.JComboBox jComboBoxSocio;
    private javax.swing.JComboBox jComboBoxStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private JTable jTableEditarConta;
    // End of variables declaration//GEN-END:variables
}
