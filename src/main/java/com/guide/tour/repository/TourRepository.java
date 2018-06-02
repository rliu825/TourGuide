package com.guide.tour.repository;

import com.guide.tour.model.Tour;
import com.guide.tour.model.Tourist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TourRepository extends JpaRepository<Tour, Long> {
    Tour findById(long id);
}
