package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication( scanBasePackages = {"inbound", "com.example"} )
@EnableReactiveMongoRepositories( basePackages = "com.example.outbound" )
public class DemoApplication {

	public static void main( String[] args ) {
		SpringApplication.run( DemoApplication.class, args );
	}

}
