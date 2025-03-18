package integreation.integration;

import domain.Store.Store;
import lombok.Data;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@Data
public class StoreServiceIntegration {

    private final WebClient webClient;

    public Mono<Store> createStore( Store store ) {

        return webClient
                .post()
                .uri("http://localhost:8091/store")
                .contentType( MediaType.APPLICATION_JSON )
                .bodyValue( store )
                .retrieve()
                .bodyToMono( Store.class );
    }
}
