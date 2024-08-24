package acal.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import acal.entidades.Saida;
import acal.infra.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DaoSaidas {

    
    public void AdicionarSaida(Saida saida) {
       
        Session sessao = null;
        Transaction transcao = null;
       
         try{
            sessao = HibernateUtil.getSessionFactory().openSession();
            transcao = sessao.beginTransaction();    
            sessao.save(saida); 
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

    
    public void AlterarSaida(Saida saida) {
       
        Session sessao = null;
        Transaction transcao = null;
       
         try{
            sessao = HibernateUtil.getSessionFactory().openSession();
            transcao = sessao.beginTransaction();    
            sessao.saveOrUpdate(saida); 
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

    
    public void ApagarSaida(Saida saida) {
        
        Session sessao = null;
        Transaction transcao = null;
       
         try{
            sessao = HibernateUtil.getSessionFactory().openSession();
            transcao = sessao.beginTransaction();    
            sessao.delete(saida); 
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

    
    public Saida BuscarSaidaId(int id) {
       
        Saida saida = null;
        Session sessao = null; 
        Query query = null;
        Transaction transacao = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           transacao = sessao.beginTransaction();
           query = sessao.createQuery("from Saida where id = :id");
           query.setParameter("id",id);
           saida = (Saida)query.uniqueResult();
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
    return saida;
    }
    
    
     public List<Saida> BuscarSaidaFavorecidoLikeNome(String nome)
    {
        List<Saida> saida = null;
        Session sessao = null; 
        Query query = null;
        Transaction transacao = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           transacao = sessao.beginTransaction();
           query = sessao.createQuery("from Saida s where s.favorecido LIKE :nome");
           query.setString("nome","%"+nome+"%");
           //query.setParameter("nome",nome);
           saida = query.list();
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
    return saida;
    }
    
    
    public BigDecimal SomaSaidas(Date inicio, Date fim) {
      
        BigDecimal saida = null;
        Session sessao = null; 
        Query query = null;
        Transaction tx = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           tx = sessao.beginTransaction();
           query = sessao.createSQLQuery("select sum(valor) from saida where data between :inicio and :fim");
           query.setParameter("inicio",inicio);
          query.setParameter("fim",fim);
         
           saida = (BigDecimal) query.uniqueResult();
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
    return saida;
        
        
    }
    
    
     public List<Saida> BuscarTodasSaidas() {
        
        List<Saida> saidas = null;
        Session sessao = null; 
        Query query = null;
        Transaction transacao = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           transacao = sessao.beginTransaction();
           query = sessao.createQuery("from Saida order by favorecido");
           saidas =  query.list();
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
    return saidas;
    }

    
    public List<Saida> SaidasPorFuncionario(int IdFuncionario) {
      
        List<Saida> saida = null;
        Session sessao = null; 
        Query query = null;
        Transaction tx = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           tx = sessao.beginTransaction();
           query = sessao.createQuery("from Saida where idFuncionaio = :idFuncionario");
           query.setParameter("IdFuncionario",IdFuncionario);
           
           saida = query.list();
           //saida = query.uniqueResult();
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
    return saida;
    }

    
    public List<Saida> SaidasPorData(Date inicio, Date fim) {
      
        List<Saida> saida = null;
        Session sessao = null; 
        Query query = null;
        Transaction tx = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           tx = sessao.beginTransaction();
           query = sessao.createQuery("from Saida where Data between :incio and :fim");
           query.setParameter("inicio",inicio);
           query.setParameter("fim",fim);
           
           
           saida = query.list();
           //saida = query.uniqueResult();
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
    return saida;
    }

    
    public List<Saida> SaidaPorDataPorFuncionario(int idFuncionario, Date inicio, Date fim) {
       
        List<Saida> saida = null;
        Session sessao = null; 
        Query query = null;
        Transaction tx = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           tx = sessao.beginTransaction();
           query = sessao.createQuery("from Saida where Idfuncionario = :idFuncionario Data between :incio and :fim");
           query.setParameter("idFuncionario",idFuncionario);
           query.setParameter("inicio",inicio);
           query.setParameter("fim",fim);
           
           
           saida = query.list();
           //saida = query.uniqueResult();
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
    return saida;
    }

    
    public List<Saida> SaidaPorFuncionarioPorMotivo(int Motivo, int IdFuncionario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public List<Saida> SaidasPorMotivo(int IdMotivoSaidas) {
       
        List<Saida> saida = null;
        Session sessao = null; 
        Query query = null;
        Transaction tx = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           tx = sessao.beginTransaction();
           query = sessao.createQuery("from Saida where id = :id");
           query.setParameter("id",IdMotivoSaidas);
           saida = query.list();
           //saida = query.uniqueResult();
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
    return saida;
    }

    
}
