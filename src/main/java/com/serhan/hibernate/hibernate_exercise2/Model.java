package com.serhan.hibernate.hibernate_exercise2;


import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.GenericGenerator;

import javax.jws.WebParam;
import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//https://docs.jboss.org/hibernate/validator/4.1/reference/en-US/html/validator-usingvalidator.html#validator-usingvalidator-annotate
@Entity
@Table(name = "hibernate_exercise2")
public class Model extends SuperModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    
    @NotNull
    @Size(min = 3, max = 8)
    public String name;
    
    @Min(10)
    public int money;
    
    @AssertTrue
    public boolean isModel;
    
    @Embedded
    @NotNull
    @Valid
    public SubClass subClass;
    
    //FIXME: not working properly.
    @ElementCollection
    public List<@NotNull @Size(min = 4) @NotEmpty String> list = new ArrayList<>();
    
    public Model() {
        //totally valid class.
        this.name = "Serhan";
        this.money = 15;
        this.isModel = true;
        this.subClass = new SubClass();
    }
    
    public Model(@NotNull @Size(min = 3, max = 8) String name, @Min(10) int money) {
        this.name = name;
        this.money = money;
        this.isModel = true;
        this.subClass = new SubClass();
        this.list.add("placeholder");
    }
    
    public Model(@NotNull @Size(min = 3, max = 8) String name, @Min(10) int money, @AssertTrue boolean isModel) {
        this(name, money);
        this.isModel = isModel;
    }
 
    public Model(String superModelName) {
        this();
        this.superModelName = superModelName;
    }
    
   public Model(List<@NotNull @Size(min = 4) @NotEmpty String> list) {
       this();
       this.list = list;
   }
}
