package acal.telas.relatorios.tabelas;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import acal.TableModel.CaixaCompletoTableModel;
import acal.dao.view.DaoCaixaView;
import acal.dao.view.DaoContaView;
import acal.dao.view.DaoEnderecoView;
import acal.dao.view.DaoSocioView;
import acal.entidades.EnderecoView;
import acal.entidades.SociosView;
import acal.infra.HibernateUtil;
import acal.telas.TelaPrincipal;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class TelaTabelaConta extends javax.swing.JFrame {
      
   private CaixaCompletoTableModel pModelTela;
   private CaixaCompletoTableModel pModelBanco;
   
   private final int _socio  = 1;
   private final int _logradouro = 2;
   private final int _status = 4;

   private int existeAtraso   = 0;
   private int existeCarne    = 0;
   private int existeConta    = 0;
   
   private final int checkSocio              =1;
   private final int checkLogradouro         =2;
   private final int checkStatus             =4;
   private final int checkSocio_logradouro   =3;
   private final int checkSocio_status       =5;
   private final int checkLogradouro_status  =6;
   private final int check_todas             =7;
   
   private final int aberta = 1;
   private final int paga   = 2;
   private final int vencida= 3;

   private final int EscolhaSocio = 1;
   private final int EscolhaEndereco =2;
    
   String sqlnormal    ="";
   String sqlatrasadas ="";
   String sqlCarne     ="";
      
    public TelaTabelaConta() {        
        initComponents();
        inicializer();
    }

    private void inicializer()
    {
      jTotalTela.setEnabled(false);
      jTotalBanco.setEnabled(false);
      jAbertasTela.setEnabled(false);
      jAbertasBanco.setEnabled(false);
      jAtrasadasBanco.setEnabled(false);
      jAtrasadasTela.setEnabled(false);
      jDatePagamentoFim.setEnabled(false);
      jDatePagamentoInicio.setEnabled(false);
      jDateVencimentoInicio.setEnabled(false);
      jDateVencimentoFim.setEnabled(false);
      jValorTotalTela.setEnabled(false);
      jValorTotalbanco.setEnabled(false);
      jValorAtrasadasBanco.setEnabled(false);
      jValorAtrasadasTela.setEnabled(false);
      jComboBoxLogradouro.setEnabled(false);
      jComboBoxSocio.setEnabled(false);
      
      getTableModelBanco();
      getTableModelTela();
      ConfigurarTabela();
    }
    
   public void ConfigurarTabela(){
    jTabBanco.setModel(pModelBanco);
    jTabTela .setModel(pModelTela);
    adicionarEventosTela(jTabTela);
    adicionarEventosBanco(jTabBanco);
    //jTabTela.setDefaultRenderer(Object.class, new Render());
    //jTabBanco.setDefaultRenderer(Object.class, new Render());
    
   }
   
   public void contar()
   {
       
       jTotalTela.setText (Integer.toString(pModelTela.getRowCount()));
       jTotalBanco.setText(Integer.toString(pModelBanco.getRowCount()));
   
       int TelaAberta=0;
       int TelaQtdAtrasada=0;
       
       BigDecimal bdTela= new BigDecimal(000000.00);
       BigDecimal vdTela= new BigDecimal(000000.00);
       
       for (int i = 0; i < pModelTela.getRowCount(); i++) {
          //total de contas abertas
          if( pModelTela.getLinha(i).getPagamento()==null)
          {
          TelaAberta++;
          }
          //valor total das contas
          bdTela= bdTela.add(BigDecimal.valueOf(pModelTela.getLinha(i).getTotalconta()));
          if((pModelTela.getLinha(i).getPagamento() == null)&&
          (pModelTela.getLinha(i).getVencimento().before(new Date()) ))
          {
          TelaQtdAtrasada++;
          vdTela= vdTela.add(BigDecimal.valueOf(pModelTela.getLinha(i).getTotalconta()));
          }    
       }
       
       if(bdTela==null){jValorTotalTela.setText(String.valueOf("0.00"));}
       else            {jValorTotalTela.setText(String.valueOf(bdTela));}
       if(vdTela==null){jValorAtrasadasTela.setText(String.valueOf("0.00"));}
       else            {jValorAtrasadasTela.setText(String.valueOf(vdTela));}
       
       jAtrasadasTela.setText(Integer.toString(TelaQtdAtrasada));
       jAbertasTela.setText(Integer.toString(TelaAberta));
       
       int BancoAberta=0;
       int BancoQtdAtrasada=0;
       
       BigDecimal bdBanco = new BigDecimal(000000.00);
       BigDecimal VdBanco = new BigDecimal(000000.00);
               
       
       for (int i = 0; i < pModelBanco.getRowCount(); i++) {
           
           if(pModelBanco.getLinha(i).getPagamento()==null)
           {
           BancoAberta++;
           }
           bdBanco= bdBanco.add(BigDecimal.valueOf(pModelBanco.getLinha(i).getTotalconta()));
           if((pModelBanco.getLinha(i).getPagamento() == null)&&
           (pModelBanco.getLinha(i).getVencimento().before(new Date()) ))
           {
           BancoQtdAtrasada++;
           VdBanco= VdBanco.add(BigDecimal.valueOf(pModelBanco.getLinha(i).getTotalconta()));
           }
          
       }
       if  (bdBanco==null){jValorTotalbanco.setText("0.00");}
       else               {jValorTotalbanco.setText(String.valueOf(bdBanco));}
       if  (VdBanco==null){jValorAtrasadasBanco.setText("0.00");}
       else               {jValorAtrasadasBanco.setText(String.valueOf(VdBanco));}
       
       
       jAtrasadasBanco.setText(Integer.toString(BancoQtdAtrasada));
       jAbertasBanco.setText(Integer.toString(BancoAberta));
   }
   
    private void getTableModelBanco()        
    {       
        if (pModelBanco == null) {
            pModelBanco = new CaixaCompletoTableModel();       
        }
    }    
   
    private void getTableModelTela()        
    {       
        if (pModelTela == null) {
            pModelTela = new CaixaCompletoTableModel();       
        }
    }    
    
    private void adicionarEventosBanco(final JTable table ) {
    
     table.addMouseListener(new MouseListener() {
     @Override
     public void mouseClicked(MouseEvent e) 
     { 
         boolean flag=true;
          if (e.getClickCount() == 2) 
          {
              for (int i = 0; i < pModelTela.getRowCount(); i++) {
                if( pModelTela.getLinha(i).getNumeroconta() ==
                    pModelBanco.getLinha(jTabBanco.getSelectedRow()).getNumeroconta())
                {
                 flag=false;
                JOptionPane.showMessageDialog(null,"Essa linha já foi adcionda");
                }
              }
              if(flag==true){
              pModelTela.addLinha(pModelBanco.getLinha(jTabBanco.getSelectedRow()));
              pModelBanco.removeLinha(jTabBanco.getSelectedRow());
              }
           contar();
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
    
    private void adicionarEventosTela(final JTable table ) {
    
     table.addMouseListener(new MouseListener() {
     @Override
     public void mouseClicked(MouseEvent e) 
     { 
        if (e.getClickCount() == 2) 
        {  
        pModelTela.removeLinha(jTabTela.getSelectedRow());
        contar();
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
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabTela = new JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTotalTela = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jAbertasTela = new javax.swing.JTextField();
        jAtrasadasTela = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jValorTotalTela = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jValorAtrasadasTela = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jDatePagamentoFim = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jDatePagamentoInicio = new com.toedter.calendar.JDateChooser();
        jCheckBoxPagamento = new javax.swing.JCheckBox();
        jPanel7 = new javax.swing.JPanel();
        jDateVencimentoInicio = new com.toedter.calendar.JDateChooser();
        jDateVencimentoFim = new com.toedter.calendar.JDateChooser();
        jCheckVencimento = new javax.swing.JCheckBox();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jButtonBuscar = new javax.swing.JButton();
        jButtonExportar = new javax.swing.JButton();
        jButtonExportar1 = new javax.swing.JButton();
        jButtonExportar2 = new javax.swing.JButton();
        jButtonBuscar1 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jCheckSocio = new javax.swing.JCheckBox();
        jCheckLogradouro = new javax.swing.JCheckBox();
        jCheckStatus = new javax.swing.JCheckBox();
        jComboBoxSocio = new javax.swing.JComboBox();
        jComboBoxLogradouro = new javax.swing.JComboBox();
        jComboBoxStatus = new javax.swing.JComboBox();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTotalBanco = new javax.swing.JTextField();
        jAbertasBanco = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jAtrasadasBanco = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jValorTotalbanco = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jValorAtrasadasBanco = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTabBanco = new JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/img/ico.png")).getImage());

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTabTela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTabTela);

        jLabel1.setText("Contas Prontas para a Impressão");

        jLabel5.setText("Numero de Contas");

        jLabel7.setText("Abertas");

        jLabel9.setText("Atrasadas");

        jLabel10.setText("Valor Total");

        jLabel15.setText("Valor Atrasadas");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(3, 3, 3)
                .addComponent(jAtrasadasTela, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel15)
                .addGap(3, 3, 3)
                .addComponent(jValorAtrasadasTela, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel7)
                .addGap(3, 3, 3)
                .addComponent(jAbertasTela, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel5)
                .addGap(3, 3, 3)
                .addComponent(jTotalTela, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel10)
                .addGap(3, 3, 3)
                .addComponent(jValorTotalTela, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jAbertasTela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jValorTotalTela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jValorAtrasadasTela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jAtrasadasTela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jTotalTela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)))
                .addGap(4, 4, 4))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1))
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setText("Final");

        jLabel3.setText("Inicio");

        jDatePagamentoInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jDatePagamentoInicioMouseClicked(evt);
            }
        });
        jDatePagamentoInicio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jDatePagamentoInicioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jDatePagamentoInicioFocusLost(evt);
            }
        });

        jCheckBoxPagamento.setText("Pagamento");
        jCheckBoxPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxPagamentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(10, 10, 10)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBoxPagamento)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jDatePagamentoInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jDatePagamentoFim, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jCheckBoxPagamento)
                .addGap(0, 0, 0)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDatePagamentoInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(9, 9, 9)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDatePagamentoFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(10, 10, 10))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jDateVencimentoInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jDateVencimentoInicioMouseClicked(evt);
            }
        });
        jDateVencimentoInicio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jDateVencimentoInicioFocusGained(evt);
            }
        });

        jCheckVencimento.setText("Vecimento");
        jCheckVencimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckVencimentoActionPerformed(evt);
            }
        });

        jLabel13.setText("Inicio");

        jLabel14.setText("Final");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(10, 10, 10)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckVencimento)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jDateVencimentoInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jDateVencimentoFim, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addComponent(jCheckVencimento)
                .addGap(0, 0, 0)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateVencimentoInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(9, 9, 9)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jDateVencimentoFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButtonBuscar.setText("Buscar");
        jButtonBuscar.setPreferredSize(new java.awt.Dimension(100, 23));
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        jButtonExportar.setText("Imprimir");
        jButtonExportar.setPreferredSize(new java.awt.Dimension(100, 23));
        jButtonExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExportarActionPerformed(evt);
            }
        });

        jButtonExportar1.setText("Limpar Tela");
        jButtonExportar1.setPreferredSize(new java.awt.Dimension(100, 23));
        jButtonExportar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExportar1ActionPerformed(evt);
            }
        });

        jButtonExportar2.setText("Limpar Consulta");
        jButtonExportar2.setPreferredSize(new java.awt.Dimension(100, 23));
        jButtonExportar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExportar2ActionPerformed(evt);
            }
        });

        jButtonBuscar1.setText("Aceitar todas");
        jButtonBuscar1.setPreferredSize(new java.awt.Dimension(100, 23));
        jButtonBuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonExportar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(jButtonExportar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                        .addComponent(jButtonExportar2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButtonBuscar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(6, 6, 6))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jButtonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jButtonBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonExportar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonExportar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(jButtonExportar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11))
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

        jComboBoxStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Aberta", "Paga", "Vencida" }));
        jComboBoxStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxStatusActionPerformed(evt);
            }
        });
        jComboBoxStatus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBoxStatusKeyPressed(evt);
            }
        });

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
                    .addComponent(jComboBoxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxSocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(187, Short.MAX_VALUE))
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
                    .addComponent(jComboBoxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel2.setText("Contas No banco de dados");

        jLabel6.setText(" Numero de Contas");

        jLabel8.setText("Abertas");

        jLabel12.setText("Atrasadas");

        jLabel11.setText("Valor Total");

        jLabel16.setText("Valor Atrasadas");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addGap(3, 3, 3)
                .addComponent(jAtrasadasBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel16)
                .addGap(3, 3, 3)
                .addComponent(jValorAtrasadasBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel8)
                .addGap(3, 3, 3)
                .addComponent(jAbertasBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel6)
                .addGap(3, 3, 3)
                .addComponent(jTotalBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel11)
                .addGap(3, 3, 3)
                .addComponent(jValorTotalbanco, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(jValorTotalbanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jValorAtrasadasBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel16))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jAtrasadasBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel6)
                        .addComponent(jTotalBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jAbertasBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)))
                .addGap(5, 5, 5))
        );

        jTabBanco.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jTabBanco);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(1, 1, 1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        buscar();        
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    

    
    
    private void jButtonExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExportarActionPerformed
                 
      Thread t;  
       t = new Thread ()  
       {
           @Override
           @SuppressWarnings("empty-statement")
           public void run() {
               
               sqlnormal    =" WHERE ";
               sqlatrasadas =" WHERE ";
               sqlCarne     =" WHERE ";
               
               //tem algum valor na tela para ser impresso?
               if(pModelTela.getRowCount()<1){
                   JOptionPane.showMessageDialog(null,"É preciso Haver pelo menos um Elemento para ser Exportado");
               }
               
               else{

                   Calendar datacompara = Calendar.getInstance();
                   datacompara.set(Calendar.MONTH, -2 );
                   
                   Calendar dataConta = Calendar.getInstance();
                   
                   
                   
                   for (int i = 0; i < pModelTela.getRowCount(); i++) {
                       
                       //quem vai receber o relatorio de socio
                       if(pModelTela.getLinha(i).getSocioExclusivo()==true){
                           existeCarne++;
                           if(existeCarne==1){sqlCarne+= "\n c.id = " + pModelTela.getLinha(i).getNumeroconta();}
                           else              {sqlCarne+= "\n or c.id = " + pModelTela.getLinha(i).getNumeroconta();}
                              
                       }
                       //quem vai receber o relatorio normal de conta
                       else{
                           existeConta++;
                           if(existeConta==1){sqlnormal+= "\n c.id = " + pModelTela.getLinha(i).getNumeroconta();}
                           else              {sqlnormal+= "\n or c.id = " + pModelTela.getLinha(i).getNumeroconta();}
                       }
                   
                       //carregar o calendar com a data da conta
                       dataConta.setTime(pModelTela.getLinha(i).getData());
                       //quem vai receber cobraças de atraso.
                       if(
                               (pModelTela.getLinha(i).getPagamento()==null) &&
                               (dataConta.after(datacompara))
                               )
                       {
                           existeAtraso++;
                           if(existeAtraso==1){sqlatrasadas+="\n c.id = " + pModelTela.getLinha(i).getNumeroconta();}
                           else               {sqlatrasadas+="\n or c.id = " + pModelTela.getLinha(i).getNumeroconta();}
                       }
                   }   
               }
               
               sqlnormal   += "\n group by c.id ";
               sqlatrasadas+= "\n group by c.id ";
               sqlCarne    += "\n group by c.id ";
               
               int messagem = 0;
               
               if(existeConta>0){
                   relatar("/relatorios/rc_novaConta.jasper", sqlnormal,"Normal");
                   messagem +=1;
               }
               if(existeAtraso>0){
                   relatar("/relatorios/rc_cobranca.jasper", sqlatrasadas ,"Cobraça");
                   messagem +=2;
               }
               if(existeCarne>0)
               {
                   relatar("/relatorios/rc_socio.jasper", sqlatrasadas ,"Socio");
                   messagem +=4;
               }
               switch(messagem)
               {
                  case 1:
                  break;
                  case 2:    
                  break;
                  case 4:
                  break;
                     
               }
               
               
           }
       };
      t.start();
      limparVariaveisDeImpressaoConta();
      
    }//GEN-LAST:event_jButtonExportarActionPerformed

    private void jButtonExportar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExportar1ActionPerformed
        pModelTela.limpar();
        contar();
    }//GEN-LAST:event_jButtonExportar1ActionPerformed

    private void jButtonExportar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExportar2ActionPerformed
      pModelBanco.limpar();
      contar();
    }//GEN-LAST:event_jButtonExportar2ActionPerformed

    private void jCheckBoxPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxPagamentoActionPerformed
        if(jCheckBoxPagamento.isSelected())
        {
            
        jCheckVencimento.setSelected(false);
        jDateVencimentoInicio.setDate(null);
        jDateVencimentoFim.setDate(null);
        
        jDateVencimentoInicio.setEnabled(false);
        jDateVencimentoFim.setEnabled(false);
        
        jDatePagamentoFim.setEnabled(true);
        jDatePagamentoInicio.setEnabled(true);
        
        jComboBoxLogradouro.setEnabled(false);
        jComboBoxSocio.setEnabled(false);
        jComboBoxStatus.setEnabled(false);
        
        jCheckSocio.setSelected(false);
        jCheckLogradouro.setSelected(false);
        jCheckStatus.setSelected(false);
       
        }
        else
        {
        jDatePagamentoFim.setEnabled(false);
        jDatePagamentoInicio.setEnabled(false);
        }
    }//GEN-LAST:event_jCheckBoxPagamentoActionPerformed

    private void jCheckVencimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckVencimentoActionPerformed
        if(jCheckVencimento.isSelected())
        {
        jCheckBoxPagamento.setSelected(false);
        jDatePagamentoInicio.setDate(null);
        jDatePagamentoFim.setDate(null);
        
        jDatePagamentoInicio.setEnabled(false);
        jDatePagamentoFim.setEnabled(false);
        
        jDateVencimentoInicio.setEnabled(true);
        jDateVencimentoFim.setEnabled(true);
        
        
        jComboBoxLogradouro.setEnabled(false);
        jComboBoxSocio.setEnabled(false);
        jComboBoxStatus.setEnabled(false);
        
        jCheckSocio.setSelected(false);
        jCheckLogradouro.setSelected(false);
        jCheckStatus.setSelected(false);
                
        }
        else
        {
        jDateVencimentoInicio.setEnabled(false);
        jDateVencimentoFim.setEnabled(false);    
        }
    }//GEN-LAST:event_jCheckVencimentoActionPerformed

    private void jCheckSocioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckSocioActionPerformed

       if(jCheckSocio.isSelected()){
          travarComponentes();
           
          jComboBoxSocio.setEnabled(true);
          if(jComboBoxSocio.getItemCount() == 0){
            jComboBoxSocio.addItem("");
            List<SociosView> socios= new DaoSocioView().BuscarTodosSociosView();
            for(SociosView s : socios){
                jComboBoxSocio.addItem(s.getNome());
            }                  
        }
      }
      else{
          jComboBoxSocio.setEnabled(false);
          jComboBoxSocio.setSelectedIndex(0);
      }
    }//GEN-LAST:event_jCheckSocioActionPerformed

    private void jCheckLogradouroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckLogradouroActionPerformed

        if(jCheckLogradouro.isSelected()){
           travarComponentes();
            jComboBoxLogradouro.setEnabled(true);
            if(jComboBoxLogradouro.getItemCount()==0){
                jComboBoxLogradouro.addItem("");
                List<EnderecoView> end = new DaoEnderecoView().BuscarTodosEnderecos();
                for(EnderecoView e : end){
                    jComboBoxLogradouro.addItem(e.getNome());
                }
            }
        }
        else{
        jComboBoxLogradouro.setEnabled(false);
        jComboBoxLogradouro.setSelectedIndex(0);
        }
    }//GEN-LAST:event_jCheckLogradouroActionPerformed

    private void jCheckStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckStatusActionPerformed
        if(jCheckStatus.isSelected())
        {
            travarComponentes();
            jComboBoxStatus.setEnabled(true);
        }
        else{
           jComboBoxStatus.setSelectedIndex(0);
            jComboBoxStatus.setEnabled(false);
        }
        
    }//GEN-LAST:event_jCheckStatusActionPerformed

    private void jDatePagamentoInicioMouseClicked(MouseEvent evt) {//GEN-FIRST:event_jDatePagamentoInicioMouseClicked
        jDatePagamentoInicio.setDate(new Date());
    }//GEN-LAST:event_jDatePagamentoInicioMouseClicked

    private void jDatePagamentoInicioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jDatePagamentoInicioFocusLost
        jDatePagamentoFim.setDate(jDatePagamentoInicio.getDate());
    }//GEN-LAST:event_jDatePagamentoInicioFocusLost

    private void jDateVencimentoInicioMouseClicked(MouseEvent evt) {//GEN-FIRST:event_jDateVencimentoInicioMouseClicked
        jDateVencimentoInicio.setDate(new Date());
        
    }//GEN-LAST:event_jDateVencimentoInicioMouseClicked

    private void jDateVencimentoInicioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jDateVencimentoInicioFocusGained
      jDateVencimentoFim.setDate(jDatePagamentoInicio.getDate());
    }//GEN-LAST:event_jDateVencimentoInicioFocusGained

    private void jDatePagamentoInicioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jDatePagamentoInicioFocusGained
       jDatePagamentoInicio.setDate(new Date());
    }//GEN-LAST:event_jDatePagamentoInicioFocusGained

    private void jButtonBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscar1ActionPerformed
       
       int i=0;
       while(pModelBanco.getRowCount()>=1){
           pModelTela.addLinha(pModelBanco.getLinha(i));
           pModelBanco.removeLinha(i);
       }
       contar();
    }//GEN-LAST:event_jButtonBuscar1ActionPerformed

    private void jComboBoxStatusKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBoxStatusKeyPressed
      
        buscar();
    }//GEN-LAST:event_jComboBoxStatusKeyPressed

    private void jComboBoxStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxStatusActionPerformed

    
    public void relatar(String relatorio, String sql, String tipoRelatorio){
    
      try 
        {   
         Connection conn = HibernateUtil.getConnection();
         Map<String, Object> p = new HashMap<>();
         
         p.put("complementos",sql);
         JasperPrint jasper = JasperFillManager.fillReport
         (getClass().getResourceAsStream(relatorio), p, conn);
         JasperViewer.viewReport(jasper, false);
        
        }
        catch (Exception ex) 
        {
         JOptionPane.showMessageDialog(null, "Erro: \nRélatorio "+tipoRelatorio+ " não pode ser emitido perfeitamente. \n "+sql);
         Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void buscar(){     

        pModelBanco.limpar();      
     
        //buscar por pagamento!
        if(jCheckBoxPagamento.isSelected()){
            
            if(jDatePagamentoInicio.getDate()==null){
              JOptionPane.showMessageDialog(null, "É preciso escolher o Pagamento inicial");
              jDatePagamentoInicio.requestFocus();
            }
            else if(jDatePagamentoFim.getDate()==null){
              JOptionPane.showMessageDialog(null, "É preciso escolher o Pagamento Final");
              jDatePagamentoFim.requestFocus();
            }
            
            else if(jDatePagamentoFim.getDate().before(jDatePagamentoInicio.getDate()) ){
              JOptionPane.showMessageDialog(null, "A data Final não pode ser Inferior a data Inicial");
            jDatePagamentoInicio.setDate(null);
            jDatePagamentoFim.setDate(null);
            jDatePagamentoInicio.requestFocus();
            }
            else {  
            pModelBanco.addListaDeConta(new DaoContaView().BuscarPagamento(jDatePagamentoInicio.getDate(), jDatePagamentoFim.getDate()));
            contar();
            }
        }
        
        //buscar por vencimento
        else if(jCheckVencimento.isSelected()){
        
            if(jDateVencimentoInicio.getDate()==null){
            JOptionPane.showMessageDialog(null, "É preciso escolher o Vencimento inicial");
            jDatePagamentoInicio.requestFocus();
            }
            else if(jDateVencimentoFim.getDate()==null){
            JOptionPane.showMessageDialog(null, "É preciso escolher o Vencimento Final");
            jDatePagamentoFim.requestFocus();
            }
            else if(jDateVencimentoFim.getDate().before(jDateVencimentoInicio.getDate()) ){
            JOptionPane.showMessageDialog(null, "A data Final não pode ser Inferior a data Inicial");
            jDateVencimentoInicio.setDate(null);
            jDateVencimentoFim.setDate(null);
            jDatePagamentoInicio.requestFocus();
            }
            else {
            pModelBanco.addListaDeConta(new DaoContaView().BuscarVencimento(jDateVencimentoInicio.getDate(), jDateVencimentoFim.getDate()));
            contar();
            }
        }
        //buscar por logradouro ou socio ou status
        else if(jCheckLogradouro.isSelected() || jCheckSocio.isSelected() || jCheckStatus.isSelected()){
     
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
                pModelBanco.addListaDeConta(new DaoCaixaView().BuscarSocioNome(jComboBoxSocio.getSelectedItem().toString()));
                contar();
                }
                break;
            case(checkLogradouro):
                if(jComboBoxLogradouro.getSelectedIndex()==0){
                 JOptionPane.showMessageDialog(null, "Escolha um endereco"); jComboBoxLogradouro.requestFocus();
                }
                else{
                pModelBanco.addListaDeConta(new DaoCaixaView().BuscarLogradouro(jComboBoxLogradouro.getSelectedItem().toString()));
                contar();
                }
                break;
            case(checkStatus):
                if  (jComboBoxStatus.getSelectedIndex()==0){
                    JOptionPane.showMessageDialog(null, "É preciso escolher a opção de status");
                    jComboBoxStatus.requestFocus();
                }
                else if (jComboBoxStatus.getSelectedIndex()==1){
                    pModelBanco.addListaDeConta(new DaoCaixaView().BuscarStatus(aberta));
                }
                else if (jComboBoxStatus.getSelectedIndex()==2){
                    pModelBanco.addListaDeConta(new DaoCaixaView().BuscarStatus(paga));
                }
                else if (jComboBoxStatus.getSelectedIndex()==3){
                    pModelBanco.addListaDeConta(new DaoCaixaView().BuscarStatus(vencida));
                }
                contar();
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
                   pModelBanco.addListaDeConta(new DaoCaixaView().BuscarSocioLogradouro(jComboBoxLogradouro.getSelectedItem().toString(),jComboBoxSocio.getSelectedItem().toString()));
                   contar();
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
                    if    (jComboBoxStatus.getSelectedIndex()==0){
                        JOptionPane.showMessageDialog(null,"Escolha um Status");
                        jComboBoxStatus.requestFocus();
                    }
                    else if(jComboBoxStatus.getSelectedIndex()==1){
                    
                        pModelBanco.addListaDeConta(new DaoCaixaView().BuscarSocioStatus(aberta, jComboBoxSocio.getSelectedItem().toString()));
                    }
                    else if(jComboBoxStatus.getSelectedIndex()==2){
                         pModelBanco.addListaDeConta(new DaoCaixaView().BuscarSocioStatus(paga, jComboBoxSocio.getSelectedItem().toString()));
                    }
                    else if(jComboBoxStatus.getSelectedIndex()==3){
                         pModelBanco.addListaDeConta(new DaoCaixaView().BuscarSocioStatus(vencida, jComboBoxSocio.getSelectedItem().toString()));
                    }
                    contar();
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
                        pModelBanco.addListaDeConta(new DaoCaixaView().BuscarLogradouroStatus(aberta, jComboBoxLogradouro.getSelectedItem().toString()));
                    }
                    else if(jComboBoxStatus.getSelectedIndex()==2){
                        pModelBanco.addListaDeConta(new DaoCaixaView().BuscarLogradouroStatus(paga, jComboBoxLogradouro.getSelectedItem().toString()));
                    }
                    else if(jComboBoxStatus.getSelectedIndex()==3){
                        pModelBanco.addListaDeConta(new DaoCaixaView().BuscarLogradouroStatus(vencida, jComboBoxLogradouro.getSelectedItem().toString()));
                    }
                    contar();
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
                        pModelBanco.addListaDeConta(new DaoCaixaView().BuscarTodosCriterios(aberta, jComboBoxSocio.getSelectedItem().toString(), jComboBoxLogradouro.getSelectedItem().toString()));
                    }
                    else if(jComboBoxStatus.getSelectedIndex()==2){
                        pModelBanco.addListaDeConta(new DaoCaixaView().BuscarTodosCriterios(paga, jComboBoxSocio.getSelectedItem().toString(), jComboBoxLogradouro.getSelectedItem().toString()));
                    }
                    else if(jComboBoxStatus.getSelectedIndex()==3){
                        pModelBanco.addListaDeConta(new DaoCaixaView().BuscarTodosCriterios(vencida, jComboBoxSocio.getSelectedItem().toString(), jComboBoxLogradouro.getSelectedItem().toString()));              
                    }
                    contar();
                }
                break;
            }
        }
        else{
        JOptionPane.showMessageDialog(null, "Escolha uma opção de busca.");
        }
        contar();    
        
        
    }
    
    public void cobraças()
    {
        pModelTela.limpar();
        pModelBanco.limpar();
        pModelBanco.addListaDeConta(new DaoContaView().BuscarContasAtrasadas60());
        
    }
   
    public void  travarComponentes(){
    jCheckBoxPagamento.setSelected(false);
    jCheckVencimento.setSelected(false);
    jDatePagamentoInicio.setEnabled(false);
    jDatePagamentoFim.setEnabled(false);
    jDatePagamentoInicio.setDate(null);
    jDatePagamentoFim.setDate(null);
    jDateVencimentoInicio.setEnabled(false);
    jDateVencimentoFim.setEnabled(false);
    jDateVencimentoInicio.setDate(null);
    jDateVencimentoFim.setDate(null);
    }
    
    private int setAtrasadas(int qtd){
        existeAtraso = qtd;
    return existeAtraso;
    }
    
    private int getAtrasadsa()
    {
    return existeAtraso;
    }
    
    private void limparVariaveisDeImpressaoConta(){
     sqlnormal    ="  ";
     sqlatrasadas ="  ";
     sqlCarne ="  ";
     existeCarne = 0;
     existeAtraso = 0;
    
    }
    public static void main(String args[]) {
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
            Logger.getLogger(TelaTabelaConta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(TelaTabelaConta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(TelaTabelaConta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            Logger.getLogger(TelaTabelaConta.class.getName()).log(Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TelaTabelaConta().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField jAbertasBanco;
    private javax.swing.JTextField jAbertasTela;
    private javax.swing.JTextField jAtrasadasBanco;
    private javax.swing.JTextField jAtrasadasTela;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonBuscar1;
    private javax.swing.JButton jButtonExportar;
    private javax.swing.JButton jButtonExportar1;
    private javax.swing.JButton jButtonExportar2;
    private javax.swing.JCheckBox jCheckBoxPagamento;
    private javax.swing.JCheckBox jCheckLogradouro;
    private javax.swing.JCheckBox jCheckSocio;
    private javax.swing.JCheckBox jCheckStatus;
    private javax.swing.JCheckBox jCheckVencimento;
    private javax.swing.JComboBox jComboBoxLogradouro;
    private javax.swing.JComboBox jComboBoxSocio;
    private javax.swing.JComboBox jComboBoxStatus;
    private com.toedter.calendar.JDateChooser jDatePagamentoFim;
    private com.toedter.calendar.JDateChooser jDatePagamentoInicio;
    private com.toedter.calendar.JDateChooser jDateVencimentoFim;
    private com.toedter.calendar.JDateChooser jDateVencimentoInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private JTable jTabBanco;
    private JTable jTabTela;
    private javax.swing.JTextField jTotalBanco;
    private javax.swing.JTextField jTotalTela;
    private javax.swing.JTextField jValorAtrasadasBanco;
    private javax.swing.JTextField jValorAtrasadasTela;
    private javax.swing.JTextField jValorTotalTela;
    private javax.swing.JTextField jValorTotalbanco;
    // End of variables declaration//GEN-END:variables

}
