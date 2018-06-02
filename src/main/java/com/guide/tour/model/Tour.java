package com.guide.tour.model;

import javax.persistence.*;

@Entity
@Table(name = "tours")
public class Tour extends AuditModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String location;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Tour(String location, String description) {
        this.location = location;
        this.description = description;
    }

    protected Tour() {};

    @Override
    public String toString() {
        return String.format(
            "Tour[id='%s',location='%s', description='%s']",
            getId(),getLocation(), getDescription());
    }



}
