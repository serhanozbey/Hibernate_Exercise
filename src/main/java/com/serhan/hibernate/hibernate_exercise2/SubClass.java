package com.serhan.hibernate.hibernate_exercise2;

import javax.persistence.Embeddable;
import javax.validation.constraints.Size;

@Embeddable
public class SubClass {
    
    @Size(min = 5)
    public String subclassName;
    
    public SubClass() {
        this.subclassName = "default";
    }
    
    public SubClass(@Size(min = 5) String name) {
        this.subclassName = "def";
    }
}
