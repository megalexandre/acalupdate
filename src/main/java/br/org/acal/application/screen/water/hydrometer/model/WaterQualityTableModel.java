package br.org.acal.application.screen.water.hydrometer.model;

import br.org.acal.domain.entity.WaterQuality;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class WaterQualityTableModel extends AbstractTableModel {

    private final int NUMBER = 0;
    private final int NAME = 1;
    private final int DATE = 2;
    private final int REQUIRED = 3;
    private final int ANALYZED = 4;
    private final int ACCORDANCE = 5;

    private final List<WaterQualityTable> items;

    private final String[] columns = new String[]{"#","Nome:", "Data:", "Exigido:", "Analizado:", "Conforme:"};

    public WaterQualityTableModel(List<WaterQualityTable> items){
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

    public WaterQuality getItem(int index){
        return items.get(index).getWaterQuality();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        WaterQualityTable item = items.get(rowIndex);
        return switch (columnIndex) {
            case NUMBER -> item.getNumber();
            case NAME -> item.getName();
            case DATE -> item.getDate();
            case REQUIRED -> item.getRequired();
            case ANALYZED -> item.getAnalyzed();
            case ACCORDANCE -> item.getAccordance();
            default -> throw new IndexOutOfBoundsException("Campo Não Encontrado");
        };
    }
}
