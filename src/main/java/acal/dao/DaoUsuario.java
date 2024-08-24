package acal.dao;


import acal.entidades.TablesPriv;
import acal.entidades.User;
import acal.infra.DatabaseConnection;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DaoUsuario {

    
    public void AdicionarUsuario(User usuario) {


    }

    public void privilegios(String privilegio){
        
    }
   
     public void dropUsuario(String usuario) {
    }
    
    public void novoUsuario(String usuario) {
       
    }
    
    public void AlterarUsuario(User usuario) {
    }

    
    public void ApagarUsuario(User usuario) {
    }
 
    public List<String> verPermissoes(String nome){
        return List.of();
    }
        
   public List<TablesPriv> BuscaTodosUsuarios() {
       return List.of();
    }


    public User buscaUsuario(String nome, String pass) {
        User user = null;
        String query = "SELECT * FROM User WHERE user = ? AND password = PASSWORD(?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, nome);
            statement.setString(2, pass);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                user = new User();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
    
    
    public boolean BuscaUsuarioBoolean(String nome) {
      return true;
    }

}
