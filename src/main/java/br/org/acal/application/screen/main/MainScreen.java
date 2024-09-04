package br.org.acal.application.screen.main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

import br.org.acal.application.screen.address.AddressView;
import br.org.acal.application.screen.customer.CustomerView;
import org.springframework.stereotype.Component;

@Component
public class MainScreen extends JFrame {
    private final AddressView addressView;
    private final CustomerView customerView;

    public MainScreen(AddressView addressView, CustomerView customerView) {
        initComponents();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(800,600));
        setExtendedState(MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        this.addressView = addressView;
        this.customerView = customerView;
    }

    private void addressMenu(ActionEvent e) {
        showPanel(addressView);
    }

    private void customerMenu(ActionEvent e) {
        showPanel(customerView);
    }

    private void showPanel(JPanel pane){
        body.removeAll();
        body.add(pane);
        body.revalidate();
        body.repaint();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner non-commercial license
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        addressMenu = new JMenuItem();
        customerMenu = new JMenuItem();
        categoryMenu = new JMenuItem();
        menuItem4 = new JMenuItem();
        menu2 = new JMenu();
        menuItem5 = new JMenuItem();
        menuItem6 = new JMenuItem();
        menu3 = new JMenu();
        menuItem7 = new JMenuItem();
        body = new JPanel();

        //======== this ========
        setTitle("Acal");
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== menuBar1 ========
        {
            menuBar1.setEnabled(false);

            //======== menu1 ========
            {
                menu1.setText("Cadastros");

                //---- addressMenu ----
                addressMenu.setText("Logradouros");
                addressMenu.addActionListener(e -> addressMenu(e));
                menu1.add(addressMenu);

                //---- customerMenu ----
                customerMenu.setText("S\u00f3cios");
                customerMenu.addActionListener(this::customerMenu);
                menu1.add(customerMenu);

                //---- categoryMenu ----
                categoryMenu.setText("Categorias");
                menu1.add(categoryMenu);

                //---- menuItem4 ----
                menuItem4.setText("Taxas");
                menu1.add(menuItem4);
            }
            menuBar1.add(menu1);

            //======== menu2 ========
            {
                menu2.setText("Faturas");

                //---- menuItem5 ----
                menuItem5.setText("Consultas");
                menu2.add(menuItem5);

                //---- menuItem6 ----
                menuItem6.setText("Consultas Avan\u00e7adas");
                menu2.add(menuItem6);
            }
            menuBar1.add(menu2);

            //======== menu3 ========
            {
                menu3.setText("Caixa");

                //---- menuItem7 ----
                menuItem7.setText("Visualizar");
                menu3.add(menuItem7);
            }
            menuBar1.add(menu3);
        }
        setJMenuBar(menuBar1);

        //======== body ========
        {
            body.setBorder(new EtchedBorder());
            body.setLayout(new GridLayout());
        }
        contentPane.add(body, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner non-commercial license
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JMenuItem addressMenu;
    private JMenuItem customerMenu;
    private JMenuItem categoryMenu;
    private JMenuItem menuItem4;
    private JMenu menu2;
    private JMenuItem menuItem5;
    private JMenuItem menuItem6;
    private JMenu menu3;
    private JMenuItem menuItem7;
    private JPanel body;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
