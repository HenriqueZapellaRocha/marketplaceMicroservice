package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
//
//	@Bean
//	public RouteLocator routes(RouteLocatorBuilder builder ) {
//
//		return builder.routes()
//				.route( "userService", r -> r.path( "/user" )
//						.uri( "http://localhost:8090/" ))
//				.build();
//
//	}

}
