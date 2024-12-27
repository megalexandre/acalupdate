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

        val model = (InvoiceTableModel) table.getModel();
        val invoice = model.getInvoiceAt(row).getInvoice();

        val dark = UIManager.getColor("Actions.Dark");
        val blue = UIManager.getColor("Actions.Blue");
        val green = UIManager.getColor("Actions.Green");
        val red = UIManager.getColor("Actions.Red");
        val yellow = UIManager.getColor("Actions.Yellow");
        val grey  = UIManager.getColor("Table.selectionInactiveBackground");;

        val isPair = row % 2 == 0;

        cellComponent.setForeground(dark);

        if(isSelected){

            if(isPair){
                cellComponent.setBackground(blue);
            } else{
                cellComponent.setBackground(blue.brighter());
            }

        } else {


            if(invoice.isPayed()) {

                if(isPair) {
                    cellComponent.setBackground(green);
                } else {
                    cellComponent.setBackground(green.brighter());
                }

            } else {

                if(invoice.isOverDue()){

                    if(isPair){
                        cellComponent.setBackground(red);
                    }else {
                        cellComponent.setBackground(red.brighter());
                    }

                } else {

                    if(isPair){
                        cellComponent.setBackground(grey);
                    } else {
                        cellComponent.setBackground(grey.brighter());
                    }
                }
            }
        }

        return cellComponent;
    }
}