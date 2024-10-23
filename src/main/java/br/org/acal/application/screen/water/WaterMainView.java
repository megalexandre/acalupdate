package br.org.acal.application.screen.water;

import br.org.acal.application.screen.water.hydrometer.HydrometerView;
import org.jdesktop.swingx.VerticalLayout;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.awt.*;

@Service
public class WaterMainView extends JPanel {

    public WaterMainView(HydrometerView hydrometerView) {
        initComponents();
        tabbedPaneWater.remove(0);
        tabbedPaneWater.add("Qualidade da Água", hydrometerView);
        tabbedPaneWater.setSelectedIndex(0);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner non-commercial license
        tabbedPaneWater = new JTabbedPane();
        panel1 = new JPanel();

        //======== this ========
        setLayout(new BorderLayout());

        //======== tabbedPaneWater ========
        {

            //======== panel1 ========
            {
                panel1.setLayout(new VerticalLayout());
            }
            tabbedPaneWater.addTab("Qualidade da \u00e1gua", panel1);
        }
        add(tabbedPaneWater, BorderLayout.CENTER);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner non-commercial license
    private JTabbedPane tabbedPaneWater;
    private JPanel panel1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
