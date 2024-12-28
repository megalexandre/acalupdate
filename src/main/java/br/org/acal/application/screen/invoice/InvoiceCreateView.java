package br.org.acal.application.screen.invoice;

import br.org.acal.application.components.combobox.JComboBoxModel;
import br.org.acal.application.screen.invoice.model.table.CreateInvoiceTable;
import br.org.acal.application.screen.invoice.model.table.CreateInvoiceTableModel;
import br.org.acal.commons.util.LocalDateTimeUtil;
import br.org.acal.domain.entity.Period;
import br.org.acal.domain.entity.WaterMeter;
import br.org.acal.domain.usecase.address.AddressFindUseCase;
import br.org.acal.domain.usecase.invoice.InvoiceCreateUseCase;
import br.org.acal.domain.usecase.invoice.InvoiceSaveAllUseCase;
import lombok.val;
import org.jdesktop.swingx.HorizontalLayout;
import org.jdesktop.swingx.VerticalLayout;
import org.springframework.stereotype.Component;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.table.TableColumn;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;

@Component
public class InvoiceCreateView extends JPanel {

    private boolean select = true;
    private final InvoiceCreateUseCase invoiceCreateUseCase;
    private final InvoiceSaveAllUseCase invoiceSaveAllUseCase;
    private final AddressFindUseCase addressFindUsecase;
    private final String hasHydrometer = "Com Hidrômetro";
    private final String hasNoHydrometer = "Sem Hidrômetro";
    private final String allHydrometer = "Todos";
    private String selectedAddress = "";

    public InvoiceCreateView(
            InvoiceCreateUseCase invoiceCreateUseCase,
            InvoiceSaveAllUseCase invoiceSaveAllUseCase,
            AddressFindUseCase addressFindUsecase
    ) {
        initComponents();
        loadComponents();
        this.invoiceCreateUseCase = invoiceCreateUseCase;
        this.invoiceSaveAllUseCase = invoiceSaveAllUseCase;
        this.addressFindUsecase = addressFindUsecase;
        createFormattedDateField();
    }

    private void loadComponents(){

        comboBoxAddress.addItem(JComboBoxModel.clearData());
        comboBoxAddress.addActionListener(e -> {
            var item = (JComboBoxModel) comboBoxAddress.getSelectedItem();
            if (item != null) {
                selectedAddress = ((JComboBoxModel) comboBoxAddress.getSelectedItem()).getNumber();
            }
        });

        comboBoxHydrometer.addItem(allHydrometer);
        comboBoxHydrometer.addItem(hasHydrometer);
        comboBoxHydrometer.addItem(hasNoHydrometer);
    }

    public void clear(){
        table.setModel(new CreateInvoiceTableModel(List.of()));
        formattedDueDate.setText("");
        formattedTextFieldPeriod.setText("");
    }


    private void createTable(){
        val localDateTime = getPeriod();
        if(localDateTime == null){
            showMessage("Selecione o periodo");
            return;
        }

        val duoDate = getDuoDate();
        if(duoDate == null){
            showMessage("Selecione o vencimento");
            return;
        }

        val period = Period.builder()
                .month(localDateTime.getMonth())
                .year(localDateTime.getYear())
                .build();

        var invoices = invoiceCreateUseCase.execute(period);

        /** @TODO
        *   isso deveria ser movido para o filtro. mas não há tempo agora.
        * */
        if(!selectedAddress.isEmpty()){
            invoices = invoices.stream()
                    .filter(it -> it.getLink().getAddress().getNumber().equals(selectedAddress))
                    .toList();
        }

        if(comboBoxHydrometer.getSelectedItem() != allHydrometer ){

            if(comboBoxHydrometer.getSelectedItem() == hasNoHydrometer){
                invoices = invoices.stream().filter(it -> !it.getLink().getCategory().isHydrometer()).toList();

            } else if(comboBoxHydrometer.getSelectedItem() == hasHydrometer){

                invoices = invoices.stream().filter(it -> it.getLink().getCategory().isHydrometer()).toList();

            }
        }

        val tableModel = new CreateInvoiceTableModel(invoices.stream().map(CreateInvoiceTable::of).toList());
        table.setModel(tableModel);

        labelDetail.setText(invoices.size() + " items:");
        configureDecimalColumns();
    }

