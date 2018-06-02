package com.guide.tour.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "guides")
@Inheritance
public class Guide extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Guide(@Size(max = 50) String name, String language, String phone, String email) {
        this.setName(name);
        this.setLanguage(language);
        this.setPhone(phone);
        this.setEmail(email);
    }

    protected Guide() {
    }

    // TODO: 2018-06-01 improve toString()
    @Override
    public String toString() {
        return String.format(
            "GuideService[id=%d, name='%s', email='%s']",
            id, getName(), getEmail());
    }

}
