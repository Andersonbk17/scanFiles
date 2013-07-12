
package domainModel;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author lewandowsky
 */
public class Arquivo {
    private String nome;
    private String endereco;
    private Date dataCriacao;
    private boolean ativo;
    private int tipo;
    

    public Arquivo() {
        this.nome = "";
        this.endereco = "";
        this.dataCriacao = new Date();
        this.ativo = true;
        this.tipo = 0;
    
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.nome);
        hash = 71 * hash + Objects.hashCode(this.endereco);
        hash = 71 * hash + Objects.hashCode(this.dataCriacao);
        hash = 71 * hash + (this.ativo ? 1 : 0);
        hash = 71 * hash + this.tipo;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Arquivo other = (Arquivo) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.dataCriacao, other.dataCriacao)) {
            return false;
        }
        return true;
    }

    

    @Override
    public String toString() {
        return this.nome;
    }
    
 
    
}
