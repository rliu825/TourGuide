package com.guide.tour.service;

import com.guide.tour.model.Tourist;
import com.guide.tour.repository.TouristRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TouristService {
    @Autowired
    private TouristRepository touristRepository;

    //services
    public Tourist save(Tourist tourist) {
        return touristRepository.save(tourist);
    }
    public Tourist findTouristById(long id) {
        return touristRepository.findById(id);
    }
    public List<Tourist> findAll() {
        return touristRepository.findAll();
    }

    public void deleteTourist(Tourist tourist) {
        touristRepository.delete(tourist);
    }

}
