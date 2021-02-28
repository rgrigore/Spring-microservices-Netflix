package com.codecool.recommendations.controller.repository;

import com.codecool.recommendations.model.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecommendationRepository extends JpaRepository<Recommendation, Long> {
    List<Recommendation> findAllByVideoId(Long videoId);
}
