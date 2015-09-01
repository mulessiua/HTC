/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package factory;

import produto.Cadastro;
import dao.Conexao;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.logging.Level;
/**
 *
 * @author Mulessiua(Carlitos)
 */
public class FactoryCadastro extends Factory{

    @Override
    public  Object newElement() {
        return new Cadastro();
    }

    @Override
    public  Object read(Object primaryKey){
       Cadastro c;
       // Criar um Cadastro
       c = (Cadastro) this.newElement();
       String query = "SELECT * FROM cadastro WHERE cadastroId = ?";
      try {
        Connection conn = Conexao.getInstance();
        PreparedStatement pt = conn.prepareStatement(query);
        pt.setString(1,(String) primaryKey);
        ResultSet rs = pt.executeQuery();
        if (rs.next()){
                //Inizializar um Cadastro
                c.setRCadastroId(rs.getInt("cadastroId"));
                c.setNome(rs.getString("nome"));
                c.setApelido(rs.getString("apelido"));
                c.setPassword(rs.getString("password"));
                c.setRep_password(rs.getString("rep_password"));
                c.setEmail(rs.getString("email"));
                c.setPais(rs.getString("pais"));
                c.setEndereco(rs.getString("endereco"));
                c.setTelefone(rs.getString("telefone"));

             }
             pt.close();
             conn.close();
        }catch(Exception ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE,ex.toString(),ex);
        }
       return c;
    }

    @Override
    public  int delete(Object primaryKey){
       int ris = 0;
       String query = "DELETE FROM cadastro WHERE cadastroId = ?";
       try {
            Connection conn = Conexao.getInstance();
            PreparedStatement pt = conn.prepareStatement(query);
            pt.setString(1,(String) primaryKey);
            ris = pt.executeUpdate();
            pt.close();
            conn.close();
        }catch(Exception ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE,ex.toString(),ex);
        }
       return ris;
    }

    @Override
    public int update(Object o){
        int ris = 0;
        try {
            Connection conn = Conexao.getInstance();
            String sqlInsert = "UPDATE cadastro SET"
                    + " nome = ?, apelido = ?,"
                    + " password = ?, rep_password = ?, email = ?,"
                    + " pais = ?, endereco = ?, telefone = ?"
                    + " WHERE cadastroId = ?";
            PreparedStatement pt = conn.prepareStatement(sqlInsert);
            //pt.setString(1,((Cadastro) o).getICadastroId());
            pt.setString(1,((Cadastro) o).getNome());
            pt.setString(2,((Cadastro) o).getApelido());
            pt.setString(3,((Cadastro) o).getPassword());
            pt.setString(4,((Cadastro) o).getRep_password());
            pt.setString(5,((Cadastro) o).getEmail());
            pt.setString(6,((Cadastro) o).getPais());
            pt.setString(7,((Cadastro) o).getEndereco());
            pt.setString(8,((Cadastro) o).getTelefone());
            pt.setInt(9,((Cadastro) o).getRCadastroId());


            ris = pt.executeUpdate();
            pt.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE,ex.toString(),ex);
        }

        //Se insert OK return object se nao null
        return ris;
    }


    @Override
    public Object insert(Object o){
        boolean ris = false;
        try {
            Connection conn = Conexao.getInstance();
            String sqlInsert = "INSERT INTO cadastro VALUES(null,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pt = conn.prepareStatement(sqlInsert);
           // pt.setString(1,((Cadastro) o).getICadastroId());
            pt.setString(1,((Cadastro) o).getNome());
            pt.setString(2,((Cadastro) o).getApelido());
            pt.setString(3,((Cadastro) o).getPassword());
            pt.setString(4,((Cadastro) o).getRep_password());
            pt.setString(5,((Cadastro) o).getEmail());
            pt.setString(6,((Cadastro) o).getPais());
            pt.setString(7,((Cadastro) o).getEndereco());
            pt.setString(8,((Cadastro) o).getTelefone());
            pt.setString(9,"user");

            ris = pt.execute();
            pt.close();
            conn.close();

            ris = pt.execute();
            pt.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE,ex.toString(),ex);
        }

        //Se insert OK return object se nao null
        if (ris) {
        return o;
        }
        return null;
    }

    /*exemplo de um insert que mostra o erro
    public Object insert2(Object o) throws Exception{
        boolean ris = false;

            Connection conn = Conexao.getInstance();
            String sqlInsert = "INSERT INTO cadastro VALUES(null,?,?,?,?,?,?,?,?)";
            PreparedStatement pt = conn.prepareStatement(sqlInsert);
           // pt.setString(1,((Cadastro) o).getICadastroId());
            pt.setString(1,((Cadastro) o).getNome());
            pt.setString(2,((Cadastro) o).getApelido());
            pt.setString(3,((Cadastro) o).getPassword());
            pt.setString(4,((Cadastro) o).getRep_password());
            pt.setString(5,((Cadastro) o).getEmail());
            pt.setString(6,((Cadastro) o).getPais());
            pt.setString(7,((Cadastro) o).getEndereco());
            pt.setString(8,((Cadastro) o).getTelefone());

            ris = pt.execute();
            pt.close();
            conn.close();

        //Se insert OK return object se nao null
        if (ris) {
        return o;
        }
        return null;
    }*/


    @Override
    public java.util.ArrayList<Object> selectAll() {
        String query = "SELECT * FROM cadastro";
        Cadastro c;
        ArrayList cadastros = new ArrayList<Cadastro>();
        try {
             Connection conn = Conexao.getInstance();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(query);
             while(rs.next()){
                // Criar um Cadastro
                c = (Cadastro) this.newElement();

                //Inizializar um Cadastro
                c.setRCadastroId(rs.getInt("cadastroId"));
                c.setNome(rs.getString("nome"));
                c.setApelido(rs.getString("apelido"));
                c.setPassword(rs.getString("password"));
                c.setRep_password(rs.getString("rep_password"));
                c.setEmail(rs.getString("email"));
                c.setPais(rs.getString("pais"));
                c.setEndereco(rs.getString("endereco"));
                c.setTelefone(rs.getString("telefone"));

                //juntar um Cadastro
                cadastros.add(c);
             }
             st.close();
             conn.close();
        }catch(Exception ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE,ex.toString(),ex);
        }
        return cadastros;
    }


     public java.util.ArrayList<Object> selectCadastrosByNome(String nome) {
        String query = "SELECT * FROM cadastro WHERE nome like ? ";
        Cadastro c;
        ArrayList cadastros = new ArrayList<Cadastro>();
        try {
             Connection conn = Conexao.getInstance();
             PreparedStatement ps = conn.prepareStatement(query);
             ps.setString(1, "%"+nome+"%");
             ResultSet rs = ps.executeQuery();
             while(rs.next()){
                // Criar um Cadastro
                c = (Cadastro) this.newElement();

                //Inizializar um Cadastro
                c.setRCadastroId(rs.getInt("cadastroId"));
                c.setNome(rs.getString("nome"));
                c.setApelido(rs.getString("apelido"));
                c.setPassword(rs.getString("password"));
                c.setRep_password(rs.getString("rep_password"));
                c.setEmail(rs.getString("email"));
                c.setPais(rs.getString("pais"));
                c.setEndereco(rs.getString("endereco"));
                c.setTelefone(rs.getString("telefone"));

                //juntar um Cadastro
                cadastros.add(c);
             }
             ps.close();
             conn.close();
        }catch(Exception ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE,ex.toString(),ex);
        }
        return cadastros;

    }


