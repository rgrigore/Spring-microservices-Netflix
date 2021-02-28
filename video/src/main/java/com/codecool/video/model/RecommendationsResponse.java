package com.codecool.video.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class RecommendationsResponse {
    private List<Recommendation> recommendations;
}
