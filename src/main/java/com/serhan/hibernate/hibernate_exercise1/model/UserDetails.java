package com.serhan.hibernate.hibernate_exercise1.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "user_details",uniqueConstraints = {
        @UniqueConstraint( name = "const_username",columnNames = "username")})
public class UserDetails {
    
    //1- This is the model class that Hibernate needs to persist*/
    
    //2- Now we will use annotations to give Hibernate clue*/
    
    //3- Private key assignment
    
    //4- We need an object initialization code.
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    private String username;
    @NotNull
    private String password;
    @NotNull
    private String email;
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
}
