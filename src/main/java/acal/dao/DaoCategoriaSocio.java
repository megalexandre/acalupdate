package acal.dao;

import acal.entidades.Categoriasocio;
import acal.infra.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DaoCategoriaSocio {
 
    public void AdicionarCategoria(Categoriasocio categoria) {
        
        Session sessao = null;
        Transaction transacao = null;
       
         try{
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            sessao.save(categoria); 
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
    }

    public void ApagarCategoria(Categoriasocio categoria) {
       
        Session sessao = null;
        Transaction transacao = null;
       
         try{
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            sessao.delete(categoria); 
            transacao.commit();
            System.out.println("Deletado com sucesso");  
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

    public void AtualizarCategoria(Categoriasocio categoria) {
       
        Session sessao =  null;
        Transaction transacao = null;
       
         try{
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            sessao.saveOrUpdate(categoria); 
            transacao.commit();
            System.out.println("Atualizado com sucesso");  
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

    public Categoriasocio BuscarCategoriaPorNome(String nome) {
        
        Categoriasocio categoriaSocio = null;
        Session sessao = null; 
        Query query = null;
        Transaction transacao = null;
        
        try{

           sessao = HibernateUtil.getSessionFactory().openSession();
           transacao = sessao.beginTransaction();
           query = sessao.createQuery("from Categoriasocio where nome = :nome");
           query.setParameter("nome", nome);
           categoriaSocio = (Categoriasocio) query.uniqueResult();
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
    return categoriaSocio;
    }

     public List<Categoriasocio> BuscarCategoriaPorNomeLike (String nome) {
        
        List<Categoriasocio> categoriaSocio = null;
        Session sessao = null; 
        Transaction transacao = null;
        
        try{

           sessao = HibernateUtil.getSessionFactory().openSession();
           transacao = sessao.beginTransaction();
           Query query = sessao.createQuery("from Categoriasocio where nome like  :nome");
           query.setString("nome","%"+nome+"%");
           categoriaSocio =  query.list();
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
    return categoriaSocio;
    }
     
    public List<Categoriasocio> BuscarTodasCategorias() {
        
        List<Categoriasocio> categoriaSocio = null;
        Session sessao = null; 
        Query query = null;
        Transaction transacao = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           transacao = sessao.beginTransaction();
           query = sessao.createQuery("from Categoriasocio order by nome");
           categoriaSocio =  query.list();
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
    return categoriaSocio;
    }
    

    public Categoriasocio BuscarCategoriaSocioPorId(int id) {
        
       Categoriasocio categoriaSocio = null;
        Session sessao = null; 
        Query query = null;
        Transaction transacao = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           transacao= sessao.beginTransaction();
           query = sessao.createQuery("from Categoriasocio where id = :id");
           query.setParameter("id", id);
           categoriaSocio =(Categoriasocio) query.uniqueResult();
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

        return categoriaSocio;
    }

}
