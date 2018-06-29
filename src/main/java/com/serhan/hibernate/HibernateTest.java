package com.serhan.hibernate;

import com.serhan.hibernate.model.UserDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateTest {
    
    public static void main(String[] args) {
        
        UserDetails user1 = new UserDetails();
        user1.setUsername("serhanozb");
        UserDetails user2 = new UserDetails();
        user2.setUsername("yunus");
        UserDetails user3 = new UserDetails();
        user3.setUsername("deniz");
    
        //we can use factory method to have new sessions to do operations.
        SessionFactory sessionFactory = new Configuration().configure("com/serhan/hibernate/hibernate.cfg.xml").buildSessionFactory();
        //we will use session objects to save our model objects.
        Session session = sessionFactory.openSession();
        //we will use this transaction to perform a save
        session.beginTransaction();
        //saving object
        session.save(user1);
        session.save(user2);
        session.save(user3);
        //committing the transaction
        session.getTransaction().commit();
        //Hibernate is gonna create the table for us.
        sessionFactory.close();
    }
    
}
