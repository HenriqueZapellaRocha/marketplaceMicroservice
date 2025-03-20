package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;


@SpringBootApplication(scanBasePackages = {"com.example.demo", "com.example.controller", "services",  "integreation",
		"repositories", "repositories.repositories", "exceptionHandlers"})
@EnableReactiveMongoRepositories( basePackages = "repositories.repositories")
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
