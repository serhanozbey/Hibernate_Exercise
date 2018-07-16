package com.serhan.hibernate.hibernate_exercise2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class ValidationTest {
    
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("com/serhan/hibernate/hibernate_exercise2/hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Model model1 = new Model("serhan", 10);
            session.save(model1);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    
        try {
            session.beginTransaction();
            Model model2 = new Model("se", 10);
            session.save(model2);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("end");
        
        
        session.close();
        sessionFactory.close();
    }
    
}
