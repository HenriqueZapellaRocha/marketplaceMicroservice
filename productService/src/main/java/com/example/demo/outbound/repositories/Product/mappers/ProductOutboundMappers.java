package com.example.demo.outbound.repositories.Product.mappers;

import com.example.demo.domain.product.Product;
import com.example.demo.outbound.repositories.Product.entities.ProductEntity;

import java.util.UUID;


public class ProductOutboundMappers {

    public static ProductEntity domainToEntity( Product product ) {

        return ProductEntity.builder()
                .id( UUID.randomUUID().toString() )
                .ownerId( product.getOwnerId() )
                .name( product.getName() )
                .description( product.getDescription() )
                .price( product.getPrice() )
                .build();

    }

    public static Product entityToDomain( ProductEntity productEntity ) {

        return Product.ProductBuilder.builder()
                .id( productEntity.getId() )
                .ownerId( productEntity.getOwnerId() )
                .name( productEntity.getName() )
                .description( productEntity.getDescription() )
                .price( productEntity.getPrice() )
                .imageUrls( productEntity.getImageUrls() )
                .build();

    }
}
