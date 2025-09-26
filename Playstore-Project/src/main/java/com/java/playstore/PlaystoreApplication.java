package com.java.playstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PlaystoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlaystoreApplication.class, args);
	}

}
