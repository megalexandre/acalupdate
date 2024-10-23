package br.org.acal.application.screen.link;

import br.org.acal.application.components.combobox.JComboBoxAddress;
import br.org.acal.application.components.combobox.JComboBoxCategory;
import br.org.acal.application.components.combobox.JComboBoxCustomer;
import br.org.acal.application.components.combobox.JComboBoxModel;
import br.org.acal.application.screen.customer.model.FindCustomer;
import br.org.acal.application.screen.link.model.LinkCreateRequest;
import br.org.acal.application.screen.link.model.LinkTable;
import br.org.acal.application.screen.link.model.LinkTableModel;
import br.org.acal.application.screen.render.InvoiceTableCellRenderer;
import br.org.acal.application.screen.render.LinkTableCellRenderer;
import br.org.acal.application.screen.render.StrippedTableCellRenderer;
import br.org.acal.commons.enumeration.Group;
import br.org.acal.domain.entity.Address;
import br.org.acal.domain.entity.Category;
import br.org.acal.domain.entity.Customer;
import br.org.acal.domain.model.AddressFilter;
import br.org.acal.domain.model.LinkFilter;
import br.org.acal.domain.usecase.address.AddressFindAllUsecase;
import br.org.acal.domain.usecase.address.AddressFindUsecase;
import br.org.acal.domain.usecase.category.CategoryFindAllUseCase;
import br.org.acal.domain.usecase.customer.CustomerFindUseCase;
import br.org.acal.domain.usecase.link.LinkActiveUseCase;
import br.org.acal.domain.usecase.link.LinkCreateUseCase;
import br.org.acal.domain.usecase.link.LinkDeleteUseCase;
import br.org.acal.domain.usecase.link.LinkFindUseCase;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.val;
import org.jdesktop.swingx.HorizontalLayout;
import org.jdesktop.swingx.VerticalLayout;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.IntStream.range;
import static javax.swing.JOptionPane.showMessageDialog;

@Component
public class LinkView extends JPanel {

    private final LinkFindUseCase find;
    private final LinkCreateUseCase linkCreateUseCase;
    private final LinkDeleteUseCase linkInactiveUseCase;
    private final LinkActiveUseCase linkActiveUseCase;
    private final AddressFindAllUsecase findAllAddress;
    private final AddressFindUsecase addressFindUsecase;
    private final CategoryFindAllUseCase categoryFindAll;
    private final CustomerFindUseCase customerFindUseCase;

    private final Validator validator;

    private String selectedAddress;
    private String selectedCategory;
    private String selectedGroup;

    private final int LIST_LINK_INDEX = 0;
    private final int CREATE_LINK_INDEX = 1;

    private LinkCreateRequest linkCreateRequest = new LinkCreateRequest();
    private List<JComboBoxCustomer> customers = new ArrayList<>();
    private List<JComboBoxAddress> addresses = new ArrayList<>();
    private List<JComboBoxCategory> categories = new ArrayList<>();


    public LinkView(
            LinkFindUseCase find,
            LinkCreateUseCase linkCreateUseCase,
            LinkDeleteUseCase linkInactiveUseCase,
            LinkActiveUseCase linkActiveUseCase,
            AddressFindAllUsecase findAllAddress,
            AddressFindUsecase addressFindUsecase,
            CategoryFindAllUseCase categoryFindAll,
            CustomerFindUseCase customerFindUseCase,
            Validator validator
    ) {
        initComponents();

        this.find = find;
        this.findAllAddress = findAllAddress;
        this.linkCreateUseCase = linkCreateUseCase;
        this.linkInactiveUseCase = linkInactiveUseCase;
        this.linkActiveUseCase = linkActiveUseCase;
        this.categoryFindAll = categoryFindAll;
        this.customerFindUseCase = customerFindUseCase;
        this.addressFindUsecase = addressFindUsecase;
        this.validator = validator;

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

        table.setDefaultRenderer(Object.class, new LinkTableCellRenderer());
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
        clear();
    }

