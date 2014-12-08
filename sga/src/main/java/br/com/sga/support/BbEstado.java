//package br.com.sga.support;
//
//import br.com.sga.model.dao.HibernateDAO;
//import br.com.sga.model.dao.InterfaceDAO;
//import br.com.sga.model.entities.Estado;
//import br.com.sga.util.FacesContextUtil;
//import java.io.Serializable;
//import java.util.List;
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.RequestScoped;
//
//@ManagedBean(name="bbEstado")
//@RequestScoped
//public class BbEstado  implements Serializable {
//    
//    private static final long serialVersionUID = 1L;
//
//    public List<Estado> getEstados() {
//        InterfaceDAO<Estado> estadoDAO = new HibernateDAO<Estado>(Estado.class, FacesContextUtil.getRequestSession());
//        return estadoDAO.getEntities();
//    }	
//}