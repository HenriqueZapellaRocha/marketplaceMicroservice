package com.example.product.services;

import com.example.product.Product;
import com.example.user.User;
import reactor.core.publisher.Mono;

public interface ProductServicePort {

    Mono<Product> createProduct(Product product, User userInfos, Integer quantity, String from,
                                       String to );
}
