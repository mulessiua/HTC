/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import dao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import entidades.Utilizador;

/**
 *
 * @author ab
 */
public class FactoryUtilizador extends Factory{
    
    @Override
    public  Object newElement() {
        return new Utilizador();
    }

    @Override
    public  Object read(Object primaryKey){
       Utilizador u;
       // Criar um produto
       u = (Utilizador) this.newElement();
       String query = "SELECT * FROM utilizador WHERE utilizadorId = ?";
      try {
        Connection conn = Conexao.getInstance();
        PreparedStatement pt = conn.prepareStatement(query);
        pt.setString(1,(String) primaryKey);
        ResultSet rs = pt.executeQuery();
        if (rs.next()){
                //Inizializar um produto
                u.setUtilizadorId(rs.getInt("utilizadorId"));
                u.setNome(rs.getString("nome"));
                u.setApelido(rs.getString("apelido"));
                u.setEmail(rs.getString("email"));
                u.setPassword(rs.getString("password"));
                u.setEndereco(rs.getString("endereco"));
                u.setTelefone(rs.getString("telefone"));
                u.setNivel(rs.getString("nivel"));

             }
             pt.close();
             conn.close();
        }catch(Exception ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE,ex.toString(),ex);
        }
       return u;
    }

    @Override
    public  int delete(Object primaryKey){
       int ris = 0;
       String query = "DELETE FROM utilizador WHERE utilizadorId = ?";
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
            String sqlInsert = "UPDATE utilizador SET"
                    + " utilizadorId =?, nome = ?, apelido = ?,"
                    + " email = ?, password = ?, endereco = ?,"
                    + " telefone = ?, nivel = ?"
                    + " WHERE utilizadorId = ?";
            PreparedStatement pt = conn.prepareStatement(sqlInsert);
            pt.setInt(1,((Utilizador) o).getUtilizadorId());
            pt.setString(2,((Utilizador) o).getNome());
            pt.setString(3,((Utilizador) o).getApelido());
            pt.setString(4,((Utilizador) o).getEmail());
            pt.setString(5,((Utilizador) o).getPassword());
            pt.setString(6,((Utilizador) o).getEndereco());
            pt.setString(7,((Utilizador) o).getTelefone());
            pt.setString(8,((Utilizador) o).getNivel());
            pt.setInt(9,((Utilizador) o).getUtilizadorId());

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
            String sqlInsert = "INSERT INTO utilizador VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement pt = conn.prepareStatement(sqlInsert);
            pt.setInt(1,((Utilizador) o).getUtilizadorId());
            pt.setString(2,((Utilizador) o).getNome());
            pt.setString(3,((Utilizador) o).getApelido());
            pt.setString(4,((Utilizador) o).getEmail());
            pt.setString(5,((Utilizador) o).getPassword());
            pt.setString(6,((Utilizador) o).getEndereco());
            pt.setString(7,((Utilizador) o).getTelefone());
            pt.setString(8,((Utilizador) o).getNivel());

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

    @Override
    public java.util.ArrayList<Object> selectAll() {
        String query = "SELECT * FROM utilizador";
        Utilizador u;
        ArrayList utilizadores = new ArrayList<Utilizador>();
        try {
             Connection conn = Conexao.getInstance();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(query);
             while(rs.next()){
                // Criar um produto
                u = (Utilizador) this.newElement();

                //Inizializar um produto
                u.setUtilizadorId(rs.getInt("utilizadorId"));
                u.setNome(rs.getString("nome"));
                u.setApelido(rs.getString("apelido"));
                u.setEmail(rs.getString("email"));
                u.setPassword(rs.getString("password"));
                u.setEndereco(rs.getString("endereco"));
                u.setTelefone(rs.getString("telefone"));
                u.setNivel(rs.getString("nivel"));

                //juntar um produto
                utilizadores.add(u);
             }
             st.close();
             conn.close();
        }catch(Exception ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE,ex.toString(),ex);
        }
        return utilizadores;
    }

public java.util.ArrayList<Object> login(String email, String password) {
        String query = "SELECT * FROM utilizador WHERE email = ?  and password = ?";
        Utilizador u;
        ArrayList utilizadores = new ArrayList<Utilizador>();
        try {
             Connection conn = Conexao.getInstance();
             PreparedStatement ps = conn.prepareStatement(query);
             ps.setString(1, email);
             ps.setString(2, password);
             ResultSet rs = ps.executeQuery();
             while(rs.next()){
                // Criar um cadastro
                u = (Utilizador) this.newElement();

                //Inizializar um cadastro
                u.setUtilizadorId(rs.getInt("utilizadorId"));
                u.setNome(rs.getString("nome"));
                u.setApelido(rs.getString("apelido"));
                u.setEmail(rs.getString("email"));
                u.setPassword(rs.getString("password"));
                u.setEndereco(rs.getString("endereco"));
                u.setTelefone(rs.getString("telefone"));
                u.setNivel(rs.getString("nivel"));


                //juntar um cadastro
                utilizadores.add(u);
             }
             ps.close();
             conn.close();
        }catch(Exception ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE,ex.toString(),ex);
        }
        return utilizadores;

    }
     
    
}
