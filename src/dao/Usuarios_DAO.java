
package dao;

import bean.Usuarios;
import jdbc.ArquivoJDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Usuarios_DAO extends DAO_Abstract {

    public Usuarios_DAO() {

    }

    @Override
    public void insert(Object object) {
        Usuarios usuarios = (Usuarios) object;
        String url, user, password;
        url = "jdbc:mysql://10.7.0.51:33062/db_enio_filho";
        user = "root";
        password = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, user, password);
            //statemente stm;
            // stm = cnt.createStatemnt();
            String sql = "INSERT INTO Usuarios VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
            //tatement sql = cnt.createStatement();
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, usuarios.getIdUsuarios());
            pstm.setString(2, usuarios.getNome());
            pstm.setString(3, usuarios.getApelido());
            pstm.setString(4, usuarios.getCpf());
            pstm.setDate(5, new  java.sql.Date (usuarios.getDataNascimento().getTime()));//(java.sql.Date) new Date(2001,1,1));
            pstm.setString(6, usuarios.getSenha());
            pstm.setInt(7, usuarios.getNivel());
            pstm.setString(8, usuarios.getAtivo());
            pstm.executeUpdate();
        } catch (ClassNotFoundException ex) {
            System.out.println("erro na conexao");
            Logger.getLogger(ArquivoJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ArquivoJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param object
     */
    @Override
    public void update(Object object) {
        Usuarios usuarios = (Usuarios) object;
        String url, user, password;
        url = "jdbc:mysql://10.7.0.51:33062/db_enio_filho";
        user = "";
        password = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, user, password);
            
            String sql = "update Usuarios set nome=?,apelido=?,cpf=?, " + "dataNascimento=?, senha=?, nivel=?, ativo=? where idUsuarios=?";
           
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setInt(8, usuarios.getIdUsuarios());
            pstm.setString(1, usuarios.getNome());
            pstm.setString(2, usuarios.getApelido());
            pstm.setString(3, usuarios.getCpf());            
            pstm.setDate(4, new  java.sql.Date (usuarios.getDataNascimento().getTime()));
            pstm.setString(5, usuarios.getSenha());
            pstm.setInt(6, usuarios.getNivel());
            pstm.setString(7, usuarios.getAtivo());
            pstm.executeUpdate();
            
        } catch (ClassNotFoundException ex) {
            System.out.println("erro na conexao");
            Logger.getLogger(ArquivoJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ArquivoJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Object object) {
        Usuarios usuarios = (Usuarios) object;
        String url, user, password;
        url = "jdbc:mysql://10.7.0.51:33062/";
        user = "";
        password = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");
             try  (Connection  cnt = DriverManager.getConnection(url, user, password)){
                  String sql = "delete from Usuarios where idUsuarios=?"; 
                  PreparedStatement pstm = cnt.prepareStatement(sql);
                  pstm.setInt(1, usuarios.getIdUsuarios());
                  pstm.executeUpdate();
             }  

        } catch (ClassNotFoundException ex) {
            System.out.println("erro na conexao");
            Logger.getLogger(ArquivoJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ArquivoJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Object list(int id) {
        Usuarios usuarios = new Usuarios();
        String url, user, password;
        url = "jdbc:mysql://10.7.0.51:33062/db_enio_filho";
        user = "";
        password = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, user, password);
            //statemente stm;
            // stm = cnt.createStatemnt();
            String sql = "Select * from Usuarios where idUsuarios=?";
            //tatement sql = cnt.createStatement();
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            if (rs.next() == true) {
                usuarios.setIdUsuarios(rs.getInt("idusuarios"));
                usuarios.setNome(rs.getString("nome"));
                usuarios.setApelido(rs.getString("apelido"));
                usuarios.setCpf(rs.getString("cpf"));
                usuarios.setDataNascimento(rs.getDate("dataNascimento"));
                usuarios.setSenha(rs.getString("senha"));
                usuarios.setNivel(rs.getInt("nivel"));
                usuarios.setAtivo(rs.getString("ativo"));

            }

        } catch (ClassNotFoundException ex) {
            System.out.println("erro na conexao");
            Logger.getLogger(ArquivoJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ArquivoJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuarios;
    }

    @Override
    public List listAll() {
       
        String url, user, password;
        url = "jdbc:mysql://10.7.0.51:33062/db_enio_filho";
        user = "";
        password = "";
        
         //Foi colocado fora do try pois se for colocado dentro ele vira local, colocando fora do try o list vira global.
        List listausuarios = new ArrayList();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, user, password);
            
            String sql = "Select * from Usuarios";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
          
            while (rs.next() == true) {
                //C maiusculo porque esta declarando um objeto
               Usuarios usuarios = new Usuarios();
                
                // c minusculo pois esta chamando o objeto
                usuarios.setIdUsuarios(rs.getInt("idusuarios"));
                usuarios.setNome(rs.getString("nome"));
                usuarios.setApelido(rs.getString("apelido"));
                usuarios.setCpf(rs.getString("cpf"));
                usuarios.setDataNascimento(rs.getDate("dataNascimento"));
                usuarios.setSenha(rs.getString("senha"));
                usuarios.setNivel(rs.getInt("nivel"));
                usuarios.setAtivo(rs.getString("ativo"));
                listausuarios.add(usuarios);

            }

        } catch (ClassNotFoundException ex) {
            System.out.println("erro na conexao");
            Logger.getLogger(ArquivoJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ArquivoJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }

      
        return listausuarios;
    }

    public static void main(String[] args) {

//        chamando o bean
        Usuarios usuarios = new Usuarios();

        usuarios.setIdUsuarios(5);
        usuarios.setNome("Enio");
        usuarios.setApelido("poc");
        usuarios.setCpf("038.732.741.10");
        //usuarios.setDataNascimento( new Date( "01/01/2001"));
        usuarios.setSenha("vivi123");
        usuarios.setNivel(2);
        usuarios.setAtivo("S");

//        chamando o Dao
        Usuarios_DAO usuarios_DAO = new Usuarios_DAO();
        usuarios_DAO.insert(usuarios);

        System.out.println("Certinhooooo");

    }
    
    public Usuarios fazerLogin(String apelido, String senha) {
        Usuarios usuarios = null;
        
        String url, user, password;
        url = "jdbc:mysql://10.7.0.51:33062/db_enio_filho";
        user = "";
        password = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection cnt = DriverManager.getConnection(url, user, password)) {
                String sql = "SELECT * FROM Usuarios WHERE apelido = ? AND senha = ?";
                try (PreparedStatement pstm = cnt.prepareStatement(sql)) {
                    pstm.setString(1, apelido);
                    pstm.setString(2, senha);
                
                    try (ResultSet rs = pstm.executeQuery()) {
                        if (rs.next()) {
                            usuarios = new Usuarios();
                            usuarios.setApelido(rs.getString("apelido"));
                            usuarios.setSenha(rs.getString("senha"));
                        }
                    }
                }
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ArquivoJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }

        return usuarios;
    }

}
