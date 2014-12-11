package br.com.sga.model.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author rios
 */
@Entity
@Table(name="pessoa")
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Column(name="idPessoa", nullable = false)
    private Integer idPessoa;
    @Column(name="nome", nullable = true, length = 80)
    private String nome;
    @Column(name="email", nullable = true, length = 80)
    private String email;
    @Column(name="cpf", nullable = true, length = 14)
    private String cpf;
    @Column(name="dataNascimento", nullable = true)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataNascimento;
    @Column(name="dataCadastro", nullable = true)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataCadastro;
    @Column(name="saram", nullable = true)
    private Integer saram;
    @Column(name="secao", nullable = true)
    private String secao;
    @Column(name="telefonePessoal", nullable = true)
    private String telefonePessoal;
    @Column(name="telefoneSecao", nullable = true)
    private String telefoneSecao;
    
    @Column(name="login", unique= true, nullable = true, length = 25)
    private String login;
    @Column(name="senha", nullable = true, length = 50)
    private String senha;
    @Column(name="sexo", nullable = true, length = 9)
    private String sexo;
    @Column(name="OM", nullable = true, length = 100)
    private String OM;

    @ManyToOne(optional=false, fetch = FetchType.LAZY)
    @ForeignKey(name = "PessoaPapel") 
    @JoinColumn(name="idPapel", referencedColumnName = "idPapel")
    private Papel papel;
    
    public Pessoa() {
    }

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getSaram() {
        return saram;
    }

    public void setSaram(Integer saram) {
        this.saram = saram;
    }

    public String getTelefonePessoal() {
        return telefonePessoal;
    }

    public void setTelefonePessoal(String telefonePessoal) {
        this.telefonePessoal = telefonePessoal;
    }

    public String getTelefoneSecao() {
        return telefoneSecao;
    }

    public void setTelefoneSecao(String telefoneSecao) {
        this.telefoneSecao = telefoneSecao;
    }

    public String getSecao() {
        return secao;
    }

    public void setSecao(String secao) {
        this.secao = secao;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getOM() {
        return OM;
    }

    public void setOM(String OM) {
        this.OM = OM;
    }

    public Papel getPapel() {
        if (papel == null) {
            papel = new Papel();
        }
        return papel;
    }

    public void setPapel(Papel papel) {
        this.papel = papel;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + (this.idPessoa != null ? this.idPessoa.hashCode() : 0);
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
        final Pessoa other = (Pessoa) obj;
        if (this.idPessoa != other.idPessoa && (this.idPessoa == null || !this.idPessoa.equals(other.idPessoa))) {
            return false;
        }
        return true;
    }

    public boolean isAdm() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean isRH() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
