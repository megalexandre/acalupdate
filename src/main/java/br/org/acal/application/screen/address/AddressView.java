package br.org.acal.application.screen.address;

import br.org.acal.application.screen.render.StripperRender;
import br.org.acal.commons.enumeration.AddressType;
import br.org.acal.domain.model.Address;
import br.org.acal.domain.repository.AddressDataSource;
import lombok.val;
import org.jdesktop.swingx.HorizontalLayout;
import org.jdesktop.swingx.VerticalLayout;
import org.springframework.stereotype.Component;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static java.util.stream.IntStream.range;


@Component
public class AddressView extends JPanel implements Serializable {
    private final AddressDataSource addressDataSource;
    private List<Address> addresses;
    private Address address;
    private final int LIST_INDEX = 0;
    private final int DETAIL_INDEX = 1;

    public AddressView(
        AddressDataSource addressDataSource
    ) {
        initComponents();
        start();
        this.addressDataSource = addressDataSource;
    }

    private void start(){
        Arrays.stream(AddressType.values()).forEach(item ->
            this.addressType.addItem(item.getDescription())
        );
        addressType.setSelectedItem(null);
        detailPanel.setMaximumSize(new Dimension(800,Integer.MAX_VALUE));
    }

    private void find(ActionEvent e) {
       find();
    }

    private void find(){
        this.addresses = addressDataSource.findAll();
        val addressTableModel = new AddressTableModel(addresses.stream().map(AddressTable::of).toList());

        table.setModel(addressTableModel);
        val customRenderer = new StripperRender();

        range(0, table.getColumnCount()).forEach(i ->
            table.getColumnModel().getColumn(i).setCellRenderer(customRenderer)
        );
        tabbedPane1.setSelectedIndex(LIST_INDEX);
    }

    private void clear(ActionEvent e) {
        table.setModel(new AddressTableModel(List.of()));
    }

    private void tableMouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2 && e.getButton() == MouseEvent.BUTTON1) {
            val target = (JTable) e.getSource();
            val row = target.getSelectedRow();
            this.address = addresses.get(row);
            startDetail(address);
            setSelectedTab(DETAIL_INDEX);
        }
    }

    private void setSelectedTab(int index){
        tabbedPane1.setSelectedIndex(index);
    }

    private void startDetail(Address address){
        addressName.setText(address.getName());
        addressType.setSelectedItem(address.getType());
    }

    private void back(ActionEvent e) {
        address = null;
        addressName.setText(null);
        addressType.setSelectedItem(null);
        find();
    }

    private void save(ActionEvent e) {
        val item = Address.builder()
                .name(addressName.getText())
                .type(addressType.getSelectedItem().toString()
            ).build();

        addressDataSource.save(item);
        find();
        setSelectedTab(LIST_INDEX);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner non-commercial license
        tabbedPane1 = new JTabbedPane();
        listaTab = new JPanel();
        scrollPane1 = new JScrollPane();
        table = new JTable();
        panel2 = new JPanel();
        label1 = new JLabel();
        textField1 = new JTextField();
        panel3 = new JPanel();
        findButton = new JButton();
        clearButton = new JButton();
        DetailTab = new JPanel();
        detailPanel = new JPanel();
        panel4 = new JPanel();
        label2 = new JLabel();
        addressType = new JComboBox();
        panel5 = new JPanel();
        label3 = new JLabel();
        addressName = new JTextField();
        panel7 = new JPanel();
        buttonConfirm = new JButton();
        buttonBack = new JButton();

        //======== this ========
        setLayout(new GridLayout());

        //======== tabbedPane1 ========
        {

            //======== listaTab ========
            {
                listaTab.setLayout(new BorderLayout());

                //======== scrollPane1 ========
                {

                    //---- table ----
                    table.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            tableMouseClicked(e);
                        }
                    });
                    scrollPane1.setViewportView(table);
                }
                listaTab.add(scrollPane1, BorderLayout.CENTER);

                //======== panel2 ========
                {
                    panel2.setBorder(new EmptyBorder(5, 5, 5, 5));
                    panel2.setLayout(new BorderLayout());

                    //---- label1 ----
                    label1.setText("Nome");
                    panel2.add(label1, BorderLayout.WEST);
                    panel2.add(textField1, BorderLayout.CENTER);

                    //======== panel3 ========
                    {
                        panel3.setLayout(new HorizontalLayout());

                        //---- findButton ----
                        findButton.setText("Pesquisar");
                        findButton.addActionListener(e -> find(e));
                        panel3.add(findButton);

                        //---- clearButton ----
                        clearButton.setText("Limpar");
                        clearButton.addActionListener(e -> clear(e));
                        panel3.add(clearButton);
                    }
                    panel2.add(panel3, BorderLayout.EAST);
                }
                listaTab.add(panel2, BorderLayout.SOUTH);
            }
            tabbedPane1.addTab("Lista", listaTab);

            //======== DetailTab ========
            {
                DetailTab.setBorder(new EmptyBorder(5, 5, 5, 5));
                DetailTab.setLayout(new BorderLayout());

                //======== detailPanel ========
                {
                    detailPanel.setLayout(new VerticalLayout());

                    //======== panel4 ========
                    {
                        panel4.setLayout(new VerticalLayout());

                        //---- label2 ----
                        label2.setText("Tipo:");
                        panel4.add(label2);
                        panel4.add(addressType);
                    }
                    detailPanel.add(panel4);

                    //======== panel5 ========
                    {
                        panel5.setLayout(new VerticalLayout());

                        //---- label3 ----
                        label3.setText("Nome:");
                        panel5.add(label3);
                        panel5.add(addressName);
                    }
                    detailPanel.add(panel5);
                }
                DetailTab.add(detailPanel, BorderLayout.CENTER);

                //======== panel7 ========
                {
                    panel7.setLayout(new BorderLayout());

                    //---- buttonConfirm ----
                    buttonConfirm.setText("Confirmar");
                    buttonConfirm.addActionListener(e -> save(e));
                    panel7.add(buttonConfirm, BorderLayout.WEST);

                    //---- buttonBack ----
                    buttonBack.setText("cancelar");
                    buttonBack.addActionListener(e -> back(e));
                    panel7.add(buttonBack, BorderLayout.EAST);
                }
                DetailTab.add(panel7, BorderLayout.SOUTH);
            }
            tabbedPane1.addTab("Detalhe", DetailTab);
        }
        add(tabbedPane1);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner non-commercial license
    private JTabbedPane tabbedPane1;
    private JPanel listaTab;
    private JScrollPane scrollPane1;
    private JTable table;
    private JPanel panel2;
    private JLabel label1;
    private JTextField textField1;
    private JPanel panel3;
    private JButton findButton;
    private JButton clearButton;
    private JPanel DetailTab;
    private JPanel detailPanel;
    private JPanel panel4;
    private JLabel label2;
    private JComboBox addressType;
    private JPanel panel5;
    private JLabel label3;
    private JTextField addressName;
    private JPanel panel7;
    private JButton buttonConfirm;
    private JButton buttonBack;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
