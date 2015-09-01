/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package carrinho;

import produto.Produto;
import java.util.ArrayList;

public class Carrinho {
    private ArrayList<CarrinhoItem> items;
    private int carrinhoId;
    private int numeroItems;
    private double totale;
    private int RCadastroId;


    public Carrinho() {
        items = new ArrayList<CarrinhoItem>();
        numeroItems = 0;
        totale = 0;
    }

     public void adicionaItem(Produto p) {

        boolean novoItem = true;

        for (CarrinhoItem cItem : items) {

            if (cItem.getProduto().getProdutoId()==(p.getProdutoId())) {

                novoItem = false;
                cItem.incrementaQuantidade();
                break;
            }
        }

        if (novoItem) {
            CarrinhoItem cItem = new CarrinhoItem(p);
            items.add(cItem);
        }
    }

    
    public void atualizaQuantidade(Produto p, short qt) {

        if (qt >= 0) {
            CarrinhoItem item = null;

            for (CarrinhoItem cItem : items) {
                if (cItem.getProduto().getProdutoId()==(p.getProdutoId())) {
                    if (qt != 0) {
                        // atualiza quantidade a novo valor
                        cItem.setQuantidade(qt);
                        break;
                    } else {
                        // se quantidade è 0 break
                        item = cItem;
                        break;
                    }
                }
            }

            if (item != null) {
                // apaga da carinho
                items.remove(item);
            }
        }
    }

    
    public ArrayList<CarrinhoItem> getItems() {
        return items;
    }

    
    public int getNumeroItems() {
        numeroItems = 0;
        for (CarrinhoItem cItem : items) {
            numeroItems += cItem.getQuantidade();
        }
        return numeroItems;
    }

    
    private void calculaTotale() {
         totale = 0;

        // cast surcharge as double
         for (CarrinhoItem cItem : items) {

            Produto p = cItem.getProduto();
            totale += (cItem.getQuantidade() * p.getPreco());
        }
    }

    
    public double getTotale() {
        calculaTotale();
        return totale;
    }

    public int getRCadastroId() {
        return RCadastroId;
    }

    public void setRCadastroId(int RCadastroId) {
        this.RCadastroId = RCadastroId;
    }



    public void clear() {
        items.clear();
        numeroItems = 0;
        totale = 0;
    }
}
