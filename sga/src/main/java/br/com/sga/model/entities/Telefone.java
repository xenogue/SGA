//package br.com.sga.model.entities;
//
//import java.io.Serializable;
//import java.util.List;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//import org.hibernate.annotations.ForeignKey;
//
///**
// *
// * @author rios
// */
//@Entity
//@Table(name="telefone")
//public class Telefone implements Serializable{
//
//    public Telefone() {
//        this.pessoa = pessoa;
//    }
//    
//    private static final long serialVersionUID = 1L;
//    
//    @Id
//    @GeneratedValue
//    @Column(name="idTelefone", nullable = false)
//    private Integer idTelefone;
//    
//    @Column(name="telefone", nullable = false)
//    private String telefone;
//    
//    @Column(name="tipoTelefone", nullable = false)
//    private String tipoTelefone;
//
//    @ManyToOne(optional = false, fetch = FetchType.LAZY)
//    @ForeignKey(name = "TelefonePessoa")
//    @JoinColumn(name = "idPessoa", referencedColumnName = "idPessoa")
//    private Pessoa pessoa;
//    
//    //    @ManyToOne(optional = false, fetch = FetchType.LAZY)
////    @ForeignKey(name = "EnderecoTipoendereco")
////    @JoinColumn(name = "idTipoEndereco", referencedColumnName = "idTipoEndereco")
////    private TipoEndereco tipoEndereco;
//  
//    public Integer getIdTelefone() {
//        return idTelefone;
//    }
//
//    public void setIdTelefone(Integer idTelefone) {
//        this.idTelefone = idTelefone;
//    }
//
//    public String getTelefone() {
//        return telefone;
//    }
//
//    public void setTelefone(String telefone) {
//        this.telefone = telefone;
//    }
//
//    public String getTipoTelefone() {
//        return tipoTelefone;
//    }
//
//    public void setTipoTelefone(String tipoTelefone) {
//        this.tipoTelefone = tipoTelefone;
//    }
//
//    public Pessoa getPessoa() {
//        return pessoa;
//    }
//
//    public void setPessoa(Pessoa pessoa) {
//        this.pessoa = pessoa;
//    }
//
//    @Override
//    public int hashCode() {
//        int hash = 3;
//        hash = 47 * hash + (this.idTelefone != null ? this.idTelefone.hashCode() : 0);
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
//        final Telefone other = (Telefone) obj;
//        if (this.idTelefone != other.idTelefone && (this.idTelefone == null || !this.idTelefone.equals(other.idTelefone))) {
//            return false;
//        }
//        return true;
//    }
//    
//    
//    
//}
