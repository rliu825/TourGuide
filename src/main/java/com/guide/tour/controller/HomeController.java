package com.guide.tour.controller;


import com.guide.tour.model.Guide;
import com.guide.tour.model.Tour;
import com.guide.tour.model.Tourist;
import com.guide.tour.repository.GuideRepository;
import com.guide.tour.repository.TourRepository;
import com.guide.tour.repository.TouristRepository;
import com.guide.tour.service.GuideService;
import com.guide.tour.service.TourService;
import com.guide.tour.service.TouristService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class HomeController {
    @Autowired
    private TouristService touristService;
    @Autowired
    private GuideService guideService;
    @Autowired
    private TourService tourService;


//    @Autowired
//    public HomeController(TouristService touristService, GuideService guideService, TourService tourService) {
//        this.touristService = touristService;
//        this.guideService = guideService;
//        this.tourService = tourService;
//    }

    @GetMapping("/")
    public String homepage(){

        return "Home";
    }
    @GetMapping("/guide")
    public String guidepage(){
        return "Guide";
    }

    @GetMapping("/tourist")
    public String touristpage(Model model) {
        ArrayList<Tour> tours = (ArrayList<Tour>) tourService.findAll();
        model.addAttribute("tours",tours);
        return "Tourist";
    }


}
