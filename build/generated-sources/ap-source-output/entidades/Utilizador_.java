package entidades;

import entidades.Pedido;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-09-01T17:49:43")
@StaticMetamodel(Utilizador.class)
public class Utilizador_ { 

    public static volatile SingularAttribute<Utilizador, String> password;
    public static volatile SingularAttribute<Utilizador, String> telefone;
    public static volatile SingularAttribute<Utilizador, String> apelido;
    public static volatile SingularAttribute<Utilizador, String> endereco;
    public static volatile SingularAttribute<Utilizador, Integer> utilizadorId;
    public static volatile SingularAttribute<Utilizador, String> nome;
    public static volatile CollectionAttribute<Utilizador, Pedido> pedidoCollection;
    public static volatile SingularAttribute<Utilizador, String> nivel;
    public static volatile SingularAttribute<Utilizador, String> email;

}