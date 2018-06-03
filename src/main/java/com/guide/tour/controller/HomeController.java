package com.guide.tour.controller;

import com.guide.tour.model.Guide;
import com.guide.tour.model.Tour;
import com.guide.tour.service.GuideService;
import com.guide.tour.service.TourService;
import com.guide.tour.service.TouristService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

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
//    @PostMapping("/guide/{id}")
//    public String postTour(@PathVariable Long id, Tour otherTour){
//        Tour tour = tourService.findTourById(id);
//        tour.setLocation(otherTour.getLocation() + "333");
//        tour.setDescription(tour.getDescription() + "66");
//        tourService.updateTour(tour);
//        return "redirect:/tourist";
//    }

    @GetMapping("/guide/{id}")
    public String guidepage(@PathVariable Long id, Model model) {

        Guide guide = guideService.findGuideById(id);
        if(guide == null) {
            return "Home";
        }
        List<Tour> displayTours = new ArrayList<>();

        List<Tour> tours = tourService.findAll();
        for(Tour tour : tours) {
            if(tour.getGuide().getId() == guide.getId()) {
                displayTours.add(tour);
            }
        }

        model.addAttribute("displaytours", displayTours);
        model.addAttribute("guideId", id);
        return "Guide";
    }

    @GetMapping("/guide/{id}/create")
    public String getCreateTour(@PathVariable (value = "id") Long id, Model model) {
        Guide guide = guideService.findGuideById(id);
        if(guide == null) {
            return "Home";
        }

        model.addAttribute("guideId", id);
        return "CreateTour";
    }

    @PostMapping("/guide/{id}/create")
    public String createTour(@PathVariable (value = "id") Long id, Tour tour) {
        Guide guide = guideService.findGuideById(id);
        if(guide == null || tour == null) {
            return "Home";
        }

        tour.setId(null);
        tour.setGuide(guide);
        tourService.save(tour);

        String redirection = "redirect:/guide/" + id;

        return redirection;
    }

    @GetMapping("/tourist")
    public String touristPage(Model model) {
        ArrayList<Tour> tours = (ArrayList<Tour>) tourService.findAll();
        model.addAttribute("tours",tours);
        return "Tourist";
    }

}
