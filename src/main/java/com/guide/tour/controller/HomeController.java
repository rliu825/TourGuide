package com.guide.tour.controller;


import com.guide.tour.model.Guide;
import com.guide.tour.model.Tourist;
import com.guide.tour.model.User;
import com.guide.tour.repository.GuideRepository;
import com.guide.tour.repository.TouristRepository;
import com.guide.tour.service.GuideService;
import com.guide.tour.service.TouristService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
    private TouristService touristService;
    private TouristRepository touristRepo;
    private GuideService guideService;
    private GuideRepository guideRepo;

    @Autowired
    public HomeController(TouristService touristService) {
        this.touristService = touristService;
    }

    @GetMapping("/")
    public String homepage(){
        Tourist torrist = touristService.findTouristById(1);
        Guide guide = guideService.findGuideById(1);
        System.out.println(torrist);
        return "Home";
    }
    @GetMapping("/guide")
    public String guidepage(){
        return "Guide";
    }

    @GetMapping("/tourist")
    public String touristpage() {
        return "Tourist";
    }


}
