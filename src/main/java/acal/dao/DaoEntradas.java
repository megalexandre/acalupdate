package acal.dao;

import acal.entidades.Entrada;
import acal.infra.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class DaoEntradas  {

    
    public void AdicionarEntrada(Entrada entrada) {
        
        Session sessao = null;
        Transaction transcao = null;
       
         try{
            sessao = HibernateUtil.getSessionFactory().openSession();
            transcao = sessao.beginTransaction();    
            sessao.save(entrada); 
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

    
    public void ApagarEntrada(Entrada entrada) {
        
        Session sessao = null;
        Transaction transcao = null;
       
         try{
            sessao = HibernateUtil.getSessionFactory().openSession();
            transcao = sessao.beginTransaction();    
            sessao.delete(entrada); 
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
    
     public List<Entrada> BuscarEntradaCedenteLikeNome(String nome)
    {
        List<Entrada> entradas = null;
        Session sessao = null; 
        Query query = null;
        Transaction transacao = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           transacao = sessao.beginTransaction();
           query = sessao.createQuery("from Entrada e where e.idCedente.idPessoa.nome  LIKE :nome");
           query.setString("nome","%"+nome+"%");
           //query.setParameter("nome",nome);
           entradas = query.list();
           transacao.commit(); 
           Entrada e = new Entrada();
          
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
    return entradas;
    }
    
    
      public List<Entrada> BuscarTodasEntradas() {
        
        Session sessao= null;
        Transaction transacao = null;
        List<Entrada> lista = new ArrayList<>();
       
        try{
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            String HQL_QUERY="FROM Entrada";
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
    

    
    public void AlterarEntrada(Entrada entrada) {
       Session sessao = null;
        Transaction transcao = null;
       
         try{
            sessao = HibernateUtil.getSessionFactory().openSession();
            transcao = sessao.beginTransaction();    
            sessao.saveOrUpdate(entrada); 
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

    
    public BigDecimal SomarEntrada() {
        
        BigDecimal entrada = null;
        Session sessao = null; 
        Query query = null;
        Transaction tx = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           tx = sessao.beginTransaction();
           query = sessao.createSQLQuery("select sum(valor) from entrada where data between :inicio and :fim");
          //  query.setParameter("inicio",inicio);
          // query.setParameter("fim",fim);
    
           entrada = (BigDecimal) query.uniqueResult();
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
    return entrada;
    }

    
    public BigDecimal SomarEntradaPorFuncionario(int idfuncionario) {
        BigDecimal entrada = null;
        Session sessao = null; 
        Query query = null;
        Transaction tx = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           tx = sessao.beginTransaction();
           query = sessao.createSQLQuery("select sum(valor) from entrada where  idFuncionario = :idfuncioanario");
           //query.setParameter("inicio",inicio);
           //query.setParameter("fim",fim);
           query.setParameter("idfuncionario",idfuncionario);
           
           entrada = (BigDecimal) query.uniqueResult();
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
    return entrada;
    
    }

    
    public BigDecimal SomarEntradaPorData(Date inicio, Date fim) {
       BigDecimal entrada = null;
        Session sessao = null; 
        Query query = null;
        Transaction tx = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           tx = sessao.beginTransaction();
           query = sessao.createSQLQuery("select sum(valor) from entrada where data between :incio and :fim ");
           query.setParameter("inicio",inicio);
           query.setParameter("fim",fim);
           //query.setParameter("idfuncionario",idfuncionario);
           
           entrada = (BigDecimal) query.uniqueResult();
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
    return entrada;
    
    }
   
    
    public BigDecimal SomarEntradaPorFuncionarioPorData(int idfuncionario, Date inicio, Date fim) {
    
        BigDecimal entrada = null;
        Session sessao = null; 
        Query query = null;
        Transaction tx = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           tx = sessao.beginTransaction();
           query = sessao.createSQLQuery("select sum(valor) from entrada where  idFuncionario = :idfuncioanario and data between :inicio and :fim");
           query.setParameter("inicio",inicio);
           query.setParameter("fim",fim);
           query.setParameter("idfuncionario",idfuncionario);
           
           entrada = (BigDecimal) query.uniqueResult();
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
    return entrada;
        
    }

    
    public Entrada EntradaPorId(int id) {
    
        Entrada entrada = null;
        Session sessao = null; 
        Query query = null;
        Transaction tx = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           tx = sessao.beginTransaction();
           query = sessao.createQuery(" from Entrada where  id = :id");
           //query.setParameter("inicio",inicio);
           //query.setParameter("fim",fim);
           query.setParameter("id",id);
           
           entrada = (Entrada) query.uniqueResult();
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
    return entrada;
    
    }    
    

    
    public List<Entrada> EntradaPorFuncionario(int id) {
       
        List<Entrada> entrada = null;
        Session sessao = null; 
        Query query = null;
        Transaction tx = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           tx = sessao.beginTransaction();
           query = sessao.createQuery(" from entrada where idfuncionario = :idfuncionario");
           //query.setParameter("inicio",inicio);
           //query.setParameter("fim",fim);
           query.setParameter("id",id);
           
           entrada =  query.list();
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
    return entrada;
    }

    
    public List<Entrada> EntradaPorData(Date inicio, Date fim) {
    
        List<Entrada> entrada = null;
        Session sessao = null; 
        Query query = null;
        Transaction tx = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           tx = sessao.beginTransaction();
           query = sessao.createQuery(" from entrada where  data between :incio and :fim");
           query.setParameter("inicio",inicio);
           query.setParameter("fim",fim);
           //query.setParameter("id",id);
           
           entrada =  query.list();
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
    return entrada;
        
    
    }

    
    public List<Entrada> EntradaPorValor(int max, int min) {
    List<Entrada> entrada = null;
        Session sessao = null; 
        Query query = null;
        Transaction tx = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           tx = sessao.beginTransaction();
           query = sessao.createQuery(" from entrada where  valor between :max and :min");
           query.setParameter("max",max);
           query.setParameter("min",min);
           //query.setParameter("id",id);
           
           entrada =  query.list();
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
    return entrada; 
    }

    
    public List<Entrada> EntradaPorFuncionarioPorMotivo(int motivo, int idfuncionario) {
       List<Entrada> entrada = null;
        Session sessao = null; 
        Query query = null;
        Transaction tx = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           tx = sessao.beginTransaction();
           query = sessao.createQuery(" from entrada where  idmotivo = :motivo and idfuncionario =:idfuncionario");
           query.setParameter("motivo",motivo);
           query.setParameter("idfuncionario",idfuncionario);
           //query.setParameter("id",id);
           
           entrada =  query.list();
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
    return entrada;
    }

    
    public List<Entrada> EntradaPorMotivo(int idMotivo) {
    
        List<Entrada> entrada = null;
        Session sessao = null; 
        Query query = null;
        Transaction tx = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           tx = sessao.beginTransaction();
           query = sessao.createQuery(" from entrada where idMotivo = :idMotivo");
           query.setParameter("idMotivo",idMotivo);
           //query.setParameter("fim",fim);
           //query.setParameter("id",id);
           
           entrada =  query.list();
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
    return entrada;
        }

    
    public List<Entrada> EntradraPorSocio(int idSocio) {
        
        List<Entrada> entrada = null;
        Session sessao = null; 
        Query query = null;
        Transaction tx = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           tx = sessao.beginTransaction();
           query = sessao.createQuery(" from entrada where idSocio =:idSocio ");
           query.setParameter("idSocio",idSocio);
           //query.setParameter("fim",fim);
           //query.setParameter("id",id);
           
           entrada =  query.list();
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
    return entrada;
        }

    

}
