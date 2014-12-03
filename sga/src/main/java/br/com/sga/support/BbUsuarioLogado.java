package br.com.sga.support;

import br.com.sga.model.entities.Pessoa;
import br.com.sga.util.FacesContextUtil;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.hibernate.Query;

import org.hibernate.Session;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

/**
 *
 * @author rios
 */
@ManagedBean (name = "bbUsuarioLogado")
@SessionScoped  //Toda a aplicação
public class BbUsuarioLogado implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private Pessoa usuario;

    public BbUsuarioLogado() {
        usuario = new Pessoa();
        SecurityContext context = SecurityContextHolder.getContext();
        if(context instanceof SecurityContext) 
        {
            Authentication auth = context.getAuthentication();
            if(auth instanceof Authentication) 
            {
                usuario.setLogin(((User)auth.getPrincipal()).getUsername());
            }
        }
    }
    
    public Pessoa procuraPessoa(){
        String login = getLoginUsuarioLogado();
        Session session = FacesContextUtil.getRequestSession();
        Query query = session.createQuery("from Pessoa user where user.login like ? ");
        query.setString(0,login);
        return (Pessoa) query.uniqueResult();
    }

    private String getLoginUsuarioLogado() {
        return usuario.getLogin();
    }
    
    
        
}
