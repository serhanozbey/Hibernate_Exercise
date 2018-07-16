package com.serhan.hibernate.hibernate_exercise1.hibernate_inheritance;


public class NoSkill implements SkillInterface{
    
    public String getSkill() {
        return getClass().getSimpleName();
    }
    
    @Override
    public void attack() {
        System.out.println("no skills");
    }
}
