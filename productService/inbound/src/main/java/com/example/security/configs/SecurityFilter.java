package com.example.security.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
public class SecurityFilter {


    @Bean
    public SecurityWebFilterChain springSecurityFilterChain( ServerHttpSecurity http ) {

        return http
                .csrf(ServerHttpSecurity.CsrfSpec::disable)
                .oauth2ResourceServer( oauth2 -> oauth2.jwt( jwt ->
                        jwt.jwtAuthenticationConverter( new JWTConverter() )))
                .build();
    }
}
