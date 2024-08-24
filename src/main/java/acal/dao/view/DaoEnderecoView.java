/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package acal.dao.view;

import java.util.List;

import acal.entidades.EnderecoView;
import acal.infra.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
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
