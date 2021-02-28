package com.codecool.recommendations.controller.service;

import com.codecool.recommendations.controller.repository.RecommendationRepository;
import com.codecool.recommendations.model.Recommendation;
import com.codecool.recommendations.model.RecommendationsList;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RecommendationService {

    private final RecommendationRepository repository;

    public RecommendationsList getRecommendationsForVideo(Long videoId) {
        return RecommendationsList.builder()
                .recommendations(repository.findAllByVideoId(videoId))
                .build();
    }

    public void saveRecommendation(Long videoId, Integer rating, String comment) {
        repository.save(Recommendation.builder()
                .videoId(videoId)
                .rating(rating)
                .comment(comment)
                .build()
        );
    }
}