public java.util.ArrayList<Object> loginUser(String email, String password) {
        String query = "SELECT * FROM cadastro WHERE email = ?  and password = ? and tipo = 'user'";
        Cadastro c;
        ArrayList cadastros = new ArrayList<Cadastro>();
        try {
             Connection conn = Conexao.getInstance();
             PreparedStatement ps = conn.prepareStatement(query);
             ps.setString(1, email);
             ps.setString(2, password);
             ResultSet rs = ps.executeQuery();
             while(rs.next()){
                // Criar um cadastro
                c = (Cadastro) this.newElement();

                //Inizializar um cadastro
                c.setRCadastroId(rs.getInt("cadastroId"));
                c.setNome(rs.getString("nome"));
                c.setApelido(rs.getString("apelido"));
                c.setPassword(rs.getString("password"));
                c.setRep_password(rs.getString("rep_password"));
                c.setEmail(rs.getString("email"));
                c.setPais(rs.getString("pais"));
                c.setEndereco(rs.getString("endereco"));
                c.setTelefone(rs.getString("telefone"));


                //juntar um cadastro
                cadastros.add(c);
             }
             ps.close();
             conn.close();
        }catch(Exception ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE,ex.toString(),ex);
        }
        return cadastros;

    }

public java.util.ArrayList<Object> loginAdmin(String email, String password) {
        String query = "SELECT * FROM cadastro WHERE email = ?  and password = ? and tipo = 'admin'";
        Cadastro c;
        ArrayList cadastros = new ArrayList<Cadastro>();
        try {
             Connection conn = Conexao.getInstance();
             PreparedStatement ps = conn.prepareStatement(query);
             ps.setString(1, email);
             ps.setString(2, password);
             ResultSet rs = ps.executeQuery();
             while(rs.next()){
                // Criar um cadastro
                c = (Cadastro) this.newElement();

                //Inizializar um cadastro
                c.setRCadastroId(rs.getInt("cadastroId"));
                c.setNome(rs.getString("nome"));
                c.setApelido(rs.getString("apelido"));
                c.setPassword(rs.getString("password"));
                c.setRep_password(rs.getString("rep_password"));
                c.setEmail(rs.getString("email"));
                c.setPais(rs.getString("pais"));
                c.setEndereco(rs.getString("endereco"));
                c.setTelefone(rs.getString("telefone"));


                //juntar um cadastro
                cadastros.add(c);
             }
             ps.close();
             conn.close();
        }catch(Exception ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE,ex.toString(),ex);
        }
        return cadastros;

    }
