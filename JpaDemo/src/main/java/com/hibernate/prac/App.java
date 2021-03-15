package com.hibernate.prac;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class App 
{
	private static EntityManagerFactory ENTITY_MANAGER_FACTORY = 
			Persistence.createEntityManagerFactory("prac");
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );
        
    	addCustomer(1, "vlad", "kravets");
    	addCustomer(2, "adam", "smith");
    	addCustomer(3, "leo", "messi");
    	addCustomer(4, "john", "doe");
    	getCustomer(1);
    	getCustomers();
    	changeFName(4, "Mark");
    	deleteCustomer(3);
    	
        
            
        
        ENTITY_MANAGER_FACTORY.close();
    }
    
    
    public static void addCustomer(int id, String fname, String lname)
    {	EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
    	EntityTransaction et = null;
    	
    	try {
    		et = em.getTransaction();
    		
    		et.begin();
    		
    		Customer customer1 = new Customer();
    		customer1.setId(id);
    		customer1.setFirstName(fname);
    		customer1.setLastName(lname);
    		
    		em.persist(customer1);
    		et.commit();
    	}
    	catch(Exception e) {
    		if(et != null) {
    			et.rollback();
    		}
    		e.printStackTrace();
    	}
    	finally {
    		em.close();
    	}
    	
    	
    }
    
    
    public static void getCustomer(int id) 
    {
    	EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
    	String query = "SELECT c FROM Customer c WHERE c.id = :custID";
    	TypedQuery<Customer> tq = em.createQuery(query, Customer.class);
    	tq.setParameter("custID", id);
    	
    	Customer customer1 = null;
    	
    	try {
    		customer1 = tq.getSingleResult();
    		System.out.println(customer1);
    		
    	}
    	catch(NoResultException e) {
    		e.printStackTrace();
    	}
    	finally {
    		em.close();
    	}
    }
    
    public static void getCustomers() {
    	EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
    	String query = "SELECT c FROM Customer c WHERE c.id IS NOT NULL";
    	TypedQuery<Customer> tq = em.createQuery(query, Customer.class);
    	
    	List<Customer> customers;
    	
    	try {
    		customers = tq.getResultList();
    		customers.forEach(customer->System.out.println(customer));
    	}
    	catch(NoResultException e) {
    		e.printStackTrace();
    	}
    	finally {
    		em.close();
    	}
    }
    
    public static void changeFName(int id, String fname)
    {	EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
    	EntityTransaction et = null;
    	Customer customer1 = null;
    	
    	try {
    		et = em.getTransaction();
    		
    		et.begin();
    		
    		customer1 = em.find(Customer.class, id);
    		customer1.setFirstName(fname);
    		
    		em.persist(customer1);
    		et.commit();
    	}
    	catch(Exception e) {
    		if(et != null) {
    			et.rollback();
    		}
    		e.printStackTrace();
    	}
    	finally {
    		em.close();
    	}
    	
    	
    }
    
    
    
    public static void deleteCustomer(int id)
    {	EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
    	EntityTransaction et = null;
    	Customer customer1 = null;
    	
    	try {
    		et = em.getTransaction();
    		
    		et.begin();
    		
    		customer1 = em.find(Customer.class, id);
    		em.remove(customer1);
    		
    		em.persist(customer1);
    		et.commit();
    	}
    	catch(Exception e) {
    		if(et != null) {
    			et.rollback();
    		}
    		e.printStackTrace();
    	}
    	finally {
    		em.close();
    	}
    	
    	
    }
    
    
    
    
    
    
    
    
}
