package br.org.acal.application.telas;

import java.awt.*;
import java.awt.Component;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;
import javax.swing.border.*;
import br.org.acal.resouces.dao.DaoCategoriaSocio;
import br.org.acal.resouces.dao.DaoCheque;
import br.org.acal.resouces.dao.DaoEndereco;
import br.org.acal.resouces.dao.DaoEnderecoPessoa;
import br.org.acal.resouces.dao.DaoEntradas;
import br.org.acal.resouces.dao.DaoFuncionario;
import br.org.acal.resouces.dao.DaoMotivoDespesa;
import br.org.acal.resouces.dao.DaoMotivoEntrada;
import br.org.acal.resouces.dao.DaoPessoa;
import br.org.acal.resouces.dao.DaoSaidas;
import br.org.acal.resouces.dao.DaoSocio;
import br.org.acal.resouces.dao.DaoTaxa;
import br.org.acal.resouces.dao.view.DaoSocioView;
import br.org.acal.resouces.entidades.Categoriasocio;
import br.org.acal.resouces.entidades.Cheque;
import br.org.acal.resouces.entidades.Endereco;
import br.org.acal.resouces.entidades.Enderecopessoa;
import br.org.acal.resouces.entidades.Entrada;
import br.org.acal.resouces.entidades.Funcionario;
import br.org.acal.resouces.entidades.Motivodespesa;
import br.org.acal.resouces.entidades.Motivoentrada;
import br.org.acal.resouces.entidades.Pessoa;
import br.org.acal.resouces.entidades.Saida;
import br.org.acal.resouces.entidades.Socio;
import br.org.acal.resouces.entidades.SociosView;
import br.org.acal.resouces.entidades.Taxa;
import br.org.acal.resouces.entidades.Sociotabela;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.beans.PropertyVetoException;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.toedter.calendar.*;

public class TelaCadastros extends JFrame {

    private JFrame telaPrincipal;
    private String pesquisarTable = "";
    private boolean flagEditar = false;
    private String socioNumero= "";
    private boolean cadastrar;
    public TelaCadastros() {

        initComponents();
        editableTextFields(false);
        setEditableComponentesLogradouros(false);
        setEditableComponentesTaxas(false);
        setEditableComponentesSocio(false);
        setEditableComponentesCategoriaSocio(false);
        setEditableComponentesTipoDespesa(false);
        setEditableComponentesDespesa(false);
        setEditableComponentesTipoReceita(false);
        setEditableComponentesReceita(false);
        setEditableComponentesCheques(false);
        jDesktopPane1.setVisible(false);
        jInternalFrame1.setVisible(false);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        jFormattedCNPJ.setEditable(false);
        jRadioCPFCNPJ.setEnabled(false);
        jCheckBoxExclusivamenteSocio.setEnabled(false);
        jCheckBoxReceitaAvulsa.setEnabled(cadastrar);
    }

    public TelaCadastros(JFrame telaPrincipal) {

        this();
        this.telaPrincipal = telaPrincipal;
        this.telaPrincipal.setEnabled(false);
        
    }

    public TelaCadastros(JFrame telaPrincipal, ActionEvent evt) {

        this(telaPrincipal);

        switch (evt.getActionCommand()) {

            case "Funcionarios":
                jTabbedPane1.setSelectedComponent(jPanelFunc);
                break;
            case "Logradouro":
                jTabbedPane1.setSelectedComponent(jPanelLog);
                break;
            case "Receitas":
                jTabbedPane1.setSelectedComponent(jPanelReceitas);
                break;
            case "Contas a Pagar":
                jTabbedPane1.setSelectedComponent(jPanelReceitas);
                break;
            case "Categoria Socio":
                jTabbedPane1.setSelectedComponent(jPanelCategoriaSocio);
                break;
            case "Socio":
                jTabbedPane1.setSelectedComponent(jPanelSocio);
                break;
            case "Tipo de Despesa":
                jTabbedPane1.setSelectedComponent(jPanelTipoDespesa);
                break;
            case "Despesa":
                jTabbedPane1.setSelectedComponent(jPanelDespesa);
                break;
            case "Tipo de Receita":
                jTabbedPane1.setSelectedComponent(jPanelTipoReceita);
                break;
            case "Receita":
                jTabbedPane1.setSelectedComponent(jPanelReceitas);
                break;
            case "Taxas":
                jTabbedPane1.setSelectedComponent(jPanelTaxas);
                break;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    // Generated using JFormDesigner non-commercial license
    private void initComponents() {
        jPanel1 = new JPanel();
        jTabbedPane1 = new JTabbedPane();
        jPanelLog = new JPanel();
        jPanel20 = new JPanel();
        jPanel41 = new JPanel();
        jPanel40 = new JPanel();
        jButtonLogradouroNovo = new JButton();
        jButtonLogradouroEditar = new JButton();
        jButtonLogradouroApagar = new JButton();
        jButtonLogradouroSalvar = new JButton();
        jButtonLogradouroCancelar = new JButton();
        jPanel6 = new JPanel();
        jScrollPane1 = new JScrollPane();
        jTextAreaLogradouroDescricao = new JTextArea();
        jLabel3 = new JLabel();
        jLabel1 = new JLabel();
        jComboBoxLogradouroTipo = new JComboBox();
        jTextFieldLogradouroNome = new JTextField();
        jLabel2 = new JLabel();
        jPanel44 = new JPanel();
        jButtonLogradouroPesquisar = new JButton();
        jTextFieldLogradouroID = new JTextField();
        jLabel32 = new JLabel();
        jPanelFunc = new JPanel();
        jPanel21 = new JPanel();
        jPanel5 = new JPanel();
        Logradouro4 = new JLabel();
        Logradouro5 = new JLabel();
        Logradouro6 = new JLabel();
        Logradouro7 = new JLabel();
        jScrollPane2 = new JScrollPane();
        jTextAreaFuncionarioObservacoes = new JTextArea();
        jTextFieldFuncionarioCargo = new JTextField();
        jTextFieldFuncionarioSalario = new JTextField();
        jFormattedTextFieldFuncionarioDataContratacao = new JFormattedTextField();
        jPanel4 = new JPanel();
        Logradouro1 = new JLabel();
        Logradouro3 = new JLabel();
        jTextFieldFuncionarioNumeroDaMatricula = new JTextField();
        jComboBoxFuncionarioStatus = new JComboBox();
        jButtonFuncionarioEditar = new JButton();
        jButtonFuncionarioApagar = new JButton();
        jButtonFuncionarioSalvar = new JButton();
        jButtonFuncionarioNovo = new JButton();
        jButtonFuncionarioCancelar = new JButton();
        jPanel3 = new JPanel();
        jComboBoxFuncionarioLograduro = new JComboBox<>();
        jLabel8 = new JLabel();
        jTextFieldFuncionarioNumero = new JTextField();
        jLabel9 = new JLabel();
        jTextFieldFuncionarioBairro = new JTextField();
        jLabel10 = new JLabel();
        jTextFieldFuncionarioCidade = new JTextField();
        jLabel11 = new JLabel();
        jLabel12 = new JLabel();
        jTextFieldFuncionarioCep = new JTextField();
        Logradouro = new JLabel();
        jComboBoxFuncionarioUf = new JComboBox();
        jButton2 = new JButton();
        jPanel2 = new JPanel();
        jLabel6 = new JLabel();
        jLabel5 = new JLabel();
        jTextFieldFuncionarioNome = new JTextField();
        jTextFieldFuncionarioSobrenome = new JTextField();
        jTextFieldFuncionarioApelido = new JTextField();
        jLabel7 = new JLabel();
        jSeparator1 = new JSeparator();
        jLabel18 = new JLabel();
        jTextFieldFuncionarioID = new JTextField();
        jButtonFuncionarioPesquisar = new JButton();
        jPanel47 = new JPanel();
        jTextFieldFuncionarioRgnumero = new JTextField();
        jFormattedTextFieldFuncionarioCpf = new JFormattedTextField();
        jTextFieldFuncionarioNomedopai = new JTextField();
        jTextFieldFuncionarioNomedame = new JTextField();
        jFormattedTextFieldFuncionarioDataNascimento = new JFormattedTextField();
        jTextFieldFuncionarioTelefone = new JTextField();
        jLabel4 = new JLabel();
        jLabel14 = new JLabel();
        jLabel16 = new JLabel();
        jLabel27 = new JLabel();
        jLabel20 = new JLabel();
        jLabel21 = new JLabel();
        jPanel57 = new JPanel();
        jLabel19 = new JLabel();
        jLabel13 = new JLabel();
        jTextFieldFuncionarioEmail = new JTextField();
        jComboBoxFuncionarioSexo = new JComboBox();
        jLabel22 = new JLabel();
        jLabel24 = new JLabel();
        jFormattedTextFieldFuncionarioDataEmissao = new JFormattedTextField();
        jTextFieldFuncionarioOrgaoExpedidor = new JTextField();
        jPanelCategoriaSocio = new JPanel();
        jPanel30 = new JPanel();
        jPanel43 = new JPanel();
        jPanel10 = new JPanel();
        jButtonCategoriaSocioNovo = new JButton();
        jButtonCategoriaSocioEditar = new JButton();
        jButtonCategoriaSocioSalvar = new JButton();
        jButtonCategoriaSocioApagar = new JButton();
        jButtonCategoriaSocioCancelar = new JButton();
        jPanel7 = new JPanel();
        jLabel34 = new JLabel();
        jTextFieldCategoriaSocioNome = new JTextField();
        jLabel35 = new JLabel();
        jScrollPane5 = new JScrollPane();
        jTextAreaCategoriaSocioDescricao = new JTextArea();
        jLabel36 = new JLabel();
        jComboBoxCategoriaSocioTaxa = new JComboBox<>();
        jPanel42 = new JPanel();
        jButtonCategoriaSocioPesquisar = new JButton();
        jTextFieldCategoriaSocioID = new JTextField();
        jLabel33 = new JLabel();
        jPanelTipoDespesa = new JPanel();
        jPanel31 = new JPanel();
        jPanel24 = new JPanel();
        jLabel37 = new JLabel();
        jLabel38 = new JLabel();
        jLabel39 = new JLabel();
        jTextFieldTipoDespesaNome = new JTextField();
        jScrollPane6 = new JScrollPane();
        jTextAreaTipoDespesaDescricao = new JTextArea();
        jScrollPane7 = new JScrollPane();
        jTextAreaTipoDespesaObservacao = new JTextArea();
        jPanel45 = new JPanel();
        jLabel40 = new JLabel();
        jTextFieldTIpoDespesaID = new JTextField();
        jButtonTipoDespesaPesquisar = new JButton();
        jPanel11 = new JPanel();
        jButtonTipoDespesaNovo = new JButton();
        jButtonTipoDespesaEditar = new JButton();
        jButtonTipoDespesaSalvar = new JButton();
        jButtonTipoDespesaApagar = new JButton();
        jButtonTipoDespesaCancelar = new JButton();
        jPanelDespesa = new JPanel();
        jPanel32 = new JPanel();
        jPanel53 = new JPanel();
        jPanel12 = new JPanel();
        jButtonDespesaNovo = new JButton();
        jButtonDespesaEditar = new JButton();
        jButtonDespesaSalvar = new JButton();
        jButtonDespesaApagar = new JButton();
        jButtonDespesaCancelar = new JButton();
        jPanel25 = new JPanel();
        jLabel42 = new JLabel();
        jLabel44 = new JLabel();
        jScrollPane9 = new JScrollPane();
        jTextAreaDespesaObservacao = new JTextArea();
        jLabel47 = new JLabel();
        jLabel48 = new JLabel();
        jTextFieldDespesaValor = new JTextField();
        jComboBoxDespesaMotivo = new JComboBox<>();
        jLabel49 = new JLabel();
        jLabel50 = new JLabel();
        jTextFieldDespesaFavorecido = new JTextField();
        jFormattedTextFieldDespesaData = new JFormattedTextField();
        jComboBoxDespesaFuncionario = new JComboBox<>();
        jPanel46 = new JPanel();
        jButtonDespesaPesquisar = new JButton();
        jLabel45 = new JLabel();
        jTextFieldDespesaID = new JTextField();
        jPanelTipoReceita = new JPanel();
        jPanel33 = new JPanel();
        jPanel49 = new JPanel();
        jPanel14 = new JPanel();
        jButtonTipoReceitaNovo = new JButton();
        jButtonTipoReceitaEditar = new JButton();
        jButtonTipoReceitaSalvar = new JButton();
        jButtonTipoReceitaApagar = new JButton();
        jButtonTipoReceitaCancelar = new JButton();
        jPanel26 = new JPanel();
        jLabel51 = new JLabel();
        jLabel53 = new JLabel();
        jLabel54 = new JLabel();
        jTextFieldTipoReceitaNome = new JTextField();
        jScrollPane10 = new JScrollPane();
        jTextAreaTipoReceitaDescricao = new JTextArea();
        jScrollPane11 = new JScrollPane();
        jTextAreaTipoReceitaObservacao = new JTextArea();
        jPanel48 = new JPanel();
        jButtonTipoReceitaPesquisar = new JButton();
        jLabel55 = new JLabel();
        jTextFieldTIpoReceitaID = new JTextField();
        jPanelReceitas = new JPanel();
        jPanel34 = new JPanel();
        jPanel51 = new JPanel();
        jPanel8 = new JPanel();
        jButtonReceitaNovo = new JButton();
        jButtonReceitaEditar = new JButton();
        jButtonReceitaSalvar = new JButton();
        jButtonReceitaApagar = new JButton();
        jButtonReceitaCancelar = new JButton();
        jPanel27 = new JPanel();
        jLabel43 = new JLabel();
        jLabel46 = new JLabel();
        jScrollPane12 = new JScrollPane();
        jTextAreaReceitaObservacao = new JTextArea();
        jLabel58 = new JLabel();
        jLabel59 = new JLabel();
        jTextFieldReceitaValor = new JTextField();
        jComboBoxReceitaMotivoEntrada = new JComboBox<>();
        jLabel60 = new JLabel();
        jLabel61 = new JLabel();
        jComboBoxReceitaSocio = new JComboBox<>();
        jComboBoxReceitaFuncionario = new JComboBox<>();
        jPanel50 = new JPanel();
        jLabel57 = new JLabel();
        jTextFieldReceitaID = new JTextField();
        jButtonReceitaPesquisar = new JButton();
        jDateChooser1 = new JDateChooser();
        jCheckBoxReceitaAvulsa = new JCheckBox();
        jPanelCheques = new JPanel();
        jPanel35 = new JPanel();
        jPanel16 = new JPanel();
        jButtonChequeNovo = new JButton();
        jButtonChequeEditar = new JButton();
        jButtonChequeSalvar = new JButton();
        jButtonChequeApagar = new JButton();
        jButtonChequeCancelar = new JButton();
        jPanel15 = new JPanel();
        jLabel28 = new JLabel();
        jTextFieldChequeValor = new JTextField();
        jLabel29 = new JLabel();
        jLabel30 = new JLabel();
        jLabel62 = new JLabel();
        jLabel63 = new JLabel();
        jComboBoxChequeMotivoDespesa = new JComboBox<>();
        jLabel64 = new JLabel();
        jTextFieldChequeNumero = new JTextField();
        jScrollPane8 = new JScrollPane();
        jTextAreaChequeObservacoes = new JTextArea();
        jLabel65 = new JLabel();
        jComboBoxChequeFuncionario = new JComboBox<>();
        jFormattedTextFieldChequeDataVencimento = new JFormattedTextField();
        jFormattedTextFieldChequeDataPagamento = new JFormattedTextField();
        jPanel52 = new JPanel();
        jLabel26 = new JLabel();
        jTextFieldChequeID = new JTextField();
        jButtonChequePesquisar = new JButton();
        jPanelTaxas = new JPanel();
        jPanel22 = new JPanel();
        jPanel55 = new JPanel();
        jPanel18 = new JPanel();
        jButtonTaxaNovo = new JButton();
        jButtonTaxaEditar = new JButton();
        jButtonTaxaSalvar = new JButton();
        jButtonTaxaApagar = new JButton();
        jButtonTaxaCancelar = new JButton();
        jPanel13 = new JPanel();
        jLabel17 = new JLabel();
        jLabel23 = new JLabel();
        jLabel25 = new JLabel();
        jTextFieldTaxasNome = new JTextField();
        jTextFieldTaxasValor = new JTextField();
        jScrollPane3 = new JScrollPane();
        jTextAreaTaxasDescricao = new JTextArea();
        jPanel54 = new JPanel();
        jButtonTaxasPesquisar = new JButton();
        jTextFieldTaxasID = new JTextField();
        jLabel15 = new JLabel();
        jPanelSocio = new JPanel();
        jPanel17 = new JPanel();
        jPanel56 = new JPanel();
        jPanel9 = new JPanel();
        jButtonSocioNovo = new JButton();
        jButtonSocioEditar = new JButton();
        jButtonSocioSalvar = new JButton();
        jButtonSocioApagar = new JButton();
        jButtonSocioCancelar = new JButton();
        jButton1 = new JButton();
        jPanel29 = new JPanel();
        jLabel85 = new JLabel();
        jLabel86 = new JLabel();
        jLabel87 = new JLabel();
        jLabel88 = new JLabel();
        jLabel89 = new JLabel();
        jComboBoxSocioCategoriaSocio = new JComboBox<>();
        jTextFieldSocioNumeroSocio = new JTextField();
        jFormattedTextFieldSocioDiaVencimento = new JFormattedTextField();
        jRadioButtonSocioAtivo = new JRadioButton();
        jRadioButtonSocioInativo = new JRadioButton();
        jFormattedTextFieldSocioDataMatricula = new JFormattedTextField();
        jPanel28 = new JPanel();
        jComboBoxSocioLogradouro = new JComboBox<>();
        jLabel80 = new JLabel();
        jTextFieldSocioNumero = new JTextField();
        jLabel81 = new JLabel();
        jTextFieldSocioBairro = new JTextField();
        jLabel82 = new JLabel();
        jLabel83 = new JLabel();
        jLabel84 = new JLabel();
        jTextFieldSocioCEP = new JTextField();
        Logradouro2 = new JLabel();
        jComboBoxSocioUF = new JComboBox();
        jButtonSocioAdicionarLogradouro = new JButton();
        jTextFieldSocioCep2 = new JFormattedTextField();
        jPanel23 = new JPanel();
        jSeparator4 = new JSeparator();
        jPanel36 = new JPanel();
        jLabel70 = new JLabel();
        jTextFieldSocioEmail = new JTextField();
        jLabel74 = new JLabel();
        jComboBoxSocioSexo = new JComboBox();
        jLabel79 = new JLabel();
        jLabel72 = new JLabel();
        jTextFieldSocioNomeMae = new JTextField();
        jTextFieldSocioNomePai = new JTextField();
        jPanel37 = new JPanel();
        jTextFieldSocioNome = new JTextField();
        jTextFieldSocioSobrenome = new JTextField();
        jTextFieldSocioApelido = new JTextField();
        jTextFieldSocioTelefone = new JTextField();
        jLabel67 = new JLabel();
        jLabel66 = new JLabel();
        jLabel68 = new JLabel();
        jLabel69 = new JLabel();
        jLabel71 = new JLabel();
        jFormattedTextFieldSocioDataNascimento = new JFormattedTextField();
        jPanel38 = new JPanel();
        jButtonSocioPesquisar = new JButton();
        jTextFieldSocioID = new JTextField();
        jLabel73 = new JLabel();
        jPanel39 = new JPanel();
        jFormattedTextFieldSocioCPF = new JFormattedTextField();
        jTextFieldSocioRgNumero = new JTextField();
        jLabel76 = new JLabel();
        jLabel75 = new JLabel();
        jLabel78 = new JLabel();
        jFormattedTextFieldSocioDataEmissao = new JFormattedTextField();
        jLabel90 = new JLabel();
        jFormattedCNPJ = new JFormattedTextField();
        jRadioCPFCNPJ = new JCheckBox();
        jCheckBoxExclusivamenteSocio = new JCheckBox();
        jLabel77 = new JLabel();
        jTextFieldSocioOrgaoExpedidor = new JTextField();
        jDesktopPane1 = new JDesktopPane();
        jInternalFrame1 = new JInternalFrame();
        jScrollPane4 = new JScrollPane();
        jTable1 = new JTable();
        jPanel19 = new JPanel();
        jLabel31 = new JLabel();
        jTextField2 = new JTextField();
        jButtonPesquisa = new JButton();
        jButtonInternalFrameVoltar = new JButton();
        buttonGroupSocioAprovacao = new ButtonGroup();

        //======== this ========
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setIconImage(new ImageIcon(getClass().getResource("/img/ico.png")).getImage());
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setBounds(new Rectangle(0, 0, 0, 0));
        setResizable(false);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                formWindowClosed(e);
            }
        });
        var contentPane = getContentPane();

        //======== jPanel1 ========
        {

            //======== jTabbedPane1 ========
            {
                jTabbedPane1.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
                jTabbedPane1.setTabPlacement(SwingConstants.LEFT);
                jTabbedPane1.addChangeListener(e -> jTabbedPane1StateChanged(e));

                //======== jPanelLog ========
                {
                    jPanelLog.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
                    jPanelLog.setPreferredSize(new Dimension(800, 600));
                    jPanelLog.setLayout(new GridBagLayout());

                    //======== jPanel20 ========
                    {

                        //======== jPanel41 ========
                        {
                            jPanel41.setBorder(new EtchedBorder());

                            //======== jPanel40 ========
                            {
                                jPanel40.setBorder(new BevelBorder(BevelBorder.RAISED));

                                //---- jButtonLogradouroNovo ----
                                jButtonLogradouroNovo.setText("Novo");
                                jButtonLogradouroNovo.addActionListener(e -> jButtonLogradouroNovoActionPerformed(e));

                                //---- jButtonLogradouroEditar ----
                                jButtonLogradouroEditar.setText("Editar");
                                jButtonLogradouroEditar.addActionListener(e -> jButtonLogradouroEditarActionPerformed(e));

                                //---- jButtonLogradouroApagar ----
                                jButtonLogradouroApagar.setText("Apagar");
                                jButtonLogradouroApagar.addActionListener(e -> jButtonLogradouroApagarActionPerformed(e));

                                //---- jButtonLogradouroSalvar ----
                                jButtonLogradouroSalvar.setText("Salvar");
                                jButtonLogradouroSalvar.addActionListener(e -> jButtonLogradouroSalvarActionPerformed(e));

                                //---- jButtonLogradouroCancelar ----
                                jButtonLogradouroCancelar.setText("Cancelar");
                                jButtonLogradouroCancelar.addActionListener(e -> jButtonLogradouroCancelarActionPerformed(e));

                                GroupLayout jPanel40Layout = new GroupLayout(jPanel40);
                                jPanel40.setLayout(jPanel40Layout);
                                jPanel40Layout.setHorizontalGroup(
                                    jPanel40Layout.createParallelGroup()
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel40Layout.createSequentialGroup()
                                            .addGap(114, 114, 114)
                                            .addComponent(jButtonLogradouroNovo)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jButtonLogradouroEditar)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jButtonLogradouroApagar)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jButtonLogradouroSalvar)
                                            .addGap(18, 18, 18)
                                            .addComponent(jButtonLogradouroCancelar)
                                            .addContainerGap(271, Short.MAX_VALUE))
                                );
                                jPanel40Layout.linkSize(SwingConstants.HORIZONTAL, new Component[] {jButtonLogradouroApagar, jButtonLogradouroCancelar, jButtonLogradouroEditar, jButtonLogradouroNovo, jButtonLogradouroSalvar});
                                jPanel40Layout.setVerticalGroup(
                                    jPanel40Layout.createParallelGroup()
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel40Layout.createSequentialGroup()
                                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(jPanel40Layout.createParallelGroup()
                                                .addComponent(jButtonLogradouroNovo)
                                                .addComponent(jButtonLogradouroEditar)
                                                .addComponent(jButtonLogradouroApagar)
                                                .addComponent(jButtonLogradouroSalvar)
                                                .addComponent(jButtonLogradouroCancelar))
                                            .addGap(10, 10, 10))
                                );
                                jPanel40Layout.linkSize(SwingConstants.VERTICAL, new Component[] {jButtonLogradouroApagar, jButtonLogradouroCancelar, jButtonLogradouroEditar, jButtonLogradouroNovo, jButtonLogradouroSalvar});
                            }

                            //======== jPanel6 ========
                            {
                                jPanel6.setBorder(new TitledBorder("Logradouros"));

                                //======== jScrollPane1 ========
                                {

                                    //---- jTextAreaLogradouroDescricao ----
                                    jTextAreaLogradouroDescricao.setColumns(20);
                                    jTextAreaLogradouroDescricao.setRows(5);
                                    jScrollPane1.setViewportView(jTextAreaLogradouroDescricao);
                                }

                                //---- jLabel3 ----
                                jLabel3.setText("Descri\u00e7\u00e3o");

                                //---- jLabel1 ----
                                jLabel1.setFont(new Font("Tahoma", Font.BOLD, 11));
                                jLabel1.setText("Tipo");

                                //---- jComboBoxLogradouroTipo ----
                                jComboBoxLogradouroTipo.setModel(new javax.swing.DefaultComboBoxModel(
                                    new String[] {
                                        "",
                                        "Aeroporto",
                                        "Apartamento",
                                        "Avenida",
                                        "Beco",
                                        "Bloco",
                                        "Caminhi",
                                        "Escadinha",
                                        "Estação",
                                        "Estrada",
                                        "Fazenda",
                                        "Ladeira",
                                        "Largo",
                                        "Praça",
                                        "Parque",
                                        "Quadra",
                                        "Quilômetro",
                                        "Quinta",
                                        "Rodovia",
                                        "Rua",
                                        "Travessa"
                                    }));

                                //---- jLabel2 ----
                                jLabel2.setFont(new Font("Tahoma", Font.BOLD, 11));
                                jLabel2.setText("Nome");

                                //======== jPanel44 ========
                                {

                                    //---- jButtonLogradouroPesquisar ----
                                    jButtonLogradouroPesquisar.setText("Pesquisar");
                                    jButtonLogradouroPesquisar.addActionListener(e -> jButtonLogradouroPesquisarActionPerformed(e));

                                    //---- jTextFieldLogradouroID ----
                                    jTextFieldLogradouroID.setEnabled(false);

                                    //---- jLabel32 ----
                                    jLabel32.setText("ID");

                                    GroupLayout jPanel44Layout = new GroupLayout(jPanel44);
                                    jPanel44.setLayout(jPanel44Layout);
                                    jPanel44Layout.setHorizontalGroup(
                                        jPanel44Layout.createParallelGroup()
                                            .addGroup(GroupLayout.Alignment.TRAILING, jPanel44Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel32)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(jPanel44Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jButtonLogradouroPesquisar, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                                                    .addComponent(jTextFieldLogradouroID))
                                                .addGap(19, 19, 19))
                                    );
                                    jPanel44Layout.setVerticalGroup(
                                        jPanel44Layout.createParallelGroup()
                                            .addGroup(jPanel44Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(jPanel44Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jTextFieldLogradouroID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel32))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButtonLogradouroPesquisar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(40, 40, 40))
                                    );
                                }

                                GroupLayout jPanel6Layout = new GroupLayout(jPanel6);
                                jPanel6.setLayout(jPanel6Layout);
                                jPanel6Layout.setHorizontalGroup(
                                    jPanel6Layout.createParallelGroup()
                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                            .addContainerGap()
                                            .addGroup(jPanel6Layout.createParallelGroup()
                                                .addComponent(jLabel3)
                                                .addComponent(jLabel1)
                                                .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                                                .addComponent(jComboBoxLogradouroTipo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jTextFieldLogradouroNome))
                                            .addGap(18, 18, 18)
                                            .addComponent(jPanel44, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addContainerGap())
                                );
                                jPanel6Layout.setVerticalGroup(
                                    jPanel6Layout.createParallelGroup()
                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                            .addGroup(jPanel6Layout.createParallelGroup()
                                                .addComponent(jPanel44, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGroup(jPanel6Layout.createSequentialGroup()
                                                    .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel1)
                                                        .addComponent(jComboBoxLogradouroTipo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                    .addGap(10, 10, 10)
                                                    .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jTextFieldLogradouroNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                    .addGap(10, 10, 10)
                                                    .addGroup(jPanel6Layout.createParallelGroup()
                                                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel3))))
                                            .addGap(10, 10, 10))
                                );
                            }

                            GroupLayout jPanel41Layout = new GroupLayout(jPanel41);
                            jPanel41.setLayout(jPanel41Layout);
                            jPanel41Layout.setHorizontalGroup(
                                jPanel41Layout.createParallelGroup()
                                    .addGroup(jPanel41Layout.createSequentialGroup()
                                        .addGroup(jPanel41Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jPanel40, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jPanel6, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(0, 0, Short.MAX_VALUE))
                            );
                            jPanel41Layout.setVerticalGroup(
                                jPanel41Layout.createParallelGroup()
                                    .addGroup(jPanel41Layout.createSequentialGroup()
                                        .addComponent(jPanel6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(jPanel40, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            );
                        }

                        GroupLayout jPanel20Layout = new GroupLayout(jPanel20);
                        jPanel20.setLayout(jPanel20Layout);
                        jPanel20Layout.setHorizontalGroup(
                            jPanel20Layout.createParallelGroup()
                                .addGroup(jPanel20Layout.createSequentialGroup()
                                    .addComponent(jPanel41, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, 0))
                        );
                        jPanel20Layout.setVerticalGroup(
                            jPanel20Layout.createParallelGroup()
                                .addComponent(jPanel41, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        );
                    }
                    jPanelLog.add(jPanel20, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.NORTHWEST, GridBagConstraints.NONE,
                        new Insets(3, 3, 25, 0), 151, 807));
                }
                jTabbedPane1.addTab("Logradouros", null, jPanelLog, "Cadastre um logradouro");

                //======== jPanelFunc ========
                {
                    jPanelFunc.setLayout(new GridBagLayout());

                    //======== jPanel21 ========
                    {
                        jPanel21.setBorder(new TitledBorder(""));

                        //======== jPanel5 ========
                        {
                            jPanel5.setBorder(new TitledBorder("Detalhes do Funcionario"));
                            jPanel5.setToolTipText("");

                            //---- Logradouro4 ----
                            Logradouro4.setFont(new Font("Tahoma", Font.BOLD, 11));
                            Logradouro4.setText("Cargo");

                            //---- Logradouro5 ----
                            Logradouro5.setFont(new Font("Tahoma", Font.BOLD, 11));
                            Logradouro5.setText("Salario");

                            //---- Logradouro6 ----
                            Logradouro6.setFont(new Font("Tahoma", Font.BOLD, 11));
                            Logradouro6.setText("Data de Contrata\u00e7\u00e3o");

                            //---- Logradouro7 ----
                            Logradouro7.setText("Observa\u00e7\u00f5es");

                            //======== jScrollPane2 ========
                            {

                                //---- jTextAreaFuncionarioObservacoes ----
                                jTextAreaFuncionarioObservacoes.setColumns(20);
                                jTextAreaFuncionarioObservacoes.setRows(5);
                                jScrollPane2.setViewportView(jTextAreaFuncionarioObservacoes);
                            }

                            //---- jTextFieldFuncionarioSalario ----
                            jTextFieldFuncionarioSalario.addActionListener(e -> jTextFieldFuncionarioSalarioActionPerformed(e));

                            GroupLayout jPanel5Layout = new GroupLayout(jPanel5);
                            jPanel5.setLayout(jPanel5Layout);
                            jPanel5Layout.setHorizontalGroup(
                                jPanel5Layout.createParallelGroup()
                                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                        .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addComponent(Logradouro6, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jFormattedTextFieldFuncionarioDataContratacao, GroupLayout.DEFAULT_SIZE, 1, Short.MAX_VALUE))
                                            .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addGroup(jPanel5Layout.createParallelGroup()
                                                    .addComponent(Logradouro4)
                                                    .addComponent(Logradouro5))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel5Layout.createParallelGroup()
                                                    .addComponent(jTextFieldFuncionarioCargo)
                                                    .addComponent(jTextFieldFuncionarioSalario))))
                                        .addGap(101, 101, 101)
                                        .addComponent(Logradouro7, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 335, GroupLayout.PREFERRED_SIZE)
                                        .addGap(99, 99, 99))
                            );
                            jPanel5Layout.setVerticalGroup(
                                jPanel5Layout.createParallelGroup()
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGroup(jPanel5Layout.createParallelGroup()
                                            .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                    .addComponent(Logradouro4)
                                                    .addComponent(jTextFieldFuncionarioCargo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(Logradouro7))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                    .addComponent(Logradouro5)
                                                    .addComponent(jTextFieldFuncionarioSalario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addGap(6, 6, 6)
                                                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                    .addComponent(Logradouro6)
                                                    .addComponent(jFormattedTextFieldFuncionarioDataContratacao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                            .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addContainerGap(27, Short.MAX_VALUE))
                            );
                        }

                        //======== jPanel4 ========
                        {
                            jPanel4.setBorder(new BevelBorder(BevelBorder.RAISED));

                            //---- Logradouro1 ----
                            Logradouro1.setFont(new Font("Tahoma", Font.BOLD, 11));
                            Logradouro1.setText("Status");

                            //---- Logradouro3 ----
                            Logradouro3.setFont(new Font("Tahoma", Font.BOLD, 11));
                            Logradouro3.setText("Numero da Matricula");

                            //---- jComboBoxFuncionarioStatus ----
                            jComboBoxFuncionarioStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"","Ativo", "Inativo" }));

                            //---- jButtonFuncionarioEditar ----
                            jButtonFuncionarioEditar.setText("Editar");
                            jButtonFuncionarioEditar.addActionListener(e -> jButtonFuncionarioEditarActionPerformed(e));

                            //---- jButtonFuncionarioApagar ----
                            jButtonFuncionarioApagar.setText("Apagar");
                            jButtonFuncionarioApagar.addActionListener(e -> jButtonFuncionarioApagarActionPerformed(e));

                            //---- jButtonFuncionarioSalvar ----
                            jButtonFuncionarioSalvar.setText("Salvar");
                            jButtonFuncionarioSalvar.addActionListener(e -> jButtonFuncionarioSalvarActionPerformed(e));

                            //---- jButtonFuncionarioNovo ----
                            jButtonFuncionarioNovo.setText("Novo");
                            jButtonFuncionarioNovo.addActionListener(e -> jButtonFuncionarioNovoActionPerformed(e));

                            //---- jButtonFuncionarioCancelar ----
                            jButtonFuncionarioCancelar.setText("Cancelar");
                            jButtonFuncionarioCancelar.addActionListener(e -> jButtonFuncionarioCancelarActionPerformed(e));

                            GroupLayout jPanel4Layout = new GroupLayout(jPanel4);
                            jPanel4.setLayout(jPanel4Layout);
                            jPanel4Layout.setHorizontalGroup(
                                jPanel4Layout.createParallelGroup()
                                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(Logradouro1)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBoxFuncionarioStatus, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButtonFuncionarioNovo)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonFuncionarioEditar)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonFuncionarioApagar)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonFuncionarioSalvar)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonFuncionarioCancelar)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                                        .addComponent(Logradouro3)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldFuncionarioNumeroDaMatricula, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18))
                            );
                            jPanel4Layout.linkSize(SwingConstants.HORIZONTAL, new Component[] {jButtonFuncionarioApagar, jButtonFuncionarioCancelar, jButtonFuncionarioEditar, jButtonFuncionarioNovo, jButtonFuncionarioSalvar});
                            jPanel4Layout.setVerticalGroup(
                                jPanel4Layout.createParallelGroup()
                                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(jPanel4Layout.createParallelGroup()
                                            .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(jButtonFuncionarioEditar)
                                                .addComponent(jButtonFuncionarioApagar)
                                                .addComponent(jButtonFuncionarioSalvar)
                                                .addComponent(jButtonFuncionarioNovo)
                                                .addComponent(jButtonFuncionarioCancelar))
                                            .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(Logradouro1)
                                                .addComponent(Logradouro3)
                                                .addComponent(jTextFieldFuncionarioNumeroDaMatricula, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jComboBoxFuncionarioStatus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                        .addGap(10, 10, 10))
                            );
                            jPanel4Layout.linkSize(SwingConstants.VERTICAL, new Component[] {jButtonFuncionarioApagar, jButtonFuncionarioCancelar, jButtonFuncionarioEditar, jButtonFuncionarioNovo, jButtonFuncionarioSalvar});
                        }

                        //======== jPanel3 ========
                        {
                            jPanel3.setBorder(new TitledBorder("Endere\u00e7o"));

                            //---- jComboBoxFuncionarioLograduro ----
                            jComboBoxFuncionarioLograduro.setModel(new DefaultComboBoxModel<>(new String[] {

                            }));

                            //---- jLabel8 ----
                            jLabel8.setText("N\u00famero");

                            //---- jLabel9 ----
                            jLabel9.setText("Bairro");

                            //---- jLabel10 ----
                            jLabel10.setText("Cidade");

                            //---- jLabel11 ----
                            jLabel11.setFont(new Font("Tahoma", Font.BOLD, 11));
                            jLabel11.setText("UF");

                            //---- jLabel12 ----
                            jLabel12.setText("CEP");

                            //---- Logradouro ----
                            Logradouro.setFont(new Font("Tahoma", Font.BOLD, 11));
                            Logradouro.setText("Logradouro");

                            //---- jComboBoxFuncionarioUf ----
                            jComboBoxFuncionarioUf.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
                            "",
                            "AC",
                            "AL",
                            "AP",
                            "AM",
                            "BA",
                            "CE",
                            "DF",
                            "ES",
                            "GO",
                            "MA",
                            "MT",
                            "MS",
                            "MG",
                            "PA",
                            "PB",
                            "PR",
                            "PE",
                            "PI",
                            "RJ",
                            "RN",
                            "RS",
                            "RO",
                            "RR",
                            "SC",
                            "SE",
                            "TO"
                            }));

                            //---- jButton2 ----
                            jButton2.setIcon(new ImageIcon(getClass().getResource("/img/Cadastros.png")));
                            jButton2.addActionListener(e -> jButton2ActionPerformed(e));

                            GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
                            jPanel3.setLayout(jPanel3Layout);
                            jPanel3Layout.setHorizontalGroup(
                                jPanel3Layout.createParallelGroup()
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup()
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(Logradouro)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel3Layout.createParallelGroup()
                                                    .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                            .addGap(1, 1, 1)
                                                            .addComponent(jTextFieldFuncionarioNumero, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(jTextFieldFuncionarioBairro))
                                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                                        .addComponent(jComboBoxFuncionarioLograduro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))))
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel9))
                                        .addGap(159, 159, 159)
                                        .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel12))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jComboBoxFuncionarioUf, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextFieldFuncionarioCidade, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                                            .addComponent(jTextFieldFuncionarioCep))
                                        .addContainerGap(214, Short.MAX_VALUE))
                            );
                            jPanel3Layout.setVerticalGroup(
                                jPanel3Layout.createParallelGroup()
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel8)
                                            .addComponent(jTextFieldFuncionarioNumero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel10)
                                            .addComponent(jTextFieldFuncionarioCidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel9)
                                            .addComponent(jTextFieldFuncionarioBairro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel11)
                                            .addComponent(jComboBoxFuncionarioUf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(Logradouro)
                                            .addComponent(jComboBoxFuncionarioLograduro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel12)
                                            .addComponent(jTextFieldFuncionarioCep, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
                                        .addContainerGap(47, Short.MAX_VALUE))
                            );
                        }

                        //======== jPanel2 ========
                        {
                            jPanel2.setBorder(new TitledBorder("Informa\u00e7\u00f5es Pessoais"));

                            //---- jLabel6 ----
                            jLabel6.setFont(new Font("Tahoma", Font.BOLD, 11));
                            jLabel6.setText("Sobrenome");

                            //---- jLabel5 ----
                            jLabel5.setFont(new Font("Tahoma", Font.BOLD, 11));
                            jLabel5.setText("Nome");

                            //---- jTextFieldFuncionarioNome ----
                            jTextFieldFuncionarioNome.addActionListener(e -> jTextFieldFuncionarioNomeActionPerformed(e));

                            //---- jLabel7 ----
                            jLabel7.setText("Apelido");

                            //---- jLabel18 ----
                            jLabel18.setText("ID");

                            //---- jTextFieldFuncionarioID ----
                            jTextFieldFuncionarioID.setEditable(false);

                            //---- jButtonFuncionarioPesquisar ----
                            jButtonFuncionarioPesquisar.setText("Pesquisar");
                            jButtonFuncionarioPesquisar.addActionListener(e -> jButtonFuncionarioPesquisarActionPerformed(e));

                            //======== jPanel47 ========
                            {

                                //---- jTextFieldFuncionarioRgnumero ----
                                jTextFieldFuncionarioRgnumero.addActionListener(e -> jTextFieldFuncionarioRgnumeroActionPerformed(e));

                                //---- jLabel4 ----
                                jLabel4.setText("Telefone");

                                //---- jLabel14 ----
                                jLabel14.setText("Data Nascimento");

                                //---- jLabel16 ----
                                jLabel16.setText("Nome da M\u00e3e");

                                //---- jLabel27 ----
                                jLabel27.setText("Nome do Pai");

                                //---- jLabel20 ----
                                jLabel20.setFont(new Font("Tahoma", Font.BOLD, 11));
                                jLabel20.setText("Cpf");

                                //---- jLabel21 ----
                                jLabel21.setText("Rg Numero");

                                GroupLayout jPanel47Layout = new GroupLayout(jPanel47);
                                jPanel47.setLayout(jPanel47Layout);
                                jPanel47Layout.setHorizontalGroup(
                                    jPanel47Layout.createParallelGroup()
                                        .addGroup(jPanel47Layout.createSequentialGroup()
                                            .addContainerGap()
                                            .addGroup(jPanel47Layout.createParallelGroup()
                                                .addGroup(jPanel47Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(jLabel4, GroupLayout.Alignment.LEADING)
                                                    .addGroup(GroupLayout.Alignment.LEADING, jPanel47Layout.createSequentialGroup()
                                                        .addGroup(jPanel47Layout.createParallelGroup()
                                                            .addComponent(jLabel21)
                                                            .addComponent(jLabel20))
                                                        .addGap(76, 76, 76)
                                                        .addGroup(jPanel47Layout.createParallelGroup()
                                                            .addComponent(jTextFieldFuncionarioRgnumero)
                                                            .addGroup(jPanel47Layout.createSequentialGroup()
                                                                .addComponent(jFormattedTextFieldFuncionarioCpf, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, Short.MAX_VALUE)))))
                                                .addGroup(jPanel47Layout.createSequentialGroup()
                                                    .addGroup(jPanel47Layout.createParallelGroup()
                                                        .addComponent(jLabel16)
                                                        .addComponent(jLabel27)
                                                        .addComponent(jLabel14))
                                                    .addGap(48, 48, 48)
                                                    .addGroup(jPanel47Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jTextFieldFuncionarioNomedopai, GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                                                        .addComponent(jTextFieldFuncionarioNomedame)
                                                        .addComponent(jTextFieldFuncionarioTelefone)
                                                        .addComponent(jFormattedTextFieldFuncionarioDataNascimento, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)))))
                                );
                                jPanel47Layout.setVerticalGroup(
                                    jPanel47Layout.createParallelGroup()
                                        .addGroup(jPanel47Layout.createSequentialGroup()
                                            .addGroup(jPanel47Layout.createParallelGroup()
                                                .addGroup(jPanel47Layout.createSequentialGroup()
                                                    .addContainerGap()
                                                    .addComponent(jLabel4)
                                                    .addGap(11, 11, 11)
                                                    .addGroup(jPanel47Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel14)
                                                        .addComponent(jFormattedTextFieldFuncionarioDataNascimento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                                .addComponent(jTextFieldFuncionarioTelefone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                            .addGap(10, 10, 10)
                                            .addGroup(jPanel47Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel16)
                                                .addComponent(jTextFieldFuncionarioNomedame, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                            .addGap(10, 10, 10)
                                            .addGroup(jPanel47Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel27)
                                                .addComponent(jTextFieldFuncionarioNomedopai, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                            .addGap(10, 10, 10)
                                            .addGroup(jPanel47Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel20)
                                                .addComponent(jFormattedTextFieldFuncionarioCpf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                            .addGap(10, 10, 10)
                                            .addGroup(jPanel47Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel21)
                                                .addComponent(jTextFieldFuncionarioRgnumero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                            .addGap(0, 11, Short.MAX_VALUE))
                                );
                            }

                            //======== jPanel57 ========
                            {

                                //---- jLabel19 ----
                                jLabel19.setFont(new Font("Tahoma", Font.BOLD, 11));
                                jLabel19.setText("Sexo");

                                //---- jLabel13 ----
                                jLabel13.setText("Email");

                                //---- jTextFieldFuncionarioEmail ----
                                jTextFieldFuncionarioEmail.addActionListener(e -> jTextFieldFuncionarioEmailActionPerformed(e));

                                //---- jComboBoxFuncionarioSexo ----
                                jComboBoxFuncionarioSexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"","Masculino","Feminino" }));

                                //---- jLabel22 ----
                                jLabel22.setText("Org\u00e3o Expedidor");

                                //---- jLabel24 ----
                                jLabel24.setText("Data de Emissao");

                                GroupLayout jPanel57Layout = new GroupLayout(jPanel57);
                                jPanel57.setLayout(jPanel57Layout);
                                jPanel57Layout.setHorizontalGroup(
                                    jPanel57Layout.createParallelGroup()
                                        .addGroup(jPanel57Layout.createSequentialGroup()
                                            .addGap(10, 10, 10)
                                            .addGroup(jPanel57Layout.createParallelGroup()
                                                .addGroup(jPanel57Layout.createParallelGroup()
                                                    .addComponent(jLabel13, GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel19, GroupLayout.Alignment.TRAILING))
                                                .addGroup(jPanel57Layout.createParallelGroup()
                                                    .addGroup(jPanel57Layout.createSequentialGroup()
                                                        .addComponent(jLabel24)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(jFormattedTextFieldFuncionarioDataEmissao, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel57Layout.createSequentialGroup()
                                                        .addComponent(jLabel22)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(jPanel57Layout.createParallelGroup()
                                                            .addComponent(jComboBoxFuncionarioSexo, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jTextFieldFuncionarioOrgaoExpedidor, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jTextFieldFuncionarioEmail, GroupLayout.PREFERRED_SIZE, 258, GroupLayout.PREFERRED_SIZE)))))
                                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                );
                                jPanel57Layout.setVerticalGroup(
                                    jPanel57Layout.createParallelGroup()
                                        .addGroup(jPanel57Layout.createSequentialGroup()
                                            .addContainerGap()
                                            .addGroup(jPanel57Layout.createParallelGroup()
                                                .addComponent(jTextFieldFuncionarioEmail, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel13))
                                            .addGap(10, 10, 10)
                                            .addGroup(jPanel57Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(jComboBoxFuncionarioSexo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel19))
                                            .addGap(10, 10, 10)
                                            .addGroup(jPanel57Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(jTextFieldFuncionarioOrgaoExpedidor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel22))
                                            .addGap(10, 10, 10)
                                            .addGroup(jPanel57Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel24)
                                                .addComponent(jFormattedTextFieldFuncionarioDataEmissao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                );
                            }

                            GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
                            jPanel2.setLayout(jPanel2Layout);
                            jPanel2Layout.setHorizontalGroup(
                                jPanel2Layout.createParallelGroup()
                                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup()
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel5))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jTextFieldFuncionarioNome, GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                                            .addComponent(jTextFieldFuncionarioSobrenome))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButtonFuncionarioPesquisar)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 175, Short.MAX_VALUE)
                                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel18))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jTextFieldFuncionarioApelido, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                            .addComponent(jTextFieldFuncionarioID))
                                        .addGap(24, 24, 24))
                                    .addComponent(jSeparator1)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jPanel47, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(jPanel57, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            );
                            jPanel2Layout.setVerticalGroup(
                                jPanel2Layout.createParallelGroup()
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup()
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel5)
                                                    .addComponent(jTextFieldFuncionarioNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jButtonFuncionarioPesquisar))
                                                .addGap(10, 10, 10)
                                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel6)
                                                    .addComponent(jTextFieldFuncionarioSobrenome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jTextFieldFuncionarioID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel18, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel7)
                                                    .addComponent(jTextFieldFuncionarioApelido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                                        .addGap(10, 10, 10)
                                        .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jPanel47, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jPanel57, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(0, 0, 0))
                            );
                        }

                        GroupLayout jPanel21Layout = new GroupLayout(jPanel21);
                        jPanel21.setLayout(jPanel21Layout);
                        jPanel21Layout.setHorizontalGroup(
                            jPanel21Layout.createParallelGroup()
                                .addGroup(jPanel21Layout.createSequentialGroup()
                                    .addGroup(jPanel21Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jPanel4, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel2, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel3, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel5, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(0, 0, 0))
                        );
                        jPanel21Layout.setVerticalGroup(
                            jPanel21Layout.createParallelGroup()
                                .addGroup(jPanel21Layout.createSequentialGroup()
                                    .addGap(0, 0, 0)
                                    .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, 0)
                                    .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, 0)
                                    .addComponent(jPanel5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGap(10, 10, 10)
                                    .addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, 0))
                        );
                    }
                    jPanelFunc.add(jPanel21, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.NONE,
                        new Insets(0, 0, 0, 0), 0, 0));
                }
                jTabbedPane1.addTab("Funcion\u00e1rios", jPanelFunc);

                //======== jPanelCategoriaSocio ========
                {
                    jPanelCategoriaSocio.setLayout(new GridBagLayout());

                    //======== jPanel30 ========
                    {

                        //======== jPanel43 ========
                        {

                            //======== jPanel10 ========
                            {
                                jPanel10.setBorder(new BevelBorder(BevelBorder.RAISED));

                                //---- jButtonCategoriaSocioNovo ----
                                jButtonCategoriaSocioNovo.setText("Novo");
                                jButtonCategoriaSocioNovo.addActionListener(e -> jButtonCategoriaSocioNovoActionPerformed(e));

                                //---- jButtonCategoriaSocioEditar ----
                                jButtonCategoriaSocioEditar.setText("Editar");
                                jButtonCategoriaSocioEditar.addActionListener(e -> jButtonCategoriaSocioEditarActionPerformed(e));

                                //---- jButtonCategoriaSocioSalvar ----
                                jButtonCategoriaSocioSalvar.setText("Salvar");
                                jButtonCategoriaSocioSalvar.addActionListener(e -> jButtonCategoriaSocioSalvarActionPerformed(e));

                                //---- jButtonCategoriaSocioApagar ----
                                jButtonCategoriaSocioApagar.setText("Apagar");

                                //---- jButtonCategoriaSocioCancelar ----
                                jButtonCategoriaSocioCancelar.setText("Cancelar");
                                jButtonCategoriaSocioCancelar.addActionListener(e -> jButtonCategoriaSocioCancelarActionPerformed(e));

                                GroupLayout jPanel10Layout = new GroupLayout(jPanel10);
                                jPanel10.setLayout(jPanel10Layout);
                                jPanel10Layout.setHorizontalGroup(
                                    jPanel10Layout.createParallelGroup()
                                        .addGroup(jPanel10Layout.createSequentialGroup()
                                            .addGap(182, 182, 182)
                                            .addComponent(jButtonCategoriaSocioNovo)
                                            .addGap(10, 10, 10)
                                            .addComponent(jButtonCategoriaSocioEditar)
                                            .addGap(10, 10, 10)
                                            .addComponent(jButtonCategoriaSocioApagar)
                                            .addGap(10, 10, 10)
                                            .addComponent(jButtonCategoriaSocioSalvar)
                                            .addGap(10, 10, 10)
                                            .addComponent(jButtonCategoriaSocioCancelar)
                                            .addContainerGap(199, Short.MAX_VALUE))
                                );
                                jPanel10Layout.linkSize(SwingConstants.HORIZONTAL, new Component[] {jButtonCategoriaSocioApagar, jButtonCategoriaSocioCancelar, jButtonCategoriaSocioEditar, jButtonCategoriaSocioNovo, jButtonCategoriaSocioSalvar});
                                jPanel10Layout.setVerticalGroup(
                                    jPanel10Layout.createParallelGroup()
                                        .addGroup(jPanel10Layout.createSequentialGroup()
                                            .addGap(10, 10, 10)
                                            .addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(jButtonCategoriaSocioNovo)
                                                .addComponent(jButtonCategoriaSocioEditar)
                                                .addComponent(jButtonCategoriaSocioApagar)
                                                .addComponent(jButtonCategoriaSocioCancelar)
                                                .addComponent(jButtonCategoriaSocioSalvar))
                                            .addGap(10, 10, 10))
                                );
                                jPanel10Layout.linkSize(SwingConstants.VERTICAL, new Component[] {jButtonCategoriaSocioApagar, jButtonCategoriaSocioCancelar, jButtonCategoriaSocioEditar, jButtonCategoriaSocioNovo, jButtonCategoriaSocioSalvar});
                            }

                            //======== jPanel7 ========
                            {
                                jPanel7.setBorder(new TitledBorder("Categoria S\u00f3cio"));

                                //---- jLabel34 ----
                                jLabel34.setFont(new Font("Tahoma", Font.BOLD, 11));
                                jLabel34.setText("Nome");

                                //---- jLabel35 ----
                                jLabel35.setText("Descri\u00e7\u00e3o");

                                //======== jScrollPane5 ========
                                {

                                    //---- jTextAreaCategoriaSocioDescricao ----
                                    jTextAreaCategoriaSocioDescricao.setColumns(20);
                                    jTextAreaCategoriaSocioDescricao.setRows(5);
                                    jScrollPane5.setViewportView(jTextAreaCategoriaSocioDescricao);
                                }

                                //---- jLabel36 ----
                                jLabel36.setFont(new Font("Tahoma", Font.BOLD, 11));
                                jLabel36.setText("Taxa");

                                //---- jComboBoxCategoriaSocioTaxa ----
                                jComboBoxCategoriaSocioTaxa.setModel(new DefaultComboBoxModel<>(new String[] {

                                }));

                                //======== jPanel42 ========
                                {

                                    //---- jButtonCategoriaSocioPesquisar ----
                                    jButtonCategoriaSocioPesquisar.setText("Pesquisar");
                                    jButtonCategoriaSocioPesquisar.addActionListener(e -> jButtonCategoriaSocioPesquisarActionPerformed(e));

                                    //---- jTextFieldCategoriaSocioID ----
                                    jTextFieldCategoriaSocioID.setEnabled(false);

                                    //---- jLabel33 ----
                                    jLabel33.setText("ID");

                                    GroupLayout jPanel42Layout = new GroupLayout(jPanel42);
                                    jPanel42.setLayout(jPanel42Layout);
                                    jPanel42Layout.setHorizontalGroup(
                                        jPanel42Layout.createParallelGroup()
                                            .addGroup(GroupLayout.Alignment.TRAILING, jPanel42Layout.createSequentialGroup()
                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(jPanel42Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jButtonCategoriaSocioPesquisar, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(jPanel42Layout.createSequentialGroup()
                                                        .addComponent(jLabel33, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jTextFieldCategoriaSocioID, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)))
                                                .addContainerGap())
                                    );
                                    jPanel42Layout.setVerticalGroup(
                                        jPanel42Layout.createParallelGroup()
                                            .addGroup(jPanel42Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(jPanel42Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel33)
                                                    .addComponent(jTextFieldCategoriaSocioID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButtonCategoriaSocioPesquisar)
                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    );
                                }

                                GroupLayout jPanel7Layout = new GroupLayout(jPanel7);
                                jPanel7.setLayout(jPanel7Layout);
                                jPanel7Layout.setHorizontalGroup(
                                    jPanel7Layout.createParallelGroup()
                                        .addGroup(jPanel7Layout.createSequentialGroup()
                                            .addContainerGap()
                                            .addGroup(jPanel7Layout.createParallelGroup()
                                                .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jLabel35, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel34, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
                                                .addComponent(jLabel36))
                                            .addGap(18, 18, 18)
                                            .addGroup(jPanel7Layout.createParallelGroup()
                                                .addComponent(jTextFieldCategoriaSocioNome, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jScrollPane5, GroupLayout.PREFERRED_SIZE, 314, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jComboBoxCategoriaSocioTaxa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jPanel42, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addContainerGap())
                                );
                                jPanel7Layout.setVerticalGroup(
                                    jPanel7Layout.createParallelGroup()
                                        .addGroup(jPanel7Layout.createSequentialGroup()
                                            .addGroup(jPanel7Layout.createParallelGroup()
                                                .addComponent(jPanel42, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGroup(jPanel7Layout.createSequentialGroup()
                                                    .addGap(10, 10, 10)
                                                    .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel34)
                                                        .addComponent(jTextFieldCategoriaSocioNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                    .addGap(10, 10, 10)
                                                    .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel36)
                                                        .addComponent(jComboBoxCategoriaSocioTaxa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                    .addGap(10, 10, 10)
                                                    .addGroup(jPanel7Layout.createParallelGroup()
                                                        .addComponent(jLabel35)
                                                        .addComponent(jScrollPane5, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))))
                                            .addGap(10, 10, 10))
                                );
                            }

                            GroupLayout jPanel43Layout = new GroupLayout(jPanel43);
                            jPanel43.setLayout(jPanel43Layout);
                            jPanel43Layout.setHorizontalGroup(
                                jPanel43Layout.createParallelGroup()
                                    .addGroup(jPanel43Layout.createSequentialGroup()
                                        .addGap(0, 0, 0)
                                        .addGroup(jPanel43Layout.createParallelGroup()
                                            .addComponent(jPanel10, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jPanel7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(0, 0, 0))
                            );
                            jPanel43Layout.setVerticalGroup(
                                jPanel43Layout.createParallelGroup()
                                    .addGroup(jPanel43Layout.createSequentialGroup()
                                        .addComponent(jPanel7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(jPanel10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                            );
                        }

                        GroupLayout jPanel30Layout = new GroupLayout(jPanel30);
                        jPanel30.setLayout(jPanel30Layout);
                        jPanel30Layout.setHorizontalGroup(
                            jPanel30Layout.createParallelGroup()
                                .addGroup(jPanel30Layout.createSequentialGroup()
                                    .addGap(0, 0, 0)
                                    .addComponent(jPanel43, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, 0))
                        );
                        jPanel30Layout.setVerticalGroup(
                            jPanel30Layout.createParallelGroup()
                                .addGroup(jPanel30Layout.createSequentialGroup()
                                    .addGap(0, 0, 0)
                                    .addComponent(jPanel43, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, 0))
                        );
                    }
                    jPanelCategoriaSocio.add(jPanel30, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.NORTHWEST, GridBagConstraints.NONE,
                        new Insets(0, 0, 0, 0), 243, 752));
                }
                jTabbedPane1.addTab("Categoria S\u00f3cio", jPanelCategoriaSocio);

                //======== jPanelTipoDespesa ========
                {
                    jPanelTipoDespesa.setLayout(new GridBagLayout());

                    //======== jPanel31 ========
                    {

                        //======== jPanel24 ========
                        {
                            jPanel24.setBorder(new TitledBorder("Tipos de despesas"));

                            //---- jLabel37 ----
                            jLabel37.setFont(new Font("Tahoma", Font.BOLD, 11));
                            jLabel37.setText("Nome");

                            //---- jLabel38 ----
                            jLabel38.setFont(new Font("Tahoma", Font.BOLD, 11));
                            jLabel38.setText("Descric\u00e3o");

                            //---- jLabel39 ----
                            jLabel39.setText("Observa\u00e7\u00e3o");

                            //======== jScrollPane6 ========
                            {

                                //---- jTextAreaTipoDespesaDescricao ----
                                jTextAreaTipoDespesaDescricao.setColumns(20);
                                jTextAreaTipoDespesaDescricao.setRows(5);
                                jScrollPane6.setViewportView(jTextAreaTipoDespesaDescricao);
                            }

                            //======== jScrollPane7 ========
                            {

                                //---- jTextAreaTipoDespesaObservacao ----
                                jTextAreaTipoDespesaObservacao.setColumns(20);
                                jTextAreaTipoDespesaObservacao.setRows(5);
                                jScrollPane7.setViewportView(jTextAreaTipoDespesaObservacao);
                            }

                            //======== jPanel45 ========
                            {

                                //---- jLabel40 ----
                                jLabel40.setText("ID");

                                //---- jTextFieldTIpoDespesaID ----
                                jTextFieldTIpoDespesaID.setEnabled(false);

                                //---- jButtonTipoDespesaPesquisar ----
                                jButtonTipoDespesaPesquisar.setText("Pesquisar");
                                jButtonTipoDespesaPesquisar.addActionListener(e -> jButtonTipoDespesaPesquisarActionPerformed(e));

                                GroupLayout jPanel45Layout = new GroupLayout(jPanel45);
                                jPanel45.setLayout(jPanel45Layout);
                                jPanel45Layout.setHorizontalGroup(
                                    jPanel45Layout.createParallelGroup()
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel45Layout.createSequentialGroup()
                                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel40, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(jPanel45Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jButtonTipoDespesaPesquisar, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                                .addComponent(jTextFieldTIpoDespesaID))
                                            .addGap(45, 45, 45))
                                );
                                jPanel45Layout.setVerticalGroup(
                                    jPanel45Layout.createParallelGroup()
                                        .addGroup(jPanel45Layout.createSequentialGroup()
                                            .addContainerGap()
                                            .addGroup(jPanel45Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel40)
                                                .addComponent(jTextFieldTIpoDespesaID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jButtonTipoDespesaPesquisar)
                                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                );
                            }

                            GroupLayout jPanel24Layout = new GroupLayout(jPanel24);
                            jPanel24.setLayout(jPanel24Layout);
                            jPanel24Layout.setHorizontalGroup(
                                jPanel24Layout.createParallelGroup()
                                    .addGroup(jPanel24Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(jPanel24Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel24Layout.createSequentialGroup()
                                                .addGroup(jPanel24Layout.createParallelGroup()
                                                    .addComponent(jLabel38)
                                                    .addComponent(jLabel37))
                                                .addGap(13, 13, 13)
                                                .addGroup(jPanel24Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jTextFieldTipoDespesaNome)
                                                    .addComponent(jScrollPane6, GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)))
                                            .addGroup(jPanel24Layout.createSequentialGroup()
                                                .addComponent(jLabel39)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jScrollPane7, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel45, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap())
                            );
                            jPanel24Layout.setVerticalGroup(
                                jPanel24Layout.createParallelGroup()
                                    .addGroup(jPanel24Layout.createSequentialGroup()
                                        .addGroup(jPanel24Layout.createParallelGroup()
                                            .addGroup(jPanel24Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(jPanel24Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel37)
                                                    .addComponent(jTextFieldTipoDespesaNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addGap(10, 10, 10)
                                                .addGroup(jPanel24Layout.createParallelGroup()
                                                    .addComponent(jLabel38)
                                                    .addComponent(jScrollPane6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                            .addComponent(jPanel45, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel24Layout.createParallelGroup()
                                            .addGroup(jPanel24Layout.createSequentialGroup()
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel39)
                                                .addGap(93, 93, 93))
                                            .addGroup(jPanel24Layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(jScrollPane7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(10, 10, 10))))
                            );
                        }

                        //======== jPanel11 ========
                        {
                            jPanel11.setBorder(new BevelBorder(BevelBorder.RAISED));

                            //---- jButtonTipoDespesaNovo ----
                            jButtonTipoDespesaNovo.setText("Novo");
                            jButtonTipoDespesaNovo.addActionListener(e -> jButtonTipoDespesaNovoActionPerformed(e));

                            //---- jButtonTipoDespesaEditar ----
                            jButtonTipoDespesaEditar.setText("Editar");
                            jButtonTipoDespesaEditar.addActionListener(e -> jButtonTipoDespesaEditarActionPerformed(e));

                            //---- jButtonTipoDespesaSalvar ----
                            jButtonTipoDespesaSalvar.setText("Salvar");
                            jButtonTipoDespesaSalvar.addActionListener(e -> jButtonTipoDespesaSalvarActionPerformed(e));

                            //---- jButtonTipoDespesaApagar ----
                            jButtonTipoDespesaApagar.setText("Apagar");
                            jButtonTipoDespesaApagar.addActionListener(e -> jButtonTipoDespesaApagarActionPerformed(e));

                            //---- jButtonTipoDespesaCancelar ----
                            jButtonTipoDespesaCancelar.setText("Cancelar");
                            jButtonTipoDespesaCancelar.addActionListener(e -> jButtonTipoDespesaCancelarActionPerformed(e));

                            GroupLayout jPanel11Layout = new GroupLayout(jPanel11);
                            jPanel11.setLayout(jPanel11Layout);
                            jPanel11Layout.setHorizontalGroup(
                                jPanel11Layout.createParallelGroup()
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addGap(201, 201, 201)
                                        .addComponent(jButtonTipoDespesaNovo)
                                        .addGap(10, 10, 10)
                                        .addComponent(jButtonTipoDespesaEditar)
                                        .addGap(10, 10, 10)
                                        .addComponent(jButtonTipoDespesaApagar)
                                        .addGap(10, 10, 10)
                                        .addComponent(jButtonTipoDespesaSalvar)
                                        .addGap(10, 10, 10)
                                        .addComponent(jButtonTipoDespesaCancelar)
                                        .addContainerGap(180, Short.MAX_VALUE))
                            );
                            jPanel11Layout.linkSize(SwingConstants.HORIZONTAL, new Component[] {jButtonTipoDespesaApagar, jButtonTipoDespesaCancelar, jButtonTipoDespesaEditar, jButtonTipoDespesaNovo, jButtonTipoDespesaSalvar});
                            jPanel11Layout.setVerticalGroup(
                                jPanel11Layout.createParallelGroup()
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(jButtonTipoDespesaNovo)
                                            .addComponent(jButtonTipoDespesaEditar)
                                            .addComponent(jButtonTipoDespesaApagar)
                                            .addComponent(jButtonTipoDespesaCancelar)
                                            .addComponent(jButtonTipoDespesaSalvar))
                                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            );
                            jPanel11Layout.linkSize(SwingConstants.VERTICAL, new Component[] {jButtonTipoDespesaApagar, jButtonTipoDespesaCancelar, jButtonTipoDespesaEditar, jButtonTipoDespesaNovo, jButtonTipoDespesaSalvar});
                        }

                        GroupLayout jPanel31Layout = new GroupLayout(jPanel31);
                        jPanel31.setLayout(jPanel31Layout);
                        jPanel31Layout.setHorizontalGroup(
                            jPanel31Layout.createParallelGroup()
                                .addGroup(jPanel31Layout.createSequentialGroup()
                                    .addGap(0, 0, 0)
                                    .addGroup(jPanel31Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jPanel24, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    .addGap(0, 0, 0))
                        );
                        jPanel31Layout.setVerticalGroup(
                            jPanel31Layout.createParallelGroup()
                                .addGroup(jPanel31Layout.createSequentialGroup()
                                    .addComponent(jPanel24, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE)
                                    .addGap(10, 10, 10)
                                    .addComponent(jPanel11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, 0))
                        );
                    }
                    jPanelTipoDespesa.add(jPanel31, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.NORTHWEST, GridBagConstraints.NONE,
                        new Insets(0, 0, 0, 0), 110, 835));
                }
                jTabbedPane1.addTab("Tipo/Despesa", jPanelTipoDespesa);

                //======== jPanelDespesa ========
                {
                    jPanelDespesa.setLayout(new GridBagLayout());

                    //======== jPanel32 ========
                    {

                        //======== jPanel53 ========
                        {

                            //======== jPanel12 ========
                            {
                                jPanel12.setBorder(new BevelBorder(BevelBorder.RAISED));

                                //---- jButtonDespesaNovo ----
                                jButtonDespesaNovo.setText("Novo");
                                jButtonDespesaNovo.addActionListener(e -> jButtonDespesaNovoActionPerformed(e));

                                //---- jButtonDespesaEditar ----
                                jButtonDespesaEditar.setText("Editar");
                                jButtonDespesaEditar.addActionListener(e -> jButtonDespesaEditarActionPerformed(e));

                                //---- jButtonDespesaSalvar ----
                                jButtonDespesaSalvar.setText("Salvar");
                                jButtonDespesaSalvar.addActionListener(e -> jButtonDespesaSalvarActionPerformed(e));

                                //---- jButtonDespesaApagar ----
                                jButtonDespesaApagar.setText("Apagar");
                                jButtonDespesaApagar.addActionListener(e -> jButtonDespesaApagarActionPerformed(e));

                                //---- jButtonDespesaCancelar ----
                                jButtonDespesaCancelar.setText("Cancelar");
                                jButtonDespesaCancelar.addActionListener(e -> jButtonDespesaCancelarActionPerformed(e));

                                GroupLayout jPanel12Layout = new GroupLayout(jPanel12);
                                jPanel12.setLayout(jPanel12Layout);
                                jPanel12Layout.setHorizontalGroup(
                                    jPanel12Layout.createParallelGroup()
                                        .addGroup(jPanel12Layout.createSequentialGroup()
                                            .addGap(192, 192, 192)
                                            .addComponent(jButtonDespesaNovo)
                                            .addGap(10, 10, 10)
                                            .addComponent(jButtonDespesaEditar)
                                            .addGap(10, 10, 10)
                                            .addComponent(jButtonDespesaApagar)
                                            .addGap(10, 10, 10)
                                            .addComponent(jButtonDespesaSalvar)
                                            .addGap(10, 10, 10)
                                            .addComponent(jButtonDespesaCancelar)
                                            .addContainerGap(189, Short.MAX_VALUE))
                                );
                                jPanel12Layout.linkSize(SwingConstants.HORIZONTAL, new Component[] {jButtonDespesaApagar, jButtonDespesaCancelar, jButtonDespesaEditar, jButtonDespesaNovo, jButtonDespesaSalvar});
                                jPanel12Layout.setVerticalGroup(
                                    jPanel12Layout.createParallelGroup()
                                        .addGroup(jPanel12Layout.createSequentialGroup()
                                            .addContainerGap()
                                            .addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(jButtonDespesaNovo)
                                                .addComponent(jButtonDespesaEditar)
                                                .addComponent(jButtonDespesaApagar)
                                                .addComponent(jButtonDespesaCancelar)
                                                .addComponent(jButtonDespesaSalvar))
                                            .addContainerGap(15, Short.MAX_VALUE))
                                );
                                jPanel12Layout.linkSize(SwingConstants.VERTICAL, new Component[] {jButtonDespesaApagar, jButtonDespesaCancelar, jButtonDespesaEditar, jButtonDespesaNovo, jButtonDespesaSalvar});
                            }

                            //======== jPanel25 ========
                            {
                                jPanel25.setBorder(new TitledBorder("Cadastro de Despesas"));

                                //---- jLabel42 ----
                                jLabel42.setFont(new Font("Tahoma", Font.BOLD, 11));
                                jLabel42.setText("Data");

                                //---- jLabel44 ----
                                jLabel44.setText("Observa\u00e7\u00e3o");

                                //======== jScrollPane9 ========
                                {

                                    //---- jTextAreaDespesaObservacao ----
                                    jTextAreaDespesaObservacao.setColumns(20);
                                    jTextAreaDespesaObservacao.setRows(5);
                                    jScrollPane9.setViewportView(jTextAreaDespesaObservacao);
                                }

                                //---- jLabel47 ----
                                jLabel47.setFont(new Font("Tahoma", Font.BOLD, 11));
                                jLabel47.setText("Funcionario");

                                //---- jLabel48 ----
                                jLabel48.setFont(new Font("Tahoma", Font.BOLD, 11));
                                jLabel48.setText("Valor");

                                //---- jComboBoxDespesaMotivo ----
                                jComboBoxDespesaMotivo.setModel(new DefaultComboBoxModel<>(new String[] {

                                }));

                                //---- jLabel49 ----
                                jLabel49.setFont(new Font("Tahoma", Font.BOLD, 11));
                                jLabel49.setText("Motivo ");

                                //---- jLabel50 ----
                                jLabel50.setFont(new Font("Tahoma", Font.BOLD, 11));
                                jLabel50.setText("favorecido");

                                //---- jComboBoxDespesaFuncionario ----
                                jComboBoxDespesaFuncionario.setModel(new DefaultComboBoxModel<>(new String[] {

                                }));

                                //======== jPanel46 ========
                                {

                                    //---- jButtonDespesaPesquisar ----
                                    jButtonDespesaPesquisar.setText("Pesquisar");
                                    jButtonDespesaPesquisar.addActionListener(e -> jButtonDespesaPesquisarActionPerformed(e));

                                    //---- jLabel45 ----
                                    jLabel45.setText("ID");

                                    //---- jTextFieldDespesaID ----
                                    jTextFieldDespesaID.setEnabled(false);

                                    GroupLayout jPanel46Layout = new GroupLayout(jPanel46);
                                    jPanel46.setLayout(jPanel46Layout);
                                    jPanel46Layout.setHorizontalGroup(
                                        jPanel46Layout.createParallelGroup()
                                            .addGroup(GroupLayout.Alignment.TRAILING, jPanel46Layout.createSequentialGroup()
                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel45)
                                                .addGap(10, 10, 10)
                                                .addGroup(jPanel46Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(jButtonDespesaPesquisar, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                                                    .addComponent(jTextFieldDespesaID))
                                                .addGap(10, 10, 10))
                                    );
                                    jPanel46Layout.setVerticalGroup(
                                        jPanel46Layout.createParallelGroup()
                                            .addGroup(jPanel46Layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addGroup(jPanel46Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel45)
                                                    .addComponent(jTextFieldDespesaID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButtonDespesaPesquisar)
                                                .addGap(10, 10, 10))
                                    );
                                }

                                GroupLayout jPanel25Layout = new GroupLayout(jPanel25);
                                jPanel25.setLayout(jPanel25Layout);
                                jPanel25Layout.setHorizontalGroup(
                                    jPanel25Layout.createParallelGroup()
                                        .addGroup(jPanel25Layout.createSequentialGroup()
                                            .addContainerGap()
                                            .addGroup(jPanel25Layout.createParallelGroup()
                                                .addGroup(jPanel25Layout.createSequentialGroup()
                                                    .addGroup(jPanel25Layout.createParallelGroup()
                                                        .addComponent(jLabel47)
                                                        .addComponent(jLabel42, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel48, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel49)
                                                        .addComponent(jLabel50, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
                                                    .addGap(10, 10, 10)
                                                    .addGroup(jPanel25Layout.createParallelGroup()
                                                        .addGroup(jPanel25Layout.createSequentialGroup()
                                                            .addGroup(jPanel25Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(jComboBoxDespesaFuncionario, GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                                                                .addComponent(jFormattedTextFieldDespesaData, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jTextFieldDespesaValor)
                                                                .addComponent(jTextFieldDespesaFavorecido)
                                                                .addComponent(jComboBoxDespesaMotivo))
                                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addComponent(jPanel46, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel25Layout.createSequentialGroup()
                                                            .addComponent(jScrollPane9, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE)
                                                            .addGap(0, 0, Short.MAX_VALUE))))
                                                .addGroup(jPanel25Layout.createSequentialGroup()
                                                    .addComponent(jLabel44)
                                                    .addGap(0, 0, Short.MAX_VALUE)))
                                            .addContainerGap())
                                );
                                jPanel25Layout.setVerticalGroup(
                                    jPanel25Layout.createParallelGroup()
                                        .addGroup(jPanel25Layout.createSequentialGroup()
                                            .addContainerGap()
                                            .addGroup(jPanel25Layout.createParallelGroup()
                                                .addGroup(jPanel25Layout.createSequentialGroup()
                                                    .addGroup(jPanel25Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel47)
                                                        .addComponent(jComboBoxDespesaFuncionario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                    .addGap(10, 10, 10)
                                                    .addGroup(jPanel25Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel42)
                                                        .addComponent(jFormattedTextFieldDespesaData, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                    .addGap(10, 10, 10)
                                                    .addGroup(jPanel25Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jTextFieldDespesaValor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel48)))
                                                .addComponent(jPanel46, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                            .addGap(10, 10, 10)
                                            .addGroup(jPanel25Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(jComboBoxDespesaMotivo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel49))
                                            .addGap(10, 10, 10)
                                            .addGroup(jPanel25Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel50)
                                                .addComponent(jTextFieldDespesaFavorecido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                            .addGap(10, 10, 10)
                                            .addGroup(jPanel25Layout.createParallelGroup()
                                                .addComponent(jLabel44)
                                                .addComponent(jScrollPane9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                );
                            }

                            GroupLayout jPanel53Layout = new GroupLayout(jPanel53);
                            jPanel53.setLayout(jPanel53Layout);
                            jPanel53Layout.setHorizontalGroup(
                                jPanel53Layout.createParallelGroup()
                                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel53Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(jPanel53Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jPanel12, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jPanel25, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            );
                            jPanel53Layout.setVerticalGroup(
                                jPanel53Layout.createParallelGroup()
                                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel53Layout.createSequentialGroup()
                                        .addGap(0, 0, 0)
                                        .addComponent(jPanel25, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(jPanel12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0))
                            );
                        }

                        GroupLayout jPanel32Layout = new GroupLayout(jPanel32);
                        jPanel32.setLayout(jPanel32Layout);
                        jPanel32Layout.setHorizontalGroup(
                            jPanel32Layout.createParallelGroup()
                                .addGroup(jPanel32Layout.createSequentialGroup()
                                    .addComponent(jPanel53, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, 0))
                        );
                        jPanel32Layout.setVerticalGroup(
                            jPanel32Layout.createParallelGroup()
                                .addGroup(jPanel32Layout.createSequentialGroup()
                                    .addGap(0, 0, 0)
                                    .addComponent(jPanel53, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, 0))
                        );
                    }
                    jPanelDespesa.add(jPanel32, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.NORTHWEST, GridBagConstraints.NONE,
                        new Insets(0, 0, 0, 0), 245, 814));
                }
                jTabbedPane1.addTab("Despesa", jPanelDespesa);

                //======== jPanelTipoReceita ========
                {
                    jPanelTipoReceita.setLayout(new GridBagLayout());

                    //======== jPanel33 ========
                    {
                        jPanel33.setLayout(null);

                        //======== jPanel49 ========
                        {
                            jPanel49.setBorder(new EtchedBorder());
                            jPanel49.setLayout(null);

                            //======== jPanel14 ========
                            {
                                jPanel14.setBorder(new BevelBorder(BevelBorder.RAISED));

                                //---- jButtonTipoReceitaNovo ----
                                jButtonTipoReceitaNovo.setText("Novo");
                                jButtonTipoReceitaNovo.addActionListener(e -> jButtonTipoReceitaNovoActionPerformed(e));

                                //---- jButtonTipoReceitaEditar ----
                                jButtonTipoReceitaEditar.setText("Editar");
                                jButtonTipoReceitaEditar.addActionListener(e -> jButtonTipoReceitaEditarActionPerformed(e));

                                //---- jButtonTipoReceitaSalvar ----
                                jButtonTipoReceitaSalvar.setText("Salvar");
                                jButtonTipoReceitaSalvar.addActionListener(e -> jButtonTipoReceitaSalvarActionPerformed(e));

                                //---- jButtonTipoReceitaApagar ----
                                jButtonTipoReceitaApagar.setText("Apagar");
                                jButtonTipoReceitaApagar.addActionListener(e -> jButtonTipoReceitaApagarActionPerformed(e));

                                //---- jButtonTipoReceitaCancelar ----
                                jButtonTipoReceitaCancelar.setText("Cancelar");
                                jButtonTipoReceitaCancelar.addActionListener(e -> jButtonTipoReceitaCancelarActionPerformed(e));

                                GroupLayout jPanel14Layout = new GroupLayout(jPanel14);
                                jPanel14.setLayout(jPanel14Layout);
                                jPanel14Layout.setHorizontalGroup(
                                    jPanel14Layout.createParallelGroup()
                                        .addGroup(jPanel14Layout.createSequentialGroup()
                                            .addGap(175, 175, 175)
                                            .addComponent(jButtonTipoReceitaNovo)
                                            .addGap(10, 10, 10)
                                            .addComponent(jButtonTipoReceitaEditar)
                                            .addGap(10, 10, 10)
                                            .addComponent(jButtonTipoReceitaApagar)
                                            .addGap(10, 10, 10)
                                            .addComponent(jButtonTipoReceitaSalvar)
                                            .addGap(10, 10, 10)
                                            .addComponent(jButtonTipoReceitaCancelar)
                                            .addContainerGap(206, Short.MAX_VALUE))
                                );
                                jPanel14Layout.linkSize(SwingConstants.HORIZONTAL, new Component[] {jButtonTipoReceitaApagar, jButtonTipoReceitaCancelar, jButtonTipoReceitaEditar, jButtonTipoReceitaNovo, jButtonTipoReceitaSalvar});
                                jPanel14Layout.setVerticalGroup(
                                    jPanel14Layout.createParallelGroup()
                                        .addGroup(jPanel14Layout.createSequentialGroup()
                                            .addGap(10, 10, 10)
                                            .addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(jButtonTipoReceitaNovo)
                                                .addComponent(jButtonTipoReceitaEditar)
                                                .addComponent(jButtonTipoReceitaApagar)
                                                .addComponent(jButtonTipoReceitaCancelar)
                                                .addComponent(jButtonTipoReceitaSalvar))
                                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                );
                                jPanel14Layout.linkSize(SwingConstants.VERTICAL, new Component[] {jButtonTipoReceitaApagar, jButtonTipoReceitaCancelar, jButtonTipoReceitaEditar, jButtonTipoReceitaNovo, jButtonTipoReceitaSalvar});
                            }
                            jPanel49.add(jPanel14);
                            jPanel14.setBounds(new Rectangle(new Point(2, 280), jPanel14.getPreferredSize()));

                            //======== jPanel26 ========
                            {
                                jPanel26.setBorder(new TitledBorder("Tipos de receita"));

                                //---- jLabel51 ----
                                jLabel51.setFont(new Font("Tahoma", Font.BOLD, 11));
                                jLabel51.setText("Nome");

                                //---- jLabel53 ----
                                jLabel53.setFont(new Font("Tahoma", Font.BOLD, 11));
                                jLabel53.setText("Descric\u00e3o");

                                //---- jLabel54 ----
                                jLabel54.setText("Observa\u00e7\u00e3o");

                                //======== jScrollPane10 ========
                                {

                                    //---- jTextAreaTipoReceitaDescricao ----
                                    jTextAreaTipoReceitaDescricao.setColumns(20);
                                    jTextAreaTipoReceitaDescricao.setRows(5);
                                    jScrollPane10.setViewportView(jTextAreaTipoReceitaDescricao);
                                }

                                //======== jScrollPane11 ========
                                {

                                    //---- jTextAreaTipoReceitaObservacao ----
                                    jTextAreaTipoReceitaObservacao.setColumns(20);
                                    jTextAreaTipoReceitaObservacao.setRows(5);
                                    jScrollPane11.setViewportView(jTextAreaTipoReceitaObservacao);
                                }

                                //======== jPanel48 ========
                                {

                                    //---- jButtonTipoReceitaPesquisar ----
                                    jButtonTipoReceitaPesquisar.setText("Pesquisar");
                                    jButtonTipoReceitaPesquisar.addActionListener(e -> jButtonTipoReceitaPesquisarActionPerformed(e));

                                    //---- jLabel55 ----
                                    jLabel55.setText("ID");

                                    //---- jTextFieldTIpoReceitaID ----
                                    jTextFieldTIpoReceitaID.setEnabled(false);

                                    GroupLayout jPanel48Layout = new GroupLayout(jPanel48);
                                    jPanel48.setLayout(jPanel48Layout);
                                    jPanel48Layout.setHorizontalGroup(
                                        jPanel48Layout.createParallelGroup()
                                            .addGroup(GroupLayout.Alignment.TRAILING, jPanel48Layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(jLabel55, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
                                                .addGap(10, 10, 10)
                                                .addGroup(jPanel48Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(jTextFieldTIpoReceitaID)
                                                    .addComponent(jButtonTipoReceitaPesquisar, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE))
                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    );
                                    jPanel48Layout.setVerticalGroup(
                                        jPanel48Layout.createParallelGroup()
                                            .addGroup(jPanel48Layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addGroup(jPanel48Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jTextFieldTIpoReceitaID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel55))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButtonTipoReceitaPesquisar)
                                                .addGap(10, 10, 10))
                                    );
                                }

                                GroupLayout jPanel26Layout = new GroupLayout(jPanel26);
                                jPanel26.setLayout(jPanel26Layout);
                                jPanel26Layout.setHorizontalGroup(
                                    jPanel26Layout.createParallelGroup()
                                        .addGroup(jPanel26Layout.createSequentialGroup()
                                            .addContainerGap()
                                            .addGroup(jPanel26Layout.createParallelGroup()
                                                .addGroup(jPanel26Layout.createSequentialGroup()
                                                    .addGroup(jPanel26Layout.createParallelGroup()
                                                        .addComponent(jLabel51)
                                                        .addComponent(jLabel53))
                                                    .addGap(13, 13, 13))
                                                .addGroup(GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                                                    .addComponent(jLabel54)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)))
                                            .addGroup(jPanel26Layout.createParallelGroup()
                                                .addComponent(jTextFieldTipoReceitaNome, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jScrollPane10, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jScrollPane11, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 254, Short.MAX_VALUE)
                                            .addComponent(jPanel48, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
                                            .addContainerGap())
                                );
                                jPanel26Layout.setVerticalGroup(
                                    jPanel26Layout.createParallelGroup()
                                        .addGroup(jPanel26Layout.createSequentialGroup()
                                            .addContainerGap()
                                            .addGroup(jPanel26Layout.createParallelGroup()
                                                .addComponent(jPanel48, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGroup(jPanel26Layout.createSequentialGroup()
                                                    .addGroup(jPanel26Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jTextFieldTipoReceitaNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel51))
                                                    .addGap(12, 12, 12)
                                                    .addGroup(jPanel26Layout.createParallelGroup()
                                                        .addComponent(jScrollPane10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel53))
                                                    .addGap(10, 10, 10)
                                                    .addGroup(jPanel26Layout.createParallelGroup()
                                                        .addComponent(jLabel54)
                                                        .addComponent(jScrollPane11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
                                );
                            }
                            jPanel49.add(jPanel26);
                            jPanel26.setBounds(2, 2, 800, jPanel26.getPreferredSize().height);

                            {
                                // compute preferred size
                                Dimension preferredSize = new Dimension();
                                for(int i = 0; i < jPanel49.getComponentCount(); i++) {
                                    Rectangle bounds = jPanel49.getComponent(i).getBounds();
                                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                                }
                                Insets insets = jPanel49.getInsets();
                                preferredSize.width += insets.right;
                                preferredSize.height += insets.bottom;
                                jPanel49.setMinimumSize(preferredSize);
                                jPanel49.setPreferredSize(preferredSize);
                            }
                        }
                        jPanel33.add(jPanel49);
                        jPanel49.setBounds(new Rectangle(new Point(0, 0), jPanel49.getPreferredSize()));

                        {
                            // compute preferred size
                            Dimension preferredSize = new Dimension();
                            for(int i = 0; i < jPanel33.getComponentCount(); i++) {
                                Rectangle bounds = jPanel33.getComponent(i).getBounds();
                                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                            }
                            Insets insets = jPanel33.getInsets();
                            preferredSize.width += insets.right;
                            preferredSize.height += insets.bottom;
                            jPanel33.setMinimumSize(preferredSize);
                            jPanel33.setPreferredSize(preferredSize);
                        }
                    }
                    jPanelTipoReceita.add(jPanel33, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.NORTHWEST, GridBagConstraints.NONE,
                        new Insets(0, 0, 0, 0), 66, 770));
                }
                jTabbedPane1.addTab("Tipo/Receita", jPanelTipoReceita);

                //======== jPanelReceitas ========
                {
                    jPanelReceitas.setLayout(new GridBagLayout());

                    //======== jPanel34 ========
                    {

                        //======== jPanel51 ========
                        {

                            //======== jPanel8 ========
                            {
                                jPanel8.setBorder(new BevelBorder(BevelBorder.RAISED));

                                //---- jButtonReceitaNovo ----
                                jButtonReceitaNovo.setText("Novo");
                                jButtonReceitaNovo.addActionListener(e -> jButtonReceitaNovoActionPerformed(e));

                                //---- jButtonReceitaEditar ----
                                jButtonReceitaEditar.setText("Editar");
                                jButtonReceitaEditar.addActionListener(e -> jButtonReceitaEditarActionPerformed(e));

                                //---- jButtonReceitaSalvar ----
                                jButtonReceitaSalvar.setText("Salvar");
                                jButtonReceitaSalvar.addActionListener(e -> jButtonReceitaSalvarActionPerformed(e));

                                //---- jButtonReceitaApagar ----
                                jButtonReceitaApagar.setText("Apagar");
                                jButtonReceitaApagar.addActionListener(e -> jButtonReceitaApagarActionPerformed(e));

                                //---- jButtonReceitaCancelar ----
                                jButtonReceitaCancelar.setText("Cancelar");
                                jButtonReceitaCancelar.addActionListener(e -> jButtonReceitaCancelarActionPerformed(e));

                                GroupLayout jPanel8Layout = new GroupLayout(jPanel8);
                                jPanel8.setLayout(jPanel8Layout);
                                jPanel8Layout.setHorizontalGroup(
                                    jPanel8Layout.createParallelGroup()
                                        .addGroup(jPanel8Layout.createSequentialGroup()
                                            .addGap(188, 188, 188)
                                            .addComponent(jButtonReceitaNovo)
                                            .addGap(10, 10, 10)
                                            .addComponent(jButtonReceitaEditar, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
                                            .addGap(10, 10, 10)
                                            .addComponent(jButtonReceitaApagar, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
                                            .addGap(10, 10, 10)
                                            .addComponent(jButtonReceitaSalvar, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
                                            .addGap(10, 10, 10)
                                            .addComponent(jButtonReceitaCancelar, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                                            .addContainerGap(193, Short.MAX_VALUE))
                                );
                                jPanel8Layout.linkSize(SwingConstants.HORIZONTAL, new Component[] {jButtonReceitaApagar, jButtonReceitaCancelar, jButtonReceitaEditar, jButtonReceitaNovo, jButtonReceitaSalvar});
                                jPanel8Layout.setVerticalGroup(
                                    jPanel8Layout.createParallelGroup()
                                        .addGroup(jPanel8Layout.createSequentialGroup()
                                            .addGap(10, 10, 10)
                                            .addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(jButtonReceitaNovo)
                                                .addComponent(jButtonReceitaEditar)
                                                .addComponent(jButtonReceitaApagar)
                                                .addComponent(jButtonReceitaCancelar)
                                                .addComponent(jButtonReceitaSalvar))
                                            .addContainerGap())
                                );
                                jPanel8Layout.linkSize(SwingConstants.VERTICAL, new Component[] {jButtonReceitaApagar, jButtonReceitaCancelar, jButtonReceitaEditar, jButtonReceitaNovo, jButtonReceitaSalvar});
                            }

                            GroupLayout jPanel51Layout = new GroupLayout(jPanel51);
                            jPanel51.setLayout(jPanel51Layout);
                            jPanel51Layout.setHorizontalGroup(
                                jPanel51Layout.createParallelGroup()
                                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel51Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jPanel8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            );
                            jPanel51Layout.setVerticalGroup(
                                jPanel51Layout.createParallelGroup()
                                    .addGroup(jPanel51Layout.createSequentialGroup()
                                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            );
                        }

                        //======== jPanel27 ========
                        {
                            jPanel27.setBorder(new TitledBorder("Cadastro de Receitas"));

                            //---- jLabel43 ----
                            jLabel43.setFont(new Font("Tahoma", Font.BOLD, 11));
                            jLabel43.setText("Data");

                            //---- jLabel46 ----
                            jLabel46.setText("Observa\u00e7\u00e3o");

                            //======== jScrollPane12 ========
                            {

                                //---- jTextAreaReceitaObservacao ----
                                jTextAreaReceitaObservacao.setColumns(20);
                                jTextAreaReceitaObservacao.setRows(5);
                                jScrollPane12.setViewportView(jTextAreaReceitaObservacao);
                            }

                            //---- jLabel58 ----
                            jLabel58.setFont(new Font("Tahoma", Font.BOLD, 11));
                            jLabel58.setText("Funcionario");

                            //---- jLabel59 ----
                            jLabel59.setFont(new Font("Tahoma", Font.BOLD, 11));
                            jLabel59.setText("Valor");

                            //---- jTextFieldReceitaValor ----
                            jTextFieldReceitaValor.addFocusListener(new FocusAdapter() {
                                @Override
                                public void focusLost(FocusEvent e) {
                                    jTextFieldReceitaValorFocusLost(e);
                                }
                            });

                            //---- jComboBoxReceitaMotivoEntrada ----
                            jComboBoxReceitaMotivoEntrada.setModel(new DefaultComboBoxModel<>(new String[] {

                            }));

                            //---- jLabel60 ----
                            jLabel60.setFont(new Font("Tahoma", Font.BOLD, 11));
                            jLabel60.setText("Motivo ");

                            //---- jLabel61 ----
                            jLabel61.setFont(new Font("Tahoma", Font.BOLD, 11));
                            jLabel61.setText("Socio");

                            //---- jComboBoxReceitaSocio ----
                            jComboBoxReceitaSocio.setModel(new DefaultComboBoxModel<>(new String[] {

                            }));

                            //---- jComboBoxReceitaFuncionario ----
                            jComboBoxReceitaFuncionario.setModel(new DefaultComboBoxModel<>(new String[] {

                            }));

                            //======== jPanel50 ========
                            {

                                //---- jLabel57 ----
                                jLabel57.setText("ID");
                                jLabel57.setEnabled(false);

                                //---- jTextFieldReceitaID ----
                                jTextFieldReceitaID.setEnabled(false);
                                jTextFieldReceitaID.addActionListener(e -> jTextFieldReceitaIDActionPerformed(e));

                                //---- jButtonReceitaPesquisar ----
                                jButtonReceitaPesquisar.setText("Pesquisar");
                                jButtonReceitaPesquisar.addActionListener(e -> jButtonReceitaPesquisarActionPerformed(e));

                                GroupLayout jPanel50Layout = new GroupLayout(jPanel50);
                                jPanel50.setLayout(jPanel50Layout);
                                jPanel50Layout.setHorizontalGroup(
                                    jPanel50Layout.createParallelGroup()
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel50Layout.createSequentialGroup()
                                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel57, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(jPanel50Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jButtonReceitaPesquisar, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                                .addComponent(jTextFieldReceitaID))
                                            .addGap(10, 10, 10))
                                );
                                jPanel50Layout.setVerticalGroup(
                                    jPanel50Layout.createParallelGroup()
                                        .addGroup(jPanel50Layout.createSequentialGroup()
                                            .addGap(10, 10, 10)
                                            .addGroup(jPanel50Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel57)
                                                .addComponent(jTextFieldReceitaID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                            .addGap(10, 10, 10)
                                            .addComponent(jButtonReceitaPesquisar)
                                            .addGap(10, 10, 10))
                                );
                            }

                            //---- jCheckBoxReceitaAvulsa ----
                            jCheckBoxReceitaAvulsa.setText("Entrada Avulsa");
                            jCheckBoxReceitaAvulsa.addActionListener(e -> jCheckBoxReceitaAvulsaActionPerformed(e));

                            GroupLayout jPanel27Layout = new GroupLayout(jPanel27);
                            jPanel27.setLayout(jPanel27Layout);
                            jPanel27Layout.setHorizontalGroup(
                                jPanel27Layout.createParallelGroup()
                                    .addGroup(jPanel27Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(jPanel27Layout.createParallelGroup()
                                            .addComponent(jLabel58)
                                            .addComponent(jLabel43)
                                            .addComponent(jLabel59)
                                            .addComponent(jLabel60)
                                            .addComponent(jLabel61)
                                            .addComponent(jLabel46))
                                        .addGap(10, 10, 10)
                                        .addGroup(jPanel27Layout.createParallelGroup()
                                            .addGroup(jPanel27Layout.createSequentialGroup()
                                                .addGroup(jPanel27Layout.createParallelGroup()
                                                    .addGroup(jPanel27Layout.createSequentialGroup()
                                                        .addGroup(jPanel27Layout.createParallelGroup()
                                                            .addComponent(jComboBoxReceitaFuncionario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jDateChooser1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jPanel50, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(jPanel27Layout.createSequentialGroup()
                                                        .addGroup(jPanel27Layout.createParallelGroup()
                                                            .addComponent(jComboBoxReceitaMotivoEntrada, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addGroup(jPanel27Layout.createSequentialGroup()
                                                                .addComponent(jComboBoxReceitaSocio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(40, 40, 40)
                                                                .addComponent(jCheckBoxReceitaAvulsa)))
                                                        .addGap(0, 0, Short.MAX_VALUE)))
                                                .addContainerGap())
                                            .addGroup(jPanel27Layout.createSequentialGroup()
                                                .addGroup(jPanel27Layout.createParallelGroup()
                                                    .addComponent(jScrollPane12, GroupLayout.PREFERRED_SIZE, 328, GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jTextFieldReceitaValor, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 375, Short.MAX_VALUE))))
                            );
                            jPanel27Layout.setVerticalGroup(
                                jPanel27Layout.createParallelGroup()
                                    .addGroup(jPanel27Layout.createSequentialGroup()
                                        .addGroup(jPanel27Layout.createParallelGroup()
                                            .addGroup(jPanel27Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(jPanel27Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel58)
                                                    .addComponent(jComboBoxReceitaFuncionario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addGap(12, 12, 12)
                                                .addGroup(jPanel27Layout.createParallelGroup()
                                                    .addComponent(jLabel43)
                                                    .addComponent(jDateChooser1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                            .addComponent(jPanel50, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel27Layout.createParallelGroup()
                                            .addComponent(jLabel59)
                                            .addComponent(jTextFieldReceitaValor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addGap(10, 10, 10)
                                        .addGroup(jPanel27Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel60)
                                            .addComponent(jComboBoxReceitaMotivoEntrada, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addGap(9, 9, 9)
                                        .addGroup(jPanel27Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel61)
                                            .addComponent(jComboBoxReceitaSocio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jCheckBoxReceitaAvulsa))
                                        .addGap(8, 8, 8)
                                        .addGroup(jPanel27Layout.createParallelGroup()
                                            .addComponent(jLabel46)
                                            .addComponent(jScrollPane12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addGap(10, 10, 10))
                            );
                        }

                        GroupLayout jPanel34Layout = new GroupLayout(jPanel34);
                        jPanel34.setLayout(jPanel34Layout);
                        jPanel34Layout.setHorizontalGroup(
                            jPanel34Layout.createParallelGroup()
                                .addGroup(jPanel34Layout.createSequentialGroup()
                                    .addGroup(jPanel34Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(jPanel27, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanel51, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    .addGap(0, 0, 0))
                        );
                        jPanel34Layout.setVerticalGroup(
                            jPanel34Layout.createParallelGroup()
                                .addGroup(jPanel34Layout.createSequentialGroup()
                                    .addGap(0, 0, 0)
                                    .addComponent(jPanel27, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, 0)
                                    .addComponent(jPanel51, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, 0))
                        );
                    }
                    jPanelReceitas.add(jPanel34, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.NORTHWEST, GridBagConstraints.NONE,
                        new Insets(0, 0, 0, 0), 76, 764));
                }
                jTabbedPane1.addTab("Receitas", jPanelReceitas);

                //======== jPanelCheques ========
                {
                    jPanelCheques.setLayout(new GridBagLayout());

                    //======== jPanel35 ========
                    {

                        //======== jPanel16 ========
                        {
                            jPanel16.setBorder(new BevelBorder(BevelBorder.RAISED));

                            //---- jButtonChequeNovo ----
                            jButtonChequeNovo.setText("Novo");
                            jButtonChequeNovo.addActionListener(e -> jButtonChequeNovoActionPerformed(e));

                            //---- jButtonChequeEditar ----
                            jButtonChequeEditar.setText("Editar");
                            jButtonChequeEditar.addActionListener(e -> jButtonChequeEditarActionPerformed(e));

                            //---- jButtonChequeSalvar ----
                            jButtonChequeSalvar.setText("Salvar");
                            jButtonChequeSalvar.addActionListener(e -> jButtonChequeSalvarActionPerformed(e));

                            //---- jButtonChequeApagar ----
                            jButtonChequeApagar.setText("Apagar");
                            jButtonChequeApagar.addActionListener(e -> jButtonChequeApagarActionPerformed(e));

                            //---- jButtonChequeCancelar ----
                            jButtonChequeCancelar.setText("Cancelar");
                            jButtonChequeCancelar.addActionListener(e -> jButtonChequeCancelarActionPerformed(e));

                            GroupLayout jPanel16Layout = new GroupLayout(jPanel16);
                            jPanel16.setLayout(jPanel16Layout);
                            jPanel16Layout.setHorizontalGroup(
                                jPanel16Layout.createParallelGroup()
                                    .addGroup(jPanel16Layout.createSequentialGroup()
                                        .addGap(196, 196, 196)
                                        .addComponent(jButtonChequeNovo)
                                        .addGap(10, 10, 10)
                                        .addComponent(jButtonChequeEditar)
                                        .addGap(10, 10, 10)
                                        .addComponent(jButtonChequeApagar)
                                        .addGap(10, 10, 10)
                                        .addComponent(jButtonChequeSalvar)
                                        .addGap(10, 10, 10)
                                        .addComponent(jButtonChequeCancelar)
                                        .addContainerGap(185, Short.MAX_VALUE))
                            );
                            jPanel16Layout.linkSize(SwingConstants.HORIZONTAL, new Component[] {jButtonChequeApagar, jButtonChequeCancelar, jButtonChequeEditar, jButtonChequeNovo, jButtonChequeSalvar});
                            jPanel16Layout.setVerticalGroup(
                                jPanel16Layout.createParallelGroup()
                                    .addGroup(jPanel16Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(jPanel16Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(jButtonChequeNovo)
                                            .addComponent(jButtonChequeEditar)
                                            .addComponent(jButtonChequeApagar)
                                            .addComponent(jButtonChequeCancelar)
                                            .addComponent(jButtonChequeSalvar))
                                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            );
                            jPanel16Layout.linkSize(SwingConstants.VERTICAL, new Component[] {jButtonChequeApagar, jButtonChequeCancelar, jButtonChequeEditar, jButtonChequeNovo, jButtonChequeSalvar});
                        }

                        //======== jPanel15 ========
                        {
                            jPanel15.setBorder(new TitledBorder("Cadastro de Cheques"));

                            //---- jLabel28 ----
                            jLabel28.setFont(new Font("Tahoma", Font.BOLD, 11));
                            jLabel28.setText("Funcionario");

                            //---- jTextFieldChequeValor ----
                            jTextFieldChequeValor.addActionListener(e -> jTextFieldChequeValorActionPerformed(e));

                            //---- jLabel29 ----
                            jLabel29.setText("Data de pagamento");

                            //---- jLabel30 ----
                            jLabel30.setFont(new Font("Tahoma", Font.BOLD, 11));
                            jLabel30.setText("Data de vencimento");

                            //---- jLabel62 ----
                            jLabel62.setFont(new Font("Tahoma", Font.BOLD, 11));
                            jLabel62.setText("Numero");

                            //---- jLabel63 ----
                            jLabel63.setFont(new Font("Tahoma", Font.BOLD, 11));
                            jLabel63.setText("Valor");

                            //---- jComboBoxChequeMotivoDespesa ----
                            jComboBoxChequeMotivoDespesa.setModel(new DefaultComboBoxModel<>(new String[] {

                            }));

                            //---- jLabel64 ----
                            jLabel64.setFont(new Font("Tahoma", Font.BOLD, 11));
                            jLabel64.setText("Motivo da despesa");

                            //======== jScrollPane8 ========
                            {

                                //---- jTextAreaChequeObservacoes ----
                                jTextAreaChequeObservacoes.setColumns(20);
                                jTextAreaChequeObservacoes.setRows(5);
                                jScrollPane8.setViewportView(jTextAreaChequeObservacoes);
                            }

                            //---- jLabel65 ----
                            jLabel65.setText("observa\u00e7\u00f5es");

                            //---- jComboBoxChequeFuncionario ----
                            jComboBoxChequeFuncionario.setModel(new DefaultComboBoxModel<>(new String[] {

                            }));

                            //======== jPanel52 ========
                            {

                                //---- jLabel26 ----
                                jLabel26.setText("ID");

                                //---- jTextFieldChequeID ----
                                jTextFieldChequeID.setEnabled(false);

                                //---- jButtonChequePesquisar ----
                                jButtonChequePesquisar.setText("Pesquisar");
                                jButtonChequePesquisar.addActionListener(e -> jButtonChequePesquisarActionPerformed(e));

                                GroupLayout jPanel52Layout = new GroupLayout(jPanel52);
                                jPanel52.setLayout(jPanel52Layout);
                                jPanel52Layout.setHorizontalGroup(
                                    jPanel52Layout.createParallelGroup()
                                        .addGroup(jPanel52Layout.createSequentialGroup()
                                            .addContainerGap()
                                            .addComponent(jLabel26)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(jPanel52Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jButtonChequePesquisar, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                                                .addComponent(jTextFieldChequeID))
                                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                );
                                jPanel52Layout.setVerticalGroup(
                                    jPanel52Layout.createParallelGroup()
                                        .addGroup(jPanel52Layout.createSequentialGroup()
                                            .addContainerGap()
                                            .addGroup(jPanel52Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel26)
                                                .addComponent(jTextFieldChequeID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jButtonChequePesquisar, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                                            .addGap(10, 10, 10))
                                );
                            }

                            GroupLayout jPanel15Layout = new GroupLayout(jPanel15);
                            jPanel15.setLayout(jPanel15Layout);
                            jPanel15Layout.setHorizontalGroup(
                                jPanel15Layout.createParallelGroup()
                                    .addGroup(jPanel15Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(jPanel15Layout.createParallelGroup()
                                            .addGroup(jPanel15Layout.createSequentialGroup()
                                                .addGroup(jPanel15Layout.createParallelGroup()
                                                    .addComponent(jLabel62)
                                                    .addComponent(jLabel63)
                                                    .addComponent(jLabel28))
                                                .addGap(59, 59, 59)
                                                .addGroup(jPanel15Layout.createParallelGroup()
                                                    .addComponent(jComboBoxChequeFuncionario, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(jPanel15Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jTextFieldChequeValor, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                                                        .addComponent(jTextFieldChequeNumero)))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jPanel52, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel15Layout.createSequentialGroup()
                                                .addGroup(jPanel15Layout.createParallelGroup()
                                                    .addGroup(jPanel15Layout.createSequentialGroup()
                                                        .addGroup(jPanel15Layout.createParallelGroup()
                                                            .addComponent(jLabel64)
                                                            .addComponent(jLabel65))
                                                        .addGap(18, 18, 18)
                                                        .addGroup(jPanel15Layout.createParallelGroup()
                                                            .addComponent(jScrollPane8, GroupLayout.PREFERRED_SIZE, 296, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jComboBoxChequeMotivoDespesa, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)))
                                                    .addGroup(jPanel15Layout.createSequentialGroup()
                                                        .addGroup(jPanel15Layout.createParallelGroup()
                                                            .addComponent(jLabel30)
                                                            .addComponent(jLabel29))
                                                        .addGap(10, 10, 10)
                                                        .addGroup(jPanel15Layout.createParallelGroup()
                                                            .addComponent(jFormattedTextFieldChequeDataPagamento, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jFormattedTextFieldChequeDataVencimento, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE))))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                        .addContainerGap())
                            );
                            jPanel15Layout.setVerticalGroup(
                                jPanel15Layout.createParallelGroup()
                                    .addGroup(jPanel15Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(jPanel15Layout.createParallelGroup()
                                            .addGroup(jPanel15Layout.createSequentialGroup()
                                                .addGroup(jPanel15Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel62)
                                                    .addComponent(jTextFieldChequeNumero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jPanel15Layout.createParallelGroup()
                                                    .addGroup(jPanel15Layout.createSequentialGroup()
                                                        .addGap(10, 10, 10)
                                                        .addComponent(jLabel63))
                                                    .addGroup(jPanel15Layout.createSequentialGroup()
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(jTextFieldChequeValor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                                .addGap(10, 10, 10)
                                                .addGroup(jPanel15Layout.createParallelGroup()
                                                    .addComponent(jLabel28)
                                                    .addComponent(jComboBoxChequeFuncionario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                            .addComponent(jPanel52, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addGap(10, 10, 10)
                                        .addGroup(jPanel15Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel30)
                                            .addComponent(jFormattedTextFieldChequeDataVencimento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addGap(10, 10, 10)
                                        .addGroup(jPanel15Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel29)
                                            .addComponent(jFormattedTextFieldChequeDataPagamento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addGap(10, 10, 10)
                                        .addGroup(jPanel15Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel64)
                                            .addComponent(jComboBoxChequeMotivoDespesa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addGap(10, 10, 10)
                                        .addGroup(jPanel15Layout.createParallelGroup()
                                            .addComponent(jLabel65)
                                            .addComponent(jScrollPane8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addGap(10, 10, 10))
                            );
                        }

                        GroupLayout jPanel35Layout = new GroupLayout(jPanel35);
                        jPanel35.setLayout(jPanel35Layout);
                        jPanel35Layout.setHorizontalGroup(
                            jPanel35Layout.createParallelGroup()
                                .addGroup(jPanel35Layout.createSequentialGroup()
                                    .addGroup(jPanel35Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jPanel15, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel16, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    .addGap(0, 0, 0))
                        );
                        jPanel35Layout.setVerticalGroup(
                            jPanel35Layout.createParallelGroup()
                                .addGroup(jPanel35Layout.createSequentialGroup()
                                    .addGap(0, 0, 0)
                                    .addComponent(jPanel15, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jPanel16, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, 0))
                        );
                    }
                    jPanelCheques.add(jPanel35, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.NORTHWEST, GridBagConstraints.NONE,
                        new Insets(0, 0, 0, 0), 206, 882));
                }
                jTabbedPane1.addTab("Cheques", jPanelCheques);

                //======== jPanelTaxas ========
                {
                    jPanelTaxas.setLayout(new GridBagLayout());

                    //======== jPanel22 ========
                    {

                        GroupLayout jPanel22Layout = new GroupLayout(jPanel22);
                        jPanel22.setLayout(jPanel22Layout);
                        jPanel22Layout.setHorizontalGroup(
                            jPanel22Layout.createParallelGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                        );
                        jPanel22Layout.setVerticalGroup(
                            jPanel22Layout.createParallelGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                        );
                    }
                    jPanelTaxas.add(jPanel22, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.NONE,
                        new Insets(0, 0, 0, 0), 0, 0));

                    //======== jPanel55 ========
                    {

                        //======== jPanel18 ========
                        {
                            jPanel18.setBorder(new BevelBorder(BevelBorder.RAISED));

                            //---- jButtonTaxaNovo ----
                            jButtonTaxaNovo.setText("Novo");
                            jButtonTaxaNovo.addActionListener(e -> jButtonTaxaNovoActionPerformed(e));

                            //---- jButtonTaxaEditar ----
                            jButtonTaxaEditar.setText("Editar");
                            jButtonTaxaEditar.addActionListener(e -> jButtonTaxaEditarActionPerformed(e));

                            //---- jButtonTaxaSalvar ----
                            jButtonTaxaSalvar.setText("Salvar");
                            jButtonTaxaSalvar.addActionListener(e -> jButtonTaxaSalvarActionPerformed(e));

                            //---- jButtonTaxaApagar ----
                            jButtonTaxaApagar.setText("Apagar");
                            jButtonTaxaApagar.addActionListener(e -> jButtonTaxaApagarActionPerformed(e));

                            //---- jButtonTaxaCancelar ----
                            jButtonTaxaCancelar.setText("Cancelar");
                            jButtonTaxaCancelar.addActionListener(e -> jButtonTaxaCancelarActionPerformed(e));

                            GroupLayout jPanel18Layout = new GroupLayout(jPanel18);
                            jPanel18.setLayout(jPanel18Layout);
                            jPanel18Layout.setHorizontalGroup(
                                jPanel18Layout.createParallelGroup()
                                    .addGroup(jPanel18Layout.createSequentialGroup()
                                        .addGap(165, 165, 165)
                                        .addComponent(jButtonTaxaNovo)
                                        .addGap(10, 10, 10)
                                        .addComponent(jButtonTaxaEditar)
                                        .addGap(10, 10, 10)
                                        .addComponent(jButtonTaxaApagar)
                                        .addGap(10, 10, 10)
                                        .addComponent(jButtonTaxaSalvar)
                                        .addGap(10, 10, 10)
                                        .addComponent(jButtonTaxaCancelar)
                                        .addContainerGap(216, Short.MAX_VALUE))
                            );
                            jPanel18Layout.linkSize(SwingConstants.HORIZONTAL, new Component[] {jButtonTaxaApagar, jButtonTaxaCancelar, jButtonTaxaEditar, jButtonTaxaNovo, jButtonTaxaSalvar});
                            jPanel18Layout.setVerticalGroup(
                                jPanel18Layout.createParallelGroup()
                                    .addGroup(jPanel18Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(jPanel18Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(jButtonTaxaNovo)
                                            .addComponent(jButtonTaxaEditar)
                                            .addComponent(jButtonTaxaApagar)
                                            .addComponent(jButtonTaxaCancelar)
                                            .addComponent(jButtonTaxaSalvar))
                                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            );
                            jPanel18Layout.linkSize(SwingConstants.VERTICAL, new Component[] {jButtonTaxaApagar, jButtonTaxaCancelar, jButtonTaxaEditar, jButtonTaxaNovo, jButtonTaxaSalvar});
                        }

                        //======== jPanel13 ========
                        {
                            jPanel13.setBorder(new TitledBorder("Cadastro de Taxas"));

                            //---- jLabel17 ----
                            jLabel17.setFont(new Font("Tahoma", Font.BOLD, 11));
                            jLabel17.setText("Nome");

                            //---- jLabel23 ----
                            jLabel23.setText("Descri\u00e7\u00e3o");

                            //---- jLabel25 ----
                            jLabel25.setFont(new Font("Tahoma", Font.BOLD, 11));
                            jLabel25.setText("Valor");

                            //======== jScrollPane3 ========
                            {

                                //---- jTextAreaTaxasDescricao ----
                                jTextAreaTaxasDescricao.setColumns(20);
                                jTextAreaTaxasDescricao.setRows(5);
                                jScrollPane3.setViewportView(jTextAreaTaxasDescricao);
                            }

                            //======== jPanel54 ========
                            {

                                //---- jButtonTaxasPesquisar ----
                                jButtonTaxasPesquisar.setText("Pesquisar");
                                jButtonTaxasPesquisar.addActionListener(e -> jButtonTaxasPesquisarActionPerformed(e));

                                //---- jTextFieldTaxasID ----
                                jTextFieldTaxasID.setEnabled(false);

                                //---- jLabel15 ----
                                jLabel15.setText("ID");

                                GroupLayout jPanel54Layout = new GroupLayout(jPanel54);
                                jPanel54.setLayout(jPanel54Layout);
                                jPanel54Layout.setHorizontalGroup(
                                    jPanel54Layout.createParallelGroup()
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel54Layout.createSequentialGroup()
                                            .addGap(19, 19, 19)
                                            .addComponent(jLabel15)
                                            .addGap(10, 10, 10)
                                            .addGroup(jPanel54Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jButtonTaxasPesquisar, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                                                .addComponent(jTextFieldTaxasID))
                                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                );
                                jPanel54Layout.setVerticalGroup(
                                    jPanel54Layout.createParallelGroup()
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel54Layout.createSequentialGroup()
                                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(jPanel54Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(jTextFieldTaxasID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel15))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jButtonTaxasPesquisar)
                                            .addGap(10, 10, 10))
                                );
                            }

                            GroupLayout jPanel13Layout = new GroupLayout(jPanel13);
                            jPanel13.setLayout(jPanel13Layout);
                            jPanel13Layout.setHorizontalGroup(
                                jPanel13Layout.createParallelGroup()
                                    .addGroup(jPanel13Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(jPanel13Layout.createParallelGroup()
                                            .addComponent(jLabel25)
                                            .addComponent(jLabel23, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel17, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                                        .addGap(10, 10, 10)
                                        .addGroup(jPanel13Layout.createParallelGroup()
                                            .addComponent(jScrollPane3, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextFieldTaxasValor, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextFieldTaxasNome, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel54, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap())
                            );
                            jPanel13Layout.setVerticalGroup(
                                jPanel13Layout.createParallelGroup()
                                    .addGroup(jPanel13Layout.createSequentialGroup()
                                        .addGroup(jPanel13Layout.createParallelGroup()
                                            .addGroup(jPanel13Layout.createSequentialGroup()
                                                .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel17, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jTextFieldTaxasNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addGap(10, 10, 10)
                                                .addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel25)
                                                    .addComponent(jTextFieldTaxasValor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addGap(10, 10, 10)
                                                .addGroup(jPanel13Layout.createParallelGroup()
                                                    .addComponent(jLabel23)
                                                    .addComponent(jScrollPane3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                            .addComponent(jPanel54, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addGap(10, 10, 10))
                            );
                        }

                        GroupLayout jPanel55Layout = new GroupLayout(jPanel55);
                        jPanel55.setLayout(jPanel55Layout);
                        jPanel55Layout.setHorizontalGroup(
                            jPanel55Layout.createParallelGroup()
                                .addGroup(jPanel55Layout.createSequentialGroup()
                                    .addGap(0, 0, 0)
                                    .addGroup(jPanel55Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jPanel18, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel13, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(0, 0, Short.MAX_VALUE))
                        );
                        jPanel55Layout.setVerticalGroup(
                            jPanel55Layout.createParallelGroup()
                                .addGroup(jPanel55Layout.createSequentialGroup()
                                    .addComponent(jPanel13, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGap(10, 10, 10)
                                    .addComponent(jPanel18, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, 0))
                        );
                    }
                    jPanelTaxas.add(jPanel55, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.NONE,
                        new Insets(0, 0, 0, 0), 0, 0));
                }
                jTabbedPane1.addTab("Taxas", jPanelTaxas);

                //======== jPanelSocio ========
                {
                    jPanelSocio.setLayout(new GridBagLayout());

                    //======== jPanel17 ========
                    {

                        //======== jPanel56 ========
                        {
                            jPanel56.setBorder(new TitledBorder(""));

                            //======== jPanel9 ========
                            {
                                jPanel9.setBorder(new BevelBorder(BevelBorder.RAISED));

                                //---- jButtonSocioNovo ----
                                jButtonSocioNovo.setText("Novo");
                                jButtonSocioNovo.addActionListener(e -> jButtonSocioNovoActionPerformed(e));

                                //---- jButtonSocioEditar ----
                                jButtonSocioEditar.setText("Editar");
                                jButtonSocioEditar.addActionListener(e -> jButtonSocioEditarActionPerformed(e));

                                //---- jButtonSocioSalvar ----
                                jButtonSocioSalvar.setText("Salvar");
                                jButtonSocioSalvar.addActionListener(e -> jButtonSocioSalvarActionPerformed(e));

                                //---- jButtonSocioApagar ----
                                jButtonSocioApagar.setText("Apagar");
                                jButtonSocioApagar.addActionListener(e -> jButtonSocioApagarActionPerformed(e));

                                //---- jButtonSocioCancelar ----
                                jButtonSocioCancelar.setText("Cancelar");
                                jButtonSocioCancelar.addActionListener(e -> jButtonSocioCancelarActionPerformed(e));

                                //---- jButton1 ----
                                jButton1.setText("Importar Funcion\u00e1rio");
                                jButton1.addActionListener(e -> jButton1ActionPerformed(e));

                                GroupLayout jPanel9Layout = new GroupLayout(jPanel9);
                                jPanel9.setLayout(jPanel9Layout);
                                jPanel9Layout.setHorizontalGroup(
                                    jPanel9Layout.createParallelGroup()
                                        .addGroup(jPanel9Layout.createSequentialGroup()
                                            .addGap(40, 40, 40)
                                            .addComponent(jButtonSocioNovo)
                                            .addGap(10, 10, 10)
                                            .addComponent(jButtonSocioEditar)
                                            .addGap(10, 10, 10)
                                            .addComponent(jButtonSocioApagar)
                                            .addGap(10, 10, 10)
                                            .addComponent(jButtonSocioSalvar)
                                            .addGap(10, 10, 10)
                                            .addComponent(jButtonSocioCancelar)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jButton1)
                                            .addGap(109, 109, 109))
                                );
                                jPanel9Layout.linkSize(SwingConstants.HORIZONTAL, new Component[] {jButtonSocioApagar, jButtonSocioCancelar, jButtonSocioEditar, jButtonSocioNovo, jButtonSocioSalvar});
                                jPanel9Layout.setVerticalGroup(
                                    jPanel9Layout.createParallelGroup()
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(jButtonSocioNovo)
                                                .addComponent(jButtonSocioEditar)
                                                .addComponent(jButtonSocioApagar)
                                                .addComponent(jButtonSocioCancelar)
                                                .addComponent(jButtonSocioSalvar)
                                                .addComponent(jButton1))
                                            .addContainerGap())
                                );
                                jPanel9Layout.linkSize(SwingConstants.VERTICAL, new Component[] {jButtonSocioApagar, jButtonSocioCancelar, jButtonSocioEditar, jButtonSocioNovo, jButtonSocioSalvar});
                            }

                            //======== jPanel29 ========
                            {
                                jPanel29.setBorder(new TitledBorder("Detalhes do socio"));

                                //---- jLabel85 ----
                                jLabel85.setFont(new Font("Tahoma", Font.BOLD, 11));
                                jLabel85.setText("Dia  de vencimento");

                                //---- jLabel86 ----
                                jLabel86.setFont(new Font("Tahoma", Font.BOLD, 11));
                                jLabel86.setText("Aprova\u00e7\u00e3o:");

                                //---- jLabel87 ----
                                jLabel87.setFont(new Font("Tahoma", Font.BOLD, 11));
                                jLabel87.setText("data de matricula");

                                //---- jLabel88 ----
                                jLabel88.setFont(new Font("Tahoma", Font.BOLD, 11));
                                jLabel88.setText("Numero de Socio");

                                //---- jLabel89 ----
                                jLabel89.setFont(new Font("Tahoma", Font.BOLD, 11));
                                jLabel89.setText("Categoria de socio");

                                //---- jComboBoxSocioCategoriaSocio ----
                                jComboBoxSocioCategoriaSocio.setModel(new DefaultComboBoxModel<>(new String[] {

                                }));

                                //---- jRadioButtonSocioAtivo ----
                                jRadioButtonSocioAtivo.setBackground(Color.cyan);
                                jRadioButtonSocioAtivo.setText("Ativo");

                                //---- jRadioButtonSocioInativo ----
                                jRadioButtonSocioInativo.setBackground(Color.red);
                                jRadioButtonSocioInativo.setText("Inativo");

                                GroupLayout jPanel29Layout = new GroupLayout(jPanel29);
                                jPanel29.setLayout(jPanel29Layout);
                                jPanel29Layout.setHorizontalGroup(
                                    jPanel29Layout.createParallelGroup()
                                        .addGroup(jPanel29Layout.createSequentialGroup()
                                            .addComponent(jLabel86)
                                            .addGap(18, 18, 18)
                                            .addGroup(jPanel29Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jRadioButtonSocioInativo, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                                                .addComponent(jRadioButtonSocioAtivo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGap(18, 18, 18)
                                            .addGroup(jPanel29Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel85)
                                                .addComponent(jLabel87))
                                            .addGap(10, 10, 10)
                                            .addGroup(jPanel29Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jFormattedTextFieldSocioDataMatricula)
                                                .addComponent(jFormattedTextFieldSocioDiaVencimento, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
                                            .addGap(18, 18, 18)
                                            .addGroup(jPanel29Layout.createParallelGroup()
                                                .addGroup(jPanel29Layout.createSequentialGroup()
                                                    .addComponent(jLabel89)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jComboBoxSocioCategoriaSocio))
                                                .addGroup(jPanel29Layout.createSequentialGroup()
                                                    .addComponent(jLabel88)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(jTextFieldSocioNumeroSocio, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
                                                    .addGap(0, 0, Short.MAX_VALUE)))
                                            .addContainerGap())
                                );
                                jPanel29Layout.setVerticalGroup(
                                    jPanel29Layout.createParallelGroup()
                                        .addGroup(jPanel29Layout.createSequentialGroup()
                                            .addContainerGap()
                                            .addGroup(jPanel29Layout.createParallelGroup()
                                                .addGroup(jPanel29Layout.createSequentialGroup()
                                                    .addComponent(jRadioButtonSocioAtivo)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jRadioButtonSocioInativo))
                                                .addGroup(jPanel29Layout.createSequentialGroup()
                                                    .addGroup(jPanel29Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel86)
                                                        .addComponent(jFormattedTextFieldSocioDiaVencimento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel85)
                                                        .addComponent(jLabel88)
                                                        .addComponent(jTextFieldSocioNumeroSocio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(jPanel29Layout.createParallelGroup()
                                                        .addGroup(jPanel29Layout.createSequentialGroup()
                                                            .addGap(6, 6, 6)
                                                            .addGroup(jPanel29Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jLabel87)
                                                                .addComponent(jFormattedTextFieldSocioDataMatricula, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jLabel89)))
                                                        .addGroup(jPanel29Layout.createSequentialGroup()
                                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                            .addComponent(jComboBoxSocioCategoriaSocio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
                                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                );
                            }

                            //======== jPanel28 ========
                            {
                                jPanel28.setBorder(new TitledBorder("Endere\u00e7o"));

                                //---- jComboBoxSocioLogradouro ----
                                jComboBoxSocioLogradouro.setModel(new DefaultComboBoxModel<>(new String[] {

                                }));

                                //---- jLabel80 ----
                                jLabel80.setFont(new Font("Tahoma", Font.BOLD, 11));
                                jLabel80.setText("N\u00famero");

                                //---- jLabel81 ----
                                jLabel81.setText("Bairro");

                                //---- jLabel82 ----
                                jLabel82.setText("Cidade");

                                //---- jLabel83 ----
                                jLabel83.setFont(new Font("Tahoma", Font.BOLD, 11));
                                jLabel83.setText("UF");

                                //---- jLabel84 ----
                                jLabel84.setText("CEP");

                                //---- Logradouro2 ----
                                Logradouro2.setFont(new Font("Tahoma", Font.BOLD, 11));
                                Logradouro2.setText("Logradouro");

                                //---- jComboBoxSocioUF ----
                                jComboBoxSocioUF.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
                                "",
                                "AC",
                                "AL",
                                "AP",
                                "AM",
                                "BA",
                                "CE",
                                "DF",
                                "ES",
                                "GO",
                                "MA",
                                "MT",
                                "MS",
                                "MG",
                                "PA",
                                "PB",
                                "PR",
                                "PE",
                                "PI",
                                "RJ",
                                "RN",
                                "RS",
                                "RO",
                                "RR",
                                "SC",
                                "SE",
                                "TO"
                                }));
                                jComboBoxSocioUF.addActionListener(e -> jComboBoxSocioUFActionPerformed(e));

                                //---- jButtonSocioAdicionarLogradouro ----
                                jButtonSocioAdicionarLogradouro.setText("Editar");
                                jButtonSocioAdicionarLogradouro.addActionListener(e -> jButtonSocioAdicionarLogradouroActionPerformed(e));

                                GroupLayout jPanel28Layout = new GroupLayout(jPanel28);
                                jPanel28.setLayout(jPanel28Layout);
                                jPanel28Layout.setHorizontalGroup(
                                    jPanel28Layout.createParallelGroup()
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
                                            .addGroup(jPanel28Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                .addGroup(GroupLayout.Alignment.LEADING, jPanel28Layout.createSequentialGroup()
                                                    .addComponent(Logradouro2)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                    .addGroup(jPanel28Layout.createParallelGroup()
                                                        .addGroup(jPanel28Layout.createSequentialGroup()
                                                            .addGroup(jPanel28Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                .addGroup(jPanel28Layout.createSequentialGroup()
                                                                    .addGap(1, 1, 1)
                                                                    .addComponent(jTextFieldSocioNumero, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
                                                                .addComponent(jTextFieldSocioBairro))
                                                            .addGap(0, 0, Short.MAX_VALUE))
                                                        .addGroup(jPanel28Layout.createSequentialGroup()
                                                            .addComponent(jComboBoxSocioLogradouro)
                                                            .addGap(10, 10, 10)
                                                            .addComponent(jButtonSocioAdicionarLogradouro)
                                                            .addGap(18, 18, 18))))
                                                .addComponent(jLabel81, GroupLayout.Alignment.LEADING)
                                                .addGroup(GroupLayout.Alignment.LEADING, jPanel28Layout.createSequentialGroup()
                                                    .addComponent(jLabel80)
                                                    .addGap(153, 153, 153)
                                                    .addComponent(jLabel83)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(jComboBoxSocioUF, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(jPanel28Layout.createParallelGroup()
                                                .addComponent(jLabel82)
                                                .addGroup(jPanel28Layout.createSequentialGroup()
                                                    .addGap(10, 10, 10)
                                                    .addComponent(jLabel84)))
                                            .addGap(18, 18, 18)
                                            .addGroup(jPanel28Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jTextFieldSocioCEP)
                                                .addComponent(jTextFieldSocioCep2, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))
                                            .addContainerGap())
                                );
                                jPanel28Layout.setVerticalGroup(
                                    jPanel28Layout.createParallelGroup()
                                        .addGroup(jPanel28Layout.createSequentialGroup()
                                            .addContainerGap()
                                            .addGroup(jPanel28Layout.createParallelGroup()
                                                .addGroup(jPanel28Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel82)
                                                    .addComponent(jTextFieldSocioCep2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jPanel28Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel83)
                                                    .addComponent(jComboBoxSocioUF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jPanel28Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel80)
                                                    .addComponent(jTextFieldSocioNumero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(jPanel28Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel81)
                                                .addComponent(jTextFieldSocioBairro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel84)
                                                .addComponent(jTextFieldSocioCEP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(jPanel28Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(Logradouro2)
                                                .addComponent(jComboBoxSocioLogradouro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jButtonSocioAdicionarLogradouro))
                                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                );
                            }

                            //======== jPanel23 ========
                            {
                                jPanel23.setBorder(new TitledBorder("Informa\u00e7\u00f5es Pessoais"));

                                //======== jPanel36 ========
                                {

                                    //---- jLabel70 ----
                                    jLabel70.setText("Email");

                                    //---- jTextFieldSocioEmail ----
                                    jTextFieldSocioEmail.addActionListener(e -> jTextFieldSocioEmailActionPerformed(e));

                                    //---- jLabel74 ----
                                    jLabel74.setFont(new Font("Tahoma", Font.BOLD, 11));
                                    jLabel74.setText("Sexo");

                                    //---- jComboBoxSocioSexo ----
                                    jComboBoxSocioSexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"","Masculino","Feminino" }));

                                    //---- jLabel79 ----
                                    jLabel79.setText("Nome do Pai");

                                    //---- jLabel72 ----
                                    jLabel72.setText("Nome da M\u00e3e");

                                    GroupLayout jPanel36Layout = new GroupLayout(jPanel36);
                                    jPanel36.setLayout(jPanel36Layout);
                                    jPanel36Layout.setHorizontalGroup(
                                        jPanel36Layout.createParallelGroup()
                                            .addGroup(jPanel36Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(jPanel36Layout.createParallelGroup()
                                                    .addGroup(jPanel36Layout.createSequentialGroup()
                                                        .addGroup(jPanel36Layout.createParallelGroup()
                                                            .addComponent(jLabel72)
                                                            .addComponent(jLabel79))
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addGroup(jPanel36Layout.createParallelGroup()
                                                            .addComponent(jTextFieldSocioNomePai)
                                                            .addComponent(jTextFieldSocioNomeMae)))
                                                    .addGroup(jPanel36Layout.createSequentialGroup()
                                                        .addGroup(jPanel36Layout.createParallelGroup()
                                                            .addComponent(jLabel70)
                                                            .addComponent(jLabel74))
                                                        .addGap(48, 48, 48)
                                                        .addGroup(jPanel36Layout.createParallelGroup()
                                                            .addGroup(jPanel36Layout.createSequentialGroup()
                                                                .addComponent(jComboBoxSocioSexo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 256, Short.MAX_VALUE))
                                                            .addComponent(jTextFieldSocioEmail))))
                                                .addGap(0, 0, 0))
                                    );
                                    jPanel36Layout.setVerticalGroup(
                                        jPanel36Layout.createParallelGroup()
                                            .addGroup(jPanel36Layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addGroup(jPanel36Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel70)
                                                    .addComponent(jTextFieldSocioEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addGap(10, 10, 10)
                                                .addGroup(jPanel36Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel74)
                                                    .addComponent(jComboBoxSocioSexo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addGap(10, 10, 10)
                                                .addGroup(jPanel36Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel79)
                                                    .addComponent(jTextFieldSocioNomePai, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addGap(10, 10, 10)
                                                .addGroup(jPanel36Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel72)
                                                    .addComponent(jTextFieldSocioNomeMae, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    );
                                }

                                //======== jPanel37 ========
                                {

                                    //---- jTextFieldSocioApelido ----
                                    jTextFieldSocioApelido.addActionListener(e -> jTextFieldSocioApelidoActionPerformed(e));

                                    //---- jLabel67 ----
                                    jLabel67.setFont(new Font("Tahoma", Font.BOLD, 11));
                                    jLabel67.setText("Nome");

                                    //---- jLabel66 ----
                                    jLabel66.setFont(new Font("Tahoma", Font.BOLD, 11));
                                    jLabel66.setText("Sobrenome");

                                    //---- jLabel68 ----
                                    jLabel68.setText("Apelido");

                                    //---- jLabel69 ----
                                    jLabel69.setText("Telefone");

                                    //---- jLabel71 ----
                                    jLabel71.setText("Nascimento");

                                    //---- jFormattedTextFieldSocioDataNascimento ----
                                    jFormattedTextFieldSocioDataNascimento.addActionListener(e -> jFormattedTextFieldSocioDataNascimentoActionPerformed(e));

                                    GroupLayout jPanel37Layout = new GroupLayout(jPanel37);
                                    jPanel37.setLayout(jPanel37Layout);
                                    jPanel37Layout.setHorizontalGroup(
                                        jPanel37Layout.createParallelGroup()
                                            .addGroup(jPanel37Layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addGroup(jPanel37Layout.createParallelGroup()
                                                    .addComponent(jLabel66)
                                                    .addComponent(jLabel67)
                                                    .addComponent(jLabel68)
                                                    .addComponent(jLabel69)
                                                    .addComponent(jLabel71))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                                                .addGroup(jPanel37Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jTextFieldSocioNome, GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                                                    .addComponent(jTextFieldSocioApelido)
                                                    .addComponent(jTextFieldSocioSobrenome)
                                                    .addComponent(jTextFieldSocioTelefone)
                                                    .addComponent(jFormattedTextFieldSocioDataNascimento, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)))
                                    );
                                    jPanel37Layout.setVerticalGroup(
                                        jPanel37Layout.createParallelGroup()
                                            .addGroup(jPanel37Layout.createSequentialGroup()
                                                .addGap(5, 5, 5)
                                                .addGroup(jPanel37Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel67)
                                                    .addComponent(jTextFieldSocioNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addGap(10, 10, 10)
                                                .addGroup(jPanel37Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel66)
                                                    .addComponent(jTextFieldSocioSobrenome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addGap(10, 10, 10)
                                                .addGroup(jPanel37Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel68)
                                                    .addComponent(jTextFieldSocioApelido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addGap(10, 10, 10)
                                                .addGroup(jPanel37Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel69)
                                                    .addComponent(jTextFieldSocioTelefone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addGap(10, 10, 10)
                                                .addGroup(jPanel37Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel71)
                                                    .addComponent(jFormattedTextFieldSocioDataNascimento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addGap(10, 10, 10))
                                    );
                                }

                                //======== jPanel38 ========
                                {

                                    //---- jButtonSocioPesquisar ----
                                    jButtonSocioPesquisar.setText("Pesquisar");
                                    jButtonSocioPesquisar.addActionListener(e -> jButtonSocioPesquisarActionPerformed(e));

                                    //---- jTextFieldSocioID ----
                                    jTextFieldSocioID.setEditable(false);
                                    jTextFieldSocioID.addActionListener(e -> jTextFieldSocioIDActionPerformed(e));

                                    //---- jLabel73 ----
                                    jLabel73.setText("ID");

                                    GroupLayout jPanel38Layout = new GroupLayout(jPanel38);
                                    jPanel38.setLayout(jPanel38Layout);
                                    jPanel38Layout.setHorizontalGroup(
                                        jPanel38Layout.createParallelGroup()
                                            .addGroup(GroupLayout.Alignment.TRAILING, jPanel38Layout.createSequentialGroup()
                                                .addContainerGap(95, Short.MAX_VALUE)
                                                .addComponent(jLabel73)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel38Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(jButtonSocioPesquisar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jTextFieldSocioID, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
                                                .addContainerGap())
                                    );
                                    jPanel38Layout.setVerticalGroup(
                                        jPanel38Layout.createParallelGroup()
                                            .addGroup(jPanel38Layout.createSequentialGroup()
                                                .addGroup(jPanel38Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jTextFieldSocioID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel73, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
                                                .addGap(10, 10, 10)
                                                .addComponent(jButtonSocioPesquisar)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                    );
                                }

                                //======== jPanel39 ========
                                {

                                    //---- jLabel76 ----
                                    jLabel76.setText("Rg Numero");

                                    //---- jLabel75 ----
                                    jLabel75.setFont(new Font("Tahoma", Font.BOLD, 11));
                                    jLabel75.setText("CPF");

                                    //---- jLabel78 ----
                                    jLabel78.setText("Data de Emissao");

                                    //---- jLabel90 ----
                                    jLabel90.setFont(new Font("Tahoma", Font.BOLD, 11));
                                    jLabel90.setText("CNPJ");

                                    //---- jRadioCPFCNPJ ----
                                    jRadioCPFCNPJ.setText("Alternar");
                                    jRadioCPFCNPJ.addActionListener(e -> jRadioCPFCNPJActionPerformed(e));

                                    //---- jCheckBoxExclusivamenteSocio ----
                                    jCheckBoxExclusivamenteSocio.setText("Exclusivamente Socio");

                                    GroupLayout jPanel39Layout = new GroupLayout(jPanel39);
                                    jPanel39.setLayout(jPanel39Layout);
                                    jPanel39Layout.setHorizontalGroup(
                                        jPanel39Layout.createParallelGroup()
                                            .addGroup(jPanel39Layout.createSequentialGroup()
                                                .addGroup(jPanel39Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                    .addGroup(jPanel39Layout.createSequentialGroup()
                                                        .addComponent(jLabel78)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(jFormattedTextFieldSocioDataEmissao, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(GroupLayout.Alignment.LEADING, jPanel39Layout.createSequentialGroup()
                                                        .addGap(5, 5, 5)
                                                        .addGroup(jPanel39Layout.createParallelGroup()
                                                            .addComponent(jLabel76)
                                                            .addComponent(jLabel75))
                                                        .addGap(31, 31, 31)
                                                        .addGroup(jPanel39Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                            .addComponent(jTextFieldSocioRgNumero)
                                                            .addComponent(jFormattedTextFieldSocioCPF, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE))))
                                                .addGroup(jPanel39Layout.createParallelGroup()
                                                    .addGroup(jPanel39Layout.createSequentialGroup()
                                                        .addGap(10, 10, 10)
                                                        .addComponent(jLabel90)
                                                        .addGap(14, 14, 14)
                                                        .addComponent(jFormattedCNPJ, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jRadioCPFCNPJ)
                                                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel39Layout.createSequentialGroup()
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jCheckBoxExclusivamenteSocio)
                                                        .addContainerGap())))
                                    );
                                    jPanel39Layout.setVerticalGroup(
                                        jPanel39Layout.createParallelGroup()
                                            .addGroup(jPanel39Layout.createSequentialGroup()
                                                .addGroup(jPanel39Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel75)
                                                    .addComponent(jFormattedTextFieldSocioCPF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel90)
                                                    .addComponent(jFormattedCNPJ, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jRadioCPFCNPJ))
                                                .addGap(8, 8, 8)
                                                .addGroup(jPanel39Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel76)
                                                    .addComponent(jTextFieldSocioRgNumero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jPanel39Layout.createParallelGroup()
                                                    .addGroup(jPanel39Layout.createSequentialGroup()
                                                        .addGap(10, 10, 10)
                                                        .addGroup(jPanel39Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                            .addComponent(jLabel78)
                                                            .addComponent(jFormattedTextFieldSocioDataEmissao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                        .addGap(10, 10, 10))
                                                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel39Layout.createSequentialGroup()
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jCheckBoxExclusivamenteSocio)
                                                        .addGap(16, 16, 16))))
                                    );
                                }

                                //---- jLabel77 ----
                                jLabel77.setText("Org\u00e3o Expedidor");

                                GroupLayout jPanel23Layout = new GroupLayout(jPanel23);
                                jPanel23.setLayout(jPanel23Layout);
                                jPanel23Layout.setHorizontalGroup(
                                    jPanel23Layout.createParallelGroup()
                                        .addComponent(jSeparator4)
                                        .addComponent(jPanel39, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel23Layout.createSequentialGroup()
                                            .addGroup(jPanel23Layout.createParallelGroup()
                                                .addGroup(jPanel23Layout.createSequentialGroup()
                                                    .addGap(10, 10, 10)
                                                    .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addGroup(jPanel23Layout.createSequentialGroup()
                                                            .addComponent(jPanel37, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(jPanel36, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(jPanel38, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                                .addGroup(jPanel23Layout.createSequentialGroup()
                                                    .addComponent(jLabel77)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(jTextFieldSocioOrgaoExpedidor, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)))
                                            .addGap(0, 0, Short.MAX_VALUE))
                                );
                                jPanel23Layout.setVerticalGroup(
                                    jPanel23Layout.createParallelGroup()
                                        .addGroup(jPanel23Layout.createSequentialGroup()
                                            .addGap(0, 0, 0)
                                            .addComponent(jPanel38, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addGap(10, 10, 10)
                                            .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jPanel37, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jPanel36, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGap(0, 0, 0)
                                            .addComponent(jSeparator4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addGap(10, 10, 10)
                                            .addGroup(jPanel23Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel77)
                                                .addComponent(jTextFieldSocioOrgaoExpedidor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                            .addGap(10, 10, 10)
                                            .addComponent(jPanel39, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, 0))
                                );
                            }

                            GroupLayout jPanel56Layout = new GroupLayout(jPanel56);
                            jPanel56.setLayout(jPanel56Layout);
                            jPanel56Layout.setHorizontalGroup(
                                jPanel56Layout.createParallelGroup()
                                    .addComponent(jPanel9, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel29, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel28, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel23, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            );
                            jPanel56Layout.setVerticalGroup(
                                jPanel56Layout.createParallelGroup()
                                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel56Layout.createSequentialGroup()
                                        .addGap(0, 0, 0)
                                        .addComponent(jPanel23, GroupLayout.PREFERRED_SIZE, 365, GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(jPanel28, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(jPanel29, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(jPanel9, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0))
                            );
                        }

                        GroupLayout jPanel17Layout = new GroupLayout(jPanel17);
                        jPanel17.setLayout(jPanel17Layout);
                        jPanel17Layout.setHorizontalGroup(
                            jPanel17Layout.createParallelGroup()
                                .addComponent(jPanel56, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        );
                        jPanel17Layout.setVerticalGroup(
                            jPanel17Layout.createParallelGroup()
                                .addGroup(jPanel17Layout.createSequentialGroup()
                                    .addGap(0, 0, 0)
                                    .addComponent(jPanel56, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, 0))
                        );
                    }
                    jPanelSocio.add(jPanel17, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.NONE,
                        new Insets(0, 0, 0, 0), 0, 0));
                }
                jTabbedPane1.addTab("S\u00f3cio", jPanelSocio);
            }

            GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup()
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addComponent(jTabbedPane1, GroupLayout.DEFAULT_SIZE, 995, Short.MAX_VALUE))
            );
            jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup()
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addComponent(jTabbedPane1, GroupLayout.DEFAULT_SIZE, 752, Short.MAX_VALUE)
                        .addGap(0, 0, 0))
            );
        }

        //======== jDesktopPane1 ========
        {
            jDesktopPane1.setBackground(new Color(0xf0f0f0));
            jDesktopPane1.setOpaque(false);
            jDesktopPane1.setLayout(null);

            //======== jInternalFrame1 ========
            {
                jInternalFrame1.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
                var jInternalFrame1ContentPane = jInternalFrame1.getContentPane();

                //======== jScrollPane4 ========
                {
                    jScrollPane4.setAutoscrolls(true);

                    //---- jTable1 ----
                    jTable1.setAutoCreateRowSorter(true);
                    jTable1.setModel(new DefaultTableModel());
                    jTable1.setToolTipText("");
                    jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                    jTable1.setSelectionBackground(new Color(0x33ffff));
                    jTable1.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            jTable1MouseClicked(e);
                        }
                    });
                    jScrollPane4.setViewportView(jTable1);
                }

                //======== jPanel19 ========
                {

                    //---- jLabel31 ----
                    jLabel31.setText("Pesquisar");

                    //---- jTextField2 ----
                    jTextField2.addActionListener(e -> jTextField2ActionPerformed(e));

                    //---- jButtonPesquisa ----
                    jButtonPesquisa.setIcon(new ImageIcon(getClass().getResource("/img/pesquisar.gif")));
                    jButtonPesquisa.setBorder(new BevelBorder(BevelBorder.RAISED));
                    jButtonPesquisa.addActionListener(e -> jButtonPesquisaActionPerformed(e));

                    //---- jButtonInternalFrameVoltar ----
                    jButtonInternalFrameVoltar.setText("Voltar");
                    jButtonInternalFrameVoltar.addActionListener(e -> jButtonInternalFrameVoltarActionPerformed(e));

                    GroupLayout jPanel19Layout = new GroupLayout(jPanel19);
                    jPanel19.setLayout(jPanel19Layout);
                    jPanel19Layout.setHorizontalGroup(
                        jPanel19Layout.createParallelGroup()
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addComponent(jLabel31)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonPesquisa, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonInternalFrameVoltar, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 410, Short.MAX_VALUE))
                    );
                    jPanel19Layout.setVerticalGroup(
                        jPanel19Layout.createParallelGroup()
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addGroup(jPanel19Layout.createParallelGroup()
                                    .addGroup(jPanel19Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(jPanel19Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel31)
                                            .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel19Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jButtonInternalFrameVoltar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonPesquisa, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    );
                }

                GroupLayout jInternalFrame1ContentPaneLayout = new GroupLayout(jInternalFrame1ContentPane);
                jInternalFrame1ContentPane.setLayout(jInternalFrame1ContentPaneLayout);
                jInternalFrame1ContentPaneLayout.setHorizontalGroup(
                    jInternalFrame1ContentPaneLayout.createParallelGroup()
                        .addComponent(jScrollPane4, GroupLayout.DEFAULT_SIZE, 774, Short.MAX_VALUE)
                        .addComponent(jPanel19, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                );
                jInternalFrame1ContentPaneLayout.setVerticalGroup(
                    jInternalFrame1ContentPaneLayout.createParallelGroup()
                        .addGroup(jInternalFrame1ContentPaneLayout.createSequentialGroup()
                            .addComponent(jScrollPane4, GroupLayout.DEFAULT_SIZE, 611, Short.MAX_VALUE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPanel19, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                );
            }
            jDesktopPane1.add(jInternalFrame1);
            jInternalFrame1.setBounds(0, 0, 790, 700);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < jDesktopPane1.getComponentCount(); i++) {
                    Rectangle bounds = jDesktopPane1.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = jDesktopPane1.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                jDesktopPane1.setMinimumSize(preferredSize);
                jDesktopPane1.setPreferredSize(preferredSize);
            }
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createParallelGroup()
                    .addComponent(jDesktopPane1, GroupLayout.DEFAULT_SIZE, 995, Short.MAX_VALUE))
                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createParallelGroup()
                    .addGroup(contentPaneLayout.createSequentialGroup()
                        .addComponent(jDesktopPane1, GroupLayout.DEFAULT_SIZE, 741, Short.MAX_VALUE)
                        .addContainerGap()))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());

        //---- buttonGroupSocioAprovacao ----
        buttonGroupSocioAprovacao.add(jRadioButtonSocioAtivo);
        buttonGroupSocioAprovacao.add(jRadioButtonSocioInativo);
        }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

        telaPrincipal.setEnabled(true);
        telaPrincipal.setVisible(true);
        telaPrincipal.toFront();

    }//GEN-LAST:event_formWindowClosed

    private void jButtonFuncionarioNovoActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonFuncionarioNovoActionPerformed

       
        editableTextFields(true);
        if(!this.cadastrar){
        limparCampos();
        }
        jButtonFuncionarioApagar.setEnabled(false);
        jButtonFuncionarioEditar.setEnabled(false);
        jButtonFuncionarioNovo.setEnabled(false);

        if (jComboBoxFuncionarioLograduro.getItemCount() == 0) {
            jComboBoxFuncionarioLograduro.addItem("");
            List<Endereco> enderecos = new DaoEndereco().BuscarTodosEnderecos();
            for (Endereco endereco : enderecos) {

                jComboBoxFuncionarioLograduro.addItem(endereco.getTipo()+" "+endereco.getNome());

            }
        }
        jComboBoxFuncionarioLograduro.setSelectedItem("");
        this.cadastrar = false;
    }//GEN-LAST:event_jButtonFuncionarioNovoActionPerformed

    private void jTextFieldFuncionarioNomeActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jTextFieldFuncionarioNomeActionPerformed

        if (jButtonFuncionarioNovo.isEnabled()) {
            String nome = jTextFieldFuncionarioNome.getText();
            if (nome.matches("\\w+\\s\\w+")) {
                Pessoa pessoa = new DaoPessoa().BuscarNomeCompleto(jTextFieldFuncionarioNome.getText());
                if (pessoa != null) {

                    preencherAbaFuncionarios(pessoa);
                    jButtonFuncionarioApagar.setEnabled(true);
                    jButtonFuncionarioEditar.setEnabled(true);
                    jButtonFuncionarioCancelar.setEnabled(true);



                } else {

                    JOptionPane.showMessageDialog(this, "Funcionário não encontrado");
                    jTextFieldFuncionarioNome.setText("");
                }

            } else {

                JOptionPane.showMessageDialog(this, "Para fazer uma pesquisa por nome é necessário digitar o sobrenome");
            }
        } else {

            JOptionPane.showMessageDialog(this, "Para realizar uma pesquisa é necessário primeiro cancelar a operação ");
        }
    }//GEN-LAST:event_jTextFieldFuncionarioNomeActionPerformed

    private void jButtonFuncionarioPesquisarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonFuncionarioPesquisarActionPerformed

        if (jButtonFuncionarioNovo.isEnabled()) {

            pesquisarTable = "funcionarios";
            mostrarJtable();

        } else {

            JOptionPane.showMessageDialog(this, "É preciso cancelar a operação de inclusão para realizar pesquisa!");
        }
    }//GEN-LAST:event_jButtonFuncionarioPesquisarActionPerformed

    private void jButtonFuncionarioCancelarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonFuncionarioCancelarActionPerformed
        editableTextFields(false);
        jButtonFuncionarioCancelar.setEnabled(false);
        jButtonFuncionarioEditar.setEnabled(false);
        jButtonFuncionarioApagar.setEnabled(false);
        jButtonFuncionarioSalvar.setEnabled(false);
        jButtonFuncionarioNovo.setEnabled(true);
        limparCampos();
    }//GEN-LAST:event_jButtonFuncionarioCancelarActionPerformed

    private void jButtonFuncionarioEditarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonFuncionarioEditarActionPerformed

        // JOptionPane.showMessageDialog(this, "Você está em modo de edição, as informações só serão gravadas depois de clicar em salvar!");
        editableTextFields(true);
        jButtonFuncionarioSalvar.setEnabled(true);
        jButtonFuncionarioCancelar.setEnabled(true);
        jButtonFuncionarioNovo.setEnabled(false);
        jButtonFuncionarioApagar.setEnabled(false);
        jButtonFuncionarioEditar.setEnabled(false);

    }//GEN-LAST:event_jButtonFuncionarioEditarActionPerformed

    private void jButtonFuncionarioApagarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonFuncionarioApagarActionPerformed

        int result = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja excluir o registro?", "Apagar", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (result == JOptionPane.YES_OPTION) {

            try {
                Pessoa p = new DaoPessoa().BuscarPessoaId(Integer.parseInt(jTextFieldFuncionarioID.getText()));
                new DaoPessoa().ApagarPessoa(p);
                JOptionPane.showMessageDialog(this, "Registro excluido com sucesso!", "", JOptionPane.INFORMATION_MESSAGE);
                limparCampos();
                jButtonFuncionarioCancelarActionPerformed(evt);
            } catch (Exception e) {

                JOptionPane.showMessageDialog(this, "Erro para excluir o registro");
            }

        }
    }//GEN-LAST:event_jButtonFuncionarioApagarActionPerformed

    private void jButtonFuncionarioSalvarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonFuncionarioSalvarActionPerformed


        if (isCamposFuncionariosPreenchidos()) {

            if (jTextFieldFuncionarioID.getText().equals("")) {
                int op = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja gravar os dados?", "Salvar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (op == JOptionPane.YES_OPTION) {

                    Pattern p1 = Pattern.compile("\\d{2}\\/\\d{2}\\/\\d{4}");;
                    Matcher m;
                    try {
                        Pessoa p = new Pessoa();
                        p.setNome(jTextFieldFuncionarioNome.getText());
                        p.setSobrenome(jTextFieldFuncionarioSobrenome.getText());
                        p.setApelido(jTextFieldFuncionarioApelido.getText());
                        p.setTelefone(jTextFieldFuncionarioTelefone.getText());
                        p.setEmail(jTextFieldFuncionarioEmail.getText());
                        p.setSexo((String) jComboBoxFuncionarioSexo.getSelectedItem());
                        p.setNomeMae(jTextFieldFuncionarioNomedame.getText());
                        p.setNomePai(jTextFieldFuncionarioNomedopai.getText());
                        Pessoa p0 = new DaoPessoa().BuscarPessoaCpf(jFormattedTextFieldFuncionarioCpf.getText());
                        if (p0 != null) {
                            JOptionPane.showMessageDialog(this, "Esse cpf já existe", "Erro", JOptionPane.ERROR_MESSAGE);
                            jFormattedTextFieldFuncionarioCpf.setText("");

                            throw new Exception();
                        }
                        p.setCpf(jFormattedTextFieldFuncionarioCpf.getText());
                        p.setRgNumero(jTextFieldFuncionarioRgnumero.getText());
                        p.setRgExpedidor(jTextFieldFuncionarioOrgaoExpedidor.getText());
                        p.setNumeroEndereco(jTextFieldFuncionarioNumero.getText());
                        p.setCidade(jTextFieldFuncionarioCidade.getText());
                        p.setBairro(jTextFieldFuncionarioBairro.getText());
                        p.setUf((String) jComboBoxFuncionarioUf.getSelectedItem());
                        p.setCep(jTextFieldFuncionarioCep.getText());

                        m = p1.matcher(jFormattedTextFieldFuncionarioDataNascimento.getText());

                        if (m.find()) {

                            p.setDataNasc(SimpleDateFormat.getDateInstance().parse(jFormattedTextFieldFuncionarioDataNascimento.getText()));
                        }



                        m = p1.matcher(jFormattedTextFieldFuncionarioDataEmissao.getText());
                        if (m.find()) {

                            p.setRgEmissao(SimpleDateFormat.getDateInstance().parse(jFormattedTextFieldFuncionarioDataEmissao.getText()));
                        }
                        String endereco = (String)jComboBoxFuncionarioLograduro.getSelectedItem();
                        String[] enderecos = endereco.split(" ");
                        
                        List<Endereco> ends = new DaoEndereco().BuscarEnderecoNomeLike(enderecos[1]);
                        if (!ends.isEmpty()) {
                            p.setIdEndereco(ends.get(0));
                        }

                        String status = (String) jComboBoxFuncionarioStatus.getSelectedItem();
                        if (status.equals("Ativo")) {
                            p.setStatus(true);
                        } else {
                            p.setStatus(false);
                        }


                        Funcionario f = new Funcionario();

                        f.setCargo(jTextFieldFuncionarioCargo.getText());
                        f.setSalario(BigDecimal.valueOf(Double.parseDouble(jTextFieldFuncionarioSalario.getText())));
                        f.setObservacao(jTextAreaFuncionarioObservacoes.getText());
                        f.setMatricula(Integer.parseInt(jTextFieldFuncionarioNumeroDaMatricula.getText()));
                        m = p1.matcher(jFormattedTextFieldFuncionarioDataContratacao.getText());
                        if (m.find()) {

                            f.setDataContratacao(SimpleDateFormat.getDateInstance().parse(jFormattedTextFieldFuncionarioDataContratacao.getText()));
                        }


                        f.setIdPessoa(p);

                        p.setFuncionario(f);




                        //new DaoFuncionario().AdicionarFuncionario(f);
                        new DaoPessoa().AdicionarPessoa(p);

                        JOptionPane.showMessageDialog(this, "Dados gravados com Sucesso!", "Salvar", JOptionPane.INFORMATION_MESSAGE);
                        jButtonFuncionarioCancelarActionPerformed(evt);



                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, "Erro para gravar os dados, verifique se todos os campos estão preenchidos corretamente", "ERRO", JOptionPane.ERROR_MESSAGE);
                        e.printStackTrace();
                    }
                }
            } else {

                int op = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja gravar a edição desse registro?", "Salvar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (op == JOptionPane.YES_OPTION) {

                    Pattern p1 = Pattern.compile("\\d{2}\\/\\d{2}\\/\\d{4}");;
                    Matcher m;
                    try {
                        Pessoa p = new DaoPessoa().BuscarPessoaId(Integer.parseInt(jTextFieldFuncionarioID.getText()));


                        p.setNome(jTextFieldFuncionarioNome.getText());
                        p.setSobrenome(jTextFieldFuncionarioSobrenome.getText());
                        p.setApelido(jTextFieldFuncionarioApelido.getText());
                        p.setTelefone(jTextFieldFuncionarioTelefone.getText());
                        p.setEmail(jTextFieldFuncionarioEmail.getText());
                        p.setSexo((String) jComboBoxFuncionarioSexo.getSelectedItem());
                        p.setNomeMae(jTextFieldFuncionarioNomedame.getText());
                        p.setNomePai(jTextFieldFuncionarioNomedopai.getText());
                        if (!p.getCpf().equals(jFormattedTextFieldFuncionarioCpf.getText())) {
                            Pessoa p0 = new DaoPessoa().BuscarPessoaCpf(jFormattedTextFieldFuncionarioCpf.getText());
                            if (p0 != null) {
                                JOptionPane.showMessageDialog(this, "Esse cpf já existe", "Erro", JOptionPane.ERROR_MESSAGE);
                                jFormattedTextFieldFuncionarioCpf.setText("");

                                throw new Exception();

                            }

                        }
                        p.setCpf(jFormattedTextFieldFuncionarioCpf.getText());
                        p.setRgNumero(jTextFieldFuncionarioRgnumero.getText());
                        p.setRgExpedidor(jTextFieldFuncionarioOrgaoExpedidor.getText());
                        p.setNumeroEndereco(jTextFieldFuncionarioNumero.getText());
                        p.setCidade(jTextFieldFuncionarioCidade.getText());
                        p.setBairro(jTextFieldFuncionarioBairro.getText());
                        p.setUf((String) jComboBoxFuncionarioUf.getSelectedItem());
                        p.setCep(jTextFieldFuncionarioCep.getText());

                        m = p1.matcher(jFormattedTextFieldFuncionarioDataNascimento.getText());

                        if (m.find()) {

                            p.setDataNasc(SimpleDateFormat.getDateInstance().parse(jFormattedTextFieldFuncionarioDataNascimento.getText()));
                        }



                        m = p1.matcher(jFormattedTextFieldFuncionarioDataEmissao.getText());
                        if (m.find()) {

                            p.setRgEmissao(SimpleDateFormat.getDateInstance().parse(jFormattedTextFieldFuncionarioDataEmissao.getText()));
                        }

                        String endereco = (String)jComboBoxFuncionarioLograduro.getSelectedItem();
                        String[] enderecos = endereco.split(" ");
                        
                        List<Endereco> ends = new DaoEndereco().BuscarEnderecoNomeLike(enderecos[1]);
                        if (!ends.isEmpty()) {
                            p.setIdEndereco(ends.get(0));
                        }

                        String status = (String) jComboBoxFuncionarioStatus.getSelectedItem();
                        if (status.equals("Ativo")) {
                            p.setStatus(true);
                        } else {
                            p.setStatus(false);
                        }




                        p.getFuncionario().setCargo(jTextFieldFuncionarioCargo.getText());
                        p.getFuncionario().setSalario(BigDecimal.valueOf(Double.parseDouble(jTextFieldFuncionarioSalario.getText().replaceAll("R$", ""))));
                        p.getFuncionario().setObservacao(jTextAreaFuncionarioObservacoes.getText());
                        p.getFuncionario().setMatricula(Integer.parseInt(jTextFieldFuncionarioNumeroDaMatricula.getText()));
                        m = p1.matcher(jFormattedTextFieldFuncionarioDataContratacao.getText());
                        if (m.find()) {

                            p.getFuncionario().setDataContratacao(SimpleDateFormat.getDateInstance().parse(jFormattedTextFieldFuncionarioDataContratacao.getText()));
                        }

                        new DaoPessoa().AlterarPessoa(p);

                        JOptionPane.showMessageDialog(this, "Dados gravados com Sucesso!", "Salvar", JOptionPane.INFORMATION_MESSAGE);
                        jButtonFuncionarioCancelarActionPerformed(evt);

                    } catch (Exception e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(this, "Não foi possivel alterar os dados", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
    }//GEN-LAST:event_jButtonFuncionarioSalvarActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        
        if (evt.getClickCount() > 1) {

            if (pesquisarTable.equals("funcionarios")) {
                limparCampos();
                preencherAbaFuncionarios(new DaoPessoa().BuscarPessoaCpf((String) jTable1.getValueAt(jTable1.getSelectedRow(), 2)));
                jButtonFuncionarioApagar.setEnabled(true);
                jButtonFuncionarioEditar.setEnabled(true);
                jButtonFuncionarioCancelar.setEnabled(true);
            }else if(pesquisarTable.equals("importar funcionário")){

                limparCamposSocio();
                preencherCamposSocioImportados(new DaoPessoa().BuscarPessoaCpf((String) jTable1.getValueAt(jTable1.getSelectedRow(), 2)));

            }
      
            else if (pesquisarTable.equals("logradouros")) {

                limparCamposLogradouro();
                preencherCamposLogradouro(new DaoEndereco().BuscarPorId((Integer) jTable1.getValueAt(jTable1.getSelectedRow(), 0)));

                jButtonLogradouroApagar.setEnabled(true);
                jButtonLogradouroCancelar.setEnabled(true);
                jButtonLogradouroEditar.setEnabled(true);

            } else if (pesquisarTable.equals("taxas")) {


                limparCamposTaxas();
                preencherCamposTaxas(new DaoTaxa().TaxaPorId((Integer) jTable1.getValueAt(jTable1.getSelectedRow(), 0)));

                jButtonTaxaApagar.setEnabled(true);
                jButtonTaxaCancelar.setEnabled(true);
                jButtonTaxaEditar.setEnabled(true);

            } else if (pesquisarTable.equals("socios")) {

                limparCamposSocio();
                preencherCamposSocio(new DaoSocio().BuscarSocioId((Integer) jTable1.getValueAt(jTable1.getSelectedRow(), 0)));
                jButtonSocioApagar.setEnabled(true);
                jButtonSocioCancelar.setEnabled(true);
                jButtonSocioEditar.setEnabled(true);


            } else if (pesquisarTable.equals("categoria socio")) {

                limparCamposCategoriaSocio();


                preencherCamposCategoriaSocio(new DaoCategoriaSocio().BuscarCategoriaSocioPorId((Integer) jTable1.getValueAt(jTable1.getSelectedRow(), 0)));
                jButtonCategoriaSocioApagar.setEnabled(true);
                jButtonCategoriaSocioEditar.setEnabled(true);
                jButtonCategoriaSocioCancelar.setEnabled(true);

            } else if (pesquisarTable.equals("tipo despesa")) {

                limparCamposTipoDespesa();


                preencherCamposTipoDespesa(new DaoMotivoDespesa().BuscarMotivoDespesaId((Integer) jTable1.getValueAt(jTable1.getSelectedRow(), 0)));
                jButtonTipoDespesaApagar.setEnabled(true);
                jButtonTipoDespesaEditar.setEnabled(true);
                jButtonTipoDespesaCancelar.setEnabled(true);

            } else if (pesquisarTable.equals("despesa")) {

                limparCamposDespesa();


                preencherCamposDespesa(new DaoSaidas().BuscarSaidaId((Integer) jTable1.getValueAt(jTable1.getSelectedRow(), 0)));
                jButtonDespesaApagar.setEnabled(true);
                jButtonDespesaEditar.setEnabled(true);
                jButtonDespesaCancelar.setEnabled(true);

            } else if (pesquisarTable.equals("tipo receita")) {

                limparCamposTipoReceita();


                preencherCamposTipoReceita(new DaoMotivoEntrada().BuscarMotivoEntradaId((Integer) jTable1.getValueAt(jTable1.getSelectedRow(), 0)));
                jButtonTipoReceitaApagar.setEnabled(true);
                jButtonTipoReceitaEditar.setEnabled(true);
                jButtonTipoReceitaCancelar.setEnabled(true);

            }else if(pesquisarTable.equals("receita")){
                
                limparCamposReceita();
                
                
                preencherCamposReceita(new DaoEntradas().EntradaPorId((Integer) jTable1.getValueAt(jTable1.getSelectedRow(), 0)));
                jButtonReceitaApagar.setEnabled(true);
                jButtonReceitaEditar.setEnabled(true);
                jButtonReceitaCancelar.setEnabled(true);
                
            }else if(pesquisarTable.equals("cheque")){
                
                limparCamposCheques();
                
                preencherCamposCheque(new DaoCheque().ChequesId((Integer) jTable1.getValueAt(jTable1.getSelectedRow(), 0)));
                
                jButtonChequeApagar.setEnabled(true);
                jButtonChequeEditar.setEnabled(true);
                jButtonChequeCancelar.setEnabled(true);
                
            }


            jPanel1.setVisible(true);
            jDesktopPane1.setVisible(false);
            jInternalFrame1.setVisible(false);


        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTextField2ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed



        if (!jTextField2.getText().isEmpty()) {

            preencherTabelaComLike();


        } else if (jTextField2.getText().equals("")) {

            preencherTabelaComTodos();

        }

    }//GEN-LAST:event_jTextField2ActionPerformed

    private void preencherTabelaComLike() {
        DefaultTableModel model;
       
     try{ 
        if (pesquisarTable.equals("funcionarios") || pesquisarTable.equals("importar funcionário")) {
            ArrayList<Funcionario> f1 = (ArrayList) new DaoFuncionario().BuscarFuncionarioLikeNome(jTextField2.getText());

            model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            if (!f1.isEmpty()) {
                for (Funcionario f : f1) {
                    if (f.getIdPessoa().getDataNasc() != null) {
                    } else {
                    }
                }
            } else {

                JOptionPane.showMessageDialog(this, "Nenhuma pessoa encontrada");
            }
        } else if (pesquisarTable.equals("logradouros")) {

            ArrayList<Endereco> end = (ArrayList) new DaoEndereco().BuscarEnderecoNomeLike(jTextField2.getText());
            model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            if (!end.isEmpty()) {

                for (Endereco e : end) {

                    model.addRow(new Object[]{e.getId(), e.getNome(), e.getTipo(), e.getDescricao()});

                }

            } else {

                JOptionPane.showMessageDialog(this, "Endereço não encontrado", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            }


        } else if (pesquisarTable.equals("taxas")) {

            ArrayList<Taxa> taxas = (ArrayList) new DaoTaxa().BuscarTaxaNomeLike(jTextField2.getText());
            model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            if (!taxas.isEmpty()) {

                for (Taxa t : taxas) {

                    model.addRow(new Object[]{t.getId(), t.getNome(), t.getDescricao(), t.getValor()});

                }

            } else {

                JOptionPane.showMessageDialog(this, "Taxa não encontrada", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            }

        } else if (pesquisarTable.equals("socios")) {

            ArrayList<Socio> socios = (ArrayList) new DaoSocio().SociosPorNomeLike(jTextField2.getText());
            model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            if (!socios.isEmpty()) {
                for (Socio s : socios) {
                    List<Enderecopessoa> ends = s.getIdPessoa().getEnderecopessoaList();
                    for(Enderecopessoa e : ends){
                    model.addRow(
                            new Object[]{
                                s.getId(), 
                                s.getIdPessoa().getNome()+" "+ s.getIdPessoa().getSobrenome(), 
                                s.getIdPessoa().getCpf(), 
                                s.getIdCategoriaSocio().getNome(), 
                                e.getIdEndereco().getTipo()+" "+e.getIdEndereco().getNome(), 
                                e.getNumero()
                            });
            }
                }

            } else {

                JOptionPane.showMessageDialog(this, "Sócio não encontrado", "Atenção", JOptionPane.INFORMATION_MESSAGE);

            }



        } else if (pesquisarTable.equals("categoria socio")) {

            ArrayList<Categoriasocio> categorias = (ArrayList) new DaoCategoriaSocio().BuscarCategoriaPorNomeLike(jTextField2.getText());
            model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            if (!categorias.isEmpty()) {

                for (Categoriasocio c : categorias) {
                    model.addRow(new Object[]{c.getId(), c.getNome(), c.getDescricao(), c.getTaxasId().getNome()});

                }
            } else {
                JOptionPane.showMessageDialog(this, "Categoria Sócio não encontrada", "Atenção", JOptionPane.INFORMATION_MESSAGE);

            }

        } else if (pesquisarTable.equals("tipo despesa")) {

            ArrayList<Motivodespesa> tipos = (ArrayList) new DaoMotivoDespesa().BuscarMotivoDespesaLikeNome(jTextField2.getText());
            model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            if (!tipos.isEmpty()) {

                for (Motivodespesa m : tipos) {
                    model.addRow(new Object[]{m.getId(), m.getNome(), m.getDescricao(), m.getObservacao()});
                }
            } else {

                JOptionPane.showMessageDialog(this, "Tipo Despesa não encontrado", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            }

        } else if (pesquisarTable.equals("despesa")) {

            ArrayList<Saida> despesas = (ArrayList) new DaoSaidas().BuscarSaidaFavorecidoLikeNome(jTextField2.getText());
            model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            if (!despesas.isEmpty()) {

                for (Saida s : despesas) {

                    model.addRow(new Object[]{s.getId(), SimpleDateFormat.getDateInstance().format(s.getData()), s.getValor(), s.getFavorecido(), s.getIdfuncionario().getIdPessoa().getNome() + " " + s.getIdfuncionario().getIdPessoa().getSobrenome(), s.getIdmotivosaida().getNome(), s.getObservacao()});

                }

            } else {

                JOptionPane.showMessageDialog(this, "Despesa não encontrada", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            }

        }else if(pesquisarTable.equals("tipo receita")){

            ArrayList<Motivoentrada> motivoEntrada = (ArrayList) new DaoMotivoEntrada().BuscarMotivoEntradaLikeNome(jTextField2.getText());
            model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            if(!motivoEntrada.isEmpty()){

                for(Motivoentrada m : motivoEntrada){

                    model.addRow(new Object[]{m.getId(), m.getNome(), m.getDescricao(), m.getObservacao()});
                }

            }else{

                JOptionPane.showMessageDialog(this, "Motivo Entrada não encontrado", "Atenção", JOptionPane.INFORMATION_MESSAGE);

            }

        }else if(pesquisarTable.equals("receita")){

            ArrayList<Entrada> entradas = (ArrayList) new DaoEntradas().BuscarEntradaCedenteLikeNome(jTextField2.getText());
            model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            if(!entradas.isEmpty()){

               for(Entrada e : entradas){

                   if(e.getData() != null){

                       model.addRow(new Object[]{e.getId(),SimpleDateFormat.getDateInstance().format(e.getData()), e.getValor(), e.getIdCedente().getIdPessoa().getNome()+" "+e.getIdCedente().getIdPessoa().getSobrenome(),e.getIdFuncionario().getIdPessoa().getNome()+" "+e.getIdFuncionario().getIdPessoa().getSobrenome(),e.getIdMotivoEntrada().getNome(), e.getObservacao()});
                   }else{

                    model.addRow(new Object[]{e.getId(),"nulo", e.getIdCedente().getIdPessoa().getNome()+" "+e.getIdCedente().getIdPessoa().getSobrenome(),e.getIdFuncionario().getIdPessoa().getNome()+" "+e.getIdFuncionario().getIdPessoa().getSobrenome(),e.getIdMotivoEntrada().getNome(), e.getObservacao()});
                   }
                   }

            }else{

                JOptionPane.showMessageDialog(this, " Entrada não encontrada", "Atenção", JOptionPane.INFORMATION_MESSAGE);

            }

        }else if(pesquisarTable.equals("cheque")){

            ArrayList<Cheque> cheques = (ArrayList) new DaoCheque().BuscarChequeFuncionarioLikeNome(jTextField2.getText());
            model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            if(!cheques.isEmpty()){

               for(Cheque c : cheques){
               model.addRow(new Object[]{c.getId(), c.getNumero(), c.getValor(), c.getIdFuncionario().getIdPessoa().getNome()+" "+c.getIdFuncionario().getIdPessoa().getSobrenome(), c.getIdMotivoDespesa().getNome(), SimpleDateFormat.getDateInstance().format(c.getDataPagamento()), SimpleDateFormat.getDateInstance().format(c.getDataVencimento())});
               }
            }else{

               JOptionPane.showMessageDialog(this, " Cheque não encontrado", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            }

        }
    }catch(Exception e){
        
        JOptionPane.showMessageDialog(this,"Erro: "+e.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE);
    }
     
    
    }

    private void preencherTabelaComTodos() {
    
        DefaultTableModel model;
    
        try{

        if (pesquisarTable.equals("funcionarios") || pesquisarTable.equals("importar funcionário")) {
            ArrayList<Funcionario> funcionarios = (ArrayList) new DaoFuncionario().BuscarFuncionarios();
            model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
        } else if (pesquisarTable.equals("logradouros")) {

            ArrayList<Endereco> enderecos = (ArrayList) new DaoEndereco().BuscarTodosEnderecos();
            model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            if (!enderecos.isEmpty()) {
                for (Endereco end : enderecos) {

                    model.addRow(new Object[]{end.getId(), end.getNome(), end.getTipo(), end.getDescricao()});
                }
            } else {

                JOptionPane.showMessageDialog(this, "A tabela de Endereços está vazia", "Erro", JOptionPane.ERROR_MESSAGE);
            }



        } else if (pesquisarTable.equals("taxas")) {

            ArrayList<Taxa> taxas = (ArrayList) new DaoTaxa().TaxasTodas();
            model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            if (!taxas.isEmpty()) {

                for (Taxa t : taxas) {
                    model.addRow(new Object[]{t.getId(), t.getNome(), t.getDescricao(), t.getValor()});
                }
            } else {
                JOptionPane.showMessageDialog(this, "A tabela de Taxas está vazia", "Erro", JOptionPane.ERROR_MESSAGE);

            }

        } else if (pesquisarTable.equals("socios")) {


            List<Sociotabela> socios = new DaoSocio().findAllCustomers();
            model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            if (!socios.isEmpty()) {
                for (Sociotabela s : socios) {
                    model.addRow(new Object[]{s.getIdSocio(), s.getNomeCompleto(), s.getCpf(), s.getNome(), s.getEndereco(),s.getNumero()});
                }
            } else {

                JOptionPane.showMessageDialog(this, "A tabela de Sócios está vazia", "Erro", JOptionPane.ERROR_MESSAGE);

            }

        } else if (pesquisarTable.equals("categoria socio")) {

            List<Categoriasocio> categorias = new DaoCategoriaSocio().BuscarTodasCategorias();
            model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            if (!categorias.isEmpty()) {

                for (Categoriasocio c : categorias) {

                    model.addRow(new Object[]{c.getId(), c.getNome(), c.getDescricao(), c.getTaxasId().getNome()});
                }

            } else {

                JOptionPane.showMessageDialog(this, "A tabela de Categoria Sócio está vazia", "Erro", JOptionPane.ERROR_MESSAGE);

            }

        } else if (pesquisarTable.equals("tipo despesa")) {

            List<Motivodespesa> tipos = new DaoMotivoDespesa().BuscarTodosMotivos();
            model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            if (!tipos.isEmpty()) {

                for (Motivodespesa m : tipos) {

                    model.addRow(new Object[]{m.getId(), m.getNome(), m.getDescricao(), m.getObservacao()});
                }

            } else {

                JOptionPane.showMessageDialog(this, "A tabela de Motivo Despesa está vazia", "Erro", JOptionPane.ERROR_MESSAGE);

            }

        } else if (pesquisarTable.equals("despesa")) {

            List<Saida> saidas = new DaoSaidas().BuscarTodasSaidas();
            model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            if (!saidas.isEmpty()) {

                for (Saida s : saidas) {

                    model.addRow(new Object[]{s.getId(), SimpleDateFormat.getDateInstance().format(s.getData()), s.getValor(), s.getFavorecido(), s.getIdfuncionario().getIdPessoa().getNome() + " " + s.getIdfuncionario().getIdPessoa().getSobrenome(), s.getIdmotivosaida().getNome(), s.getObservacao()});
                }

            } else {

                JOptionPane.showMessageDialog(this, "A tabela de Despesa está vazia", "Erro", JOptionPane.ERROR_MESSAGE);

            }


        }else if(pesquisarTable.equals("tipo receita")){
            
            List<Motivoentrada> motivoEntrada = new DaoMotivoEntrada().BuscarTodosMotivos();
            model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            
            if(!motivoEntrada.isEmpty()){
                
                for(Motivoentrada m : motivoEntrada){
                    
                    model.addRow(new Object[]{m.getId(), m.getNome(), m.getDescricao(), m.getObservacao()});
                }
                
            }else{
                
                JOptionPane.showMessageDialog(this, "A tabela de Motivo Entrada está vazia", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                
            }
            
        }else if(pesquisarTable.equals("receita")){
            
            List<Entrada> entradas =  new DaoEntradas().BuscarTodasEntradas();
            model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            
            if(!entradas.isEmpty()){
                
               for(Entrada e : entradas){
                   
                   if(e.getData() != null){
                       
                       model.addRow(new Object[]{e.getId(),SimpleDateFormat.getDateInstance().format(e.getData()), e.getValor(), e.getIdCedente().getIdPessoa().getNome()+" "+e.getIdCedente().getIdPessoa().getSobrenome(),e.getIdFuncionario().getIdPessoa().getNome()+" "+e.getIdFuncionario().getIdPessoa().getSobrenome(),e.getIdMotivoEntrada().getNome(), e.getObservacao()});
                   }else{
                   
                    model.addRow(new Object[]{e.getId(),"nulo", e.getIdCedente().getIdPessoa().getNome()+" "+e.getIdCedente().getIdPessoa().getSobrenome(),e.getIdFuncionario().getIdPessoa().getNome()+" "+e.getIdFuncionario().getIdPessoa().getSobrenome(),e.getIdMotivoEntrada().getNome(), e.getObservacao()});
                   }
                   }
                
            }else{
                
                JOptionPane.showMessageDialog(this, "A tabela de entradas está vazia", "Atenção", JOptionPane.INFORMATION_MESSAGE); 
  
        }

      }else if(pesquisarTable.equals("cheque")){
            
            List<Cheque> cheques = new DaoCheque().ChequesTotalAbertos();
            model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            
            if(!cheques.isEmpty()){
                
               for(Cheque c : cheques){ 
               model.addRow(new Object[]{c.getId(), c.getNumero(), c.getValor(), c.getIdFuncionario().getIdPessoa().getNome()+" "+c.getIdFuncionario().getIdPessoa().getSobrenome(), c.getIdMotivoDespesa().getNome(), SimpleDateFormat.getDateInstance().format(c.getDataPagamento()), SimpleDateFormat.getDateInstance().format(c.getDataVencimento())});
               }
            }else{
                
               JOptionPane.showMessageDialog(this, "A tabela de Cheque está vazia", "Atenção", JOptionPane.INFORMATION_MESSAGE);   
            }
            
        }
    } catch(Exception e){
        e.printStackTrace();
        JOptionPane.showMessageDialog(this,"Erro: "+e.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE);
        }
    }

    private void jButtonPesquisaActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisaActionPerformed

        if (!jTextField2.getText().isEmpty()) {
            preencherTabelaComLike();
        } else if (jTextField2.getText().equals("")) {
            preencherTabelaComTodos();
        }
    }//GEN-LAST:event_jButtonPesquisaActionPerformed

    private void jButtonInternalFrameVoltarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonInternalFrameVoltarActionPerformed

        switch (pesquisarTable) {

            case "funcionarios":
                jButtonFuncionarioCancelarActionPerformed(evt);
                break;
            case "logradouros":
                jButtonLogradouroCancelarActionPerformed(evt);
                break;
            case "taxas":
                jButtonTaxaCancelarActionPerformed(evt);
                break;
            case "socios":
                jButtonSocioCancelarActionPerformed(evt);
                break;
            case "categoria socio":
                jButtonCategoriaSocioCancelarActionPerformed(evt);
                break;
            case "tipo despesa":
                jButtonTipoDespesaCancelarActionPerformed(evt);
                break;
            case "despesa":
                jButtonDespesaCancelarActionPerformed(evt);
                break;
            case "tipo receita":
                jButtonTipoReceitaCancelarActionPerformed(evt);
                break;
            case "receita":
                jButtonReceitaCancelarActionPerformed(evt);
                break;
            case "cheque":
                jButtonChequeCancelarActionPerformed(evt);
            case "importar funcionário":
                jButtonSocioCancelarActionPerformed(evt);
                break;
        }
        jTextField2.setText("");
        jDesktopPane1.setVisible(false);
        jInternalFrame1.setVisible(false);
        jPanel1.setVisible(true);
    }//GEN-LAST:event_jButtonInternalFrameVoltarActionPerformed

    private void jButtonLogradouroNovoActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonLogradouroNovoActionPerformed

        
        limparCamposLogradouro();
        setEditableComponentesLogradouros(true);
        jButtonLogradouroEditar.setEnabled(false);
        jButtonLogradouroApagar.setEnabled(false);
        jButtonLogradouroNovo.setEnabled(false);
       

    }//GEN-LAST:event_jButtonLogradouroNovoActionPerformed

    private void jButtonLogradouroCancelarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonLogradouroCancelarActionPerformed

        limparCamposLogradouro();
        setEditableComponentesLogradouros(false);
        jButtonLogradouroNovo.setEnabled(true);
        if(this.cadastrar){
            
            this.cadastrar = false;
            jTabbedPane1.setSelectedComponent(jPanelFunc);
            
        }
    }//GEN-LAST:event_jButtonLogradouroCancelarActionPerformed

    private void jButtonLogradouroEditarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonLogradouroEditarActionPerformed

        setEditableComponentesLogradouros(true);
        jButtonLogradouroNovo.setEnabled(false);
        jButtonLogradouroApagar.setEnabled(false);
        jButtonLogradouroEditar.setEnabled(false);
    }//GEN-LAST:event_jButtonLogradouroEditarActionPerformed

    private void jButtonLogradouroSalvarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonLogradouroSalvarActionPerformed

        if (!jTextFieldLogradouroNome.getText().equals("") && !jComboBoxLogradouroTipo.getSelectedItem().equals("")) {

            if (jTextFieldLogradouroID.getText().equals("")) {
                int op = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja gravar os dados?", "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
                if (op == JOptionPane.YES_OPTION) {
                    try {
                        Endereco end = new Endereco();
                        end.setNome(jTextFieldLogradouroNome.getText());
                        end.setTipo((String) jComboBoxLogradouroTipo.getSelectedItem());
                        end.setDescricao(jTextAreaLogradouroDescricao.getText());

                        new DaoEndereco().AdicionarEndereco(end);

                        JOptionPane.showMessageDialog(this, "Dados gravados com sucesso!", "", JOptionPane.INFORMATION_MESSAGE);
                        jButtonLogradouroCancelarActionPerformed(evt);
                    } catch (Exception e) {

                        JOptionPane.showMessageDialog(this, "Erro na gravação dos dados", "Erro", JOptionPane.ERROR_MESSAGE);

                    }
                }
            } else {

                int op = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja gravar a edição do registro?", "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
                if (op == JOptionPane.YES_OPTION) {


                    Endereco end = new DaoEndereco().BuscarPorId(Integer.parseInt(jTextFieldLogradouroID.getText()));
                    end.setNome(jTextFieldLogradouroNome.getText());
                    end.setTipo((String) jComboBoxLogradouroTipo.getSelectedItem());
                    end.setDescricao(jTextAreaLogradouroDescricao.getText());

                    new DaoEndereco().AlterarEndereco(end);

                    JOptionPane.showMessageDialog(this, "Dados gravados com sucesso!", "", JOptionPane.INFORMATION_MESSAGE);
                    jButtonLogradouroCancelarActionPerformed(evt);
                   
                }

            }
            
            jTabbedPane1.setSelectedComponent(jPanelFunc);
            jButtonFuncionarioNovoActionPerformed(evt);
        } else {

            JOptionPane.showMessageDialog(this, "Os campos em negrito são obrigatórios", "Atenção", JOptionPane.INFORMATION_MESSAGE);

        }

    }//GEN-LAST:event_jButtonLogradouroSalvarActionPerformed

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged

        
        
        if ((!jButtonFuncionarioNovo.isEnabled() || !jTextFieldFuncionarioID.getText().equals("")) && this.cadastrar == false) {
            if (jTabbedPane1.getSelectedComponent() != jPanelFunc) {
                JOptionPane.showMessageDialog(this, "Cancele a operação ", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            }
            jTabbedPane1.setSelectedComponent(jPanelFunc);

        } else if ((!jButtonLogradouroNovo.isEnabled() || !jTextFieldLogradouroID.getText().equals(""))|| this.cadastrar) {

            if (jTabbedPane1.getSelectedComponent() != jPanelLog) {

                JOptionPane.showMessageDialog(this, "Cancele a operação ", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            }
            jTabbedPane1.setSelectedComponent(jPanelLog);

        } else if (!jButtonTaxaNovo.isEnabled() || !jTextFieldTaxasID.getText().equals("")) {

            if (jTabbedPane1.getSelectedComponent() != jPanelTaxas) {

                JOptionPane.showMessageDialog(this, "Cancele a operação ", "Atenção", JOptionPane.INFORMATION_MESSAGE);

            }
            jTabbedPane1.setSelectedComponent(jPanelTaxas);

        } else if (!jButtonSocioNovo.isEnabled() || !jTextFieldSocioID.getText().equals("")  || (!jFormattedTextFieldSocioCPF.getText().equals("") &&  !jFormattedTextFieldSocioCPF.getText().equals("   .   .   -  "))) {

            if (jTabbedPane1.getSelectedComponent() != jPanelSocio) {

                JOptionPane.showMessageDialog(this, "Cancele a operação ", "Atenção", JOptionPane.INFORMATION_MESSAGE);

            }
            jTabbedPane1.setSelectedComponent(jPanelSocio);

        } else if (!jButtonCategoriaSocioNovo.isEnabled() || !jTextFieldCategoriaSocioID.getText().equals("")) {

            if (jTabbedPane1.getSelectedComponent() != jPanelCategoriaSocio) {

                JOptionPane.showMessageDialog(this, "Cancele a operação ", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            }
            jTabbedPane1.setSelectedComponent(jPanelCategoriaSocio);

        } else if (!jButtonTipoDespesaNovo.isEnabled() || !jTextFieldTIpoDespesaID.getText().equals("")) {


            if (jTabbedPane1.getSelectedComponent() != jPanelTipoDespesa) {

                JOptionPane.showMessageDialog(this, "Cancele a operação ", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            }
            jTabbedPane1.setSelectedComponent(jPanelTipoDespesa);

        } else if (!jButtonDespesaNovo.isEnabled() || !jTextFieldDespesaID.getText().equals("")) {


            if (jTabbedPane1.getSelectedComponent() != jPanelDespesa) {

                JOptionPane.showMessageDialog(this, "Cancele a operação ", "Atenção", JOptionPane.INFORMATION_MESSAGE);

            }
            jTabbedPane1.setSelectedComponent(jPanelDespesa);
       
        }else if(!jButtonTipoReceitaNovo.isEnabled() || !jTextFieldTIpoReceitaID.getText().equals("")){
            
             if (jTabbedPane1.getSelectedComponent() != jPanelTipoReceita) {

                JOptionPane.showMessageDialog(this, "Cancele a operação ", "Atenção", JOptionPane.INFORMATION_MESSAGE);

            }
            jTabbedPane1.setSelectedComponent(jPanelTipoReceita);
            
        }else if(!jButtonReceitaNovo.isEnabled() || !jTextFieldReceitaID.getText().equals("")){
            
             if (jTabbedPane1.getSelectedComponent() != jPanelReceitas) {

                JOptionPane.showMessageDialog(this, "Cancele a operação ", "Atenção", JOptionPane.INFORMATION_MESSAGE);

            }
            jTabbedPane1.setSelectedComponent(jPanelReceitas);
            
        }else if(!jButtonChequeNovo.isEnabled() || !jTextFieldChequeID.getText().equals("")){
             if (jTabbedPane1.getSelectedComponent() != jPanelCheques) {

                JOptionPane.showMessageDialog(this, "Cancele a operação ", "Atenção", JOptionPane.INFORMATION_MESSAGE);

            }
            jTabbedPane1.setSelectedComponent(jPanelCheques);
            
        }
        
        else{
             
            zerarComboBox();
        }


    }//GEN-LAST:event_jTabbedPane1StateChanged

    private void jButtonLogradouroPesquisarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonLogradouroPesquisarActionPerformed

        if (jButtonLogradouroNovo.isEnabled()) {

            pesquisarTable = "logradouros";
            mostrarJtable();

        } else {

            JOptionPane.showMessageDialog(this, "Cancele a operação para fazer uma pesquisa", "Atenção", JOptionPane.INFORMATION_MESSAGE);
        }


    }//GEN-LAST:event_jButtonLogradouroPesquisarActionPerformed

    private void jButtonLogradouroApagarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonLogradouroApagarActionPerformed

        int op = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja excluir o registro?", "Apagar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (op == JOptionPane.YES_OPTION) {
            try {
                Endereco end = new DaoEndereco().BuscarPorId(Integer.parseInt(jTextFieldLogradouroID.getText()));
                new DaoEndereco().ApagarEndereco(end);
                JOptionPane.showMessageDialog(this, "Registro excluido com sucesso!", "", JOptionPane.INFORMATION_MESSAGE);
                limparCamposLogradouro();
                jButtonLogradouroCancelarActionPerformed(evt);


            } catch (Exception e) {

                JOptionPane.showMessageDialog(this, "Não foi possível excluir o registro", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButtonLogradouroApagarActionPerformed

    private void jButtonTaxaNovoActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonTaxaNovoActionPerformed

        limparCamposTaxas();
        setEditableComponentesTaxas(true);
        jButtonTaxaNovo.setEnabled(false);
        jButtonTaxaEditar.setEnabled(false);
        jButtonTaxaApagar.setEnabled(false);



    }//GEN-LAST:event_jButtonTaxaNovoActionPerformed

    private void jButtonTaxaCancelarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonTaxaCancelarActionPerformed

        setEditableComponentesTaxas(false);
        jButtonTaxaNovo.setEnabled(true);
        jButtonTaxaCancelar.setEnabled(false);
        limparCamposTaxas();

    }//GEN-LAST:event_jButtonTaxaCancelarActionPerformed

    private void jButtonTaxaEditarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonTaxaEditarActionPerformed

        setEditableComponentesTaxas(true);
        jButtonTaxaNovo.setEnabled(false);
        jButtonTaxaApagar.setEnabled(false);
        jButtonTaxaEditar.setEnabled(false);

    }//GEN-LAST:event_jButtonTaxaEditarActionPerformed

    private void jButtonTaxaSalvarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonTaxaSalvarActionPerformed

        try {
            if (!jTextFieldTaxasNome.getText().equals("") && !jTextFieldTaxasValor.getText().equals("")) {

                Pattern p = Pattern.compile("\\d+\\.\\d+");
                Matcher m = p.matcher(jTextFieldTaxasValor.getText());
                if (jTextFieldTaxasID.getText().equals("")) {

                    int op = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja gravar o registro?", "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (op == JOptionPane.YES_OPTION) {
                        if (m.find()) {

                            Taxa taxa = new Taxa();
                            taxa.setNome(jTextFieldTaxasNome.getText());
                            taxa.setValor(BigDecimal.valueOf(Double.parseDouble(jTextFieldTaxasValor.getText())));
                            taxa.setDescricao(jTextAreaTaxasDescricao.getText());

                            new DaoTaxa().AdicionarTaxa(taxa);
                            JOptionPane.showMessageDialog(this, "Dados gravados com sucesso", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                            jButtonTaxaCancelarActionPerformed(evt);
                        } else {

                            JOptionPane.showMessageDialog(this, "Números monetários devem ser separados por ponto", "Erro", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } else {

                    int op = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja gravar a edição do registro?", "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (op == JOptionPane.YES_OPTION) {

                        if (m.find()) {

                            Taxa taxa = new DaoTaxa().TaxaPorId(Integer.parseInt(jTextFieldTaxasID.getText()));
                            taxa.setNome(jTextFieldTaxasNome.getText());
                            taxa.setValor(BigDecimal.valueOf(Double.parseDouble(jTextFieldTaxasValor.getText())));
                            taxa.setDescricao(jTextAreaTaxasDescricao.getText());

                            new DaoTaxa().AlterarTaxa(taxa);
                            JOptionPane.showMessageDialog(this, "Dados gravados com sucesso", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                            jButtonTaxaCancelarActionPerformed(evt);
                        } else {

                            JOptionPane.showMessageDialog(this, "Números monetários devem ser separados por ponto", "Erro", JOptionPane.ERROR_MESSAGE);
                        }

                    }
                }

            } else {

                JOptionPane.showMessageDialog(this, "Os campos em negrito são obrigatórios", "Atenção", JOptionPane.INFORMATION_MESSAGE);

            }
        } catch (HeadlessException | NumberFormatException e) {

            JOptionPane.showMessageDialog(this, "Erro ao gravar os dados", "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

    }//GEN-LAST:event_jButtonTaxaSalvarActionPerformed

    private void jButtonTaxasPesquisarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonTaxasPesquisarActionPerformed

        if (jButtonLogradouroNovo.isEnabled()) {

            pesquisarTable = "taxas";
            mostrarJtable();

        } else {

            JOptionPane.showMessageDialog(this, "Cancele a operação para fazer uma pesquisa", "Atenção", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_jButtonTaxasPesquisarActionPerformed

    private void jButtonTaxaApagarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonTaxaApagarActionPerformed

        try {
            int op = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja apagar o registro?", "Atençao", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (op == JOptionPane.YES_OPTION) {

                Taxa taxa = new DaoTaxa().TaxaPorId(Integer.parseInt(jTextFieldTaxasID.getText()));
                new DaoTaxa().ApagarTaxa(taxa);

                JOptionPane.showMessageDialog(this, "Taxa excluida com sucesso!", "Atenção", JOptionPane.INFORMATION_MESSAGE);

                jButtonTaxaCancelarActionPerformed(evt);

            }
        } catch (Exception e) {

            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro para excluir o registro", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonTaxaApagarActionPerformed

    private void jButtonSocioNovoActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonSocioNovoActionPerformed

        limparCamposSocio();
        setEditableComponentesSocio(true);
        jButtonSocioApagar.setEnabled(false);
        jButtonSocioEditar.setEnabled(false);
        jButtonSocioNovo.setEnabled(false);

        jRadioCPFCNPJ.setEnabled(true);
        jButtonSocioAdicionarLogradouro.setEnabled(false);
        if (jComboBoxSocioLogradouro.getItemCount() == 0) {

            jComboBoxSocioLogradouro.addItem("");
            List<Endereco> end = new DaoEndereco().BuscarTodosEnderecos();
            for (Endereco e : end) {
                jComboBoxSocioLogradouro.addItem(e.getTipo()+" "+e.getNome());
            }
        }
        if (jComboBoxSocioCategoriaSocio.getItemCount() == 0) {

            jComboBoxSocioCategoriaSocio.addItem("");
            List<Categoriasocio> cs = new DaoCategoriaSocio().BuscarTodasCategorias();
            for (Categoriasocio c : cs) {

                jComboBoxSocioCategoriaSocio.addItem(c.getNome());

            }

        }
        jComboBoxSocioLogradouro.setSelectedItem("");
        jComboBoxSocioCategoriaSocio.setSelectedItem("");

    }//GEN-LAST:event_jButtonSocioNovoActionPerformed

    private void jButtonSocioCancelarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonSocioCancelarActionPerformed

        limparCamposSocio();
        setEditableComponentesSocio(false);
        jButtonSocioNovo.setEnabled(true);


    }//GEN-LAST:event_jButtonSocioCancelarActionPerformed

    private void jButtonSocioEditarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonSocioEditarActionPerformed

        flagEditar = true;
        socioNumero = (String)jTextFieldSocioNumero.getText();
        jRadioCPFCNPJ.setEnabled(true);
        setEditableComponentesSocio(true);
        jButtonSocioEditar.setEnabled(false);
        jButtonSocioApagar.setEnabled(false);
        jButtonSocioNovo.setEnabled(false);

    }//GEN-LAST:event_jButtonSocioEditarActionPerformed

    private void jButtonSocioPesquisarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonSocioPesquisarActionPerformed

        if (jButtonSocioNovo.isEnabled()) {
            pesquisarTable = "socios";
            mostrarJtable();

        } else {

            JOptionPane.showMessageDialog(this, "Cancele a operação para fazer uma pesquisa", "Atenção", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_jButtonSocioPesquisarActionPerformed

    private void jButtonSocioSalvarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonSocioSalvarActionPerformed

        if (isCamposSocioPreenchidos()) {
            
            Pattern p1 = Pattern.compile("\\d{2}\\/\\d{2}\\/\\d{4}");;
            Matcher m;
            if (jTextFieldSocioID.getText().equals("")) {           
                if(pesquisarTable.equals("importar funcionário")){
                    
                int op = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja gravar esse funcionario como sócio?", "Salvar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (op == JOptionPane.YES_OPTION) {
                    
                     try {
                        Pessoa p = new  DaoPessoa().BuscarPessoaCpf(jFormattedTextFieldSocioCPF.getText());

                        p.setNome(jTextFieldSocioNome.getText());
                        p.setSobrenome(jTextFieldSocioSobrenome.getText());
                        p.setApelido(jTextFieldSocioApelido.getText());
                        p.setTelefone(jTextFieldSocioTelefone.getText());
                        p.setEmail(jTextFieldSocioEmail.getText());
                        p.setNomeMae(jTextFieldSocioNomeMae.getText());
                        p.setNomePai(jTextFieldSocioNomePai.getText());
                        p.setRgNumero(jTextFieldSocioRgNumero.getText());
                        p.setRgExpedidor(jTextFieldSocioOrgaoExpedidor.getText());
                        
                        if(jFormattedCNPJ.isEditable()){}
                        else{}
                        if(flagEditar==false){
                            if(new DaoEnderecoPessoa().EnderecopessoaporNumero(jTextFieldSocioNumero.getText()) != null){
                            throw new Exception("Número de Endereço já cadastrado -1");
                            }
                        }
                        else {
                            if(!new DaoEnderecoPessoa().EnderecopessoaporNumero(jTextFieldSocioNumero.getText()).equals(socioNumero)){
                            if(new DaoEnderecoPessoa().EnderecopessoaporNumero(jTextFieldSocioNumero.getText()) != null){
                            throw new Exception("Número de Endereço já cadastrado -2"); }
                            }
                           
                        }
                        
                        p.setNumeroEndereco(jTextFieldSocioNumero.getText());
                        p.setCidade(jTextFieldSocioCep2.getText());
                        p.setBairro(jTextFieldSocioBairro.getText());
                        p.setCep(jTextFieldSocioCEP.getText());

                        if (p1.matcher(jFormattedTextFieldSocioDataNascimento.getText()).find()) {


                            p.setDataNasc(SimpleDateFormat.getDateInstance().parse(jFormattedTextFieldSocioDataNascimento.getText()));
                        }

                       
                        p.setCpf(jFormattedTextFieldSocioCPF.getText());
                        if (p1.matcher(jFormattedTextFieldSocioDataEmissao.getText()).find()) {


                            p.setRgEmissao(SimpleDateFormat.getDateInstance().parse(jFormattedTextFieldSocioDataEmissao.getText()));
                        }
                        p.setSexo((String) jComboBoxSocioSexo.getSelectedItem());
                        p.setUf((String) jComboBoxSocioUF.getSelectedItem());

                        
                        Enderecopessoa ep = new Enderecopessoa();
                        Endereco e = new DaoEndereco().BuscarEnderecoCompleto((String)jComboBoxSocioLogradouro.getSelectedItem());
                        List<Categoriasocio> cs = new DaoCategoriaSocio().BuscarCategoriaPorNomeLike((String) jComboBoxSocioCategoriaSocio.getSelectedItem());
                        if (!cs.isEmpty()) {
                       
                            ep.setIdCategoriaSocio(cs.get(0));
                        }
                        if (e != null) {
                            p.setIdEndereco(e);
                             
                              ep.setIdEndereco(e);
                              ep.setIdPessoa(p);
                              ep.setNumero(jTextFieldSocioNumero.getText());
                              List<Enderecopessoa> enderecos1 = new ArrayList<>();
                              enderecos1.add(ep);
                              p.setEnderecopessoaList(enderecos1);

                        }
                        Socio s = new Socio();
                        if (jRadioButtonSocioAtivo.isSelected()) {
                            p.setStatus(true);
                            s.setDataAprovacao(new Date());
                        } else {
                            p.setStatus(false);
                        }
                        s.setIdCategoriaSocio(cs.get(0));
                        s.setDataVence(SimpleDateFormat.getDateInstance().parse(jFormattedTextFieldSocioDiaVencimento.getText()));
                        s.setDataMatricula(SimpleDateFormat.getDateInstance().parse(jFormattedTextFieldSocioDataMatricula.getText()));
                        s.setNumeroSocio((Integer.parseInt(jTextFieldSocioNumeroSocio.getText())));
                       
                        //O socio usa um Carne de Agua ou de Socio??
                        if(jCheckBoxExclusivamenteSocio.isSelected()){
                        s.setSocioExclusivo(true);//carne de Socio
                        }
                        else{
                        s.setSocioExclusivo(false);//Carne de Agua
                        }
                        
                        s.setIdPessoa(p);
                        p.setSocio(s);
                        
                        new DaoPessoa().AlterarPessoa(p);

                        jButtonSocioCancelarActionPerformed(evt);
                        JOptionPane.showMessageDialog(this, "Dados gravados com Sucesso!", "Salvar", JOptionPane.INFORMATION_MESSAGE);


                    } catch (Exception e) {

                        JOptionPane.showMessageDialog(this, "Erro:"+e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
                        e.printStackTrace();

                    }
                    
                } 
                    
                    
                }
                else{
                int op = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja gravar os dados?", "Salvar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (op == JOptionPane.YES_OPTION) {

                    try {
                        Pessoa p = new Pessoa();

                        p.setNome(jTextFieldSocioNome.getText());
                        p.setSobrenome(jTextFieldSocioSobrenome.getText());
                        p.setApelido(jTextFieldSocioApelido.getText());
                        p.setTelefone(jTextFieldSocioTelefone.getText());
                        p.setEmail(jTextFieldSocioEmail.getText());
                        p.setNomeMae(jTextFieldSocioNomeMae.getText());
                        p.setNomePai(jTextFieldSocioNomePai.getText());
                        p.setRgNumero(jTextFieldSocioRgNumero.getText());
                        p.setRgExpedidor(jTextFieldSocioOrgaoExpedidor.getText());
                       
                        if(jFormattedCNPJ.isEditable()){
                            //aqui estamos editando
                            if(flagEditar==false){
                                if(new DaoEnderecoPessoa().BuscaCnpj(jFormattedCNPJ.getText())){
                                throw new Exception("Número de Endereço já cadastrado: erro 1");
                                }
                            }
                            //aqui estamos salvando
                            else {                  
                                if(!new DaoEnderecoPessoa().EnderecopessoaporNumero(jTextFieldSocioNumero.getText()).equals(socioNumero)){
                                if(new DaoEnderecoPessoa().EnderecopessoaporNumero(jTextFieldSocioNumero.getText()) != null){
                                throw new Exception("Número de Endereço já cadastrado: erro 2"); }
                                }
                            }
                        }
                        else{
                            if(flagEditar==false){
                                if(new DaoEnderecoPessoa().EnderecopessoaporNumero(jTextFieldSocioNumero.getText()) != null){
                                throw new Exception("Número de Endereço já cadastrado: ERRO 3");
                                }
                            }
                            else {
                                if(!new DaoEnderecoPessoa().EnderecopessoaporNumero(jTextFieldSocioNumero.getText()).equals(socioNumero)){
                                if(new DaoEnderecoPessoa().EnderecopessoaporNumero(jTextFieldSocioNumero.getText()) != null){
                                throw new Exception("Número de Endereço já cadastrado 2"); }
                                }
                            }
                        }
                        
                        p.setNumeroEndereco(jTextFieldSocioNumero.getText());
                        p.setCidade(jTextFieldSocioCep2.getText());
                        p.setBairro(jTextFieldSocioBairro.getText());
                        p.setCep(jTextFieldSocioCEP.getText());

                        if (p1.matcher(jFormattedTextFieldSocioDataNascimento.getText()).find()) {


                            p.setDataNasc(SimpleDateFormat.getDateInstance().parse(jFormattedTextFieldSocioDataNascimento.getText()));
                        }

                        Pessoa p0 = new DaoPessoa().BuscarPessoaCpf(jFormattedTextFieldSocioCPF.getText());
                        if (p0 != null) {
                            JOptionPane.showMessageDialog(this, "O cpf informado já existe", "Erro", JOptionPane.ERROR_MESSAGE);
                            jFormattedTextFieldSocioCPF.setText("");
                            throw new Exception();
                        }
                        p.setCpf(jFormattedTextFieldSocioCPF.getText());
                        if (p1.matcher(jFormattedTextFieldSocioDataEmissao.getText()).find()) {


                            p.setRgEmissao(SimpleDateFormat.getDateInstance().parse(jFormattedTextFieldSocioDataEmissao.getText()));
                        }
                        p.setSexo((String) jComboBoxSocioSexo.getSelectedItem());
                        p.setUf((String) jComboBoxSocioUF.getSelectedItem());

                        
                        Enderecopessoa ep = new Enderecopessoa();
                        Endereco e = new DaoEndereco().BuscarEnderecoCompleto((String)jComboBoxSocioLogradouro.getSelectedItem());
                        List<Categoriasocio> cs = new DaoCategoriaSocio().BuscarCategoriaPorNomeLike((String) jComboBoxSocioCategoriaSocio.getSelectedItem());
                        if (!cs.isEmpty()) {
                       
                            ep.setIdCategoriaSocio(cs.get(0));
                        }
                        if (e != null) {
                            p.setIdEndereco(e);
                             
                              ep.setIdEndereco(e);
                              ep.setIdPessoa(p);
                              ep.setNumero(jTextFieldSocioNumero.getText());
                              List<Enderecopessoa> enderecos1 = new ArrayList<>();
                              enderecos1.add(ep);
                              p.setEnderecopessoaList(enderecos1);

                        }
                        Socio s = new Socio();
                        if (jRadioButtonSocioAtivo.isSelected()) {

                            p.setStatus(true);
                            s.setDataAprovacao(new Date());
                        } else {

                            p.setStatus(false);
                        }

                        s.setDataVence(SimpleDateFormat.getDateInstance().parse(jFormattedTextFieldSocioDiaVencimento.getText()));
                        s.setDataMatricula(SimpleDateFormat.getDateInstance().parse(jFormattedTextFieldSocioDataMatricula.getText()));
                        s.setNumeroSocio(Integer.parseInt(jTextFieldSocioNumeroSocio.getText()));                                               
                        s.setIdCategoriaSocio(cs.get(0));
                        s.setIdPessoa(p);
                        //O socio usa um Carne de Agua ou de Socio??
                        if(jCheckBoxExclusivamenteSocio.isSelected()){
                        s.setSocioExclusivo(true);//carne de Socio
                        }
                        else{
                        s.setSocioExclusivo(false);//Carne de Agua
                        }
                        
                        p.setSocio(s);

                        new DaoPessoa().AdicionarPessoa(p);

                        jButtonSocioCancelarActionPerformed(evt);
                        JOptionPane.showMessageDialog(this, "Dados gravados com Sucesso!", "Salvar", JOptionPane.INFORMATION_MESSAGE);


                    } catch (Exception e) {

                        JOptionPane.showMessageDialog(this, "Erro:"+e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
                        e.printStackTrace();

                    }
                }
            }
            } else {
                int op = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja gravar a edição desse registro?", "Salvar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (op == JOptionPane.YES_OPTION) {

                    try {

                        Socio s = new DaoSocio().BuscarSocioId(Integer.parseInt(jTextFieldSocioID.getText()));
                        Pessoa p = s.getIdPessoa();

                        p.setNome(jTextFieldSocioNome.getText());
                        p.setSobrenome(jTextFieldSocioSobrenome.getText());
                        p.setApelido(jTextFieldSocioApelido.getText());
                        p.setTelefone(jTextFieldSocioTelefone.getText());
                        p.setEmail(jTextFieldSocioEmail.getText());
                        p.setNomeMae(jTextFieldSocioNomeMae.getText());
                        p.setNomePai(jTextFieldSocioNomePai.getText());
                        p.setRgNumero(jTextFieldSocioRgNumero.getText());
                        
                        p.setRgExpedidor(jTextFieldSocioOrgaoExpedidor.getText());
                        
    if((flagEditar==true)&& (socioNumero.equals(jTextFieldSocioNumero.getText()) ))
       {
       }
   else {
              
       if(new DaoEnderecoPessoa().EnderecopessoaporNumero(jTextFieldSocioNumero.getText())!=null)  {
       JOptionPane.showMessageDialog(null, "ja existe");
       throw new Exception("Número de Endereço já cadastrado: Erro 3");
       }    
       
    }
   
                        p.setNumeroEndereco(jTextFieldSocioNumero.getText());
                        p.setCidade(jTextFieldSocioCep2.getText());
                        p.setBairro(jTextFieldSocioBairro.getText());
                        p.setCep(jTextFieldSocioCEP.getText());

                        if (p1.matcher(jFormattedTextFieldSocioDataNascimento.getText()).find()) {


                            p.setDataNasc(SimpleDateFormat.getDateInstance().parse(jFormattedTextFieldSocioDataNascimento.getText()));
                        }

                        if (!p.getCpf().equals(jFormattedTextFieldSocioCPF.getText())) {
 
                            Pessoa p0 = new DaoPessoa().BuscarPessoaCpf(jFormattedTextFieldSocioCPF.getText());
                            if (p0 != null) {
                                JOptionPane.showMessageDialog(this, "Esse cpf já existe", "Erro", JOptionPane.ERROR_MESSAGE);
                                jFormattedTextFieldSocioCPF.setText("");

                                throw new Exception();

                            }

                        
                           
                        }
                        p.setCpf(jFormattedTextFieldSocioCPF.getText());
                        if (p1.matcher(jFormattedTextFieldSocioDataEmissao.getText()).find()) {


                            p.setRgEmissao(SimpleDateFormat.getDateInstance().parse(jFormattedTextFieldSocioDataEmissao.getText()));
                        }
                        p.setSexo((String) jComboBoxSocioSexo.getSelectedItem());
                        p.setUf((String) jComboBoxSocioUF.getSelectedItem());

                         //Enderecopessoa ep = new Enderecopessoa();
                        Endereco e = new DaoEndereco().BuscarEnderecoCompleto((String)jComboBoxSocioLogradouro.getSelectedItem());
                        List<Categoriasocio> cs = new DaoCategoriaSocio().BuscarCategoriaPorNomeLike((String) jComboBoxSocioCategoriaSocio.getSelectedItem());
                        p.getEnderecopessoaList().get(0).setIdCategoriaSocio(cs.get(0));
                        if (e != null) {
                            if(p.getIdEndereco() == e){
                            p.setIdEndereco(e);
                            }else{
                                
                                p.setIdEndereco(e);
                                p.getEnderecopessoaList().get(0).setIdEndereco(e);
                                p.getEnderecopessoaList().get(0).setNumero(p.getNumeroEndereco());
                                 
                            }

                        }

                        if (jRadioButtonSocioAtivo.isSelected()) {

                            p.setStatus(true);
                            if(p.getSocio().getDataAprovacao() == null){
                                
                                p.getSocio().setDataAprovacao(new Date());
                            }
                        } else {
                            p.getSocio().setDataAprovacao(null);
                            p.setStatus(false);
                        }
                        p.getSocio().setDataVence(SimpleDateFormat.getDateInstance().parse(jFormattedTextFieldSocioDiaVencimento.getText()));
                        p.getSocio().setDataMatricula(SimpleDateFormat.getDateInstance().parse(jFormattedTextFieldSocioDataMatricula.getText()));
                        p.getSocio().setNumeroSocio(Integer.parseInt((jTextFieldSocioNumeroSocio.getText())));
                        p.getSocio().setIdCategoriaSocio(cs.get(0));
                        
                        
                        //O socio usa um Carne de Agua ou de Socio??
                        if(jCheckBoxExclusivamenteSocio.isSelected()){
                        p.getSocio().setSocioExclusivo(true);//carne de Socio
                        }
                        else{
                        p.getSocio().setSocioExclusivo(false);//Carne de Agua
                        }
                        new DaoPessoa().AlterarPessoa(p);

                        jButtonSocioCancelarActionPerformed(evt);
                        JOptionPane.showMessageDialog(this, "Dados alterados com Sucesso!", "Salvar", JOptionPane.INFORMATION_MESSAGE);



                    } catch (Exception e) {

                        JOptionPane.showMessageDialog(this, "Erro :"+e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);

                    }
                }



            }

        }

    }//GEN-LAST:event_jButtonSocioSalvarActionPerformed

    private void jButtonSocioApagarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonSocioApagarActionPerformed


        int op = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja excluir o registro?", "Apagar", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (op == JOptionPane.YES_OPTION) {

            try {

                Socio s = new DaoSocio().BuscarSocioId(Integer.parseInt(jTextFieldSocioID.getText()));
                Pessoa p = s.getIdPessoa();

                new DaoPessoa().ApagarPessoa(p);
                JOptionPane.showMessageDialog(this, "Registro excluido com sucesso", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                jButtonSocioCancelarActionPerformed(evt);

            } catch (Exception e) {

                JOptionPane.showMessageDialog(this, "Erro ao excluir o registro", "Erro", JOptionPane.ERROR_MESSAGE);
            }

        }
    }//GEN-LAST:event_jButtonSocioApagarActionPerformed

    private void jButtonCategoriaSocioNovoActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonCategoriaSocioNovoActionPerformed

        setEditableComponentesCategoriaSocio(true);
        jButtonCategoriaSocioNovo.setEnabled(false);
        jButtonCategoriaSocioApagar.setEnabled(false);
        jButtonCategoriaSocioEditar.setEnabled(false);
        limparCamposCategoriaSocio();

        if (jComboBoxCategoriaSocioTaxa.getItemCount() == 0) {

            jComboBoxCategoriaSocioTaxa.addItem("");
            List<Taxa> taxas = new DaoTaxa().TaxasTodas();
            for (Taxa t : taxas) {

                jComboBoxCategoriaSocioTaxa.addItem(t.getNome());
            }

        }
        jComboBoxCategoriaSocioTaxa.setSelectedItem("");

    }//GEN-LAST:event_jButtonCategoriaSocioNovoActionPerformed

    private void jButtonCategoriaSocioCancelarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonCategoriaSocioCancelarActionPerformed

        setEditableComponentesCategoriaSocio(false);
        limparCamposCategoriaSocio();
        jButtonCategoriaSocioNovo.setEnabled(true);


    }//GEN-LAST:event_jButtonCategoriaSocioCancelarActionPerformed

    private void jButtonCategoriaSocioPesquisarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonCategoriaSocioPesquisarActionPerformed
        if (jButtonCategoriaSocioNovo.isEnabled()) {
            pesquisarTable = "categoria socio";
            mostrarJtable();

        } else {

            JOptionPane.showMessageDialog(this, "Cancele a operação para fazer uma pesquisa", "Atenção", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButtonCategoriaSocioPesquisarActionPerformed

    private void jButtonCategoriaSocioEditarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonCategoriaSocioEditarActionPerformed

        setEditableComponentesCategoriaSocio(true);
        jButtonCategoriaSocioApagar.setEnabled(false);
        jButtonCategoriaSocioEditar.setEnabled(false);

    }//GEN-LAST:event_jButtonCategoriaSocioEditarActionPerformed

    private void jButtonCategoriaSocioSalvarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonCategoriaSocioSalvarActionPerformed

        if (isCamposCategoriaSocioPreenchidos()) {

            if (jTextFieldCategoriaSocioID.getText().equals("")) {
                int op = JOptionPane.showConfirmDialog(this, "Deseja gravar esses dados?", "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (op == JOptionPane.YES_OPTION) {
                    try {
                        Categoriasocio c = new Categoriasocio();
                        c.setNome(jTextFieldCategoriaSocioNome.getText());
                        List<Taxa> taxas = new DaoTaxa().BuscarTaxaNomeLike((String) jComboBoxCategoriaSocioTaxa.getSelectedItem());
                        if (!taxas.isEmpty()) {

                            c.setTaxasId(taxas.get(0));
                        }

                        c.setDescricao(jTextAreaCategoriaSocioDescricao.getText());

                        new DaoCategoriaSocio().AdicionarCategoria(c);
                        JOptionPane.showMessageDialog(this, "Dados gravados com sucesso!");
                        jButtonCategoriaSocioCancelarActionPerformed(evt);
                    } catch (Exception e) {

                        JOptionPane.showMessageDialog(this, "Erro ao tentar gravar os dados", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                }

            } else {
                int op = JOptionPane.showConfirmDialog(this, "Deseja gravar a edição desse registro?", "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (op == JOptionPane.YES_OPTION) {

                    try {

                        Categoriasocio c = new DaoCategoriaSocio().BuscarCategoriaSocioPorId(Integer.parseInt(jTextFieldCategoriaSocioID.getText()));
                        c.setNome(jTextFieldCategoriaSocioNome.getText());
                        List<Taxa> taxas = new DaoTaxa().BuscarTaxaNomeLike((String) jComboBoxCategoriaSocioTaxa.getSelectedItem());
                        if (!taxas.isEmpty()) {

                            c.setTaxasId(taxas.get(0));
                        }

                        c.setDescricao(jTextAreaCategoriaSocioDescricao.getText());

                        new DaoCategoriaSocio().AtualizarCategoria(c);
                        JOptionPane.showMessageDialog(this, "Dados alterados com sucesso!");
                        jButtonCategoriaSocioCancelarActionPerformed(evt);


                    } catch (Exception e) {

                        JOptionPane.showMessageDialog(this, "Erro ao tentar gravar os dados", "Erro", JOptionPane.ERROR_MESSAGE);
                    }


                }


            }
        }
    }//GEN-LAST:event_jButtonCategoriaSocioSalvarActionPerformed

    private void jButtonTipoDespesaNovoActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonTipoDespesaNovoActionPerformed

        limparCamposTipoDespesa();
        setEditableComponentesTipoDespesa(true);
        jButtonTipoDespesaNovo.setEnabled(false);
        jButtonTipoDespesaApagar.setEnabled(false);
        jButtonTipoDespesaEditar.setEnabled(false);


    }//GEN-LAST:event_jButtonTipoDespesaNovoActionPerformed

    private void jButtonTipoDespesaCancelarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonTipoDespesaCancelarActionPerformed

        limparCamposTipoDespesa();
        setEditableComponentesTipoDespesa(false);
        jButtonTipoDespesaNovo.setEnabled(true);

    }//GEN-LAST:event_jButtonTipoDespesaCancelarActionPerformed

    private void jButtonTipoDespesaEditarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonTipoDespesaEditarActionPerformed

        setEditableComponentesTipoDespesa(true);
        jButtonTipoDespesaEditar.setEnabled(false);
        jButtonTipoDespesaApagar.setEnabled(false);

    }//GEN-LAST:event_jButtonTipoDespesaEditarActionPerformed

    private void jButtonTipoDespesaPesquisarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonTipoDespesaPesquisarActionPerformed

        if (jButtonTipoDespesaNovo.isEnabled()) {

            pesquisarTable = "tipo despesa";
            mostrarJtable();

        } else {

            JOptionPane.showMessageDialog(this, "Cancele a operação para fazer uma pesquisa", "Atenção", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButtonTipoDespesaPesquisarActionPerformed

    private void jButtonTipoDespesaSalvarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonTipoDespesaSalvarActionPerformed


        if (isCamposTipoDespesaPreenchidos()) {

            if (jTextFieldTIpoDespesaID.getText().equals("")) {

                int op = JOptionPane.showConfirmDialog(this, "Confirma a gravação dos dados?", "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (op == JOptionPane.YES_OPTION) {

                    try {
                        Motivodespesa md = new Motivodespesa();

                        md.setNome(jTextFieldTipoDespesaNome.getText());
                        md.setDescricao(jTextAreaTipoDespesaDescricao.getText());
                        md.setObservacao(jTextAreaTipoDespesaObservacao.getText());

                        new DaoMotivoDespesa().AdicionarMotivoDespesa(md);

                        jButtonTipoDespesaCancelarActionPerformed(evt);
                        JOptionPane.showMessageDialog(this, "Registro gravado com sucesso!", "Atenção", JOptionPane.INFORMATION_MESSAGE);


                    } catch (Exception e) {

                        JOptionPane.showMessageDialog(this, "Erro para gravar os dados", "Erro", JOptionPane.ERROR_MESSAGE);

                    }
                }

            } else {

                int op = JOptionPane.showConfirmDialog(this, "Confirma a gravação da edição desse registro?", "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (op == JOptionPane.YES_OPTION) {

                    try {

                        Motivodespesa md = new DaoMotivoDespesa().BuscarMotivoDespesaId(Integer.parseInt(jTextFieldTIpoDespesaID.getText()));

                        md.setNome(jTextFieldTipoDespesaNome.getText());
                        md.setDescricao(jTextAreaTipoDespesaDescricao.getText());
                        md.setObservacao(jTextAreaTipoDespesaObservacao.getText());

                        new DaoMotivoDespesa().AlterarMotivoDespesa(md);

                        jButtonTipoDespesaCancelarActionPerformed(evt);
                        JOptionPane.showMessageDialog(this, "Registro gravado com sucesso!", "Atenção", JOptionPane.INFORMATION_MESSAGE);



                    } catch (Exception e) {

                        JOptionPane.showMessageDialog(this, "Erro para gravar os dados", "Erro", JOptionPane.ERROR_MESSAGE);

                    }


                }
            }



        }
    }//GEN-LAST:event_jButtonTipoDespesaSalvarActionPerformed

    private void jButtonTipoDespesaApagarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonTipoDespesaApagarActionPerformed

        int op = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja excluir esse registro?", "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (op == JOptionPane.YES_OPTION) {

            try {

                Motivodespesa md = new DaoMotivoDespesa().BuscarMotivoDespesaId(Integer.parseInt(jTextFieldTIpoDespesaID.getText()));

                new DaoMotivoDespesa().ApagarMotivoDespesa(md);

                JOptionPane.showMessageDialog(this, "Registro excluido com sucesso!", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                jButtonTipoDespesaCancelarActionPerformed(evt);

            } catch (Exception e) {

                JOptionPane.showMessageDialog(this, "Erro ao tentar excluir o registro", "Erro", JOptionPane.ERROR_MESSAGE);

            }

        }

    }//GEN-LAST:event_jButtonTipoDespesaApagarActionPerformed

    private void jButtonDespesaNovoActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonDespesaNovoActionPerformed

        limparCamposDespesa();

        setEditableComponentesDespesa(true);
        jButtonDespesaNovo.setEnabled(false);
        jButtonDespesaApagar.setEnabled(false);
        jButtonDespesaEditar.setEnabled(false);

        if (jComboBoxDespesaFuncionario.getItemCount() == 0) {
            jComboBoxDespesaFuncionario.addItem("");
            List<Funcionario> funcionarios = new DaoFuncionario().BuscarFuncionarios();

            for (Funcionario f : funcionarios) {

                jComboBoxDespesaFuncionario.addItem(f.getIdPessoa().getNome() + " " + f.getIdPessoa().getSobrenome());
            }

        }
        jComboBoxDespesaFuncionario.setSelectedIndex(0);

        if (jComboBoxDespesaMotivo.getItemCount() == 0) {
            jComboBoxDespesaMotivo.addItem("");
            List<Motivodespesa> motivoDespesa = new DaoMotivoDespesa().BuscarTodosMotivos();

            for (Motivodespesa m : motivoDespesa) {

                jComboBoxDespesaMotivo.addItem(m.getNome());
            }
        }
        jComboBoxDespesaMotivo.setSelectedIndex(0);

    }//GEN-LAST:event_jButtonDespesaNovoActionPerformed

    private void jButtonDespesaCancelarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonDespesaCancelarActionPerformed

        limparCamposDespesa();
        setEditableComponentesDespesa(false);
        jButtonDespesaNovo.setEnabled(true);

    }//GEN-LAST:event_jButtonDespesaCancelarActionPerformed

    private void jButtonDespesaEditarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonDespesaEditarActionPerformed

        setEditableComponentesDespesa(true);
        jButtonDespesaEditar.setEnabled(false);
        jButtonDespesaApagar.setEnabled(false);


    }//GEN-LAST:event_jButtonDespesaEditarActionPerformed

    private void jButtonDespesaPesquisarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonDespesaPesquisarActionPerformed

        if (jButtonDespesaNovo.isEnabled()) {

            pesquisarTable = "despesa";
            mostrarJtable();

        } else {

            JOptionPane.showMessageDialog(this, "Cancele a operação antes de realizar uma pesquisa", "Atenção", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_jButtonDespesaPesquisarActionPerformed

    private void jButtonDespesaSalvarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonDespesaSalvarActionPerformed

        
        if (isCamposDespesaPreenchidos()) {

            if (jTextFieldDespesaID.getText().equals("")) {

                int op = JOptionPane.showConfirmDialog(this, "Confirma gravação do registro?", "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (op == JOptionPane.YES_OPTION) {

                    try {

                        Saida s = new Saida();
                        s.setFavorecido(jTextFieldDespesaFavorecido.getText());
                        s.setValor(BigDecimal.valueOf(Double.parseDouble(jTextFieldDespesaValor.getText())));



                        s.setData(SimpleDateFormat.getDateInstance().parse(jFormattedTextFieldDespesaData.getText()));

                        Pessoa p1 = new DaoPessoa().BuscarNomeCompleto((String) jComboBoxDespesaFuncionario.getSelectedItem());
                        Funcionario f = p1.getFuncionario();
                        s.setIdfuncionario(f);

                        List<Motivodespesa> motivos = new DaoMotivoDespesa().BuscarMotivoDespesaLikeNome((String) jComboBoxDespesaMotivo.getSelectedItem());
                        s.setIdmotivosaida(motivos.get(0));
                        s.setObservacao(jTextAreaDespesaObservacao.getText());

                        new DaoSaidas().AdicionarSaida(s);

                        JOptionPane.showMessageDialog(this, "Dados gravados com sucesso", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                        jButtonDespesaCancelarActionPerformed(evt);


                    } catch (Exception e) {
                        //04
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(this, "Erro ao gravar o registro 2", "Erro", JOptionPane.ERROR_MESSAGE);
                    }



                }



            } else {
                int op = JOptionPane.showConfirmDialog(this, "Confirma a gravação da edição desse registro?", "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (op == JOptionPane.YES_OPTION) {

                    try {

                        Saida s = new DaoSaidas().BuscarSaidaId(Integer.parseInt(jTextFieldDespesaID.getText()));
                        s.setFavorecido(jTextFieldDespesaFavorecido.getText());
                        s.setValor(BigDecimal.valueOf(Double.parseDouble(jTextFieldDespesaValor.getText())));

                        s.setData(SimpleDateFormat.getDateInstance().parse(jFormattedTextFieldDespesaData.getText()));

                        Pessoa p1 = new DaoPessoa().BuscarNomeCompleto((String) jComboBoxDespesaFuncionario.getSelectedItem());
                        Funcionario f = p1.getFuncionario();
                        s.setIdfuncionario(f);

                        List<Motivodespesa> motivos = new DaoMotivoDespesa().BuscarMotivoDespesaLikeNome((String) jComboBoxDespesaMotivo.getSelectedItem());
                        s.setIdmotivosaida(motivos.get(0));
                        s.setObservacao(jTextAreaDespesaObservacao.getText());

                        new DaoSaidas().AlterarSaida(s);

                        JOptionPane.showMessageDialog(this, "Dados alterados com sucesso", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                        jButtonDespesaCancelarActionPerformed(evt);




                    } catch (Exception e) {

                        JOptionPane.showMessageDialog(this, "Erro ao alterar o registro", "Erro", JOptionPane.ERROR_MESSAGE);

                    }



                }


            }



        }


    }//GEN-LAST:event_jButtonDespesaSalvarActionPerformed

    private void jButtonDespesaApagarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonDespesaApagarActionPerformed

        int op = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja excluir esse registro?", "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (op == JOptionPane.YES_OPTION) {

            try {
                Saida s = new DaoSaidas().BuscarSaidaId(Integer.parseInt(jTextFieldDespesaID.getText()));

                new DaoSaidas().ApagarSaida(s);
                JOptionPane.showMessageDialog(this, "Registro excluido com sucesso!", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                jButtonDespesaCancelarActionPerformed(evt);

            } catch (Exception e) {

                JOptionPane.showMessageDialog(this, "Erro ao tentar excluir o registro", "Erro", JOptionPane.ERROR_MESSAGE);

            }
        }


    }//GEN-LAST:event_jButtonDespesaApagarActionPerformed

    private void jButtonTipoReceitaNovoActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonTipoReceitaNovoActionPerformed

        limparCamposTipoReceita();

        setEditableComponentesTipoReceita(true);
        jButtonTipoReceitaNovo.setEnabled(false);
        jButtonTipoReceitaApagar.setEnabled(false);
        jButtonTipoReceitaEditar.setEnabled(false);

    }//GEN-LAST:event_jButtonTipoReceitaNovoActionPerformed

    private void jButtonTipoReceitaCancelarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonTipoReceitaCancelarActionPerformed

        limparCamposTipoReceita();
        setEditableComponentesTipoReceita(false);
        jButtonTipoReceitaNovo.setEnabled(true);

    }//GEN-LAST:event_jButtonTipoReceitaCancelarActionPerformed

    private void jButtonTipoReceitaEditarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonTipoReceitaEditarActionPerformed
        
        setEditableComponentesTipoReceita(true);
        jButtonTipoReceitaApagar.setEnabled(false);
        jButtonTipoReceitaEditar.setEnabled(false);
        
        
    }//GEN-LAST:event_jButtonTipoReceitaEditarActionPerformed

    private void jButtonTipoReceitaPesquisarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonTipoReceitaPesquisarActionPerformed

        if (jButtonTipoReceitaNovo.isEnabled()) {

            pesquisarTable = "tipo receita";
            mostrarJtable();

        } else {

            JOptionPane.showMessageDialog(this, "Cancele a operação antes de realizar uma pesquisa", "Atenção", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_jButtonTipoReceitaPesquisarActionPerformed

    private void jButtonTipoReceitaSalvarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonTipoReceitaSalvarActionPerformed

        if (isCamposTipoReceitaPreenchidos()) {

            if (jTextFieldTIpoReceitaID.getText().equals("")) {
                int op = JOptionPane.showConfirmDialog(this, "Confirma a gravação desse registro?", "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (op == JOptionPane.YES_OPTION) {
                    try {
                        Motivoentrada motivo = new Motivoentrada();

                        motivo.setNome(jTextFieldTipoReceitaNome.getText());
                        motivo.setDescricao(jTextAreaTipoReceitaDescricao.getText());
                        motivo.setObservacao(jTextAreaTipoReceitaObservacao.getText());

                        new DaoMotivoEntrada().AdicionarMotivoEntrada(motivo);
                        JOptionPane.showMessageDialog(this, "Registro gravado com sucesso!", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                        jButtonTipoReceitaCancelarActionPerformed(evt);

                    } catch (Exception e) {
                        //01
                        JOptionPane.showMessageDialog(this, "Erro ao gravar o registro 4", "Erro", JOptionPane.ERROR_MESSAGE);

                    }

                }




            } else {

                int op = JOptionPane.showConfirmDialog(this, "Confirma a alteração desse registro?", "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (op == JOptionPane.YES_OPTION) {

                    try {
                        Motivoentrada motivo = new DaoMotivoEntrada().BuscarMotivoEntradaId(Integer.parseInt(jTextFieldTIpoReceitaID.getText()));

                        motivo.setNome(jTextFieldTipoReceitaNome.getText());
                        motivo.setDescricao(jTextAreaTipoReceitaDescricao.getText());
                        motivo.setObservacao(jTextAreaTipoReceitaObservacao.getText());

                        new DaoMotivoEntrada().AlterarMotivoEntrada(motivo);
                        JOptionPane.showMessageDialog(this, "Registro alterado com sucesso!", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                        jButtonTipoReceitaCancelarActionPerformed(evt);

                    } catch (Exception e) {

                        JOptionPane.showMessageDialog(this, "Erro ao alterar o registro", "Erro", JOptionPane.ERROR_MESSAGE);

                    }


                }

            }


        }

    }//GEN-LAST:event_jButtonTipoReceitaSalvarActionPerformed

    private void jButtonTipoReceitaApagarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonTipoReceitaApagarActionPerformed
       
          int op = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja excluir esse registro?", "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
          if(op == JOptionPane.YES_OPTION){
              
             try{
                 Motivoentrada m = new DaoMotivoEntrada().BuscarMotivoEntradaId(Integer.parseInt(jTextFieldTIpoReceitaID.getText()));
             
                 new DaoMotivoEntrada().ApagarMotivoEntrada(m);
                 JOptionPane.showMessageDialog(this,"Registro excluido com sucesso","Atenção",JOptionPane.INFORMATION_MESSAGE);
                 jButtonTipoReceitaCancelarActionPerformed(evt);
                 
             }catch(Exception e){
                 
                 JOptionPane.showMessageDialog(this, "Erro ao excluir o registro","Erro",JOptionPane.ERROR_MESSAGE);
                 
             }
              
              
              
          }
          
        
    }//GEN-LAST:event_jButtonTipoReceitaApagarActionPerformed

    private void jButtonReceitaNovoActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonReceitaNovoActionPerformed
        
        limparCamposReceita();
        
        jCheckBoxReceitaAvulsa.setEnabled(true);
        setEditableComponentesReceita(true);
        jButtonReceitaNovo.setEnabled(false);
        jButtonReceitaApagar.setEnabled(false);
        jButtonReceitaEditar.setEnabled(false);
        
        
        if(jComboBoxReceitaFuncionario.getItemCount() == 0){
            
            jComboBoxReceitaFuncionario.addItem("");
            List<Funcionario> funcionarios = new DaoFuncionario().BuscarFuncionarios();
            for(Funcionario f : funcionarios){
                
                jComboBoxReceitaFuncionario.addItem(f.getIdPessoa().getNome()+" "+f.getIdPessoa().getSobrenome());
            }
      
        }
        
        if(jComboBoxReceitaMotivoEntrada.getItemCount() == 0){
            
            jComboBoxReceitaMotivoEntrada.addItem("");
            
            List<Motivoentrada> motivos = new DaoMotivoEntrada().BuscarTodosMotivos();
            for(Motivoentrada m : motivos){
                
                jComboBoxReceitaMotivoEntrada.addItem(m.getNome());
                
            }
 
            
        }
        
        if(jComboBoxReceitaSocio.getItemCount() == 0){
            
            jComboBoxReceitaSocio.addItem("");
            
            List<SociosView> socios = new DaoSocioView().BuscarTodosSociosView();
            
            for(SociosView s : socios){
                
                jComboBoxReceitaSocio.addItem(s.getNome());
                
            }
            
        }
        
        
    }//GEN-LAST:event_jButtonReceitaNovoActionPerformed

    private void jButtonReceitaCancelarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonReceitaCancelarActionPerformed
        
        
        limparCamposReceita();
        setEditableComponentesReceita(false);
        jButtonReceitaNovo.setEnabled(true);
    }//GEN-LAST:event_jButtonReceitaCancelarActionPerformed

    private void jButtonReceitaEditarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonReceitaEditarActionPerformed
        
        setEditableComponentesReceita(true);
        jButtonReceitaApagar.setEnabled(false);
        jButtonReceitaEditar.setEnabled(false);
    }//GEN-LAST:event_jButtonReceitaEditarActionPerformed

    private void jButtonSocioAdicionarLogradouroActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonSocioAdicionarLogradouroActionPerformed
       
       Socio s = new DaoSocio().BuscarSocioId(Integer.parseInt(jTextFieldSocioID.getText()));
       Pessoa p = s.getIdPessoa();
       List<Enderecopessoa> enderecos = p.getEnderecopessoaList();
      
       Logradouros l = new Logradouros(this, true, enderecos, s);
       l.setLocationRelativeTo(null);
      
       l.setVisible(true);
      
       
    }//GEN-LAST:event_jButtonSocioAdicionarLogradouroActionPerformed

    private void jButtonReceitaPesquisarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonReceitaPesquisarActionPerformed
       
         if (jButtonReceitaNovo.isEnabled()) {

            pesquisarTable = "receita";
            mostrarJtable();

        } else {

            JOptionPane.showMessageDialog(this, "Cancele a operação antes de realizar uma pesquisa", "Atenção", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }//GEN-LAST:event_jButtonReceitaPesquisarActionPerformed

    private void jButtonReceitaSalvarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonReceitaSalvarActionPerformed
      
        if(isCamposReceitaPreenchidos()){
 
            if(jTextFieldReceitaID.getText().equals("")){
               int op = JOptionPane.showConfirmDialog(this, "Confirma a gravação desse registro?", "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
               if(op == JOptionPane.YES_OPTION){
                   
                   try{
                       Entrada e = new Entrada();
              
                       e.setData(jDateChooser1.getDate());
                       e.setValor(BigDecimal.valueOf(Double.parseDouble(jTextFieldReceitaValor.getText())));
                       e.setObservacao(jTextAreaReceitaObservacao.getText());
                       
                      Pessoa p = new DaoPessoa().BuscarNomeCompleto((String)jComboBoxReceitaFuncionario.getSelectedItem());
                      e.setIdFuncionario(p.getFuncionario());
                      
                      p = new DaoPessoa().BuscarNomeCompleto((String)jComboBoxReceitaSocio.getSelectedItem());
                      e.setIdCedente(p.getSocio());
                      
                      List<Motivoentrada> entrada = new DaoMotivoEntrada().BuscarMotivoEntradaLikeNome((String)jComboBoxReceitaMotivoEntrada.getSelectedItem());
                       e.setIdMotivoEntrada(entrada.get(0));
                       
                       new DaoEntradas().AdicionarEntrada(e);
                       
                        JOptionPane.showMessageDialog(this, "Registro gravado com sucesso!", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                       jButtonReceitaCancelarActionPerformed(evt);
                   }catch(NumberFormatException | HeadlessException e){
                       JOptionPane.showMessageDialog(this, "Erro ao gravar o registro 3", "Erro", JOptionPane.ERROR_MESSAGE);
                   }                 
               }
               
            }else{
                 int op = JOptionPane.showConfirmDialog(this, "Confirma a alteração desse registro?", "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                 if(op == JOptionPane.YES_OPTION){
                                          
                     try{
                       
                       Entrada e = new DaoEntradas().EntradaPorId(Integer.parseInt(jTextFieldReceitaID.getText()));
                       
                       e.setData(jDateChooser1.getDate());
                       e.setValor(BigDecimal.valueOf(Double.parseDouble(jTextFieldReceitaValor.getText())));
                       e.setObservacao(jTextAreaReceitaObservacao.getText());
                       
                      Pessoa p = new DaoPessoa().BuscarNomeCompleto((String)jComboBoxReceitaFuncionario.getSelectedItem());
                      e.setIdFuncionario(p.getFuncionario());
                      
                      p = new DaoPessoa().BuscarNomeCompleto((String)jComboBoxReceitaSocio.getSelectedItem());
                      if(p.getSocio()!=null)
                      {
                           e.setIdCedente(p.getSocio());
                      }
                     
                      
                      List<Motivoentrada> entrada = new DaoMotivoEntrada().BuscarMotivoEntradaLikeNome((String)jComboBoxReceitaMotivoEntrada.getSelectedItem());
                       e.setIdMotivoEntrada(entrada.get(0));
                       
                       new DaoEntradas().AlterarEntrada(e);
                        JOptionPane.showMessageDialog(this, "Registro alterado com sucesso!", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                       jButtonReceitaCancelarActionPerformed(evt);
                   }catch(HeadlessException | NumberFormatException e){
                       
                       JOptionPane.showMessageDialog(this, "Erro ao alterar o registro", "Erro", JOptionPane.ERROR_MESSAGE);
                       
                   }  
                     
                     
                     
                 }
                
                
            }
            
            
            
            
        
        }
        
    }//GEN-LAST:event_jButtonReceitaSalvarActionPerformed

    private void jButtonReceitaApagarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonReceitaApagarActionPerformed
      
         int op = JOptionPane.showConfirmDialog(this, "1 Tem certeza que deseja excluir esse registro?", "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
         if(op == JOptionPane.YES_OPTION){
             
             try{
                 
                 Entrada e = new DaoEntradas().EntradaPorId(Integer.parseInt(jTextFieldReceitaID.getText()));
                 
                 new DaoEntradas().ApagarEntrada(e);
           
                 JOptionPane.showMessageDialog(this,"Registro excluido com sucesso","Atenção",JOptionPane.INFORMATION_MESSAGE);
                 jButtonReceitaCancelarActionPerformed(evt);
             }catch(NumberFormatException | HeadlessException e){
                 
                 JOptionPane.showMessageDialog(this, "Erro ao excluir o registro", "Erro", JOptionPane.ERROR_MESSAGE);
                 
             }
             
         }
        
    }//GEN-LAST:event_jButtonReceitaApagarActionPerformed

    private void jButtonChequeNovoActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonChequeNovoActionPerformed
        
        limparCamposCheques();
        
        setEditableComponentesCheques(true);
        jButtonChequeNovo.setEnabled(false);
        jButtonChequeApagar.setEnabled(false);
        jButtonChequeEditar.setEnabled(false);
        
        if(jComboBoxChequeFuncionario.getItemCount() == 0){
            
            jComboBoxChequeFuncionario.addItem("");
            List<Funcionario> funcionarios = new DaoFuncionario().BuscarFuncionarios();
            
            if(!funcionarios.isEmpty()){
                
                for(Funcionario f : funcionarios){
                    
                    jComboBoxChequeFuncionario.addItem(f.getIdPessoa().getNome()+" "+f.getIdPessoa().getSobrenome());
                }
            }
            
            
        }
        
        if(jComboBoxChequeMotivoDespesa.getItemCount() == 0){
            
            jComboBoxChequeMotivoDespesa.addItem("");
            List<Motivodespesa> motivos = new DaoMotivoDespesa().BuscarTodosMotivos();
            
            if(!motivos.isEmpty()){
                
                for(Motivodespesa m : motivos){
                    
                    jComboBoxChequeMotivoDespesa.addItem(m.getNome());
                }
                
            }
            
            
        }
        
    }//GEN-LAST:event_jButtonChequeNovoActionPerformed

    private void jButtonChequeEditarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonChequeEditarActionPerformed
        
        setEditableComponentesCheques(true);
        jButtonChequeEditar.setEnabled(false);
        jButtonChequeApagar.setEnabled(false);
        
    }//GEN-LAST:event_jButtonChequeEditarActionPerformed

    private void jButtonChequeCancelarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonChequeCancelarActionPerformed
       
        limparCamposCheques();
        
        setEditableComponentesCheques(false);
        jButtonChequeNovo.setEnabled(true);
        
    }//GEN-LAST:event_jButtonChequeCancelarActionPerformed

    private void jButtonChequePesquisarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonChequePesquisarActionPerformed
       
          if (jButtonChequeNovo.isEnabled()) {

            pesquisarTable = "cheque";
            mostrarJtable();

        } else {

            JOptionPane.showMessageDialog(this, "Cancele a operação antes de realizar uma pesquisa", "Atenção", JOptionPane.INFORMATION_MESSAGE);
        }
        
        
    }//GEN-LAST:event_jButtonChequePesquisarActionPerformed

    private void jButtonChequeSalvarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonChequeSalvarActionPerformed
        
        if(isCamposChequePreenchidos()){
            
            if(jTextFieldChequeID.getText().equals("")){
            int op = JOptionPane.showConfirmDialog(this, "Confirma a gravação desse registro?", "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(op == JOptionPane.YES_OPTION){
                
                try{
                    
                    Cheque c = new Cheque();
                    
                    c.setNumero(Integer.parseInt(jTextFieldChequeNumero.getText()));
                    c.setValor(BigDecimal.valueOf(Double.parseDouble(jTextFieldChequeValor.getText())));
                    c.setDataPagamento(SimpleDateFormat.getDateInstance().parse(jFormattedTextFieldChequeDataPagamento.getText()));
                    c.setDataVencimento(SimpleDateFormat.getDateInstance().parse(jFormattedTextFieldChequeDataVencimento.getText()));
                    c.setObservacoes(jTextAreaChequeObservacoes.getText());
                    
                    Pessoa pessoa = new DaoPessoa().BuscarNomeCompleto((String)jComboBoxChequeFuncionario.getSelectedItem());
                    c.setIdFuncionario(pessoa.getFuncionario());
                    
                    List<Motivodespesa> motivos = new DaoMotivoDespesa().BuscarMotivoDespesaLikeNome((String) jComboBoxChequeMotivoDespesa.getSelectedItem());
                    c.setIdMotivoDespesa(motivos.get(0));
                    
                    
                     new DaoCheque().AdicionarCheque(c);
                     JOptionPane.showMessageDialog(this, "Registro gravado com sucesso!", "Atenção", JOptionPane.INFORMATION_MESSAGE);       
                     jButtonChequeCancelarActionPerformed(evt);
                    
                }catch(Exception e){
                    //03
                       JOptionPane.showMessageDialog(this, "Erro ao gravar o registro 1", "Erro", JOptionPane.ERROR_MESSAGE);
                    
                }
                
                
                
            }
            
            
            }else{
                 int op = JOptionPane.showConfirmDialog(this, "Confirma a alteração desse registro?", "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                 if(op == JOptionPane.YES_OPTION){
                     
                     try{
                         
                    Cheque c = new DaoCheque().ChequesId(Integer.parseInt(jTextFieldChequeID.getText()));
                    
                    c.setNumero(Integer.parseInt(jTextFieldChequeNumero.getText()));
                    c.setValor(BigDecimal.valueOf(Double.parseDouble(jTextFieldChequeValor.getText())));
                    c.setDataPagamento(SimpleDateFormat.getDateInstance().parse(jFormattedTextFieldChequeDataPagamento.getText()));
                    c.setDataVencimento(SimpleDateFormat.getDateInstance().parse(jFormattedTextFieldChequeDataVencimento.getText()));
                    c.setObservacoes(jTextAreaChequeObservacoes.getText());
                    
                    Pessoa pessoa = new DaoPessoa().BuscarNomeCompleto((String)jComboBoxChequeFuncionario.getSelectedItem());
                    c.setIdFuncionario(pessoa.getFuncionario());
                    
                    List<Motivodespesa> motivos = new DaoMotivoDespesa().BuscarMotivoDespesaLikeNome((String) jComboBoxChequeMotivoDespesa.getSelectedItem());
                    c.setIdMotivoDespesa(motivos.get(0));
                    
                    
                     new DaoCheque().AtualizarCheque(c);
                     JOptionPane.showMessageDialog(this, "Registro alterado com sucesso!", "Atenção", JOptionPane.INFORMATION_MESSAGE);       
                     jButtonChequeCancelarActionPerformed(evt);  
                         
                         
                     }catch(Exception e){
                         
                       JOptionPane.showMessageDialog(this, "Erro ao alterar o registro", "Erro", JOptionPane.ERROR_MESSAGE);    
                         
                     }
                     
                 }
                
                
            }
            
        }
        
        
    }//GEN-LAST:event_jButtonChequeSalvarActionPerformed

    private void jButtonChequeApagarActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonChequeApagarActionPerformed
        
         int op = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja excluir esse registro?", "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
         if(op == JOptionPane.YES_OPTION){
             
             try{
                 
                 Cheque c = new DaoCheque().ChequesId(Integer.parseInt(jTextFieldChequeID.getText()));
                 
                 new DaoCheque().ApagarCheque(c);
                 
                 JOptionPane.showMessageDialog(this,"Registro excluido com sucesso","Atenção",JOptionPane.INFORMATION_MESSAGE);
                 jButtonChequeCancelarActionPerformed(evt);
                 
             }catch(Exception e){
                 
                  JOptionPane.showMessageDialog(this, "Erro ao excluir o registro", "Erro", JOptionPane.ERROR_MESSAGE);
             }
             
         }
        
    }//GEN-LAST:event_jButtonChequeApagarActionPerformed

    private void jButton1ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        
         if (jButtonSocioNovo.isEnabled()) {
            pesquisarTable = "importar funcionário";
            mostrarJtable();
            if (jComboBoxSocioLogradouro.getItemCount() == 0) {

            jComboBoxSocioLogradouro.addItem("");
            List<Endereco> end = new DaoEndereco().BuscarTodosEnderecos();
            for (Endereco e : end) {

                jComboBoxSocioLogradouro.addItem(e.getTipo()+" "+e.getNome());


            }


        }
        if (jComboBoxSocioCategoriaSocio.getItemCount() == 0) {

            jComboBoxSocioCategoriaSocio.addItem("");
            List<Categoriasocio> cs = new DaoCategoriaSocio().BuscarTodasCategorias();
            for (Categoriasocio c : cs) {

                jComboBoxSocioCategoriaSocio.addItem(c.getNome());

            }

        }
            
        } else {

            JOptionPane.showMessageDialog(this, "Cancele a operação para importar um funcionário", "Atenção", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBoxSocioUFActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jComboBoxSocioUFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxSocioUFActionPerformed

    private void jTextFieldSocioApelidoActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jTextFieldSocioApelidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSocioApelidoActionPerformed

    private void jFormattedTextFieldSocioDataNascimentoActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jFormattedTextFieldSocioDataNascimentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextFieldSocioDataNascimentoActionPerformed

    private void jTextFieldSocioIDActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jTextFieldSocioIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSocioIDActionPerformed

    private void jTextFieldSocioEmailActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jTextFieldSocioEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSocioEmailActionPerformed

    private void jTextFieldFuncionarioSalarioActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jTextFieldFuncionarioSalarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldFuncionarioSalarioActionPerformed

    private void jTextFieldFuncionarioRgnumeroActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jTextFieldFuncionarioRgnumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldFuncionarioRgnumeroActionPerformed

    private void jTextFieldReceitaIDActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jTextFieldReceitaIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldReceitaIDActionPerformed

    private void jTextFieldChequeValorActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jTextFieldChequeValorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldChequeValorActionPerformed

    private void jTextFieldFuncionarioEmailActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jTextFieldFuncionarioEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldFuncionarioEmailActionPerformed

    private void jButton2ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.cadastrar = true;
        jButtonLogradouroCancelar.setEnabled(true);
        jTabbedPane1.setSelectedComponent(jPanelLog);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jRadioCPFCNPJActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jRadioCPFCNPJActionPerformed
      if(jRadioCPFCNPJ.isSelected()){
          jFormattedCNPJ.setEditable(true);
          jFormattedTextFieldSocioCPF.setEditable(false);
          jFormattedTextFieldSocioCPF.setText(null);
      }
      else{
          jFormattedCNPJ.setEditable(false);
          jFormattedTextFieldSocioCPF.setEditable(true);
          jFormattedCNPJ.setText(null);
      }
    }//GEN-LAST:event_jRadioCPFCNPJActionPerformed

    private void jCheckBoxReceitaAvulsaActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jCheckBoxReceitaAvulsaActionPerformed
      if(jCheckBoxReceitaAvulsa.isSelected()){
          jComboBoxReceitaSocio.setSelectedIndex(0);
          jComboBoxReceitaSocio.setEnabled(false);
      }
      else{
          jComboBoxReceitaSocio.setEnabled(true);
      }
    }//GEN-LAST:event_jCheckBoxReceitaAvulsaActionPerformed

    private void jTextFieldReceitaValorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldReceitaValorFocusLost
      
    }//GEN-LAST:event_jTextFieldReceitaValorFocusLost

    private void editableTextFields(boolean editable) {

        jTextFieldFuncionarioApelido.setEditable(editable);
        jTextFieldFuncionarioBairro.setEditable(editable);
        jTextFieldFuncionarioCargo.setEditable(editable);
        jButton2.setEnabled(editable);
        jTextFieldFuncionarioCep.setEditable(editable);
        jTextFieldFuncionarioCidade.setEditable(editable);
        jFormattedTextFieldFuncionarioCpf.setEditable(editable);
        jFormattedTextFieldFuncionarioDataContratacao.setEditable(editable);
        jFormattedTextFieldFuncionarioDataNascimento.setEditable(editable);
        jFormattedTextFieldFuncionarioDataEmissao.setEditable(editable);
        jTextFieldFuncionarioEmail.setEditable(editable);
        jTextFieldFuncionarioNomedame.setEditable(editable);
        jTextFieldFuncionarioNomedopai.setEditable(editable);
        jTextFieldFuncionarioNumero.setEditable(editable);
        jTextFieldFuncionarioNumeroDaMatricula.setEditable(editable);
        jTextFieldFuncionarioOrgaoExpedidor.setEditable(editable);
        jTextFieldFuncionarioRgnumero.setEditable(editable);
        jTextFieldFuncionarioSalario.setEditable(editable);
        jTextFieldFuncionarioSobrenome.setEditable(editable);
        jTextFieldFuncionarioTelefone.setEditable(editable);
        jComboBoxFuncionarioLograduro.setEnabled(editable);
        jComboBoxFuncionarioSexo.setEnabled(editable);
        jComboBoxFuncionarioStatus.setEnabled(editable);
        jComboBoxFuncionarioUf.setEnabled(editable);
        jButtonFuncionarioApagar.setEnabled(editable);
        jButtonFuncionarioCancelar.setEnabled(editable);
        jButtonFuncionarioEditar.setEnabled(editable);
        jButtonFuncionarioSalvar.setEnabled(editable);

    }

    private void limparCampos() {

        jTextFieldFuncionarioID.setText("");
        jTextFieldFuncionarioNome.setText("");
        jTextFieldFuncionarioApelido.setText("");
        jTextFieldFuncionarioBairro.setText("");
        jTextFieldFuncionarioCargo.setText("");

        jTextFieldFuncionarioCep.setText("");
        jTextFieldFuncionarioCidade.setText("");
        jFormattedTextFieldFuncionarioCpf.setText("");
        jFormattedTextFieldFuncionarioDataContratacao.setText("");
        jFormattedTextFieldFuncionarioDataNascimento.setText("");
        jFormattedTextFieldFuncionarioDataEmissao.setText("");
        jTextFieldFuncionarioEmail.setText("");
        jTextFieldFuncionarioNomedame.setText("");
        jTextFieldFuncionarioNomedopai.setText("");
        jTextFieldFuncionarioNumero.setText("");
        jTextFieldFuncionarioNumeroDaMatricula.setText("");
        jTextFieldFuncionarioOrgaoExpedidor.setText("");
        jTextFieldFuncionarioRgnumero.setText("");
        jTextFieldFuncionarioSalario.setText("");
        jTextFieldFuncionarioSobrenome.setText("");
        jTextFieldFuncionarioTelefone.setText("");
        jTextAreaFuncionarioObservacoes.setText("");
        jComboBoxFuncionarioSexo.setSelectedIndex(0);
        jComboBoxFuncionarioStatus.setSelectedIndex(0);
        jComboBoxFuncionarioUf.setSelectedIndex(0);
        if (jComboBoxFuncionarioLograduro.getItemCount() != 0) {
            jComboBoxFuncionarioLograduro.setSelectedIndex(0);
        }

    }

    protected void preencherAbaFuncionarios(Pessoa pessoa) {


        jTextFieldFuncionarioNome.setText(pessoa.getNome());
        jTextFieldFuncionarioID.setText(String.valueOf(pessoa.getId()));
        jTextFieldFuncionarioSobrenome.setText(pessoa.getSobrenome());
        jTextFieldFuncionarioApelido.setText(pessoa.getApelido());
        jTextFieldFuncionarioTelefone.setText(pessoa.getTelefone());
        jTextFieldFuncionarioEmail.setText(pessoa.getEmail());
        if (pessoa.getDataNasc() != null) {
            jFormattedTextFieldFuncionarioDataNascimento.setText(SimpleDateFormat.getDateInstance().format(pessoa.getDataNasc()));
        }
        jComboBoxFuncionarioSexo.setSelectedItem(pessoa.getSexo());
        jTextFieldFuncionarioNomedame.setText(pessoa.getNomeMae());
        jTextFieldFuncionarioNomedopai.setText(pessoa.getNomePai());
        jFormattedTextFieldFuncionarioCpf.setText(pessoa.getCpf());
        jTextFieldFuncionarioRgnumero.setText(pessoa.getRgNumero());
        jTextFieldFuncionarioOrgaoExpedidor.setText(pessoa.getRgExpedidor());
        if (pessoa.getRgEmissao() != null) {
            jFormattedTextFieldFuncionarioDataEmissao.setText(SimpleDateFormat.getDateInstance().format(pessoa.getRgEmissao()));
        }
        if (jComboBoxFuncionarioLograduro.getItemCount() == 0) {
            jComboBoxFuncionarioLograduro.addItem("");
            List<Endereco> enderecos = new DaoEndereco().BuscarTodosEnderecos();
            for (Endereco endereco : enderecos) {

                jComboBoxFuncionarioLograduro.addItem(endereco.getTipo()+" "+endereco.getNome());

            }
        }
        jComboBoxFuncionarioLograduro.setSelectedItem(pessoa.getIdEndereco().getTipo()+" "+pessoa.getIdEndereco().getNome());
        jTextFieldFuncionarioNumero.setText(pessoa.getNumeroEndereco());
        jTextFieldFuncionarioCidade.setText(pessoa.getCidade());
        jTextFieldFuncionarioBairro.setText(pessoa.getBairro());
        jComboBoxFuncionarioUf.setSelectedItem(pessoa.getUf());
        jTextFieldFuncionarioCep.setText(pessoa.getCep());

        Funcionario f = pessoa.getFuncionario();


        jTextFieldFuncionarioCargo.setText(f.getCargo());
        // jTextFieldFuncionarioSalario.setText(NumberFormat.getCurrencyInstance().format(func.getSalario()));
        jTextFieldFuncionarioSalario.setText(String.valueOf(f.getSalario()));
        if (f.getDataContratacao() != null) {

            jFormattedTextFieldFuncionarioDataContratacao.setText(SimpleDateFormat.getDateInstance().format(f.getDataContratacao()));
        } else {
            jFormattedTextFieldFuncionarioDataContratacao.setText("nulo");
        }
        jTextAreaFuncionarioObservacoes.setText(f.getObservacao());
        jTextFieldFuncionarioNumeroDaMatricula.setText(String.valueOf(f.getMatricula()));

        if (pessoa.isStatus()) {
            jComboBoxFuncionarioStatus.setSelectedItem("Ativo");
        } else {
            jComboBoxFuncionarioStatus.setSelectedItem("Desativo");
        }

        // jTextFieldFuncionarioNumeroDaMatricula.setText(String.valueOf(pessoa.getNumeroMatricula()));


    }

    private boolean isCamposFuncionariosPreenchidos() {

        Pattern p = Pattern.compile("\\d{2}\\/\\d{2}\\/\\d{4}");
        Matcher m = p.matcher(jFormattedTextFieldFuncionarioDataContratacao.getText());

        if (!jTextFieldFuncionarioNome.getText().equals("") && !jTextFieldFuncionarioSobrenome.getText().equals("") && !jTextFieldFuncionarioCargo.getText().equals("") && !jTextFieldFuncionarioSalario.getText().equals("") && m.find() && !jComboBoxFuncionarioStatus.getSelectedItem().equals("") && !jTextFieldFuncionarioNumeroDaMatricula.getText().equals("") && !jComboBoxFuncionarioLograduro.getSelectedItem().equals("") && !jComboBoxFuncionarioSexo.getSelectedItem().equals("") && !jComboBoxFuncionarioUf.getSelectedItem().equals("")) {


            p = Pattern.compile("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}");
            m = p.matcher(jFormattedTextFieldFuncionarioCpf.getText());
            if (m.find()) {

                p = Pattern.compile("\\d+\\.?\\d+");
                m = p.matcher(jTextFieldFuncionarioSalario.getText());
                if (m.find()) {
                    return true;
                } else {
                    JOptionPane.showMessageDialog(this, "Números monetários devem ser separados por ponto", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                    return false;
                }
            } else {
                JOptionPane.showMessageDialog(this, "Por Favor, preencha todos os campos em negrito", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                return false;
            }


        } else {

            JOptionPane.showMessageDialog(this, "Por Favor, preencha todos os campos em negrito", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }


    }

    private boolean isCamposSocioPreenchidos() {

        Pattern p = Pattern.compile("\\d{2}\\/\\d{2}\\/\\d{4}");
        Matcher m;

        if (!jTextFieldSocioNome.getText().equals("") && !jTextFieldSocioSobrenome.getText().equals("") && !jComboBoxSocioSexo.getSelectedItem().equals("") && !jComboBoxSocioLogradouro.getSelectedItem().equals("") && !jComboBoxSocioUF.getSelectedItem().equals("") && !jTextFieldSocioNumeroSocio.getText().equals("") && !jComboBoxSocioCategoriaSocio.getSelectedItem().equals("") && !jTextFieldSocioNumero.getText().equals("") && (jRadioButtonSocioAtivo.isSelected() || jRadioButtonSocioInativo.isSelected())) {



            m = p.matcher(jFormattedTextFieldSocioDiaVencimento.getText());
            if (m.find()) {
                m = p.matcher(jFormattedTextFieldSocioDataMatricula.getText());
                if (m.find()) {
                    p = Pattern.compile("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}");
                    m = p.matcher(jFormattedTextFieldSocioCPF.getText());
                    if (m.find()) {

                        return true;
                    } else {
                        JOptionPane.showMessageDialog(this, "Por Favor, preencha todos os campos em negrito", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                        return false;
                    }
                } else {

                    JOptionPane.showMessageDialog(this, "Por Favor, preencha todos os campos em negrito", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                    return false;
                }

            } else {

                JOptionPane.showMessageDialog(this, "Por Favor, preencha todos os campos em negrito", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                return false;
            }





        } else {

            JOptionPane.showMessageDialog(this, "Por Favor, preencha todos os campos em negrito", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }



    }

    private boolean isCamposCategoriaSocioPreenchidos() {

        if (!jTextFieldCategoriaSocioNome.getText().equals("") && !jComboBoxCategoriaSocioTaxa.getSelectedItem().equals("")) {

            return true;

        } else {

            JOptionPane.showMessageDialog(this, "Os campos em negrito são obrigatórios", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }



    }

    private boolean isCamposTipoDespesaPreenchidos() {

        if (!jTextFieldTipoDespesaNome.getText().equals("") && !jTextAreaTipoDespesaDescricao.getText().equals("")) {

            return true;

        } else {

            JOptionPane.showMessageDialog(this, "Os campos em negrito são obrigatórios", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }


    }

    private boolean isCamposDespesaPreenchidos() {

        Pattern p = Pattern.compile("\\d{2}\\/\\d{2}\\/\\d{4}");
        Matcher m;
        if (!jComboBoxDespesaFuncionario.getSelectedItem().equals("") && !jComboBoxDespesaMotivo.getSelectedItem().equals("") && !jTextFieldDespesaFavorecido.getText().equals("") && !jTextFieldDespesaValor.getText().equals("")) {

            m = p.matcher(jFormattedTextFieldDespesaData.getText());
            if (m.find()) {

                p = Pattern.compile("\\d+\\.\\d+");
                m = p.matcher(jTextFieldDespesaValor.getText());
                if (m.find()) {

                    return true;

                } else {
                    JOptionPane.showMessageDialog(this, "Campos monetários devem ser separados com ponto", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                    return false;
                }

            } else {

                JOptionPane.showMessageDialog(this, "Os campos em negrito são obrigatórios", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                return false;
            }


        } else {

            JOptionPane.showMessageDialog(this, "Os campos em negrito são obrigatórios", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            return false;

        }


    }

    private boolean isCamposTipoReceitaPreenchidos() {


        if (!jTextFieldTipoReceitaNome.getText().equals("") && !jTextAreaTipoReceitaDescricao.getText().equals("")) {

            return true;

        } else {

            JOptionPane.showMessageDialog(this, "Os campos em negrito são obrigatórios", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }


    }

    private boolean isCamposReceitaPreenchidos(){
        
        Pattern p = Pattern.compile("\\d{2}\\/\\d{2}\\/\\d{4}");
        Matcher m;
        
        
        
        if( 
            (
            jCheckBoxReceitaAvulsa.isSelected()                    ||
            !jComboBoxReceitaSocio.getSelectedItem().equals("")
            )&& 
            !jComboBoxReceitaMotivoEntrada.getSelectedItem().equals("") &&
            !jComboBoxReceitaFuncionario.getSelectedItem().equals("")    
             ){
           
            //alexandre was here
            if(null != jDateChooser1.getDate()){
            
            p = Pattern.compile("\\d+\\.\\d+");
            m = p.matcher(jTextFieldReceitaValor.getText());
            
            if(m.find()){
                return true;
            }else{
              JOptionPane.showMessageDialog(this, "Campos monetários devem ser separados com ponto", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                    return false; 
            }
                
            }else{
               JOptionPane.showMessageDialog(this, "Os campos em negrito são obrigatórios", "Atenção", JOptionPane.INFORMATION_MESSAGE);
               return false;      
            }
            
        }else{
            
          JOptionPane.showMessageDialog(this, "Os campos em negrito são obrigatórios", "Atenção", JOptionPane.INFORMATION_MESSAGE);
          return false;  
            
        }
        
        
        
        
    }
   
    private boolean isCamposChequePreenchidos(){
        
        Pattern p = Pattern.compile("\\d{2}\\/\\d{2}\\/\\d{4}");
        Matcher m;
        
        if(!jTextFieldChequeNumero.getText().equals("") && !jComboBoxChequeFuncionario.getSelectedItem().equals("") && !jComboBoxChequeMotivoDespesa.getSelectedItem().equals("") ){
            
            
                m = p.matcher(jFormattedTextFieldChequeDataVencimento.getText());
                if(m.find()){
                    p = Pattern.compile("\\d+\\.\\d+");
                    m = p.matcher(jTextFieldChequeValor.getText());
                    if(m.find()){
                        return true;
                        
                    }else{
                    
                       JOptionPane.showMessageDialog(this, "Campos monetários devem ser separados com ponto", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                       return false;    
                }
                    
                    
                }else{
                    
                    JOptionPane.showMessageDialog(this, "Os campos em negrito são obrigatórios", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                    return false; 
                }
                
                
            
                
            
            
        }else{
            
            
          JOptionPane.showMessageDialog(this, "Os campos em negrito são obrigatórios", "Atenção", JOptionPane.INFORMATION_MESSAGE);
          return false;   
        }
        
        
        
    }
    
    private void setEditableComponentesLogradouros(boolean edite) {

        jTextFieldLogradouroNome.setEnabled(edite);
        jTextAreaLogradouroDescricao.setEnabled(edite);
        jComboBoxLogradouroTipo.setEnabled(edite);
        jButtonLogradouroApagar.setEnabled(edite);
        jButtonLogradouroCancelar.setEnabled(edite);
        jButtonLogradouroEditar.setEnabled(edite);
        jButtonLogradouroSalvar.setEnabled(edite);


    }

    private void setEditableComponentesTaxas(boolean edite) {

        jTextFieldTaxasNome.setEditable(edite);
        jTextFieldTaxasValor.setEditable(edite);
        jTextAreaTaxasDescricao.setEditable(edite);
        jButtonTaxaApagar.setEnabled(edite);
        jButtonTaxaCancelar.setEnabled(edite);
        jButtonTaxaEditar.setEnabled(edite);
        jButtonTaxaSalvar.setEnabled(edite);



    }

    private void setEditableComponentesSocio(boolean edit) {


        if(pesquisarTable.equals("importar funcionário")){
          
        jTextFieldSocioNome.setEditable(edit);
        jTextFieldSocioSobrenome.setEditable(edit);
        jTextFieldSocioApelido.setEditable(edit);
        jTextFieldSocioTelefone.setEditable(edit);
        jTextFieldSocioEmail.setEditable(edit);
        jFormattedTextFieldSocioDataNascimento.setEditable(edit);
        jComboBoxSocioSexo.setEnabled(edit);
        jComboBoxSocioLogradouro.setEnabled(edit);
        jTextFieldSocioNomeMae.setEditable(edit);
        jTextFieldSocioNomePai.setEditable(edit);
        jFormattedTextFieldSocioCPF.setEditable(false);
        jTextFieldSocioRgNumero.setEditable(edit);
        jTextFieldSocioOrgaoExpedidor.setEditable(edit);
        jFormattedTextFieldSocioDataEmissao.setEditable(edit);
        jTextFieldSocioNumero.setEditable(edit);
        jTextFieldSocioBairro.setEditable(edit);
        jTextFieldSocioCep2.setEditable(edit);
        jComboBoxSocioUF.setEnabled(edit);
        jTextFieldSocioCEP.setEditable(edit);
        buttonGroupSocioAprovacao.clearSelection();
        jRadioButtonSocioAtivo.setEnabled(edit);
        jRadioButtonSocioInativo.setEnabled(edit);
        jFormattedTextFieldSocioDiaVencimento.setEditable(edit);
        jFormattedTextFieldSocioDataMatricula.setEditable(edit);
        jTextFieldSocioNumeroSocio.setEditable(edit);
        jComboBoxSocioCategoriaSocio.setEnabled(edit);
        jButtonSocioApagar.setEnabled(false);
        jButtonSocioCancelar.setEnabled(edit);
        jButtonSocioEditar.setEnabled(false);
        jButtonSocioSalvar.setEnabled(edit);
       jButtonSocioAdicionarLogradouro.setEnabled(edit);
        }
        
        else{
        jTextFieldSocioNome.setEditable(edit);
        jTextFieldSocioSobrenome.setEditable(edit);
        jTextFieldSocioApelido.setEditable(edit);
        jTextFieldSocioTelefone.setEditable(edit);
        jTextFieldSocioEmail.setEditable(edit);
        jFormattedTextFieldSocioDataNascimento.setEditable(edit);
        jComboBoxSocioSexo.setEnabled(edit);
        jComboBoxSocioLogradouro.setEnabled(edit);
        jTextFieldSocioNomeMae.setEditable(edit);
        jTextFieldSocioNomePai.setEditable(edit);
        jFormattedTextFieldSocioCPF.setEditable(edit);
        jTextFieldSocioRgNumero.setEditable(edit);
        jTextFieldSocioOrgaoExpedidor.setEditable(edit);
        jFormattedTextFieldSocioDataEmissao.setEditable(edit);
        jTextFieldSocioNumero.setEditable(edit);
        jTextFieldSocioBairro.setEditable(edit);
        jTextFieldSocioCep2.setEditable(edit);
        jComboBoxSocioUF.setEnabled(edit);
        jTextFieldSocioCEP.setEditable(edit);
        buttonGroupSocioAprovacao.clearSelection();
        jRadioButtonSocioAtivo.setEnabled(edit);
        jRadioButtonSocioInativo.setEnabled(edit);
        jFormattedTextFieldSocioDiaVencimento.setEditable(edit);
        jFormattedTextFieldSocioDataMatricula.setEditable(edit);
        jTextFieldSocioNumeroSocio.setEditable(edit);
        jComboBoxSocioCategoriaSocio.setEnabled(edit);
        jButtonSocioApagar.setEnabled(edit);
        jButtonSocioCancelar.setEnabled(edit);
        jButtonSocioEditar.setEnabled(edit);
        jButtonSocioSalvar.setEnabled(edit);
        jButtonSocioAdicionarLogradouro.setEnabled(edit);
        jCheckBoxExclusivamenteSocio.setEnabled(edit);
        }

    }

    private void setEditableComponentesCategoriaSocio(boolean edit) {

        jTextFieldCategoriaSocioNome.setEditable(edit);
        jTextAreaCategoriaSocioDescricao.setEditable(edit);
        jComboBoxCategoriaSocioTaxa.setEnabled(edit);
        jButtonCategoriaSocioApagar.setEnabled(edit);
        jButtonCategoriaSocioCancelar.setEnabled(edit);
        jButtonCategoriaSocioEditar.setEnabled(edit);
        jButtonCategoriaSocioSalvar.setEnabled(edit);



    }

    private void setEditableComponentesTipoDespesa(boolean edit) {


        jTextFieldTipoDespesaNome.setEditable(edit);
        jTextAreaTipoDespesaDescricao.setEditable(edit);
        jTextAreaTipoDespesaObservacao.setEditable(edit);
        jButtonTipoDespesaApagar.setEnabled(edit);
        jButtonTipoDespesaCancelar.setEnabled(edit);
        jButtonTipoDespesaEditar.setEnabled(edit);
        jButtonTipoDespesaSalvar.setEnabled(edit);

    }

    private void setEditableComponentesDespesa(boolean edit) {

        jComboBoxDespesaFuncionario.setEnabled(edit);
        jFormattedTextFieldDespesaData.setEditable(edit);
        jTextFieldDespesaValor.setEditable(edit);
        jComboBoxDespesaMotivo.setEnabled(edit);
        jTextFieldDespesaFavorecido.setEditable(edit);
        jTextAreaDespesaObservacao.setEditable(edit);
        jButtonDespesaApagar.setEnabled(edit);
        jButtonDespesaCancelar.setEnabled(edit);
        jButtonDespesaEditar.setEnabled(edit);
        jButtonDespesaSalvar.setEnabled(edit);


    }

    private void setEditableComponentesTipoReceita(boolean edit) {


        jTextFieldTipoReceitaNome.setEditable(edit);
        jTextAreaTipoReceitaDescricao.setEditable(edit);
        jTextAreaTipoReceitaObservacao.setEditable(edit);
        jButtonTipoReceitaApagar.setEnabled(edit);
        jButtonTipoReceitaCancelar.setEnabled(edit);
        jButtonTipoReceitaEditar.setEnabled(edit);
        jButtonTipoReceitaSalvar.setEnabled(edit);

    }

    private void setEditableComponentesReceita(boolean edit){
        
        jComboBoxReceitaFuncionario.setEnabled(edit);
        jComboBoxReceitaMotivoEntrada.setEnabled(edit);
        jComboBoxReceitaSocio.setEnabled(edit);
        jTextFieldReceitaValor.setEditable(edit);
        jTextAreaReceitaObservacao.setEditable(edit);
        jDateChooser1.setEnabled(edit);
        jButtonReceitaApagar.setEnabled(edit);
        jButtonReceitaCancelar.setEnabled(edit);
        jButtonReceitaEditar.setEnabled(edit);
        jButtonReceitaSalvar.setEnabled(edit);
        jCheckBoxReceitaAvulsa.setEnabled(edit);
        
        
    }
    
    private void setEditableComponentesCheques(boolean edit){
        
        jTextFieldChequeNumero.setEditable(edit);
        jTextFieldChequeValor.setEditable(edit);
        jComboBoxChequeFuncionario.setEnabled(edit);
        jComboBoxChequeMotivoDespesa.setEnabled(edit);
        jFormattedTextFieldChequeDataPagamento.setEditable(edit);
        jFormattedTextFieldChequeDataVencimento.setEditable(edit);
        jButtonChequeApagar.setEnabled(edit);
        jButtonChequeCancelar.setEnabled(edit);
        jButtonChequeEditar.setEnabled(edit);
        jButtonChequeSalvar.setEnabled(edit);
        
        
    }
    
    private void limparCamposTaxas() {


        jTextFieldTaxasID.setText("");
        jTextFieldTaxasNome.setText("");
        jTextFieldTaxasValor.setText("");
        jTextAreaTaxasDescricao.setText("");
    }

    private void limparCamposLogradouro() {

        jTextFieldLogradouroNome.setText("");
        jTextAreaLogradouroDescricao.setText("");
        if(jComboBoxLogradouroTipo.getItemCount() != 0){
        jComboBoxLogradouroTipo.setSelectedIndex(0);
        }
        jTextFieldLogradouroID.setText("");

    }

    private void limparCamposSocio() {
        jCheckBoxExclusivamenteSocio.setSelected(false);
        jTextFieldSocioID.setText("");
        jTextFieldSocioNome.setText("");
        jTextFieldSocioSobrenome.setText("");
        jTextFieldSocioApelido.setText("");
        jTextFieldSocioTelefone.setText("");
        jTextFieldSocioEmail.setText("");
        jFormattedTextFieldSocioDataNascimento.setText("");
        jComboBoxSocioSexo.setSelectedItem("");
        jTextFieldSocioNomePai.setText("");
        jTextFieldSocioNomeMae.setText("");
        jFormattedTextFieldSocioCPF.setText("");
        jTextFieldSocioRgNumero.setText("");
        jTextFieldSocioOrgaoExpedidor.setText("");
        jFormattedTextFieldSocioDataEmissao.setText("");
        jTextFieldSocioNumero.setText("");
        jTextFieldSocioBairro.setText("");
        jTextFieldSocioCep2.setText("");
        jComboBoxSocioUF.setSelectedItem("");
        jTextFieldSocioCEP.setText("");
        if (jComboBoxSocioLogradouro.getItemCount() != 0) {

            jComboBoxSocioLogradouro.setSelectedIndex(0);
        }
        buttonGroupSocioAprovacao.clearSelection();
        jFormattedTextFieldSocioDataMatricula.setText("");
        jFormattedTextFieldSocioDiaVencimento.setText("");
        jTextFieldSocioNumeroSocio.setText("");
        if (jComboBoxSocioCategoriaSocio.getItemCount() != 0) {

            jComboBoxSocioCategoriaSocio.setSelectedIndex(0);

        }

        jCheckBoxExclusivamenteSocio.setEnabled(true);
    }
    

    private void limparCamposCategoriaSocio() {

        jTextFieldCategoriaSocioNome.setText("");
        jTextFieldCategoriaSocioID.setText("");
        jTextAreaCategoriaSocioDescricao.setText("");
        if (jComboBoxCategoriaSocioTaxa.getItemCount() != 0) {

            jComboBoxCategoriaSocioTaxa.setSelectedIndex(0);
        }


    }

    private void limparCamposTipoDespesa() {


        jTextFieldTIpoDespesaID.setText("");
        jTextFieldTipoDespesaNome.setText("");
        jTextAreaTipoDespesaDescricao.setText("");
        jTextAreaTipoDespesaObservacao.setText("");

    }

    private void limparCamposDespesa() {


        if (jComboBoxDespesaFuncionario.getItemCount() != 0) {
            jComboBoxDespesaFuncionario.setSelectedIndex(0);

        }

        jTextFieldDespesaID.setText("");
        jFormattedTextFieldDespesaData.setText("");
        jTextFieldDespesaValor.setText("");
        if (jComboBoxDespesaMotivo.getItemCount() != 0) {

            jComboBoxDespesaMotivo.setSelectedIndex(0);
        }
        jTextFieldDespesaFavorecido.setText("");
        jTextAreaDespesaObservacao.setText("");

    }

    private void limparCamposTipoReceita() {

        jTextFieldTIpoReceitaID.setText("");
        jTextFieldTipoReceitaNome.setText("");
        jTextAreaTipoReceitaDescricao.setText("");
        jTextAreaTipoReceitaObservacao.setText("");

    }

    private void limparCamposReceita(){
        
        
        jTextFieldReceitaID.setText("");
        jTextFieldReceitaValor.setText("");
        jDateChooser1.setDate(null);
        
        if(jComboBoxReceitaFuncionario.getItemCount() != 0){
            
            jComboBoxReceitaFuncionario.setSelectedIndex(0);
        }
         if(jComboBoxReceitaMotivoEntrada.getItemCount() != 0){
            
            jComboBoxReceitaMotivoEntrada.setSelectedIndex(0);
        }
          if(jComboBoxReceitaSocio.getItemCount() != 0){
            
            jComboBoxReceitaSocio.setSelectedIndex(0);
        }
          jTextAreaReceitaObservacao.setText("");
        
        
    }
    
    private void limparCamposCheques(){
        
        jTextFieldChequeID.setText("");
        jTextFieldChequeNumero.setText("");
        jTextFieldChequeValor.setText("");
        jTextAreaChequeObservacoes.setText("");
        jFormattedTextFieldChequeDataPagamento.setText("");
        jFormattedTextFieldChequeDataVencimento.setText("");
        
        if(jComboBoxChequeFuncionario.getItemCount() != 0){
            
            jComboBoxChequeFuncionario.setSelectedIndex(0);
        }
        
        if(jComboBoxChequeMotivoDespesa.getItemCount() != 0){
            
            jComboBoxChequeMotivoDespesa.setSelectedIndex(0);
        }
        
        
    }
    
    private void preencherCamposLogradouro(Endereco end) {

        jTextFieldLogradouroID.setText(String.valueOf(end.getId()));
        jTextFieldLogradouroNome.setText(end.getNome());
        jTextAreaLogradouroDescricao.setText(end.getDescricao());
        
        
        jComboBoxLogradouroTipo.setSelectedItem(end.getTipo());




    }

    private void preencherCamposTaxas(Taxa taxa) {

        jTextFieldTaxasID.setText(String.valueOf(taxa.getId()));
        jTextFieldTaxasNome.setText(taxa.getNome());
        jTextFieldTaxasValor.setText(String.valueOf(taxa.getValor()));
        jTextAreaTaxasDescricao.setText(taxa.getDescricao());

    }

    private void preencherCamposSocio(Socio socio) {

        jTextFieldSocioNome.setText(socio.getIdPessoa().getNome());
        jTextFieldSocioSobrenome.setText(socio.getIdPessoa().getSobrenome());
        jTextFieldSocioApelido.setText(socio.getIdPessoa().getApelido());
        jTextFieldSocioID.setText(String.valueOf(socio.getId()));
        jTextFieldSocioTelefone.setText(socio.getIdPessoa().getTelefone());
        jTextFieldSocioEmail.setText(socio.getIdPessoa().getEmail());
        jTextFieldSocioNomePai.setText(socio.getIdPessoa().getNomePai());
        jTextFieldSocioNomeMae.setText(socio.getIdPessoa().getNomeMae());
        jTextFieldSocioRgNumero.setText(socio.getIdPessoa().getRgNumero());
        jTextFieldSocioOrgaoExpedidor.setText(socio.getIdPessoa().getRgExpedidor());
        jTextFieldSocioNumero.setText(socio.getIdPessoa().getEnderecopessoaList().get(0).getNumero());
        jTextFieldSocioCep2.setText(socio.getIdPessoa().getCidade());
        jTextFieldSocioBairro.setText(socio.getIdPessoa().getBairro());
        jTextFieldSocioCEP.setText(socio.getIdPessoa().getCep());            
        jTextFieldSocioNumeroSocio.setText(String.valueOf(socio.getNumeroSocio()));
 

        jComboBoxSocioSexo.setSelectedItem(socio.getIdPessoa().getSexo());
        jComboBoxSocioUF.setSelectedItem(socio.getIdPessoa().getUf());
        if (jComboBoxSocioLogradouro.getItemCount() == 0) {

            jComboBoxSocioLogradouro.addItem("");
            List<Endereco> ends = new DaoEndereco().BuscarTodosEnderecos();
            for (Endereco e : ends) {

                jComboBoxSocioLogradouro.addItem(e.getTipo()+" "+e.getNome());

            }

        }
        jComboBoxSocioLogradouro.setSelectedItem(socio.getIdPessoa().getIdEndereco().getTipo()+" "+socio.getIdPessoa().getIdEndereco().getNome());
        if (jComboBoxSocioCategoriaSocio.getItemCount() == 0) {

            jComboBoxSocioCategoriaSocio.addItem("");
            List<Categoriasocio> categorias = new DaoCategoriaSocio().BuscarTodasCategorias();
            for (Categoriasocio categoria : categorias) {

                jComboBoxSocioCategoriaSocio.addItem(categoria.getNome());

            }

        }
        jComboBoxSocioCategoriaSocio.setSelectedItem(socio.getIdCategoriaSocio().getNome());


        if (socio.getIdPessoa().getDataNasc() != null) {
            jFormattedTextFieldSocioDataNascimento.setText(SimpleDateFormat.getDateInstance().format(socio.getIdPessoa().getDataNasc()));
        }
        jFormattedTextFieldSocioCPF.setText(socio.getIdPessoa().getCpf());
        if (socio.getIdPessoa().getRgEmissao() != null) {

            jFormattedTextFieldSocioDataEmissao.setText(SimpleDateFormat.getDateInstance().format(socio.getIdPessoa().getRgEmissao()));
        }
        jFormattedTextFieldSocioDiaVencimento.setText(SimpleDateFormat.getDateInstance().format(socio.getDataVence()));
        jFormattedTextFieldSocioDataMatricula.setText(SimpleDateFormat.getDateInstance().format(socio.getDataMatricula()));


        if (socio.getIdPessoa().isStatus()) {

            jRadioButtonSocioAtivo.setSelected(true);
        } else {

            jRadioButtonSocioInativo.setSelected(false);

        }
        jCheckBoxExclusivamenteSocio.setSelected(socio.getSocioExclusivo());
    }

    private void preencherCamposCategoriaSocio(Categoriasocio c) {

        jTextFieldCategoriaSocioID.setText(String.valueOf(c.getId()));
        jTextFieldCategoriaSocioNome.setText(c.getNome());
        jTextAreaCategoriaSocioDescricao.setText(c.getDescricao());

        if (jComboBoxCategoriaSocioTaxa.getItemCount() == 0) {

            jComboBoxCategoriaSocioTaxa.addItem("");
            List<Taxa> taxas = new DaoTaxa().TaxasTodas();
            for (Taxa t : taxas) {

                jComboBoxCategoriaSocioTaxa.addItem(t.getNome());
            }

        }
        jComboBoxCategoriaSocioTaxa.setSelectedItem(c.getTaxasId().getNome());



    }

    private void preencherCamposSocioImportados(Pessoa pessoa){
        
        Socio s = pessoa.getSocio();
        if(s != null){
            
            try{
                throw new Exception();
            }catch(Exception e){
                
                JOptionPane.showMessageDialog(this,"Esse funcionario ja foi importado","Erro",JOptionPane.ERROR_MESSAGE);
            
            }
            
        }
        else{
        jTextFieldSocioNome.setText(pessoa.getNome());
        
        jTextFieldSocioSobrenome.setText(pessoa.getSobrenome());
        jTextFieldSocioApelido.setText(pessoa.getApelido());
        jTextFieldSocioTelefone.setText(pessoa.getTelefone());
        jTextFieldSocioEmail.setText(pessoa.getEmail());
        if (pessoa.getDataNasc() != null) {
            jFormattedTextFieldSocioDataNascimento.setText(SimpleDateFormat.getDateInstance().format(pessoa.getDataNasc()));
        }
        jComboBoxSocioSexo.setSelectedItem(pessoa.getSexo());
        jTextFieldSocioNomeMae.setText(pessoa.getNomeMae());
        jTextFieldSocioNomePai.setText(pessoa.getNomePai());
        jFormattedTextFieldSocioCPF.setText(pessoa.getCpf());
        
        jTextFieldSocioRgNumero.setText(pessoa.getRgNumero());
        jTextFieldSocioOrgaoExpedidor.setText(pessoa.getRgExpedidor());
        if (pessoa.getRgEmissao() != null) {
            jFormattedTextFieldSocioDataEmissao.setText(SimpleDateFormat.getDateInstance().format(pessoa.getRgEmissao()));
        }
        if (jComboBoxSocioLogradouro.getItemCount() == 0) {
            jComboBoxSocioLogradouro.addItem("");
            List<Endereco> enderecos = new DaoEndereco().BuscarTodosEnderecos();
            for (Endereco endereco : enderecos) {

                jComboBoxSocioLogradouro.addItem(endereco.getTipo()+" "+endereco.getNome());

            }
        }
        jComboBoxSocioLogradouro.setSelectedItem(pessoa.getIdEndereco().getTipo()+" "+pessoa.getIdEndereco().getNome());
        jTextFieldSocioNumero.setText(pessoa.getNumeroEndereco());
        jTextFieldSocioCep2.setText(pessoa.getCidade());
        jTextFieldSocioBairro.setText(pessoa.getBairro());
        jComboBoxSocioUF.setSelectedItem(pessoa.getUf());
        jTextFieldSocioCEP.setText(pessoa.getCep());

      

        if (pessoa.isStatus()) {
            jRadioButtonSocioAtivo.setSelected(true);
        } else {
            jRadioButtonSocioInativo.setSelected(false);
        }
        setEditableComponentesSocio(true);
    }
    }
    
    private void preencherCamposTipoDespesa(Motivodespesa m) {


        jTextFieldTIpoDespesaID.setText(String.valueOf(m.getId()));
        jTextFieldTipoDespesaNome.setText(m.getNome());
        jTextAreaTipoDespesaDescricao.setText(m.getDescricao());
        jTextAreaTipoDespesaObservacao.setText(m.getObservacao());

    }

    private void preencherCamposDespesa(Saida s) {

        jTextFieldDespesaID.setText(String.valueOf(s.getId()));

        if (jComboBoxDespesaFuncionario.getItemCount() == 0) {

            jComboBoxDespesaFuncionario.addItem("");
            List<Funcionario> funcionarios = new DaoFuncionario().BuscarFuncionarios();
            for (Funcionario f : funcionarios) {

                jComboBoxDespesaFuncionario.addItem(f.getIdPessoa().getNome() + " " + f.getIdPessoa().getSobrenome());

            }

        }
        jComboBoxDespesaFuncionario.setSelectedItem(s.getIdfuncionario().getIdPessoa().getNome() + " " + s.getIdfuncionario().getIdPessoa().getSobrenome());

        jFormattedTextFieldDespesaData.setText(SimpleDateFormat.getDateInstance().format(s.getData()));
        jTextFieldDespesaValor.setText(String.valueOf(s.getValor()));

        if (jComboBoxDespesaMotivo.getItemCount() == 0) {
            jComboBoxDespesaMotivo.addItem("");
            List<Motivodespesa> motivos = new DaoMotivoDespesa().BuscarTodosMotivos();

            for (Motivodespesa m : motivos) {

                jComboBoxDespesaMotivo.addItem(m.getNome());
            }


        }
        jComboBoxDespesaMotivo.setSelectedItem(s.getIdmotivosaida().getNome());

        jTextFieldDespesaFavorecido.setText(s.getFavorecido());
        jTextAreaDespesaObservacao.setText(s.getObservacao());




    }

    private void preencherCamposTipoReceita(Motivoentrada m) {

        jTextFieldTIpoReceitaID.setText(String.valueOf(m.getId()));
        jTextFieldTipoReceitaNome.setText(m.getNome());
        jTextAreaTipoReceitaDescricao.setText(m.getDescricao());
        jTextAreaTipoReceitaObservacao.setText(m.getObservacao());


    }

    private void preencherCamposReceita(Entrada e){
        
        
        jTextFieldReceitaID.setText(String.valueOf(e.getId()));
        jTextAreaReceitaObservacao.setText(e.getObservacao());
        jTextFieldReceitaValor.setText(String.valueOf(e.getValor()));
        jDateChooser1.setDate(e.getData());
        
       
        if(jComboBoxReceitaFuncionario.getItemCount() == 0){
            
            jComboBoxReceitaFuncionario.addItem("");
            List<Funcionario> funcionarios = new DaoFuncionario().BuscarFuncionarios();
            for(Funcionario f : funcionarios){
                
                jComboBoxReceitaFuncionario.addItem(f.getIdPessoa().getNome()+" "+f.getIdPessoa().getSobrenome());
            }
      
        }
        jComboBoxReceitaFuncionario.setSelectedItem(e.getIdFuncionario().getIdPessoa().getNome()+" "+e.getIdFuncionario().getIdPessoa().getSobrenome());
        
        if(jComboBoxReceitaMotivoEntrada.getItemCount() == 0){
            
            jComboBoxReceitaMotivoEntrada.addItem("");
            
            List<Motivoentrada> motivos = new DaoMotivoEntrada().BuscarTodosMotivos();
            for(Motivoentrada m : motivos){
                
                jComboBoxReceitaMotivoEntrada.addItem(m.getNome());
                
            }
 
            
        }
        jComboBoxReceitaMotivoEntrada.setSelectedItem(e.getIdMotivoEntrada().getNome());
        
        if(jComboBoxReceitaSocio.getItemCount() == 0){
            
            jComboBoxReceitaSocio.addItem("");
            
            List<Socio> socios = new DaoSocio().TodosOsSocios();
            
            for(Socio s : socios){
                
                jComboBoxReceitaSocio.addItem(s.getIdPessoa().getNome()+" "+s.getIdPessoa().getSobrenome());
                
            }
            
        }
        jComboBoxReceitaSocio.setSelectedItem(e.getIdCedente().getIdPessoa().getNome()+" "+e.getIdCedente().getIdPessoa().getSobrenome());
        
        
        
        
        
    }

    private void preencherCamposCheque(Cheque c){
        

        jTextFieldChequeID.setText(String.valueOf(c.getId()));
        jTextFieldChequeNumero.setText(String.valueOf(c.getNumero()));
        jTextFieldChequeValor.setText(String.valueOf(c.getValor()));
        jTextAreaChequeObservacoes.setText(c.getObservacoes());
        
        jFormattedTextFieldChequeDataPagamento.setText(SimpleDateFormat.getDateInstance().format(c.getDataPagamento()));
        jFormattedTextFieldChequeDataVencimento.setText(SimpleDateFormat.getDateInstance().format(c.getDataVencimento()));
        
        if(jComboBoxChequeFuncionario.getItemCount() == 0){
            
            jComboBoxChequeFuncionario.addItem("");
            List<Funcionario> funcionarios = new DaoFuncionario().BuscarFuncionarios();
            
            if(!funcionarios.isEmpty()){
                
                for(Funcionario f : funcionarios){
                    
                    jComboBoxChequeFuncionario.addItem(f.getIdPessoa().getNome()+" "+f.getIdPessoa().getSobrenome());
                }
            }
            
            
        }
        jComboBoxChequeFuncionario.setSelectedItem(c.getIdFuncionario().getIdPessoa().getNome()+" "+c.getIdFuncionario().getIdPessoa().getSobrenome());
        
        if(jComboBoxChequeMotivoDespesa.getItemCount() == 0){
            
            jComboBoxChequeMotivoDespesa.addItem("");
            List<Motivodespesa> motivos = new DaoMotivoDespesa().BuscarTodosMotivos();
            
            if(!motivos.isEmpty()){
                
                for(Motivodespesa m : motivos){
                    
                    jComboBoxChequeMotivoDespesa.addItem(m.getNome());
                }
                
            }
            
            
        }
        jComboBoxChequeMotivoDespesa.setSelectedItem(c.getIdMotivoDespesa().getNome());   
    }
          
    
    private void zerarComboBox(){
        
        jComboBoxCategoriaSocioTaxa.removeAllItems();
        jComboBoxDespesaFuncionario.removeAllItems();
        jComboBoxDespesaMotivo.removeAllItems();
        jComboBoxFuncionarioLograduro.removeAllItems();
   
        jComboBoxReceitaFuncionario.removeAllItems();
        jComboBoxReceitaMotivoEntrada.removeAllItems();
        jComboBoxReceitaSocio.removeAllItems();
        jComboBoxSocioCategoriaSocio.removeAllItems();
        jComboBoxSocioLogradouro.removeAllItems();
            
    }
    
    private void mostrarJtable() {

        DefaultTableCellRenderer centralizar = new DefaultTableCellRenderer();
        centralizar.setHorizontalAlignment(SwingConstants.CENTER);
        switch (pesquisarTable) {
            case "funcionarios":
            case "importar funcionário":
                jTable1.setModel(new DefaultTableModel(
                        new Object[][]{},
                        new String[]{"Nome", "Sobrenome", "CPF", "Cidade", "Data Nascimento", "Email", "Status"}) {
                            Class[] types = new Class[]{String.class, String.class, String.class, String.class, String.class,
                                String.class, Boolean.class};
                            
                            @Override
                            public Class getColumnClass(int columnIndex) {
                                return types[columnIndex];
                            }
                            boolean[] canEdit = new boolean[]{false, false, false, false, false, false, false};
                            
                            @Override
                            public boolean isCellEditable(int rowIndex, int columnIndex) {
                                
                                return canEdit[columnIndex];
                            }
                        }); jTable1.getColumn("Nome").setCellRenderer(centralizar);
            jTable1.getColumn("Sobrenome").setCellRenderer(centralizar);
                jTable1.getColumn("CPF").setCellRenderer(centralizar);
                jTable1.getColumn("Cidade").setCellRenderer(centralizar);
                jTable1.getColumn("Data Nascimento").setCellRenderer(centralizar);
                jTable1.getColumn("Email").setCellRenderer(centralizar);
                break;
            case "logradouros":
                jTable1.setModel(new DefaultTableModel(
                        new Object[][]{}, new String[]{"ID", "Nome", "Tipo", "Descrição"}) {
                            Class[] types = new Class[]{Integer.class, String.class, String.class, String.class};
                            
                            @Override
                            public Class getColumnClass(int columnIndex) {
                                
                                return types[columnIndex];
                            }
                            boolean[] canEdit = new boolean[]{false, false, false, false};
                            
                            @Override
                            public boolean isCellEditable(int rowIndex, int columnIndex) {
                                
                                return canEdit[columnIndex];
                                
                            }
                        }); jTable1.getColumn("ID").setCellRenderer(centralizar);
            jTable1.getColumn("Nome").setCellRenderer(centralizar);
                jTable1.getColumn("Tipo").setCellRenderer(centralizar);
                jTable1.getColumn("Descrição").setCellRenderer(centralizar);
                break;
            case "taxas":
                jTable1.setModel(new DefaultTableModel(
                        new Object[][]{}, new String[]{"ID", "Nome", "Descrição", "Valor"}) {
                            Class[] types = new Class[]{Integer.class, String.class, String.class, BigDecimal.class};
                            
                            @Override
                            public Class getColumnClass(int columnIndex) {
                                
                                return types[columnIndex];
                            }
                            boolean[] canEdit = new boolean[]{false, false, false, false};
                            
                            @Override
                            public boolean isCellEditable(int rowIndex, int columnIndex) {
                                
                                return canEdit[columnIndex];
                                
                            }
                        }); jTable1.getColumn("ID").setCellRenderer(centralizar);
            jTable1.getColumn("Nome").setCellRenderer(centralizar);
                jTable1.getColumn("Descrição").setCellRenderer(centralizar);
                jTable1.getColumn("Valor").setCellRenderer(centralizar);
                break;
            case "socios":
                jTable1.setModel(new DefaultTableModel(
                        new Object[][]{}, new String[]{"ID", "Nome", "CPF", "Categoria Socio", "Logradouro", "Numero"}) {
                            Class[] types = new Class[]{Integer.class, String.class, String.class, String.class, String.class, String.class};
                            
                            @Override
                            public Class getColumnClass(int columnIndex) {
                                
                                return types[columnIndex];
                                
                            }
                            boolean[] canEdit = new boolean[]{false, false, false, false, false, false};
                            
                            @Override
                            public boolean isCellEditable(int rowIndex, int columnIndex) {
                                
                                
                                return canEdit[columnIndex];
                            }
                        }); jTable1.getColumn("ID").setCellRenderer(centralizar);
            jTable1.getColumn("Nome").setCellRenderer(centralizar);
                jTable1.getColumn("CPF").setCellRenderer(centralizar);
                jTable1.getColumn("Categoria Socio").setCellRenderer(centralizar);
                jTable1.getColumn("Logradouro").setCellRenderer(centralizar);
                jTable1.getColumn("Numero").setCellRenderer(centralizar);
                break;
            case "categoria socio":
                jTable1.setModel(new DefaultTableModel(
                        new Object[][]{}, new String[]{"ID", "Nome", "Descrição", "Taxa"}) {
                            Class[] type = new Class[]{Integer.class, String.class, String.class, String.class};
                            
                            @Override
                            public Class getColumnClass(int columnIndex) {
                                
                                return type[columnIndex];
                                
                            }
                            boolean[] canEdit = new boolean[]{false, false, false, false};
                            
                            @Override
                            public boolean isCellEditable(int rowIndex, int columnIndex) {
                                
                                return canEdit[columnIndex];
                            }
                        }); jTable1.getColumn("ID").setCellRenderer(centralizar);
            jTable1.getColumn("Nome").setCellRenderer(centralizar);
                jTable1.getColumn("Descrição").setCellRenderer(centralizar);
                jTable1.getColumn("Taxa").setCellRenderer(centralizar);
                break;
            case "tipo despesa":
                jTable1.setModel(new DefaultTableModel(
                        new Object[][]{}, new String[]{"ID", "Nome", "Descrição", "Observação"}) {
                            Class[] type = new Class[]{Integer.class, String.class, String.class, String.class};
                            
                            @Override
                            public Class getColumnClass(int columnIndex) {
                                
                                return type[columnIndex];
                                
                            }
                            boolean[] canEdit = new boolean[]{false, false, false, false};
                            
                            @Override
                            public boolean isCellEditable(int rowIndex, int columnIndex) {
                                
                                return canEdit[columnIndex];
                            }
                        }); jTable1.getColumn("ID").setCellRenderer(centralizar);
            jTable1.getColumn("Nome").setCellRenderer(centralizar);
                jTable1.getColumn("Descrição").setCellRenderer(centralizar);
                jTable1.getColumn("Observação").setCellRenderer(centralizar);
                break;
            case "despesa":
                jTable1.setModel(new DefaultTableModel(
                        new Object[][]{}, new String[]{"ID", "Data", "Valor", "Favorecido", "Funcionario", "Motivo de Saida", "Observação"}) {
                            Class[] type = new Class[]{Integer.class, String.class, BigDecimal.class, String.class, String.class, String.class, String.class};
                            
                            @Override
                            public Class getColumnClass(int columnIndex) {
                                
                                return type[columnIndex];
                            }
                            boolean canEdit[] = new boolean[]{false, false, false, false, false, false, false};
                            
                            @Override
                            public boolean isCellEditable(int rowIndex, int columnIndex) {
                                
                                return canEdit[columnIndex];
                                
                            }
                        }); jTable1.getColumn("ID").setCellRenderer(centralizar);
            jTable1.getColumn("Data").setCellRenderer(centralizar);
                jTable1.getColumn("Valor").setCellRenderer(centralizar);
                jTable1.getColumn("Favorecido").setCellRenderer(centralizar);
                jTable1.getColumn("Funcionario").setCellRenderer(centralizar);
                jTable1.getColumn("Motivo de Saida").setCellRenderer(centralizar);
                jTable1.getColumn("Observação").setCellRenderer(centralizar);
                break;
            case "tipo receita":
                jTable1.setModel(new DefaultTableModel(
                        new Object[][]{}, new String[]{"ID", "Nome", "Descrição", "Observação"}) {
                            Class[] type = new Class[]{Integer.class, String.class, String.class, String.class};
                            
                            @Override
                            public Class getColumnClass(int columnIndex) {
                                
                                return type[columnIndex];
                            }
                            boolean[] canEdit = new boolean[]{false, false, false, false};
                            
                            @Override
                            public boolean isCellEditable(int rowIndex, int columnIndex) {
                                
                                return canEdit[columnIndex];
                                
                            }
                        }); jTable1.getColumn("ID").setCellRenderer(centralizar);
            jTable1.getColumn("Nome").setCellRenderer(centralizar);
                jTable1.getColumn("Descrição").setCellRenderer(centralizar);
                jTable1.getColumn("Observação").setCellRenderer(centralizar);
                break;
            case "receita":
                jTable1.setModel(new DefaultTableModel(
                        new Object[][]{}, new String[]{"ID", "Data", "Valor", "Cedente","Funcionario","Motivo","Observações"}){
                            
                            Class[] type = new Class[]{String.class, String.class, BigDecimal.class, String.class, String.class, String.class, String.class};
                            
                            @Override
                            public Class getColumnClass(int columnIndex){
                                
                                
                                return type[columnIndex];
                                
                                
                            }
                            
                            boolean[] canEdit = new boolean[]{false, false, false, false, false, false, false};
                            
                            
                            @Override
                            public boolean isCellEditable(int rowIndex, int columnIndex){
                                
                                
                                return canEdit[columnIndex];
                                
                            }
                            
                        });
                jTable1.getColumn("ID").setCellRenderer(centralizar);
                jTable1.getColumn("Data").setCellRenderer(centralizar);
                jTable1.getColumn("Valor").setCellRenderer(centralizar);
                jTable1.getColumn("Cedente").setCellRenderer(centralizar);
                jTable1.getColumn("Funcionario").setCellRenderer(centralizar);
                jTable1.getColumn("Motivo").setCellRenderer(centralizar);
                jTable1.getColumn("Observações").setCellRenderer(centralizar);
                break;
            case "cheque":
                jTable1.setModel(new DefaultTableModel(
                        new Object[][]{}, new String[]{"ID","Numero","Valor","Funcionario","Motivo Despesa","Data Pagamento","Data Vencimento"}){
                            
                            Class[] type = new Class[]{String.class, String.class, BigDecimal.class, String.class, String.class, String.class, String.class};
                            
                            @Override
                            public Class getColumnClass(int columnIndex){
                                
                                return type[columnIndex];
                            }
                            
                            boolean[] canEdit = new boolean[]{false, false, false, false, false, false, false};
                            
                            @Override
                            public boolean isCellEditable(int rowIndex, int columnIndex){
                                
                                return canEdit[columnIndex];
                                
                            }
                        });
                jTable1.getColumn("ID").setCellRenderer(centralizar);
                jTable1.getColumn("Numero").setCellRenderer(centralizar);
                jTable1.getColumn("Valor").setCellRenderer(centralizar);
                jTable1.getColumn("Funcionario").setCellRenderer(centralizar);
                jTable1.getColumn("Motivo Despesa").setCellRenderer(centralizar);
                jTable1.getColumn("Data Pagamento").setCellRenderer(centralizar);
                jTable1.getColumn("Data Vencimento").setCellRenderer(centralizar);
                break;
        }
        


        jDesktopPane1.setVisible(true);
        jInternalFrame1.setVisible(true);
        try {
            jInternalFrame1.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(TelaCadastros.class.getName()).log(Level.SEVERE, null, ex);
        }
        jPanel1.setVisible(false);
    }

    /**
     * @param args the command line arguments
     */
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
            Logger.getLogger(TelaCadastros.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(TelaCadastros.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(TelaCadastros.class.getName()).log(Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            Logger.getLogger(TelaCadastros.class.getName()).log(Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TelaCadastros().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // Generated using JFormDesigner non-commercial license
    private JPanel jPanel1;
    private JTabbedPane jTabbedPane1;
    private JPanel jPanelLog;
    private JPanel jPanel20;
    private JPanel jPanel41;
    private JPanel jPanel40;
    private JButton jButtonLogradouroNovo;
    private JButton jButtonLogradouroEditar;
    private JButton jButtonLogradouroApagar;
    private JButton jButtonLogradouroSalvar;
    private JButton jButtonLogradouroCancelar;
    private JPanel jPanel6;
    private JScrollPane jScrollPane1;
    private JTextArea jTextAreaLogradouroDescricao;
    private JLabel jLabel3;
    private JLabel jLabel1;
    private JComboBox jComboBoxLogradouroTipo;
    private JTextField jTextFieldLogradouroNome;
    private JLabel jLabel2;
    private JPanel jPanel44;
    private JButton jButtonLogradouroPesquisar;
    private JTextField jTextFieldLogradouroID;
    private JLabel jLabel32;
    private JPanel jPanelFunc;
    private JPanel jPanel21;
    private JPanel jPanel5;
    private JLabel Logradouro4;
    private JLabel Logradouro5;
    private JLabel Logradouro6;
    private JLabel Logradouro7;
    private JScrollPane jScrollPane2;
    private JTextArea jTextAreaFuncionarioObservacoes;
    private JTextField jTextFieldFuncionarioCargo;
    private JTextField jTextFieldFuncionarioSalario;
    private JFormattedTextField jFormattedTextFieldFuncionarioDataContratacao;
    private JPanel jPanel4;
    private JLabel Logradouro1;
    private JLabel Logradouro3;
    private JTextField jTextFieldFuncionarioNumeroDaMatricula;
    private JComboBox jComboBoxFuncionarioStatus;
    protected JButton jButtonFuncionarioEditar;
    protected JButton jButtonFuncionarioApagar;
    private JButton jButtonFuncionarioSalvar;
    private JButton jButtonFuncionarioNovo;
    private JButton jButtonFuncionarioCancelar;
    private JPanel jPanel3;
    private JComboBox<String> jComboBoxFuncionarioLograduro;
    private JLabel jLabel8;
    private JTextField jTextFieldFuncionarioNumero;
    private JLabel jLabel9;
    private JTextField jTextFieldFuncionarioBairro;
    private JLabel jLabel10;
    private JTextField jTextFieldFuncionarioCidade;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JTextField jTextFieldFuncionarioCep;
    private JLabel Logradouro;
    private JComboBox jComboBoxFuncionarioUf;
    private JButton jButton2;
    private JPanel jPanel2;
    private JLabel jLabel6;
    private JLabel jLabel5;
    private JTextField jTextFieldFuncionarioNome;
    private JTextField jTextFieldFuncionarioSobrenome;
    private JTextField jTextFieldFuncionarioApelido;
    private JLabel jLabel7;
    private JSeparator jSeparator1;
    private JLabel jLabel18;
    private JTextField jTextFieldFuncionarioID;
    private JButton jButtonFuncionarioPesquisar;
    private JPanel jPanel47;
    private JTextField jTextFieldFuncionarioRgnumero;
    private JFormattedTextField jFormattedTextFieldFuncionarioCpf;
    private JTextField jTextFieldFuncionarioNomedopai;
    private JTextField jTextFieldFuncionarioNomedame;
    private JFormattedTextField jFormattedTextFieldFuncionarioDataNascimento;
    private JTextField jTextFieldFuncionarioTelefone;
    private JLabel jLabel4;
    private JLabel jLabel14;
    private JLabel jLabel16;
    private JLabel jLabel27;
    private JLabel jLabel20;
    private JLabel jLabel21;
    private JPanel jPanel57;
    private JLabel jLabel19;
    private JLabel jLabel13;
    private JTextField jTextFieldFuncionarioEmail;
    private JComboBox jComboBoxFuncionarioSexo;
    private JLabel jLabel22;
    private JLabel jLabel24;
    private JFormattedTextField jFormattedTextFieldFuncionarioDataEmissao;
    private JTextField jTextFieldFuncionarioOrgaoExpedidor;
    private JPanel jPanelCategoriaSocio;
    private JPanel jPanel30;
    private JPanel jPanel43;
    private JPanel jPanel10;
    private JButton jButtonCategoriaSocioNovo;
    private JButton jButtonCategoriaSocioEditar;
    private JButton jButtonCategoriaSocioSalvar;
    private JButton jButtonCategoriaSocioApagar;
    private JButton jButtonCategoriaSocioCancelar;
    private JPanel jPanel7;
    private JLabel jLabel34;
    private JTextField jTextFieldCategoriaSocioNome;
    private JLabel jLabel35;
    private JScrollPane jScrollPane5;
    private JTextArea jTextAreaCategoriaSocioDescricao;
    private JLabel jLabel36;
    private JComboBox<String> jComboBoxCategoriaSocioTaxa;
    private JPanel jPanel42;
    private JButton jButtonCategoriaSocioPesquisar;
    private JTextField jTextFieldCategoriaSocioID;
    private JLabel jLabel33;
    private JPanel jPanelTipoDespesa;
    private JPanel jPanel31;
    private JPanel jPanel24;
    private JLabel jLabel37;
    private JLabel jLabel38;
    private JLabel jLabel39;
    private JTextField jTextFieldTipoDespesaNome;
    private JScrollPane jScrollPane6;
    private JTextArea jTextAreaTipoDespesaDescricao;
    private JScrollPane jScrollPane7;
    private JTextArea jTextAreaTipoDespesaObservacao;
    private JPanel jPanel45;
    private JLabel jLabel40;
    private JTextField jTextFieldTIpoDespesaID;
    private JButton jButtonTipoDespesaPesquisar;
    private JPanel jPanel11;
    private JButton jButtonTipoDespesaNovo;
    private JButton jButtonTipoDespesaEditar;
    private JButton jButtonTipoDespesaSalvar;
    private JButton jButtonTipoDespesaApagar;
    private JButton jButtonTipoDespesaCancelar;
    private JPanel jPanelDespesa;
    private JPanel jPanel32;
    private JPanel jPanel53;
    private JPanel jPanel12;
    private JButton jButtonDespesaNovo;
    private JButton jButtonDespesaEditar;
    private JButton jButtonDespesaSalvar;
    private JButton jButtonDespesaApagar;
    private JButton jButtonDespesaCancelar;
    private JPanel jPanel25;
    private JLabel jLabel42;
    private JLabel jLabel44;
    private JScrollPane jScrollPane9;
    private JTextArea jTextAreaDespesaObservacao;
    private JLabel jLabel47;
    private JLabel jLabel48;
    private JTextField jTextFieldDespesaValor;
    private JComboBox<String> jComboBoxDespesaMotivo;
    private JLabel jLabel49;
    private JLabel jLabel50;
    private JTextField jTextFieldDespesaFavorecido;
    private JFormattedTextField jFormattedTextFieldDespesaData;
    private JComboBox<String> jComboBoxDespesaFuncionario;
    private JPanel jPanel46;
    private JButton jButtonDespesaPesquisar;
    private JLabel jLabel45;
    private JTextField jTextFieldDespesaID;
    private JPanel jPanelTipoReceita;
    private JPanel jPanel33;
    private JPanel jPanel49;
    private JPanel jPanel14;
    private JButton jButtonTipoReceitaNovo;
    private JButton jButtonTipoReceitaEditar;
    private JButton jButtonTipoReceitaSalvar;
    private JButton jButtonTipoReceitaApagar;
    private JButton jButtonTipoReceitaCancelar;
    private JPanel jPanel26;
    private JLabel jLabel51;
    private JLabel jLabel53;
    private JLabel jLabel54;
    private JTextField jTextFieldTipoReceitaNome;
    private JScrollPane jScrollPane10;
    private JTextArea jTextAreaTipoReceitaDescricao;
    private JScrollPane jScrollPane11;
    private JTextArea jTextAreaTipoReceitaObservacao;
    private JPanel jPanel48;
    private JButton jButtonTipoReceitaPesquisar;
    private JLabel jLabel55;
    private JTextField jTextFieldTIpoReceitaID;
    private JPanel jPanelReceitas;
    private JPanel jPanel34;
    private JPanel jPanel51;
    private JPanel jPanel8;
    private JButton jButtonReceitaNovo;
    private JButton jButtonReceitaEditar;
    private JButton jButtonReceitaSalvar;
    private JButton jButtonReceitaApagar;
    private JButton jButtonReceitaCancelar;
    private JPanel jPanel27;
    private JLabel jLabel43;
    private JLabel jLabel46;
    private JScrollPane jScrollPane12;
    private JTextArea jTextAreaReceitaObservacao;
    private JLabel jLabel58;
    private JLabel jLabel59;
    private JTextField jTextFieldReceitaValor;
    private JComboBox<String> jComboBoxReceitaMotivoEntrada;
    private JLabel jLabel60;
    private JLabel jLabel61;
    private JComboBox<String> jComboBoxReceitaSocio;
    private JComboBox<String> jComboBoxReceitaFuncionario;
    private JPanel jPanel50;
    private JLabel jLabel57;
    private JTextField jTextFieldReceitaID;
    private JButton jButtonReceitaPesquisar;
    private JDateChooser jDateChooser1;
    private JCheckBox jCheckBoxReceitaAvulsa;
    private JPanel jPanelCheques;
    private JPanel jPanel35;
    private JPanel jPanel16;
    private JButton jButtonChequeNovo;
    private JButton jButtonChequeEditar;
    private JButton jButtonChequeSalvar;
    private JButton jButtonChequeApagar;
    private JButton jButtonChequeCancelar;
    private JPanel jPanel15;
    private JLabel jLabel28;
    private JTextField jTextFieldChequeValor;
    private JLabel jLabel29;
    private JLabel jLabel30;
    private JLabel jLabel62;
    private JLabel jLabel63;
    private JComboBox<String> jComboBoxChequeMotivoDespesa;
    private JLabel jLabel64;
    private JTextField jTextFieldChequeNumero;
    private JScrollPane jScrollPane8;
    private JTextArea jTextAreaChequeObservacoes;
    private JLabel jLabel65;
    private JComboBox<String> jComboBoxChequeFuncionario;
    private JFormattedTextField jFormattedTextFieldChequeDataVencimento;
    private JFormattedTextField jFormattedTextFieldChequeDataPagamento;
    private JPanel jPanel52;
    private JLabel jLabel26;
    private JTextField jTextFieldChequeID;
    private JButton jButtonChequePesquisar;
    private JPanel jPanelTaxas;
    private JPanel jPanel22;
    private JPanel jPanel55;
    private JPanel jPanel18;
    private JButton jButtonTaxaNovo;
    private JButton jButtonTaxaEditar;
    private JButton jButtonTaxaSalvar;
    private JButton jButtonTaxaApagar;
    private JButton jButtonTaxaCancelar;
    private JPanel jPanel13;
    private JLabel jLabel17;
    private JLabel jLabel23;
    private JLabel jLabel25;
    private JTextField jTextFieldTaxasNome;
    private JTextField jTextFieldTaxasValor;
    private JScrollPane jScrollPane3;
    private JTextArea jTextAreaTaxasDescricao;
    private JPanel jPanel54;
    private JButton jButtonTaxasPesquisar;
    private JTextField jTextFieldTaxasID;
    private JLabel jLabel15;
    private JPanel jPanelSocio;
    private JPanel jPanel17;
    private JPanel jPanel56;
    private JPanel jPanel9;
    private JButton jButtonSocioNovo;
    private JButton jButtonSocioEditar;
    private JButton jButtonSocioSalvar;
    private JButton jButtonSocioApagar;
    private JButton jButtonSocioCancelar;
    private JButton jButton1;
    private JPanel jPanel29;
    private JLabel jLabel85;
    private JLabel jLabel86;
    private JLabel jLabel87;
    private JLabel jLabel88;
    private JLabel jLabel89;
    private JComboBox<String> jComboBoxSocioCategoriaSocio;
    private JTextField jTextFieldSocioNumeroSocio;
    private JFormattedTextField jFormattedTextFieldSocioDiaVencimento;
    private JRadioButton jRadioButtonSocioAtivo;
    private JRadioButton jRadioButtonSocioInativo;
    private JFormattedTextField jFormattedTextFieldSocioDataMatricula;
    private JPanel jPanel28;
    private JComboBox<String> jComboBoxSocioLogradouro;
    private JLabel jLabel80;
    private JTextField jTextFieldSocioNumero;
    private JLabel jLabel81;
    private JTextField jTextFieldSocioBairro;
    private JLabel jLabel82;
    private JLabel jLabel83;
    private JLabel jLabel84;
    private JTextField jTextFieldSocioCEP;
    private JLabel Logradouro2;
    private JComboBox jComboBoxSocioUF;
    private JButton jButtonSocioAdicionarLogradouro;
    private JFormattedTextField jTextFieldSocioCep2;
    private JPanel jPanel23;
    private JSeparator jSeparator4;
    private JPanel jPanel36;
    private JLabel jLabel70;
    private JTextField jTextFieldSocioEmail;
    private JLabel jLabel74;
    private JComboBox jComboBoxSocioSexo;
    private JLabel jLabel79;
    private JLabel jLabel72;
    private JTextField jTextFieldSocioNomeMae;
    private JTextField jTextFieldSocioNomePai;
    private JPanel jPanel37;
    private JTextField jTextFieldSocioNome;
    private JTextField jTextFieldSocioSobrenome;
    private JTextField jTextFieldSocioApelido;
    private JTextField jTextFieldSocioTelefone;
    private JLabel jLabel67;
    private JLabel jLabel66;
    private JLabel jLabel68;
    private JLabel jLabel69;
    private JLabel jLabel71;
    private JFormattedTextField jFormattedTextFieldSocioDataNascimento;
    private JPanel jPanel38;
    private JButton jButtonSocioPesquisar;
    private JTextField jTextFieldSocioID;
    private JLabel jLabel73;
    private JPanel jPanel39;
    private JFormattedTextField jFormattedTextFieldSocioCPF;
    private JTextField jTextFieldSocioRgNumero;
    private JLabel jLabel76;
    private JLabel jLabel75;
    private JLabel jLabel78;
    private JFormattedTextField jFormattedTextFieldSocioDataEmissao;
    private JLabel jLabel90;
    private JFormattedTextField jFormattedCNPJ;
    private JCheckBox jRadioCPFCNPJ;
    private JCheckBox jCheckBoxExclusivamenteSocio;
    private JLabel jLabel77;
    private JTextField jTextFieldSocioOrgaoExpedidor;
    private JDesktopPane jDesktopPane1;
    private JInternalFrame jInternalFrame1;
    private JScrollPane jScrollPane4;
    private JTable jTable1;
    private JPanel jPanel19;
    private JLabel jLabel31;
    private JTextField jTextField2;
    private JButton jButtonPesquisa;
    private JButton jButtonInternalFrameVoltar;
    private ButtonGroup buttonGroupSocioAprovacao;
    // End of variables declaration//GEN-END:variables
}
