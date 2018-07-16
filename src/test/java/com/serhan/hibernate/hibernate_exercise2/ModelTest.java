package com.serhan.hibernate.hibernate_exercise2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.validation.Validator;

import java.util.ArrayList;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertThrows;


class ModelTest {
    
    private static SessionFactory sessionFactory;
    private static Session session;
    private static Validator validator;
    
    @BeforeAll
    static void beforeAll() {
                sessionFactory = new Configuration().configure("com/serhan/hibernate/hibernate_exercise2/hibernate.cfg.xml").buildSessionFactory();
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    
    @BeforeEach
    void beforeEach() {
        session = sessionFactory.openSession();
    }
    
    
    @Test
    void nameIsTooShort() {
        Model model = new Model("se", 12);
        assertThrows(ConstraintViolationException.class, () -> session.save(model));
    }
    
    @Test
    void nameIsTooLong() {
        Model model = new Model("serhanserhanserhan", 12);
        assertThrows(ConstraintViolationException.class, () -> session.save(model));
    }
    
    @Test
    void numberTooSmall(){
        Model model = new Model("serhan", 2);
        assertThrows(ConstraintViolationException.class, () -> session.save(model));
    }
    
    @Test
    void isNotModel(){
        Model model = new Model("serhan", 20, false);
        assertThrows(ConstraintViolationException.class, () -> session.save(model));
    }
    
    @Test
    void compositionNotValid(){
        Model model = new Model();
        model.subClass = new SubClass("se");
        assertThrows(ConstraintViolationException.class, ()-> session.save(model));
    }
    
    @Test
    void validationInheritanceNotValid(){
        Model model = new Model("a");
        assertThrows(ConstraintViolationException.class, () -> session.save(model));
    }
    
    //@Test
    //void nestedElementNotValid(){
    //    ArrayList<String> list = new ArrayList<>();
    //    list.add("eb");
    //    Model model = new Model(list);
    //    assertThrows(ConstraintViolationException.class, () -> session.save(model));
    //}
    
    @Test
    void successfullWrite(){
        Model model1 = new Model("serhan", 20);
        Model model2 = new Model("dedede", 30);
        session.save(model1);
        session.save(model2);
    }
    
    @AfterEach
    void afterEach() {
        session.close();
    }
    
    @AfterAll
    static void afterAll(){
        sessionFactory.close();
    }
}