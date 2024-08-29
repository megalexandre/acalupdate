package br.org.acal.application.telas;

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
    private void initComponents() {

        jButtonAdicionar2 = new javax.swing.JButton();
        jButtonAdicionar3 = new javax.swing.JButton();
        jComboBox1 = new JComboBox();
        jComboBox2 = new JComboBox();
        jComboBox3 = new JComboBox();
        jButtonAdicionar4 = new javax.swing.JButton();
        jComboBox4 = new JComboBox();
        jButtonAdicionar5 = new javax.swing.JButton();
        jButtonAdicionar7 = new javax.swing.JButton();
        jComboBox7 = new JComboBox();
        jButtonAdicionar8 = new javax.swing.JButton();
        jButtonAdicionar6 = new javax.swing.JButton();
        jComboBox8 = new JComboBox();
        jComboBox5 = new JComboBox();
        jComboBox6 = new JComboBox();
        jTextField1 = new JTextField();
        jTextField2 = new JTextField();
        jTextField3 = new JTextField();
        jTextField4 = new JTextField();
        jTextField5 = new JTextField();
        jTextField6 = new JTextField();
        jTextField7 = new JTextField();
        jTextField8 = new JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);
        setResizable(false);

        jButtonAdicionar2.setText("Adicionar");
        jButtonAdicionar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionar2ActionPerformed(evt);
            }
        });

        jButtonAdicionar3.setText("Adicionar");
        jButtonAdicionar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionar3ActionPerformed(evt);
            }
        });

        jButtonAdicionar4.setText("Adicionar");
        jButtonAdicionar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionar4ActionPerformed(evt);
            }
        });

        jButtonAdicionar5.setText("Adicionar");
        jButtonAdicionar5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionar5ActionPerformed(evt);
            }
        });

        jButtonAdicionar7.setText("Adicionar");
        jButtonAdicionar7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionar7ActionPerformed(evt);
            }
        });

        jButtonAdicionar8.setText("Adicionar");
        jButtonAdicionar8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionar8ActionPerformed(evt);
            }
        });

        jButtonAdicionar6.setText("Adicionar");
        jButtonAdicionar6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionar6ActionPerformed(evt);
            }
        });

        jLabel1.setText("Valor");

        jLabel2.setText("Taxa");

        jButton2.setText("Remover");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Remover");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Remover");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Remover");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Remover");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Remover");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Remover");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonAdicionar2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonAdicionar3)
                            .addComponent(jButtonAdicionar4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3)
                            .addComponent(jButton4)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonAdicionar5)
                            .addComponent(jButtonAdicionar6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton5)
                            .addComponent(jButton6)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonAdicionar7)
                            .addComponent(jButtonAdicionar8))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton7)
                            .addComponent(jButton8))))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonAdicionar2, jButtonAdicionar3, jButtonAdicionar4, jButtonAdicionar5, jButtonAdicionar6, jButtonAdicionar7, jButtonAdicionar8});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAdicionar2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonAdicionar3)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonAdicionar4)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton4))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton6)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonAdicionar5)
                                    .addComponent(jButton5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonAdicionar6)
                                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonAdicionar7)
                                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jComboBox8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonAdicionar8)
                                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton8)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jTextField1, jTextField2, jTextField3, jTextField4, jTextField5, jTextField6, jTextField7, jTextField8});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButtonAdicionar2, jButtonAdicionar3, jButtonAdicionar4, jButtonAdicionar5, jButtonAdicionar6, jButtonAdicionar7, jButtonAdicionar8});

        pack();
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
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButtonAdicionar2;
    private javax.swing.JButton jButtonAdicionar3;
    private javax.swing.JButton jButtonAdicionar4;
    private javax.swing.JButton jButtonAdicionar5;
    private javax.swing.JButton jButtonAdicionar6;
    private javax.swing.JButton jButtonAdicionar7;
    private javax.swing.JButton jButtonAdicionar8;
    private JComboBox jComboBox1;
    private JComboBox jComboBox2;
    private JComboBox jComboBox3;
    private JComboBox jComboBox4;
    private JComboBox jComboBox5;
    private JComboBox jComboBox6;
    private JComboBox jComboBox7;
    private JComboBox jComboBox8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private JTextField jTextField1;
    private JTextField jTextField2;
    private JTextField jTextField3;
    private JTextField jTextField4;
    private JTextField jTextField5;
    private JTextField jTextField6;
    private JTextField jTextField7;
    private JTextField jTextField8;
    // End of variables declaration//GEN-END:variables
}
