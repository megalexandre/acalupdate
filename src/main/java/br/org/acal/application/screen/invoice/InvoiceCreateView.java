package br.org.acal.application.screen.invoice;

import br.org.acal.application.screen.invoice.model.table.CreateInvoiceTable;
import br.org.acal.application.screen.invoice.model.table.CreateInvoiceTableModel;
import br.org.acal.commons.util.LocalDateTimeUtil;
import br.org.acal.domain.entity.Period;
import br.org.acal.domain.entity.WaterMeter;
import br.org.acal.domain.usecase.invoice.CreateInvoiceUseCase;
import br.org.acal.domain.usecase.invoice.InvoiceSaveAllUseCase;
import lombok.val;
import org.jdesktop.swingx.HorizontalLayout;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableColumn;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class InvoiceCreateView extends JPanel {

    private boolean select = true;
    private final CreateInvoiceUseCase createInvoiceUseCase;
    private final InvoiceSaveAllUseCase invoiceSaveAllUseCase;

    public InvoiceCreateView(
            CreateInvoiceUseCase createInvoiceUseCase,
            InvoiceSaveAllUseCase invoiceSaveAllUseCase
    ) {
        initComponents();
        this.createInvoiceUseCase = createInvoiceUseCase;
        this.invoiceSaveAllUseCase = invoiceSaveAllUseCase;
        createFormattedDateField();
    }

    public void clear(){
        table.setModel(new CreateInvoiceTableModel(List.of()));
        formattedDueDate.setText("");
        formattedTextFieldPeriod.setText("");
    }


    private void createTable(){
        val localDateTime = getDuoDate(formattedTextFieldPeriod.getText());
        val period = Period.builder()
                .month(localDateTime.getMonth())
                .year(localDateTime.getYear())
                .build();

        var invoices = createInvoiceUseCase.execute(period);
        val tableModel = new CreateInvoiceTableModel(invoices.stream().map(CreateInvoiceTable::of).toList());
        table.setModel(tableModel);

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
        val duoDate = getDuoDate(formattedDueDate.getText());
        val period = getPeriod(formattedTextFieldPeriod.getText());

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

    private LocalDateTime getDuoDate(String date) {
        if (date.length() == 7) {
            date = "01/" + date;
        }
        return LocalDateTimeUtil.stringToLocalDateTime(date);
    }

    private LocalDateTime getPeriod(String date) {
        if (date.length() == 7) {
            date = "01/" + date;
        }
        return LocalDateTimeUtil.stringToLocalDateTime(date);
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


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner non-commercial license
        panel1 = new JPanel();
        scrollPane1 = new JScrollPane();
        table = new JTable();
        panel2 = new JPanel();
        panel4 = new JPanel();
        label1 = new JLabel();
        formattedDueDate = new JFormattedTextField();
        label2 = new JLabel();
        formattedTextFieldPeriod = new JFormattedTextField();
        panel3 = new JPanel();
        Confirmar = new JButton();
        buttonSelection = new JButton();
        buttonCreate = new JButton();

        //======== this ========
        setAlignmentY(1.0F);
        setAlignmentX(1.0F);
        setLayout(new GridBagLayout());
        ((GridBagLayout)getLayout()).columnWidths = new int[] {0, 0};
        ((GridBagLayout)getLayout()).rowHeights = new int[] {0, 0, 0};
        ((GridBagLayout)getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
        ((GridBagLayout)getLayout()).rowWeights = new double[] {0.0, 0.0, 1.0E-4};

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

        //======== panel2 ========
        {
            panel2.setBorder(new TitledBorder("Op\u00e7\u00f5es"));
            panel2.setAlignmentX(1.0F);
            panel2.setAlignmentY(1.0F);
            panel2.setLayout(new BorderLayout());

            //======== panel4 ========
            {
                panel4.setLayout(new HorizontalLayout());

                //---- label1 ----
                label1.setText("Vencimento:");
                panel4.add(label1);

                //---- formattedDueDate ----
                formattedDueDate.setToolTipText("Vencimento");
                panel4.add(formattedDueDate);

                //---- label2 ----
                label2.setText("Periodo");
                panel4.add(label2);
                panel4.add(formattedTextFieldPeriod);
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
    private JPanel panel2;
    private JPanel panel4;
    private JLabel label1;
    private JFormattedTextField formattedDueDate;
    private JLabel label2;
    private JFormattedTextField formattedTextFieldPeriod;
    private JPanel panel3;
    private JButton Confirmar;
    private JButton buttonSelection;
    private JButton buttonCreate;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
