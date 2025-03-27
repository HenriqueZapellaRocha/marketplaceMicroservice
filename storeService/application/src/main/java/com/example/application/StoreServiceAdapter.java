package com.example.application;


import com.example.domain.Store.Store;
import com.example.domain.Store.repository.StoreRepositoryPort;
import com.example.domain.Store.services.StoreServicePort;
import lombok.Data;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Data
public class StoreServiceAdapter implements StoreServicePort {

    private final StoreRepositoryPort storeRepository;


    public Mono<Store> createStore( Store store ) {
        return storeRepository.save( store );
    }

    public Mono<Store> getStoreIByOwnerId( String ownerId ) {
        return storeRepository.getByOwnerId( ownerId );
    }
}
