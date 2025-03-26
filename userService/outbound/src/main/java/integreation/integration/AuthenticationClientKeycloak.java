package integreation.integration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import java.util.Map;

@Component
public class AuthenticationClientKeycloak {

    private final WebClient webClient = WebClient.builder().build();

    @Value("${keycloak.client_id}")
    String client_id;
    @Value("${keycloak.client_secret}")
    String client_secret;
    @Value("${keycloak.grant_type}")
    String grant_type;
    String tokenUrl = "http://localhost:8080/realms/master/protocol/openid-connect/token";

    public Mono<String> getAdminToken() {

        return webClient.post()
                .uri(tokenUrl)
                .header("Content-Type", "application/x-www-form-urlencoded")
                .body( BodyInserters.fromFormData("grant_type", "client_credentials")
                        .with( "client_id", client_id )
                        .with("client_secret", client_secret )).retrieve()
                .bodyToMono( Map.class )
                .flatMap( response -> {

                    String token = (String) response.get( "access_token" );
                    return Mono.just( token );
                } );
    }
}
