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
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Session session = sessionFactory.openSession();
        try {
            Model model = new Model("se", 10);
            session.save(model);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
