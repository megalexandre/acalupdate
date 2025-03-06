package br.org.acal.application.screen.water.hydrometer.create;

import br.org.acal.commons.enumeration.WaterQualityParameter;
import br.org.acal.commons.util.LocalDateUtil;
import br.org.acal.domain.entity.WaterQuality;
import lombok.val;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.util.List;

import static br.org.acal.commons.enumeration.WaterQualityParameter.*;

public class WaterQualityCreateView extends JDialog {

    private final DialogCallback callback;

    public interface DialogCallback {
        void onWaterQualityReceived(List<WaterQuality> items);
    }

    public WaterQualityCreateView(Window owner, DialogCallback callback) {
        super(owner);

        initComponents();
        this.callback = callback;

        try {
            MaskFormatter periodMask = new MaskFormatter("##/####");
            periodMask.setPlaceholderCharacter(' ');
            periodMask.install(formattedTextFieldPeriod);
        } catch (Exception ignored){

        }

        buttonConfirm.addActionListener(e -> {
            val items = create().getItems().stream().map(WaterQualityCreateItem::fromWaterQuality).toList();
            callback.onWaterQualityReceived(items);
            dispose();
        });

    }

    private WaterQualityCreate create() {
        val apparentColor = createItem(APPEARANCE_COLOR, textFieldColorRequired, textFieldColorAnalized, textFieldColorAccordance);
        val turbidity = createItem(TURBIDITY, textFieldTurbidezRequired, textFieldTurbidezAnalized, textFieldTurbidezAccordance);
        val chlorine = createItem(CHLORINE, textFieldChlorineRequired, textFieldChlorineAnalized, textFieldChlorineAccordance);
        val escherichiaColi = createItem(ESCHERICHIA_COLI, textFieldEscherichiaColiRequired, textFieldEscherichiaColiAnalized, textFieldEscherichiaColiAccordance );
        val totalColiforms = createItem(TOTAL_COLIFORMS, textFieldTotalColiformsRequired, textFieldTotalColiformsAnalized, textFieldTotalColiformsAccordance );

        return WaterQualityCreate.builder()
            .items(List.of(apparentColor, turbidity, chlorine, escherichiaColi, totalColiforms))
            .build();
    }

