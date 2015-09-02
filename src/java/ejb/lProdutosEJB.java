/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import dao.Conexao;
import entidades.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;

/**
 *
 * @author ab
 */
@Stateless
public class lProdutosEJB extends Factory{

    public  Object newElement() {
        return new Produto();
    }


    public  Object read(Object primaryKey){
       Produto u;
       // Criar um produto
       u = (Produto) this.newElement();
       String query = "SELECT * FROM produto WHERE produtoId = ?";
      try {
        Connection conn = Conexao.getInstance();
        PreparedStatement pt = conn.prepareStatement(query);
        pt.setString(1,(String) primaryKey);
        ResultSet rs = pt.executeQuery();
        if (rs.next()){
                //Inizializar um produto
                u.setProdutoId(rs.getInt("produtoId"));
                u.setTipo(rs.getString("tipo"));
                u.setNome(rs.getString("nome"));
                u.setDescricao(rs.getString("descricao"));
                u.setPreco(rs.getDouble("preco"));
                u.setStok(rs.getInt("stok"));
                u.setVendidos(rs.getInt("vendidos"));
                u.setAcompanhantes(rs.getString("acompanhantes"));

             }
             pt.close();
             conn.close();
        }catch(Exception ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE,ex.toString(),ex);
        }
       return u;
    }

    public  int delete(Object primaryKey){
       int ris = 0;
       String query = "DELETE FROM produto WHERE produtoId = ?";
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


    public int update(Object o){
        int ris = 0;
        try {
            Connection conn = Conexao.getInstance();
            String sqlInsert = "UPDATE produto SET"
                    + " produtoId =?, tipo = ?, nome = ?,"
                    + " descricao = ?, preco = ?, stok = ?,"
                    + " vendidos = ?, acompanhantes = ?"
                    + " WHERE produtoId = ?";
            PreparedStatement pt = conn.prepareStatement(sqlInsert);
            pt.setInt(1,((Produto) o).getProdutoId());
            pt.setString(2,((Produto) o).getTipo());
            pt.setString(3,((Produto) o).getNome());
            pt.setString(4,((Produto) o).getDescricao());
            pt.setDouble(5,((Produto) o).getPreco());
            pt.setInt(6,((Produto) o).getStok());
            pt.setInt(7,((Produto) o).getVendidos());
            pt.setString(8,((Produto) o).getAcompanhantes());
            pt.setInt(9,((Produto) o).getProdutoId());

            ris = pt.executeUpdate();
            pt.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE,ex.toString(),ex);
        }

        //Se insert OK return object se nao null
        return ris;
    }


    public Object insert(Object o){
        boolean ris = false;
        try {
            Connection conn = Conexao.getInstance();
            String sqlInsert = "INSERT INTO produto VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement pt = conn.prepareStatement(sqlInsert);
            
            pt.setInt(1,((Produto) o).getProdutoId());
            pt.setString(2,((Produto) o).getTipo());
            pt.setString(3,((Produto) o).getNome());
            pt.setString(4,((Produto) o).getDescricao());
            pt.setDouble(5,((Produto) o).getPreco());
            pt.setInt(6,((Produto) o).getStok());
            pt.setInt(7,((Produto) o).getVendidos());
            pt.setString(8,((Produto) o).getAcompanhantes());

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

    public java.util.ArrayList<Object> selectAll() {
        String query = "SELECT * FROM produto";
        Produto u;
        ArrayList produtos = new ArrayList<Produto>();
        try {
             Connection conn = Conexao.getInstance();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(query);
             while(rs.next()){
                // Criar um produto
                u = (Produto) this.newElement();

                //Inizializar um produto
                u.setProdutoId(rs.getInt("produtoId"));
                u.setTipo(rs.getString("tipo"));
                u.setNome(rs.getString("nome"));
                u.setDescricao(rs.getString("descricao"));
                u.setPreco(rs.getDouble("preco"));
                u.setStok(rs.getInt("stok"));
                u.setVendidos(rs.getInt("vendidos"));
                u.setAcompanhantes(rs.getString("acompanhantes"));

                //juntar um produto
                produtos.add(u);
             }
             st.close();
             conn.close();
        }catch(Exception ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE,ex.toString(),ex);
        }
        return produtos;
    }


}
