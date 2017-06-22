package gestion_projets.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
public class HibernateUtil {
    
    private static SessionFactory sessionFactory=buildSessionFactory();
    private static ServiceRegistry serviceRegistry;
    private static Session session=null;

    
    //création objet sessionfactory
	private static SessionFactory buildSessionFactory() {
    	
        try {
            Configuration configuration = new Configuration();
            configuration.configure("config/hibernate.cfg.xml");
            serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                    configuration.getProperties()).build();
            sessionFactory=configuration.buildSessionFactory(serviceRegistry);
            
           return sessionFactory;
            }catch (Throwable ex) {
            System.err.println("failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        
    }

    //Méthodes utils-------
    
    
    
    public static SessionFactory getSessionFactory() {
    	
        return sessionFactory;
        
    }
    
    public static Session openSession(){
    	return sessionFactory.openSession();
    }
    
	public static Session  getCurrentSession(){
		
		
		return  sessionFactory.getCurrentSession();
	}
	

	    public static void close(){
	    	
	    	
	    	if(sessionFactory !=null){
	    		sessionFactory.close();
	    	}
	    	sessionFactory=null;
	    }
	}
