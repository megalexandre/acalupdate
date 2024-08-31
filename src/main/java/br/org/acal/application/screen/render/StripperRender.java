package br.org.acal.application.screen.render;

import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.Color;
import java.awt.Component;

public class StripperRender extends DefaultTableCellRenderer {
    private static final Color TABLE_BACKGROUND = UIManager.getColor("Table.background");
    private static final Color TABLE_FOREGROUND_COLOR = UIManager.getColor("Table.foreground");
    private static final Color ALTERNATE_COLOR = UIManager.getColor("Table.alternateRowColor");
    private static final Color SELECTED_COLOR = UIManager.getColor("Table.selectionBackground");
    private static final Color SELECTED_TEXT_COLOR = UIManager.getColor("Table.selectionForeground");


    @Override
    public Component getTableCellRendererComponent(
            JTable table, Object value, boolean isSelected,boolean hasFocus, int row, int column) {

        Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (isSelected) {
            cellComponent.setBackground(SELECTED_COLOR);
            cellComponent.setForeground(SELECTED_TEXT_COLOR);
        } else {
            cellComponent.setBackground(row % 2 == 0 ? TABLE_BACKGROUND : ALTERNATE_COLOR);
            cellComponent.setForeground(TABLE_FOREGROUND_COLOR);
        }

        return cellComponent;
    }
}

    
