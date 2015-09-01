/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import produto.Cadastro;

/**
 *
 * @author hallan medeiros
 *
 */
public class DaoUsuario {

    public Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/emoz", "root", "12345");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }


    public Cadastro getUsuario( String email, String password ){
        Connection c = this.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = c.prepareStatement("select cadastroId, nome from usuario where email = ? and password = ?");
            ps.setString(1, email);
            ps.setString(2, password);

            rs = ps.executeQuery();

            if ( rs.next() ){
                Cadastro user = new Cadastro();
                user.setRCadastroId( rs.getInt("id") );
                user.setEmail(email);
                user.setPassword(password);
                user.setNome( rs.getString("nome") );

                return user;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally{
            if (rs != null ) {
                try { rs.close(); } catch (SQLException e) { ; }
                rs = null;
            }
            if (ps != null ) {
                try { ps.close(); } catch (SQLException e) { ; }
                ps = null;
            }
            if (c != null ) {
                try { c.close(); } catch (SQLException e) { ; }
                c = null;
            }
        }
        return null;
    }

}
