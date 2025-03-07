package br.org.acal.application.screen.address.model;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class AddressTableModel extends AbstractTableModel {

    private final List<AddressTable> addresses;

    private final String[] columns = new String[]{"Nome:"};

    public AddressTableModel(List<AddressTable> addresses){
        this.addresses = addresses;
    }
    @Override
    public String getColumnName(int columnIndex) {
        return columns[columnIndex];
    }

    @Override
    public int getRowCount() {
        return addresses.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        AddressTable address = addresses.get(rowIndex);

        return switch (columnIndex) {
            case 0 -> address.getName();
            default -> throw new IndexOutOfBoundsException("Campo Não Encontrado");
        };

    }
}
