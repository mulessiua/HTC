/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package carrinho;

import produto.Produto;

public class CarrinhoItem {

    private Produto produto;
    private short  quantidade;

    public CarrinhoItem(Produto p){
        this.produto = p;
        this.quantidade = 1;
    }

    public Produto getProduto() {
        return this.produto;
    }

    public short getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(short qt){
        quantidade = qt;
    }

    public void incrementaQuantidade(){
        quantidade ++;
    }


}
