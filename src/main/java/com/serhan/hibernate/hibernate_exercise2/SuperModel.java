package com.serhan.hibernate.hibernate_exercise2;

import javax.validation.constraints.Size;

public class SuperModel {

    @Size(min = 3)
    public String superModelName;

}