    private void configureDecimalColumns() {
        NumberFormat decimalFormat = DecimalFormat.getNumberInstance();
        decimalFormat.setMinimumFractionDigits(0);
        decimalFormat.setMaximumFractionDigits(0);

        NumberFormatter decimalFormatter = new NumberFormatter(decimalFormat);
        decimalFormatter.setValueClass(Double.class);
        decimalFormatter.setAllowsInvalid(false);
        decimalFormatter.setMinimum(0.0);

        JFormattedTextField decimalField = new JFormattedTextField(decimalFormatter);
        decimalField.setFocusLostBehavior(JFormattedTextField.COMMIT);

        TableColumn waterStartColumn = table.getColumnModel().getColumn(5);
        TableColumn waterEndColumn = table.getColumnModel().getColumn(6);
        waterStartColumn.setCellEditor(new DefaultCellEditor(decimalField));
        waterEndColumn.setCellEditor(new DefaultCellEditor(decimalField));
    }


    private void findAction(ActionEvent e) {
        createTable();
    }

    private void selectionEvent(ActionEvent e) {
        val model = (CreateInvoiceTableModel) table.getModel();
        model.items.forEach(it -> it.setChecked(select));
        model.fireTableDataChanged();

        select = !select;
    }

    private void createEvent(ActionEvent e) {
        val duoDate = getDuoDate();
        val period = getPeriod();

        val model = (CreateInvoiceTableModel) table.getModel();
        val invoices = model.items.stream()
            .filter(CreateInvoiceTable::isChecked)
            .map(it -> {

                val water = WaterMeter.builder()
                    .consumptionStart(it.getWaterStartAsDouble())
                    .consumptionEnd(it.getWaterEndAsDouble())
                    .build();

                val invoice = it.getInvoice();
                invoice.setDueDate(duoDate);
                invoice.setPeriod(period);
                invoice.setWaterMeter(water);

                return invoice;
            })
            .toList();

        invoiceSaveAllUseCase.execute(invoices);
        createTable();
        model.fireTableDataChanged();
    }

    private void createFormattedDateField() {
        try {
            MaskFormatter dateMask = new MaskFormatter("##/##/####");
            dateMask.setPlaceholderCharacter(' ');
            dateMask.install(formattedDueDate);

            MaskFormatter periodMask = new MaskFormatter("##/####");
            periodMask.setPlaceholderCharacter(' ');
            periodMask.install(formattedTextFieldPeriod);

        } catch (ParseException ignored) {
        }
    }

    private void showMessage(String message){
        showMessageDialog(this, message, "Campos invalidos", INFORMATION_MESSAGE);
    }

    private LocalDateTime getPeriod(){
        val text = formattedTextFieldPeriod.getText()
                .replace(" ","")
                .replace("/", "");

        if(text.isEmpty()){
            return null;
        }

        var date = formattedTextFieldPeriod.getText();
        if (date.length() == 7) {
            date = "01/" + date;
        }

        return LocalDateTimeUtil.stringToLocalDateTime(date);
    }


    private LocalDateTime getDuoDate(){
        var text = formattedDueDate.getText()
                .replace(" ", "")
                .replace("//", "");

        if(text.isEmpty()){
            return null;
        }

        var date = formattedDueDate.getText();
        if (date.length() == 7) {
            date = "01/" + date;
        }

        return LocalDateTimeUtil.stringToLocalDateTime(date);
    }

    private void comboBoxAddressPopupMenuWillBecomeVisible() {
        if(comboBoxAddress.getItemCount() <= 1){
            Optional.ofNullable(addressFindUsecase.execute(null)).ifPresent(data ->
                data.forEach(item -> comboBoxAddress.addItem(JComboBoxModel.of(item)))
            );
        }
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner non-commercial license
        panel1 = new JPanel();
        scrollPane1 = new JScrollPane();
        table = new JTable();
        panel6 = new JPanel();
        label3 = new JLabel();
        labelDetail = new JLabel();
        panel2 = new JPanel();
        panel4 = new JPanel();
        period = new JPanel();
        label2 = new JLabel();
        formattedTextFieldPeriod = new JFormattedTextField();
        duodate = new JPanel();
        label1 = new JLabel();
        formattedDueDate = new JFormattedTextField();
        street = new JPanel();
        Rua = new JLabel();
        comboBoxAddress = new JComboBox<>();
        hasHydromter = new JPanel();
        Rua2 = new JLabel();
        comboBoxHydrometer = new JComboBox<>();
        panel3 = new JPanel();
        Confirmar = new JButton();
        buttonSelection = new JButton();
        buttonCreate = new JButton();

        //======== this ========
        setAlignmentY(1.0F);
        setAlignmentX(1.0F);
        setLayout(new GridBagLayout());
        ((GridBagLayout)getLayout()).columnWidths = new int[] {0, 0};
        ((GridBagLayout)getLayout()).rowHeights = new int[] {0, 0, 0, 0};
        ((GridBagLayout)getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
        ((GridBagLayout)getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 1.0E-4};

        //======== panel1 ========
        {
            panel1.setPreferredSize(new Dimension(452, 800));
            panel1.setAlignmentX(1.0F);
            panel1.setAlignmentY(1.0F);
            panel1.setLayout(new BorderLayout());

            //======== scrollPane1 ========
            {
                scrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
                scrollPane1.setAlignmentX(1.0F);
                scrollPane1.setAlignmentY(1.0F);

                //---- table ----
                table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                scrollPane1.setViewportView(table);
            }
            panel1.add(scrollPane1, BorderLayout.CENTER);
        }
        add(panel1, new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));

        //======== panel6 ========
        {
            panel6.setLayout(new VerticalLayout());

            //---- label3 ----
            label3.setText("Detalhes");
            panel6.add(label3);
            panel6.add(labelDetail);
        }
        add(panel6, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
            GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
            new Insets(0, 0, 0, 0), 0, 0));

