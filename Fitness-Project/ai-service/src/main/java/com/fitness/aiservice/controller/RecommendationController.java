package com.fitness.aiservice.controller;

import com.fitness.aiservice.dto.RecommendationRequest;
import com.fitness.aiservice.model.Recommendation;
import com.fitness.aiservice.response.RecommendationResponse;
import com.fitness.aiservice.service.IRecommendationService;
import jakarta.ws.rs.Path;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recommendations/api")
@RequiredArgsConstructor
public class RecommendationController {

    private final IRecommendationService iRecommendationService;

    /*@PostMapping("/registerRecommendation")
    public ResponseEntity<RecommendationResponse> registerRecommendation(@RequestBody RecommendationRequest recommendationRequest) {
        return ResponseEntity.ok(iRecommendationService.registerRecommendation(recommendationRequest));
    }*/

    @GetMapping("/getUserRecommendation/{userId}")
    public ResponseEntity<List<Recommendation>> getUserRecommendation(@PathVariable("userId") Integer userId) {
        return ResponseEntity.ok(iRecommendationService.getUserRecommendation(userId));
    }

    @GetMapping("/getActivityRecommendation/{userId}")
    public ResponseEntity<Recommendation> getActivityRecommendation(@PathVariable("activityId") String activityId) {
        return ResponseEntity.ok(iRecommendationService.getActivityRecommendation(activityId));
    }


}
