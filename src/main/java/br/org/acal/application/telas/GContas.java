package br.org.acal.application.telas;

import br.org.acal.resouces.dao.DaoContasMensais;
import br.org.acal.resouces.dao.DaoEnderecoPessoa;
import br.org.acal.resouces.entidades.Conta;
import br.org.acal.resouces.entidades.Enderecopessoa;
import br.org.acal.resouces.entidades.Geracaocontas;
import br.org.acal.resouces.entidades.Hidrometro;
import br.org.acal.resouces.entidades.Taxa;
import br.org.acal.resouces.entidades.Taxasconta;
import br.org.acal.application.telas.relatorios.TelaRelatoriosContas;

import javax.swing.AbstractCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GContas extends JFrame {

    private List<Geracaocontas> socios;
    private Map<String, List<Taxa>> taxas;
    private JFrame telaPrincipal;
    public GContas() {
        taxas = new HashMap<>();
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        carregarSocios();
        
        
    }
//Construtor que recebe como parâmetro o frame da tela principal.
    public GContas(JFrame telaPrincipal) {

        this();
        this.telaPrincipal = telaPrincipal;
        this.telaPrincipal.setEnabled(false);
        this.telaPrincipal.setVisible(false);
        toFront();
    }

    //Aqui são carregados todos os endereços para preencher a tabela.
    private void carregarSocios() {
        socios = new DaoEnderecoPessoa().TodosOsSocios();
        //this.socios = new ArrayList<Enderecopessoa>();
       // this.socios = new DaoEnderecoPessoa().TodosOsSocios(0);
    }

    //Método responsável por editar as colunas da tabela, de acordo com o tipo de conta selecionada, que pode ser fixa ou hidrometro.
    private void preencherTabela() {

        //Se tiver sido selecionado a conta fixa, a tabela será preenchida com as colunas específicas.
        if (jRadioButtonContaFixa.isSelected()) {
            //Table Renderer resposável por centralizar o conteúdo das colunas.
            DefaultTableCellRenderer centralizar = new DefaultTableCellRenderer();
            centralizar.setHorizontalAlignment(SwingConstants.CENTER);

            //Define o modelo da tabela
            jTable1.setModel(new DefaultTableModel(
                    new Object[][]{},
                    new String[]{"id", "dataVencimento", "Sócio", "Numero Socio", "CPF", "Numero Endereço", "Valor", "Gerar", "Taxa"}) {
                Class[] types = new Class[]{Integer.class, String.class, String.class, Integer.class, String.class, String.class,
                    BigDecimal.class, Boolean.class, JButton.class};
                
                @Override
                public Class getColumnClass(int columnIndex) {
                    return types[columnIndex];
                }
                boolean[] canEdit = new boolean[]{false, false, false, false, false, false, true, true, true};

                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {

                    return canEdit[columnIndex];
                }
            });

            //Seta o tipo de Cell Renderer. Aqui eu passei o renderer que criei lá em cima para centralizar o conteúdo.
            jTable1.getColumn("id").setCellRenderer(centralizar);
            jTable1.getColumn("dataVencimento").setCellRenderer(centralizar);
            jTable1.getColumn("Sócio").setCellRenderer(centralizar);
            jTable1.getColumn("Numero Socio").setCellRenderer(centralizar);
            jTable1.getColumn("CPF").setCellRenderer(centralizar);
            jTable1.getColumn("Numero Endereço").setCellRenderer(centralizar);
            jTable1.getColumn("Valor").setCellRenderer(centralizar);

            
            
        } 
        //Se tiver sido selecionado a conta hidrometro, a tabela será preenchida com as colunas específicas.
        else if (jRadioButtonContaHidrometro.isSelected()) {
        //Table Renderer resposável por centralizar o conteúdo das colunas.
            DefaultTableCellRenderer centralizar = new DefaultTableCellRenderer();
            centralizar.setHorizontalAlignment(SwingConstants.CENTER);
            //Define o modelo da tabela
            jTable1.setModel(new DefaultTableModel(
                    new Object[][]{},
                    new String[]{"id", "dataVencimento", "Sócio", "Numero Socio", "CPF", "Numero Endereço", "Valor", "Gerar", "Taxa", "Consumo"}) {
                Class[] types = new Class[]{Integer.class, String.class, String.class, Integer.class, String.class, String.class,
                    BigDecimal.class, Boolean.class, JButton.class, Double.class};

                @Override
                public Class getColumnClass(int columnIndex) {
                    return types[columnIndex];
                }
                boolean[] canEdit = new boolean[]{false, false, false, false, false, false, true, true, true, true};

                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {

                    return canEdit[columnIndex];
                }
            });
            //Seta o tipo de Cell Renderer. Aqui eu passei o renderer que criei lá em cima para centralizar o conteúdo.
            jTable1.getColumn("id").setCellRenderer(centralizar);
            jTable1.getColumn("dataVencimento").setCellRenderer(centralizar);
            jTable1.getColumn("Sócio").setCellRenderer(centralizar);
            jTable1.getColumn("Numero Socio").setCellRenderer(centralizar);
            jTable1.getColumn("CPF").setCellRenderer(centralizar);
            jTable1.getColumn("Numero Endereço").setCellRenderer(centralizar);
            jTable1.getColumn("Valor").setCellRenderer(centralizar);
            jTable1.getColumn("Consumo").setCellRenderer(centralizar);

        }


        //Classe interna ButtonColumn, responsável por adicionar o botão de adicionar taxas na tabela.
        ButtonColumn botao = new ButtonColumn(jTable1, 8);
        //método que irá preencher as linhas com a lista de EnderecosPessoa.
        preencherColunas();

    
    }
    
 

    private void preencherColunas() {

        //Calendário que irá definir a data de vencimento da conta...Deixei fixo um valor de 5 dias após a data atual, pretendo deixar esse valor dinâmico para o usuário.
        Calendar c = Calendar.getInstance();
        c.set(Calendar.MONTH, jMonthChooser1.getMonth());
        c.set(Calendar.YEAR, jYearChooser1.getYear());
        c.add(Calendar.DAY_OF_MONTH, Integer.parseInt((String)jComboBox1.getSelectedItem()));
        try{
        if (jRadioButtonContaFixa.isSelected()) {
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            
           
            if (!socios.isEmpty()) {

                
                for (Geracaocontas s1 : socios) {
                   
                    List<Date> datas = new DaoContasMensais().datasContas(s1.getNumero());
                    if (datas.isEmpty()) {
                        Pattern p = Pattern.compile("hidrometro");
                        Matcher m = p.matcher(s1.getCategoria());
                        if (!m.find()) {
                          //  if(s.getIdPessoa().getStatus()){
                            model.addRow(new Object[]{s1.getId(), SimpleDateFormat.getDateInstance().format(c.getTime()), s1.getNome() + " " + s1.getSobrenome(), s1.getNumerosocio(), s1.getCpf(), s1.getNumero(), s1.getValor(), false});
                           // }
                            }
                    } else {
                        boolean existeContaNoMes = false;
                        for (Date data : datas) {

                            Calendar c1 = Calendar.getInstance();
                            c1.setTime(data);
                            Calendar c2 = Calendar.getInstance();
                            c2.set(Calendar.MONTH, jMonthChooser1.getMonth());
                            c2.add(Calendar.DAY_OF_MONTH, Integer.parseInt((String)jComboBox1.getSelectedItem()));
                            if (c1.get(Calendar.MONTH) == c2.get(Calendar.MONTH) && c1.get(Calendar.YEAR) == jYearChooser1.getYear()) {

                                existeContaNoMes = true;

                            }

                        }

                        if (!existeContaNoMes) {

                            Pattern p = Pattern.compile("hidrometro");
                            Matcher m = p.matcher(s1.getCategoria());
                        if (!m.find()) {
                               // if(s.getIdPessoa().getStatus()){
                                model.addRow(new Object[]{s1.getId(), SimpleDateFormat.getDateInstance().format(c.getTime()), s1.getNome() + " " + s1.getSobrenome(), s1.getNumerosocio(), s1.getCpf(), s1.getNumero(), s1.getValor(), false});
                               // }
                                }
                        }
                    }

                }

            }


        } else if (jRadioButtonContaHidrometro.isSelected()) {
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();



            model.setRowCount(0);
            // List<Enderecopessoa> socios = new DaoEnderecoPessoa().TodosOsSocios();


            if (!socios.isEmpty()) {

                for (Geracaocontas s1 : socios) {
                    
                    List<Date> datas = new DaoContasMensais().datasContas(s1.getNumero());
                    if (datas.isEmpty()) {
                        Pattern p = Pattern.compile("hidrometro");
                        Matcher m = p.matcher(s1.getCategoria());
                        if (m.find()) {
                       // if(s.getIdPessoa().getStatus()){
                            model.addRow(new Object[]{s1.getId(), SimpleDateFormat.getDateInstance().format(c.getTime()), s1.getNome() + " " + s1.getSobrenome(), s1.getNumerosocio(), s1.getCpf(), s1.getNumero(), s1.getValor(), false});
                        //}
                        }
                    } else {
                        boolean existeContaNoMes = false;
                        for (Date data : datas) {

                            Calendar c1 = Calendar.getInstance();
                            c1.setTime(data);
                            if (c1.get(Calendar.MONTH) == jMonthChooser1.getMonth() && c1.get(Calendar.YEAR) == jYearChooser1.getYear()) {

                                existeContaNoMes = true;

                            }

                        }

                        if (!existeContaNoMes) {
                        Pattern p = Pattern.compile("hidrometro");
                        Matcher m = p.matcher(s1.getCategoria());
                        if (m.find()) {
                              // if(s.getIdPessoa().getStatus()){
                                model.addRow(new Object[]{s1.getId(), SimpleDateFormat.getDateInstance().format(c.getTime()), s1.getNome() + " " + s1.getSobrenome(), s1.getNumerosocio(), s1.getCpf(), s1.getNumero(), s1.getValor(), false});
                             //  }
                               }
                        }


                    }
                }
            }



        } }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,"Erro:"+e.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE);
        }
    }

    private void chamarTaxas() {

        
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        Enderecopessoa e1 = new DaoEnderecoPessoa().EnderecopessoaporNumero((String) model.getValueAt(jTable1.getSelectedRow(), 5));
        //se o mapa não tiver essa chave , ele adiciona e coloca um único valor...que é a taxa principal
        if (!taxas.containsKey(e1.getNumero())) {
            List<Taxa> inicial = new ArrayList<>();
            inicial.add(e1.getIdCategoriaSocio().getTaxasId());
            taxas.put(e1.getNumero(), inicial);
        }

        List<Taxa> t1 = taxas.get(e1.getNumero());
        List<Taxa> enviar = new ArrayList<>();
        for (Taxa receber : t1) {

            enviar.add(receber);
        }
        Taxas t = new Taxas(this, true, enviar);
        t.setLocationRelativeTo(null);
        t.setVisible(true);

        taxas.get(e1.getNumero()).clear();
        double soma = 0;
        List<Taxa> taxasTaxas = t.getValoresTaxas();
        for (Taxa aux : taxasTaxas) {
            soma += aux.getValor().doubleValue();
            taxas.get(e1.getNumero()).add(aux);
        }


        //Atualiza o valor da conta de acordo com a quantidade de taxas
        model.setValueAt(BigDecimal.valueOf(soma), jTable1.getSelectedRow(), 6);

    }

    //Classe que adiciona o botão de adicionar taxas na tabela.
    private class ButtonColumn extends AbstractCellEditor
            implements TableCellRenderer, TableCellEditor, ActionListener {

        JTable table;
        JButton renderButton;
        JButton editButton;
        String text;

        public ButtonColumn(JTable table, int column) {
            super();
            this.table = table;
            renderButton = new JButton();

            editButton = new JButton();
            editButton.setFocusPainted(false);
            editButton.addActionListener(this);

            TableColumnModel columnModel = table.getColumnModel();
            columnModel.getColumn(column).setCellRenderer(this);
            columnModel.getColumn(column).setCellEditor(this);
        }

        @Override
        public Component getTableCellRendererComponent(
                JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (hasFocus) {
                renderButton.setForeground(table.getForeground());
                renderButton.setBackground(UIManager.getColor("Button.background"));
            } else if (isSelected) {
                renderButton.setForeground(table.getSelectionForeground());
                renderButton.setBackground(table.getSelectionBackground());
            } else {
                renderButton.setForeground(table.getForeground());
                renderButton.setBackground(UIManager.getColor("Button.background"));
            }

            renderButton.setText((value == null) ? "Adicionar" : value.toString());
            return renderButton;
        }

        @Override
        public Component getTableCellEditorComponent(
                JTable table, Object value, boolean isSelected, int row, int column) {
            text = (value == null) ? "Adicionar" : value.toString();
            editButton.setText(text);
            return editButton;
        }

        @Override
        public Object getCellEditorValue() {
            return text;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            fireEditingStopped();

            chamarTaxas();

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new JTable();
        jPanel1 = new javax.swing.JPanel();
        jRadioButtonContaFixa = new javax.swing.JRadioButton();
        jRadioButtonContaHidrometro = new javax.swing.JRadioButton();
        jButton1 = new JButton();
        jMonthChooser1 = new com.toedter.calendar.JMonthChooser();
        jYearChooser1 = new com.toedter.calendar.JYearChooser();
        jProgressBar1 = new javax.swing.JProgressBar();
        jCheckBox1 = new javax.swing.JCheckBox();
        jButton2 = new JButton();
        jComboBox1 = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/img/ico.png")).getImage());
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
        jTable1.setSelectionBackground(new java.awt.Color(51, 255, 255));
        jTable1.getTableHeader().setResizingAllowed(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        buttonGroup1.add(jRadioButtonContaFixa);
        jRadioButtonContaFixa.setText("Conta Fixa");
        jRadioButtonContaFixa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jRadioButtonContaFixaActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButtonContaHidrometro);
        jRadioButtonContaHidrometro.setText("Conta com Hidrômetro");
        jRadioButtonContaHidrometro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jRadioButtonContaHidrometroActionPerformed(evt);
            }
        });

        jButton1.setText("Gerar");
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jMonthChooser1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jMonthChooser1PropertyChange(evt);
            }
        });

        jYearChooser1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jYearChooser1PropertyChange(evt);
            }
        });

        jProgressBar1.setBackground(new java.awt.Color(0, 255, 255));
        jProgressBar1.setStringPainted(true);

        jCheckBox1.setText("Marcar todas");
        jCheckBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(ItemEvent evt) {
                jCheckBox1ItemStateChanged(evt);
            }
        });

        jButton2.setText("Imprimir");
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButtonContaFixa)
                    .addComponent(jRadioButtonContaHidrometro))
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jMonthChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jYearChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 167, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jCheckBox1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jRadioButtonContaFixa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButtonContaHidrometro)
                    .addComponent(jMonthChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jYearChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jCheckBox1)
                        .addComponent(jButton2)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButtonContaFixaActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jRadioButtonContaFixaActionPerformed

        preencherTabela();
    }//GEN-LAST:event_jRadioButtonContaFixaActionPerformed

    private void jRadioButtonContaHidrometroActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jRadioButtonContaHidrometroActionPerformed

        preencherTabela();
    }//GEN-LAST:event_jRadioButtonContaHidrometroActionPerformed

    private void jButton1ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        
        //se a tabela estiver vazia nada não entrará no if.
       if(jTable1.getRowCount() >0){
          
        boolean existeContaSelecionada = false;
        //Percorre todas as linhas da tabela à procura dos sócios selecionados.
        for(int i = 0; i<jTable1.getRowCount(); i++){
               
                //se alguma linha estiver selecionada, configura a variável existeContaSelecionada como true.
                if((boolean)jTable1.getValueAt(i, 7)){
                    
                    existeContaSelecionada = true;
                }
              
            }
            
        
        //Se tiver pelo menos uma conta selecionada, o bloco if será executado.
        if(existeContaSelecionada){
         boolean consumoPreenchido = false;
         int cont = 0;
         Pattern p = Pattern.compile("\\d+");
         Matcher m = null;
         //Se as contas de hidrometro estiverem selecionadas...o bloco if irá fazer um teste para verificar se a coluna consumo está preenchida corretamente.
        if(jRadioButtonContaHidrometro.isSelected()){
            
           for(int i = 0; i<jTable1.getRowCount(); i++){
               if(jTable1.getValueAt(i, 9) != null){
                   cont++;
               m = p.matcher(String.valueOf(jTable1.getValueAt(i, 9)));
               if(m.find() && (boolean)jTable1.getValueAt(i, 7)){
                   consumoPreenchido = true;
               }
           }
           }
            
        }    
        //se a coluna de consumo estiver preenchida de acordo com a expressão regular, o bloco if será executado.    
       if(jRadioButtonContaHidrometro.isSelected()){
        if(consumoPreenchido){
        int op = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja registrar as contas desses sócios?", "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        if (op == JOptionPane.YES_OPTION) {
            Thread t = new Thread() {
                @Override
                public void run() {
                    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                    Conta c = null;
                    jButton1.setEnabled(false);
                    jRadioButtonContaFixa.setEnabled(false);
                    jRadioButtonContaHidrometro.setEnabled(false);

                        try {

                            int cont = 0;
                            //percorre todas as linhas
                            for (int i = 0; i < model.getRowCount(); i++) {

                                if ((boolean) model.getValueAt(i, 7)) {

                                    cont++;
                                }
                            }

                            jProgressBar1.setMaximum(cont - 1);
                            //percorre todas as linhas
                            for (int i = 0; i < model.getRowCount(); i++) {
                                //se o checkbox estiver marcado executa o if.
                                if ((boolean) model.getValueAt(i, 7)) {

                                    jProgressBar1.setValue(i);

                                    //se tiver selecionado as contas fixas...
                                    if (jRadioButtonContaFixa.isSelected()) {
                                        //Cria uma conta vazia.
                                        c = new Conta();
                                        //seta a data Gerada como a data atual.
                                        c.setDataGerada(new Date());
                                        //data de vencimento da tabela
                                        c.setDataVence(SimpleDateFormat.getDateInstance().parse((String) model.getValueAt(i, 1)));
                                        //Pega do banco um endereçoPessoa de acordo com o número do endereço na tabela, que é único
                                        Enderecopessoa e = new DaoEnderecoPessoa().EnderecopessoaporNumero((String) model.getValueAt(i, 5));
                                        //seta o enderecoPessoa na conta
                                        c.setIdEnderecoPessoa(e);

                                        List<Taxasconta> taxas1 = new ArrayList<>();
                                        if(taxas.containsKey(e.getNumero())){
                                       for(Taxa aux : taxas.get(e.getNumero())){
                                        Taxasconta tx = new Taxasconta();
                                        tx.setContaid(c);
                                        //seta a taxa em taxas Conta de acordo com a categoria socio do sócio vinculado ao endereço
                                        tx.setTaxaid(aux);
                                        //Aqui adiciono todas as taxas de cada endereço...
                                        taxas1.add(tx);
                                       } 
                                       }else{
                                        Taxasconta tx = new Taxasconta();
                                        tx.setContaid(c);
                                        //seta a taxa em taxas Conta de acordo com a categoria socio do sócio vinculado ao endereço
                                        tx.setTaxaid(e.getIdCategoriaSocio().getTaxasId());
                                        //Aqui adiciono todas as taxas de cada endereço...
                                        taxas1.add(tx);  
                                        }
                                        //lista de taxasConta na conta...
                                        //c.setTaxascontaList(taxas1);
                                        new DaoContasMensais().AdicionarConta(c);

                                    } //se tiver selecionado as contas com hidrometro
                                    else if (jRadioButtonContaHidrometro.isSelected()) {
                                        
                                         //Cria uma conta vazia.
                                        c = new Conta();
                                        //seta a data Gerada como a data atual.
                                        c.setDataGerada(new Date());
                                        //data de vencimento da tabela
                                        c.setDataVence(SimpleDateFormat.getDateInstance().parse((String) model.getValueAt(i, 1)));
                                        //Pega do banco um endereçoPessoa de acordo com o número do endereço na tabela, que é único
                                        Enderecopessoa e = new DaoEnderecoPessoa().EnderecopessoaporNumero((String) model.getValueAt(i, 5));
                                        //seta o enderecoPessoa na conta
                                        c.setIdEnderecoPessoa(e);

                                        List<Taxasconta> taxas1 = new ArrayList<>();
                                        if(taxas.containsKey(e.getNumero())){
                                       for(Taxa aux : taxas.get(e.getNumero())){
                                        Taxasconta tx = new Taxasconta();
                                        tx.setContaid(c);
                                        //seta a taxa em taxas Conta de acordo com a categoria socio do sócio vinculado ao endereço
                                        tx.setTaxaid(aux);
                                        //Aqui adiciono todas as taxas de cada endereço...
                                        taxas1.add(tx);
                                       } 
                                       }else{
                                        Taxasconta tx = new Taxasconta();
                                        tx.setContaid(c);
                                        //seta a taxa em taxas Conta de acordo com a categoria socio do sócio vinculado ao endereço
                                        tx.setTaxaid(e.getIdCategoriaSocio().getTaxasId());
                                        //Aqui adiciono todas as taxas de cada endereço...
                                        taxas1.add(tx);  
                                        }
                                        
                                        Hidrometro h = new Hidrometro();
                                        h.setIdconta(c);
                                        h.setConsumo((double)model.getValueAt(i, 9));
                                        c.setHidrometro(h);
                                        new DaoContasMensais().AdicionarConta(c); 
                                        
                                    }

                                }
                            }

                                jButton1.setEnabled(true);
                                jRadioButtonContaFixa.setEnabled(true);
                                jRadioButtonContaHidrometro.setEnabled(true);
                                JOptionPane.showMessageDialog(GContas.this, "Conta(s) Registrada(s) com sucesso!", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                                jProgressBar1.setValue(0);
                                jCheckBox1.setSelected(false);
                                carregarSocios();
                                preencherTabela();
                            

                        } catch (Exception e) {

                            JOptionPane.showMessageDialog(GContas.this, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                        }
                    
                }
            };

            t.start();
        }
        }else{
          JOptionPane.showMessageDialog(this, "Preencha corretamente o campo de consumo com dígitos","Atenção",JOptionPane.ERROR_MESSAGE);  
            
        }
        
        }else{
            
        int op = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja registrar as contas desses sócios?", "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        if (op == JOptionPane.YES_OPTION) {
            Thread t = new Thread() {
                @Override
                public void run() {
                    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                    Conta c = null;
                    jButton1.setEnabled(false);
                    jRadioButtonContaFixa.setEnabled(false);
                    jRadioButtonContaHidrometro.setEnabled(false);

                        try {

                            int cont = 0;
                            //percorre todas as linhas
                            for (int i = 0; i < model.getRowCount(); i++) {

                                if ((boolean) model.getValueAt(i, 7)) {

                                    cont++;
                                }
                            }

                            jProgressBar1.setMaximum(cont - 1);
                            //percorre todas as linhas
                            for (int i = 0; i < model.getRowCount(); i++) {
                                //se o checkbox estiver marcado executa o if.
                                if ((boolean) model.getValueAt(i, 7)) {

                                    jProgressBar1.setValue(i);

                                    //se tiver selecionado as contas fixas...
                                    if (jRadioButtonContaFixa.isSelected()) {
                                        //Cria uma conta vazia.
                                        c = new Conta();
                                        //seta a data Gerada como a data atual.
                                        c.setDataGerada(new Date());
                                        //data de vencimento da tabela
                                        c.setDataVence(SimpleDateFormat.getDateInstance().parse((String) model.getValueAt(i, 1)));
                                        //Pega do banco um endereçoPessoa de acordo com o número do endereço na tabela, que é único
                                        Enderecopessoa e = new DaoEnderecoPessoa().EnderecopessoaporNumero((String) model.getValueAt(i, 5));
                                        //seta o enderecoPessoa na conta
                                        c.setIdEnderecoPessoa(e);

                                        List<Taxasconta> taxas1 = new ArrayList<>();
                                        if(taxas.containsKey(e.getNumero())){
                                       for(Taxa aux : taxas.get(e.getNumero())){
                                        Taxasconta tx = new Taxasconta();
                                        tx.setContaid(c);
                                        //seta a taxa em taxas Conta de acordo com a categoria socio do sócio vinculado ao endereço
                                        
                                        tx.setTaxaid(aux);
                                        
                                        //Aqui adiciono todas as taxas de cada endereço...
                                        taxas1.add(tx);
                                       } 
                                       }else{
                                        Taxasconta tx = new Taxasconta();
                                        tx.setContaid(c);
                                        //seta a taxa em taxas Conta de acordo com a categoria socio do sócio vinculado ao endereço
                                        tx.setTaxaid(e.getIdCategoriaSocio().getTaxasId());
                                        //Aqui adiciono todas as taxas de cada endereço...
                                        taxas1.add(tx);  
                                        }
                                        //lista de taxasConta na conta...
                                       // c.setTaxascontaList(taxas1);
                                        new DaoContasMensais().AdicionarConta(c);

                                    } //se tiver selecionado as contas com hidrometro
                                    else if (jRadioButtonContaHidrometro.isSelected()) {
                                        
                                         //Cria uma conta vazia.
                                        c = new Conta();
                                        //seta a data Gerada como a data atual.
                                        c.setDataGerada(new Date());
                                        //data de vencimento da tabela
                                        c.setDataVence(SimpleDateFormat.getDateInstance().parse((String) model.getValueAt(i, 1)));
                                        //Pega do banco um endereçoPessoa de acordo com o número do endereço na tabela, que é único
                                        Enderecopessoa e = new DaoEnderecoPessoa().EnderecopessoaporNumero((String) model.getValueAt(i, 5));
                                        //seta o enderecoPessoa na conta
                                        c.setIdEnderecoPessoa(e);

                                        List<Taxasconta> taxas1 = new ArrayList<>();
                                        if(taxas.containsKey(e.getNumero())){
                                       for(Taxa aux : taxas.get(e.getNumero())){
                                        Taxasconta tx = new Taxasconta();
                                        tx.setContaid(c);
                                        //seta a taxa em taxas Conta de acordo com a categoria socio do sócio vinculado ao endereço
                                        tx.setTaxaid(aux);
                                        //Aqui adiciono todas as taxas de cada endereço...
                                        taxas1.add(tx);
                                       } 
                                       }else{
                                        Taxasconta tx = new Taxasconta();
                                        tx.setContaid(c);
                                        //seta a taxa em taxas Conta de acordo com a categoria socio do sócio vinculado ao endereço
                                        tx.setTaxaid(e.getIdCategoriaSocio().getTaxasId());
                                        //Aqui adiciono todas as taxas de cada endereço...
                                        taxas1.add(tx);  
                                        }
                                        
                                        Hidrometro h = new Hidrometro();
                                        h.setIdconta(c);
                                        h.setConsumo((double)model.getValueAt(i, 9));
                                        //lista de taxasConta na conta...
                                       // c.setTaxascontaList(taxas1);
                                        c.setHidrometro(h);
                                        new DaoContasMensais().AdicionarConta(c); 
                                        
                                    }

                                }
                            }

                                jButton1.setEnabled(true);
                                jRadioButtonContaFixa.setEnabled(true);
                                jRadioButtonContaHidrometro.setEnabled(true);
                                JOptionPane.showMessageDialog(GContas.this, "Conta(s) Registrada(s) com sucesso!", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                                jProgressBar1.setValue(0);
                                jCheckBox1.setSelected(false);
                                carregarSocios();
                                preencherTabela();
                            

                        } catch (Exception e) {

                            JOptionPane.showMessageDialog(GContas.this, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                        }
                    
                }
            };

            t.start();
        } 
        }
        
        
        }else{
            
            JOptionPane.showMessageDialog(this, "Nenhum sócio foi selecionado","Atenção",JOptionPane.INFORMATION_MESSAGE);
            
        }
       }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMonthChooser1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jMonthChooser1PropertyChange
        taxas.clear();
        jCheckBox1.setSelected(false);
        if (jRadioButtonContaFixa.isSelected()) {

            jRadioButtonContaFixaActionPerformed(null);
        } else if (jRadioButtonContaHidrometro.isSelected()) {

            jRadioButtonContaHidrometroActionPerformed(null);
        }
    }//GEN-LAST:event_jMonthChooser1PropertyChange

    private void jYearChooser1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jYearChooser1PropertyChange
        taxas.clear();
        jCheckBox1.setSelected(false);
        if (jRadioButtonContaFixa.isSelected()) {

            jRadioButtonContaFixaActionPerformed(null);
        } else if (jRadioButtonContaHidrometro.isSelected()) {

            jRadioButtonContaHidrometroActionPerformed(null);
        }
    }//GEN-LAST:event_jYearChooser1PropertyChange

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        telaPrincipal.setEnabled(true);
        telaPrincipal.setVisible(true);
        telaPrincipal.toFront();

    }//GEN-LAST:event_formWindowClosed

    private void jCheckBox1ItemStateChanged(ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
      
        
        if((jRadioButtonContaFixa.isSelected() || jRadioButtonContaHidrometro.isSelected()) && jTable1.getModel().getRowCount() >0){
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
            if(evt.getStateChange() == ItemEvent.SELECTED){
            
         for(int i = 0; i<model.getRowCount();i++){
             
             model.setValueAt(true, i, 7);
             
         }
            
        }else if(evt.getStateChange() == ItemEvent.DESELECTED){
            
             for(int i = 0; i<model.getRowCount();i++){
             
             model.setValueAt(false, i, 7);
             
         } 
            
        }
        
        }else{
            
            jCheckBox1.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox1ItemStateChanged

    private void jButton2ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      // TelaRelatoriosContas tc = new TelaRelatoriosContas();
       // tc.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox1ItemStateChanged(ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        
         taxas.clear(); 
        jCheckBox1.setSelected(false);
        if (jRadioButtonContaFixa.isSelected()) {

            jRadioButtonContaFixaActionPerformed(null);
        } else if (jRadioButtonContaHidrometro.isSelected()) {

            jRadioButtonContaHidrometroActionPerformed(null);
        }
       
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(GContas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(GContas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(GContas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(GContas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GContas().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private JButton jButton1;
    private JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox jComboBox1;
    private com.toedter.calendar.JMonthChooser jMonthChooser1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JRadioButton jRadioButtonContaFixa;
    private javax.swing.JRadioButton jRadioButtonContaHidrometro;
    private javax.swing.JScrollPane jScrollPane1;
    private JTable jTable1;
    private com.toedter.calendar.JYearChooser jYearChooser1;
    // End of variables declaration//GEN-END:variables
}
