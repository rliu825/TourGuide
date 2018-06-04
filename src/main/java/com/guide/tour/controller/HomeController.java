package com.guide.tour.controller;

import com.guide.tour.model.Guide;
import com.guide.tour.model.Tour;
import com.guide.tour.model.Tourist;
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

    @GetMapping("/guide/{id}")
    public String guideProfile(@PathVariable Long id, Model model) {

        Guide guide = guideService.findGuideById(id);
        if(guide == null) {
            return "Home";
        }

        List<Tour> displayTours = tourService.findToursByGuide(guide);

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

        String redirectionURL = "redirect:/guide/" + id;
        return redirectionURL;
    }

    @PostMapping("/guide/{guideId}/tour/{tourId}/delete")
    public String deleteTourFromGuide(
            @PathVariable (value = "guideId") Long guideId,
            @PathVariable (value = "tourId") Long tourId
    ) {
        Tour tour = tourService.findTourById(tourId);
        if(tour == null) {
            return "Home";
        }

        Guide guide = tour.getGuide();

        if(!guide.getId().equals(guideId)) {
            System.out.println("[ERROR-d]Guide of id: " + guideId + " doesn't have tour of id: " + tourId);
        }

        List<Tourist> tourists = touristService.findAll();
        for(Tourist tourist : tourists) {
            tourist.getTours().remove(tour);
            touristService.save(tourist);
        }
        tourService.deleteTour(tour);

        String redirectionURL = "redirect:/guide/" + guideId;
        return redirectionURL;
    }

    @GetMapping("/tourist/{id}")
    public String touristProfile(@PathVariable (value = "id") Long id, Model model) {
        Tourist tourist = touristService.findTouristById(id);
        if(tourist == null) {
            return "Home";
        }


        ArrayList<Tour> tours = (ArrayList<Tour>) tourService.findAll();
        model.addAttribute("tours",tours);
        model.addAttribute("tourist", tourist);
        model.addAttribute("touristId", tourist.getId());
        return "Tourist";
    }

    @PostMapping("/tourist/{id}")
    public String addTourToTourist(@PathVariable (value = "id") Long touristId, @RequestParam Long tourId) {
        Tourist tourist = touristService.findTouristById(touristId);
        Tour tour = tourService.findTourById(tourId);
        if(tourist == null || tour == null) {
            return "Home";
        }

        if(tourist.getTours().contains(tour)) {
            System.out.println("[ERROR-p]Tourist of id: " + touristId + " already selected tour with id: " + tourId);
            return "Home";
        }

        tourist.getTours().add(tour);
        tour.getTourists().add(tourist);
        touristService.save(tourist);

        String redirectionURL = "redirect:/tourist/" + touristId;
        return redirectionURL;
    }

    @PostMapping("/tourist/{touristId}/tour/{tourId}/delete")
    public String removeTourFromTourist(
            @PathVariable (value = "touristId") Long touristId,
            @PathVariable (value = "tourId") Long tourId
    ) {

        Tourist tourist = touristService.findTouristById(touristId);
        Tour tour = tourService.findTourById(tourId);
        if(tourist == null || tour == null) {
            return "Home";
        }

        if(!tourist.getTours().contains(tour)) {
            System.out.println("[ERROR-d]Tourist of id: " + touristId + " hasn't selected tour of id: " + tourId);
            return "Home";
        }

        tourist.getTours().remove(tour);
        tour.getTourists().remove(tourist);
        touristService.save(tourist);

        String redirectionURL = "redirect:/tourist/" + touristId;
        return redirectionURL;
    }

}
