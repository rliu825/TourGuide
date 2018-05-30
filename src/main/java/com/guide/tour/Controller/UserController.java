package com.guide.tour.Controller;

import java.util.ArrayList;
import java.util.List;

import com.guide.tour.Model.User;
import com.guide.tour.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    private UserRepository userRepo;

    @Autowired
    public UserController(UserRepository userRepo) {
        this.userRepo = userRepo;
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
    public String postSignUp(User user) {
        if(user != null) {
            userRepo.save(user);
        }
        return "landing";
    }

    @GetMapping("/redirect/signin")
    public String getRedirectSignIn() {
        return "signin";
    }

    @GetMapping("/allcontacts")
    public String listContacts(Model model) {
        List<User> users = (ArrayList) userRepo.findAll();
        model.addAttribute("users", users);
        return "AllContacts";
    }
}