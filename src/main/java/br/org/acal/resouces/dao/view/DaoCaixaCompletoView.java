package br.org.acal.resouces.dao.view;

import java.util.Date;
import java.util.List;

import br.org.acal.resouces.entidades.RcCaixaCompleto;
import br.org.acal.infra.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DaoCaixaCompletoView {
    
     public List<RcCaixaCompleto> BuscarTodosRcCaixaCompleto() {
       
        List<RcCaixaCompleto> endereco = null;
        Session sessao = null; 
        Query query = null;
        Transaction transacao = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           transacao = sessao.beginTransaction();
           query = sessao.createQuery("from RcCaixaCompleto ");
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
    
    public List<RcCaixaCompleto> BuscarTodosRcCaixaCompletoDatePagamento(Date ini, Date fim) {
        
        List<RcCaixaCompleto> endereco = null;
        Session sessao = null; 
        Query query = null;
        Transaction transacao = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           transacao = sessao.beginTransaction();
           query = sessao.createQuery("from RcCaixaCompleto where Pagamento between :ini and :fim");
           query.setParameter("ini",ini);
           query.setParameter("fim",fim);
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
    public List<RcCaixaCompleto> BuscarTodosRcCaixaCompletoDateVencimento(Date ini, Date fim) {
        
        List<RcCaixaCompleto> endereco = null;
        Session sessao = null; 
        Query query = null;
        Transaction transacao = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           transacao = sessao.beginTransaction();
           query = sessao.createQuery("from RcCaixaCompleto where vencimento between :ini and :fim");
           query.setParameter("ini",ini);
           query.setParameter("fim",fim);
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
}

