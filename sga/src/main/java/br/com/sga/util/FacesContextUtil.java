package br.com.sga.util;

import javax.faces.context.FacesContext;
import org.hibernate.Session;
/**
 *
 * @author rios
 */
public class FacesContextUtil {

    private static final String HIBERNATE_SESSION = "hibernate_session"; 

    public static void serRequestSession(Session session){
        FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put(HIBERNATE_SESSION,session);
        
    }
    public static String getHIBERNATE_SESSION() {
        return HIBERNATE_SESSION;
    }
    
    
}
