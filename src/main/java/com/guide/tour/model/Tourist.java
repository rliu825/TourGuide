package com.guide.tour.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tourists")
@Inheritance
public class Tourist extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "tourist_tours",
            joinColumns = { @JoinColumn(name = "tourist_id") },
            inverseJoinColumns = { @JoinColumn(name = "tour_id") })
    private Set<Tour> tours = new HashSet<>();

    public Tourist(@Size(max = 50) String name, String language, String phone, String email) {
        this.setName(name);
        this.setLanguage(language);
        this.setPhone(phone);
        this.setEmail(email);
    }

    protected Tourist() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Tour> getTours() {
        return tours;
    }

    public void setTours(Set<Tour> tours) {
        this.tours = tours;
    }

    // TODO: 2018-06-01 improve toString()
    @Override
    public String toString() {
        return String.format(
            "Tourist[id=%d, name='%s', email='%s']",
            id, getName(), getEmail());
    }

}
