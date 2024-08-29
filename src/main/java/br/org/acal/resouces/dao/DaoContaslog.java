/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.acal.resouces.dao;

import java.util.List;

import br.org.acal.resouces.entidades.Contaslog;
import br.org.acal.infra.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DaoContaslog{
//testado
    
    public Contaslog ListarPorId(int id) {
         
        Contaslog contaslog = null;
        Session sessao = null; 
        Query query = null;
        Transaction tx = null;
         
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           tx = sessao.beginTransaction();
           query = sessao.createQuery("from Contaslog c where c.id = :id  ");
           query.setParameter("id",id);
           contaslog = (Contaslog) query.uniqueResult();
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
        return contaslog;
    }
    //testado
    
    public List<Contaslog> ListarPorTipo(String tipo) {
        List<Contaslog> contaslog = null;
        Session sessao = null; 
        Query query = null;
        Transaction tx = null;
         
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           tx = sessao.beginTransaction();
           query = sessao.createQuery("from Contaslog  where  tipo = :tipo  ");
           query.setParameter("tipo",tipo);
           contaslog =  query.list();
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
        return contaslog;
    }
   //testado
    
    public List<Contaslog> ListarTodas() {
     
        List<Contaslog> contaslog = null;
        Session sessao = null; 
        Query query = null;
        Transaction tx = null;
         
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           tx = sessao.beginTransaction();
           query = sessao.createQuery("from Contaslog   ");
           contaslog =  query.list();
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
        return contaslog;
    }
    
}