    private void clear(){
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

    private void tabbedPaneLinkStateChanged(ChangeEvent e) {
        JTabbedPane source = (JTabbedPane) e.getSource();
        int selectedIndex = source.getSelectedIndex();
        if (selectedIndex == CREATE_LINK_INDEX) {
            linkCreateRequest = new LinkCreateRequest();

            if(customers.isEmpty()){
                val filter = FindCustomer.builder().active(true).build();
                customers = customerFindUseCase.execute(filter).stream()
                        .sorted(Comparator.comparing(Customer::getName))
                        .map(JComboBoxCustomer::of).toList();

                comboBoxCustomer.addItem(JComboBoxCustomer.clearData());
                customers.forEach(customer ->
                    comboBoxCustomer.addItem(customer)
                );
            }

            if(addresses.isEmpty()){
                val addressFilter = AddressFilter.builder().active(true).build();
                addresses = addressFindUsecase.execute(addressFilter).stream()
                        .sorted(Comparator.comparing(Address::getDisplayName))
                        .map(JComboBoxAddress::of)
                        .toList();

                comboBoxActiveAddress.addItem(JComboBoxAddress.select());
                addresses.forEach(category ->
                        comboBoxActiveAddress.addItem(category)
                );
            }

            if(categories.isEmpty()){
                categories = categoryFindAll.execute(null).stream()
                        .sorted(Comparator
                            .comparing(Category::getGroup)
                            .thenComparing(Category::getName)
                        )
                        .map(JComboBoxCategory::of)
                        .toList();

                comboBoxActiveCategory.addItem(JComboBoxCategory.clearData());
                categories.forEach(category ->
                    comboBoxActiveCategory.addItem(category)
                );
            }

            comboBoxCustomer.setSelectedIndex(0);
            comboBoxActiveAddress.setSelectedIndex(0);
            comboBoxActiveCategory.setSelectedIndex(0);
        }
    }

    private void customerCreateSelected(ActionEvent e) {
        val selected = (JComboBoxCustomer) comboBoxCustomer.getSelectedItem();

        assert selected != null;
        if(selected.isSelectOption()){
            linkCreateRequest.setCustomer(null);
        } else {
            linkCreateRequest.setCustomer(selected.getCustomer());
        }
    }

    private void addressCreateSelected(ActionEvent e) {
        val selected = (JComboBoxAddress) comboBoxActiveAddress.getSelectedItem();

        assert selected != null;
        if(!selected.isSelectOption()){
            linkCreateRequest.setAddress(selected.getAddress());
        }
    }

    private void categoryCreateSelected(ActionEvent e) {
        val selected = (JComboBoxCategory) comboBoxActiveCategory.getSelectedItem();

        assert selected != null;
        if(!selected.isSelectOption()){
            linkCreateRequest.setCategory(selected.getCategory());
        }
    }

    private void saveButtonAction(ActionEvent e) {

        linkCreateRequest.setLinkNumber(textFieldNumber.getText());
        linkCreateRequest.setExclusiveMember(checkBoxPartnerOnly.isSelected());


        val violations = validator.validate(linkCreateRequest);
        if (!violations.isEmpty()) {
            showMessageDialog(this,
                violations.stream().map(ConstraintViolation::getMessage).collect(Collectors.joining("\n"))
            );

            return;
        }


        try {
            linkCreateUseCase.execute(linkCreateRequest.toLink());
            tabbedPaneLink.setSelectedIndex(LIST_LINK_INDEX);
        } catch (RuntimeException ex) {
            showMessageDialog(this, ex.getMessage());
        }

    }

    private void inactiveLinkAction(ActionEvent e) {
        int selectedRow = table.getSelectedRow();

        val model = (LinkTableModel) table.getModel();
        val link = model.getItem(selectedRow);

        linkInactiveUseCase.execute(link);
        search();
    }

    private void activeLinkAction(ActionEvent e) {
        int selectedRow = table.getSelectedRow();

        val model = (LinkTableModel) table.getModel();
        val link = model.getItem(selectedRow);

        linkActiveUseCase.execute(link);
        search();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner non-commercial license
        tabbedPaneLink = new JTabbedPane();
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
        panel17 = new JPanel();
        panelNumber = new JPanel();
        Número = new JLabel();
        textFieldNumber = new JTextField();
        panelPartner = new JPanel();
        label7 = new JLabel();
        comboBoxCustomer = new JComboBox<>();
        panelAddress = new JPanel();
        label8 = new JLabel();
        comboBoxActiveAddress = new JComboBox<>();
        panelCategory = new JPanel();
        label9 = new JLabel();
        comboBoxActiveCategory = new JComboBox<>();
        panelMemberOnly = new JPanel();
        checkBoxPartnerOnly = new JCheckBox();
        panelActions = new JPanel();
        button1 = new JButton();
        contextMenu = new JPopupMenu();
        menuItem1 = new JMenuItem();
        menuItem2 = new JMenuItem();

        //======== this ========
        setPreferredSize(new Dimension(1024, 768));
        setLayout(new BorderLayout());

        //======== tabbedPaneLink ========
        {
            tabbedPaneLink.addChangeListener(e -> tabbedPaneLinkStateChanged(e));

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
            tabbedPaneLink.addTab("Liga\u00e7\u00f5es", panel1);

            //======== panel17 ========
            {
                panel17.setMinimumSize(new Dimension(95, 40));
                panel17.setPreferredSize(new Dimension(95, 40));
                panel17.setLayout(new GridBagLayout());
                ((GridBagLayout)panel17.getLayout()).columnWidths = new int[] {0, 0};
                ((GridBagLayout)panel17.getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0, 0};
                ((GridBagLayout)panel17.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
                ((GridBagLayout)panel17.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

                //======== panelNumber ========
                {
                    panelNumber.setLayout(new VerticalLayout());

                    //---- Número ----
                    Número.setText("N\u00famero");
                    panelNumber.add(Número);

                    //---- textFieldNumber ----
                    textFieldNumber.setPreferredSize(new Dimension(800, 34));
                    panelNumber.add(textFieldNumber);
                }
                panel17.add(panelNumber, new GridBagConstraints(0, 0, 1, 1, 1.0, 0.0,
                    GridBagConstraints.NORTH, GridBagConstraints.NONE,
                    new Insets(0, 0, 0, 0), 0, 0));

                //======== panelPartner ========
                {
                    panelPartner.setLayout(new VerticalLayout());

                    //---- label7 ----
                    label7.setText("S\u00f3cio:");
                    panelPartner.add(label7);

                    //---- comboBoxCustomer ----
                    comboBoxCustomer.setPreferredSize(new Dimension(800, 34));
                    comboBoxCustomer.addActionListener(e -> customerCreateSelected(e));
                    panelPartner.add(comboBoxCustomer);
                }
                panel17.add(panelPartner, new GridBagConstraints(0, 2, 1, 1, 1.0, 0.0,
                    GridBagConstraints.NORTH, GridBagConstraints.NONE,
                    new Insets(0, 0, 0, 0), 0, 0));

                //======== panelAddress ========
                {
                    panelAddress.setLayout(new VerticalLayout());

                    //---- label8 ----
                    label8.setText("Endere\u00e7o:");
                    panelAddress.add(label8);

                    //---- comboBoxActiveAddress ----
                    comboBoxActiveAddress.setPreferredSize(new Dimension(800, 34));
                    comboBoxActiveAddress.addActionListener(e -> addressCreateSelected(e));
                    panelAddress.add(comboBoxActiveAddress);
                }
                panel17.add(panelAddress, new GridBagConstraints(0, 1, 1, 1, 1.0, 0.0,
                    GridBagConstraints.NORTH, GridBagConstraints.NONE,
                    new Insets(0, 0, 0, 0), 0, 0));

                //======== panelCategory ========
                {
                    panelCategory.setLayout(new VerticalLayout());

                    //---- label9 ----
                    label9.setText("Categoria:");
                    panelCategory.add(label9);

                    //---- comboBoxActiveCategory ----
                    comboBoxActiveCategory.setPreferredSize(new Dimension(800, 34));
                    comboBoxActiveCategory.addActionListener(e -> categoryCreateSelected(e));
                    panelCategory.add(comboBoxActiveCategory);
                }
                panel17.add(panelCategory, new GridBagConstraints(0, 3, 1, 1, 1.0, 0.0,
                    GridBagConstraints.NORTH, GridBagConstraints.NONE,
                    new Insets(0, 0, 0, 0), 0, 0));

                //======== panelMemberOnly ========
                {
                    panelMemberOnly.setLayout(new HorizontalLayout());

                    //---- checkBoxPartnerOnly ----
                    checkBoxPartnerOnly.setText("Exclusivamente S\u00f3cio?");
                    panelMemberOnly.add(checkBoxPartnerOnly);
                }
                panel17.add(panelMemberOnly, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0,
                    GridBagConstraints.NORTH, GridBagConstraints.NONE,
                    new Insets(0, 0, 0, 0), 0, 0));

                //======== panelActions ========
                {
                    panelActions.setLayout(new VerticalLayout());

                    //---- button1 ----
                    button1.setText("Confirmar");
                    button1.addActionListener(e -> saveButtonAction(e));
                    panelActions.add(button1);
                }
                panel17.add(panelActions, new GridBagConstraints(0, 5, 1, 1, 1.0, 1.0,
                    GridBagConstraints.SOUTH, GridBagConstraints.NONE,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            tabbedPaneLink.addTab("Criar Nova Liga\u00e7\u00e3o", panel17);
        }
        add(tabbedPaneLink, BorderLayout.CENTER);

        //======== contextMenu ========
        {

            //---- menuItem1 ----
            menuItem1.setText("Ativar");
            menuItem1.addActionListener(e -> activeLinkAction(e));
            contextMenu.add(menuItem1);

            //---- menuItem2 ----
            menuItem2.setText("Inativar");
            menuItem2.addActionListener(e -> inactiveLinkAction(e));
            contextMenu.add(menuItem2);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner non-commercial license
    private JTabbedPane tabbedPaneLink;
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
    private JPanel panel17;
    private JPanel panelNumber;
    private JLabel Número;
    private JTextField textFieldNumber;
    private JPanel panelPartner;
    private JLabel label7;
    private JComboBox<JComboBoxCustomer> comboBoxCustomer;
    private JPanel panelAddress;
    private JLabel label8;
    private JComboBox<JComboBoxAddress> comboBoxActiveAddress;
    private JPanel panelCategory;
    private JLabel label9;
    private JComboBox<JComboBoxCategory> comboBoxActiveCategory;
    private JPanel panelMemberOnly;
    private JCheckBox checkBoxPartnerOnly;
    private JPanel panelActions;
    private JButton button1;
    private JPopupMenu contextMenu;
    private JMenuItem menuItem1;
    private JMenuItem menuItem2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
