package br.org.acal.application.telas;

import java.awt.Component;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import br.org.acal.resouces.dao.DaoTaxa;
import br.org.acal.resouces.entidades.Taxa;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.util.List;

public class Taxas extends javax.swing.JDialog {

 private List<Taxa> valoresTaxas;
    public Taxas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
      
        setEditableComponentes(false);
    }
    
   public Taxas(java.awt.Frame parent, boolean modal, List<Taxa> taxas){
       
       this(parent, modal);
       
       this.valoresTaxas = taxas;
       carregarCampos();      
       
   }
   
   public List<Taxa> getValoresTaxas(){
       
       return this.valoresTaxas;
   }
   
    private void carregarCampos(){
        
        List<Taxa> ends = new DaoTaxa().TaxasTodas();
               
        if(!ends.isEmpty() && jComboBox1.getItemCount() == 0){
            
                jComboBox1.addItem("");
                jComboBox2.addItem("");
                jComboBox3.addItem("");
                jComboBox4.addItem("");
                jComboBox5.addItem("");
                jComboBox6.addItem("");
                jComboBox7.addItem("");
                jComboBox8.addItem("");
            for(Taxa e : ends){
                jComboBox1.addItem(e.getNome());
                jComboBox2.addItem(e.getNome());
                jComboBox3.addItem(e.getNome());
                jComboBox4.addItem(e.getNome());
                jComboBox5.addItem(e.getNome());
                jComboBox6.addItem(e.getNome());
                jComboBox7.addItem(e.getNome());
                jComboBox8.addItem(e.getNome());
                
            }
        }
        
        switch(valoresTaxas.size()){
             case 1 : setSelectedCombos(1); break;
             case 2 : setSelectedCombos(2); break;
             case 3 : setSelectedCombos(3); break;
             case 4 : setSelectedCombos(4); break;
             case 5 : setSelectedCombos(5); break;
             case 6 : setSelectedCombos(6); break;
             case 7 : setSelectedCombos(7); break;
             case 8 : setSelectedCombos(8); break;
        }
    }
    
    private void setSelectedCombos(int size){
        if(size >= 1){
            
          
            
            jComboBox1.setSelectedItem(valoresTaxas.get(0).getNome());
            jTextField1.setText(String.valueOf(valoresTaxas.get(0).getValor()));
            
             jComboBox2.setEnabled(true);
             jButtonAdicionar2.setEnabled(true);
             
        } if(size >= 2){
            
            
             jComboBox2.setEnabled(false);
             jButtonAdicionar2.setEnabled(false);
              jButton2.setEnabled(true);
            jTextField2.setText(String.valueOf(valoresTaxas.get(1).getValor()));
           
             jComboBox3.setEnabled(true);
             jButtonAdicionar3.setEnabled(true);
              
             jComboBox2.setSelectedItem(valoresTaxas.get(1).getNome());
        } if(size >= 3){
            
            
             jComboBox3.setEnabled(false);
             jButtonAdicionar3.setEnabled(false);
              jButton3.setEnabled(true);
            jTextField3.setText(String.valueOf(valoresTaxas.get(2).getValor()));
            
            
             jComboBox4.setEnabled(true);
             jButtonAdicionar4.setEnabled(true);
             
             jComboBox3.setSelectedItem(valoresTaxas.get(2).getNome());
        } if(size >= 4){
            
           
             jComboBox4.setEnabled(false);
             jButtonAdicionar4.setEnabled(false);
              jButton4.setEnabled(true);
            jTextField4.setText(String.valueOf(valoresTaxas.get(3).getValor()));
            
             jComboBox5.setEnabled(true);
             jButtonAdicionar5.setEnabled(true);
             
             jComboBox4.setSelectedItem(valoresTaxas.get(3).getNome());
        }if(size >= 5){
            
            
             jComboBox5.setEnabled(false);
             jButtonAdicionar5.setEnabled(false);
              jButton5.setEnabled(true);
            jTextField5.setText(String.valueOf(valoresTaxas.get(4).getValor()));
            
             jComboBox6.setEnabled(true);
             jButtonAdicionar6.setEnabled(true);
             
             jComboBox5.setSelectedItem(valoresTaxas.get(4).getNome());
            
        }if(size >= 6){
            
            
             jComboBox6.setEnabled(false);
             jButtonAdicionar6.setEnabled(false);
              jButton6.setEnabled(true);
            jTextField6.setText(String.valueOf(valoresTaxas.get(5).getValor()));
             
             jComboBox7.setEnabled(true);
             jButtonAdicionar7.setEnabled(true);
             
             jComboBox6.setSelectedItem(valoresTaxas.get(5).getNome());
        } if(size >= 7){
            
            
             jComboBox7.setEnabled(false);
             jButtonAdicionar7.setEnabled(false);
              jButton7.setEnabled(true);
            jTextField7.setText(String.valueOf(valoresTaxas.get(6).getValor()));
            
             jComboBox8.setEnabled(true);
             jButtonAdicionar8.setEnabled(true);
             
             jComboBox7.setSelectedItem(valoresTaxas.get(6).getNome());
        } if(size >= 8){
             
           
             jComboBox8.setEnabled(false);
             jButtonAdicionar8.setEnabled(false);
              jButton8.setEnabled(true);
            jTextField8.setText(String.valueOf(valoresTaxas.get(7).getValor()));
             jComboBox8.setSelectedItem(valoresTaxas.get(7).getNome());
        }if(size > 8){
            
            JOptionPane.showMessageDialog(this, "Você atingiu o número máximo de taxas","Erro",JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    private void setEditableComponentes(boolean edit){
        
        jTextField1.setEditable(edit);
        
        jTextField2.setEditable(edit);
        jTextField3.setEditable(edit);
        jTextField4.setEditable(edit);
        jTextField5.setEditable(edit);
        jTextField6.setEditable(edit);
        jTextField7.setEditable(edit);
        jTextField8.setEditable(edit);
     
        jComboBox1.setEnabled(edit);
        jComboBox2.setEnabled(edit);
        jComboBox3.setEnabled(edit);
        jComboBox4.setEnabled(edit);
        jComboBox5.setEnabled(edit);
        jComboBox6.setEnabled(edit);
        jComboBox7.setEnabled(edit);
        jComboBox8.setEnabled(edit);
        
       
        jButtonAdicionar2.setEnabled(edit);
        jButtonAdicionar3.setEnabled(edit);
        jButtonAdicionar4.setEnabled(edit);
        jButtonAdicionar5.setEnabled(edit);
        jButtonAdicionar6.setEnabled(edit);
        jButtonAdicionar7.setEnabled(edit);
        jButtonAdicionar8.setEnabled(edit);
        
        jButton2.setEnabled(edit);
        jButton3.setEnabled(edit);
        jButton4.setEnabled(edit);
        jButton5.setEnabled(edit);
        jButton6.setEnabled(edit);
        jButton7.setEnabled(edit);
        jButton8.setEnabled(edit);
        
    }
 

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    // Generated using JFormDesigner non-commercial license
    private void initComponents() {
        jButtonAdicionar2 = new JButton();
        jButtonAdicionar3 = new JButton();
        jComboBox1 = new JComboBox<>();
        jComboBox2 = new JComboBox<>();
        jComboBox3 = new JComboBox<>();
        jButtonAdicionar4 = new JButton();
        jComboBox4 = new JComboBox<>();
        jButtonAdicionar5 = new JButton();
        jButtonAdicionar7 = new JButton();
        jComboBox7 = new JComboBox<>();
        jButtonAdicionar8 = new JButton();
        jButtonAdicionar6 = new JButton();
        jComboBox8 = new JComboBox<>();
        jComboBox5 = new JComboBox<>();
        jComboBox6 = new JComboBox<>();
        jTextField1 = new JTextField();
        jTextField2 = new JTextField();
        jTextField3 = new JTextField();
        jTextField4 = new JTextField();
        jTextField5 = new JTextField();
        jTextField6 = new JTextField();
        jTextField7 = new JTextField();
        jTextField8 = new JTextField();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jButton2 = new JButton();
        jButton3 = new JButton();
        jButton4 = new JButton();
        jButton5 = new JButton();
        jButton6 = new JButton();
        jButton7 = new JButton();
        jButton8 = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);
        setResizable(false);
        var contentPane = getContentPane();

        //---- jButtonAdicionar2 ----
        jButtonAdicionar2.setText("Adicionar");
        jButtonAdicionar2.addActionListener(e -> jButtonAdicionar2ActionPerformed(e));

        //---- jButtonAdicionar3 ----
        jButtonAdicionar3.setText("Adicionar");
        jButtonAdicionar3.addActionListener(e -> jButtonAdicionar3ActionPerformed(e));

        //---- jComboBox1 ----
        jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] {

        }));

        //---- jComboBox2 ----
        jComboBox2.setModel(new DefaultComboBoxModel<>(new String[] {

        }));

        //---- jComboBox3 ----
        jComboBox3.setModel(new DefaultComboBoxModel<>(new String[] {

        }));

        //---- jButtonAdicionar4 ----
        jButtonAdicionar4.setText("Adicionar");
        jButtonAdicionar4.addActionListener(e -> jButtonAdicionar4ActionPerformed(e));

        //---- jComboBox4 ----
        jComboBox4.setModel(new DefaultComboBoxModel<>(new String[] {

        }));

        //---- jButtonAdicionar5 ----
        jButtonAdicionar5.setText("Adicionar");
        jButtonAdicionar5.addActionListener(e -> jButtonAdicionar5ActionPerformed(e));

        //---- jButtonAdicionar7 ----
        jButtonAdicionar7.setText("Adicionar");
        jButtonAdicionar7.addActionListener(e -> jButtonAdicionar7ActionPerformed(e));

        //---- jComboBox7 ----
        jComboBox7.setModel(new DefaultComboBoxModel<>(new String[] {

        }));

        //---- jButtonAdicionar8 ----
        jButtonAdicionar8.setText("Adicionar");
        jButtonAdicionar8.addActionListener(e -> jButtonAdicionar8ActionPerformed(e));

        //---- jButtonAdicionar6 ----
        jButtonAdicionar6.setText("Adicionar");
        jButtonAdicionar6.addActionListener(e -> jButtonAdicionar6ActionPerformed(e));

        //---- jComboBox8 ----
        jComboBox8.setModel(new DefaultComboBoxModel<>(new String[] {

        }));

        //---- jComboBox5 ----
        jComboBox5.setModel(new DefaultComboBoxModel<>(new String[] {

        }));

        //---- jComboBox6 ----
        jComboBox6.setModel(new DefaultComboBoxModel<>(new String[] {

        }));

        //---- jLabel1 ----
        jLabel1.setText("Valor");

        //---- jLabel2 ----
        jLabel2.setText("Taxa");

        //---- jButton2 ----
        jButton2.setText("Remover");
        jButton2.addActionListener(e -> jButton2ActionPerformed(e));

        //---- jButton3 ----
        jButton3.setText("Remover");
        jButton3.addActionListener(e -> jButton3ActionPerformed(e));

        //---- jButton4 ----
        jButton4.setText("Remover");
        jButton4.addActionListener(e -> jButton4ActionPerformed(e));

        //---- jButton5 ----
        jButton5.setText("Remover");
        jButton5.addActionListener(e -> jButton5ActionPerformed(e));

        //---- jButton6 ----
        jButton6.setText("Remover");
        jButton6.addActionListener(e -> jButton6ActionPerformed(e));

        //---- jButton7 ----
        jButton7.setText("Remover");
        jButton7.addActionListener(e -> jButton7ActionPerformed(e));

        //---- jButton8 ----
        jButton8.setText("Remover");
        jButton8.addActionListener(e -> jButton8ActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(jTextField6, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField8, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField7, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(jComboBox8, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBox7, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBox6, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createParallelGroup()
                                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jTextField5, GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField3, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField1, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jTextField2, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel1))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(jLabel2)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(jComboBox5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
                    .addGap(10, 10, 10)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(jButtonAdicionar2)
                            .addGap(18, 18, 18)
                            .addComponent(jButton2))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(jButtonAdicionar3)
                                .addComponent(jButtonAdicionar4))
                            .addGap(18, 18, 18)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(jButton3)
                                .addComponent(jButton4)))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(jButtonAdicionar5)
                                .addComponent(jButtonAdicionar6))
                            .addGap(18, 18, 18)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(jButton5)
                                .addComponent(jButton6)))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(jButtonAdicionar7)
                                .addComponent(jButtonAdicionar8))
                            .addGap(18, 18, 18)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(jButton7)
                                .addComponent(jButton8))))
                    .addContainerGap(26, Short.MAX_VALUE))
        );
        contentPaneLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {jButtonAdicionar2, jButtonAdicionar3, jButtonAdicionar4, jButtonAdicionar5, jButtonAdicionar6, jButtonAdicionar7, jButtonAdicionar8});
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(10, 10, 10)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonAdicionar2)
                        .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2))
                    .addGap(10, 10, 10)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jComboBox3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButtonAdicionar3)
                                .addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton3))
                            .addGap(10, 10, 10)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jComboBox4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButtonAdicionar4)
                                .addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jButton4))
                    .addGap(10, 10, 10)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(jTextField5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(jButton6)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jComboBox5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButtonAdicionar5)
                                        .addComponent(jButton5))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jComboBox6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButtonAdicionar6)
                                        .addComponent(jTextField6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                            .addGap(10, 10, 10)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jComboBox7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButtonAdicionar7)
                                        .addComponent(jTextField7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    .addGap(10, 10, 10)
                                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jComboBox8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButtonAdicionar8)
                                        .addComponent(jTextField8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(jButton7)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jButton8)))))
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        contentPaneLayout.linkSize(SwingConstants.VERTICAL, new Component[] {jTextField1, jTextField2, jTextField3, jTextField4, jTextField5, jTextField6, jTextField7, jTextField8});
        contentPaneLayout.linkSize(SwingConstants.VERTICAL, new Component[] {jButtonAdicionar2, jButtonAdicionar3, jButtonAdicionar4, jButtonAdicionar5, jButtonAdicionar6, jButtonAdicionar7, jButtonAdicionar8});
        pack();
        setLocationRelativeTo(getOwner());
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAdicionar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionar2ActionPerformed
       
        adicionar(jComboBox2, jTextField2);
        
    }//GEN-LAST:event_jButtonAdicionar2ActionPerformed

    
    private void adicionar(JComboBox comboAtual, JTextField textoAtual){
        
          if(!comboAtual.getSelectedItem().equals("")){
           
            int op = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja adicionar essa taxa? ","Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(op == JOptionPane.YES_OPTION){
                
                
                try{
                    
                   Taxa t = new DaoTaxa().TaxasPorNome((String)comboAtual.getSelectedItem());
                   boolean existeTaxa = false;
                    for(Taxa aux : valoresTaxas){
                        
                        if(aux.getNome().equals(t.getNome())){
                            
                            existeTaxa = true;
                        }
                        
                    }
                    
                    
                    if(existeTaxa){
                    JOptionPane.showMessageDialog(this,"Esta taxa já existe para esse endereço","Erro",JOptionPane.ERROR_MESSAGE);
                    }else{
                    valoresTaxas.add(t);    
                    JOptionPane.showMessageDialog(this,"Taxa adicionada com sucesso!","Atenção", JOptionPane.INFORMATION_MESSAGE);
                    }
                    
                    carregarCampos();
                 }catch(Exception e){
                    
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Erro "+e.getMessage(),"Erro", JOptionPane.ERROR_MESSAGE);
                }}

}
            
        else{
            
            JOptionPane.showMessageDialog(this, "Preencha  os campos","Erro", JOptionPane.ERROR_MESSAGE);
        }
 
    }
    
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      
       remover(jComboBox2);
    }//GEN-LAST:event_jButton2ActionPerformed

    
    private void remover(JComboBox comboAtual){
        
         int op = JOptionPane.showConfirmDialog(this,"Deseja excluir a taxa? ","Atenção",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(op == JOptionPane.YES_OPTION){
            try{
        
                Taxa t = new DaoTaxa().TaxasPorNome((String)comboAtual.getSelectedItem());
                valoresTaxas.remove(t);
                 
               
                
        JOptionPane.showMessageDialog(this, "Taxa excluida com sucesso!","Atenção", JOptionPane.INFORMATION_MESSAGE);
       limparCampos();
       setEditableComponentes(false);
        carregarCampos();
            }catch(Exception e){
                
                JOptionPane.showMessageDialog(this, "Erro","Erro", JOptionPane.ERROR_MESSAGE);
                
            }
        }
        
        
    }
    
    private void jButtonAdicionar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionar3ActionPerformed
       adicionar(jComboBox3, jTextField3);
    }//GEN-LAST:event_jButtonAdicionar3ActionPerformed

    private void jButtonAdicionar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionar4ActionPerformed
       adicionar(jComboBox4, jTextField4);
    }//GEN-LAST:event_jButtonAdicionar4ActionPerformed

    private void jButtonAdicionar5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionar5ActionPerformed
        adicionar(jComboBox5, jTextField5);
    }//GEN-LAST:event_jButtonAdicionar5ActionPerformed

    private void jButtonAdicionar6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionar6ActionPerformed
        adicionar(jComboBox6, jTextField6);
    }//GEN-LAST:event_jButtonAdicionar6ActionPerformed

    private void jButtonAdicionar7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionar7ActionPerformed
        adicionar(jComboBox7, jTextField7);
    }//GEN-LAST:event_jButtonAdicionar7ActionPerformed

    private void jButtonAdicionar8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionar8ActionPerformed
       adicionar(jComboBox8, jTextField8);
    }//GEN-LAST:event_jButtonAdicionar8ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        remover(jComboBox3);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        remover(jComboBox4);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        remover(jComboBox5);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        remover(jComboBox6);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
       remover(jComboBox7);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        remover(jComboBox8);
    }//GEN-LAST:event_jButton8ActionPerformed

    
    
    private void limparCampos(){
        
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jTextField6.setText("");
        jTextField7.setText("");
        jTextField8.setText("");
        
        jComboBox1.setSelectedIndex(0);
        jComboBox2.setSelectedIndex(0);
        jComboBox3.setSelectedIndex(0);
        jComboBox4.setSelectedIndex(0);
        jComboBox5.setSelectedIndex(0);
        jComboBox6.setSelectedIndex(0);
        jComboBox7.setSelectedIndex(0);
        jComboBox8.setSelectedIndex(0);
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Logradouros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Logradouros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Logradouros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Logradouros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                Taxas dialog = new Taxas(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // Generated using JFormDesigner non-commercial license
    private JButton jButtonAdicionar2;
    private JButton jButtonAdicionar3;
    private JComboBox<String> jComboBox1;
    private JComboBox<String> jComboBox2;
    private JComboBox<String> jComboBox3;
    private JButton jButtonAdicionar4;
    private JComboBox<String> jComboBox4;
    private JButton jButtonAdicionar5;
    private JButton jButtonAdicionar7;
    private JComboBox<String> jComboBox7;
    private JButton jButtonAdicionar8;
    private JButton jButtonAdicionar6;
    private JComboBox<String> jComboBox8;
    private JComboBox<String> jComboBox5;
    private JComboBox<String> jComboBox6;
    private JTextField jTextField1;
    private JTextField jTextField2;
    private JTextField jTextField3;
    private JTextField jTextField4;
    private JTextField jTextField5;
    private JTextField jTextField6;
    private JTextField jTextField7;
    private JTextField jTextField8;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;
    private JButton jButton5;
    private JButton jButton6;
    private JButton jButton7;
    private JButton jButton8;
    // End of variables declaration//GEN-END:variables
}
