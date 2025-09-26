package com.fitness.aiservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "recommendations")
public class Recommendation {
    @Id
    private String recommendationId;
    private String activityId;
    private ActivityType activityType;
    private Integer userId;
    private String recommendation;
    private List<String> improvements;
    private List<String> suggestions;
    private List<String> safety;
    @CreatedDate
    private LocalDateTime createdAt;
}
