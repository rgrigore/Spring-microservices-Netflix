package com.codecool.recommendations.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Recommendation {
    @Id
    @GeneratedValue
    private Long id;

    @Min(1)
    @Max(5)
    private Integer rating;

    private String comment;
    private Long videoId;
}
