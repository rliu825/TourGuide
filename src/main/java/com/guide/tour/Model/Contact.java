package com.guide.tour.Model;

import javax.persistence.*;

@Entity
@Table(name = "contacts")
public class Contact extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    
    private String lastName;

    private String userName;

    private String emailAddress;

    private String passWord;

    /**
     * Constructor for Contact Model
     *
     * @param id
     * @param firstName
     * @param lastName
     * @param userName
     * @param emailAddress
     */

    public Contact(Long id, String firstName, String lastName, String userName, String emailAddress, String passWord) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.emailAddress = emailAddress;
        this.passWord = passWord;
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
        return userName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.userName = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassWord() {return passWord; }

    public void setPassWord(String passWord) {this.passWord = passWord; }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID is: " + this.id);
        sb.append(" FirstName is: " + this.firstName);
        sb.append(" LastName is: " + this.lastName);
        sb.append(" PhoneNumber is: " + this.userName);
        sb.append(" EmailAddress is: " + this.emailAddress);
        sb.append(" Password is: " + this.passWord);
        return sb.toString();
    }
}
