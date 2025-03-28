package com.example.controller;

import com.example.user.User;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class SecurityContext {


    public Mono<User> getUser() {
        return ReactiveSecurityContextHolder.getContext()
                .map( securityContext -> {
                    Jwt jwt = ( Jwt ) securityContext.getAuthentication().getPrincipal();
                    return jwt.<String>getClaim( "sub" );
                }).map( id -> User.builder()
                        .id( id )
                        .build() );
    }
}
