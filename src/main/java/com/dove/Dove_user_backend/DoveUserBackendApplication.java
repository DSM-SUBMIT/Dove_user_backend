package com.dove.Dove_user_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class DoveUserBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoveUserBackendApplication.class, args);
	}

}
