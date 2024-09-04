package br.org.acal.application.screen.customer;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class CustomerTableModel extends AbstractTableModel {
    private final int NUMBER = 0;
    private final int NAME = 1;
    private final int DOCUMENT = 2;
    private final List<CustomerTable> itens;
    private final String[] columns = new String[]{"#","nome:", "Documento:"};

    public CustomerTableModel(List<CustomerTable> itens){
        this.itens = itens;
    }
    @Override
    public String getColumnName(int columnIndex) {
        return columns[columnIndex];
    }
    @Override
    public int getRowCount() {
        return itens.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        CustomerTable item = itens.get(rowIndex);

        return switch (columnIndex) {
            case NUMBER -> item.getNumber();
            case NAME -> item.getName();
            case DOCUMENT -> item.getDocument();
            default -> throw new IndexOutOfBoundsException("Campo Não Encontrado");
        };
    }
}
