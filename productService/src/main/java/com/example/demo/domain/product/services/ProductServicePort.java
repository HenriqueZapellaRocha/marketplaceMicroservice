package com.example.demo.domain.product.services;

import com.example.demo.domain.product.Product;
import reactor.core.publisher.Mono;

public interface ProductServicePort {

    Mono<Product> createProduct( Product product );
}