public java.util.ArrayList<Object> selectCadastrosByPrimaryKey(String primaryKey) {
        String query = "SELECT * FROM cadastro WHERE cadastroId = ? ";
        Cadastro c;
        ArrayList cadastros = new ArrayList<Cadastro>();
        try {
             Connection conn = Conexao.getInstance();
             PreparedStatement ps = conn.prepareStatement(query);
             ps.setString(1, primaryKey);
             ResultSet rs = ps.executeQuery();
             while(rs.next()){
                // Criar um produto
                c = (Cadastro) this.newElement();

                //Inizializar um cadastroo
                c.setRCadastroId(rs.getInt("cadastroId"));
                c.setNome(rs.getString("nome"));
                c.setApelido(rs.getString("apelido"));
                c.setPassword(rs.getString("password"));
                c.setRep_password(rs.getString("rep_password"));
                c.setEmail(rs.getString("email"));
                c.setPais(rs.getString("pais"));
                c.setEndereco(rs.getString("endereco"));
                c.setTelefone(rs.getString("telefone"));


                //juntar um cadastro
                cadastros.add(c);
             }
             ps.close();
             conn.close();
        }catch(Exception ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE,ex.toString(),ex);
        }
        return cadastros;

}
public java.util.ArrayList<Object> selectCadastrosByEmail(String email) {
        String query = "SELECT * FROM cadastro WHERE email = ? ";
        Cadastro c;
        ArrayList cadastros = new ArrayList<Cadastro>();
        try {
             Connection conn = Conexao.getInstance();
             PreparedStatement ps = conn.prepareStatement(query);
             ps.setString(1, email);
             ResultSet rs = ps.executeQuery();
             while(rs.next()){
                // Criar um produto
                c = (Cadastro) this.newElement();

                //Inizializar um cadastroo
                c.setRCadastroId(rs.getInt("cadastroId"));
                c.setNome(rs.getString("nome"));
                c.setApelido(rs.getString("apelido"));
                c.setPassword(rs.getString("password"));
                c.setRep_password(rs.getString("rep_password"));
                c.setEmail(rs.getString("email"));
                c.setPais(rs.getString("pais"));
                c.setEndereco(rs.getString("endereco"));
                c.setTelefone(rs.getString("telefone"));


                //juntar um cadastro
                cadastros.add(c);
             }
             ps.close();
             conn.close();
        }catch(Exception ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE,ex.toString(),ex);
        }
        return cadastros;

}


}
