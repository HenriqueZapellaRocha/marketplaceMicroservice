package com.example.demo.application;


import com.example.demo.application.utils.mappers.StoreServiceMappers;
import com.example.demo.domain.Store;
import com.example.demo.inbound.controllers.utils.mappers.StoreInboundMappers;
import com.example.demo.outbound.repositories.Store.StoreRepository;
import lombok.Data;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Data
public class StoreService {

    private final StoreRepository storeRepository;


    public Mono<Store> createStore( Store store ) {
        return storeRepository.save( StoreServiceMappers.domainToEntity(store) )
                .map( StoreServiceMappers::entityToDomain );
    }
}
