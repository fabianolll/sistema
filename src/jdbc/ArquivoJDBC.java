package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author eniof
 */
public class ArquivoJDBC {
    public static void main(String[] argus){
       String url, user, password;
       url = "jdbc:mysql://10.7.0.51:33062/db_enio_filho";
       user = "";
       password = ""; 
  
        try {
            Class.forName("com.mysql.jdbc.Driver");
             Connection cnt;
             cnt = DriverManager.getConnection(url, user, password);
             Statement stm;
           Statement sql = cnt.createStatement();
           // String sql = "INSERT INTO Usuarios VALUES ('1', 'ufu', 'yuryu', '5757565686', '2000-03-15', '747575', '1', 's');";
           // String sql = "UPDATE `db_enio_filho`.`Usuarios` SET `nome` = 'enipo' WHERE (`id_usuarios` = '1');";
           // String sql = "DELETE FROM `db_enio_filho`.`Usuarios` WHERE (`id_usuarios` = '1');";
                    } catch (ClassNotFoundException ex) {
                        System.out.println("erro na conexao");
            Logger.getLogger(ArquivoJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ArquivoJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Conectou");
        
} 
}
