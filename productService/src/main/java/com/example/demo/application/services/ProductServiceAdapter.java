package com.example.demo.application.services;

import com.example.demo.domain.product.Product;
import com.example.demo.domain.product.services.ProductServicePort;
import reactor.core.publisher.Mono;

public class ProductServiceAdapter implements ProductServicePort {

    @Override
    public Mono<Product> createProduct( Product product ) {
        return null;
    }
}
