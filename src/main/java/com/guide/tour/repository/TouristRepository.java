package com.guide.tour.repository;

import com.guide.tour.model.Tourist;
import com.guide.tour.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TouristRepository extends JpaRepository<Tourist, Long> {
    Tourist findById(long id);
}
