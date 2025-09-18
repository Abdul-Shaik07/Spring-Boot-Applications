package com.fitness.aiservice.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fitness.aiservice.model.Activity;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ActivityMessageListener {
	
	@KafkaListener(topics = "${kafka.topic.name}", groupId = "activity-processor-group")
	public void processActivity(Activity activity) {
		log.info("Processed Activity {} ", activity.getUserId());
	}

}
