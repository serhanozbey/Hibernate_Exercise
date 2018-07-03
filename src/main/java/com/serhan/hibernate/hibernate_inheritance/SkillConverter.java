package com.serhan.hibernate.hibernate_inheritance;

import javax.persistence.AttributeConverter;

public class SkillConverter implements AttributeConverter<SkillInterface,String> {
    
    @Override
    public String convertToDatabaseColumn(SkillInterface skill) {
        return skill.getClass().getSimpleName().toLowerCase();
    }
    
    @Override
    public SkillInterface convertToEntityAttribute(String dbData) {
        return new NoSkill();
    }
}
