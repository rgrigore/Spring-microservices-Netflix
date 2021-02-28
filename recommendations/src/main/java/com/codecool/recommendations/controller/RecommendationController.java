package com.codecool.recommendations.controller;

import com.codecool.recommendations.controller.service.RecommendationService;
import com.codecool.recommendations.model.RecommendationsList;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recommendation")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RecommendationController {

    private final RecommendationService service;

    @GetMapping("/video/{videoId}")
    public RecommendationsList videoRecommendations(@PathVariable Long videoId) {
        return service.getRecommendationsForVideo(videoId);
    }

    @PostMapping("/video/{videoId}/save")
    public void saveRecommendation(@PathVariable Long videoId, @RequestParam Integer rating, @RequestParam String comment) {
        service.saveRecommendation(videoId, rating, comment);
    }
}
