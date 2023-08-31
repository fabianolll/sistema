package bean;

import java.util.Objects;

public class Fornecedor {

    private int idfornecedor;
    private String nome;
    private String email;
    private String telefone;
    private String cnpj;
    private String endereco;

    public int getIdfornecedor() {
        return idfornecedor;
    }

    public void setIdfornecedor(int idfornecedor) {
        this.idfornecedor = idfornecedor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    
    @Override
    public String toString(){
    return getIdfornecedor() + " - " + getNome();
    }
    
    /**
     *
     * @param object
     * @return
     */
    @Override
    public boolean equals(Object object){
        if (object instanceof Fornecedor){
        Fornecedor fornecedor = (Fornecedor) object;
        if (this.getIdfornecedor() == fornecedor.getIdfornecedor()) {
        return true;
        }
        }
    
    return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.idfornecedor;
        hash = 17 * hash + Objects.hashCode(this.nome);
        hash = 17 * hash + Objects.hashCode(this.email);
        hash = 17 * hash + Objects.hashCode(this.telefone);
        hash = 17 * hash + Objects.hashCode(this.cnpj);
        hash = 17 * hash + Objects.hashCode(this.endereco);
        return hash;
    }
}