package integreation.configs.tokenAuth;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.Instant;
import java.util.Map;

@Service
@Data
public class RetriveTokenAdmin {

    private final WebClient webClient = WebClient.builder().build();
    private String token;
    private Instant tokenExpiration = Instant.MIN;


    @Value("${keycloak.client_id}")
    String client_id;
    @Value("${keycloak.client_secret}")
    String client_secret;
    @Value("${keycloak.grant_type}")
    String grant_type;
    String tokenUrl = "http://localhost:8080/realms/master/protocol/openid-connect/token";

    public Mono<String> getAdminToken() {

        if( Instant.now().isBefore( tokenExpiration ) )
            return Mono.just( this.token );

        return webClient.post()
                .uri(tokenUrl)
                .header("Content-Type", "application/x-www-form-urlencoded")
                .body( BodyInserters.fromFormData("grant_type", "client_credentials")
                        .with( "client_id", client_id )
                        .with("client_secret", client_secret )).retrieve()
                .bodyToMono( Map.class )
                .flatMap( response -> {

                    this.token = (String) response.get( "access_token" );
                    Integer expiresIn = (Integer) response.get( "expires_in" );

                    if( expiresIn != null )
                        this.tokenExpiration = Instant.now().plusSeconds( expiresIn - 200 );

                    return Mono.just( this.token );

                } );
    }



}
