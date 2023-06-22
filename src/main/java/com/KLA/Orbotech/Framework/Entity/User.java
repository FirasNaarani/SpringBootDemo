package com.KLA.Orbotech.Framework.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "UserType", nullable = false, length = 50)
    private String UserType;

    @Column(name = "password", nullable = false, length = 100)
    private String password;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_user", referencedColumnName = "user_id")
    private List<Order> orderList = new ArrayList<>();
    //GETTERS
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUserType() {
        return UserType;
    }

    //SETTERS
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserType(String userType) {
        UserType = userType;
    }

    //CONSTRUCTOR
    public User(){

    }
}