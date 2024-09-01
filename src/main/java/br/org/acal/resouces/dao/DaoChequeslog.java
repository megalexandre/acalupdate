package br.org.acal.resouces.dao;

import br.org.acal.resouces.entidades.Chequeslog;
import br.org.acal.infra.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DaoChequeslog  {

    
    public List<Chequeslog> BuscarChequeLog(String nome) {
       
        List<Chequeslog> cheque = null;
        Session sessao = null; 
        Query query = null;
        Transaction tx = null;
         
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           tx = sessao.beginTransaction();
           query = sessao.createQuery("implementar ");
           query.setParameter("nome",nome);
           cheque =  query.list();
           tx.commit(); 
           
        }
        catch(HibernateException e)
        {
            System.out.println(e);
            tx.rollback();
        }
        finally
        {
             sessao.close();
        }  
    return cheque;
        
        
    }
    //testado
    
    public List<Chequeslog> BuscarTodosChequesLog() {
        
        List<Chequeslog> cheque = null;
        Session sessao = null; 
        Query query = null;
        Transaction tx = null;
         
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           tx = sessao.beginTransaction();
           query = sessao.createQuery("from Chequeslog ");
           cheque =  query.list();
           tx.commit(); 
           
        }
        catch(HibernateException e)
        {
            System.out.println(e);
            tx.rollback();
        }
        finally
        {
             sessao.close();
        }  
    return cheque;
    }

    
    public Chequeslog BuscarChequeLogPorId(int id) {
     
        Chequeslog cheque = null;
        Session sessao = null; 
        Query query = null;
        Transaction tx = null;
         
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           tx = sessao.beginTransaction();
           query = sessao.createQuery("implementar ");
           query.setParameter("id",id);
           cheque =(Chequeslog)query.uniqueResult();
           tx.commit(); 
           
        }
        catch(HibernateException e)
        {
            System.out.println(e);
            tx.rollback();
        }
        finally
        {
             sessao.close();
        }  
    return cheque;
    }
    
}
