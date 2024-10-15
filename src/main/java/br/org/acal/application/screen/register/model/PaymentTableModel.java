package br.org.acal.application.screen.register.model;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class PaymentTableModel extends AbstractTableModel {

    private final int NUMBER = 0;
    private final int CUSTOMER = 1;
    private final int ADDRESS = 2;
    private final int CREATED_AT = 3;
    private final int VALUE = 4;

    private final List<PaymentTable> items;

    private final String[] columns = new String[]{
        "Número","Cliente", "Endereço","Data:","Valor:"
    };

    public PaymentTableModel(List<PaymentTable> items){
        this.items = items;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columns[columnIndex];
    }

    @Override
    public int getRowCount() {
        return items.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        PaymentTable item = items.get(rowIndex);

        return switch (columnIndex) {
            case NUMBER -> item.getNumber();
            case CUSTOMER -> item.getCustomer();
            case ADDRESS -> item.getAddress();
            case CREATED_AT -> item.getCreatedAt();
            case VALUE -> item.getValue();
            default -> throw new IndexOutOfBoundsException("Campo Não Encontrado");
        };

    }

    public PaymentTable getInvoiceAt(int rowIndex) {
        return items.get(rowIndex);
    }

}
