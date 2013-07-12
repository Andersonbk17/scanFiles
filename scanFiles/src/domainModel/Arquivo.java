
package domainModel;

import java.util.Date;

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
    private String codMidia;

    public Arquivo() {
        this.nome = "";
        this.endereco = "";
        this.dataCriacao = new Date();
        this.ativo = true;
        this.tipo = 0;
        this.codMidia = "";
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

    public String getCodMidia() {
        return codMidia;
    }

    public void setCodMidia(String codMidia) {
        this.codMidia = codMidia;
    }

    @Override
    public String toString() {
        return this.nome;
    }
    
 
    
}
