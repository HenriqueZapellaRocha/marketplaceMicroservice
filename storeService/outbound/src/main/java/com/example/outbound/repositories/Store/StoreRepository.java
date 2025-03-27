package com.example.outbound.repositories.Store;


import com.example.outbound.repositories.Store.entities.StoreEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface StoreRepository extends ReactiveMongoRepository<StoreEntity, String> {

     Mono<StoreEntity> getByOwnerId( String ownerId );
}
