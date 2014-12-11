package br.com.sga.support;

import br.com.sga.model.dao.HibernateDAO;
import br.com.sga.model.dao.InterfaceDAO;
import br.com.sga.model.entities.Papel;
import br.com.sga.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author rios
 */
@ManagedBean(name = "bbPapel")
@RequestScoped
public class BbPapel implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    public List<Papel> getPapeis(){
        InterfaceDAO<Papel> papelDAO = new HibernateDAO<Papel>(Papel.class,FacesContextUtil.getRequestSession());
        return papelDAO.getEntities();
    }
    
    
}
