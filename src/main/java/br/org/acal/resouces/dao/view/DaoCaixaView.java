package br.org.acal.resouces.dao.view;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import br.org.acal.resouces.entidades.CaixaView;
import br.org.acal.infra.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
public class DaoCaixaView {
    
     public List<CaixaView> BuscarTodosCaixaView() {
       
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
    
    public List<CaixaView> BuscarTodosCaixaViewDatePagamento(Date ini, Date fim) {
        
        List<CaixaView> endereco = null;
        Session sessao = null; 
        Query query = null;
        Transaction transacao = null;
        
      
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        //transformar em string para evitar passar o horario.
        String inis = sdf.format(ini);
        String fims = sdf.format(fim);
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           transacao = sessao.beginTransaction();
           query = sessao.createQuery("from CaixaView where Pagamento between :ini and :fim");
           query.setParameter("ini",inis);
           query.setParameter("fim",fims);
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
    public List<CaixaView> BuscarTodosCaixaViewDateVencimento(Date ini, Date fim) {
        
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
    
    
    
     public List<CaixaView> BuscarSocioNome(String socio) {
       
        List<CaixaView> caixa = null;
        Session sessao = null; 
        Query query = null;
        Transaction transacao = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           transacao = sessao.beginTransaction();
           query = sessao.createQuery("from CaixaView where socio = :socio");
           query.setParameter("socio", socio);
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
     
    public List<CaixaView> BuscarLogradouro(String endereco) {
       
        List<CaixaView> contas = null;
        Session sessao = null; 
        Query query = null;
        Transaction transacao = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           transacao = sessao.beginTransaction();
           query = sessao.createQuery("from CaixaView where endereco = :endereco");
           query.setParameter("endereco", endereco);
           contas = query.list();
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
    return contas;
    }
      
    public List<CaixaView> BuscarStatus(int status) {
       
        List<CaixaView> contas = null;
        Session sessao = null; 
        Query query = null;
        Transaction transacao = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           transacao = sessao.beginTransaction();
           if(status == 1){//aberta
            query = sessao.createQuery("from CaixaView where pagamento is null");
           }
           else if (status==2){//paga
            query = sessao.createQuery("from CaixaView where pagamento is not null");   
           }
           else if (status==3){//vencida
            Date d = new Date();
            query = sessao.createQuery("from CaixaView where vencimento <= :data and pagamento is null");   
            query.setParameter("data", d);
           }
           
           
           contas = query.list();
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
         return contas;
    }

    public List<CaixaView> BuscarSocioLogradouro(String endereco, String socio) {
       
        List<CaixaView> contas = null;
        Session sessao = null; 
        Query query = null;
        Transaction transacao = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           transacao = sessao.beginTransaction();
           query = sessao.createQuery("from CaixaView where endereco = :endereco and socio = :socio");
           query.setParameter("endereco", endereco);
           query.setParameter("socio", socio);
           contas = query.list();
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
    return contas;
    }
    
    public List<CaixaView> BuscarSocioStatus(int status, String socio) {
       
       
        List<CaixaView> contas = null;
        Session sessao = null; 
        Query query = null;
        Transaction transacao = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           transacao = sessao.beginTransaction();
           if(status == 1){//aberta
            query = sessao.createQuery("from CaixaView where socio = :socio ");
            query.setParameter("socio", socio);
            
           }
           else if (status==2){//paga
            query = sessao.createQuery("from CaixaView where pagamento is not null and socio = :socio");   
            query.setParameter("socio", socio);
            
           }
           else if (status==3){//vencida
            Date d = new Date();
            query = sessao.createQuery("from CaixaView where vencimento <= :data and pagamento is null and socio = :socio");   
            query.setParameter("data", d);
            query.setParameter("socio", socio);
            
           }
           
           contas = query.list();
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
    return contas;
    }
    
    public List<CaixaView> BuscarLogradouroStatus(int status, String end) {
       
        List<CaixaView> contas = null;
        Session sessao = null; 
        Query query = null;
        Transaction transacao = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           transacao = sessao.beginTransaction();
           if(status == 1){//aberta
            query = sessao.createQuery("from CaixaView where pagamento is null and endereco = :endereco ");
            
           }
           else if (status==2){//paga
            query = sessao.createQuery("from CaixaView where pagamento is not null and endereco = :endereco ");   
           }
           else if (status==3){//vencida
            Date d = new Date();
            query = sessao.createQuery("from CaixaView where vencimento <= :data and pagamento is null and endereco = :endereco ");   
            query.setParameter("data", d);
           }
          
           query.setParameter("endereco", end);
           contas = query.list();
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
    return contas;
    }
    
    
    public List<CaixaView> BuscarTodosCriterios(int status, String socio, String endereco) {
       
        List<CaixaView> contas = null;
        Session sessao = null; 
        Query query = null;
        Transaction transacao = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           transacao = sessao.beginTransaction();
           if(status == 1){//aberta
            query = sessao.createQuery("from CaixaView where pagamento is null and socio = :socio and endereco = :endereco and " );
            
           }
           else if (status==2){//paga
            query = sessao.createQuery("from CaixaView where pagamento is not null and socio = :socio and endereco = :endereco");   
           }
           else if (status==3){//vencida
            Date d = new Date();
            query = sessao.createQuery("from CaixaView where vencimento <= :data and pagamento is null and socio = :socio and endereco = :endereco");   
            query.setParameter("data", d);
           }
           
           query.setParameter("endereco",endereco);
           query.setParameter("socio", socio);
           contas = query.list();
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
    return contas;
    }
}

