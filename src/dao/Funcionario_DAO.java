
package dao;


import bean.Funcionario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Funcionario_DAO extends DAO_Abstract {

    @Override
    public void insert(Object object) {
        Funcionario funcionario = (Funcionario) object;
        String url, user, password;
            url = "jdbc:mysql://localhost/db_enio_filho";
            user = "root";
            password = "";
            
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, user, password);
            //Statement stm;
            //stm = cnt.createStatement();

             String sql = "insert into funcionario values(?,?,?,?,?,?)";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, funcionario.getIdFuncionario());
              pstm.setString(2, funcionario.getNome());
              pstm.setString(3, funcionario.getEmail());
              pstm.setString(4, funcionario.getTelefone());
             pstm.setString(5, funcionario.getCpf());
             pstm.setInt(6, funcionario.getCargo());
             pstm.executeUpdate();
            //stm.executeUpdate(sql);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Funcionario_DAO.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    
    public Object List(int id) {
       Funcionario funcionario = new Funcionario();
        String url, user, password;
            url = "jdbc:mysql://localhost/db_enio_filho";
            user = "root";
            password = "";
            
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, user, password);
            //Statement stm;
            //stm = cnt.createStatement();

             String sql = "select * from funcionario where idFuncionario=?";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setInt(1,id);
            ResultSet rs= pstm.executeQuery();
            if(rs.next()== true){
                funcionario.setIdFuncionario(rs.getInt("idFuncionario"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setEmail(rs.getString("email"));
                funcionario.setTelefone(rs.getString("telefone"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setCargo(rs.getInt("cargo"));
            }
             
            //stm.executeUpdate(sql);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Usuarios_DAO.class.getName()).log(Level.SEVERE, null, ex);

        }
    return funcionario;
    }
    

   

    public java.util.List listALL() {
         String url, user, password;
            url = "jdbc:mysql://localhost/db_enio_filho";
            user = "root";
            password = "";
 
          List lista = new ArrayList();
        
        
          
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, user, password);
            //Statement stm;
            //stm = cnt.createStatement();

             String sql = "select * from funcionario";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            ResultSet rs= pstm.executeQuery();
          
            while(rs.next()== true){
                Funcionario funcionario = new Funcionario();
                funcionario.setIdFuncionario(rs.getInt("idFuncionario"));
                funcionario.setNome(rs.getString("nome"));
                  funcionario.setEmail(rs.getString("email"));
                funcionario.setTelefone(rs.getString("telefone"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setCargo(rs.getInt("cargo"));
             
              
                lista.add(funcionario);
            }
             
            //stm.executeUpdate(sql);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Funcionario_DAO.class.getName()).log(Level.SEVERE, null, ex);

        }
    return lista;
    }


    @Override
    public void update(Object object) {
       Funcionario funcionario = (Funcionario) object;
        String url, user, password;
            url = "jdbc:mysql://localhost/db_enio_filho";
            user = "root";
            password = ""; 
             
        try { 
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, user, password);
            //Statement stm;
            //stm = cnt.createStatement();

             String sql = "update funcionario set nome=?,email=?,telefone=?," + "cpf=?,cargo=? where idFuncionario=?";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setInt(6, funcionario.getIdFuncionario());
              pstm.setString(1, funcionario.getNome());
              pstm.setString(2, funcionario.getEmail());
              pstm.setString(3, funcionario.getTelefone());
             pstm.setString(4, funcionario.getCpf());
             pstm.setInt(5, funcionario.getCargo());
             pstm.executeUpdate();
            //stm.executeUpdate(sql);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Usuarios_DAO.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    @Override
    public void delete(Object object) {
        Funcionario funcionario = (Funcionario) object;
        String url, user, password;
            url = "jdbc:mysql://localhost/db_enio_filho";
            user = "root";
            password = "";
            
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, user, password);
            //Statement stm;
            //stm = cnt.createStatement();

             String sql = "delete from funcionario where idFuncionario=?";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, funcionario.getIdFuncionario());
             pstm.executeUpdate();
            //stm.executeUpdate(sql);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Usuarios_DAO.class.getName()).log(Level.SEVERE, null, ex);

        }


    }

    @Override
    public Object list(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List listAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 }
   