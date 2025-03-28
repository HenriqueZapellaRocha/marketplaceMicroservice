package com.example.outbound.repositories.Product.mappers;

import com.example.outbound.repositories.Product.entities.ProductEntity;
import com.example.product.Product;

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
