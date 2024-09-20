package br.org.acal.resouces.dao;

import br.org.acal.resouces.entidades.Funcionario;
import br.org.acal.infra.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
public class DaoFuncionario{

    
    public void AdicionarFuncionario(Funcionario funcionario) {
      throw new RuntimeException("");
    }
    public void ApagarFuncionario(Funcionario funcionario) {
        throw new RuntimeException("");
    }
    public void AlterarFuncionario(Funcionario funcionario) {
        throw new RuntimeException("");
    }

    public List<Funcionario> BuscarFuncionarioLikeNome(String nome) {
        throw new RuntimeException("");
    }

     public Funcionario BuscarFuncionarioCpf(String Cpf) {
         throw new RuntimeException("");
    }

    public Funcionario BuscarFuncionario(String nome) {
        throw new RuntimeException("");
    }

    public List<Funcionario> BuscarFuncionarios() {
        throw new RuntimeException("");
    }

}
