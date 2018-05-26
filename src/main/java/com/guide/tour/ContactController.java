package com.guide.tour;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class ContactController {
    private ContactService contactRepo;

    @Autowired
    public ContactController(ContactService contactRepo) {
        this.contactRepo = contactRepo;
        this.contactRepo.createContact();
    }

    @RequestMapping(method=RequestMethod.GET)
    public String home(Map<String,Object> model) {
        List<Contact> contacts = contactRepo.findAll();
        model.put("contacts", contacts);
        return "home";
    }

    @RequestMapping(method=RequestMethod.POST)
    public String submit(Contact contact) {
        contactRepo.insertContact(contact);
        return "redirect:/";
    }
}