package com.example.airbnb.message.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.Set;

public class SiginUpForm {
    @Size(min = 3, max = 50)
    private String name;

    @Size(min = 3, max = 50)
    private String username;

    @Size(max = 60)
    @Email
    private String email;

    private Set<String> role;

    @Size(min = 6, max = 40)
    private String password;
    private String phoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getRole() {
        return this.role;
    }

    public void setRole(Set<String> role) {
        this.role = role;
    }
}