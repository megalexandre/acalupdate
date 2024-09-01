package br.org.acal.resouces.dao;

import java.util.ArrayList;
import java.util.List;

import br.org.acal.resouces.entidades.Motivoentrada;
import br.org.acal.infra.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
public class DaoMotivoEntrada{

    
    public void AdicionarMotivoEntrada(Motivoentrada motivo) {
        
        Session sessao= null;
        Transaction transacao = null;
        
        try{
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            sessao.save(motivo); 
            transacao.commit();
            System.out.println("Salvo com sucesso");  
        }
        catch(HibernateException e)
        {
            System.out.println("Erro ao iniciar a sessao para persistencia " + e);
            transacao.rollback();
        }
        finally
        {
            sessao.close(); 
        }      
    }

    
    public void ApagarMotivoEntrada(Motivoentrada motivo) {
      
        Session sessao= null;
        Transaction transacao = null;
        
        try{
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            sessao.delete(motivo); 
            transacao.commit();
            System.out.println("Salvo com sucesso");  
        }
        catch(HibernateException e)
        {
            System.out.println("Erro ao iniciar a sessao para persistencia " + e);
            transacao.rollback();
        }
        finally
        {
            sessao.close(); 
        }      
    }
    
     
    public Motivoentrada BuscarMotivoEntradaId(int id) {
       
        Motivoentrada motivoEntrada = null;
        Session sessao = null; 
        Query query = null;
        Transaction transacao = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           transacao = sessao.beginTransaction();
           query = sessao.createQuery("from Motivoentrada where id = :id");
           query.setParameter("id",id);
           motivoEntrada = (Motivoentrada)query.uniqueResult();
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
    return motivoEntrada;
    }
    
    
    public List<Motivoentrada> BuscarMotivoEntradaLikeNome(String nome)
    {
        List<Motivoentrada> motivoEntrada = null;
        Session sessao = null; 
        Query query = null;
        Transaction transacao = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           transacao = sessao.beginTransaction();
           query = sessao.createQuery("from Motivoentrada m where m.nome LIKE :nome");
           query.setParameter("nome","%"+nome+"%");
           //query.setParameter("nome",nome);
           motivoEntrada = query.list();
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
    return motivoEntrada;
    }
    
    
    public void AlterarMotivoEntrada(Motivoentrada motivo) {
       
        Session sessao= null;
        Transaction transacao = null;
        
        try{
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            sessao.saveOrUpdate(motivo); 
            transacao.commit();
            System.out.println("Salvo com sucesso");  
        }
        catch(HibernateException e)
        {
            System.out.println("Erro ao iniciar a sessao para persistencia " + e);
            transacao.rollback();
        }
        finally
        {
            sessao.close(); 
        }      
    }
    
    
    public List<Motivoentrada> BuscarMotivo(String nome) {
        
        Session sessao= null;
        Transaction transacao = null;
        List<Motivoentrada> lista = new ArrayList<>();
       
        try{
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            String HQL_QUERY="FROM MotivoEntrada m where  lower(m.nome) like lower(:nome) order by nome";
            Query query = sessao.createQuery(HQL_QUERY);
            query.setParameter("nome",'%'+nome+'%' );
            
            lista = query.list();
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
    return lista;
    }

    
    public List<Motivoentrada> BuscarTodosMotivos() {
        
        Session sessao= null;
        Transaction transacao = null;
        List<Motivoentrada> lista = new ArrayList<>();
       
        try{
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            String HQL_QUERY="FROM Motivoentrada order by nome";
            Query query = sessao.createQuery(HQL_QUERY);       
            lista = query.list();
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
     return lista;
    }
    
}
