package br.com.sga.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


/**
 *
 * @author rios
 */
public class HibernateUtil {

    public static final SessionFactory sessionFactory;
    public static final String HIBERNATE_SESSION = "hibernate_session";
    
    static {
            try { 
            System.out.println("Inicializando a SF");
            Configuration configuration = new Configuration().configure();
            ServiceRegistry serviceRegister = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            sessionFactory = configuration.buildSessionFactory(serviceRegister);
            System.out.println("SF Criada");
    } catch(Exception e) {
        System.out.println("Erro ao iniciar a SF"+e);
        throw new ExceptionInInitializerError(e);
    }
             
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
