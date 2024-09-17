package br.org.acal.resouces.dao.view;

import br.org.acal.resouces.entidades.CaixaView;

import java.util.Date;
import java.util.List;
public class DaoCaixaView {
    
     public List<CaixaView> BuscarTodosCaixaView() {
         throw new RuntimeException("Legacy flow");
    }
    
    public List<CaixaView> BuscarTodosCaixaViewDatePagamento(Date ini, Date fim) {
        throw new RuntimeException("Legacy flow");
    }
    public List<CaixaView> BuscarTodosCaixaViewDateVencimento(Date ini, Date fim) {
        throw new RuntimeException("Legacy flow");
    }

     public List<CaixaView> BuscarSocioNome(String socio) {
         throw new RuntimeException("Legacy flow");
    }
     
    public List<CaixaView> BuscarLogradouro(String endereco) {
        throw new RuntimeException("Legacy flow");
    }
      
    public List<CaixaView> BuscarStatus(int status) {
        throw new RuntimeException("Legacy flow");
    }

    public List<CaixaView> BuscarSocioLogradouro(String endereco, String socio) {
        throw new RuntimeException("Legacy flow");
    }
    
    public List<CaixaView> BuscarSocioStatus(int status, String socio) {
        throw new RuntimeException("Legacy flow");
    }
    
    public List<CaixaView> BuscarLogradouroStatus(int status, String end) {
        throw new RuntimeException("Legacy flow");
    }

    public List<CaixaView> BuscarTodosCriterios(int status, String socio, String endereco) {
        throw new RuntimeException("Legacy flow");
    }
}

