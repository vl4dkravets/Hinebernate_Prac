package org.hibernate.Persistance_Lifecycle;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	// Creating & getting the session
    	SessionFactory sf  = HibernateSessionFactoryUtil.getSessionFactory(); 
    	Session session1 = sf.openSession();
    	
    	/**
    	 * There are 4 states in Hibernate Persistance lifecycle:
    	 *  - transient
    	 *  - persistent
    	 *  - detached
    	 *  - removed
    	 */
    	
    	session1.beginTransaction();
    	
    	// transient state
    	Laptop laptop1 = new Laptop(52, "Mac", 1300);
    	
    	// persistent state
    	session1.save(laptop1);
    	
    	// Since laptop1 now is in persistent state, any new changes
    	// will effect both the original object & its entity stored in DB
    	laptop1.setPrice(1890);  	
    	
    	session1.getTransaction().commit();
    	
    	
    	// detached state - it's similar to committed data
    	// Meaning, anything happened after commit will be in detached state, & thus
    	// having no effect on entities in DB
    	session1.detach(laptop1);
    	laptop1.setPrice(1500);
    }
}
