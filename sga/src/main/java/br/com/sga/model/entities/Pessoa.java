package br.com.sga.model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
    @Column(name="nome", nullable = false, length = 80)
    private String nome;
    @Column(name="email", nullable = false, length = 80)
    private String email;
    @Column(name="cpf", nullable = false, length = 14)
    private String cpf;
    @Column(name="dataNascimento", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataNascimento;
    @Column(name="dataCadastro", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataCadastro;
    @Column(name="saram", nullable = false)
    private Integer saram;
    @Column(name="secao", nullable = false)
    private String secao;
    @Column(name="telefonePessoal", nullable = false)
    private String telefonePessoal;
    @Column(name="telefoneSecao", nullable = false)
    private String telefoneSecao;
    
    @Column(name="login", unique= true, nullable = false, length = 25)
    private String login;
    @Column(name="senha", nullable = false, length = 50)
    private String senha;
    @Column(name="permissao", nullable = true, length = 36)
    private String permissao;
//    @Column(name="role", unique= true, nullable = false, length = 25)
//    private String role;
    
    
    
    @OneToOne(mappedBy = "pessoa", fetch = FetchType.LAZY)
    @ForeignKey(name = "EnderecoPessoa")
    private Endereco endereco;
    
    @ManyToOne(optional = false)
    @ForeignKey(name = "PessoaSexo")
    @JoinColumn(name = "idSexo", referencedColumnName = "idSexo")
    private Sexo sexo;
    
//    @OneToMany(mappedBy = "telefone", fetch = FetchType.LAZY)
//    @ForeignKey(name = "PessoaTelefone")
//    private List<Telefone> telefones;
    
        
    public Pessoa() {
        this.sexo = new Sexo();
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

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
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

    public String getPermissao() {
        return permissao;
    }

    public void setPermissao(String permissao) {
        this.permissao = permissao;
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

    
//    public List<Telefone> getTelefones() {
//        return telefones;
//    }
//
//    public void setTelefones(List<Telefone> telefones) {
//        this.telefones = telefones;
//    }

    public String getSecao() {
        return secao;
    }

    public void setSecao(String secao) {
        this.secao = secao;
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
    
    
    
}
