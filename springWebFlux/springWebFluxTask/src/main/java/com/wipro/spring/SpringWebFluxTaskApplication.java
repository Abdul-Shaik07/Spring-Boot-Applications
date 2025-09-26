package com.wipro.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@SpringBootApplication
@EnableR2dbcRepositories
@ComponentScan()

public class SpringWebFluxTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringWebFluxTaskApplication.class, args);
    }
}
