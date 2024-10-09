package br.org.acal.application.screen.render;

import br.org.acal.application.screen.invoice.model.table.InvoiceTableModel;
import lombok.val;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.Color;
import java.awt.Component;

import static br.org.acal.commons.Colors.COLOR_INFO_400;
import static br.org.acal.commons.Colors.COLOR_INFO_500;

public class InvoiceTableCellRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        val model = (InvoiceTableModel) table.getModel();
        val invoice = model.getInvoiceAt(row).getInvoice();

        if(row % 2 == 0){
            cellComponent.setBackground(COLOR_INFO_400);
            cellComponent.setForeground(Color.WHITE);
        } else {
            cellComponent.setBackground(COLOR_INFO_500);
            cellComponent.setForeground(Color.BLACK);
        }

         /*
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

        if(isSelected){
            cellComponent.setBackground(COLOR_INFO_100);
            cellComponent.setForeground(COLOR_INFO_800);
        }
        else if(invoice.status() == StatusPaymentInvoice.OPEN){
            cellComponent.setBackground(COLOR_PRIMARY_100);
            cellComponent.setForeground(COLOR_PRIMARY_900);
        }
        else if(invoice.status() == StatusPaymentInvoice.PAYED){
            cellComponent.setBackground(COLOR_SUCCESS_100);
            cellComponent.setForeground(COLOR_SUCCESS_900);
        }
        else if(invoice.status() == StatusPaymentInvoice.OVERDUE){
            cellComponent.setBackground(COLOR_DANGER_100);
            cellComponent.setForeground(COLOR_DANGER_900);
        }
        Color tableForeground = UIManager.getColor("Table.foreground");
        Color tableBackground = UIManager.getColor("Table.background");
        Color tableSelectionForeground = UIManager.getColor("Table.selectionForeground");
        Color tableSelectionBackground = UIManager.getColor("Table.selectionBackground");
        Color tableSelectionInactiveForeground = UIManager.getColor("Table.selectionInactiveForeground");
        Color tableSelectionInactiveBackground = UIManager.getColor("Table.selectionInactiveBackground");


        */

        return cellComponent;
    }
}