/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domainModel;

import java.io.File;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author lewandowsky
 */
public class Midia implements Serializable{
    private String codMidia;
    private List<File> listaDeArquivos;
    private String descricao;

    public Midia() {
        this.codMidia = "";
        this.listaDeArquivos = new LinkedList<>();
        this.descricao = "";
    }

    public String getCodMidia() {
        return codMidia;
    }

    public void setCodMidia(String codMidia) {
        this.codMidia = codMidia;
    }

    public List<File> getListaDeArquivos() {
        return listaDeArquivos;
    }

    public void setListaDeArquivos(List<File> listaDeArquivos) {
        this.listaDeArquivos = listaDeArquivos;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public void addArquivo(File a){
        if(!this.listaDeArquivos.contains(a)){
            this.listaDeArquivos.add(a);
        }
    }
    
    public void removeArquivo(File a){
        if(this.listaDeArquivos.contains(a)){
            this.listaDeArquivos.remove(a);
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.codMidia);
        hash = 29 * hash + Objects.hashCode(this.listaDeArquivos);
        hash = 29 * hash + Objects.hashCode(this.descricao);
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
        final Midia other = (Midia) obj;
        if (!Objects.equals(this.codMidia, other.codMidia)) {
            return false;
        }
        if (!Objects.equals(this.listaDeArquivos, other.listaDeArquivos)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return codMidia;
    }
    
    
    
    
}
