package acal.telas.relatorios;

import acal.application.report.InvoiceReport;
import acal.commons.DateUtils;
import acal.dao.DaoCategoriaSocio;
import acal.dao.DaoEndereco;
import acal.dao.view.DaoSocioView;
import acal.domain.FindInvoice;
import acal.domain.StatusPaymentInvoice;
import acal.entidades.Categoriasocio;
import acal.entidades.Endereco;
import acal.entidades.SociosView;
import acal.report.create.ReportService;
import acal.report.model.ReportData;
import acal.resource.repository.InvoiceRepository;
import acal.telas.TelaPrincipal;
import lombok.val;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import static acal.commons.Report.NEW_INVOICE;

public final class TelaRelatoriosContas extends javax.swing.JFrame {

    private final int OPEN = 1;
    private final int CLOSED = 2;

    public TelaRelatoriosContas() {
        initComponents();
        travarComponentes();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel15 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jCheckBoxId = new JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        jTextFieldIdMaior = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldIdMenor = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jCheckBoxStatus = new JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        jComboBoxStatus = new javax.swing.JComboBox();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jCheckBoxData = new JCheckBox();
        jPanel6 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jFormattedTextFieldDataMenor = new com.toedter.calendar.JDateChooser();
        jFormattedTextFieldDataMaior = new com.toedter.calendar.JDateChooser();
        jPanel7 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jCheckBoxCategoria = new JCheckBox();
        jPanel9 = new javax.swing.JPanel();
        jComboBoxCategoria = new javax.swing.JComboBox();
        jPanel12 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jCheckBoxSocio = new JCheckBox();
        jPanel14 = new javax.swing.JPanel();
        jComboBoxSocio = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jCheckRegristro = new JCheckBox();
        jCheckData = new JCheckBox();
        jCheckCategoria = new JCheckBox();
        jCheckSocio = new JCheckBox();
        jCheckLogradouro = new JCheckBox();
        jPanel17 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jCheckBoxLogradouro = new JCheckBox();
        jPanel20 = new javax.swing.JPanel();
        jComboBoxLogradouro = new javax.swing.JComboBox();
        jPanel21 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jCheckBoxDataVecimento = new JCheckBox();
        jPanel23 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jDateVencimentoMenor = new com.toedter.calendar.JDateChooser();
        jDateVecimentoMaior = new com.toedter.calendar.JDateChooser();
        jPanel24 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jToggleButtonCarnePadrao = new javax.swing.JToggleButton();
        jToggleButtonCarnePadrao.setSelected(true);
        jToggleButtonCarneSocio = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel15.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Conta");

        jCheckBoxId.setText("Filtrar por Regristro");
        jCheckBoxId.setPreferredSize(new java.awt.Dimension(100, 23));
        jCheckBoxId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxIdActionPerformed(evt);
            }
        });

        jTextFieldIdMaior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIdMaiorActionPerformed(evt);
            }
        });

        jLabel7.setText("E");

        jLabel8.setText("Entre");

        jTextFieldIdMenor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIdMenorActionPerformed(evt);
            }
        });
        jTextFieldIdMenor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldIdMenorFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(97, Short.MAX_VALUE)
                                .addComponent(jLabel8)
                                .addGap(11, 11, 11)
                                .addComponent(jTextFieldIdMenor, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldIdMaior, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextFieldIdMaior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel7)
                                        .addComponent(jTextFieldIdMenor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBoxId, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addGap(54, 54, 54))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jCheckBoxId, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Status");

        jCheckBoxStatus.setText("Filtrar por Status");
        jCheckBoxStatus.setMaximumSize(new java.awt.Dimension(100, 23));
        jCheckBoxStatus.setMinimumSize(new java.awt.Dimension(100, 23));
        jCheckBoxStatus.setPreferredSize(new java.awt.Dimension(100, 23));
        jCheckBoxStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxStatusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
                jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jCheckBoxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel8Layout.setVerticalGroup(
                jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jCheckBoxStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );

        jComboBoxStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"", "Aberta", "Fechada", "Todas"}));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addContainerGap(162, Short.MAX_VALUE)
                                .addComponent(jComboBoxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(83, 83, 83))
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGap(0, 13, Short.MAX_VALUE)
                                .addComponent(jComboBoxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(54, 54, 54))
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setText("Data de Geração");

        jCheckBoxData.setText("Filtrar por Geracão");
        jCheckBoxData.setMaximumSize(new java.awt.Dimension(100, 23));
        jCheckBoxData.setMinimumSize(new java.awt.Dimension(100, 23));
        jCheckBoxData.setPreferredSize(new java.awt.Dimension(100, 23));
        jCheckBoxData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxDataActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
                jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jCheckBoxData, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
                jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jCheckBoxData, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                                .addGap(0, 0, 0))
        );

        jLabel11.setText("E");

        jLabel12.setText("Entre");

        jFormattedTextFieldDataMenor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jFormattedTextFieldDataMenorFocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                jFormattedTextFieldDataMenorFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFormattedTextFieldDataMenor, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFormattedTextFieldDataMaior, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jFormattedTextFieldDataMaior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jFormattedTextFieldDataMenor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel12)
                                        .addComponent(jLabel11))
                                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addGap(54, 54, 54))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                                .addGap(4, 4, 4)
                                                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setText("Categoria");

        jCheckBoxCategoria.setText("Filtrar por Categoria");
        jCheckBoxCategoria.setMaximumSize(new java.awt.Dimension(100, 23));
        jCheckBoxCategoria.setMinimumSize(new java.awt.Dimension(100, 23));
        jCheckBoxCategoria.setPreferredSize(new java.awt.Dimension(100, 23));
        jCheckBoxCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxCategoriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
                jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jCheckBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel11Layout.setVerticalGroup(
                jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jCheckBoxCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
                jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel9Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jComboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(107, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
                jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                .addContainerGap(13, Short.MAX_VALUE)
                                .addComponent(jComboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
                jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel7Layout.setVerticalGroup(
                jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addGap(54, 54, 54))
                        .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setText("Socio");

        jCheckBoxSocio.setText("Filtrar por Socio");
        jCheckBoxSocio.setMaximumSize(new java.awt.Dimension(100, 23));
        jCheckBoxSocio.setMinimumSize(new java.awt.Dimension(100, 23));
        jCheckBoxSocio.setPreferredSize(new java.awt.Dimension(100, 23));
        jCheckBoxSocio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxSocioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
                jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jCheckBoxSocio, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel13Layout.setVerticalGroup(
                jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jCheckBoxSocio, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
                jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel14Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jComboBoxSocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(106, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
                jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                                .addContainerGap(13, Short.MAX_VALUE)
                                .addComponent(jComboBoxSocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
                jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel12Layout.setVerticalGroup(
                jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addGap(54, 54, 54))
                        .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        jButton1.setText("Gerar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel16.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel16.setPreferredSize(new java.awt.Dimension(486, 50));

        jLabel6.setText("Ordernar");

        jCheckRegristro.setText("Regristro");
        jCheckRegristro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckRegristroActionPerformed(evt);
            }
        });

        jCheckData.setText("Data");
        jCheckData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckDataActionPerformed(evt);
            }
        });

        jCheckCategoria.setText("Categoria");
        jCheckCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckCategoriaActionPerformed(evt);
            }
        });

        jCheckSocio.setText("Socio");
        jCheckSocio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckSocioActionPerformed(evt);
            }
        });

        jCheckLogradouro.setText("Logradouro");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
                jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel18Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jCheckRegristro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(5, 5, 5)
                                .addComponent(jCheckData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(5, 5, 5)
                                .addComponent(jCheckCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(5, 5, 5)
                                .addComponent(jCheckSocio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckLogradouro)
                                .addGap(40, 40, 40))
        );
        jPanel18Layout.setVerticalGroup(
                jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel18Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jCheckRegristro)
                                        .addComponent(jCheckData)
                                        .addComponent(jCheckCategoria)
                                        .addComponent(jCheckSocio)
                                        .addComponent(jCheckLogradouro))
                                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
                jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
                jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel16Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel6)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel17.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel9.setText("Logradouro");

        jCheckBoxLogradouro.setText("Filtrar por Logradouro");
        jCheckBoxLogradouro.setMaximumSize(new java.awt.Dimension(100, 23));
        jCheckBoxLogradouro.setMinimumSize(new java.awt.Dimension(100, 23));
        jCheckBoxLogradouro.setPreferredSize(new java.awt.Dimension(100, 23));
        jCheckBoxLogradouro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxLogradouroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
                jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jCheckBoxLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel19Layout.setVerticalGroup(
                jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jCheckBoxLogradouro, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
                jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel20Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jComboBoxLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(106, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
                jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                                .addContainerGap(13, Short.MAX_VALUE)
                                .addComponent(jComboBoxLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
                jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel17Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel17Layout.setVerticalGroup(
                jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9)
                                .addGap(54, 54, 54))
                        .addGroup(jPanel17Layout.createSequentialGroup()
                                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel21.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel10.setText("Data de Vencimento");

        jCheckBoxDataVecimento.setText("Filtrar por Vencimento");
        jCheckBoxDataVecimento.setMaximumSize(new java.awt.Dimension(100, 23));
        jCheckBoxDataVecimento.setMinimumSize(new java.awt.Dimension(100, 23));
        jCheckBoxDataVecimento.setPreferredSize(new java.awt.Dimension(100, 23));
        jCheckBoxDataVecimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxDataVecimentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
                jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jCheckBoxDataVecimento, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel22Layout.setVerticalGroup(
                jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel22Layout.createSequentialGroup()
                                .addComponent(jCheckBoxDataVecimento, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                                .addGap(0, 0, 0))
        );

        jLabel13.setText("E");

        jLabel14.setText("Entre");

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
                jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateVencimentoMenor, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateVecimentoMaior, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
                jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel14)
                                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jDateVecimentoMaior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jDateVencimentoMenor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel13)))
                                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
                jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel21Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 204, Short.MAX_VALUE)
                                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel21Layout.setVerticalGroup(
                jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel21Layout.createSequentialGroup()
                                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel21Layout.createSequentialGroup()
                                                .addGap(4, 4, 4)
                                                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel10)
                                .addGap(54, 54, 54))
        );

        jPanel24.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel15.setText("Tipo de Carnê");

        jToggleButtonCarnePadrao.setText("Carnê Padrão");
        jToggleButtonCarnePadrao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonCarnePadraoActionPerformed(evt);
            }
        });

        jToggleButtonCarneSocio.setText("Carnê Socio");
        jToggleButtonCarneSocio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonCarneSocioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
                jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel24Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jToggleButtonCarnePadrao, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(jToggleButtonCarneSocio, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20))
        );
        jPanel24Layout.setVerticalGroup(
                jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel24Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel15)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jToggleButtonCarnePadrao)
                                        .addComponent(jToggleButtonCarneSocio))
                                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
                jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel15Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE)
                                        .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
                jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBoxIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxIdActionPerformed

        if (jCheckBoxId.isSelected()) {
            jTextFieldIdMaior.setEditable(true);
            jTextFieldIdMenor.setEditable(true);
        } else {
            jTextFieldIdMaior.setText("");
            jTextFieldIdMenor.setText("");
            jTextFieldIdMaior.setEditable(false);
            jTextFieldIdMenor.setEditable(false);
        }
    }//GEN-LAST:event_jCheckBoxIdActionPerformed

    private void jTextFieldIdMaiorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIdMaiorActionPerformed

    }//GEN-LAST:event_jTextFieldIdMaiorActionPerformed

    private void jTextFieldIdMenorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIdMenorActionPerformed

    }//GEN-LAST:event_jTextFieldIdMenorActionPerformed

    private void jCheckBoxDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxDataActionPerformed

        if (jCheckBoxData.isSelected()) {
            jFormattedTextFieldDataMaior.setEnabled(true);
            jFormattedTextFieldDataMenor.setEnabled(true);
        } else {

            jFormattedTextFieldDataMaior.setDate(new Date());
            jFormattedTextFieldDataMenor.setDate(null);
            jFormattedTextFieldDataMaior.setEnabled(false);
            jFormattedTextFieldDataMenor.setEnabled(false);
        }
    }//GEN-LAST:event_jCheckBoxDataActionPerformed

    private void jCheckBoxCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxCategoriaActionPerformed

        if (jCheckBoxCategoria.isSelected()) {
            jComboBoxCategoria.setEnabled(true);

            if (jComboBoxCategoria.getItemCount() == 0) {
                jComboBoxCategoria.addItem("");
                List<Categoriasocio> f = new DaoCategoriaSocio().BuscarTodasCategorias();
                for (Categoriasocio funcs : f) {
                    jComboBoxCategoria.addItem(funcs.getNome());
                }
            }

        } else {
            jComboBoxCategoria.setEnabled(false);
            jComboBoxCategoria.setSelectedIndex(0);
        }
    }//GEN-LAST:event_jCheckBoxCategoriaActionPerformed

    private void jCheckBoxSocioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxSocioActionPerformed
        if (jCheckBoxSocio.isSelected()) {
            jComboBoxSocio.setEnabled(true);

            if (jComboBoxSocio.getItemCount() == 0) {

                jComboBoxSocio.addItem("");
                List<SociosView> s = new DaoSocioView().BuscarTodosSociosView();
                for (SociosView scs : s) {
                    jComboBoxSocio.addItem(scs.getNome());
                }
            }

        } else {
            jComboBoxSocio.setEnabled(false);
            jComboBoxSocio.setSelectedIndex(0);
        }
    }//GEN-LAST:event_jCheckBoxSocioActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        if (
                preencidoCheckBox(jCheckBoxId, jTextFieldIdMenor.getText(), jTextFieldIdMaior.getText()) &&
                        preencidoCheckBoxDate(jCheckBoxData, jFormattedTextFieldDataMenor.getDate(), jFormattedTextFieldDataMaior.getDate()) &&
                        preencidoCombobox(jCheckBoxStatus, (String) jComboBoxStatus.getSelectedItem()) &&
                        preencidoCombobox(jCheckBoxSocio, (String) jComboBoxSocio.getSelectedItem()) &&
                        preencidoCombobox(jCheckBoxCategoria, (String) jComboBoxCategoria.getSelectedItem()) &&
                        preencidoCheckBoxDate(jCheckBoxDataVecimento, jDateVencimentoMenor.getDate(), jDateVecimentoMaior.getDate()) &&
                        preencidoTipoCarne(jToggleButtonCarnePadrao.isSelected(), jToggleButtonCarneSocio.isSelected())
        ) {
            new Thread() {
                @Override
                @SuppressWarnings("empty-statement")
                public void run() {

                    FindInvoice find = createFilter();

                    try {
                        val invoices = new InvoiceRepository().find(find).stream().map(InvoiceReport::adapter).toList();
                        Map<String, Object> map = new HashMap<>();
                        map.put("SUBREPORT_DIR", getPath());

                        val report = ReportData.builder()
                                .report(NEW_INVOICE)
                                .param(map)
                                .dataSource(new JRBeanCollectionDataSource(invoices))
                                .build();

                        new ReportService().create(report);

                    } catch (Exception ex) {
                        Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }.start();
        } else {
            JOptionPane.showMessageDialog(null, "você deve preencer corretamente os campos escolhidos");
            if (!preencidoTipoCarne(jToggleButtonCarnePadrao.isSelected(), jToggleButtonCarneSocio.isSelected())) {
                JOptionPane.showMessageDialog(null, "Escolha Entre Carnê para Socio ou Carnê Padrão");
            }
        }
    }

    private FindInvoice createFilter() {
        val find = new FindInvoice();

        if (jCheckBoxId.isSelected()) {
            find.setEndId(jTextFieldIdMaior.getText());
            find.setStartId(jTextFieldIdMenor.getText());
        }

        if (jCheckBoxStatus.isSelected()) {
            if (jComboBoxStatus.getSelectedIndex() == OPEN) {
                find.setStatus(StatusPaymentInvoice.OPEN);
            }
            if (jComboBoxStatus.getSelectedIndex() == CLOSED) {
                find.setStatus(StatusPaymentInvoice.CLOSED);

            }
        }

        if (jCheckBoxData.isSelected()) {
            find.setCreatedAtStart(DateUtils.from(jFormattedTextFieldDataMenor.getDate()));
            find.setCreatedAtEnd(DateUtils.from(jFormattedTextFieldDataMaior.getDate()));
        }

        if (jCheckBoxDataVecimento.isSelected()) {
            find.setDuoDateStart(DateUtils.from(jDateVencimentoMenor.getDate()));
            find.setDuoDateEnd(DateUtils.from(jDateVencimentoMenor.getDate()));
        }

        if (jCheckBoxCategoria.isSelected()) {
            find.setCategoria(jComboBoxCategoria.getSelectedItem().toString());
        }

        if (jCheckBoxSocio.isSelected()) {
            find.setSocioNome(jComboBoxSocio.getSelectedItem().toString());
        }
        if (jCheckBoxLogradouro.isSelected()) {
            find.setLogradouro(jComboBoxLogradouro.getSelectedItem().toString());
        }
        if (jToggleButtonCarnePadrao.isSelected()) {

        }

        return find;
    }

    private String getPath() throws URISyntaxException {
        return Paths.get(getClass().getResource("/report/invoice").toURI()).toString();
    }

    private void jCheckRegristroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckRegristroActionPerformed

        jCheckData.setSelected(false);
        jCheckSocio.setSelected(false);
        jCheckCategoria.setSelected(false);

    }//GEN-LAST:event_jCheckRegristroActionPerformed

    private void jCheckDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckDataActionPerformed

        jCheckRegristro.setSelected(false);
        jCheckSocio.setSelected(false);
        jCheckCategoria.setSelected(false);

    }//GEN-LAST:event_jCheckDataActionPerformed

    private void jCheckCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckCategoriaActionPerformed
        jCheckRegristro.setSelected(false);
        jCheckData.setSelected(false);
        jCheckSocio.setSelected(false);

    }//GEN-LAST:event_jCheckCategoriaActionPerformed

    private void jCheckSocioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckSocioActionPerformed
        jCheckRegristro.setSelected(false);
        jCheckData.setSelected(false);
        jCheckCategoria.setSelected(false);

    }//GEN-LAST:event_jCheckSocioActionPerformed

    private void jCheckBoxLogradouroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxLogradouroActionPerformed
        if (jCheckBoxLogradouro.isSelected()) {
            jComboBoxLogradouro.setEnabled(true);

            if (jComboBoxLogradouro.getItemCount() == 0) {
                jComboBoxLogradouro.addItem("");
                List<Endereco> s = new DaoEndereco().BuscarTodosEnderecos();
                for (Endereco scs : s) {
                    jComboBoxLogradouro.addItem(scs.getTipo() + " " + scs.getNome());
                }
            }

        } else {
            jComboBoxLogradouro.setEnabled(false);
            jComboBoxLogradouro.setSelectedIndex(0);
        }
    }//GEN-LAST:event_jCheckBoxLogradouroActionPerformed

    private void jCheckBoxDataVecimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxDataVecimentoActionPerformed
        if (jCheckBoxDataVecimento.isSelected()) {
            jDateVencimentoMenor.setEnabled(true);
            jDateVecimentoMaior.setEnabled(true);
        } else {
            //   SimpleDateFormat.getDateInstance().parse(jFormattedTextFieldDataMaior.getText());
            jDateVencimentoMenor.setDate(null);
            jDateVecimentoMaior.setDate(null);
            jDateVencimentoMenor.setEnabled(false);
            jDateVecimentoMaior.setEnabled(false);
        }
    }//GEN-LAST:event_jCheckBoxDataVecimentoActionPerformed

    private void jCheckBoxStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxStatusActionPerformed
        jComboBoxStatus.setEnabled(jCheckBoxStatus.isSelected());

    }//GEN-LAST:event_jCheckBoxStatusActionPerformed

    private void jTextFieldIdMenorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldIdMenorFocusLost
        jTextFieldIdMaior.setText(jTextFieldIdMenor.getText());
    }//GEN-LAST:event_jTextFieldIdMenorFocusLost

    private void jFormattedTextFieldDataMenorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFormattedTextFieldDataMenorFocusGained
        jDateVencimentoMenor.setDate(new Date());
    }//GEN-LAST:event_jFormattedTextFieldDataMenorFocusGained

    private void jFormattedTextFieldDataMenorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFormattedTextFieldDataMenorFocusLost
        jDateVecimentoMaior.setDate(jDateVencimentoMenor.getDate());
    }//GEN-LAST:event_jFormattedTextFieldDataMenorFocusLost

    private void jToggleButtonCarneSocioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonCarneSocioActionPerformed
        jToggleButtonCarnePadrao.setSelected(false);
    }//GEN-LAST:event_jToggleButtonCarneSocioActionPerformed

    private void jToggleButtonCarnePadraoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonCarnePadraoActionPerformed
        jToggleButtonCarneSocio.setSelected(false);
    }//GEN-LAST:event_jToggleButtonCarnePadraoActionPerformed

    public boolean preencidoCombobox(JCheckBox check, String string) {
        boolean test;
        if (check.isSelected()) {
            test = !string.equals("");
        } else {
            test = true;
        }
        return test;
    }

    public boolean preencidoCheckBox(JCheckBox check, String a, String b) {

        boolean test;

        if (check.isSelected()) {
            test = !a.equals("") && !b.equals("");
        } else {
            test = true;
        }
        return test;
    }

    public boolean preencidoCheckBoxDate(JCheckBox check, Date a, Date b) {

        boolean test;

        if (check.isSelected()) {
            test = a != null && b != null;
        } else {
            test = true;
        }
        return test;
    }

    public boolean preencidoTipoCarne(boolean a, boolean b) {
        return a || b;
    }

    public void travarComponentes() {
        jComboBoxLogradouro.setEnabled(false);
        jComboBoxStatus.setEnabled(false);
        jTextFieldIdMenor.setEditable(false);
        jTextFieldIdMaior.setEditable(false);
        jDateVencimentoMenor.setEnabled(false);
        jDateVecimentoMaior.setEnabled(false);
        jFormattedTextFieldDataMenor.setEnabled(false);
        jFormattedTextFieldDataMaior.setEnabled(false);
        jComboBoxCategoria.setEnabled(false);
        jComboBoxSocio.setEnabled(false);
    }


    /**
     * @param args the command line arguments
     */


    public static void main(String[] args) {
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
            Logger.getLogger(TelaRelatoriosContas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(TelaRelatoriosContas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(TelaRelatoriosContas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            Logger.getLogger(TelaRelatoriosContas.class.getName()).log(Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaRelatoriosContas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private JCheckBox jCheckBoxCategoria;
    private JCheckBox jCheckBoxData;
    private JCheckBox jCheckBoxDataVecimento;
    private JCheckBox jCheckBoxId;
    private JCheckBox jCheckBoxLogradouro;
    private JCheckBox jCheckBoxSocio;
    private JCheckBox jCheckBoxStatus;
    private JCheckBox jCheckCategoria;
    private JCheckBox jCheckData;
    private JCheckBox jCheckLogradouro;
    private JCheckBox jCheckRegristro;
    private JCheckBox jCheckSocio;
    private javax.swing.JComboBox jComboBoxCategoria;
    private javax.swing.JComboBox jComboBoxLogradouro;
    private javax.swing.JComboBox jComboBoxSocio;
    private javax.swing.JComboBox jComboBoxStatus;
    private com.toedter.calendar.JDateChooser jDateVecimentoMaior;
    private com.toedter.calendar.JDateChooser jDateVencimentoMenor;
    private com.toedter.calendar.JDateChooser jFormattedTextFieldDataMaior;
    private com.toedter.calendar.JDateChooser jFormattedTextFieldDataMenor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextField jTextFieldIdMaior;
    private javax.swing.JTextField jTextFieldIdMenor;
    private javax.swing.JToggleButton jToggleButtonCarnePadrao;
    private javax.swing.JToggleButton jToggleButtonCarneSocio;
    // End of variables declaration//GEN-END:variables
}
