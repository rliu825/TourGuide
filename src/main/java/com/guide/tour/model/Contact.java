package com.guide.tour.model;

import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
@Table(name = "contacts")
public class Contact extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    private String phoneNumber;

    private String emailAddress;

    /**
     * Constructor for Contact model
     *
     * @param id
     * @param firstName
     * @param lastName
     * @param phoneNumber
     * @param emailAddress
     */

    public Contact(Long id, String firstName, String lastName, String phoneNumber, String emailAddress) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    protected Contact() {
    }

    ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID is: " + this.id);
        sb.append(" FirstName is: " + this.firstName);
        sb.append(" LastName is: " + this.lastName);
        sb.append(" PhoneNumber is: " + this.phoneNumber);
        sb.append(" EmailAddress is: " + this.emailAddress);
        return sb.toString();
    }
}
