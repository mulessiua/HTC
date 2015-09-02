/**
 * Classe para conexao a Base Dados
 */

package dao;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author Simone Mura
 * @version 1.0
 */
public class Conexao {

    /**
     * Cria uma conexao a base dados
     * @since 1.0
     * @return Connection
     */
    public static Connection getInstance() throws Exception{
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "htc";
        String userName = "root";
        String password = "";

        Class.forName(driver).newInstance();
        return  DriverManager.getConnection(url+dbName,userName,password);
    }
}
