package com.serhan.hibernate.hibernate_inheritance;

import javax.persistence.Entity;
import javax.persistence.Id;


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
