package br.org.acal.application.screen.render;

import br.org.acal.application.screen.invoice.model.table.InvoiceTableModel;
import br.org.acal.application.screen.link.model.LinkTableModel;
import lombok.val;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class LinkTableCellRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        val model = (LinkTableModel) table.getModel();
        val item = model.getItem(row);

        Color tableForeground = UIManager.getColor("Table.foreground");
        Color tableBackground = UIManager.getColor("Table.background");
        Color tableSelectionForeground = UIManager.getColor("Table.selectionForeground");
        Color tableSelectionBackground = UIManager.getColor("Table.selectionBackground");
        Color tableSelectionInactiveForeground = UIManager.getColor("Table.selectionInactiveForeground");
        Color tableSelectionInactiveBackground = UIManager.getColor("Table.selectionInactiveBackground");

        boolean isEvenRow = row % 2 == 0;
        if (isSelected) {

            if(isEvenRow){
                cellComponent.setBackground(tableSelectionBackground);
                cellComponent.setForeground(tableSelectionForeground);
            } else {
                cellComponent.setBackground(tableSelectionBackground.darker());
                cellComponent.setForeground(tableSelectionForeground.darker());
            }

        } else {

            if(item.isInactive()){
               cellComponent.setForeground(tableSelectionInactiveForeground.brighter());
               cellComponent.setBackground(tableSelectionInactiveBackground);
            } else {

                if (isEvenRow) {
                    cellComponent.setBackground(tableBackground);
                    cellComponent.setForeground(tableForeground);
                } else {
                    cellComponent.setBackground(tableBackground.darker());
                    cellComponent.setForeground(tableForeground.darker());
                }

            }

        }

        return cellComponent;
    }
}