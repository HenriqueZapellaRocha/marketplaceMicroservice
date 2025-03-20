package com.example.application;


import com.example.application.utils.mappers.StoreServiceMappers;
import com.example.domain.Store.Store;
import com.example.domain.Store.services.StoreServicePort;
import com.example.outbound.repositories.Store.StoreRepository;
import lombok.Data;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Data
public class StoreServiceAdapter implements StoreServicePort {

    private final StoreRepository storeRepository;


    public Mono<Store> createStore( Store store ) {
        return storeRepository.save( StoreServiceMappers.domainToEntity( store ) )
                .map( StoreServiceMappers::entityToDomain );
    }
}
