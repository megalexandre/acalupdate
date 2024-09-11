package br.org.acal.application.screen.main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

import br.org.acal.application.screen.address.AddressView;
import br.org.acal.application.screen.customer.CustomerView;
import br.org.acal.application.screen.invoice.InvoiceView;
import br.org.acal.application.screen.link.LinkView;
import br.org.acal.domain.entity.Invoice;
import org.springframework.stereotype.Component;

@Component
public class MainScreen extends JFrame {
    private final AddressView addressView;
    private final CustomerView customerView;
    private final InvoiceView invoiceView;
    private final LinkView linkView;

    public MainScreen(AddressView addressView, CustomerView customerView, InvoiceView invoiceView, LinkView linkView) {
        initComponents();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(800,600));
        setExtendedState(MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        this.addressView = addressView;
        this.customerView = customerView;
        this.invoiceView = invoiceView;
        this.linkView = linkView;
    }

    private void addressMenu(ActionEvent e) {
        showPanel(addressView);
    }

    private void customerMenu(ActionEvent e) {
        showPanel(customerView);
    }

    private void invoiceMenu(ActionEvent e) {
        showPanel(invoiceView);
    }
    private void linkMenu(ActionEvent e) { showPanel(linkView);}

    private void showPanel(JPanel pane){
        body.removeAll();
        body.add(pane);
        body.revalidate();
        body.repaint();
    }

    private void CustomerMenu(ActionEvent e) {
        // TODO add your code here
    }




    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner non-commercial license
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        addressMenu = new JMenuItem();
        customerMenu = new JMenuItem();
        linkMenu = new JMenuItem();
        categoryMenu = new JMenuItem();
        menuItem4 = new JMenuItem();
        menu2 = new JMenu();
        invoiceMenu = new JMenuItem();
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
                customerMenu.addActionListener(e -> {
			CustomerMenu(e);
			customerMenu(e);
		});
                menu1.add(customerMenu);

                //---- linkMenu ----
                linkMenu.setText("Liga\u00e7\u00f5es");
                linkMenu.addActionListener(e -> linkMenu(e));
                menu1.add(linkMenu);

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

                //---- invoiceMenu ----
                invoiceMenu.setText("Consultas");
                invoiceMenu.addActionListener(e -> invoiceMenu(e));
                menu2.add(invoiceMenu);

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
    private JMenuItem linkMenu;
    private JMenuItem categoryMenu;
    private JMenuItem menuItem4;
    private JMenu menu2;
    private JMenuItem invoiceMenu;
    private JMenuItem menuItem6;
    private JMenu menu3;
    private JMenuItem menuItem7;
    private JPanel body;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
