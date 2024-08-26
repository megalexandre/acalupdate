package acal.dao;

import acal.entidades.Conta;
import acal.infra.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;
import java.util.List;
public class DaoContasMensais  {

    
    public void AdicionarConta(Conta conta) {
       
        Session sessao = null;
        Transaction transacao = null;
       
         try{
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            sessao.save(conta); 
            transacao.commit();
            System.out.println("Conta salva com sucesso");  
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

    
    public void ApagarConta(Conta conta) {
         
        Session sessao = null;
        Transaction transacao = null;
       
         try{
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            sessao.delete(conta); 
            transacao.commit();
            System.out.println("deletado com sucesso");  
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

    
    public void AtualizarConta(Conta conta) {
        
        Session sessao = null;
        Transaction transacao = null;
       
         try{
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            sessao.saveOrUpdate(conta); 
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
    
    public List<Date> datasContas(String numero){

        List<Date> datas = null;
        Session sessao = null; 
        Query query = null;
        Transaction tx = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           tx = sessao.beginTransaction();
          query = sessao.createSQLQuery(
"select c.dataVence from Conta c inner join enderecopessoa e on c.idenderecopessoa = e.id where e.numero =:numero" );
           query.setParameter("numero",numero);
           datas =  query.list();
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
    return datas;
        
    }

    
    public Conta ContasPorId(int id) {
          
        Conta cheque = null;
        Session sessao = null; 
        Query query = null;
        Transaction tx = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           tx = sessao.beginTransaction();
          query = sessao.createQuery("from Conta where id =:id" );
           query.setParameter("id",id);
           cheque = (Conta) query.uniqueResult();
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
    return cheque; }

    
    public List<Conta> ContasAbertas(Date inicio, Date fim) {
        
        List<Conta> conta = null;
        Session sessao = null; 
        Query query = null;
        Transaction tx = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           tx = sessao.beginTransaction();
           query = sessao.createQuery("from Conta where datapagamento is null and datavencimento between :ini and :fim");
           query.setParameter("dataIni",inicio);
           query.setParameter("dataFim",fim);
           conta =  query.list();
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
    return conta;
    }

    
    public List<Conta> ContasAbertasCliente(int id) {
        
        List<Conta> conta = null;
        Session sessao = null; 
        Query query = null;
        Transaction tx = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           tx = sessao.beginTransaction();
           query = sessao.createQuery("from Conta where datapagamento is null and idSocio =:id");
           query.setParameter("id",id);
           //query.setParameter("dataFim",fim);
           conta =  query.list();
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
    return conta;}

    
    public List<Conta> ContasAbertasCliente(String nome) {
        
        //custa implementar ainda!!!
        List<Conta> conta = null;
        Session sessao = null; 
        Query query = null;
        Transaction tx = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           tx = sessao.beginTransaction();
           query = sessao.createQuery("from Conta where datapagamento is null and ");
           //query.setParameter("dataIni",inicio);
           //query.setParameter("dataFim",fim);
           conta =  query.list();
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
    return conta;
    }

    
    public List<Conta> ContasVencidas(Date data) {
     
        List<Conta> conta = null;
        Session sessao = null; 
        Query query = null;
        Transaction tx = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           tx = sessao.beginTransaction();
           query = sessao.createQuery("from Conta where dataPag is null and dataVence < :data");
           query.setParameter("data",data);
           //query.setParameter("dataFim",fim);
           conta =  query.list();
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
    return conta;   
    
    }

    
    public List<Conta> ContasVencidasPorCliente(Date data, int id) {
    
        List<Conta> conta = null;
        Session sessao = null; 
        Query query = null;
        Transaction tx = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           tx = sessao.beginTransaction();
           query = sessao.createQuery("from Contas where dataPag is null and dataVence < :data and idSocio = :id");
           query.setParameter("data",data);
           query.setParameter("id",id);
           conta =  query.list();
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
    return conta;   }

    
    public List<Conta> ContasVencidasPorCliente(Date data, String nome) {
       
        List<Conta> conta = null;
        Session sessao = null; 
        Query query = null;
        Transaction tx = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           tx = sessao.beginTransaction();
           query = sessao.createQuery("from Contas where dataPag is null and dataVence < :data and Pesssoa.nome = :nome");
           query.setParameter("data",data);
           query.setParameter("nome","%"+nome+"%");
           conta =  query.list();
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
    return conta;   
    }

    
    public List<Conta> ContasTotalAbertas() {
        List<Conta> conta = null;
        Session sessao = null; 
        Query query = null;
        Transaction tx = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           tx = sessao.beginTransaction();
           query = sessao.createQuery("from Conta where dataPag is null ");
          // query.setParameter("data",data);
           //query.setParameter("id",id);
           conta =  query.list();
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
    return conta;   
    }

    
    public List<Conta> ContaSomaPorData(Date inicio, Date fim) {
        List<Conta> conta = null;
        Session sessao = null; 
        Query query = null;
        Transaction tx = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           tx = sessao.beginTransaction();
           query = sessao.createSQLQuery("select sum(valor) from contas where datapag between :inicio and :fim ");
           query.setParameter("inicio",inicio);
           query.setParameter("fim",fim);
           conta =  query.list();
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
    return conta;   
    }

    
    public List<Conta> ContasPorRua(int idRua) {
        List<Conta> conta = null;
        Session sessao = null; 
        Query query = null;
        Transaction tx = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           tx = sessao.beginTransaction();
           query = sessao.createQuery(" from Conta where endereco =:irRua ");
           query.setParameter("irRua",idRua);
           //query.setParameter("fim",fim);
           //query.setParameter("id",id);
           conta =  query.list();
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
    return conta;
    }

    
    public List<Conta> ContasAbertas(Date data) {
       
        List<Conta> conta = null;
        Session sessao = null; 
        Query query = null;
        Transaction tx = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           tx = sessao.beginTransaction();
           query = sessao.createQuery(" from Conta where datapag is null and datavencimento > data ");
           query.setParameter("data",data);
           //query.setParameter("fim",fim);
           //query.setParameter("id",id);
           conta =  query.list();
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
    return conta;
    }
}
