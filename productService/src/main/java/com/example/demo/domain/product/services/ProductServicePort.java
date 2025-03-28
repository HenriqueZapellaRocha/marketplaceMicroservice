package com.example.demo.domain.product.services;

import com.example.demo.controller.UserInfos;
import com.example.demo.domain.product.Product;
import reactor.core.publisher.Mono;

public interface ProductServicePort {

    public Mono<Product> createProduct( Product product, UserInfos userInfos, Integer quantity, String from,
                                        String to );
}
