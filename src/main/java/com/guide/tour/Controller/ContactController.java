package com.guide.tour.Controller;

import java.util.ArrayList;
import java.util.List;

import com.guide.tour.Model.Contact;
import com.guide.tour.Repository.ContactRepository;
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

    @GetMapping("/")
    public String getHome(){
        return "home";
    }

    @GetMapping("/signin")
    public String getSignIn() {
        return "signin";
    }

    @GetMapping("/signup")
    public String getSignUp() {
        return "signup";
    }

    @PostMapping("/signup")
    public String postSignUp(Contact contact) {
        if(contact != null) {
            contactRepo.save(contact);
        }
        return "landing";
    }

    @GetMapping("/allcontacts")
    public String listContacts(Model model) {
        List<Contact> contacts = (ArrayList) contactRepo.findAll();
        model.addAttribute("contacts", contacts);
        return "AllContacts";
    }
}