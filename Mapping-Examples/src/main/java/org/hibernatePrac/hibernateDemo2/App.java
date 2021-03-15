package org.hibernatePrac.hibernateDemo2;

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
    	Laptop laptop1 = new Laptop();
    	laptop1.setLid(101);
    	laptop1.setName("Dell");
    	
    	Laptop laptop2 = new Laptop();
    	laptop2.setLid(102);
    	laptop2.setName("HP");
    	
    	Student student1 = new Student();
    	student1.setName("Vlad");
    	student1.setRollno(1);
    	student1.setMarks(82);
    	
    	Student student2 = new Student();
    	student2.setName("Adam");
    	student2.setRollno(2);
    	student2.setMarks(97);
    	//student1.setLaptop(laptop1);
    	
    	// Filling laptop1 with students
    	laptop1.getStudents().add(student1);
    	laptop1.getStudents().add(student2);
    	
    	// Filling laptop2 with students
    	laptop2.getStudents().add(student1);
    	laptop2.getStudents().add(student2);
    	
    	// Filling student1 with laptops
    	student1.getLaptops().add(laptop1);
    	student1.getLaptops().add(laptop2);
    	
    	// Filling student2 with laptops
    	student2.getLaptops().add(laptop2);
    	student2.getLaptops().add(laptop1);
  	
    	// Creating & getting the session
    	Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession(); 
    	
    	// Performing a transaction
    	Transaction transac = session.beginTransaction();
    	
    	session.save(laptop1);
    	session.save(laptop2);
    	session.save(student1);
    	session.save(student2);
    	
    	transac.commit();
    
    	
    	
    }
}
