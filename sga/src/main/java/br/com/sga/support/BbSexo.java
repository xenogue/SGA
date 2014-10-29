package br.com.sga.support;

import br.com.sga.model.dao.HibernateDAO;
import br.com.sga.model.dao.InterfaceDAO;
import br.com.sga.model.entities.Sexo;
import br.com.sga.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author rios
 */
@ManagedBean(name = "bbSexo")
@RequestScoped
public class BbSexo implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    public List<Sexo> getSexos(){
        InterfaceDAO<Sexo> sexoDAO = new HibernateDAO<Sexo>(Sexo.class,FacesContextUtil.getRequestSession());
        return sexoDAO.getEntities();
    }
    
    
}
