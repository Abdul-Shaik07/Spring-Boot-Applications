package com.fitness.activityservice.controller;

import com.fitness.activityservice.dto.ActivityRequest;
import com.fitness.activityservice.response.ActivityResponse;
import com.fitness.activityservice.service.IActivityService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/activities/api")
@RequiredArgsConstructor
public class ActivityController {

    private final IActivityService iActivityService;

    @PostMapping("/registerActivity")
    public ResponseEntity<ActivityResponse> registerActivity(@RequestBody @Valid ActivityRequest activityRequest) {
        return ResponseEntity.ok(iActivityService.registerActivity(activityRequest));
    }

    @GetMapping("/getByActivityId/{activityId}")
    public ResponseEntity<ActivityResponse> getByActivityId(@PathVariable("activityId") String activityId) {
        return ResponseEntity.ok(iActivityService.getByActivityId(activityId));
    }

    @GetMapping("/getAllActivities")
    public ResponseEntity<List<ActivityResponse>> getAllActivities() {
        return ResponseEntity.ok(iActivityService.getAllActivities());
    }

}
