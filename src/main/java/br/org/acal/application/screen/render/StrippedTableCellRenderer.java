package br.org.acal.application.screen.render;

import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.Color;
import java.awt.Component;

public class StrippedTableCellRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        Color tableForeground = UIManager.getColor("Table.foreground");
        Color tableBackground = UIManager.getColor("Table.background");
        Color tableSelectionForeground = UIManager.getColor("Table.selectionForeground");
        Color tableSelectionBackground = UIManager.getColor("Table.selectionBackground");
        Color tableSelectionInactiveForeground = UIManager.getColor("Table.selectionInactiveForeground");
        Color tableSelectionInactiveBackground = UIManager.getColor("Table.selectionInactiveBackground");

        if (isSelected) {
            cellComponent.setBackground(tableSelectionBackground);
            cellComponent.setForeground(tableSelectionForeground);
        } else {
            boolean isEvenRow = row % 2 == 0;
            if (table.getComponentOrientation().isLeftToRight()) {
                cellComponent.setBackground(isEvenRow ? tableBackground : tableSelectionInactiveBackground);
            } else {
                cellComponent.setBackground(isEvenRow ? tableForeground : tableSelectionInactiveBackground);
            }
            cellComponent.setForeground(tableForeground);
        }

        return cellComponent;
    }
}