package com.example.product.repositories;

import com.example.product.Product;
import reactor.core.publisher.Mono;

public interface ProductRepositoryPort {

    public Mono<Product> save( Product product );
}
