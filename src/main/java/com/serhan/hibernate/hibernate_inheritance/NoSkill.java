package com.serhan.hibernate.hibernate_inheritance;

import javax.persistence.Column;
import javax.persistence.Entity;


public class NoSkill implements SkillInterface{
    
    public String getSkill() {
        return getClass().getSimpleName();
    }
    
    @Override
    public void attack() {
        System.out.println("no skills");
    }
}
