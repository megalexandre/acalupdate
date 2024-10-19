package br.org.acal.application.screen.render;

import br.org.acal.commons.util.LocalDateUtil;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class WaterQualityTableCellRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        String date = (String) table.getValueAt(row, 2);
        var month = LocalDateUtil.stringToLocalDate(date).getMonth().getValue();

        Color tableForeground = UIManager.getColor("Table.foreground");
        Color tableBackground = UIManager.getColor("Table.background");
        Color tableSelectionInactiveBackground = UIManager.getColor("Table.selectionInactiveBackground");

        if (month % 2 ==0) {
            cellComponent.setBackground(tableBackground);
            cellComponent.setForeground(tableForeground);
        } else {
            cellComponent.setBackground(tableSelectionInactiveBackground);
            cellComponent.setForeground(tableForeground);
        }

        return cellComponent;
    }
}