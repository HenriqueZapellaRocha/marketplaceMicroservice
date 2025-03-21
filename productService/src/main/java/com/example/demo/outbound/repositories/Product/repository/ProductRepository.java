package com.example.demo.outbound.repositories.Product.repository;

import com.example.demo.outbound.repositories.Product.entities.ProductEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProductRepository extends ReactiveMongoRepository<ProductEntity, String> {
}
