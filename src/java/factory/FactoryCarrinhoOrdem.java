/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package factory;

import produto.CarrinhoOrdem;
import dao.Conexao;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.logging.Level;

public class FactoryCarrinhoOrdem extends Factory{

    @Override
    public  Object newElement() {
        return new CarrinhoOrdem();
    }

    @Override
    public  Object read(Object primaryKey){
       CarrinhoOrdem c;
       // Criar um Carrinho
       c = (CarrinhoOrdem) this.newElement();
       String query = "SELECT * FROM carrinho WHERE carrinhooId = ?";
      try {
        Connection conn = Conexao.getInstance();
        PreparedStatement pt = conn.prepareStatement(query);
        pt.setString(1,(String) primaryKey);
        ResultSet rs = pt.executeQuery();
        if (rs.next()){
                //Inizializar um Carrinho
                c.setCarrinhoId(rs.getInt("carrinhoId"));
                c.setCadastroId(rs.getInt("cadastroId"));
                c.setProdutoId(rs.getInt("produtoId"));
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
       String query = "DELETE FROM carrinho WHERE carrinhoId = ?";
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
            String sqlInsert = "UPDATE carrinho SET"
                    + " carrinhoId =?, cadastroId = ?, produtoId = ?"
                    + " WHERE carrinhoId = ?";
            PreparedStatement pt = conn.prepareStatement(sqlInsert);
            pt.setInt(1,((CarrinhoOrdem) o).getCarrinhoId());
            pt.setInt(2,((CarrinhoOrdem) o).getCadastroId());
            pt.setInt(3,((CarrinhoOrdem) o).getProdutoId());
            
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
            String sqlInsert = "INSERT INTO carrinho VALUES(null,?,?)";
            PreparedStatement pt = conn.prepareStatement(sqlInsert);
           // pt.setString(1,((Cadastro) o).getICadastroId());
            pt.setInt(1,((CarrinhoOrdem) o).getCadastroId());
            pt.setInt(2,((CarrinhoOrdem) o).getProdutoId());

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

    @Override
    public java.util.ArrayList<Object> selectAll() {
        String query = "SELECT distinct cadastroId FROM carrinho";
        CarrinhoOrdem c;
        ArrayList carrinhoOrdens = new ArrayList<CarrinhoOrdem>();
        try {
             Connection conn = Conexao.getInstance();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(query);
             while(rs.next()){
                // Criar um Carrinho
                c = (CarrinhoOrdem) this.newElement();

                //Inizializar um Carrinho
                c.setCarrinhoId(rs.getInt("carrinhoId"));
                c.setCadastroId(rs.getInt("cadastroId"));
                c.setProdutoId(rs.getInt("produtoId"));

                //juntar um Carrinho
                carrinhoOrdens.add(c);
             }
             st.close();
             conn.close();
        }catch(Exception ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE,ex.toString(),ex);
        }
        return carrinhoOrdens;
    }

    public java.util.ArrayList<Object> selectCarrinhoOrdensByCadastroId(int cadastroId) {
        String query = "SELECT * FROM carrinho WHERE cadastroId = ? ";
        CarrinhoOrdem c;
        ArrayList carrinhoOrdens = new ArrayList<CarrinhoOrdem>();
        try {
             Connection conn = Conexao.getInstance();
             PreparedStatement ps = conn.prepareStatement(query);
             ps.setInt(1, cadastroId);
             ResultSet rs = ps.executeQuery();
             while(rs.next()){
                // Criar um carrinho
                c = (CarrinhoOrdem) this.newElement();

                //Inizializar um carrinho
                c.setCarrinhoId(rs.getInt("carrinhoId"));
                c.setCadastroId(rs.getInt("cadastroId"));
                c.setProdutoId(rs.getInt("produtoId"));


                //juntar um carrinho
                carrinhoOrdens.add(c);
             }
             ps.close();
             conn.close();
        }catch(Exception ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE,ex.toString(),ex);
        }
        return carrinhoOrdens;

}
 public java.util.ArrayList<Object> selectAllCadastroId() {
        String query = "SELECT distinct cadastroId FROM carrinho";
        CarrinhoOrdem c;
        ArrayList carrinhoOrdens = new ArrayList<CarrinhoOrdem>();
        try {
             Connection conn = Conexao.getInstance();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(query);
             while(rs.next()){
                // Criar um Carrinho
                c = (CarrinhoOrdem) this.newElement();

                //Inizializar um Carrinho
                //c.setCarrinhoId(rs.getInt("carrinhoId"));
                c.setCadastroId(rs.getInt("cadastroId"));
                //c.setProdutoId(rs.getInt("produtoId"));

                //juntar um Carrinho
                carrinhoOrdens.add(c);
             }
             st.close();
             conn.close();
        }catch(Exception ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE,ex.toString(),ex);
        }
        return carrinhoOrdens;
    }
 
}
