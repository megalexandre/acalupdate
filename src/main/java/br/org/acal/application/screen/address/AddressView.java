package br.org.acal.application.screen.address;

import br.org.acal.application.screen.address.model.CreateAddress;
import br.org.acal.application.screen.render.StripperRender;
import br.org.acal.commons.enumeration.AddressType;
import br.org.acal.domain.entity.Address;
import br.org.acal.domain.usecase.address.DeleteAddressUsecase;
import br.org.acal.domain.usecase.address.FindAllAddressUsecase;
import br.org.acal.domain.usecase.address.SaveAddressUsecase;
import lombok.val;
import org.jdesktop.swingx.HorizontalLayout;
import org.jdesktop.swingx.VerticalLayout;
import org.springframework.stereotype.Component;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.IntStream.range;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;


@Component
public class AddressView extends JPanel implements Serializable {
    private final DeleteAddressUsecase delete;
    private final FindAllAddressUsecase findAll;
    private final SaveAddressUsecase save;
    private List<Address> addresses;
    private Address address;
    public AddressTable addresTable;
    private final int LIST_INDEX = 0;
    private final int DETAIL_INDEX = 1;

    public AddressView(
        DeleteAddressUsecase delete,
        FindAllAddressUsecase findAll,
        SaveAddressUsecase save
    ) {
        initComponents();
        start();
        this.delete = delete;
        this.findAll = findAll;
        this.save = save;
    }

    private void start(){
        Arrays.stream(AddressType.values()).forEach(item ->
            this.addressType.addItem(item.getDescription())
        );
        addressType.setSelectedItem(null);

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                showPopup(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                showPopup(e);
            }

            private void showPopup(MouseEvent e) {
                if (e.isPopupTrigger() && e.getComponent() instanceof JTable) {
                    int row = table.rowAtPoint(e.getPoint());
                    int column = table.columnAtPoint(e.getPoint());

                    if (!table.isRowSelected(row)) {
                        table.setRowSelectionInterval(row, row);
                    }
                    if (!table.isColumnSelected(column)) {
                        table.setColumnSelectionInterval(column, column);
                    }

                    address = addresses.get(row);
                    contextMenu.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });

    }

    private void find(ActionEvent e) {
       find();
    }

    private void find(){
        this.addresses = findAll.execute(null);
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

        val type = addressType.getSelectedItem() != null ? addressType.getSelectedItem().toString() : null;

        val item = CreateAddress.builder()
            .name(addressName.getText())
            .type(type)
        .build();

        if(item.isValid()){
            save.execute(item.toAddress());
            find();
            setSelectedTab(LIST_INDEX);
        }else {
            showMessage("Preencha todos os campos");
        }
    }

    private void showMessage(String message){
        showMessageDialog(this, message, "Campos invalidos", INFORMATION_MESSAGE);
    }

    private void delete(ActionEvent e) {

        val operation = delete.execute(address.getNumber());

        if(operation.isSuccess()){
            find();
        } else {
            showMessage(operation.getErrors().stream().findFirst().orElseThrow());
        }

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
        contextMenu = new JPopupMenu();
        menuItemEdit = new JMenuItem();
        menuItemDelete = new JMenuItem();

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
                    panel7.add(buttonConfirm, BorderLayout.EAST);

                    //---- buttonBack ----
                    buttonBack.setText("cancelar");
                    buttonBack.addActionListener(e -> back(e));
                    panel7.add(buttonBack, BorderLayout.WEST);
                }
                DetailTab.add(panel7, BorderLayout.SOUTH);
            }
            tabbedPane1.addTab("Detalhe", DetailTab);
        }
        add(tabbedPane1);

        //======== contextMenu ========
        {

            //---- menuItemEdit ----
            menuItemEdit.setText("Editar");
            contextMenu.add(menuItemEdit);

            //---- menuItemDelete ----
            menuItemDelete.setText("Deletar");
            menuItemDelete.addActionListener(e -> delete(e));
            contextMenu.add(menuItemDelete);
        }
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
    private JPopupMenu contextMenu;
    private JMenuItem menuItemEdit;
    private JMenuItem menuItemDelete;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
