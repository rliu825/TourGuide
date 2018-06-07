package com.guide.tour.model;

import org.springframework.lang.NonNull;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Size;

@MappedSuperclass
public abstract class User extends AuditModel {

    @NonNull
    @Size(max = 50)
    private String name;
    private String language;
    private String phone;
    private String email;

    protected User() {
    }

    public User(@Size(max = 50) String name, String language, String phone, String email) {
        this.name = name;
        this.language = language;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
