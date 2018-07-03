package com.serhan.hibernate.hibernate_inheritance;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class InheritanceTest {
    
    public static void main(String[] args) {
        Creature creature1 = new Cat();
        Creature creature2 = new Dog();
        //we can use factory method to have new sessions to do operations.
        SessionFactory sessionFactory = new Configuration().configure("com/serhan/hibernate/hibernate_inheritance/hibernate.cfg.xml").buildSessionFactory();
        //we will use session objects to save our model objects.
        Session session = sessionFactory.openSession();
        //we will use this transaction to perform a save
        session.beginTransaction();
    
        session.save(creature1);
        creature2.setSkill(new Axe());
        
        session.save(creature2);
    
        //committing the transaction
        session.getTransaction().commit();
        //Hibernate is gonna create the table for us.
    
        Creature retrievedCreature1 = session.get(Creature.class, 1);
        Creature retrievedCreature2 = session.get(Creature.class, 2);
        retrievedCreature1.getSkill().attack();
        retrievedCreature2.getSkill().attack();
        sessionFactory.close();
    
    }
}
