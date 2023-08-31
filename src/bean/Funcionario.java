package bean;

import java.util.Objects;

/**
 *
 * @author u10154925179
 */
public class Funcionario {

    private int idFuncionario;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    private int cargo;

    public Funcionario() {

    }

    /**
     * @return the idFuncionario
     */
    public int getIdFuncionario() {
        return idFuncionario;
    }

    /**
     * @param idFuncionario the idFuncionario to set
     */
    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the cargo
     */
    public int getCargo() {
        return cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(int cargo) {
        this.cargo = cargo;
    }
    
    @Override
    public String toString(){
    return getIdFuncionario() + " - " + getNome();
    }
    
    /**
     *
     * @param object
     * @return
     */
    @Override
    public boolean equals(Object object){
        if (object instanceof Funcionario){
        Funcionario funcionario = (Funcionario) object;
        if (this.getIdFuncionario() == funcionario.getIdFuncionario()) {
        return true;
        }
        }
        return false;
   }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.idFuncionario;
        hash = 83 * hash + Objects.hashCode(this.nome);
        hash = 83 * hash + Objects.hashCode(this.email);
        hash = 83 * hash + Objects.hashCode(this.telefone);
        hash = 83 * hash + Objects.hashCode(this.cpf);
        hash = 83 * hash + this.cargo;
        return hash;
    }
}