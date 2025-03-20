package domain.Store.integration;

import domain.Store.Store;
import reactor.core.publisher.Mono;

public interface StoreServiceIntegrationPort {

    public Mono<Store> createStore(Store store, String ownerId );
}
