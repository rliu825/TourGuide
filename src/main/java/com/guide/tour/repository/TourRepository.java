package com.guide.tour.repository;

import com.guide.tour.model.Guide;
import com.guide.tour.model.Tour;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TourRepository extends JpaRepository<Tour, Long> {
    Tour findById(long id);

    List<Tour> findToursByGuide(Guide guide);

    void delete(Tour tour);
}
