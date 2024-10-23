package br.org.acal.application.screen.address;

import br.org.acal.application.screen.address.crud.create.AddressCreateView;
import br.org.acal.application.screen.address.model.AddressTable;
import br.org.acal.application.screen.address.model.AddressTableModel;
import br.org.acal.application.screen.render.StrippedTableCellRenderer;
import br.org.acal.domain.entity.Address;
import br.org.acal.domain.usecase.address.AddressDeleteUsecase;
import br.org.acal.domain.usecase.address.AddressFindUseCase;
import br.org.acal.domain.usecase.address.AddressSaveUseCase;
import lombok.val;
import org.jdesktop.swingx.HorizontalLayout;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import java.util.List;

import static java.util.stream.IntStream.range;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;
import static javax.swing.SwingUtilities.getWindowAncestor;


@Component
public class AddressView extends JPanel implements Serializable {
    private final AddressDeleteUsecase delete;
    private final AddressFindUseCase findAll;
    private final AddressSaveUseCase save;
    private List<Address> addresses;
    private Address address;

    public AddressView(
        AddressDeleteUsecase delete,
        AddressFindUseCase findAll,
        AddressSaveUseCase save
    ) {
        initComponents();
        start();
        this.delete = delete;
        this.findAll = findAll;
        this.save = save;
    }

    private void start(){
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

        tabbedPaneAddress.addChangeListener(e -> {
            clear();
        });
    }

    private void findAction() {
        find();
    }

    private void find(){
        this.addresses = findAll.execute(null);
        val addressTableModel = new AddressTableModel(addresses.stream().map(AddressTable::of).toList());

        table.setModel(addressTableModel);
        val customRenderer = new StrippedTableCellRenderer();

        range(0, table.getColumnCount()).forEach(i ->
            table.getColumnModel().getColumn(i).setCellRenderer(customRenderer)
        );

        table.revalidate();
        table.repaint();
    }

    private void clear(ActionEvent e) {
       clear();
    }

    private void clear(){
        table.setModel(new AddressTableModel(List.of()));
    }

    private void tableMouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2 && e.getButton() == MouseEvent.BUTTON1) {
            val target = (JTable) e.getSource();
            val row = target.getSelectedRow();
            this.address = addresses.get(row);
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

    private void editEvent(ActionEvent e) {
        createDialog();
    }

    private void createEvent() {
        address = null;
        createDialog();
    }

    private void createDialog(){
        val dialog = new AddressCreateView(getWindowAncestor(this), address, items -> {

            try{
                save.execute(items);
                find();
            } catch (Exception exception){
                showMessage("Valores duplicados não são aceitos");
            }

        });
        dialog.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner non-commercial license
        tabbedPaneAddress = new JTabbedPane();
        listaTab = new JPanel();
        scrollPane1 = new JScrollPane();
        table = new JTable();
        panel2 = new JPanel();
        clearButton = new JButton();
        panel1 = new JPanel();
        panel3 = new JPanel();
        buttonCreate = new JButton();
        buttonSearch = new JButton();
        contextMenu = new JPopupMenu();
        menuItemEdit = new JMenuItem();
        menuItemDelete = new JMenuItem();

        //======== this ========
        setLayout(new GridLayout());

        //======== tabbedPaneAddress ========
        {

            //======== listaTab ========
            {
                listaTab.setLayout(new BorderLayout());

                //======== scrollPane1 ========
                {

                    //---- table ----
                    table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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

                    //---- clearButton ----
                    clearButton.setText("Limpar");
                    clearButton.addActionListener(e -> clear(e));
                    panel2.add(clearButton, BorderLayout.WEST);

                    //======== panel1 ========
                    {
                        panel1.setLayout(new HorizontalLayout());
                    }
                    panel2.add(panel1, BorderLayout.CENTER);

                    //======== panel3 ========
                    {
                        panel3.setLayout(new HorizontalLayout());

                        //---- buttonCreate ----
                        buttonCreate.setText("Criar");
                        buttonCreate.addActionListener(e -> createEvent());
                        panel3.add(buttonCreate);

                        //---- buttonSearch ----
                        buttonSearch.setText("Pesquisar");
                        buttonSearch.addActionListener(e -> findAction());
                        panel3.add(buttonSearch);
                    }
                    panel2.add(panel3, BorderLayout.EAST);
                }
                listaTab.add(panel2, BorderLayout.SOUTH);
            }
            tabbedPaneAddress.addTab("Endere\u00e7os", listaTab);
        }
        add(tabbedPaneAddress);

        //======== contextMenu ========
        {

            //---- menuItemEdit ----
            menuItemEdit.setText("Editar");
            menuItemEdit.addActionListener(e -> editEvent(e));
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
    private JTabbedPane tabbedPaneAddress;
    private JPanel listaTab;
    private JScrollPane scrollPane1;
    private JTable table;
    private JPanel panel2;
    private JButton clearButton;
    private JPanel panel1;
    private JPanel panel3;
    private JButton buttonCreate;
    private JButton buttonSearch;
    private JPopupMenu contextMenu;
    private JMenuItem menuItemEdit;
    private JMenuItem menuItemDelete;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
