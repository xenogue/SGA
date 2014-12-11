package br.com.sga.controller;

import br.com.sga.conversores.ConverterSHA1;
import br.com.sga.model.dao.HibernateDAO;
import br.com.sga.model.dao.InterfaceDAO;
import br.com.sga.model.entities.Papel;
import br.com.sga.model.entities.Pessoa;
import br.com.sga.util.FacesContextUtil;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;

/**
 *
 * @author rios
 */

@ManagedBean
//@SessionScoped  //A página será mudada
@RequestScoped
public class MbPessoa implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String confereSenha;
    
//    @ManagedProperty(value = "#{pessoaMB}")
//    private MbPessoa pessoaMB;

//    private Pessoa pessoa = new Pessoa();
    private Pessoa pessoa;
    private List<Pessoa> pessoas;
    private List<String> sexos;
    private EnumPapel papel;
    
    public MbPessoa() {
    }
    
    private InterfaceDAO<Pessoa> pessoaDAO(){
        InterfaceDAO<Pessoa> pessoaDAO = new HibernateDAO<Pessoa>(Pessoa.class, FacesContextUtil.getRequestSession());
        return pessoaDAO;
    }
    
    public String limpPessoa(){
        pessoa = new Pessoa();
        return editPessoa();
    }
    
    public String editPessoa(){
        return "/restrict/cadastrarpessoa.faces";
    }
    
    public String addPessoa(){
        if(pessoa.getIdPessoa() == null || pessoa.getIdPessoa() == 0 ) {
            Date date = new Date();
            pessoa.setDataCadastro(date);
            insertPessoa();
        } else {
            updatePessoa();
        }
        return null;
    }

    private String insertPessoa() {
        boolean alteraLogin = false;
        if (comparaSenha() && comparaLogin(alteraLogin))
        {
            pessoaDAO().save(pessoa);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Gravação efetuada com sucesso", ""));
            return "/restrict/cadastrarpessoa.faces";
        }
        return null;
    }

    private String updatePessoa() {
        boolean alteraLogin = true;
        if (comparaSenha() && comparaLogin(alteraLogin))
        {
            pessoaDAO().merge(pessoa);
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualização efetuada com sucesso", ""));
            return "/restrict/consultarpessoas.faces";
        }
        return null;
    }
    
    public String deletePessoa() {
        pessoaDAO().remove(pessoa);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Pessoa excluída com sucesso", ""));
        return "/restrict/consultarpessoas.faces";

    }

//    public void setPessoaMB(MbPessoa pessoaMB) {
//        this.pessoaMB = pessoaMB;
//    }

    public List<Pessoa> getPessoas() {
        pessoas = pessoaDAO().getEntities();
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public Pessoa getPessoa() {
        if(pessoa == null){
            pessoa = new Pessoa();
        }

        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
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
            return true;
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "As senhas não conferem.", ""));
            return false;
        }
        
    }
    
//    public void retornaPerfilUsuarioLogado() {
//        pessoaMB.get
//    }
    
    private boolean comparaLogin(boolean alteracaoLogin){
        DetachedCriteria criteriacriteria = DetachedCriteria.forClass(Pessoa.class).add( Property.forName("login").eq(pessoa.getLogin()) );
        pessoas = pessoaDAO().getListByDetachedCriteria(criteriacriteria);
        if(pessoas.size() != 0){
            if(alteracaoLogin == true) {
                Pessoa p = pessoas.get(0);
                boolean loginExiste = p.equals(pessoa);
                if(loginExiste == true){
                    FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Login já cadastrado no sistema, favor alterá-lo.", ""));
                    return false;
                }
            }
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Login já cadastrado no sistema, favor alterá-lo.", ""));
            return false;
        }
            
        return true;
    }    
    
    public boolean isAdm() {
        return EnumPapel.ADM.equals(papel);
    }
    public boolean isGerente() {
        return EnumPapel.GERENTE.equals(papel);
    }
    public boolean isUsuarioSimples() {
        return EnumPapel.USUARIO_SIMPLES.equals(papel);
    }
    public boolean isUsuarioPodeVerSalario(){
        return pessoa.isAdm() && pessoa.isRH();
    }  //rendered="#{relatorioMB.usuarioPodeVerSalario}”

   
}
