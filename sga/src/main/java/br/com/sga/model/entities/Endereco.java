package br.com.sga.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author rios
 */
@Entity
@Table(name = "endereco")
public class Endereco {
   
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column(name = "idEndereco", nullable = false)
    private Integer idEndereco;
    @Column(name = "OM")
    private String OM;
//    @Column(name = "cep")
//    private String cep;
//    @Column(name = "complemento")
//    private String complemento;
//    @Column(name = "nomeLogradouro")
//    private String nomeLogradouro;
//    @Column(name = "numero")
//    private String numero;
    
    //optional = Pode cadastrar uma pessoa sem endereço
    @OneToOne(optional = true, fetch = FetchType.LAZY)
    @ForeignKey(name = "EnderecoPessoa")
    @JoinColumn(name = "idPessoa", referencedColumnName = "idPessoa")
    private Pessoa pessoa;
    
//    @ManyToOne(optional = false, fetch = FetchType.LAZY)
//    @ForeignKey(name = "EnderecoTipoLogradouro")
//    @JoinColumn(name = "idTipoLogradouro", referencedColumnName = "idTipoLogradouro")
//    private TipoLogradouro tipoLogradouro;
//    
//    @ManyToOne(optional = false, fetch = FetchType.LAZY)
//    @ForeignKey(name = "EnderecoTipoendereco")
//    @JoinColumn(name = "idTipoEndereco", referencedColumnName = "idTipoEndereco")
//    private TipoEndereco tipoEndereco;
//    
//    @ManyToOne(optional = false, fetch = FetchType.LAZY)
//    @ForeignKey(name = "EnderecoEstado")
//    @JoinColumn(name = "idEstado", referencedColumnName = "idEstado")
//    private Estado estado;
//    
//    @ManyToOne(optional = false, fetch = FetchType.LAZY)
//    @ForeignKey(name = "EnderecoCidade")
//    @JoinColumn(name = "idCidade", referencedColumnName = "idCidade")
//    private Cidade cidade;

    public Endereco() {
//        this.cidade = new Cidade();
//        this.estado = new Estado();
//        this.tipoLogradouro = new TipoLogradouro();
//        this.tipoEndereco = new TipoEndereco();
        this.pessoa = new Pessoa();
    }

    public Integer getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }


    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getOM() {
        return OM;
    }

    public void setOM(String OM) {
        this.OM = OM;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + (this.idEndereco != null ? this.idEndereco.hashCode() : 0);
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
        final Endereco other = (Endereco) obj;
        if (this.idEndereco != other.idEndereco && (this.idEndereco == null || !this.idEndereco.equals(other.idEndereco))) {
            return false;
        }
        return true;
    }
    
    
}
