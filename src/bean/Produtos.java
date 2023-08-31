package bean;

import java.util.Objects;

public class Produtos {
    
    public Produtos(){
    
}
    private int idProduto; // Variável que armazena o idproduto doo produto
    private String nome; // Variável que armazena o nome do produto
    private int quantidade; // Variável que armazena a quantidade de produtos
    private double valor; // Variável que armazena o valor dos produtos 
    private String tipo; // Variável que armazena o tipo do produto

    //Encapsulamento das variáveis 
    
    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    @Override
 public String toString(){
    return getIdProduto() + " - " + getNome();
    }
    
    /**
     *
     * @param object
     * @return
     */
    @Override
    public boolean equals(Object object){
        if (object instanceof Produtos){
        Produtos produtos = (Produtos) object;
        if (this.getIdProduto() == produtos.getIdProduto()) {
        return true;
        }
        }
    
    return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.idProduto;
        hash = 59 * hash + Objects.hashCode(this.nome);
        hash = 59 * hash + this.quantidade;
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.valor) ^ (Double.doubleToLongBits(this.valor) >>> 32));
        hash = 59 * hash + Objects.hashCode(this.tipo);
        return hash;
    }
}
