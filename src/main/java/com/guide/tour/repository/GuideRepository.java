package com.guide.tour.repository;

import com.guide.tour.model.Guide;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuideRepository extends JpaRepository<Guide, Long> {
    Guide findById(long id);
}
