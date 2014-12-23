package br.com.sga.model.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author rios
 */
@Entity
@Table(name = "ano")
public class Ano  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idAno", nullable = false)
    private Integer idAno;
    @Column(name="ano", nullable = false, length = 4)
    private Integer ano;
    
//    @ManyToMany(cascade = {CascadeType.ALL})
//    @JoinTable(name="EMPLOYEE_MEETING",
//                joinColumns={@JoinColumn(name="EMPLOYEE_ID")},
//                inverseJoinColumns={@JoinColumn(name="MEETING_ID")})
//private Set<Meeting> meetings = new HashSet<Meeting>();
    
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "alteracao_ano",
            joinColumns = @JoinColumn(name = "idAno"),
            inverseJoinColumns = @JoinColumn(name = "idAlteracao"))
    private Set<Alteracao> alteracoes = new HashSet<Alteracao>();

    public Integer getIdAno() {
        return idAno;
    }

    public void setIdAno(Integer idAno) {
        this.idAno = idAno;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Set<Alteracao> getAlteracoes() {
        return alteracoes;
    }

    public void setAlteracoes(Set<Alteracao> alteracoes) {
        this.alteracoes = alteracoes;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + (this.idAno != null ? this.idAno.hashCode() : 0);
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
        final Ano other = (Ano) obj;
        if (this.idAno != other.idAno && (this.idAno == null || !this.idAno.equals(other.idAno))) {
            return false;
        }
        return true;
    }
    
    
    
}
