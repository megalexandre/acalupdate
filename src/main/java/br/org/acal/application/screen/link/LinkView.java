package br.org.acal.application.screen.link;

import java.awt.event.*;

import br.org.acal.application.screen.link.model.JComboBoxModel;
import br.org.acal.application.screen.link.model.LinkTable;
import br.org.acal.application.screen.link.model.LinkTableModel;
import br.org.acal.application.screen.render.StrippedTableCellRenderer;
import br.org.acal.commons.enumeration.Group;
import br.org.acal.domain.model.LinkFilter;
import br.org.acal.domain.usecase.address.AddressFindAllUsecase;
import br.org.acal.domain.usecase.category.CategoryFindAllUseCase;
import br.org.acal.domain.usecase.link.LinkFindUseCase;
import lombok.val;
import org.jdesktop.swingx.*;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import javax.swing.*;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

import static java.util.stream.IntStream.range;

@Component
public class LinkView extends JPanel {

    private final LinkFindUseCase find;
    private final AddressFindAllUsecase findAllAddress;
    private final CategoryFindAllUseCase categoryFindAll;
    private String selectedAddress;
    private String selectedCategory;
    private String selectedGroup;

    public LinkView(
            LinkFindUseCase find,
            AddressFindAllUsecase findAllAddress,
            CategoryFindAllUseCase categoryFindAll) {
        initComponents();

        this.find = find;
        this.findAllAddress = findAllAddress;
        this.categoryFindAll = categoryFindAll;

        comboBoxAddress.addItem(JComboBoxModel.clearData());
        comboBoxAddress.addActionListener(e -> {
            var item = (JComboBoxModel) comboBoxAddress.getSelectedItem();
            if (item != null) {
                selectedAddress = ((JComboBoxModel) comboBoxAddress.getSelectedItem()).getNumber();
            }
        });

        comboBoxCategory.addItem(JComboBoxModel.clearData());
        comboBoxCategory.addActionListener(e -> {
            var item = (JComboBoxModel) comboBoxCategory.getSelectedItem();
            if (item != null) {
                selectedCategory = ((JComboBoxModel) comboBoxCategory.getSelectedItem()).getNumber();
            }
        });

        comboBoxGroup.addActionListener(e -> {
            var item = (JComboBoxModel) comboBoxGroup.getSelectedItem();
            if (item != null) {
                selectedGroup = ((JComboBoxModel) comboBoxGroup.getSelectedItem()).getNumber();
            }
        });

        textFieldPartner.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    search();
                }
            }
        });

        setContextMenu();
        comboBoxGroup.addItem(JComboBoxModel.clearData());
        comboBoxStatus.addItem("Selecione");

        labelHelper.setText("");
    }

    private void search(ActionEvent e) {
       search();
    }

    private void search(){
        val links = find.execute(createFilter());
        val tableModel = new LinkTableModel(links.stream().map(LinkTable::of).toList());
        table.setModel(tableModel);
        table.setDefaultRenderer(String.class, new StrippedTableCellRenderer());

        val render = new StrippedTableCellRenderer();
        table.setDefaultRenderer(String.class, render);
        range(0, table.getColumnCount()).forEach(i ->
                table.getColumnModel().getColumn(i).setCellRenderer(render)
        );

        labelHelper.setText(links.size() + " Registros.");
    }

    private LinkFilter createFilter(){
        var filter = LinkFilter.builder().build();
        filter.setNumber("");
        filter.setAddressNumber(selectedAddress);
        filter.setCategoryNumber(selectedCategory);
        filter.setPartner(textFieldPartner.getText());
        filter.setGroup(selectedGroup);
        filter.setStatus((String) comboBoxStatus.getSelectedItem());
        return filter;
    }

    private void clearAction(ActionEvent e) {
        table.setModel(new LinkTableModel(List.of()));
        comboBoxAddress.setSelectedIndex(0);
        comboBoxCategory.setSelectedIndex(0);
        comboBoxGroup.setSelectedIndex(0);
        comboBoxStatus.setSelectedIndex(0);
        textFieldPartner.setText("");
        labelHelper.setText("");
    }

    private void comboBoxCategoryPopupMenuWillBecomeVisible(PopupMenuEvent e) {
        if(comboBoxCategory.getItemCount() <= 1){
            Optional.ofNullable(categoryFindAll.execute(null)).ifPresent(data ->
                data.forEach(item -> comboBoxCategory.addItem(JComboBoxModel.of(item)))
            );
        }
    }

    private void comboBoxAddressPopupMenuWillBecomeVisible(PopupMenuEvent e) {
        if(comboBoxAddress.getItemCount() <= 1){
            Optional.ofNullable(findAllAddress.execute(null)).ifPresent(data ->
                data.forEach(item -> comboBoxAddress.addItem(JComboBoxModel.of(item)))
            );
        }
    }

    private void setContextMenu(){
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

                    contextMenu.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });
    }

    private void addressChange(ActionEvent e) {
        // TODO add your code here
    }

    private void partnerAddEventHandler(ActionEvent e) {
    }

    private void comboBoxGroupPopupMenuWillBecomeVisible(PopupMenuEvent e) {
        if(comboBoxGroup.getItemCount() <= 1){
            Arrays.stream(Group.values()).forEach(item ->
                comboBoxGroup.addItem(JComboBoxModel.builder().number(item.getNumber()).name(item.getDescription()).build()));
        }
    }

    private void comboBoxStatusPopupMenuWillBecomeVisible(PopupMenuEvent e) {
        if(comboBoxStatus.getItemCount() == 1){
            comboBoxStatus.addItem("Ativo");
            comboBoxStatus.addItem("Inativo");
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner non-commercial license
        tabbedPane1 = new JTabbedPane();
        panel1 = new JPanel();
        panel8 = new JPanel();
        label4 = new JLabel();
        scrollPane1 = new JScrollPane();
        table = new JTable();
        panel2 = new JPanel();
        panel11 = new JPanel();
        labelHelper = new JLabel();
        panel5 = new JPanel();
        buttonSearch = new JButton();
        buttonClear = new JButton();
        panel3 = new JPanel();
        panel4 = new JPanel();
        label1 = new JLabel();
        comboBoxAddress = new JComboBox<>();
        panel6 = new JPanel();
        label3 = new JLabel();
        comboBoxCategory = new JComboBox<>();
        panel9 = new JPanel();
        label5 = new JLabel();
        comboBoxGroup = new JComboBox<>();
        panel7 = new JPanel();
        label2 = new JLabel();
        textFieldPartner = new JTextField();
        panel10 = new JPanel();
        label6 = new JLabel();
        comboBoxStatus = new JComboBox<>();
        panel12 = new JPanel();
        label7 = new JLabel();
        comboBox1 = new JComboBox();
        label8 = new JLabel();
        comboBox2 = new JComboBox();
        label9 = new JLabel();
        textField1 = new JTextField();
        button1 = new JButton();
        contextMenu = new JPopupMenu();
        menuItem1 = new JMenuItem();
        menuItem2 = new JMenuItem();

        //======== this ========
        setPreferredSize(new Dimension(1024, 768));
        setLayout(new BorderLayout());

        //======== tabbedPane1 ========
        {

            //======== panel1 ========
            {
                panel1.setLayout(new BorderLayout());

                //======== panel8 ========
                {
                    panel8.setLayout(new FlowLayout());

                    //---- label4 ----
                    label4.setText("Liga\u00e7\u00f5es");
                    panel8.add(label4);
                }
                panel1.add(panel8, BorderLayout.NORTH);

                //======== scrollPane1 ========
                {
                    scrollPane1.setViewportView(table);
                }
                panel1.add(scrollPane1, BorderLayout.CENTER);

                //======== panel2 ========
                {
                    panel2.setLayout(new BorderLayout());

                    //======== panel11 ========
                    {
                        panel11.setLayout(new FlowLayout());

                        //---- labelHelper ----
                        labelHelper.setText("Ajuda");
                        panel11.add(labelHelper);
                    }
                    panel2.add(panel11, BorderLayout.NORTH);

                    //======== panel5 ========
                    {
                        panel5.setLayout(new BorderLayout());

                        //---- buttonSearch ----
                        buttonSearch.setText("Buscar");
                        buttonSearch.addActionListener(e -> search(e));
                        panel5.add(buttonSearch, BorderLayout.EAST);

                        //---- buttonClear ----
                        buttonClear.setText("Limpar");
                        buttonClear.addActionListener(e -> clearAction(e));
                        panel5.add(buttonClear, BorderLayout.CENTER);
                    }
                    panel2.add(panel5, BorderLayout.EAST);

                    //======== panel3 ========
                    {
                        panel3.setLayout(new HorizontalLayout());

                        //======== panel4 ========
                        {
                            panel4.setMinimumSize(new Dimension(150, 40));
                            panel4.setPreferredSize(new Dimension(150, 40));
                            panel4.setLayout(new VerticalLayout());

                            //---- label1 ----
                            label1.setText("Endere\u00e7o:");
                            panel4.add(label1);

                            //---- comboBoxAddress ----
                            comboBoxAddress.setMinimumSize(new Dimension(150, 22));
                            comboBoxAddress.setPreferredSize(new Dimension(150, 22));
                            comboBoxAddress.addActionListener(e -> addressChange(e));
                            comboBoxAddress.addPopupMenuListener(new PopupMenuListener() {
                                @Override
                                public void popupMenuCanceled(PopupMenuEvent e) {}
                                @Override
                                public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {}
                                @Override
                                public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
                                    comboBoxAddressPopupMenuWillBecomeVisible(e);
                                    comboBoxAddressPopupMenuWillBecomeVisible(e);
                                }
                            });
                            panel4.add(comboBoxAddress);
                        }
                        panel3.add(panel4);

                        //======== panel6 ========
                        {
                            panel6.setPreferredSize(new Dimension(150, 40));
                            panel6.setMinimumSize(new Dimension(0, 400));
                            panel6.setLayout(new VerticalLayout());

                            //---- label3 ----
                            label3.setText("Categoria:");
                            panel6.add(label3);

                            //---- comboBoxCategory ----
                            comboBoxCategory.setMinimumSize(new Dimension(150, 22));
                            comboBoxCategory.setPreferredSize(new Dimension(150, 22));
                            comboBoxCategory.addPopupMenuListener(new PopupMenuListener() {
                                @Override
                                public void popupMenuCanceled(PopupMenuEvent e) {}
                                @Override
                                public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {}
                                @Override
                                public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
                                    comboBoxCategoryPopupMenuWillBecomeVisible(e);
                                }
                            });
                            panel6.add(comboBoxCategory);
                        }
                        panel3.add(panel6);

                        //======== panel9 ========
                        {
                            panel9.setMinimumSize(new Dimension(150, 0));
                            panel9.setPreferredSize(new Dimension(150, 0));
                            panel9.setLayout(new VerticalLayout());

                            //---- label5 ----
                            label5.setText("Grupo:");
                            panel9.add(label5);

                            //---- comboBoxGroup ----
                            comboBoxGroup.setPreferredSize(new Dimension(150, 22));
                            comboBoxGroup.setMinimumSize(new Dimension(150, 22));
                            comboBoxGroup.addPopupMenuListener(new PopupMenuListener() {
                                @Override
                                public void popupMenuCanceled(PopupMenuEvent e) {}
                                @Override
                                public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {}
                                @Override
                                public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
                                    comboBoxGroupPopupMenuWillBecomeVisible(e);
                                }
                            });
                            panel9.add(comboBoxGroup);
                        }
                        panel3.add(panel9);

                        //======== panel7 ========
                        {
                            panel7.setMinimumSize(new Dimension(150, 40));
                            panel7.setPreferredSize(new Dimension(150, 40));
                            panel7.setLayout(new VerticalLayout());

                            //---- label2 ----
                            label2.setText("S\u00f3cio:");
                            panel7.add(label2);

                            //---- textFieldPartner ----
                            textFieldPartner.setPreferredSize(new Dimension(150, 22));
                            textFieldPartner.setMinimumSize(new Dimension(150, 22));
                            textFieldPartner.addActionListener(e -> partnerAddEventHandler(e));
                            panel7.add(textFieldPartner);
                        }
                        panel3.add(panel7);

                        //======== panel10 ========
                        {
                            panel10.setMinimumSize(new Dimension(150, 0));
                            panel10.setPreferredSize(new Dimension(150, 0));
                            panel10.setLayout(new VerticalLayout());

                            //---- label6 ----
                            label6.setText("Status:");
                            panel10.add(label6);

                            //---- comboBoxStatus ----
                            comboBoxStatus.setPreferredSize(new Dimension(150, 22));
                            comboBoxStatus.setMinimumSize(new Dimension(150, 22));
                            comboBoxStatus.addPopupMenuListener(new PopupMenuListener() {
                                @Override
                                public void popupMenuCanceled(PopupMenuEvent e) {}
                                @Override
                                public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {}
                                @Override
                                public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
                                    comboBoxStatusPopupMenuWillBecomeVisible(e);
                                }
                            });
                            panel10.add(comboBoxStatus);
                        }
                        panel3.add(panel10);
                    }
                    panel2.add(panel3, BorderLayout.CENTER);
                }
                panel1.add(panel2, BorderLayout.SOUTH);
            }
            tabbedPane1.addTab("Liga\u00e7\u00f5es", panel1);

            //======== panel12 ========
            {
                panel12.setLayout(new VerticalLayout());

                //---- label7 ----
                label7.setText("S\u00f3cio:");
                panel12.add(label7);
                panel12.add(comboBox1);

                //---- label8 ----
                label8.setText("Endere\u00e7o");
                panel12.add(label8);
                panel12.add(comboBox2);

                //---- label9 ----
                label9.setText("Grupo de cobran\u00e7a");
                panel12.add(label9);
                panel12.add(textField1);

                //---- button1 ----
                button1.setText("Confirmar");
                panel12.add(button1);
            }
            tabbedPane1.addTab("text", panel12);
        }
        add(tabbedPane1, BorderLayout.CENTER);

        //======== contextMenu ========
        {

            //---- menuItem1 ----
            menuItem1.setText("Ativar");
            contextMenu.add(menuItem1);

            //---- menuItem2 ----
            menuItem2.setText("Inativar");
            contextMenu.add(menuItem2);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner non-commercial license
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JPanel panel8;
    private JLabel label4;
    private JScrollPane scrollPane1;
    private JTable table;
    private JPanel panel2;
    private JPanel panel11;
    private JLabel labelHelper;
    private JPanel panel5;
    private JButton buttonSearch;
    private JButton buttonClear;
    private JPanel panel3;
    private JPanel panel4;
    private JLabel label1;
    private JComboBox<JComboBoxModel
    > comboBoxAddress;
    private JPanel panel6;
    private JLabel label3;
    private JComboBox<JComboBoxModel> comboBoxCategory;
    private JPanel panel9;
    private JLabel label5;
    private JComboBox<JComboBoxModel> comboBoxGroup;
    private JPanel panel7;
    private JLabel label2;
    private JTextField textFieldPartner;
    private JPanel panel10;
    private JLabel label6;
    private JComboBox<String> comboBoxStatus;
    private JPanel panel12;
    private JLabel label7;
    private JComboBox comboBox1;
    private JLabel label8;
    private JComboBox comboBox2;
    private JLabel label9;
    private JTextField textField1;
    private JButton button1;
    private JPopupMenu contextMenu;
    private JMenuItem menuItem1;
    private JMenuItem menuItem2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
