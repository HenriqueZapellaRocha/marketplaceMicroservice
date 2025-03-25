package com.example.demo.configs;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Collection;
import java.util.Map;

@Service
public class JWTConverter implements Converter<Jwt, Mono<AbstractAuthenticationToken>> {

    @Override
    public Mono<AbstractAuthenticationToken> convert( Jwt jwt ) {

        Map<String, Collection<String>> realmAccess = jwt.getClaim( "realm_access" );
        Collection<String> roles = realmAccess.get( "roles" );
        var grants = roles
                .stream()
                .map( role -> new SimpleGrantedAuthority( "ROLE_"+ role )).toList();


        return Mono.just( new JwtAuthenticationToken( jwt, grants ) );
    }

}
