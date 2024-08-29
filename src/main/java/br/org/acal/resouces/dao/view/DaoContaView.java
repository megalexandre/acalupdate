package br.org.acal.resouces.dao.view;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.org.acal.resouces.entidades.CaixaView;
import br.org.acal.infra.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DaoContaView {
      
    public List<CaixaView> BuscarTodasContas(){
 
        List<CaixaView> caixa = null;
        Session sessao = null; 
        Query query = null;
        Transaction transacao = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           transacao = sessao.beginTransaction();
           query = sessao.createQuery("from CaixaView ");
           caixa = query.list();
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
    return caixa;
    }

    public List<CaixaView> BuscarContasAtrasadas60(){
        
        List<CaixaView> caixa = null;
        Session sessao = null; 
        Query query = null;
        Transaction transacao = null;
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH, -60);
       
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           transacao = sessao.beginTransaction();
           query = sessao.createQuery("from CaixaView where vencimento < :para" );
           query.setCalendarDate("para", c);
           caixa = query.list();
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
    return caixa;
    }

     public List<CaixaView> BuscarPagamento(Date ini, Date fim) {
        
        List<CaixaView> caixa = null;
        Session sessao = null; 
        Query query = null;
        Transaction transacao = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           transacao = sessao.beginTransaction();
           query = sessao.createQuery("from CaixaView where Pagamento between :ini and :fim");
           query.setParameter("ini",ini);
           query.setParameter("fim",fim);
           caixa = query.list();
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
    return caixa;
    }
     
     
    public List<CaixaView> BuscarVencimento(Date ini, Date fim) {
        
        List<CaixaView> caixa = null;
        Session sessao = null; 
        Query query = null;
        Transaction transacao = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           transacao = sessao.beginTransaction();
           query = sessao.createQuery("from CaixaView where vencimento between :ini and :fim");
           query.setParameter("ini",ini);
           query.setParameter("fim",fim);
           caixa = query.list();
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
    return caixa;
    }
}