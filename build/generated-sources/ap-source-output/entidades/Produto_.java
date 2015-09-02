package entidades;

import entidades.Pedido;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-09-01T17:49:43")
@StaticMetamodel(Produto.class)
public class Produto_ { 

    public static volatile SingularAttribute<Produto, Double> preco;
    public static volatile SingularAttribute<Produto, Integer> produtoId;
    public static volatile SingularAttribute<Produto, String> tipo;
    public static volatile SingularAttribute<Produto, Integer> vendidos;
    public static volatile SingularAttribute<Produto, String> acompanhantes;
    public static volatile SingularAttribute<Produto, String> nome;
    public static volatile SingularAttribute<Produto, Integer> stok;
    public static volatile CollectionAttribute<Produto, Pedido> pedidoCollection;
    public static volatile SingularAttribute<Produto, String> descricao;

}