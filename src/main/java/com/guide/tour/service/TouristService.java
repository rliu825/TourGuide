package com.guide.tour.service;

import com.guide.tour.model.Tourist;
import com.guide.tour.repository.TouristRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TouristService {
    @Autowired
    private TouristRepository touristRepository;

    //services
    public Tourist findTouristById(long id) {
        return touristRepository.findById(id);
    }
}
