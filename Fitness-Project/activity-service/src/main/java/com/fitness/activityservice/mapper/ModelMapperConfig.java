package com.fitness.activityservice.mapper;

import com.fitness.activityservice.dto.ActivityRequest;
import com.fitness.activityservice.model.Activity;
import com.fitness.activityservice.response.ActivityResponse;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper getModelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setSkipNullEnabled(true);
        modelMapper.typeMap(ActivityRequest.class, Activity.class)
                .addMappings(mapper -> {
                    mapper.skip(Activity::setActivityId);
                    mapper.skip(Activity::setCreatedAt);
                    mapper.skip(Activity::setUpdatedAt);
                });
        modelMapper.typeMap(Activity.class, ActivityResponse.class);
        return modelMapper;
    }
}
