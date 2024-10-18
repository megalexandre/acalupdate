package br.org.acal.application.screen.water;

import java.awt.*;
import javax.swing.event.*;
import br.org.acal.application.screen.water.hydrometer.HydrometerView;
import br.org.acal.application.screen.water.param.ParamView;
import lombok.val;
import org.jdesktop.swingx.VerticalLayout;
import org.springframework.stereotype.Service;

import javax.swing.*;

@Service
public class WaterMainView extends JPanel {

    private final HydrometerView hydrometerView;
    private final ParamView paramView;

    private final int WATER = 0;
    private final int PARAM = 1;

    public WaterMainView(
            HydrometerView hydrometerView,
            ParamView paramView) {
        initComponents();

        this.hydrometerView = hydrometerView;
        this.paramView = paramView;
    }

    private void tabbedPaneWaterStateChanged(ChangeEvent e) {
        int index = tabbedPaneWater.getSelectedIndex();

        switch (index) {
            case PARAM:
                if (paramView != null) {
                    tabbedPaneWater.setComponentAt(PARAM, paramView);
                }
                break;
            case WATER:
                if (hydrometerView != null) {
                    tabbedPaneWater.setComponentAt(WATER, hydrometerView);
                }
                break;
            default:
                break;
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner non-commercial license
        tabbedPaneWater = new JTabbedPane();
        panel1 = new JPanel();
        panel2 = new JPanel();

        //======== this ========
        setLayout(new BorderLayout());

        //======== tabbedPaneWater ========
        {
            tabbedPaneWater.addChangeListener(e -> tabbedPaneWaterStateChanged(e));

            //======== panel1 ========
            {
                panel1.setLayout(new VerticalLayout());
            }
            tabbedPaneWater.addTab("Qualidade da \u00e1gua", panel1);

            //======== panel2 ========
            {
                panel2.setLayout(new VerticalLayout());
            }
            tabbedPaneWater.addTab("Hidrometros", panel2);
        }
        add(tabbedPaneWater, BorderLayout.CENTER);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner non-commercial license
    private JTabbedPane tabbedPaneWater;
    private JPanel panel1;
    private JPanel panel2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
