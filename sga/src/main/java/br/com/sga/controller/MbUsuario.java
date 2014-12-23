package br.com.sga.controller;

import br.com.sga.conversores.ConverterSHA1;
import br.com.sga.model.dao.HibernateDAO;
import br.com.sga.model.dao.InterfaceDAO;
import br.com.sga.model.entities.Papel;
import br.com.sga.model.entities.Usuario;
import br.com.sga.util.FacesContextUtil;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
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
public class MbUsuario implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String confereSenha;
    
//    @ManagedProperty(value = "#{pessoaMB}")
//    private MbPessoa pessoaMB;

//    private Pessoa pessoa = new Pessoa();
    private Usuario usuario;
    private List<Usuario> usuarios;
    private List<String> sexos;
    private EnumPapel papel;
    
    public MbUsuario() {
    }
    
    private InterfaceDAO<Usuario> usuarioDAO(){
        InterfaceDAO<Usuario> usuarioDAO = new HibernateDAO<Usuario>(Usuario.class, FacesContextUtil.getRequestSession());
        return usuarioDAO;
    }
    
    public String limpUsuario(){
        usuario = new Usuario();
        return editUsuario();
    }
    
    public String editUsuario(){
        return "/paginas/cadastrarusuario.faces";
    }
    
    public String addUsuario(){
        if(usuario.getIdUsuario() == null || usuario.getIdUsuario() == 0 ) {
            Date date = new Date();
            usuario.setDataCadastro(date);
            insertUsuario();
        } else {
            updateUsuario();
        }
        return null;
    }

    private String insertUsuario() {
        boolean alteraLogin = false;
        if (comparaSenha() && comparaLogin(alteraLogin))
        {
            usuarioDAO().save(usuario);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Gravação efetuada com sucesso", ""));
            return "/restrict/cadastrarusuario.faces";
        }
        return null;
    }

    private String updateUsuario() {
        boolean alteraLogin = true;
        if (comparaSenha() && comparaLogin(alteraLogin))
        {
            usuarioDAO().merge(usuario);
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Atualização efetuada com sucesso", ""));
            return "/restrict/consultarusuario.faces";
        }
        return null;
    }
    
    public String deleteUsuario() {
        usuarioDAO().remove(usuario);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário excluído com sucesso", ""));
        return "/restrict/consultarusuario.faces";

    }

//    public void setPessoaMB(MbPessoa pessoaMB) {
//        this.pessoaMB = pessoaMB;
//    }

    public List<Usuario> getUsuarios() {
        if(usuarios == null) {
            usuarios = usuarioDAO().getEntities();
        }
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Usuario getUsuario() {
        if(usuario == null){
            usuario = new Usuario();
        }

        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getConfereSenha() {
        return confereSenha;
    }

    public void setConfereSenha(String confereSenha) {
        this.confereSenha = confereSenha;
    }

    private boolean comparaSenha() {
        usuario.setSenha(ConverterSHA1.cipher(usuario.getSenha()));
        if (usuario.getSenha() == null ? confereSenha == null : usuario.getSenha().equals(ConverterSHA1.cipher(confereSenha))) {
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
        DetachedCriteria criteriacriteria = DetachedCriteria.forClass(Usuario.class).add( Property.forName("login").eq(usuario.getLogin()) );
        List<Usuario> usuariosLogin = usuarioDAO().getListByDetachedCriteria(criteriacriteria);
        if(usuariosLogin.size() != 0){
            if(alteracaoLogin == true) {
                Usuario p = usuariosLogin.get(0);
                boolean loginEncontrado = p.equals(usuario);
                if(loginEncontrado == false){
                    FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Login já cadastrado no sistema, favor alterá-lo.", ""));
                    return false;
                } else{
                    return true;
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
        return usuario.isAdm() && usuario.isRH();
    }  //rendered="#{relatorioMB.usuarioPodeVerSalario}”

   
}
