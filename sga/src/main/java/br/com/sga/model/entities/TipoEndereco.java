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
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author rios
 */
@Entity
@Table(name = "tipoEndereco")
public class TipoEndereco implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column(name = "idTipoEndereco", nullable = false)
    private Integer idTipoEndereco;
    @Column(name = "descricao", nullable = false)
    private String descricao;

    @OneToMany(mappedBy = "tipoEndereco", fetch = FetchType.LAZY)
    @ForeignKey(name = "TipoEnderecoEndereco")
    private List<Endereco> enderecos;
    
    public TipoEndereco() {
    }

    public Integer getIdTipoEndereco() {
        return idTipoEndereco;
    }

    public void setIdTipoEndereco(Integer idTipoEndereco) {
        this.idTipoEndereco = idTipoEndereco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + (this.idTipoEndereco != null ? this.idTipoEndereco.hashCode() : 0);
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
        final TipoEndereco other = (TipoEndereco) obj;
        if (this.idTipoEndereco != other.idTipoEndereco && (this.idTipoEndereco == null || !this.idTipoEndereco.equals(other.idTipoEndereco))) {
            return false;
        }
        return true;
    }
    
    
    
}
