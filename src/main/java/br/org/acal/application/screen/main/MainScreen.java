package br.org.acal.application.screen.main;

import br.org.acal.application.screen.address.AddressView;
import br.org.acal.application.screen.customer.CustomerView;
import br.org.acal.application.screen.invoice.InvoiceView;
import br.org.acal.application.screen.link.LinkView;
import br.org.acal.application.screen.register.RegisterMainView;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

@Component
public class MainScreen extends JFrame {

    private final AddressView addressView;
    private final CustomerView customerView;
    private final InvoiceView invoiceView;
    private final LinkView linkView;
    private final RegisterMainView registerMainView;

    public MainScreen(
            AddressView addressView,
            CustomerView customerView,
            InvoiceView invoiceView,
            LinkView linkView,
            RegisterMainView registerMainView
    ) {

        initComponents();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(800,600));
        setExtendedState(MAXIMIZED_BOTH);
        setLocationRelativeTo(null);


        this.addressView = addressView;
        this.customerView = customerView;
        this.invoiceView = invoiceView;
        this.linkView = linkView;
        this.registerMainView = registerMainView;
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

    private void menuRegister(ActionEvent e) {
        showPanel(registerMainView);
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
        linkMenu = new JMenuItem();
        categoryMenu = new JMenuItem();
        menu2 = new JMenu();
        invoiceMenu = new JMenuItem();
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
                customerMenu.addActionListener(e -> customerMenu(e));
                menu1.add(customerMenu);

                //---- linkMenu ----
                linkMenu.setText("Liga\u00e7\u00f5es");
                linkMenu.addActionListener(e -> linkMenu(e));
                menu1.add(linkMenu);

                //---- categoryMenu ----
                categoryMenu.setText("Categorias");
                menu1.add(categoryMenu);
            }
            menuBar1.add(menu1);

            //======== menu2 ========
            {
                menu2.setText("Faturas");

                //---- invoiceMenu ----
                invoiceMenu.setText("Consultas");
                invoiceMenu.addActionListener(e -> invoiceMenu(e));
                menu2.add(invoiceMenu);
            }
            menuBar1.add(menu2);

            //======== menu3 ========
            {
                menu3.setText("Caixa");

                //---- menuItem7 ----
                menuItem7.setText("Visualizar");
                menuItem7.addActionListener(e -> menuRegister(e));
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
    private JMenu menu2;
    private JMenuItem invoiceMenu;
    private JMenu menu3;
    private JMenuItem menuItem7;
    private JPanel body;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
