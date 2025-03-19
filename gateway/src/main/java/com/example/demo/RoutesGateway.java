package com.example.demo;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

@Configuration
public class RoutesGateway {

    @Bean
    public RouteLocator routes( RouteLocatorBuilder builder ) {

        return builder.routes()
                .route( "userService", r -> r.path( "/user" )
                        .and()
                        .method( HttpMethod.POST )
                        .uri( "http://localhost:8090/user" ))
                .build();

    }
}
