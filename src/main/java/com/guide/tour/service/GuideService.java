package com.guide.tour.service;

import com.guide.tour.model.Guide;
import com.guide.tour.model.Tour;
import com.guide.tour.repository.GuideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuideService {
    @Autowired
    private GuideRepository guideRepository;

    @Autowired
    private TourService tourService;

    //services
    public Guide findGuideById(long id) {
        return guideRepository.findById(id);
    }

    public void deleteGuide(Guide guide) {
        List<Tour> tours = tourService.findToursByGuide(guide);
        for(Tour tour : tours) {
            tourService.deleteTour(tour);
        }
        guideRepository.delete(guide);
    }
}
