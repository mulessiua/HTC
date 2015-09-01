/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package produto;

/**
 *
 * @author Mulessiua(Carlitos)
 */
public class Cadastro {

    private int RCadastroId;
    private String ICadastroId;
    private String nome;
    private String apelido;
    private String password;
    private String rep_password;
    private String email;
    private String pais;
    private String endereco;
    private String telefone;
    private String tipo;

    
    public Cadastro(){}
    
    public Cadastro(String nome, String apelido){
        this.nome=nome;
        this.apelido=apelido;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public int getRCadastroId() {
        return RCadastroId;
    }

    public void setRCadastroId(int RCadastroId) {
        this.RCadastroId = RCadastroId;
    }

    public String getICadastroId() {
        return ICadastroId;
    }

    public void setICadastroId(String ICadastroId) {
        this.ICadastroId = ICadastroId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRep_password() {
        return rep_password;
    }

    public void setRep_password(String rep_password) {
        this.rep_password = rep_password;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
    
}
