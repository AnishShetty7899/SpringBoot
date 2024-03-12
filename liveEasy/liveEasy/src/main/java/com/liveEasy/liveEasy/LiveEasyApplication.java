package com.liveEasy.liveEasy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.liveEasy.liveEasy.entites")
public class LiveEasyApplication {

	public static void main(String[] args) {
		SpringApplication.run(LiveEasyApplication.class, args);
	}

}
