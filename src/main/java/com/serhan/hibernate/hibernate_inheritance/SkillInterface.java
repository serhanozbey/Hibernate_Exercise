package com.serhan.hibernate.hibernate_inheritance;

import javax.persistence.*;

@Entity
@Inheritance
public interface SkillInterface {
    
    public String getSkill();
    
    void attack();
    
}