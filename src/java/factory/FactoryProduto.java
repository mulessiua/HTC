/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package factory;

import produto.Produto;
import dao.Conexao;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.logging.Level;
/**
 *
 * @author Mulessiua(Carlitos)
 */
public class FactoryProduto extends Factory{

    @Override
    public  Object newElement() {
        return new Produto();
    }

    @Override
    public  Object read(Object primaryKey){
       Produto p;
       // Criar um produto
       p = (Produto) this.newElement();
       String query = "SELECT * FROM produto WHERE produtoId = ?";
      try {
        Connection conn = Conexao.getInstance();
        PreparedStatement pt = conn.prepareStatement(query);
        pt.setString(1,(String) primaryKey);
        ResultSet rs = pt.executeQuery();
        if (rs.next()){
                //Inizializar um produto
                p.setProdutoId(rs.getInt("produtoId"));
                p.setCategoria(rs.getString("categoria"));
                p.setNome(rs.getString("nome"));
                p.setDescricao(rs.getString("descricao"));
                p.setPreco(rs.getDouble("preco"));
                p.setImagen(rs.getString("imagen"));
                p.setDisponivel(rs.getInt("disponivel"));
                p.setVendido(rs.getInt("vendido"));

             }
             pt.close();
             conn.close();
        }catch(Exception ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE,ex.toString(),ex);
        }
       return p;
    }

    @Override
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

    @Override
    public int update(Object o){
        int ris = 0;
        try {
            Connection conn = Conexao.getInstance();
            String sqlInsert = "UPDATE produto SET"
                    + " produtoId =?, categoria = ?, nome = ?,"
                    + " descricao = ?, preco = ?, imagen = ?,"
                    + " disponivel = ?, vendido = ?"
                    + " WHERE produtoId = ?";
            PreparedStatement pt = conn.prepareStatement(sqlInsert);
            pt.setInt(1,((Produto) o).getProdutoId());
            pt.setString(2,((Produto) o).getCategoria());
            pt.setString(3,((Produto) o).getNome());
            pt.setString(4,((Produto) o).getDescricao());
            pt.setDouble(5,((Produto) o).getPreco());
            pt.setString(6,((Produto) o).getImagen());
            pt.setInt(7,((Produto) o).getDisponivel());
            pt.setInt(8,((Produto) o).getVendido());
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

    @Override
    public Object insert(Object o){
        boolean ris = false;
        try {
            Connection conn = Conexao.getInstance();
            String sqlInsert = "INSERT INTO produto VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement pt = conn.prepareStatement(sqlInsert);
            pt.setInt(1,((Produto) o).getProdutoId());
            pt.setString(2,((Produto) o).getCategoria());
            pt.setString(3,((Produto) o).getNome());
            pt.setString(4,((Produto) o).getDescricao());
            pt.setDouble(5,((Produto) o).getPreco());
            pt.setString(6,((Produto) o).getImagen());
            pt.setInt(7,((Produto) o).getDisponivel());
            pt.setInt(8,((Produto) o).getVendido());

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
        String query = "SELECT * FROM produto";
        Produto p;
        ArrayList produtos = new ArrayList<Produto>();
        try {
             Connection conn = Conexao.getInstance();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(query);
             while(rs.next()){
                // Criar um produto
                p = (Produto) this.newElement();

                //Inizializar um produto
                p.setProdutoId(rs.getInt("produtoId"));
                p.setCategoria(rs.getString("categoria"));
                p.setNome(rs.getString("nome"));
                p.setDescricao(rs.getString("descricao"));
                p.setPreco(rs.getDouble("preco"));
                p.setImagen(rs.getString("imagen"));
                p.setDisponivel(rs.getInt("disponivel"));
                p.setVendido(rs.getInt("vendido"));

                //juntar um produto
                produtos.add(p);
             }
             st.close();
             conn.close();
        }catch(Exception ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE,ex.toString(),ex);
        }
        return produtos;
    }


     public java.util.ArrayList<Object> selectProdutosByNome(String nome) {
        String query = "SELECT * FROM produto WHERE nome like ? ";
        Produto p;
        ArrayList produtos = new ArrayList<Produto>();
        try {
             Connection conn = Conexao.getInstance();
             PreparedStatement ps = conn.prepareStatement(query);
             ps.setString(1, "%"+nome+"%");
             ResultSet rs = ps.executeQuery();
             while(rs.next()){
                // Criar um produto
                p = (Produto) this.newElement();

                //Inizializar um produto
                p.setProdutoId(rs.getInt("produtoId"));
                p.setCategoria(rs.getString("categoria"));
                p.setNome(rs.getString("nome"));
                p.setDescricao(rs.getString("descricao"));
                p.setPreco(rs.getDouble("preco"));
                p.setImagen(rs.getString("imagen"));
                p.setDisponivel(rs.getInt("disponivel"));
                p.setVendido(rs.getInt("vendido"));

                //juntar um produto
                produtos.add(p);
             }
             ps.close();
             conn.close();
        }catch(Exception ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE,ex.toString(),ex);
        }
        return produtos;

    }

    public java.util.ArrayList<Object> selectProdutosByCategoria(String categoria) {
        String query = "SELECT * FROM produto WHERE categoria like ? ";
        Produto p;
        ArrayList produtos = new ArrayList<Produto>();
        try {
             Connection conn = Conexao.getInstance();
             PreparedStatement ps = conn.prepareStatement(query);
             ps.setString(1, "%"+categoria+"%");
             ResultSet rs = ps.executeQuery();
             while(rs.next()){
                // Criar um produto
                p = (Produto) this.newElement();

                //Inizializar umproduto
                p.setProdutoId(rs.getInt("produtoId"));
                p.setCategoria(rs.getString("categoria"));
                p.setNome(rs.getString("nome"));
                p.setDescricao(rs.getString("descricao"));
                p.setPreco(rs.getDouble("preco"));
                p.setImagen(rs.getString("imagen"));
                p.setDisponivel(rs.getInt("disponivel"));
                p.setVendido(rs.getInt("vendido"));


                //juntar um produto
                produtos.add(p);
             }
             ps.close();
             conn.close();
        }catch(Exception ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE,ex.toString(),ex);
        }
        return produtos;

    }

    public java.util.ArrayList<Object> selectProdutosByMarca(String marca) {
        String query = "SELECT * FROM produto WHERE categoria = 'computador' and nome like ? ";
        Produto p;
        ArrayList produtos = new ArrayList<Produto>();
        try {
             Connection conn = Conexao.getInstance();
             PreparedStatement ps = conn.prepareStatement(query);
             ps.setString(1, "%"+marca+"%");
             ResultSet rs = ps.executeQuery();
             while(rs.next()){
                // Criar um produto
                p = (Produto) this.newElement();

                //Inizializar umproduto
                p.setProdutoId(rs.getInt("produtoId"));
                p.setCategoria(rs.getString("categoria"));
                p.setNome(rs.getString("nome"));
                p.setDescricao(rs.getString("descricao"));
                p.setPreco(rs.getDouble("preco"));
                p.setImagen(rs.getString("imagen"));
                p.setDisponivel(rs.getInt("disponivel"));
                p.setVendido(rs.getInt("vendido"));


                //juntar um produto
                produtos.add(p);
             }
             ps.close();
             conn.close();
        }catch(Exception ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE,ex.toString(),ex);
        }
        return produtos;

    }

   public java.util.ArrayList<Object> selectProdutosByPrimaryKey(String primaryKey) {
        String query = "SELECT * FROM produto WHERE produtoId = ? ";
        Produto p;
        ArrayList produtos = new ArrayList<Produto>();
        try {
             Connection conn = Conexao.getInstance();
             PreparedStatement ps = conn.prepareStatement(query);
             ps.setString(1, primaryKey);
             ResultSet rs = ps.executeQuery();
             while(rs.next()){
                // Criar um produto
                p = (Produto) this.newElement();

                //Inizializar umproduto
                p.setProdutoId(rs.getInt("produtoId"));
                p.setCategoria(rs.getString("categoria"));
                p.setNome(rs.getString("nome"));
                p.setDescricao(rs.getString("descricao"));
                p.setPreco(rs.getDouble("preco"));
                p.setImagen(rs.getString("imagen"));
                p.setDisponivel(rs.getInt("disponivel"));
                p.setVendido(rs.getInt("vendido"));


                //juntar um produto
                produtos.add(p);
             }
             ps.close();
             conn.close();
        }catch(Exception ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE,ex.toString(),ex);
        }
        return produtos;

    }
    
}
