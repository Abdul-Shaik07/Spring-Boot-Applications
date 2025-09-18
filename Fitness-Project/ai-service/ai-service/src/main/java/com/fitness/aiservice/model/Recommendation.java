package com.fitness.aiservice.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Document(collection = "recommendations")
public class Recommendation {
    @Id
    private String recommendationId;
    private String activityId;
    private Integer userId;
    private String activityType;
    private String recommendation;
    private List<String> improvements;
    private List<String> suggestions;
    private List<String> safety;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
