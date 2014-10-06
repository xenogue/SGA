package br.com.sga.model.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author rios
 */
@Entity
@Table(name = "tipoLogradouro")
public class TipoLogradouro implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column(name = "idTipoLogradouro", nullable = false)
    private Integer idTipoLogradouro;
    @Column(name = "descricao", nullable = false)
    private String descricao;

    @OneToMany(mappedBy = "tipoLogradouro", fetch = FetchType.LAZY)
    @ForeignKey(name = "LogradouroEndereco")
    private List<Endereco> logradouros;
    
    public TipoLogradouro() {
    }

    public Integer getIdTipoLogradouro() {
        return idTipoLogradouro;
    }

    public void setIdTipoLogradouro(Integer idTipoLogradouro) {
        this.idTipoLogradouro = idTipoLogradouro;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + (this.idTipoLogradouro != null ? this.idTipoLogradouro.hashCode() : 0);
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
        final TipoLogradouro other = (TipoLogradouro) obj;
        if (this.idTipoLogradouro != other.idTipoLogradouro && (this.idTipoLogradouro == null || !this.idTipoLogradouro.equals(other.idTipoLogradouro))) {
            return false;
        }
        return true;
    }
    
    
}

