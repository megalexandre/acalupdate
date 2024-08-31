package br.org.acal.application.screen.address;

import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import br.org.acal.application.screen.render.StripperRender;
import br.org.acal.domain.model.Address;
import br.org.acal.resouces.repository.AddressRepository;
import lombok.val;
import org.jdesktop.swingx.*;

import static com.sun.xml.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;

public class AddressView extends JPanel {
    public AddressView() {
        initComponents();

    }

    private void find(ActionEvent e) {
       find();
    }

    private void find(){
        val addresses = new AddressRepository().findAll();
        AddressTableModel addressTableModel = new AddressTableModel(addresses.stream().map(AddressTable::of).toList());

        table.setModel(addressTableModel);

        DefaultTableCellRenderer customRenderer = new StripperRender();
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(customRenderer);
        }

    }

    private void clear(ActionEvent e) {
        table.setModel(new AddressTableModel(List.of()));
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner non-commercial license
        tabbedPane1 = new JTabbedPane();
        panel1 = new JPanel();
        scrollPane1 = new JScrollPane();
        table = new JTable();
        panel2 = new JPanel();
        label1 = new JLabel();
        textField1 = new JTextField();
        panel3 = new JPanel();
        findButton = new JButton();
        clearButton = new JButton();

        //======== this ========
        setLayout(new GridLayout());

        //======== tabbedPane1 ========
        {

            //======== panel1 ========
            {
                panel1.setLayout(new BorderLayout());

                //======== scrollPane1 ========
                {
                    scrollPane1.setViewportView(table);
                }
                panel1.add(scrollPane1, BorderLayout.CENTER);

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
                panel1.add(panel2, BorderLayout.SOUTH);
            }
            tabbedPane1.addTab("Lista", panel1);
        }
        add(tabbedPane1);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner non-commercial license
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JScrollPane scrollPane1;
    private JTable table;
    private JPanel panel2;
    private JLabel label1;
    private JTextField textField1;
    private JPanel panel3;
    private JButton findButton;
    private JButton clearButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
