package com.guide.tour.repository;

import com.guide.tour.model.Tour;
import com.guide.tour.model.Tourist;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TourRepository extends JpaRepository<Tour, Long> {
    Tour findById(long id);

    Page<Tour> findByGuideId(Long guideId, Pageable pageable);
}
