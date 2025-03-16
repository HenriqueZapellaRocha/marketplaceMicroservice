package com.example.demo.integreation.integration;

import com.example.demo.domain.User;
import com.example.demo.integreation.mappers.KeycloakUser;
import com.example.demo.integreation.mappers.UserIntegreationKeycloakMappers;
import lombok.Data;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Data
@Service
public class KeycloakIntegration {

    private final WebClient webClient;

    public Mono<String> createUser( User user ) {

        KeycloakUser keycloakUser = UserIntegreationKeycloakMappers.domainToKeycloakUser( user );

        return webClient.post()
                .contentType( MediaType.APPLICATION_JSON )
                .bodyValue( keycloakUser )
                .exchangeToMono( clientResponse -> {

                    String headerIdUser = clientResponse.headers()
                            .asHttpHeaders()
                            .getFirst( "Location" );

                    if( headerIdUser == null )
                        return  Mono.empty();

                    String regex = "[^/]+$";


                    Pattern pattern = Pattern.compile(regex);
                    Matcher matcher = pattern.matcher(headerIdUser);

                    if( matcher.find() ) {

                        String lastPart = matcher.group();

                        return Mono.just( lastPart );
                    }
                    else {
                        return Mono.empty();
                    }


                } ).onErrorResume( e -> Mono.error( new RuntimeException( "error creating user" ) ) );

    }
}
