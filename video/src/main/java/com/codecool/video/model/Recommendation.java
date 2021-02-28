package com.codecool.video.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Recommendation {
    private Long id;
    private Integer rating;
    private String comment;
    private Long videoId;
}
