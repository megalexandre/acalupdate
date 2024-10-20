package br.org.acal.application.screen.address.crud.create;

import javax.swing.border.*;
import br.org.acal.application.screen.address.model.CreateAddress;
import br.org.acal.commons.enumeration.AddressType;
import br.org.acal.domain.entity.Address;
import lombok.val;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;

import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;

public class AddressCreateView extends JDialog {

    public interface AddressListener {
        void onAddressSaved(Address address);
    }

    private final Address address;
    private final AddressListener addressListener;

    public AddressCreateView(Window owner, Address address, AddressListener addressListener) {
        super(owner);
        initComponents();
        this.address = address;
        this.addressListener = addressListener;
        startValues();
    }

    public void startValues(){
        Arrays.stream(AddressType.values()).forEach(item ->
            this.comboBoxAddressType.addItem(item.getDescription())
        );
        comboBoxAddressType.setSelectedItem(null);

        if(address != null){
            textFieldName.setText(address.getName());
            comboBoxAddressType.setSelectedItem(address.getType());
        }

    }

    private void saveAction() {
        val item = CreateAddress.builder()
                .name(getAddressName())
                .type(getAddressType())
                .build();

        if(item.isValid()){

            val address = item.toAddress();
            address.setNumber(getAddressNumber());
            addressListener.onAddressSaved(address);
            this.dispose();

        } else {
            showMessage();
        }
    }

    private void showMessage(){
        showMessageDialog(this, "Preencha todos os campos", "Campos invalidos", INFORMATION_MESSAGE);
    }

    private String getAddressName(){
        return textFieldName.getText();
    }

    private String getAddressType(){
        return comboBoxAddressType.getSelectedItem() != null ? comboBoxAddressType.getSelectedItem().toString() : null;
    }

    private String getAddressNumber(){
        return address == null ? null : address.getNumber();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner non-commercial license
        panel1 = new JPanel();
        label1 = new JLabel();
        comboBoxAddressType = new JComboBox<>();
        label2 = new JLabel();
        textFieldName = new JTextField();
        panel2 = new JPanel();
        buttonSave = new JButton();

        //======== this ========
        setPreferredSize(new Dimension(320, 150));
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== panel1 ========
        {
            panel1.setBorder(new TitledBorder("Endere\u00e7o"));
            panel1.setLayout(new GridBagLayout());
            ((GridBagLayout)panel1.getLayout()).columnWidths = new int[] {0, 0, 0};
            ((GridBagLayout)panel1.getLayout()).rowHeights = new int[] {0, 0, 0};
            ((GridBagLayout)panel1.getLayout()).columnWeights = new double[] {0.0, 1.0, 1.0E-4};
            ((GridBagLayout)panel1.getLayout()).rowWeights = new double[] {0.0, 0.0, 1.0E-4};

            //---- label1 ----
            label1.setText("Tipo:");
            panel1.add(label1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));
            panel1.add(comboBoxAddressType, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 0), 0, 0));

            //---- label2 ----
            label2.setText("Nome:");
            panel1.add(label2, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 5), 0, 0));
            panel1.add(textFieldName, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        }
        contentPane.add(panel1, BorderLayout.CENTER);

        //======== panel2 ========
        {
            panel2.setLayout(new BorderLayout());

            //---- buttonSave ----
            buttonSave.setText("Salvar");
            buttonSave.addActionListener(e -> saveAction());
            panel2.add(buttonSave, BorderLayout.EAST);
        }
        contentPane.add(panel2, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner non-commercial license
    private JPanel panel1;
    private JLabel label1;
    private JComboBox<String> comboBoxAddressType;
    private JLabel label2;
    private JTextField textFieldName;
    private JPanel panel2;
    private JButton buttonSave;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
