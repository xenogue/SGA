package br.com.sga.controller;

import br.com.sga.conversores.ConverterSHA1;
import br.com.sga.model.dao.HibernateDAO;
import br.com.sga.model.dao.InterfaceDAO;
import br.com.sga.model.entities.Endereco;
import br.com.sga.model.entities.Pessoa;
import br.com.sga.util.FacesContextUtil;
import java.io.Serializable;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;

/**
 *
 * @author rios
 */
@ManagedBean
@SessionScoped  //A página será mudada
public class MbPessoa implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String confereSenha;
    private Pessoa pessoa = new Pessoa();
    private Endereco endereco = new Endereco();
    private List<Pessoa> pessoas;
    private List<Endereco> enderecos;
 
    public MbPessoa() {
    }
    
    private InterfaceDAO<Pessoa> pessoaDAO(){
        InterfaceDAO<Pessoa> pessoaDAO = new HibernateDAO<Pessoa>(Pessoa.class, FacesContextUtil.getRequestSession());
        return pessoaDAO;
    }
    
    private InterfaceDAO<Endereco> enderecoDAO(){
        InterfaceDAO<Endereco> enderecoDAO = new HibernateDAO<Endereco>(Endereco.class, FacesContextUtil.getRequestSession());
        return enderecoDAO;
    }
    
    public String limpPessoa(){
        pessoa = new Pessoa();
        endereco = new Endereco();
        return editPessoa();
    }
    
    public String editPessoa(){
        return "/restrict/cadastrarpessoa.faces";
    }
    
    public String addPessoa(){
        Date date = new Date();
        pessoa.setDataCadastro(date);
        if(pessoa.getIdPessoa() == null || pessoa.getIdPessoa() == 0 ) {
            
            insertPessoa();
        } else {
            updatePessoa();
        }
        return null;
    }

    private void insertPessoa() {
        if (comparaSenha() && comparaLogin())
        {
            //insereTelefones();
            pessoaDAO().save(pessoa);
            endereco.setPessoa(pessoa);
            enderecoDAO().save(endereco);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Gravação efetuada com sucesso", ""));
        }
    }

    private void updatePessoa() {
        pessoaDAO().update(pessoa);
        enderecoDAO().save(endereco);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualização efetuada com sucesso", ""));
    }
    
    public void deletePessoa(){
        pessoaDAO().remove(pessoa);
        enderecoDAO().remove(endereco);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Pessoa excluída com sucesso", ""));
    }

    public List<Pessoa> getPessoas() {
        pessoas = pessoaDAO().getEntities();
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public List<Endereco> getEnderecos() {
        enderecos = enderecoDAO().getEntities();
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getConfereSenha() {
        return confereSenha;
    }

    public void setConfereSenha(String confereSenha) {
        this.confereSenha = confereSenha;
    }

    private boolean comparaSenha() {
        pessoa.setSenha(ConverterSHA1.cipher(pessoa.getSenha()));
        if (pessoa.getSenha() == null ? confereSenha == null : pessoa.getSenha().equals(ConverterSHA1.cipher(confereSenha))) {
            pessoa.setPermissao("ROLE_USER");
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "As senhas não conferem.", ""));
            return false;
        }
        return true;
    }
    
    private boolean comparaLogin(){
        DetachedCriteria criteriacriteria = DetachedCriteria.forClass(Pessoa.class).add( Property.forName("login").eq(pessoa.getLogin()) );
        pessoas = pessoaDAO().getListByDetachedCriteria(criteriacriteria);
        if(pessoas.size() != 0){
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Login já cadastrado no sistema, favor alterá-lo.", ""));
            return false;
        }
            
        return true;
    }    
   
}

//    private void insereTelefones() {
//        if(telefonePessoal != null) {
//            telefonePessoal.setPessoa(pessoa);
//            telefonePessoal.setTipoTelefone("pessoal");
//            telefones.add(telefonePessoal);
//        }
//        if(telefoneSecao != null) {
//            telefoneSecao.setPessoa(pessoa);
//            telefoneSecao.setTipoTelefone("trabalho");
//            telefones.add(telefoneSecao);
//        }
//        
//    }