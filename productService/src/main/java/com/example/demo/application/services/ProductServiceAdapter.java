package com.example.demo.application.services;

import com.example.demo.controller.UserInfos;
import com.example.demo.domain.product.Product;
import com.example.demo.domain.product.repositories.ProductRepositoryPort;
import com.example.demo.domain.product.services.ProductServicePort;
import lombok.Data;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Data
public class ProductServiceAdapter implements ProductServicePort {

    private final ProductRepositoryPort productRepository;

    @Override
    public Mono<Product> createProduct( Product product, UserInfos userInfos ) {

        product.setOwnerId( userInfos.id() );
        return productRepository.save( product );
    }
}
