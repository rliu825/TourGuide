package com.guide.tour.service;

import com.guide.tour.model.Guide;
import com.guide.tour.repository.GuideRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class GuideService {
    @Autowired
    private GuideRepository guideRepository;

    //services
    public Guide findGuideById(long id) {
        return guideRepository.findById(id);
    }
}