        //======== panel2 ========
        {
            panel2.setBorder(new TitledBorder("Op\u00e7\u00f5es"));
            panel2.setAlignmentX(1.0F);
            panel2.setAlignmentY(1.0F);
            panel2.setLayout(new BorderLayout());

            //======== panel4 ========
            {
                panel4.setLayout(new HorizontalLayout());

                //======== period ========
                {
                    period.setPreferredSize(new Dimension(200, 51));
                    period.setLayout(new VerticalLayout());

                    //---- label2 ----
                    label2.setText("Periodo:");
                    period.add(label2);
                    period.add(formattedTextFieldPeriod);
                }
                panel4.add(period);

                //======== duodate ========
                {
                    duodate.setPreferredSize(new Dimension(200, 51));
                    duodate.setLayout(new VerticalLayout());

                    //---- label1 ----
                    label1.setText("Vencimento:");
                    duodate.add(label1);

                    //---- formattedDueDate ----
                    formattedDueDate.setToolTipText("Vencimento");
                    duodate.add(formattedDueDate);
                }
                panel4.add(duodate);

                //======== street ========
                {
                    street.setPreferredSize(new Dimension(200, 51));
                    street.setLayout(new VerticalLayout());

                    //---- Rua ----
                    Rua.setText("Rua:");
                    street.add(Rua);

                    //---- comboBoxAddress ----
                    comboBoxAddress.addPopupMenuListener(new PopupMenuListener() {
                        @Override
                        public void popupMenuCanceled(PopupMenuEvent e) {}
                        @Override
                        public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {}
                        @Override
                        public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
                            comboBoxAddressPopupMenuWillBecomeVisible();
                        }
                    });
                    street.add(comboBoxAddress);
                }
                panel4.add(street);

                //======== hasHydromter ========
                {
                    hasHydromter.setLayout(new VerticalLayout());

                    //---- Rua2 ----
                    Rua2.setText("Hidr\u00f4metro");
                    hasHydromter.add(Rua2);
                    hasHydromter.add(comboBoxHydrometer);
                }
                panel4.add(hasHydromter);
            }
            panel2.add(panel4, BorderLayout.WEST);

            //======== panel3 ========
            {
                panel3.setLayout(new HorizontalLayout());

                //---- Confirmar ----
                Confirmar.setText("Buscar");
                Confirmar.addActionListener(e -> findAction(e));
                panel3.add(Confirmar);

                //---- buttonSelection ----
                buttonSelection.setText("Alternar Sele\u00e7\u00e3o");
                buttonSelection.addActionListener(e -> selectionEvent(e));
                panel3.add(buttonSelection);

                //---- buttonCreate ----
                buttonCreate.setText("Gerar");
                buttonCreate.addActionListener(e -> createEvent(e));
                panel3.add(buttonCreate);
            }
            panel2.add(panel3, BorderLayout.EAST);
        }
        add(panel2, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner non-commercial license
    private JPanel panel1;
    private JScrollPane scrollPane1;
    private JTable table;
    private JPanel panel6;
    private JLabel label3;
    private JLabel labelDetail;
    private JPanel panel2;
    private JPanel panel4;
    private JPanel period;
    private JLabel label2;
    private JFormattedTextField formattedTextFieldPeriod;
    private JPanel duodate;
    private JLabel label1;
    private JFormattedTextField formattedDueDate;
    private JPanel street;
    private JLabel Rua;
    private JComboBox<JComboBoxModel> comboBoxAddress;
    private JPanel hasHydromter;
    private JLabel Rua2;
    private JComboBox<String> comboBoxHydrometer;
    private JPanel panel3;
    private JButton Confirmar;
    private JButton buttonSelection;
    private JButton buttonCreate;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
