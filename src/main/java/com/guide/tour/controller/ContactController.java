package com.guide.tour.controller;

import java.util.ArrayList;
import java.util.List;

import com.guide.tour.model.Contact;
import com.guide.tour.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ContactController {
    private ContactRepository contactRepo;

    @Autowired
    public ContactController(ContactRepository contactRepo) {
        this.contactRepo = contactRepo;
    }

    @GetMapping("/allcontacts")
    public String listContacts(Model model) {
        List<Contact> contacts = (ArrayList) contactRepo.findAll();
        model.addAttribute("contacts", contacts);
        return "AllContacts";
    }

    @GetMapping("/newcontact")
    public String createContactForm() {
        return "CreateContact";
    }

    @PostMapping("/newcontact")
    public String createNewContact(Contact contact) {
        if(contact != null) {
            contactRepo.save(contact);
        }
        return "TourGuideHome";
    }

}