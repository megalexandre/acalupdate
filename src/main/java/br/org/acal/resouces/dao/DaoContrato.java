package br.org.acal.resouces.dao;

import java.util.List;

import br.org.acal.resouces.entidades.Contrato;
import br.org.acal.infra.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
public class DaoContrato {

    public void AdcionarContrato(Contrato contrato) {
        
       Session sessao = null;
       Transaction transcao = null;
       
         try{
            sessao = HibernateUtil.getSessionFactory().openSession();
            transcao = sessao.beginTransaction();    
            sessao.save(contrato); 
            transcao.commit();
            System.out.println("Salvo com sucesso");  
        }
        catch(HibernateException e)
        {
            transcao.rollback();
        }
        finally
        {
            sessao.close(); 
        } 
    }
    
    public  void ApagarCategoria(Contrato contrato) {
       
        Session sessao = null;
        Transaction transcao = null;
       
         try{
            sessao = HibernateUtil.getSessionFactory().openSession();
            transcao = sessao.beginTransaction();    
            sessao.delete(contrato); 
            transcao.commit();
            System.out.println("Salvo com sucesso");  
        }
        catch(HibernateException e)
        {
            transcao.rollback();
        }
        finally
        {
            sessao.close(); 
        } 
    }

    
    public void AtualizarCategoria(Contrato contrato) {
   
        Session sessao = null;
       Transaction transcao = null;
       
         try{
            sessao = HibernateUtil.getSessionFactory().openSession();
            transcao = sessao.beginTransaction();    
            sessao.saveOrUpdate(contrato); 
            transcao.commit();
            System.out.println("Salvo com sucesso");  
        }
        catch(HibernateException e)
        {
            transcao.rollback();
        }
        finally
        {
            sessao.close(); 
        } 
    }

    
    public List<Contrato> BuscarContrato(int id) {
       
        List<Contrato> contrato = null;
        Session sessao = null; 
        Query query = null;
        Transaction transacao = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           transacao = sessao.beginTransaction();
           query = sessao.createQuery("from Contrato c where c.id :id");   
           query.setParameter("id", id);
           contrato = query.list();
           transacao.commit(); 
           
        }
        catch(HibernateException e)
        {
            transacao.rollback();
        }
        finally
        {
             sessao.close();
        }  
    return contrato;
    }
    
}
