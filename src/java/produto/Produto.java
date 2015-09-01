/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package produto;

/**
 *
 * @author Mulessiua(Carlitos)
 */
public class Produto {

    private int produtoId;
    private String categoria;
    private String nome;
    private String descricao;
    private double preco;
    private String imagen;
    private int disponivel;


    public Produto(){}

    public Produto(String categoria, String nome){
        this.categoria=categoria;
        this.nome=nome;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(int produtoId) {
        this.produtoId = produtoId;
    }
    
    public int getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(int disponivel) {
        this.disponivel = disponivel;
    }

    public int getVendido() {
        return vendido;
    }

    public void setVendido(int vendido) {
        this.vendido = vendido;
    }
    private int vendido;

}

