package org.hibernatePrac.hibernate_Caching;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class App 
{
    public static void main( String[] args )
    {
    	Alien alien3 = null;
           
    	// Creating & getting the session
    	SessionFactory sf  = HibernateSessionFactoryUtil.getSessionFactory(); 
    	Session session1 = sf.openSession();

    	/**
    	 * Caching Level 1
    	 * Hibernate performs only 1 retrieval operations instead of 2 within 1 session
    	 */
        
    	// Performing a transaction
    	session1.beginTransaction();
    	Query<Alien> query1 = session1.createQuery("from Alien where aid=1");
    	query1.setCacheable(true);
    	
    	//alien3 = (Alien) session1.get(Alien.class, 1);
    	
    	alien3 = query1.uniqueResult();
    	
    	System.out.println(alien3);
    	
    	session1.getTransaction().commit();
    	
    	session1.close();
    	
    	
    	// Session #2
    	
    	/**
    	 * Caching Level 2
    	 * Hibernate performs only 1 call for similar retrieval operations; applicable for several sessions
    	 */
    	
    	Session session2 = sf.openSession();
    	
    	session2.beginTransaction();
    	
    	//alien3 = (Alien) session2.get(Alien.class, 1);
    	
    	Query<Alien> query2 = session2.createQuery("from Alien where aid=1");
    	query2.setCacheable(true);
    	alien3 = query2.uniqueResult();
    	
    	System.out.println(alien3);
    	    	
    	session2.getTransaction().commit();
    	
    	
    	
    	session2.close();
    	
    	
    	
    	
    }
}
