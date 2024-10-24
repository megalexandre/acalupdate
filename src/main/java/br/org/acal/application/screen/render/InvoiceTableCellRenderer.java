package br.org.acal.application.screen.render;

import br.org.acal.application.screen.invoice.model.table.InvoiceTableModel;
import lombok.val;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.Color;
import java.awt.Component;

import static br.org.acal.commons.Colors.COLOR_INFO_400;
import static br.org.acal.commons.Colors.COLOR_INFO_500;

public class InvoiceTableCellRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        Color tableForeground = UIManager.getColor("Table.foreground");
        Color tableBackground = UIManager.getColor("Table.background");
        Color tableSelectionForeground = UIManager.getColor("Table.selectionForeground");
        Color tableSelectionBackground = UIManager.getColor("Table.selectionBackground");
        Color tableSelectionInactiveForeground = UIManager.getColor("Table.selectionInactiveForeground");
        Color tableSelectionInactiveBackground = UIManager.getColor("Table.selectionInactiveBackground");

        val model = (InvoiceTableModel) table.getModel();
        val invoice = model.getInvoiceAt(row).getInvoice();


        if(isSelected){

            cellComponent.setBackground(UIManager.getColor("Actions.Blue"));
            cellComponent.setForeground(UIManager.getColor("Actions.Blue").darker());

        } else {
            val isPair = row % 2 == 0;

            if(invoice.isPayed()) {

                if(isPair) {
                    cellComponent.setBackground(UIManager.getColor("Actions.Green"));
                } else {
                    cellComponent.setBackground(UIManager.getColor("Actions.Green").brighter());
                }

            } else {
                if(isPair){

                    cellComponent.setBackground(tableBackground);
                    cellComponent.setForeground(tableForeground);
                } else {

                    cellComponent.setBackground(tableSelectionInactiveBackground);
                    cellComponent.setForeground(tableForeground);
                }
            }
        }




        return cellComponent;
    }
}