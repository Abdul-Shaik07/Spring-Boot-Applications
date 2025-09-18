package com.fitness.aiservice.service;

import com.fitness.aiservice.model.Recommendation;

import java.util.List;

public interface IRecommendationService {

    List<Recommendation> getUserRecommendation(Integer userId);
    Recommendation getActivityRecommendation(String activityId);

}
