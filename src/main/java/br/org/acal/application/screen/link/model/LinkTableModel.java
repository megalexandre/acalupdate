package br.org.acal.application.screen.link.model;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class LinkTableModel extends AbstractTableModel {

    private final List<LinkTable> items;
    private final String[] columns = new String[]{
         "Endereço:", "Número:", "Nome:", "Categoria:", "Grupo:", "Ativo:"
    };

    public LinkTableModel(List<LinkTable> items){
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
        LinkTable item = items.get(rowIndex);

        return switch (columnIndex) {
            case 0 -> item.getAddress();
            case 1 -> item.getNumber();
            case 2 -> item.getName();
            case 3 -> item.getCategory();
            case 4 -> item.getGroup();
            case 5 -> item.getInactive();
            default -> throw new IndexOutOfBoundsException("Campo Não Encontrado");
        };

    }


}
