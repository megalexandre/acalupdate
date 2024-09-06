package br.org.acal.application.screen.invoice;

import br.org.acal.application.screen.customer.CustomerTable;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class InvoiceTableModel extends AbstractTableModel {
    private final int NUMBER = 0;
    private final int PAYED_AT = 1;
    private final int DUO_DATE = 2;
    private final int PERIOD = 3;
    private final int CUSTOMER= 4;
    private final List<InvoiceTable> itens;
    private final String[] columns = new String[]{"#","Pago em:", "Vencimento:", "Periodo:", "Cliente:" };

    public InvoiceTableModel(List<InvoiceTable> itens){
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
        InvoiceTable item = itens.get(rowIndex);

        return switch (columnIndex) {
            case NUMBER -> item.getNumber();
            case PAYED_AT -> item.getPayedAt();
            case DUO_DATE -> item.getDuoDate();
            case PERIOD -> item.getPeriod();
            case CUSTOMER -> item.getCustomer();
            default -> throw new IndexOutOfBoundsException("Campo Não Encontrado");
        };
    }
}
