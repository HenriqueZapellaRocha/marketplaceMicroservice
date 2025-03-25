package com.example.demo.security.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityFilter {


    @Bean
    public SecurityWebFilterChain springSecurityFilterChain( ServerHttpSecurity http ) {

        return http
                .csrf(ServerHttpSecurity.CsrfSpec::disable)
                .authorizeExchange( exchanges -> exchanges
                        .pathMatchers( HttpMethod.POST, "/product" ).hasRole( "STORE_ADMIN" )
                )
                .oauth2ResourceServer( oauth2 -> oauth2.jwt( jwt ->
                        jwt.jwtAuthenticationConverter( new JWTConverter() )))
                .build();
    }
}
