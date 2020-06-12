
package br.com.foursys.vendas.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * @author's: Equipe 4 "Diego, we have a problem!"
 */
public class HibernateUtil {
   
    
    private static final SessionFactory sessionFactory = buildSessionFactory();
    
    private static SessionFactory buildSessionFactory(){
        
        return new AnnotationConfiguration().configure().buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    
    
    
}
