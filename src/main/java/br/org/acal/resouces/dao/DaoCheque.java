package br.org.acal.resouces.dao;

import br.org.acal.resouces.entidades.Cheque;
import br.org.acal.infra.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;
import java.util.List;
public class DaoCheque {

    //testado com sucesso
    public void AdicionarCheque(Cheque cheque) {
      
        Session session = null;
        Transaction  tx = null;
       
         try{
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(cheque); 
            tx.commit();
        }
        catch(HibernateException e)
        {
            tx.rollback();
        }
        finally
        {
            session.close(); 
        }    
    }

    public void ApagarCheque(Cheque cheque) {
        
        Session session = null;
        Transaction  tx = null;
       
         try{
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.delete(cheque); 
            tx.commit();
            System.out.println("Salvo com sucesso");  
        }
        catch(HibernateException e)
        {
            System.out.println("Erro ao iniciar a sessao para persistencia " + e);
            tx.rollback();
        }
        finally
        {
            session.close(); 
        }    
    }
    
    public List<Cheque> BuscarChequeFuncionarioLikeNome(String nome)
    {
        List<Cheque> entradas = null;
        Session sessao = null; 
        Query query = null;
        Transaction transacao = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           transacao = sessao.beginTransaction();
           query = sessao.createQuery("from Cheque c where c.idFuncionario.idPessoa.nome  LIKE :nome");
           query.setString("nome","%"+nome+"%");
           //query.setParameter("nome",nome);
           entradas = query.list();
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
    return entradas;
    }

    public void AtualizarCheque(Cheque cheque) {
      
        Session session = null;
        Transaction  tx = null;
       
         try{
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.saveOrUpdate(cheque); 
            tx.commit();
            System.out.println("Salvo com sucesso");  
        }
        catch(HibernateException e)
        {
            System.out.println("Erro ao iniciar a sessao para persistencia " + e);
            tx.rollback();
        }
        finally
        {
            session.close(); 
        }    
    }
    //testado
    public Cheque ChequesId(int idCheque) {
       
        Cheque cheque = null;
        Session sessao = null; 
        Query query = null;
        Transaction tx = null;
        
        try{
          sessao = HibernateUtil.getSessionFactory().openSession();
           tx = sessao.beginTransaction();
           query = sessao.createQuery("from Cheque where id = :id");
           query.setParameter("id",idCheque);
           cheque = (Cheque) query.uniqueResult();
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

    public List<Cheque> ChequesAbertos(Date ini, Date fim ) {
      
        List<Cheque> cheque = null;
        Session sessao = null; 
        Query query = null;
        Transaction tx = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           tx = sessao.beginTransaction();
           query = sessao.createQuery("from cheque where datapagamento is null and datavencimento between :ini and :fim");
           query.setParameter("dataIni",ini);
           query.setParameter("dataFim",fim);
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

    
    public List<Cheque> ChequesVencidosPorCliente(Date data) {
       
        List<Cheque> cheque = null;
        Session sessao = null; 
        Query query = null;
        Transaction tx = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           tx = sessao.beginTransaction();
           query = sessao.createQuery("implementar ");
           query.setParameter("data",data);
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

    public List<Cheque> ChequesTotalAbertos() {
     
        List<Cheque> cheque = null;
        Session sessao = null; 
        Query query = null;
        Transaction tx = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           tx = sessao.beginTransaction();
           query = sessao.createQuery("from Cheque ");
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

    public List<Cheque> ChequesSomaPorData(Date dataInicial, Date dataFinal) {
      
        List<Cheque> cheque = null;
        Session sessao = null; 
        Query query = null;
        Transaction tx = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           tx = sessao.beginTransaction();
           query = sessao.createQuery("implementar ");
           query.setParameter("dataIni",dataInicial);
           query.setParameter("dataFim",dataFinal);
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

    public List<Cheque> ChequesAbertosClientesPorIdClinete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Cheque> ChequesAbertosClientesPorNomeCliente(String nome) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
