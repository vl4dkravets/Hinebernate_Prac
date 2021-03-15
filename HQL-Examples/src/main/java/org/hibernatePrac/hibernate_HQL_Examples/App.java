package org.hibernatePrac.hibernate_HQL_Examples;

import java.util.List;
import java.util.Map;

import org.hibernate.query.NativeQuery;
import java.util.Random;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;


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
    	
    	// insertTestData(session1);
    	
    	session1.beginTransaction();
    	
    	
    	System.out.println("List of objects\n");
    	Query query1 = session1.createQuery("from Student s where s.rollno>45");
    	List<Student> students= query1.list();
    	
    	for(Student s: students) {
    		System.out.println(s);
    	}
    	
    	System.out.println("\n*****************\n");
    	
    	int rollno = 7;
    	
    	System.out.println("Single object via explicit parameter\n");
    	Query query2 = session1.createQuery("from Student where rollno=:param");
    	query2.setParameter("param", rollno);
    	Student student1 = (Student) query2.uniqueResult();
    	System.out.println(student1);
    	
    	System.out.println("\n*****************\n");
    	
    	System.out.println("Single object with certain columns\\n");
    	
    	Query query3 = session1.createQuery("Select rollno, name from Student where rollno=7");
    	Object[] student2 = (Object[]) query3.uniqueResult();
    	System.out.println(student2[0] + " - " + student2[1]);
    	
    	System.out.println("\n*****************\n");
    	
    	System.out.println("Returns results of adding data (summation)\n");
    	
    	Query query4 = session1.createQuery("Select sum(marks) from Student");
    	Long sumOfMarks = (Long) query4.uniqueResult();
    	System.out.println("sumOfMarks: " + sumOfMarks);
    	
    	System.out.println("\n*****************\n");
    	
    	
    	System.out.println("Returns results by using original SQL\n");
    	
    	SQLQuery query5 = session1.createSQLQuery("SELECT * FROM student WHERE marks>60");
    	query5.addEntity(Student.class);
    	List<Student> students2 = query5.getResultList();
    	
    	for(Student s1: students2) {
    		System.out.println(s1);
    	}
    	
    	System.out.println("\n*****************\n");
    	
    	System.out.println("Return results by using original SQL/Native Query\n");
    	
    	NativeQuery query6 = session1.createSQLQuery("SELECT rollno, name FROM student WHERE marks>60");
    	query6.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
    	List<?> students3 = query6.list();
    	
    	for(Object s1: students3) {
    		Map<?, ?> m1 = (Map) s1;
    		System.out.println(m1.get("name") + " : " + m1.get("rollno"));
    	}
    	
    	System.out.println("\n*****************\n");
    	
    	session1.getTransaction().commit();
    }
    
    
    
    public static void insertTestData(Session session1) {
    	Random r = new Random();
    	session1.beginTransaction();
    	
    	for(int i = 1; i<=50;i++) {
    		Student s = new Student(i, "Name " + i, r.nextInt(100));
    		
    		session1.save(s);
    	}
    	
    	session1.getTransaction().commit();
    }
}
