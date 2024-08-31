package br.org.acal.application.TableModel;

import br.org.acal.resouces.entidades.CaixaView;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class CaixaCompletoTableModel extends AbstractTableModel{
    
    private static final int numeroconta = 0;
    private static final int data        = 1;
    private static final int pagamento   = 2;
    private static final int vencimento  = 3;
    private static final int socio       = 4;
    private static final int endereco    = 5;
    private static final int numero      = 6;
    private static final int categoriaSocio = 7;
    private static final int taxaSocio   = 8;
    private static final int consumo     = 9;
    private static final int excessoValor = 10;
    private static final int totalconta = 11;
   
    private static final int data_set      = 1;
    private static final int vencimento_set= 2 ;
    private static final int pagamento_set = 3;
    private static final int consumo_set   = 4;
    
    private final List<CaixaView> linhas;
    
    public CaixaCompletoTableModel() {
        linhas = new ArrayList<>();
    }
    
    public CaixaCompletoTableModel(List<CaixaView> listaDoCaixa) {
        linhas = new ArrayList<>(listaDoCaixa);
    }
    
    private final String[] colunas = new String[] 
    {"Conta",
     "Data", 
     "Pagamento", 
     "Vencimento",
     "Socio",
     "Endereco", 
     "Numero", 
     "CategoriaSocio", 
     "TaxaSocio", 
     "Consumo", 
     "ExcessoValor", 
     "Total"
    };

    
    @Override
    public int getRowCount(){
       return linhas.size();  
    }
    
    
    @Override
    public int getColumnCount() {
      return colunas.length;
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    };
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return switch (columnIndex) {
            case numeroconta -> Integer.class;
            case data -> Date.class;
            case pagamento -> Date.class;
            case vencimento -> Date.class;
            case socio -> String.class;
            case endereco -> String.class;
            case numero -> Integer.class;
            case categoriaSocio -> String.class;
            case taxaSocio -> BigDecimal.class;
            case consumo -> Integer.class;
            case excessoValor -> BigDecimal.class;
            case totalconta -> BigDecimal.class;
            default -> throw new IndexOutOfBoundsException("Index Não Encontrado");
        };
    }
     
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
   
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
    
    CaixaView c = linhas.get(rowIndex);

        return switch (columnIndex) {
            case numeroconta -> c.getNumeroconta();
            case data -> c.getData();
            case pagamento -> c.getPagamento();
            case vencimento -> c.getVencimento();
            case socio -> c.getSocio();
            case endereco -> c.getEndereco();
            case numero -> c.getNumero();
            case categoriaSocio -> c.getCategoriaSocio();
            case taxaSocio -> c.getTaxaSocio();
            case consumo -> c.getConsumo();
            case excessoValor -> c.getExcessoValor();
            case totalconta -> c.getTotalconta();
            default -> throw new IndexOutOfBoundsException("Campo Não Encontrado");
        };
    }
    
     public void setValueAt(CaixaView aValue, int rowIndex) {  
        CaixaView conta = linhas.get(rowIndex); // Carrega o item da linha que deve ser modificado  
  
        conta.setData(aValue.getData());
        conta.setVencimento(aValue.getVencimento());
        conta.setPagamento(aValue.getPagamento());
        conta.setConsumo(aValue.getConsumo());
        
        fireTableCellUpdated(rowIndex, data_set);  
        fireTableCellUpdated(rowIndex, vencimento_set);  
        fireTableCellUpdated(rowIndex, pagamento_set);       
        fireTableCellUpdated(rowIndex, consumo_set); 
        
    }  
     
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
   /*
        CaixaView c = linhas.get(rowIndex);

    switch (columnIndex) {
            case data_set:
             c.setData((Date) aValue);
            break;
            case vencimento_set:
             c.setVencimento((Date) aValue);
            break;    
            case pagamento_set:
             c.setPagamento((Date) aValue);
            break;
            case consumo_set:
             c.setConsumo((Double)aValue);
            break;
      default:
      throw new IndexOutOfBoundsException("Alteração de ID Não permintida ou Index inválido");
   }
    */
   fireTableCellUpdated(rowIndex, columnIndex);
   }
   
    // Retorna o sócio referente a linha especificada
    public CaixaView getLinha(int indiceLinha) {
        return linhas.get(indiceLinha);
    }
 
    // Adiciona o sócio especificado ao modelo
    public void addLinha(CaixaView caixa) {
    // Adiciona o registro.
    linhas.add(caixa);
 
    // Pega a quantidade de registros e subtrai 1 para
    // achar o último índice. A subtração é necessária
    // porque os índices começam em zero.
    int ultimoIndice = getRowCount() - 1;
 
    // Notifica a mudança.
    fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }
 
    // Remove o sócio da linha especificada.
    public void removeLinha(int indiceLinha) {
    // Remove o registro.
    linhas.remove(indiceLinha);
 
    // Notifica a mudança.
    fireTableRowsDeleted(indiceLinha, indiceLinha);
    }
 
    // Adiciona uma lista de sócios no final da lista.
    public void addListaDeConta(List<CaixaView> caixaLinha) {
         int indice = getRowCount();
         linhas.addAll(caixaLinha);
         fireTableRowsInserted(indice, indice + caixaLinha.size());
    }
 
    // Remove todos os registros.
    public void limpar() {
        // Remove todos os elementos da lista de sócios.
        linhas.clear();
 
        // Notifica a mudança.
        fireTableDataChanged();
    }   
}
