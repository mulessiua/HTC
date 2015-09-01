/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package produto;

/**
 *
 * @author Mulessiua(Carlitos)
 */
public class CarrinhoOrdem {

    private int carrinhoId;
    private int cadastroId;
    private int produtoId;
    

    public CarrinhoOrdem(){

    }
    public CarrinhoOrdem(int carrinhoId, int cadastroId, int produtoId){
    this.carrinhoId=carrinhoId;
    this.cadastroId=cadastroId;
    this.produtoId=produtoId;
    }

    public int getCadastroId() {
        return cadastroId;
    }

    public void setCadastroId(int cadastroId) {
        this.cadastroId = cadastroId;
    }

    public int getCarrinhoId() {
        return carrinhoId;
    }

    public void setCarrinhoId(int carrinhoId) {
        this.carrinhoId = carrinhoId;
    }

    public int getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(int produtoId) {
        this.produtoId = produtoId;
    }

    
}
