package com.example.demo.outbound.repositories.Store;

import com.example.demo.outbound.entities.Store.StoreEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends ReactiveMongoRepository<StoreEntity, String> {
}
