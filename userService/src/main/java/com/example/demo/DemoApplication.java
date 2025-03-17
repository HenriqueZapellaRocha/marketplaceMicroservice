package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;


@SpringBootApplication(scanBasePackages = {"com.example.demo", "com.example.controller", "services",  "integreation", "repository", "repository.repositories", "exceptionHandlers"})
@EnableReactiveMongoRepositories( basePackages = "repository.repositories")
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
