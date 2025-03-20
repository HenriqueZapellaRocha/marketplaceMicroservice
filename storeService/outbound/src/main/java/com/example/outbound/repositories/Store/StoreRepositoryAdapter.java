package com.example.outbound.repositories.Store;

import com.example.domain.Store.Store;
import com.example.domain.Store.repository.StoreRepositoryPort;
import com.example.outbound.mappers.store.StoreOutboundMappers;
import lombok.Data;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
@Data
public class StoreRepositoryAdapter implements StoreRepositoryPort {

    private final StoreRepository storeRepository;


    public Mono<Store> save( Store store ) {

        return storeRepository.save( StoreOutboundMappers.domainToStoreEntity( store ) )
                .map( StoreOutboundMappers::storeEntityToDomain );
    }
}
