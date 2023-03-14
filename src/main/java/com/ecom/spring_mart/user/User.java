package com.ecom.spring_mart.user;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public class User {

    @Id
    @GeneratedValue
    private Integer id;

    @Size(min = 4, message = "Name should have atleast 4 characters")
    private String name;

    @Email(message = "Enter valid email address")
    private String email;

    private String address;

    public User(Integer id, @Size(min = 4, message = "Name should have atleast 4 characters") String name,
            @Email(message = "Enter valid email address") String email, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", email=" + email + ", address=" + address + "]";
    }
}
