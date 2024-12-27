package br.org.acal.application.screen.render;

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

        val dark = Color.DARK_GRAY;
        val blue = UIManager.getColor("Actions.Blue");
        val green = UIManager.getColor("Actions.Green");
        val red = UIManager.getColor("Actions.Red");
        val yellow = UIManager.getColor("Actions.Yellow");
        val grey  = UIManager.getColor("Table.selectionInactiveBackground");;


        if (isSelected) {

            cellComponent.setBackground(blue);
        } else {

            if(item.isInactive()){
                cellComponent.setForeground(dark);
                cellComponent.setBackground(grey);
            } else {
                cellComponent.setForeground(dark.darker());
                cellComponent.setBackground(grey.brighter());
            }
        }

        return cellComponent;
    }
}