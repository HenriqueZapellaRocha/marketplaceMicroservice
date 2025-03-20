package integreation.integration;

import domain.Store.Store;
import domain.Store.integration.StoreServiceIntegrationPort;
import integreation.mappers.StoreOutboundMappers;
import lombok.Data;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@Data
public class StoreServiceIntegrationAdapter implements StoreServiceIntegrationPort {

    private final WebClient webClient;

    public Mono<Store> createStore( Store store, String ownerId ) {
        return webClient
                .post()
                .uri( "http://localhost:8091/store" )
                .contentType( MediaType.APPLICATION_JSON )
                .bodyValue( StoreOutboundMappers.domainToStoreCreationDTO( store, ownerId ) )
                .retrieve()
                .bodyToMono( Store.class );

    }
}
