package com.guide.tour.controller;

import java.util.ArrayList;
import java.util.List;

import com.guide.tour.model.Contact;

import com.guide.tour.model.User;
import com.guide.tour.repository.UserRepository;
import com.guide.tour.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
    private UserRepository userRepo;
    private UserService userService;

    @Autowired
    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String homepage(){
        User user = userService.findUserById(1);
        System.out.println(user);
        return "Home";
    }
    @GetMapping("/guide")
    public String guidepage(){
        return "Guide";
    }

    @GetMapping("/tourist")
    public String touristpage(){
        return "Tourist";
    }

    @GetMapping("/service")
    public String listContacts(Model model) {
        List<Contact> contacts = (ArrayList) userRepo.findAll();
        model.addAttribute("contacts", contacts);
        return "AllContacts";
    }


}
