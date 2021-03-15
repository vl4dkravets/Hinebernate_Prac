package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );
        Alien alien1 = new Alien();
        alien1.setId(1);
        alien1.setName("blabla");
        alien1.setColor("green");

        Configuration config = new Configuration();
        SessionFactory sf = config.buildSessionFactory();

        Session session1 = sf.openSession();
        session1.save(alien1);
    }
}
