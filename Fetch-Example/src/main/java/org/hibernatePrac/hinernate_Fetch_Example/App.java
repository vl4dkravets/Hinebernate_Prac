package org.hibernatePrac.hinernate_Fetch_Example;

import java.util.ArrayList;
import java.util.Arrays;

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
    	Session session1 = HibernateSessionFactoryUtil.getSessionFactory().openSession();
    	
    	
    	//Data insertion
    	Laptop laptop1 = new Laptop();
    	laptop1.setBrand("Lenovo");
    	laptop1.setLid(101);
    	laptop1.setPrice(500);
    	
    	Laptop laptop2 = new Laptop();
    	laptop2.setBrand("Apple");
    	laptop2.setLid(103);
    	laptop2.setPrice(900);    	
    	
    	Alien alien1 = new Alien();
    	alien1.setAid(2);
    	alien1.setAname("Vasya");
    	
    	alien1.setLaptops(new ArrayList<Laptop>(Arrays.asList(laptop1, laptop2)));
    	
    	laptop1.setAlien(alien1);
    	laptop2.setAlien(alien1);
    	
//    	session1.beginTransaction();
//    	
//    	session1.save(alien1);
//    	session1.save(laptop1);
//    	session1.save(laptop2);
//    	
//    	session1.getTransaction().commit();
    	
    	
    	session1.beginTransaction();
    	
    	Alien alien2 = session1.get(Alien.class,2);
    	
    	session1.getTransaction().commit();
    	
    	System.out.println(alien2);
    }
}
