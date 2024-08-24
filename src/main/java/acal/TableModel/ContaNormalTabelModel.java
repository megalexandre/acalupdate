package acal.TableModel;

import acal.entidades.CaixaView;

import javax.swing.table.AbstractTableModel;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author megalexandre
 */
public class ContaNormalTabelModel  extends AbstractTableModel{   

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
   
    
    
    private List<CaixaView> linhas;
    
    public ContaNormalTabelModel() {
        linhas = new ArrayList<>();
    }
    
    public ContaNormalTabelModel(List<CaixaView> listaDoCaixa) {
        linhas = new ArrayList<>(listaDoCaixa);
    }
    
    private String[] colunas = new String[] 
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
        switch (columnIndex) {
            case numeroconta:
            return Integer.class;
            case data:
            return Date.class;
            case pagamento:
            return Date.class;
            case vencimento:
            return Date.class;
            case socio:
            return String.class;
            case endereco:
            return String.class;
            case numero:
            return Integer.class;
            case categoriaSocio:
            return String.class;     
            case taxaSocio:
            return BigDecimal.class;  
            case consumo:
            return Integer.class;
            case excessoValor:
            return BigDecimal.class;
            case totalconta:
            return BigDecimal.class;
        default:
        throw new IndexOutOfBoundsException("Index Não Encontrado");
        }
    }
     
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return  false;
    }
   
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
    
    CaixaView c = linhas.get(rowIndex);
 
        switch (columnIndex) {
            case numeroconta:
            return c.getNumeroconta();
            case data:
            return c.getData();
            case pagamento:
            return c.getPagamento();
            case vencimento:
            return c.getVencimento();
            case socio:
            return c.getSocio();
            case endereco:
            return c.getEndereco();
            case numero:
            return c.getNumero();
            case categoriaSocio:
            return c.getCategoriaSocio();
            case taxaSocio:
            return c.getTaxaSocio();
            case consumo:
            return c.getConsumo();
            case excessoValor:
            return c.getExcessoValor();
            case totalconta:
            return c.getTotalconta();
        default:
        throw new IndexOutOfBoundsException("Campo Não Encontrado");
        }
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
    CaixaView c = linhas.get(rowIndex);
 //nao 'e possivel alterar nada nessa tabela que veem de uma view
//     switch (columnIndex) {
//            case ID:
//                System.out.println("erro, alteração de id invalido");
//            break;
//            case NOME:
//             pessoa.setNome((String)aValue);
//            break;    
//            case CPFCNPJ:
//             pessoa.setCpfCnpj((String)aValue);
//            break;
//            case EMAIL:
//             pessoa.setEmail((String)aValue);
//            break;
//            case STATUS:
//             pessoa.setStatus((Boolean) aValue);
//           break;
//      default:
//      throw new IndexOutOfBoundsException("Alteração de ID Não permintida ou Index inválido");
//      
 //    }
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
    public void addListaDeCaixa(List<CaixaView> caixaLinha) {
        // Pega o tamanho antigo da tabela, que servirá
        // como índice para o primeiro dos novos registros
        int indice = getRowCount();
 
        // Adiciona os registros.
         linhas.addAll(caixaLinha);
 
        // Notifica a mudança.
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
