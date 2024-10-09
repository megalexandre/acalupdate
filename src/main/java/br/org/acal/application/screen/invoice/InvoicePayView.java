package br.org.acal.application.screen.invoice;

import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

import br.org.acal.commons.util.BigDecimalUtil;
import br.org.acal.domain.datasource.DecimalFormatUtil;
import br.org.acal.domain.entity.Invoice;
import lombok.Getter;
import lombok.val;
import org.jdesktop.swingx.*;

import static java.awt.Dialog.ModalityType.APPLICATION_MODAL;


public class InvoicePayView extends JDialog {

    @Getter
    private Invoice invoice;

    public InvoicePayView(Window owner, Invoice invoice) {
        super(owner, APPLICATION_MODAL);
        initComponents();
        this.invoice = invoice;

        textFieldWaterStart.setEnabled(false);
        textFieldWaterEnd.setEnabled(false);

        if(this.invoice.getWaterMeter() != null){
            panelWater.setVisible(true);

            textFieldWaterStart.setText(DecimalFormatUtil.format(this.invoice.getWaterMeter().getConsumptionStart()));
            textFieldWaterEnd.setText(DecimalFormatUtil.format(this.invoice.getWaterMeter().getConsumptionEnd())) ;
        } else {
            panelWater.setVisible(false);
        }

        try {
            starView();
        } catch (Exception ignored){

        }
    }

    private void starView() throws ParseException {
        this.textFieldNumber.setEnabled(false);
        this.textFieldNumber.setText(invoice.getNumber());

        this.textFieldPartner.setEnabled(false);
        this.textFieldPartner.setText(invoice.getLink().getCustomer().getName());

        this.textFieldAddress.setEnabled(false);
        this.textFieldAddress.setText(invoice.getLink().getAddress().getDisplayName());

        this.textFieldValue.setEnabled(false);
        this.textFieldValue.setText(BigDecimalUtil.asString(invoice.totalValue()));
        MaskFormatter maskFormatter = new MaskFormatter("##/##/####");
        maskFormatter.setPlaceholderCharacter('_');

        formattedTextFieldPaymentDate.setFormatterFactory(new DefaultFormatterFactory(maskFormatter));

        if(invoice.getPayedAt() != null){
            formattedTextFieldPaymentDate.setText(invoice.payedAtAsString());
        }
    }

    private void paymentEvent(ActionEvent e) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        val payedAtAsString = formattedTextFieldPaymentDate.getText();
        val payedAt = LocalDate.parse(payedAtAsString, formatter).atTime(LocalTime.now());

        this.invoice.setPayedAt(payedAt);
        this.dispose();
    }

    private void checkBoxToday(ActionEvent e) {
        String today = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        formattedTextFieldPaymentDate.setText(today);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner non-commercial license
        panel1 = new JPanel();
        buttonPayment = new JButton();
        panel2 = new JPanel();
        separator3 = new JSeparator();
        label1 = new JLabel();
        textFieldNumber = new JTextField();
        separator1 = new JSeparator();
        panel3 = new JPanel();
        label2 = new JLabel();
        textFieldPartner = new JTextField();
        label3 = new JLabel();
        textFieldAddress = new JTextField();
        label4 = new JLabel();
        textFieldValue = new JTextField();
        panelWater = new JPanel();
        panel7 = new JPanel();
        label7 = new JLabel();
        textFieldWaterStart = new JTextField();
        panel6 = new JPanel();
        label6 = new JLabel();
        textFieldWaterEnd = new JTextField();
        label5 = new JLabel();
        panel4 = new JPanel();
        checkBox1 = new JCheckBox();
        formattedTextFieldPaymentDate = new JFormattedTextField();
        separator2 = new JSeparator();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== panel1 ========
        {
            panel1.setLayout(new VerticalLayout());

            //---- buttonPayment ----
            buttonPayment.setText("Receber");
            buttonPayment.addActionListener(e -> paymentEvent(e));
            panel1.add(buttonPayment);
        }
        contentPane.add(panel1, BorderLayout.PAGE_END);

        //======== panel2 ========
        {
            panel2.setLayout(new VerticalLayout());
            panel2.add(separator3);

            //---- label1 ----
            label1.setText("N\u00famero da fatura:");
            panel2.add(label1);
            panel2.add(textFieldNumber);
            panel2.add(separator1);
        }
        contentPane.add(panel2, BorderLayout.PAGE_START);

        //======== panel3 ========
        {
            panel3.setPreferredSize(new Dimension(200, 84));
            panel3.setBorder(new TitledBorder("Detalhes"));
            panel3.setLayout(new VerticalLayout());

            //---- label2 ----
            label2.setText("S\u00f3cio:");
            panel3.add(label2);
            panel3.add(textFieldPartner);

            //---- label3 ----
            label3.setText("Endere\u00e7o:");
            panel3.add(label3);
            panel3.add(textFieldAddress);

            //---- label4 ----
            label4.setText("Valor:");
            panel3.add(label4);
            panel3.add(textFieldValue);

            //======== panelWater ========
            {
                panelWater.setLayout(new BoxLayout(panelWater, BoxLayout.X_AXIS));

                //======== panel7 ========
                {
                    panel7.setLayout(new VerticalLayout());

                    //---- label7 ----
                    label7.setText("Medi\u00e7\u00e3o Anterior:");
                    panel7.add(label7);
                    panel7.add(textFieldWaterStart);
                }
                panelWater.add(panel7);

                //======== panel6 ========
                {
                    panel6.setLayout(new VerticalLayout());

                    //---- label6 ----
                    label6.setText("Medi\u00e7\u00e3o Atual:");
                    panel6.add(label6);
                    panel6.add(textFieldWaterEnd);
                }
                panelWater.add(panel6);
            }
            panel3.add(panelWater);

            //---- label5 ----
            label5.setText("Data de Pagamento:");
            panel3.add(label5);

            //======== panel4 ========
            {
                panel4.setLayout(new BoxLayout(panel4, BoxLayout.X_AXIS));

                //---- checkBox1 ----
                checkBox1.setText("Hoje:");
                checkBox1.addActionListener(e -> checkBoxToday(e));
                panel4.add(checkBox1);
                panel4.add(formattedTextFieldPaymentDate);
            }
            panel3.add(panel4);
            panel3.add(separator2);
        }
        contentPane.add(panel3, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner non-commercial license
    private JPanel panel1;
    private JButton buttonPayment;
    private JPanel panel2;
    private JSeparator separator3;
    private JLabel label1;
    private JTextField textFieldNumber;
    private JSeparator separator1;
    private JPanel panel3;
    private JLabel label2;
    private JTextField textFieldPartner;
    private JLabel label3;
    private JTextField textFieldAddress;
    private JLabel label4;
    private JTextField textFieldValue;
    private JPanel panelWater;
    private JPanel panel7;
    private JLabel label7;
    private JTextField textFieldWaterStart;
    private JPanel panel6;
    private JLabel label6;
    private JTextField textFieldWaterEnd;
    private JLabel label5;
    private JPanel panel4;
    private JCheckBox checkBox1;
    private JFormattedTextField formattedTextFieldPaymentDate;
    private JSeparator separator2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
