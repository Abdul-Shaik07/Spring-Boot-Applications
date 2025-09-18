package com.fitness.activityservice.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fitness.activityservice.dto.ActivityDto;
import com.fitness.activityservice.model.Activity;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper getModelMapperConfig() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.typeMap(ActivityDto.class, Activity.class)
                .addMappings(mapper -> {
                    mapper.skip(Activity::setActivityId);
                    mapper.skip(Activity::setCreatedAt);
                    mapper.skip(Activity::setUpdatedAt);
                });
        return modelMapper;

    }
}
