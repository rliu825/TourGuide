package com.guide.tour;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ContactController {
    private ContactService contactRepo;

    @Autowired
    public ContactController(ContactService contactRepo) {
        this.contactRepo = contactRepo;
    }

    @GetMapping("/")
    public String homepage(){
        return "TourGuideHome";
    }

    @GetMapping("/allcontacts")
    public String listContacts(Map<String,Object> model) {
        List<Contact> contacts = contactRepo.findAll();
        model.put("contacts", contacts);
        return "AllContacts";
    }

    @GetMapping("/newcontact")
    public String createContactForm() {
        return "CreateContact";
    }

    @PostMapping("/newcontact")
    public String createNewContact(Contact contact) {
        if(contact != null) {
            contactRepo.insertContact(contact);
        }
        return "TourGuideHome";
    }
}