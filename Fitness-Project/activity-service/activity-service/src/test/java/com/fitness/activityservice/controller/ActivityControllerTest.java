package com.fitness.activityservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fitness.activityservice.dto.ActivityDto;
import com.fitness.activityservice.factory.TestFactory;
import com.fitness.activityservice.response.ActivityResponse;
import com.fitness.activityservice.service.IActivityService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyChar;
import static org.mockito.Mockito.when;

@WebMvcTest(value =  ActivityController.class)
@ActiveProfiles("test")
public class ActivityControllerTest {

    @MockBean
    private IActivityService iActivityService;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    private ActivityDto activityDto;

    private ActivityResponse activityResponse;

    private ModelMapper modelMapper;

//    static {
//        System.setProperty("spring.cloud.config.enabled", "false");
//        System.setProperty("spring.main.allow-bean-definition-overriding", "true");
//    }

    @BeforeEach
    void setUp() {
        activityDto = TestFactory.createActivityDto();
        modelMapper = new ModelMapper();
        activityResponse = modelMapper.map(activityDto, ActivityResponse.class);
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }
    @Test
    public void createActivityTestSuccess() throws Exception {
        when(iActivityService.registerActivity(any(ActivityDto.class))).thenReturn(activityResponse);
        int status = mockMvc.perform(MockMvcRequestBuilders.post("/activities/api/registerActivity")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(activityDto)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getStatus();
        Assertions.assertEquals(HttpStatus.OK.value(), status);
    }

    @Test
    public void createActivityTestFailure() throws Exception{
        activityDto = new ActivityDto();
        activityDto.setUserId(0);
        when(iActivityService.registerActivity(any(ActivityDto.class))).thenThrow(new RuntimeException("Activities Not Found"));
        int status = mockMvc.perform(MockMvcRequestBuilders.post("/activities/api/registerActivity")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(activityDto)))
                .andExpect(MockMvcResultMatchers.status().isInternalServerError())
                .andReturn().getResponse().getStatus();
        Assertions.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), status);
    }

}
