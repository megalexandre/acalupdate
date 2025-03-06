package br.org.acal.application.screen.customer.model;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class CustomerTableModel extends AbstractTableModel {

    private final int COUNT = 0;
    private final int NUMBER = 1;
    private final int NAME = 2;
    private final int DOCUMENT = 3;

    private final List<CustomerTable> items;
    private final String[] columns = new String[]{"#:","Número:","Nome:", "Documento:"};

    public CustomerTableModel(List<CustomerTable> items){
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
        CustomerTable item = items.get(rowIndex);

        return switch (columnIndex) {
            case COUNT -> item.getCount();
            case NUMBER -> item.getNumber();
            case NAME -> item.getName();
            case DOCUMENT -> item.getDocument();
            default -> throw new IndexOutOfBoundsException("Campo Não Encontrado");
        };
    }
}
