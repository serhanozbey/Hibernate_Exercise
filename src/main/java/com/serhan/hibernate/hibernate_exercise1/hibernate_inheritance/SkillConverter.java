package com.serhan.hibernate.hibernate_exercise1.hibernate_inheritance;

import javax.persistence.AttributeConverter;

public class SkillConverter implements AttributeConverter<SkillInterface,String> {
    
    @Override
    public String convertToDatabaseColumn(SkillInterface skill) {
        return skill.getClass().getSimpleName().toLowerCase();
    }
    
    @Override
    public SkillInterface convertToEntityAttribute(String dbData) {
        if (dbData.equals("noskill")) {
            return new NoSkill();
        } else if (dbData.equals("axe")) {
            return new Axe();
        }
        return null;
    }
}
