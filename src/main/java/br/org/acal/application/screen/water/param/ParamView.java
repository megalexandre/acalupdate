
package br.org.acal.application.screen.water.param;

import javax.swing.*;
import org.jdesktop.swingx.*;
import org.springframework.stereotype.Component;

@Component
public class ParamView extends JPanel {

    public ParamView() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner non-commercial license
        label1 = new JLabel();

        //======== this ========
        setLayout(new VerticalLayout());

        //---- label1 ----
        label1.setText("Param");
        add(label1);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner non-commercial license
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