    private WaterQualityCreateItem createItem(
        WaterQualityParameter waterQualityParameter,
        JTextField required,
        JTextField analyzed,
        JTextField accordance
    ){
        val date = LocalDateUtil.stringToLocalDate("01/" + formattedTextFieldPeriod.getText());

        return WaterQualityCreateItem.builder()
                .waterParam(fromEnum(waterQualityParameter))
                .required(required.getText())
                .analyzed(analyzed.getText())
                .accordance(accordance.getText())
                .date(date)
                .build();
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner non-commercial license
        panel3 = new JPanel();
        panel2 = new JPanel();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        label8 = new JLabel();
        label14 = new JLabel();
        label9 = new JLabel();
        textFieldColorRequired = new JTextField();
        textFieldColorAnalized = new JTextField();
        textFieldColorAccordance = new JTextField();
        label15 = new JLabel();
        label10 = new JLabel();
        textFieldTurbidezRequired = new JTextField();
        textFieldTurbidezAnalized = new JTextField();
        textFieldTurbidezAccordance = new JTextField();
        label16 = new JLabel();
        label11 = new JLabel();
        textFieldChlorineRequired = new JTextField();
        textFieldChlorineAnalized = new JTextField();
        textFieldChlorineAccordance = new JTextField();
        label17 = new JLabel();
        label13 = new JLabel();
        textFieldEscherichiaColiRequired = new JTextField();
        textFieldEscherichiaColiAnalized = new JTextField();
        textFieldEscherichiaColiAccordance = new JTextField();
        label20 = new JLabel();
        label12 = new JLabel();
        textFieldTotalColiformsRequired = new JTextField();
        textFieldTotalColiformsAnalized = new JTextField();
        textFieldTotalColiformsAccordance = new JTextField();
        label21 = new JLabel();
        formattedTextFieldPeriod = new JFormattedTextField();
        panel1 = new JPanel();
        buttonConfirm = new JButton();

        //======== this ========
        setPreferredSize(new Dimension(620, 300));
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== panel3 ========
        {
            panel3.setBorder(new EmptyBorder(5, 5, 5, 5));
            panel3.setLayout(new BorderLayout());

            //======== panel2 ========
            {
                panel2.setLayout(new GridBagLayout());
                ((GridBagLayout)panel2.getLayout()).columnWidths = new int[] {0, 0, 0, 0, 0, 0};
                ((GridBagLayout)panel2.getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0};
                ((GridBagLayout)panel2.getLayout()).columnWeights = new double[] {0.0, 1.0, 1.0, 1.0, 1.0, 1.0E-4};
                ((GridBagLayout)panel2.getLayout()).rowWeights = new double[] {1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, 1.0, 1.0E-4};

                //---- label5 ----
                label5.setText("Par\u00e2metro:");
                panel2.add(label5, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 10), 0, 0));

                //---- label6 ----
                label6.setText("Exigido");
                panel2.add(label6, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 10), 0, 0));

                //---- label7 ----
                label7.setText("Analisado:");
                panel2.add(label7, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 10), 0, 0));

                //---- label8 ----
                label8.setText("Conforme:");
                panel2.add(label8, new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 0), 0, 0));

                //---- label14 ----
                label14.setText("1");
                panel2.add(label14, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 10), 0, 0));

                //---- label9 ----
                label9.setText("Cor aparente - 15UH");
                panel2.add(label9, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 10), 0, 0));

                //---- textFieldColorRequired ----
                textFieldColorRequired.setText("0");
                panel2.add(textFieldColorRequired, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 10), 0, 0));

                //---- textFieldColorAnalized ----
                textFieldColorAnalized.setText("0");
                panel2.add(textFieldColorAnalized, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 10), 0, 0));

                //---- textFieldColorAccordance ----
                textFieldColorAccordance.setText("0");
                panel2.add(textFieldColorAccordance, new GridBagConstraints(4, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 0), 0, 0));

                //---- label15 ----
                label15.setText("2");
                panel2.add(label15, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 10), 0, 0));

                //---- label10 ----
                label10.setText("Turbidez - 5.0 UT");
                panel2.add(label10, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 10), 0, 0));

                //---- textFieldTurbidezRequired ----
                textFieldTurbidezRequired.setText("0");
                panel2.add(textFieldTurbidezRequired, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 10), 0, 0));

                //---- textFieldTurbidezAnalized ----
                textFieldTurbidezAnalized.setText("0");
                panel2.add(textFieldTurbidezAnalized, new GridBagConstraints(3, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 10), 0, 0));

                //---- textFieldTurbidezAccordance ----
                textFieldTurbidezAccordance.setText("0");
                panel2.add(textFieldTurbidezAccordance, new GridBagConstraints(4, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 0), 0, 0));

                //---- label16 ----
                label16.setText("3");
                panel2.add(label16, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 10), 0, 0));

                //---- label11 ----
                label11.setText("Cloro - Min 0,2 mg/l");
                panel2.add(label11, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 10), 0, 0));

                //---- textFieldChlorineRequired ----
                textFieldChlorineRequired.setText("0");
                panel2.add(textFieldChlorineRequired, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 10), 0, 0));

                //---- textFieldChlorineAnalized ----
                textFieldChlorineAnalized.setText("0");
                panel2.add(textFieldChlorineAnalized, new GridBagConstraints(3, 3, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 10), 0, 0));

                //---- textFieldChlorineAccordance ----
                textFieldChlorineAccordance.setText("0");
                panel2.add(textFieldChlorineAccordance, new GridBagConstraints(4, 3, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 0), 0, 0));

                //---- label17 ----
                label17.setText("4");
                panel2.add(label17, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 10), 0, 0));

                //---- label13 ----
                label13.setText("Eschirichia Coli");
                panel2.add(label13, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 10), 0, 0));

                //---- textFieldEscherichiaColiRequired ----
                textFieldEscherichiaColiRequired.setText("0");
                panel2.add(textFieldEscherichiaColiRequired, new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 10), 0, 0));

                //---- textFieldEscherichiaColiAnalized ----
                textFieldEscherichiaColiAnalized.setText("0");
                panel2.add(textFieldEscherichiaColiAnalized, new GridBagConstraints(3, 4, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 10), 0, 0));

                //---- textFieldEscherichiaColiAccordance ----
                textFieldEscherichiaColiAccordance.setText("0");
                panel2.add(textFieldEscherichiaColiAccordance, new GridBagConstraints(4, 4, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 0), 0, 0));

                //---- label20 ----
                label20.setText("5");
                panel2.add(label20, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 10), 0, 0));

                //---- label12 ----
                label12.setText("Coliformes Totais");
                panel2.add(label12, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 10), 0, 0));

                //---- textFieldTotalColiformsRequired ----
                textFieldTotalColiformsRequired.setText("0");
                panel2.add(textFieldTotalColiformsRequired, new GridBagConstraints(2, 5, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 10), 0, 0));

                //---- textFieldTotalColiformsAnalized ----
                textFieldTotalColiformsAnalized.setText("0");
                panel2.add(textFieldTotalColiformsAnalized, new GridBagConstraints(3, 5, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 10), 0, 0));

                //---- textFieldTotalColiformsAccordance ----
                textFieldTotalColiformsAccordance.setText("0");
                panel2.add(textFieldTotalColiformsAccordance, new GridBagConstraints(4, 5, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 0), 0, 0));

                //---- label21 ----
                label21.setText("Refer\u00eancia");
                panel2.add(label21, new GridBagConstraints(1, 6, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 10), 0, 0));

                //---- formattedTextFieldPeriod ----
                formattedTextFieldPeriod.setPreferredSize(new Dimension(150, 34));
                formattedTextFieldPeriod.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                panel2.add(formattedTextFieldPeriod, new GridBagConstraints(2, 6, 3, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 0), 0, 0));
            }
            panel3.add(panel2, BorderLayout.CENTER);
        }
        contentPane.add(panel3, BorderLayout.CENTER);

        //======== panel1 ========
        {
            panel1.setLayout(new BorderLayout());

            //---- buttonConfirm ----
            buttonConfirm.setText("Confirmar");
            panel1.add(buttonConfirm, BorderLayout.EAST);
        }
        contentPane.add(panel1, BorderLayout.PAGE_END);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner non-commercial license
    private JPanel panel3;
    private JPanel panel2;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JLabel label14;
    private JLabel label9;
    private JTextField textFieldColorRequired;
    private JTextField textFieldColorAnalized;
    private JTextField textFieldColorAccordance;
    private JLabel label15;
    private JLabel label10;
    private JTextField textFieldTurbidezRequired;
    private JTextField textFieldTurbidezAnalized;
    private JTextField textFieldTurbidezAccordance;
    private JLabel label16;
    private JLabel label11;
    private JTextField textFieldChlorineRequired;
    private JTextField textFieldChlorineAnalized;
    private JTextField textFieldChlorineAccordance;
    private JLabel label17;
    private JLabel label13;
    private JTextField textFieldEscherichiaColiRequired;
    private JTextField textFieldEscherichiaColiAnalized;
    private JTextField textFieldEscherichiaColiAccordance;
    private JLabel label20;
    private JLabel label12;
    private JTextField textFieldTotalColiformsRequired;
    private JTextField textFieldTotalColiformsAnalized;
    private JTextField textFieldTotalColiformsAccordance;
    private JLabel label21;
    private JFormattedTextField formattedTextFieldPeriod;
    private JPanel panel1;
    private JButton buttonConfirm;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
