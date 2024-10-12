package br.org.acal.application.screen.invoice.model.table;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class CreateInvoiceTableModel extends AbstractTableModel {

    private final int CUSTOMER = 0;
    private final int LINK_NUMBER = 1;
    private final int ADDRESS = 2;
    private final int GROUP = 3;
    private final int CATEGORY = 4;
    private final int WATER = 5;
    private final int TOTAL = 6;
    private final int CHECKED = 7;

    public final List<CreateInvoiceTable> items;

    private final String[] columns = new String[]{
            "SÓCIO:",
            "NÚMERO",
            "ENDEREÇO",
            "CATEGORIA",
            "GRUPO",
            "CONSUMO",
            "TOTAL:",
            "SELECIONADO"};

    public CreateInvoiceTableModel(List<CreateInvoiceTable> items){
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
        CreateInvoiceTable table = items.get(rowIndex);
        return switch (columnIndex) {
            case CUSTOMER -> table.getCustomer();
            case LINK_NUMBER -> table.getLinkNumber();
            case ADDRESS -> table.getAddress();
            case GROUP -> table.getGroup();
            case CATEGORY -> table.getCategory();
            case WATER -> table.getWater();
            case TOTAL -> table.getTotal();
            case CHECKED -> table.getChecked();
            default -> throw new IndexOutOfBoundsException("Campo Não Encontrado");
        };
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == CHECKED) {
            return Boolean.class;
        } else {
            return String.class;
        }
    }


    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == CHECKED;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if (columnIndex == CHECKED) {
            CreateInvoiceTable table = items.get(rowIndex);
            table.setChecked((Boolean) aValue);
            fireTableCellUpdated(rowIndex, columnIndex);
        }
    }

}
