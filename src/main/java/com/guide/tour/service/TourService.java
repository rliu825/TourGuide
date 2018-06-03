package com.guide.tour.service;

import com.guide.tour.model.Tour;
import com.guide.tour.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourService {
    @Autowired
    private TourRepository tourRepository;

    //services
    public Tour findTourById(long id) {
        return tourRepository.findById(id);
    }
    public List<Tour> findAll() {
        return tourRepository.findAll();
    }

    public void updateTour(Tour tour) {
        tourRepository.save(tour);
    }

    public void save(Tour tour) {
        tourRepository.save(tour);
    }
}
