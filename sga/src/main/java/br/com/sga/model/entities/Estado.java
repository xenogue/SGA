//package br.com.sga.model.entities;
//
//import java.io.Serializable;
//import java.util.List;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//import org.hibernate.annotations.ForeignKey;
//
///**
// *
// * @author rios
// */
//@Entity
//@Table(name="estado")
//public class Estado implements Serializable{
//    
//    private static final long serialVersionUID = 1L;
//    
//    @Id
//    @GeneratedValue
//    @Column(name = "idEstado", nullable = false)
//    private Integer idEstado;
//    @Column(name = "descricao",nullable = false)
//    private String descricao;
//
//    @OneToMany(mappedBy = "estado", fetch = FetchType.LAZY)
//    @ForeignKey(name = "EstadoEndereco")
//    private List<Endereco> enderecos;
//    
//    public Estado() {
//    }
//
//    public Integer getIdEstado() {
//        return idEstado;
//    }
//
//    public void setIdEstado(Integer idEstado) {
//        this.idEstado = idEstado;
//    }
//
//    public String getDescricao() {
//        return descricao;
//    }
//
//    public void setDescricao(String descricao) {
//        this.descricao = descricao;
//    }
//
//    @Override
//    public int hashCode() {
//        int hash = 3;
//        hash = 83 * hash + (this.idEstado != null ? this.idEstado.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final Estado other = (Estado) obj;
//        if (this.idEstado != other.idEstado && (this.idEstado == null || !this.idEstado.equals(other.idEstado))) {
//            return false;
//        }
//        return true;
//    }
//
//    
//}
