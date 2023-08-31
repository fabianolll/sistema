package dao;

import bean.Produtos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdbc.ArquivoJDBC;

public class Produtos_DAO extends DAO_Abstract{

    @Override
    public void insert(Object object) {
        Produtos produtos = (Produtos) object;
         try {
            //Carregar o drive
            
            Class.forName("com.mysql.jdbc.Driver");
            //Conexão própriamente dita
            String url, user, password;
            url = "jdbc:mysql://localhost/db_enio_filho";
            user = "root";
            password = "";
            Connection cnt;
            cnt = DriverManager.getConnection(url, user, password);
            System.out.println("conectou");
           
            //Enviar instruções
             
            PreparedStatement pst = cnt.prepareCall("insert into produto values (? , ?, ?, ?, ?)");
            pst.setInt(1, produtos.getIdProduto());
            pst.setString(2, produtos.getNome());
            pst.setInt(3, produtos.getQuantidade());
            pst.setDouble(4, produtos.getValor());
            pst.setString(5, produtos.getTipo());
            pst.executeUpdate();
            
            
               
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ArquivoJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    @Override
    public void update(Object object) {
        Produtos produtos = (Produtos) object;

        
         try {
            //Carregar o drive
            
            
            Class.forName("com.mysql.jdbc.Driver");
                      
            
            //Conexão própriamente dita
            
            
            String url, user, password;
            url = "jdbc:mysql://localhost/db_enio_filho";
            user = "root";
            password = "";
            Connection cnt;
            cnt = DriverManager.getConnection(url, user, password);
            System.out.println("conectou");
            
            
            //Enviar instruções
            
            
            PreparedStatement pst = cnt.prepareCall("update produto set nome = ?, quantidade = ?, valor = ?, tipo = ? where idProduto = ?");
            pst.setString(1, produtos.getNome());
            pst.setInt(2, produtos.getQuantidade());
            pst.setDouble(3, produtos.getValor());
            pst.setString(4, produtos.getTipo());
            pst.setInt(5, produtos.getIdProduto());
            pst.executeUpdate();

            
               
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Produtos_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    

    @Override
    public void delete(Object object) {
        Produtos produtos = (Produtos) object;

        
         try {
            //Carregar o drive
            
            
            Class.forName("com.mysql.jdbc.Driver");
                      
            
            //Conexão própriamente dita
            
            
            String url, user, password;
            url = "jdbc:mysql://localhost/db_enio_filho";
            user = "root";
            password = "";
            Connection cnt;
            cnt = DriverManager.getConnection(url, user, password);
            System.out.println("conectou");
            
            
            //Enviar instruções
            
            
            PreparedStatement pst = cnt.prepareCall("delete from produto where idProduto = ?");
            pst.setInt(1, produtos.getIdProduto());
            pst.executeUpdate();

        
               
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ArquivoJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    

    @Override
    public Object list(int id) {
        Produtos produtos = new Produtos();
        try {
            //Carregar o drive
            
            
            Class.forName("com.mysql.jdbc.Driver");
                      
            
            //Conexão própriamente dita
            
            
            String url, user, password;
            url = "jdbc:mysql://localhost/db_enio_filho";
            user = "root";
            password = "";
            Connection cnt;
            cnt = DriverManager.getConnection(url, user, password);
            
            
            String sql = "select * from produto where idProduto = ?";
            PreparedStatement pst = cnt.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            if (rs.next() == true){
                produtos.setIdProduto(rs.getInt("idProduto"));
                produtos.setNome(rs.getString("nome"));
                produtos.setQuantidade(rs.getInt("quantidade"));
                produtos.setValor(rs.getDouble("valor"));
                produtos.setTipo(rs.getString("tipo"));
                
             
            } else {
                produtos = null;
            }
        } catch (SQLException ex) {
            System.out.println("Erro no list:" + ex.getMessage());
        }   catch (ClassNotFoundException ex) {
                Logger.getLogger(Produtos_DAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        return produtos;
    }  
    
    

    @Override
    public List listAll() {
       List lista = new ArrayList();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url, user, pass;
            url = "jdbc:mysql://localhost/db_enio_filho";
            user = "root";
            pass = "";
            Connection cnt;
            cnt = DriverManager.getConnection(url, user, pass);
            
            
            PreparedStatement pst = cnt.prepareStatement("select * from Produto");
            ResultSet rs = pst.executeQuery();
            
            while (rs.next() == true){ 
                Produtos produtos = new Produtos();
                produtos.setIdProduto(rs.getInt("IdProduto"));
                produtos.setQuantidade (rs.getInt("Quantidade"));
                produtos.setNome(rs.getString("Nome"));
                produtos.setTipo(rs.getString("Tipo"));
                produtos.setValor(rs.getDouble("Valor"));
                lista.add(produtos);       
            } 
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro no registro do mysql:" + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Erro no envio das instruções sql:" + ex.getMessage());
        }
        return lista;
        }
   }

