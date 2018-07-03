package com.serhan.hibernate.hibernate_inheritance;

import javax.persistence.*;

@Entity
@Table(name = "inheritance")
@DiscriminatorColumn(name = "type")
public abstract class Creature {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
   
    @Convert(converter = SkillConverter.class)
    private SkillInterface skill;
    
    public Creature() {
        this.skill = new NoSkill();
    }
    
    public SkillInterface getSkill() {
        return skill;
    }
    
    public void setSkill(SkillInterface skill) {
        this.skill = skill;
    }
    
    public int getId() {
        return id;
    }
}
