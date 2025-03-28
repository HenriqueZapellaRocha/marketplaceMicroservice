package com.example.demo.outbound.repositories.Product.repository;

import com.example.demo.domain.product.Product;
import com.example.demo.domain.product.repositories.ProductRepositoryPort;
import com.example.demo.outbound.repositories.Product.mappers.ProductOutboundMappers;
import lombok.Data;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Data
@Repository
public class ProductRepositoryAdapter implements ProductRepositoryPort {

    private final ProductRepository productRepository;

    public Mono<Product> save( Product product ){
        return productRepository.save( ProductOutboundMappers.domainToEntity( product ) )
                .map( ProductOutboundMappers::entityToDomain );
    }


}
