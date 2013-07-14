
package domainModel;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author lewandowsky
 */
public class Emprestimo {
    private int idEmpestimo;
    private List<Midia> listaDeMidias;
    private Pessoa pessoa;
    private Date dataEmprestimo;
    private Date dataDevolucao;

    public Emprestimo() {
        this.idEmpestimo = 0;
        this.listaDeMidias = new LinkedList<>();
        this.pessoa = new Pessoa();
        this.dataEmprestimo = new Date();
        this.dataDevolucao = new Date();
    }

    public int getIdEmpestimo() {
        return idEmpestimo;
    }

    public void setIdEmpestimo(int idEmpestimo) {
        this.idEmpestimo = idEmpestimo;
    }

    public List<Midia> getListaDeMidias() {
        return listaDeMidias;
    }

    public void setListaDeMidias(List<Midia> listaDeMidias) {
        this.listaDeMidias = listaDeMidias;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public void addMidia(Midia a){
        if(!this.listaDeMidias.contains(a)){
            this.listaDeMidias.add(a);
        }
    }
    
    public void removeMidia(Midia a){
        if(this.listaDeMidias.contains(a)){
            this.listaDeMidias.remove(a);
        }
    }
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.idEmpestimo;
        hash = 53 * hash + Objects.hashCode(this.listaDeMidias);
        hash = 53 * hash + Objects.hashCode(this.pessoa);
        hash = 53 * hash + Objects.hashCode(this.dataEmprestimo);
        hash = 53 * hash + Objects.hashCode(this.dataDevolucao);
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
        final Emprestimo other = (Emprestimo) obj;
        if (!Objects.equals(this.pessoa, other.pessoa)) {
            return false;
        }
        if (!Objects.equals(this.dataEmprestimo, other.dataEmprestimo)) {
            return false;
        }
        if (!Objects.equals(this.dataDevolucao, other.dataDevolucao)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  pessoa.getNome() ;
    }
    
    
    
    
}
