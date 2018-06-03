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

import com.sun.org.apache.xpath.internal.operations.Mod;
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
    @PostMapping("/guide/{id}")
    public String postTour(@PathVariable Long id){
        Tour tour = tourService.findTourById(id);
        tour.setDescription("eddie!!!!!");
        tourService.updateTour(tour);
        return "redirect:/tourist";
    }

    @GetMapping("/guide")
    public String guidepage(Model model) {
//        ArrayList<Tour> tours = (ArrayList<Tour>) tourService.findAll();
        return "Guide";
    }

    @GetMapping("/tourist")
    public String touristPage(Model model) {
        ArrayList<Tour> tours = (ArrayList<Tour>) tourService.findAll();
        model.addAttribute("tours",tours);
        return "Tourist";
    }


}
