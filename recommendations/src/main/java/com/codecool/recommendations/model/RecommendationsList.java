package com.codecool.recommendations.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class RecommendationsList {
    private List<Recommendation> recommendations;
}
