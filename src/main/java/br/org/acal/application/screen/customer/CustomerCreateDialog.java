
package br.org.acal.application.screen.customer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

import br.org.acal.application.screen.customer.model.CustomerCreateRequest;
import br.org.acal.commons.util.LocalDateUtil;
import br.org.acal.domain.entity.Address;
import br.org.acal.domain.entity.Customer;
import br.org.acal.domain.usecase.customer.CustomerSaveUseCase;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.val;
import org.jdesktop.swingx.*;

import static javax.swing.JOptionPane.showMessageDialog;

public class CustomerCreateDialog extends JDialog {

    public interface CustomerListener {
        void onClosed();
    }

    private final CustomerSaveUseCase save;
    private final Validator validator;
    private final CustomerListener customerListener;
    private final Customer customer;

    public CustomerCreateDialog(Window owner, Customer customer, Validator validator, CustomerSaveUseCase save, CustomerListener customerListener) {
        super(owner);
        initComponents();

        this.validator = validator;
        this.customer = customer;
        this.save = save;
        this.customerListener = customerListener;

        startItems();
    }

    private void startItems(){
        try {
            MaskFormatter dateFormatter = new MaskFormatter("##/##/####");
            dateFormatter.setPlaceholderCharacter('_');
            textFieldCreatedAt.setFormatterFactory(new DefaultFormatterFactory(dateFormatter));
        } catch (ParseException ignored ) {

        }


        if(customer != null){
            textFieldName.setText(customer.getName());
            textFieldDocument.setText(customer.getDocument().documentNumber());
            textFieldPartner.setText(customer.getPartnerNumber());
            textFieldCreatedAt.setText(LocalDateUtil.localDateToString(customer.getCreatedAt()));
            textFieldPhoneNumber.setText(customer.getPhoneNumber());
        }



    }

    private void saveAction() {
        val request = CustomerCreateRequest.builder()
            .name(getCustomerName())
            .document(getDocumentNumber())
            .partnerNumber(getPartnerNumber())
            .phoneNumber(getPhoneNumber())
            .createdAt(LocalDateUtil.stringToLocalDate(getCreatedAt()))
            .build();

        val violations = validator.validate(request);

        if (!violations.isEmpty()) {
            AtomicInteger counter = new AtomicInteger(1);
            showMessageDialog(this,
                violations.stream().map(
                    violation ->   counter.getAndIncrement() + ": *" + violation.getMessage())
                    .collect(Collectors.joining("\n"))
            );

            return;
        }

        val customerRequest = request.toCustomer();
        if(customer != null ){
            customerRequest.setNumber(customer.getNumber());
        }

        save.execute(customerRequest);
        customerListener.onClosed();
        dispose();
    }

    private String getCustomerName(){
        return textFieldName.getText();
    }

    private String getDocumentNumber(){
        return textFieldDocument.getText();
    }

    private String getPartnerNumber(){
        return textFieldPartner.getText();
    }

    private String getCreatedAt (){
        return textFieldCreatedAt.getText();
    }

    private String getPhoneNumber (){
        return textFieldPhoneNumber.getText();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner non-commercial license
        panel1 = new JPanel();
        panel2 = new JPanel();
        label1 = new JLabel();
        textFieldName = new JTextField();
        panel3 = new JPanel();
        label2 = new JLabel();
        textFieldDocument = new JTextField();
        panel4 = new JPanel();
        label3 = new JLabel();
        textFieldPartner = new JTextField();
        panel5 = new JPanel();
        label4 = new JLabel();
        textFieldCreatedAt = new JFormattedTextField();
        panel6 = new JPanel();
        label5 = new JLabel();
        textFieldPhoneNumber = new JTextField();
        panel7 = new JPanel();
        buttonSave = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== panel1 ========
        {
            panel1.setPreferredSize(new Dimension(640, 320));
            panel1.setBorder(new TitledBorder("S\u00f3cio:"));
            panel1.setLayout(new GridBagLayout());
            ((GridBagLayout)panel1.getLayout()).columnWidths = new int[] {0, 0, 0, 0};
            ((GridBagLayout)panel1.getLayout()).rowHeights = new int[] {0, 0, 0};
            ((GridBagLayout)panel1.getLayout()).columnWeights = new double[] {1.0, 1.0, 1.0, 1.0E-4};
            ((GridBagLayout)panel1.getLayout()).rowWeights = new double[] {0.0, 0.0, 1.0E-4};

            //======== panel2 ========
            {
                panel2.setLayout(new VerticalLayout());

                //---- label1 ----
                label1.setText("Nome:");
                panel2.add(label1);
                panel2.add(textFieldName);
            }
            panel1.add(panel2, new GridBagConstraints(0, 0, 2, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //======== panel3 ========
            {
                panel3.setLayout(new VerticalLayout());

                //---- label2 ----
                label2.setText("Documento:");
                panel3.add(label2);
                panel3.add(textFieldDocument);
            }
            panel1.add(panel3, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 0), 0, 0));

            //======== panel4 ========
            {
                panel4.setLayout(new VerticalLayout());

                //---- label3 ----
                label3.setText("N\u00famero de S\u00f3cio:");
                panel4.add(label3);
                panel4.add(textFieldPartner);
            }
            panel1.add(panel4, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 5), 0, 0));

            //======== panel5 ========
            {
                panel5.setLayout(new VerticalLayout());

                //---- label4 ----
                label4.setText("Data de Matricula:");
                panel5.add(label4);
                panel5.add(textFieldCreatedAt);
            }
            panel1.add(panel5, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 5), 0, 0));

            //======== panel6 ========
            {
                panel6.setLayout(new VerticalLayout());

                //---- label5 ----
                label5.setText("N\u00famero de Telefone:");
                panel6.add(label5);
                panel6.add(textFieldPhoneNumber);
            }
            panel1.add(panel6, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        }
        contentPane.add(panel1, BorderLayout.CENTER);

        //======== panel7 ========
        {
            panel7.setLayout(new GridBagLayout());
            ((GridBagLayout)panel7.getLayout()).columnWidths = new int[] {0, 0, 0, 0, 0};
            ((GridBagLayout)panel7.getLayout()).rowHeights = new int[] {0, 0};
            ((GridBagLayout)panel7.getLayout()).columnWeights = new double[] {1.0, 1.0, 1.0, 1.0, 1.0E-4};
            ((GridBagLayout)panel7.getLayout()).rowWeights = new double[] {0.0, 1.0E-4};

            //---- buttonSave ----
            buttonSave.setText("Salvar");
            buttonSave.addActionListener(e -> saveAction());
            panel7.add(buttonSave, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        }
        contentPane.add(panel7, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner non-commercial license
    private JPanel panel1;
    private JPanel panel2;
    private JLabel label1;
    private JTextField textFieldName;
    private JPanel panel3;
    private JLabel label2;
    private JTextField textFieldDocument;
    private JPanel panel4;
    private JLabel label3;
    private JTextField textFieldPartner;
    private JPanel panel5;
    private JLabel label4;
    private JFormattedTextField textFieldCreatedAt;
    private JPanel panel6;
    private JLabel label5;
    private JTextField textFieldPhoneNumber;
    private JPanel panel7;
    private JButton buttonSave;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}