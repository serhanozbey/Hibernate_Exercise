package com.serhan.hibernate.hibernate_exercise1.hibernate_inheritance;


public class Axe implements SkillInterface {
    
    @Override
    public String getSkill() {
        return getClass().getSimpleName();
    }
    
    @Override
    public void attack() {
        System.out.println("Axe attack");
    }
}
