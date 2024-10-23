
package br.org.acal.application.screen.register;

import br.org.acal.application.screen.register.model.PaymentTable;
import br.org.acal.application.screen.register.model.PaymentTableModel;
import br.org.acal.application.screen.render.StrippedTableCellRenderer;
import br.org.acal.commons.util.BigDecimalUtil;
import br.org.acal.domain.datasource.ReportDataSource;
import br.org.acal.domain.entity.Payment;
import br.org.acal.domain.model.PaymentFilter;
import br.org.acal.domain.usecase.register.PaymentPaginateUseCase;
import br.org.acal.domain.usecase.register.RegisterSearchPrintReportUseCase;
import lombok.val;
import net.sf.jasperreports.engine.JRException;
import org.jdesktop.swingx.HorizontalLayout;
import org.jdesktop.swingx.VerticalLayout;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;

@Component
public class RegisterMainView extends JPanel {

    private final PaymentPaginateUseCase paymentPaginateUseCase;
    private final RegisterSearchPrintReportUseCase printReport;

    public RegisterMainView(
        PaymentPaginateUseCase paymentPaginateUseCase,
        RegisterSearchPrintReportUseCase printReport
    ) {
        initComponents();
        this.paymentPaginateUseCase = paymentPaginateUseCase;
        this.printReport = printReport;

        textPatter(formattedTextFieldDateStart);
        textPatter(formattedTextFieldDateEnd);
    }

    private void start(){
        search();
    }

