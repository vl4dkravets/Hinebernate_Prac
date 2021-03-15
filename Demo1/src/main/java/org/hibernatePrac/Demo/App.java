package org.hibernatePrac.Demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );
    	
//    	Alien alien1 = new Alien();
//    	alien1.setId(1);
//    	alien1.setName("Vlad");
//    	alien1.setColor("red");
    	
    	AlienName name = new AlienName();
    	name.setFirstName("Vlad");
    	name.setLastName("Kravets");
    	name.setMiddleNamel(null);
    	
    	Alien alien1 = new Alien();
    	alien1.setId(5);
    	alien1.setName(name);
    	alien1.setColor("yellow");
    	
    	Configuration config = new Configuration().configure("hibernate.cfg.xml");
    	config.addAnnotatedClass(Alien.class);
    	ServiceRegistry serviceReg = new StandardServiceRegistryBuilder().applySettings(config.getProperties())
    							.build();
    	
    	SessionFactory sf = config.buildSessionFactory(serviceReg); 
    	Session session = sf.openSession(); 
    	
    	Transaction transac = session.beginTransaction();
    	
    	// to save object
    	session.save(alien1);
    	
    	// to retrieve/select data from DB
    	Alien alien2 = null;
    	alien2 = (Alien) session.get(Alien.class, 5);
    	System.out.println(alien2);
    	
    	transac.commit();
    	
    
    }
}
