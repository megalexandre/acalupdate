package br.org.acal.resouces.dao;

import br.org.acal.resouces.entidades.Endereco;
import br.org.acal.infra.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DaoEndereco {

    
    public void AdicionarEndereco(Endereco endereco) {
        
        Session sessao = null;
        Transaction transcao = null;
       
         try{
            sessao = HibernateUtil.getSessionFactory().openSession();
            transcao = sessao.beginTransaction();    
            sessao.save(endereco); 
            transcao.commit();
             
        }
        catch(HibernateException e)
        {
            System.out.println("Erro ao iniciar a sessao para persistencia " + e);
            transcao.rollback();
        }
        finally
        {
            sessao.close(); 
        }
    }

    
    public void ApagarEndereco(Endereco endereco) {
      
        Session sessao = null;
        Transaction transcao = null;
       
         try{
            sessao = HibernateUtil.getSessionFactory().openSession();
            transcao = sessao.beginTransaction();    
            sessao.delete(endereco);
            transcao.commit();
            
        }
        catch(HibernateException e)
        {
            System.out.println("Erro ao iniciar a sessao para persistencia " + e);
            transcao.rollback();
        }
        finally
        {
            sessao.close(); 
        } 
    }

    
    public void AlterarEndereco(Endereco endereco) {
    
        Session sessao = null;
        Transaction transcao = null;
       
         try{
            sessao = HibernateUtil.getSessionFactory().openSession();
            transcao = sessao.beginTransaction();    
            sessao.update(endereco);
            transcao.commit();
            System.out.println("Salvo com sucesso");  
        }
        catch(HibernateException e)
        {
            System.out.println("Erro ao iniciar a sessao para persistencia " + e);
            transcao.rollback();
        }
        finally
        {
            sessao.close(); 
        }
    }

    
    public List<Endereco> BuscarEnderecoNomeLike(String nome) {
     
        List<Endereco> endereco = null;
        Session sessao = null; 
        Query query = null;
        Transaction transacao = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           transacao = sessao.beginTransaction();
           query = sessao.createQuery("from Endereco e where e.nome LIKE :nome");
           query.setParameter("nome","%"+nome+"%");
           //query.setParameter("nome",nome);
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

   public Endereco BuscarEnderecoCompleto(String nomeCompleto){
        
        Endereco endereco = null;
        Session sessao = null; 
        Query query = null;
        Transaction transacao = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           transacao = sessao.beginTransaction();
           query = sessao.createQuery
          ("from Endereco p where\n" +
          "lower(concat(p.tipo,' ', p.nome)) = lower(:nomeCompleto)");
           query.setParameter("nomeCompleto",nomeCompleto);
           endereco = (Endereco)query.uniqueResult();
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
    
    

    public List<Endereco> BuscarTodosEnderecos() {

        try (Session sessao = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transacao = sessao.beginTransaction();
            Query query = sessao.createQuery("from Endereco order by tipo, nome");
            List<Endereco> addess = query.list();
            transacao.commit();
            return addess;

        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }

    
    public Endereco BuscarPorId(int id) {
        
        Endereco endereco = null;
        Session sessao = null; 
        Query query = null;
        Transaction transacao = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           transacao = sessao.beginTransaction();
           query = sessao.createQuery("from Endereco e where e.id = :id");
           // query.setString("nome","%"+nome+"%");
          query.setParameter("id",id);
           endereco = (Endereco)query.uniqueResult();
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
