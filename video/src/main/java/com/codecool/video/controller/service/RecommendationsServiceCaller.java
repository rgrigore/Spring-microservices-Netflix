package com.codecool.video.controller.service;

import com.codecool.video.model.Recommendation;
import com.codecool.video.model.RecommendationsResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Service
public class RecommendationsServiceCaller {

    @Value("${recommendations.url}")
    private String baseUrl;

    private final RestTemplate restTemplate;

    public RecommendationsServiceCaller(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Recommendation> getRecommendations(Long videoId) {
        try {
            ResponseEntity<RecommendationsResponse> entity = restTemplate
                    .getForEntity(
                            baseUrl + String.format("/video/%d", videoId),
                            RecommendationsResponse.class
                    );
            if (entity.getStatusCode().is2xxSuccessful()) {
                return Objects.requireNonNull(entity.getBody()).getRecommendations();
            }
        } catch (RestClientException | IllegalStateException e) {
            e.printStackTrace();
        }

        return List.of();
    }
}
