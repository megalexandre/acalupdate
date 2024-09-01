package br.org.acal.resouces.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import br.org.acal.resouces.entidades.Categoriasocio;
import br.org.acal.resouces.entidades.Endereco;
import br.org.acal.resouces.entidades.Enderecopessoa;
import br.org.acal.resouces.entidades.Pessoa;
import br.org.acal.resouces.entidades.Socio;
import br.org.acal.resouces.entidades.Sociotabela;
import br.org.acal.infra.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
public class DaoSocio{

    
    public void AdicionarSocio(Socio socio) {
         Session sessao = null;
        Transaction transcao = null;
       
         try{
            sessao = HibernateUtil.getSessionFactory().openSession();
            transcao = sessao.beginTransaction();    
            sessao.save(socio); 
            transcao.commit();
        }
        catch(HibernateException e)
        {
            transcao.rollback();
        }
        finally
        {
            sessao.close(); 
        }  
    }

    
    public void AlterarSocio(Socio socio) {
        Session sessao = null;
        Transaction transcao = null;
       
         try{
            sessao = HibernateUtil.getSessionFactory().openSession();
            transcao = sessao.beginTransaction();    
            sessao.saveOrUpdate(socio); 
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

    
    public void ApagarSocio(Socio socio) {
         Session sessao = null;
        Transaction transcao = null;
       
         try{
            sessao = HibernateUtil.getSessionFactory().openSession();
            transcao = sessao.beginTransaction();    
            sessao.delete(socio); 
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

    
    public List<Socio> SociosPorNomeLike(String nome) {
       
        List<Socio> socio = null;
        Session sessao = null; 
        Query query = null;
        Transaction transacao = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           transacao = sessao.beginTransaction();
           query = sessao.createQuery("from Socio s  where s.idPessoa.nome like :nome   ");
           query.setParameter("nome","%"+nome+"%");
           socio = query.list();
           if(socio instanceof Socio){
               JOptionPane.showMessageDialog(null, "é");
               
           }
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
    return socio;
    }

    
    public Socio BuscarSocioId(int id) {
       
        Socio socio = null;
        Session sessao = null; 
        Query query = null;
        Transaction transacao = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           transacao = sessao.beginTransaction();
           query = sessao.createQuery("from Socio where id = :id");
           query.setParameter("id",id);
           socio = (Socio)query.uniqueResult();
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
    return socio;
    }
    
    
    
    public List<Socio> SocioPorRua(String rua) {
      
        List<Socio> socio = null;
        Session sessao = null; 
        Query query = null;
        Transaction transacao = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           transacao = sessao.beginTransaction();
           query = sessao.createQuery("from Socio s, Pessoa p where p.id = s.idPessoa\n" +
        "and p.idEndereco = :rua");
           //query.setString("nome","%"+nome+"%");
           query.setParameter("rua",rua);
           // socio = (Taxa) query.uniqueResult();
           socio = query.list();
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
    return socio;
    }

    
    public List<Integer> TodosOsSociosPorId() {
        
        List<Integer> socio = null;
        Session sessao = null; 
        Query query = null;
        Transaction transacao = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           transacao = sessao.beginTransaction();
           query = sessao.createNativeQuery("select id from Socio ");
           socio = query.list();
           transacao.commit(); 
           
        }
        catch(HibernateException e)
        {
            e.printStackTrace();
            System.out.println(e);
            transacao.rollback();
        }
        finally
        {
             sessao.close();
        }  
    return socio;
    }
    
    
    public List<Socio> TodosOsSocios() {
        
        List<Socio> socio = null;
        Session sessao = null; 
        Query query = null;
        Transaction transacao = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           transacao = sessao.beginTransaction();
           query = sessao.createQuery("from Socio ");
           socio = query.list();
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
    return socio;
    }


    public List<Sociotabela> findAllCustomers(){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Sociotabela", Sociotabela.class).getResultList();
        }
    }
    
    public List<Socio> TodosOsSociosJDBC(){
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Socio> socios = new ArrayList<Socio>();
        Socio s = null;
        try{
            
            conn = HibernateUtil.getConnection();
            ps = conn.prepareStatement("select id from socio");
            rs = ps.executeQuery();
            while(rs.next()){
                
                s = new Socio();
                s.setId(rs.getInt("id"));
                socios.add(s);
            }
            
        }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Erro:"+e.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE);
        }finally{
            try {
                conn.close();
                
            } catch (SQLException ex) {
                Logger.getLogger(DaoSocio.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
        return socios;
        
    }
    
    public List<Enderecopessoa> TodosOsEnderecosPessoasJDBC(int idSocio){
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Enderecopessoa> enderecopessoa = new ArrayList<Enderecopessoa>();
        Enderecopessoa s = null;
        try{
            
            conn = HibernateUtil.getConnection();
            ps = conn.prepareStatement("select e.id, e.numero from  enderecopessoa e inner join pessoa p on e.idPessoa = p.id inner join socio s on s.idPessoa = p.id where s.id = ?");
            ps.setInt(1, idSocio);
            rs = ps.executeQuery();
            while(rs.next()){
                
                s = new Enderecopessoa();
                s.setId(rs.getInt("id"));
                s.setNumero(rs.getString("Numero"));
                
                enderecopessoa.add(s);
            }
            
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(null,"Erro:"+e.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE);
        }finally{
            try {
                conn.close();
                
            } catch (SQLException ex) {
                Logger.getLogger(DaoSocio.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
        return enderecopessoa; 
        
        
    }
    
    public Endereco fromEnderecoPessoaJDBC(int idEnderecoPessoa){
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Endereco endereco = null;
        try{
            
            conn = HibernateUtil.getConnection();
            ps = conn.prepareStatement("select e.nome, e.tipo from endereco e inner join enderecopessoa ep on e.id = ep.idEndereco where ep.id = ?");
            ps.setInt(1, idEnderecoPessoa);
            rs = ps.executeQuery();
            while(rs.next()){
                
               endereco = new Endereco();
               //endereco.setId(rs.getInt("id"));
               //endereco.setDescricao(rs.getString("descricao"));
               endereco.setNome(rs.getString("nome"));
               endereco.setTipo(rs.getString("tipo"));
            }
            
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(null,"Erro:"+e.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE);
        }finally{
            try {
                conn.close();
              
            } catch (SQLException ex) {
                Logger.getLogger(DaoSocio.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
        return endereco; 
        
  
    }
    
    public Pessoa fromSocioJDBC(int idSocio){
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Pessoa pessoa = null;
        try{
            
            conn = HibernateUtil.getConnection();
            ps = conn.prepareStatement("select p.nome, p.sobrenome, p.cpf from pessoa p inner join socio s on s.idPessoa = p.id where s.id = ?");
            ps.setInt(1, idSocio);
            rs = ps.executeQuery();
            while(rs.next()){
                
               pessoa = new Pessoa();
               pessoa.setNome(rs.getString("nome"));
               pessoa.setSobrenome(rs.getString("sobrenome"));
               pessoa.setCpf(rs.getString("cpf"));
            }
            
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(null,"Erro:"+e.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE);
        }finally{
            try {
                conn.close();
               ;
            } catch (SQLException ex) {
                Logger.getLogger(DaoSocio.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
        return pessoa; 
        
        
        
        
    }
    
    public Categoriasocio fromCategoriaSocioJDBC(int idEnderecoPessoa){
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Categoriasocio categoria = null;
        try{
            
            conn = HibernateUtil.getConnection();
            ps = conn.prepareStatement("select c.nome from categoriasocio c inner join enderecopessoa e on c.id = e.idCategoriaSocio inner join pessoa p on e.idpessoa = p.id inner join socio s on s.idpessoa = p.id where e.id = ?");
            ps.setInt(1, idEnderecoPessoa);
            rs = ps.executeQuery();
            while(rs.next()){
                
               categoria = new Categoriasocio();
               categoria.setNome(rs.getString("nome"));
            }
            
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(null,"Erro:"+e.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE);
        }finally{
            try {
                conn.close();
                
            } catch (SQLException ex) {
                Logger.getLogger(DaoSocio.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
        return categoria;   
        
    }

    public List<Object> fromSocioTodosOsMetodosJDBC(int idSocio){
        
        
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Object> lista = new ArrayList<>();
        List<Enderecopessoa> enderecopessoa = new ArrayList<>();
        Pessoa p = null;
        Categoriasocio c = null;
        try{
            
            conn = HibernateUtil.getConnection();
            ps = conn.prepareStatement("select * from enderecopessoa e inner join pessoa p on p.id = e.idpessoa inner join socio s on s.idpessoa = p.id inner join categoriasocio cs on cs.id = s.idcategoriasocio where s.id = ?");
            ps.setInt(1, idSocio);
            rs = ps.executeQuery();
            while(rs.next()){
               
                Enderecopessoa e = new Enderecopessoa();
                
               
            }
            
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(null,"Erro:"+e.getMessage(),"Erro",JOptionPane.ERROR_MESSAGE);
        }finally{
            try {
                conn.close();
                
            } catch (SQLException ex) {
                Logger.getLogger(DaoSocio.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
        return lista;    
        
    }
}
