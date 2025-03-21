package com.example.demo.domain.product.repositories;

import com.example.demo.domain.product.Product;
import reactor.core.publisher.Mono;

public interface ProductRepositoryPort {

    public Mono<Product> save( Product product );
}