    private void search(){
        val paymentFilter = PaymentFilter.builder().createdAtStart(getDateStart()).createAtEnd(getDateEnd()).build();
        val paymentsData = paymentPaginateUseCase.execute(paymentFilter);
        val payments = paymentsData.stream().map(PaymentTable::of).toList() ;
        val tableModel = new PaymentTableModel(payments);

        table.setModel(tableModel);
        val render = new StrippedTableCellRenderer();

        table.setDefaultRenderer(String.class, render);

        labelQuantity.setText("Quantidade:" + payments.size() + " ");
        BigDecimal total = paymentsData.stream().map(Payment::getValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        labelTotal.setText("Total:  " + BigDecimalUtil.asString(total));

        if(paymentsData.isEmpty()){
            showDialog();
        }
    }

    private void textPatter(JFormattedTextField field){
        try {

            MaskFormatter dateMask = new MaskFormatter("##/##/####");
            dateMask.setPlaceholderCharacter('_');
            field.setFormatterFactory(new DefaultFormatterFactory(dateMask));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private void buttonSearchAction(ActionEvent e) {
        start();
    }

    private LocalDateTime cast(String text){

        try {
            return LocalDate.parse(text, DateTimeFormatter.ofPattern("dd/MM/yyyy")).atStartOfDay();
        } catch (Exception ex) {
            return null;
        }
    }

    private void todayAction(ActionEvent e) {
        String text = DateTimeFormatter.ofPattern("dd/MM/yyyy").format(LocalDate.now());

        formattedTextFieldDateStart.setText(text);
        formattedTextFieldDateEnd.setText(text);
        search();
    }

    private void clearAction() {
        clear();
    }

    private void clear(){
        formattedTextFieldDateStart.setText("");
        formattedTextFieldDateEnd.setText("");
        table.setModel(new PaymentTableModel(List.of()));
    }

    private void printEvent() {

        try {
            val build = PaymentFilter.builder().createdAtStart(getDateStart()).createAtEnd(getDateEnd()).build();
            printReport.execute(build);
        } catch (Exception ignored){}

    }

    private LocalDateTime getDateStart(){
        return cast(formattedTextFieldDateStart.getText());
    }

    private LocalDateTime getDateEnd(){
        return cast(formattedTextFieldDateEnd.getText());
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner non-commercial license
        registerMainView = new JTabbedPane();
        panel2 = new JPanel();
        scrollPane = new JScrollPane();
        table = new JTable();
        panel1 = new JPanel();
        panel4 = new JPanel();
        panel3 = new JPanel();
        labelQuantity = new JLabel();
        labelTotal = new JLabel();
        panel5 = new JPanel();
        panel6 = new JPanel();
        label1 = new JLabel();
        formattedTextFieldDateStart = new JFormattedTextField();
        label2 = new JLabel();
        formattedTextFieldDateEnd = new JFormattedTextField();
        buttonPrint = new JButton();
        buttonToday = new JButton();
        buttonClear = new JButton();
        buttonSearch = new JButton();

        //======== this ========
        setLayout(new BorderLayout());

        //======== registerMainView ========
        {

            //======== panel2 ========
            {
                panel2.setLayout(new BorderLayout());

                //======== scrollPane ========
                {
                    scrollPane.setViewportView(table);
                }
                panel2.add(scrollPane, BorderLayout.CENTER);

                //======== panel1 ========
                {
                    panel1.setLayout(new VerticalLayout());

                    //======== panel4 ========
                    {
                        panel4.setLayout(new BorderLayout());

                        //======== panel3 ========
                        {
                            panel3.setLayout(new HorizontalLayout());

                            //---- labelQuantity ----
                            labelQuantity.setText("text");
                            panel3.add(labelQuantity);

                            //---- labelTotal ----
                            labelTotal.setText("text");
                            panel3.add(labelTotal);
                        }
                        panel4.add(panel3, BorderLayout.CENTER);

                        //======== panel5 ========
                        {
                            panel5.setLayout(new HorizontalLayout());

                            //======== panel6 ========
                            {
                                panel6.setLayout(new HorizontalLayout());

                                //---- label1 ----
                                label1.setText("In\u00edcio:");
                                panel6.add(label1);

                                //---- formattedTextFieldDateStart ----
                                formattedTextFieldDateStart.setPreferredSize(new Dimension(100, 34));
                                panel6.add(formattedTextFieldDateStart);

                                //---- label2 ----
                                label2.setText("Final");
                                panel6.add(label2);

                                //---- formattedTextFieldDateEnd ----
                                formattedTextFieldDateEnd.setPreferredSize(new Dimension(100, 34));
                                panel6.add(formattedTextFieldDateEnd);
                            }
                            panel5.add(panel6);

                            //---- buttonPrint ----
                            buttonPrint.setText("Imprimir");
                            buttonPrint.addActionListener(e -> printEvent());
                            panel5.add(buttonPrint);

                            //---- buttonToday ----
                            buttonToday.setText("Hoje");
                            buttonToday.addActionListener(e -> todayAction(e));
                            panel5.add(buttonToday);

                            //---- buttonClear ----
                            buttonClear.setText("Limpar");
                            buttonClear.addActionListener(e -> clearAction());
                            panel5.add(buttonClear);

                            //---- buttonSearch ----
                            buttonSearch.setText("Consultar");
                            buttonSearch.addActionListener(e -> buttonSearchAction(e));
                            panel5.add(buttonSearch);
                        }
                        panel4.add(panel5, BorderLayout.EAST);
                    }
                    panel1.add(panel4);
                }
                panel2.add(panel1, BorderLayout.SOUTH);
            }
            registerMainView.addTab("Hoje:", panel2);
        }
        add(registerMainView, BorderLayout.CENTER);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    private void showDialog(){
        showMessageDialog(this,
                "Nenhum dado para os parametros",
                "Sem Resultado",
                INFORMATION_MESSAGE);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner non-commercial license
    private JTabbedPane registerMainView;
    private JPanel panel2;
    private JScrollPane scrollPane;
    private JTable table;
    private JPanel panel1;
    private JPanel panel4;
    private JPanel panel3;
    private JLabel labelQuantity;
    private JLabel labelTotal;
    private JPanel panel5;
    private JPanel panel6;
    private JLabel label1;
    private JFormattedTextField formattedTextFieldDateStart;
    private JLabel label2;
    private JFormattedTextField formattedTextFieldDateEnd;
    private JButton buttonPrint;
    private JButton buttonToday;
    private JButton buttonClear;
    private JButton buttonSearch;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
