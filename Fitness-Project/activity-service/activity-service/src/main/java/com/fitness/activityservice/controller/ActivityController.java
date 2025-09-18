package com.fitness.activityservice.controller;

import java.util.List;
import com.fitness.activityservice.response.ActivitiesWithUserId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fitness.activityservice.dto.ActivityDto;
import com.fitness.activityservice.response.ActivityResponse;
import com.fitness.activityservice.service.IActivityService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/activities/api")
@RequiredArgsConstructor
public class ActivityController {

	private final IActivityService iActivityService;
	
	@PostMapping("/registerActivity")
	public ResponseEntity<ActivityResponse> registerActivity(@RequestBody ActivityDto activityDto) {
		return ResponseEntity.ok(iActivityService.registerActivity(activityDto));
	}
	
	@GetMapping("/getActivityById/{activityId}")
	public ResponseEntity<ActivityResponse> getActivityById(@PathVariable("activityId") String activityId) {
		return ResponseEntity.ok(iActivityService.getActivityById(activityId));
	}
	
	@GetMapping("/getAllActivities")
	public ResponseEntity<List<ActivityResponse>> getAllActivities() {
		return ResponseEntity.ok(iActivityService.getAllActivities());
	}

	@GetMapping("/getUserActivitiesByUserId/{userId}")
	public ResponseEntity<ActivitiesWithUserId> getActivitiesByUserId(@PathVariable("userId") Integer userId) {
		return ResponseEntity.ok(iActivityService.getActivitiesByUserId(userId));
	}
}
