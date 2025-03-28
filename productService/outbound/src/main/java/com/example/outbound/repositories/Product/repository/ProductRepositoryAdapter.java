package com.example.outbound.repositories.Product.repository;

import com.example.outbound.repositories.Product.mappers.ProductOutboundMappers;
import com.example.product.Product;
import com.example.product.repositories.ProductRepositoryPort;
import lombok.Data;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Data
@Repository
public class ProductRepositoryAdapter implements ProductRepositoryPort {

    private final ProductRepository productRepository;

    public Mono<Product> save(Product product ){
        return productRepository.save( ProductOutboundMappers.domainToEntity( product ) )
                .map( ProductOutboundMappers::entityToDomain );
    }


}
