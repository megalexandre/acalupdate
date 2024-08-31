/*
 * Created by JFormDesigner on Sat Aug 31 19:30:46 BRT 2024
 */

package br.org.acal.application.screen.customer;

import java.awt.*;
import javax.swing.*;

/**
 * @author alexa
 */
public class CustomerView extends JPanel {
    public CustomerView() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner non-commercial license
        tabbedPane1 = new JTabbedPane();
        panel1 = new JPanel();
        label1 = new JLabel();
        panel2 = new JPanel();
        label2 = new JLabel();

        //======== this ========
        setLayout(new GridLayout());

        //======== tabbedPane1 ========
        {

            //======== panel1 ========
            {
                panel1.setLayout(new GridLayout());

                //---- label1 ----
                label1.setText("Meu ovo Esquerdo");
                panel1.add(label1);
            }
            tabbedPane1.addTab("text", panel1);

            //======== panel2 ========
            {
                panel2.setLayout(new GridLayout());

                //---- label2 ----
                label2.setText("Meu ovo direito");
                panel2.add(label2);
            }
            tabbedPane1.addTab("text", panel2);
        }
        add(tabbedPane1);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner non-commercial license
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JLabel label1;
    private JPanel panel2;
    private JLabel label2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
