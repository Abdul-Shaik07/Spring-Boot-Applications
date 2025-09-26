package com.fitness.aiservice.service;

import com.fitness.aiservice.dto.RecommendationRequest;
import com.fitness.aiservice.model.Recommendation;
import com.fitness.aiservice.repository.RecommendationRepository;
import com.fitness.aiservice.response.RecommendationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecommendationService implements IRecommendationService {

    private final RecommendationRepository recommendationRepository;


    @Override
    public List<Recommendation> getUserRecommendation(Integer userId) {
        return recommendationRepository.findByUserId(userId);
    }

    @Override
    public Recommendation getActivityRecommendation(String activityId) {
        Recommendation byActivityId = recommendationRepository.findByActivityId(activityId);
        if(byActivityId == null){
            throw new RuntimeException("Activity not found");
        }
        return byActivityId;
    }
}
