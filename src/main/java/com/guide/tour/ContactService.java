package com.guide.tour;

import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
@Repository
public class ContactService {
    private static final Logger log = LoggerFactory.getLogger(ContactService.class);

    // SQL Command
    private static final String createSQL= "CREATE TABLE IF NOT EXISTS Contact (id int AUTO_INCREMENT, " +
            "firstName VARCHAR(30) not null, lastName VARCHAR(30) not null, phoneNumber VARCHAR(30), emailAddress VARCHAR(30), PRIMARY KEY (id))";
    private static final String insertSQL = "INSERT INTO Contact (firstName, lastName, phoneNumber, emailAddress) VALUES (?, ?, ?, ?)";
    private static final String querySQL = "SELECT * FROM Contact";


    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ContactService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createContact() {
        log.info("Creating Contact table: ");
        try {
            jdbcTemplate.execute(createSQL);
        } catch (Exception e){
            log.error("Failed to create Contact table! " + e);
        }
        log.info("Contact table create complete");
    }

    public void insertContact(Contact contact) {
        // Parsing contact data
        String firstName = contact.getFirstName();
        String lastName = contact.getLastName();
        String phoneNumber = contact.getPhoneNumber();
        String emailAddress = contact.getEmailAddress();

        if(contact != null) {
            // Inserting parsed data into contact table
            log.info("Inserting data into Contact table");
            try {
                jdbcTemplate.update(insertSQL, firstName, lastName, phoneNumber, emailAddress);
            } catch (Exception e){
                log.error("Failed to update Contact table! " + e);
            }
            log.info("Insert successfully into contact table!");
        }
    }

    public List<Contact> findAll() {
        List<Contact> entries = new ArrayList<>();
        try{
            entries = jdbcTemplate.query(querySQL, new Object[]{}, new BeanPropertyRowMapper(Contact.class));
        } catch (Exception e){
            log.error("Failed to query data from Contact table! " + e);
        }

        if(entries != null && entries.size() > 0) {
            return entries;
        } else {
            return null;
        }
    }
}