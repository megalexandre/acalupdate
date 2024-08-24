package acal.telas;

import acal.dao.DaoCategoriaSocio;
import acal.dao.DaoEndereco;
import acal.dao.DaoEnderecoPessoa;
import acal.dao.DaoPessoa;
import acal.entidades.Categoriasocio;
import acal.entidades.Endereco;
import acal.entidades.Enderecopessoa;
import acal.entidades.Pessoa;
import acal.entidades.Socio;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Logradouros extends javax.swing.JDialog {

 private Socio s;
 private List<Enderecopessoa> enderecos;

 public Logradouros(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
      
        setPreferredSize(new Dimension(1024, 768));
        setEditableComponentes(false);
    }
    
   public Logradouros(java.awt.Frame parent, boolean modal, List<Enderecopessoa> enderecos , Socio s){
       this(parent, modal);
       this.enderecos = enderecos;
       this.s = s;
       
       carregarCampos();   
   }
   
   //preencer os combobox
    private void carregarCampos(){
        
        List<Endereco> ends = new DaoEndereco().BuscarTodosEnderecos();
        List<Categoriasocio> categorias = new DaoCategoriaSocio().BuscarTodasCategorias();
        
        if(!ends.isEmpty() && jCombo0.getItemCount() == 0){
            
                jCombo0.addItem("");
                jCombo1.addItem("");
                jCombo2.addItem("");
                jCombo3.addItem("");
                jCombo4.addItem("");
                jCombo5.addItem("");
                jCombo6.addItem("");
                jCombo7.addItem("");
                
            for(Endereco e : ends){
                
                jCombo0.addItem(e.getTipo()+" "+e.getNome());
                jCombo1.addItem(e.getTipo()+" "+e.getNome());
                jCombo2.addItem(e.getTipo()+" "+e.getNome());
                jCombo3.addItem(e.getTipo()+" "+e.getNome());
                jCombo4.addItem(e.getTipo()+" "+e.getNome());
                jCombo5.addItem(e.getTipo()+" "+e.getNome());
                jCombo6.addItem(e.getTipo()+" "+e.getNome());
                jCombo7.addItem(e.getTipo()+" "+e.getNome());
            }
        }
        
      if(!categorias.isEmpty() && jComboCategoria0.getItemCount() == 0){
            
                jComboCategoria0.addItem("");
                jComboCategoria1.addItem("");
                jComboCategoria2.addItem("");
                jComboCategoria3.addItem("");
                jComboCategoria4.addItem("");
                jComboCategoria5.addItem("");
                jComboCategoria6.addItem("");
                jComboCategoria7.addItem("");
                
            for(Categoriasocio c : categorias){
        
                jComboCategoria0.addItem(c.getNome());
               jComboCategoria1.addItem(c.getNome());
               jComboCategoria2.addItem(c.getNome());
               jComboCategoria3.addItem(c.getNome());
               jComboCategoria4.addItem(c.getNome());
               jComboCategoria5.addItem(c.getNome());
               jComboCategoria6.addItem(c.getNome());
               jComboCategoria7.addItem(c.getNome());
            }
        }
        switch(enderecos.size()){
            
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
            
            jCombo0.setSelectedItem(enderecos.get(0).getIdEndereco().getTipo()+" "+enderecos.get(0).getIdEndereco().getNome());
            jComboCategoria0.setSelectedItem(enderecos.get(0).getIdPessoa().getSocio().getIdCategoriaSocio().getNome());
            jNumero0.setText(String.valueOf(enderecos.get(0).getNumero()));
            jFormatted0.setText(SimpleDateFormat.getDateInstance().format(enderecos.get(0).getIdPessoa().getSocio().getDataMatricula()));
                      
            jNumero1.setEditable(true);
            jFormatted1.setEditable(true);
            jCombo1.setEnabled(true);
            jComboCategoria1.setEnabled(true);
            jButtonAdicionar1.setEnabled(true);
            jRadioSocioExclusivo1.setEnabled(true);
            jCheckBox1.setEnabled(true);
            
        } if(size >= 2){
            
             jButton0.setEnabled(true);
             jButtonEditar0.setEnabled(true);
             
             jNumero1.setEditable(false);
             jFormatted1.setEditable(false);
             jCombo1.setEnabled(false);
             jComboCategoria1.setEnabled(false);
             jButtonAdicionar1.setEnabled(false);
             jRadioSocioExclusivo1.setEnabled(false);
             jCheckBox1.setEnabled(false);
   
             jCheckBox1.setSelected(enderecos.get(1).getInativo());
             jRadioSocioExclusivo1.setSelected(enderecos.get(1).getSocioExclusivo());
             
             jNumero1.setText(String.valueOf(enderecos.get(1).getNumero()));          
             jFormatted1.setText((enderecos.get(1).getDatamatricula().toString()));
            
             jNumero2.setEditable(true);
             jFormatted2.setEditable(true);
             jCombo2.setEnabled(true);
             jComboCategoria2.setEnabled(true);
             jButtonAdicionar2.setEnabled(true);
             jRadioSocioExclusivo2.setEnabled(true);
             jCheckBox2.setEnabled(true);
     
             jComboCategoria1.setSelectedItem(enderecos.get(1).getIdCategoriaSocio().getNome());
             jCombo1.setSelectedItem(enderecos.get(1).getIdEndereco().getTipo()+" "+enderecos.get(1).getIdEndereco().getNome());
        
        } if(size >= 3){
            
             jButtonEditar1.setEnabled(true);    
            
             jNumero2.setEditable(false);
             jFormatted2.setEditable(false);
             jCombo2.setEnabled(false);
             jComboCategoria2.setEnabled(false);
             jButtonAdicionar2.setEnabled(false);
             jButton2.setEnabled(true);
             jNumero2.setText(String.valueOf(enderecos.get(2).getNumero()));
             //Alexandre esteve aqui 2
             jFormatted2.setText(SimpleDateFormat.getDateInstance().format(enderecos.get(2).getDatamatricula()));
             jRadioSocioExclusivo2.setEnabled(false);
             jCheckBox2.setEnabled(false);
     
             
             jCheckBox2.setSelected(enderecos.get(2).getInativo());
             jRadioSocioExclusivo2.setSelected(enderecos.get(2).getSocioExclusivo());
             
             jNumero3.setEditable(true);
             jFormatted3.setEditable(true);
             jCombo3.setEnabled(true);
             jComboCategoria3.setEnabled(true);
             jButtonAdicionar3.setEnabled(true);
             jRadioSocioExclusivo3.setEnabled(true);
             jCheckBox3.setEnabled(true);
     
             
             jComboCategoria2.setSelectedItem(enderecos.get(2).getIdCategoriaSocio().getNome());
             jCombo2.setSelectedItem(enderecos.get(2).getIdEndereco().getTipo()+" "+enderecos.get(2).getIdEndereco().getNome());
        
        } if(size >= 4){
            
             jButtonEditar2.setEnabled(true);
            
             jNumero3.setEditable(false);
             jFormatted3.setEditable(false);
             jCombo3.setEnabled(false);
             jComboCategoria3.setEnabled(false);
             jButtonAdicionar3.setEnabled(false);
             jButton3.setEnabled(true);
             jNumero3.setText(String.valueOf(enderecos.get(3).getNumero()));
             jFormatted3.setText(SimpleDateFormat.getDateInstance().format(enderecos.get(3).getDatamatricula()));
             jRadioSocioExclusivo3.setEnabled(false);
             jCheckBox3.setEnabled(false);
             
             jCheckBox3.setSelected(enderecos.get(3).getInativo());
             jRadioSocioExclusivo3.setSelected(enderecos.get(3).getSocioExclusivo());
             
             
             jNumero4.setEditable(true);
             jFormatted4.setEditable(true);
             jCombo4.setEnabled(true);
             jComboCategoria4.setEnabled(true);
             jButtonAdicionar4.setEnabled(true);
             jRadioSocioExclusivo4.setEnabled(true);
             jCheckBox4.setEnabled(true);
             
             jComboCategoria3.setSelectedItem(enderecos.get(3).getIdCategoriaSocio().getNome());
             jCombo3.setSelectedItem(enderecos.get(3).getIdEndereco().getTipo()+" "+enderecos.get(3).getIdEndereco().getNome());
        
        }if(size >= 5){
            
             jButtonEditar3.setEnabled(true); 
             jNumero4.setEditable(false);
             jFormatted4.setEditable(false);
             jCombo4.setEnabled(false);
             jComboCategoria4.setEnabled(false);
             jButtonAdicionar4.setEnabled(false);
             jButton4.setEnabled(true);
             jNumero4.setText(String.valueOf(enderecos.get(4).getNumero()));
             jFormatted4.setText(SimpleDateFormat.getDateInstance().format(enderecos.get(4).getDatamatricula()));
             
             jRadioSocioExclusivo4.setEnabled(false);
             jCheckBox4.setEnabled(false);
             
             
             jCheckBox3.setSelected(enderecos.get(3).getInativo());
             jRadioSocioExclusivo3.setSelected(enderecos.get(3).getSocioExclusivo());
             
             jFormatted5.setEditable(true);
             jNumero5.setEditable(true);
             jCombo5.setEnabled(true);
             jComboCategoria5.setEnabled(true);
             jButtonAdicionar5.setEnabled(true);
             
             jRadioSocioExclusivo5.setEnabled(true);
             jCheckBox5.setEnabled(true);
             
             jComboCategoria4.setSelectedItem(enderecos.get(4).getIdCategoriaSocio().getNome());
             jCombo4.setSelectedItem(enderecos.get(4).getIdEndereco().getTipo()+" "+enderecos.get(4).getIdEndereco().getNome());
            
        }if(size >= 6){
            
            jButtonEditar4.setEnabled(true);
             jNumero5.setEditable(false);
             jFormatted5.setEditable(false);
             jCombo5.setEnabled(false);
             jComboCategoria5.setEnabled(false);
             jButtonAdicionar5.setEnabled(false);
             jButton5.setEnabled(true);
             jNumero5.setText(String.valueOf(enderecos.get(5).getNumero()));
             jFormatted5.setText(SimpleDateFormat.getDateInstance().format(enderecos.get(5).getDatamatricula()));
             
             jRadioSocioExclusivo5.setEnabled(false);
             jCheckBox5.setEnabled(false);
             
             jCheckBox5.setSelected(enderecos.get(5).getInativo());
             jRadioSocioExclusivo5.setSelected(enderecos.get(5).getSocioExclusivo());
             
             
             jFormatted6.setEditable(true);
             jNumero6.setEditable(true);
             jCombo6.setEnabled(true);
             jComboCategoria6.setEnabled(true);
             jButtonAdicionar6.setEnabled(true);
             
             jRadioSocioExclusivo6.setEnabled(true);
             jCheckBox6.setEnabled(true);
             
             
             jComboCategoria5.setSelectedItem(enderecos.get(5).getIdCategoriaSocio().getNome());
             jCombo5.setSelectedItem(enderecos.get(5).getIdEndereco().getTipo()+" "+enderecos.get(5).getIdEndereco().getNome());
        } if(size >= 7){
            
             jButtonEditar5.setEnabled(true);
             
             jNumero6.setEditable(false);
             jFormatted6.setEditable(false);
             jCombo6.setEnabled(false);
             jComboCategoria6.setEnabled(false);
             jButtonAdicionar6.setEnabled(false);
             jButton6.setEnabled(true);
             jNumero6.setText(String.valueOf(enderecos.get(6).getNumero()));
             jFormatted6.setText(SimpleDateFormat.getDateInstance().format(enderecos.get(6).getDatamatricula()));
                
             jRadioSocioExclusivo6.setEnabled(false);
             jCheckBox6.setEnabled(false);
             
             jCheckBox6.setSelected(enderecos.get(6).getInativo());
             jRadioSocioExclusivo6.setSelected(enderecos.get(6).getSocioExclusivo());
             
             jFormatted7.setEditable(true);
             jNumero7.setEditable(true);
             jCombo7.setEnabled(true);
             jComboCategoria7.setEnabled(true);
             jButtonAdicionar7.setEnabled(true);
             jRadioSocioExclusivo6.setEnabled(true);
             jCheckBox6.setEnabled(true);
            
             jComboCategoria6.setSelectedItem(enderecos.get(6).getIdCategoriaSocio().getNome());
             jCombo6.setSelectedItem(enderecos.get(6).getIdEndereco().getTipo()+" "+enderecos.get(6).getIdEndereco().getNome());
             
        } if(size >= 8){
             
             jNumero6.setEditable(false);
             
             jFormatted7.setEditable(false);
             jCombo7.setEnabled(false);
             jComboCategoria7.setEnabled(false);
             jButtonAdicionar7.setEnabled(false);
             jButton7.setEnabled(true);
             
             jRadioSocioExclusivo7.setEnabled(false);
             jCheckBox7.setEnabled(false);
            
             jCheckBox7.setSelected(enderecos.get(7).getInativo());
             jRadioSocioExclusivo7.setSelected(enderecos.get(7).getSocioExclusivo());
             
             jNumero7.setText(String.valueOf(enderecos.get(7).getNumero()));
             jFormatted7.setText(SimpleDateFormat.getDateInstance().format(enderecos.get(7).getDatamatricula()));
             jComboCategoria7.setSelectedItem(enderecos.get(7).getIdCategoriaSocio().getNome());
             jCombo7.setSelectedItem(enderecos.get(7).getIdEndereco().getTipo()+" "+enderecos.get(7).getIdEndereco().getNome());
             
        }if(size > 8){
            
            JOptionPane.showMessageDialog(this, "Você atingiu o numero maximo de endereços","Erro 1",JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    private void setEditableComponentes(boolean edit){
        
        jNumero0.setEditable(edit);
        jNumero1.setEditable(edit);
        jNumero2.setEditable(edit);
        jNumero3.setEditable(edit);
        jNumero4.setEditable(edit);
        jNumero5.setEditable(edit);
        jNumero6.setEditable(edit);
        jNumero7.setEditable(edit);
     
        jRadioSocioExclusivo1.setEnabled(edit);
        jRadioSocioExclusivo2.setEnabled(edit);
        jRadioSocioExclusivo3.setEnabled(edit);
        jRadioSocioExclusivo4.setEnabled(edit);
        jRadioSocioExclusivo5.setEnabled(edit);
        jRadioSocioExclusivo6.setEnabled(edit);
        jRadioSocioExclusivo7.setEnabled(edit);
        
        jCheckBox1.setEnabled(edit);
        jCheckBox2.setEnabled(edit);
        jCheckBox3.setEnabled(edit);
        jCheckBox4.setEnabled(edit);
        jCheckBox5.setEnabled(edit);
        jCheckBox6.setEnabled(edit);
        jCheckBox7.setEnabled(edit);
     
        jFormatted0.setEditable(edit);
        jFormatted1.setEditable(edit);
        jFormatted2.setEditable(edit);
        jFormatted3.setEditable(edit);
        jFormatted4.setEditable(edit);
        jFormatted5.setEditable(edit);
        jFormatted6.setEditable(edit);
        jFormatted7.setEditable(edit);
        
        
        jCombo0.setEnabled(edit);
        jCombo1.setEnabled(edit);
        jCombo2.setEnabled(edit);
        jCombo3.setEnabled(edit);
        jCombo4.setEnabled(edit);
        jCombo5.setEnabled(edit);
        jCombo6.setEnabled(edit);
        jCombo7.setEnabled(edit);
        
        jComboCategoria0.setEnabled(edit);
        jComboCategoria1.setEnabled(edit);
        jComboCategoria2.setEnabled(edit);
        jComboCategoria3.setEnabled(edit);
        jComboCategoria4.setEnabled(edit);
        jComboCategoria5.setEnabled(edit);
        jComboCategoria6.setEnabled(edit);
        jComboCategoria7.setEnabled(edit);
        
       
        jButtonAdicionar1.setEnabled(edit);
        jButtonAdicionar2.setEnabled(edit);
        jButtonAdicionar3.setEnabled(edit);
        jButtonAdicionar4.setEnabled(edit);
        jButtonAdicionar5.setEnabled(edit);
        jButtonAdicionar6.setEnabled(edit);
        jButtonAdicionar7.setEnabled(edit);
        
        jButton0.setEnabled(edit);
        jButton2.setEnabled(edit);
        jButton3.setEnabled(edit);
        jButton4.setEnabled(edit);
        jButton5.setEnabled(edit);
        jButton6.setEnabled(edit);
        jButton7.setEnabled(edit);
        
        jButtonEditar0.setEnabled(edit);
        jButtonEditar1.setEnabled(edit);
        jButtonEditar2.setEnabled(edit);
        jButtonEditar3.setEnabled(edit);
        jButtonEditar4.setEnabled(edit);
        jButtonEditar5.setEnabled(edit);
        jButtonEditar6.setEnabled(edit);
        
    }
 

    /** This method is called from within the constructor to
* initialize the form.
* WARNING: Do NOT modify this code. The content of this method is
* always regenerated by the Form Editor.
*/
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jNumero0 = new JTextField();
        jCombo0 = new JComboBox();
        jFormatted0 = new JFormattedTextField();
        jComboCategoria0 = new JComboBox();
        jPanel4 = new javax.swing.JPanel();
        jButton0 = new javax.swing.JButton();
        jButtonAdicionar1 = new javax.swing.JButton();
        jNumero1 = new JTextField();
        jCombo1 = new JComboBox();
        jFormatted1 = new JFormattedTextField();
        jComboCategoria1 = new JComboBox();
        jCheckBox1 = new JCheckBox();
        jRadioSocioExclusivo1 = new JRadioButton();
        jButtonEditar0 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jNumero2 = new JTextField();
        jCombo2 = new JComboBox();
        jFormatted2 = new JFormattedTextField();
        jComboCategoria2 = new JComboBox();
        jButtonAdicionar2 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jCheckBox2 = new JCheckBox();
        jRadioSocioExclusivo2 = new JRadioButton();
        jButtonEditar1 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jNumero3 = new JTextField();
        jButton3 = new javax.swing.JButton();
        jButtonAdicionar3 = new javax.swing.JButton();
        jComboCategoria3 = new JComboBox();
        jFormatted3 = new JFormattedTextField();
        jCombo3 = new JComboBox();
        jCheckBox3 = new JCheckBox();
        jRadioSocioExclusivo3 = new JRadioButton();
        jButtonEditar2 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButtonAdicionar4 = new javax.swing.JButton();
        jComboCategoria4 = new JComboBox();
        jFormatted4 = new JFormattedTextField();
        jCombo4 = new JComboBox();
        jNumero4 = new JTextField();
        jCheckBox4 = new JCheckBox();
        jRadioSocioExclusivo4 = new JRadioButton();
        jButtonEditar3 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jButtonAdicionar5 = new javax.swing.JButton();
        jComboCategoria5 = new JComboBox();
        jFormatted5 = new JFormattedTextField();
        jCombo5 = new JComboBox();
        jNumero5 = new JTextField();
        jCheckBox5 = new JCheckBox();
        jRadioSocioExclusivo5 = new JRadioButton();
        jButtonEditar4 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jNumero6 = new JTextField();
        jCombo6 = new JComboBox();
        jFormatted6 = new JFormattedTextField();
        jComboCategoria6 = new JComboBox();
        jButtonAdicionar6 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jCheckBox6 = new JCheckBox();
        jRadioSocioExclusivo6 = new JRadioButton();
        jButtonEditar5 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jNumero7 = new JTextField();
        jCombo7 = new JComboBox();
        jFormatted7 = new JFormattedTextField();
        jComboCategoria7 = new JComboBox();
        jButtonAdicionar7 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jCheckBox7 = new JCheckBox();
        jRadioSocioExclusivo7 = new JRadioButton();
        jButtonEditar6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);
        setType(Type.UTILITY);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setText("Categoria Socio");

        jLabel3.setText("Data Matricula");

        jLabel2.setText("Logradouro");

        jLabel1.setText("Número");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(42, 42, 42)
                .addComponent(jLabel2)
                .addGap(26, 26, 26)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(194, 194, 194))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        try {
            jFormatted0.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jNumero0, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jCombo0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jFormatted0, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(245, 245, 245)
                .addComponent(jComboCategoria0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jNumero0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCombo0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormatted0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboCategoria0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        jButton0.setText("Remover");
        jButton0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton0ActionPerformed(evt);
            }
        });

        jButtonAdicionar1.setText("Adicionar");
        jButtonAdicionar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionar1ActionPerformed(evt);
            }
        });

        jNumero1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNumero1ActionPerformed(evt);
            }
        });

        try {
            jFormatted1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jCheckBox1.setText("Inativo");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jRadioSocioExclusivo1.setText("Exclusivamente Socio");

        jButtonEditar0.setText("Editar");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jNumero1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jFormatted1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jCheckBox1)
                .addGap(20, 20, 20)
                .addComponent(jRadioSocioExclusivo1)
                .addGap(20, 20, 20)
                .addComponent(jComboCategoria1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jButtonAdicionar1)
                .addGap(20, 20, 20)
                .addComponent(jButton0)
                .addGap(20, 20, 20)
                .addComponent(jButtonEditar0, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jNumero1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormatted1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboCategoria1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAdicionar1)
                    .addComponent(jButton0)
                    .addComponent(jCheckBox1)
                    .addComponent(jRadioSocioExclusivo1)
                    .addComponent(jButtonEditar0))
                .addGap(5, 5, 5))
        );

        try {
            jFormatted2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jButtonAdicionar2.setText("Adicionar");
        jButtonAdicionar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionar2ActionPerformed(evt);
            }
        });

        jButton2.setText("Remover");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jCheckBox2.setText("Inativo");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        jRadioSocioExclusivo2.setText("Exclusivamente Socio");

        jButtonEditar1.setText("Editar");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jNumero2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jCombo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jFormatted2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jCheckBox2)
                .addGap(20, 20, 20)
                .addComponent(jRadioSocioExclusivo2)
                .addGap(20, 20, 20)
                .addComponent(jComboCategoria2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jButtonAdicionar2)
                .addGap(20, 20, 20)
                .addComponent(jButton2)
                .addGap(20, 20, 20)
                .addComponent(jButtonEditar1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonAdicionar2)
                        .addComponent(jButton2)
                        .addComponent(jComboCategoria2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonEditar1))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jNumero2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCombo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jFormatted2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCheckBox2)
                        .addComponent(jRadioSocioExclusivo2)))
                .addGap(5, 5, 5))
        );

        jButton3.setText("Remover");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButtonAdicionar3.setText("Adicionar");
        jButtonAdicionar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionar3ActionPerformed(evt);
            }
        });

        try {
            jFormatted3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jCheckBox3.setText("Inativo");

        jRadioSocioExclusivo3.setText("Exclusivamente Socio");

        jButtonEditar2.setText("Editar");
        jButtonEditar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditar2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jNumero3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jCombo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jFormatted3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jCheckBox3)
                .addGap(20, 20, 20)
                .addComponent(jRadioSocioExclusivo3)
                .addGap(20, 20, 20)
                .addComponent(jComboCategoria3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jButtonAdicionar3)
                .addGap(20, 20, 20)
                .addComponent(jButton3)
                .addGap(20, 20, 20)
                .addComponent(jButtonEditar2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(104, 104, 104))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jNumero3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCombo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormatted3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAdicionar3)
                    .addComponent(jButton3)
                    .addComponent(jCheckBox3)
                    .addComponent(jRadioSocioExclusivo3)
                    .addComponent(jComboCategoria3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEditar2))
                .addGap(5, 5, 5))
        );

        jButton4.setText("Remover");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButtonAdicionar4.setText("Adicionar");
        jButtonAdicionar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionar4ActionPerformed(evt);
            }
        });

        try {
            jFormatted4.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jCheckBox4.setText("Inativo");

        jRadioSocioExclusivo4.setText("Exclusivamente Socio");

        jButtonEditar3.setText("Editar");
        jButtonEditar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditar3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jNumero4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jCombo4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jFormatted4, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jCheckBox4)
                .addGap(20, 20, 20)
                .addComponent(jRadioSocioExclusivo4)
                .addGap(20, 20, 20)
                .addComponent(jComboCategoria4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jButtonAdicionar4)
                .addGap(20, 20, 20)
                .addComponent(jButton4)
                .addGap(20, 20, 20)
                .addComponent(jButtonEditar3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jNumero4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCombo4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormatted4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboCategoria4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAdicionar4)
                    .addComponent(jButton4)
                    .addComponent(jCheckBox4)
                    .addComponent(jRadioSocioExclusivo4)
                    .addComponent(jButtonEditar3))
                .addGap(5, 5, 5))
        );

        jButton5.setText("Remover");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButtonAdicionar5.setText("Adicionar");
        jButtonAdicionar5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionar5ActionPerformed(evt);
            }
        });

        jComboCategoria5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboCategoria5ActionPerformed(evt);
            }
        });

        try {
            jFormatted5.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jCheckBox5.setText("Inativo");

        jRadioSocioExclusivo5.setText("Exclusivamente Socio");

        jButtonEditar4.setText("Editar");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jNumero5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jCombo5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jFormatted5, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jCheckBox5)
                .addGap(20, 20, 20)
                .addComponent(jRadioSocioExclusivo5)
                .addGap(20, 20, 20)
                .addComponent(jComboCategoria5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jButtonAdicionar5)
                .addGap(20, 20, 20)
                .addComponent(jButton5)
                .addGap(20, 20, 20)
                .addComponent(jButtonEditar4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jCombo5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jNumero5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jFormatted5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboCategoria5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonAdicionar5)
                        .addComponent(jButton5)
                        .addComponent(jCheckBox5)
                        .addComponent(jRadioSocioExclusivo5)
                        .addComponent(jButtonEditar4)))
                .addGap(5, 5, 5))
        );

        try {
            jFormatted6.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jButtonAdicionar6.setText("Adicionar");
        jButtonAdicionar6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionar6ActionPerformed(evt);
            }
        });

        jButton6.setText("Remover");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jCheckBox6.setText("Inativo");
        jCheckBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox6ActionPerformed(evt);
            }
        });

        jRadioSocioExclusivo6.setText("Exclusivamente Socio");
        jRadioSocioExclusivo6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioSocioExclusivo6ActionPerformed(evt);
            }
        });

        jButtonEditar5.setText("Editar");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jNumero6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jCombo6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jFormatted6, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jCheckBox6)
                .addGap(20, 20, 20)
                .addComponent(jRadioSocioExclusivo6)
                .addGap(20, 20, 20)
                .addComponent(jComboCategoria6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jButtonAdicionar6)
                .addGap(20, 20, 20)
                .addComponent(jButton6)
                .addGap(20, 20, 20)
                .addComponent(jButtonEditar5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jNumero6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCombo6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormatted6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox6)
                    .addComponent(jRadioSocioExclusivo6)
                    .addComponent(jComboCategoria6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAdicionar6)
                    .addComponent(jButton6)
                    .addComponent(jButtonEditar5))
                .addGap(5, 5, 5))
        );

        try {
            jFormatted7.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jButtonAdicionar7.setText("Adicionar");
        jButtonAdicionar7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionar7ActionPerformed(evt);
            }
        });

        jButton7.setText("Remover");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jCheckBox7.setText("Inativo");

        jRadioSocioExclusivo7.setText("Exclusivamente Socio");

        jButtonEditar6.setText("Editar");
        jButtonEditar6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditar6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jNumero7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jCombo7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jFormatted7, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jCheckBox7)
                .addGap(20, 20, 20)
                .addComponent(jRadioSocioExclusivo7)
                .addGap(20, 20, 20)
                .addComponent(jComboCategoria7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jButtonAdicionar7)
                .addGap(20, 20, 20)
                .addComponent(jButton7)
                .addGap(20, 20, 20)
                .addComponent(jButtonEditar6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jCombo7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jNumero7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jFormatted7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboCategoria7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jCheckBox7)
                        .addComponent(jRadioSocioExclusivo7)
                        .addComponent(jButtonAdicionar7))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton7)
                        .addComponent(jButtonEditar6)))
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAdicionar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionar1ActionPerformed
       
        adicionar(jCheckBox1, jRadioSocioExclusivo1,jCombo1, jNumero1, jFormatted1,jComboCategoria1);
        
    }//GEN-LAST:event_jButtonAdicionar1ActionPerformed

    
    private void adicionar(JCheckBox checkAtual,JRadioButton radioAtual, JComboBox comboAtual, JTextField textoAtual, JFormattedTextField dataMatricula, JComboBox categoria){

        Pattern p1 = Pattern.compile("\\d{2}\\/\\d{2}\\/\\d{4}");
        Matcher m = p1.matcher(dataMatricula.getText());
          if(!textoAtual.getText().equals("") && !comboAtual.getSelectedItem().equals("") && m.find() && !categoria.getSelectedItem().equals("")){
            if(new DaoEnderecoPessoa().EnderecopessoaporNumero(textoAtual.getText()) == null ){
            int op = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja adicionar esse endereço? ","Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(op == JOptionPane.YES_OPTION){
                
                
                try{
                    
                    Endereco e = new DaoEndereco().BuscarEnderecoCompleto((String) comboAtual.getSelectedItem());
                    Pessoa p = this.s.getIdPessoa();
                    List<Enderecopessoa> ends = p.getEnderecopessoaList();
                    Enderecopessoa ep = new Enderecopessoa();
                    ep.setIdEndereco(e);
                    
                    ep.setNumero(textoAtual.getText());
                    ep.setIdPessoa(p);
                    ep.setDatamatricula(SimpleDateFormat.getDateInstance().parse(dataMatricula.getText()));
                    Categoriasocio c = new DaoCategoriaSocio().BuscarCategoriaPorNome((String)categoria.getSelectedItem());
                    ep.setIdCategoriaSocio(c);
                    
                   
                    ep.setInativo(checkAtual.isSelected());
                    ep.setSocioExclusivo(radioAtual.isSelected());
                     
                    ends.add(ep);
                    p.setEnderecopessoaList(ends);
                    
                    new DaoPessoa().AlterarPessoa(p);
                    
                    JOptionPane.showMessageDialog(this,"Endere�o adicionado com sucesso!","Aten��o", JOptionPane.INFORMATION_MESSAGE);
                  
                    carregarCampos();
                }catch(Exception e){
                    
                    
                    JOptionPane.showMessageDialog(this, "Erro "+e.getMessage(),"Erro", JOptionPane.ERROR_MESSAGE);
                }
                
            }
            }else{
                
                JOptionPane.showMessageDialog(this, "N�mero ou Endereço ja existente para esse sócio","Erro",JOptionPane.ERROR_MESSAGE);
                
            }
        }else{
            
            JOptionPane.showMessageDialog(this, "Preencha todos os campos","Erro", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    
    private void jButton0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton0ActionPerformed
      
       remover(jNumero1);
    }//GEN-LAST:event_jButton0ActionPerformed

    
    private void remover(JTextField textoAtual){
        
        int op = JOptionPane.showConfirmDialog(this,"Deseja excluir o endereço? ","Atenção",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(op == JOptionPane.YES_OPTION){
            try{
        
                Enderecopessoa ep = new DaoEnderecoPessoa().EnderecopessoaporNumero(textoAtual.getText());
                this.enderecos.remove(ep);
                new DaoEnderecoPessoa().ApagarEnderecopessoa(ep);
                
        JOptionPane.showMessageDialog(this, "Endere�o excluido com sucesso!","Atenção", JOptionPane.INFORMATION_MESSAGE);
      
        
       limparCampos();
       setEditableComponentes(false);
       carregarCampos();
            }catch(HeadlessException e){
                
                JOptionPane.showMessageDialog(this, "Erro","Erro", JOptionPane.ERROR_MESSAGE);
                
            }
        }
        
        
    }
    
    private void jButtonAdicionar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionar2ActionPerformed
       adicionar(jCheckBox2, jRadioSocioExclusivo2,jCombo2, jNumero2, jFormatted2, jComboCategoria2);
    }//GEN-LAST:event_jButtonAdicionar2ActionPerformed

    private void jButtonAdicionar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionar3ActionPerformed
       adicionar(jCheckBox3, jRadioSocioExclusivo3,jCombo3, jNumero3,jFormatted3, jComboCategoria3);
    }//GEN-LAST:event_jButtonAdicionar3ActionPerformed

    private void jButtonAdicionar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionar4ActionPerformed
        adicionar(jCheckBox4, jRadioSocioExclusivo4,jCombo4, jNumero4,jFormatted4, jComboCategoria4);
    }//GEN-LAST:event_jButtonAdicionar4ActionPerformed

    private void jButtonAdicionar5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionar5ActionPerformed
        adicionar(jCheckBox5, jRadioSocioExclusivo5,jCombo5, jNumero5,jFormatted5, jComboCategoria5);
    }//GEN-LAST:event_jButtonAdicionar5ActionPerformed

    private void jButtonAdicionar6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionar6ActionPerformed
        adicionar(jCheckBox6, jRadioSocioExclusivo6,jCombo6, jNumero6,jFormatted6, jComboCategoria6);
    }//GEN-LAST:event_jButtonAdicionar6ActionPerformed

    private void jButtonAdicionar7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionar7ActionPerformed
       adicionar(jCheckBox7, jRadioSocioExclusivo7,jCombo7, jNumero7,jFormatted7, jComboCategoria7);
    }//GEN-LAST:event_jButtonAdicionar7ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        remover(jNumero2);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        remover(jNumero3);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        remover(jNumero4);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        remover(jNumero5);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
       remover(jNumero6);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        remover(jNumero7);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jComboCategoria5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboCategoria5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboCategoria5ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jNumero1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNumero1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jNumero1ActionPerformed

    private void jCheckBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox6ActionPerformed

    private void jRadioSocioExclusivo6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioSocioExclusivo6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioSocioExclusivo6ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jButtonEditar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditar2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonEditar2ActionPerformed

    private void jButtonEditar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditar3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonEditar3ActionPerformed

    private void jButtonEditar6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditar6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonEditar6ActionPerformed

    
    
    private void limparCampos(){
        
        
        jNumero0.setText("");
        jNumero1.setText("");
        jNumero2.setText("");
        jNumero3.setText("");
        jNumero4.setText("");
        jNumero5.setText("");
        jNumero6.setText("");
        jNumero7.setText("");
        jFormatted0.setText("");
        jFormatted1.setText("");
        jFormatted2.setText("");
        jFormatted3.setText("");
        jFormatted4.setText("");
        jFormatted5.setText("");
        jFormatted6.setText("");
        jFormatted7.setText("");
        
        jCombo0.setSelectedIndex(0);
        jCombo1.setSelectedIndex(0);
        jCombo2.setSelectedIndex(0);
        jCombo3.setSelectedIndex(0);
        jCombo4.setSelectedIndex(0);
        jCombo5.setSelectedIndex(0);
        jCombo6.setSelectedIndex(0);
        jCombo7.setSelectedIndex(0);
        jComboCategoria0.setSelectedIndex(0);
        jComboCategoria1.setSelectedIndex(0);
        jComboCategoria2.setSelectedIndex(0);
        jComboCategoria3.setSelectedIndex(0);
        jComboCategoria4.setSelectedIndex(0);
        jComboCategoria5.setSelectedIndex(0);
        jComboCategoria6.setSelectedIndex(0);
        jComboCategoria7.setSelectedIndex(0);
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

            @Override
            public void run() {
                Logradouros dialog = new Logradouros(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButton0;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButtonAdicionar1;
    private javax.swing.JButton jButtonAdicionar2;
    private javax.swing.JButton jButtonAdicionar3;
    private javax.swing.JButton jButtonAdicionar4;
    private javax.swing.JButton jButtonAdicionar5;
    private javax.swing.JButton jButtonAdicionar6;
    private javax.swing.JButton jButtonAdicionar7;
    private javax.swing.JButton jButtonEditar0;
    private javax.swing.JButton jButtonEditar1;
    private javax.swing.JButton jButtonEditar2;
    private javax.swing.JButton jButtonEditar3;
    private javax.swing.JButton jButtonEditar4;
    private javax.swing.JButton jButtonEditar5;
    private javax.swing.JButton jButtonEditar6;
    private JCheckBox jCheckBox1;
    private JCheckBox jCheckBox2;
    private JCheckBox jCheckBox3;
    private JCheckBox jCheckBox4;
    private JCheckBox jCheckBox5;
    private JCheckBox jCheckBox6;
    private JCheckBox jCheckBox7;
    private JComboBox jCombo0;
    private JComboBox jCombo1;
    private JComboBox jCombo2;
    private JComboBox jCombo3;
    private JComboBox jCombo4;
    private JComboBox jCombo5;
    private JComboBox jCombo6;
    private JComboBox jCombo7;
    private JComboBox jComboCategoria0;
    private JComboBox jComboCategoria1;
    private JComboBox jComboCategoria2;
    private JComboBox jComboCategoria3;
    private JComboBox jComboCategoria4;
    private JComboBox jComboCategoria5;
    private JComboBox jComboCategoria6;
    private JComboBox jComboCategoria7;
    private JFormattedTextField jFormatted0;
    private JFormattedTextField jFormatted1;
    private JFormattedTextField jFormatted2;
    private JFormattedTextField jFormatted3;
    private JFormattedTextField jFormatted4;
    private JFormattedTextField jFormatted5;
    private JFormattedTextField jFormatted6;
    private JFormattedTextField jFormatted7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private JTextField jNumero0;
    private JTextField jNumero1;
    private JTextField jNumero2;
    private JTextField jNumero3;
    private JTextField jNumero4;
    private JTextField jNumero5;
    private JTextField jNumero6;
    private JTextField jNumero7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private JRadioButton jRadioSocioExclusivo1;
    private JRadioButton jRadioSocioExclusivo2;
    private JRadioButton jRadioSocioExclusivo3;
    private JRadioButton jRadioSocioExclusivo4;
    private JRadioButton jRadioSocioExclusivo5;
    private JRadioButton jRadioSocioExclusivo6;
    private JRadioButton jRadioSocioExclusivo7;
    // End of variables declaration//GEN-END:variables
}
