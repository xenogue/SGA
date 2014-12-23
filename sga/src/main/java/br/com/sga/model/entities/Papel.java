package br.com.sga.model.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
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
@Table(name="papel")
public class Papel implements Serializable{

    public Papel() {
    }
        
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column(name="idPapel", nullable = false)
    private Integer idPapel;
    @Column(name="papel", unique = true, nullable = false, length = 20)
    private String papel;
    
    @OneToMany(mappedBy = "papel", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @ForeignKey(name = "UsuarioPapel")
    private List<Usuario> usuarios;

    public Integer getIdPapel() {
        return idPapel;
    }

    public void setIdPapel(Integer idPapel) {
        this.idPapel = idPapel;
    }

    public String getPapel() {
        return papel;
    }

    public void setPapel(String papel) {
        this.papel = papel;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (this.idPapel != null ? this.idPapel.hashCode() : 0);
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
        final Papel other = (Papel) obj;
        if (this.idPapel != other.idPapel && (this.idPapel == null || !this.idPapel.equals(other.idPapel))) {
            return false;
        }
        return true;
    }
}
