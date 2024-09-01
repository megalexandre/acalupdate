package br.org.acal.resouces.dao.view;

import java.util.List;

import br.org.acal.resouces.entidades.EnderecoView;
import br.org.acal.infra.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DaoEnderecoView {
 
    public List<EnderecoView> BuscarTodosEnderecos() {
        
        List<EnderecoView> endereco = null;
        Session sessao = null; 
        Query query = null;
        Transaction transacao = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           transacao = sessao.beginTransaction();
           query = sessao.createQuery("from EnderecoView ");
           endereco = query.list();
           transacao.commit(); 
           
        }
        catch(HibernateException e)
        {
            System.out.println(e);
            transacao.rollback();
        }
        finally
        {
             sessao.close();
        }  
    return endereco;
    }
    
}
