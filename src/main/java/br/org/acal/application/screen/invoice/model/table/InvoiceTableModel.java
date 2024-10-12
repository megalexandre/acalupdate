package br.org.acal.application.screen.invoice.model.table;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class InvoiceTableModel extends AbstractTableModel {

    private final int CUSTOMER = 0;
    private final int DOCUMENT = 1;
    private final int ADDRESS = 2;
    private final int NUMBER = 3;
    private final int PERIOD = 4;
    private final int DUO_DATE = 5;
    private final int PAYED_AT = 6;
    private final int TOTAL = 7;

    private final List<InvoiceTable> itens;

    private final String[] columns = new String[]{
        "Cliente","Documento:", "Endereço:", "Número", "Periodo","Vencimento:", "Pago em:", "Total:"
    };

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
            case CUSTOMER -> item.getCustomer();
            case DOCUMENT -> item.getDocument();
            case ADDRESS -> item.getAddress();
            case PAYED_AT -> item.getPayedAt();
            case NUMBER -> item.getNumber();
            case PERIOD -> item.getPeriod();
            case DUO_DATE -> item.getDuoDate();
            case TOTAL -> item.getTotal();
            default -> throw new IndexOutOfBoundsException("Campo Não Encontrado");
        };

    }

    public InvoiceTable getInvoiceAt(int rowIndex) {
        return itens.get(rowIndex);
    }

}
