
package domainModel;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author lewandowsky
 */
public class Usuario implements Serializable{
    private int idUsuario;
    private String nome;
    private String senha;
    private Date dataUltimoAcesso;
    
    public Usuario(){
        this.idUsuario = 0;
        this.dataUltimoAcesso = new Date();
        this.nome = "";
        this.senha = "";
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getDataUltimoAcesso() {
        return dataUltimoAcesso;
    }

    public void setDataUltimoAcesso(Date dataUltimoAcesso) {
        this.dataUltimoAcesso = dataUltimoAcesso;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + this.idUsuario;
        hash = 47 * hash + Objects.hashCode(this.nome);
        hash = 47 * hash + Objects.hashCode(this.senha);
        hash = 47 * hash + Objects.hashCode(this.dataUltimoAcesso);
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.nome;
    }
    
    
}
