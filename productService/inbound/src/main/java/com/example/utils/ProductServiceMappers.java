package com.example.utils;


import com.example.controller.DTOS.requests.ProductCreationRequestDTO;
import com.example.controller.DTOS.responses.ProductCreationResponseDTO;
import com.example.product.Product;

public class ProductServiceMappers {


    public static Product productRequestToDomain( ProductCreationRequestDTO productCreationRequest ) {

        return Product.ProductBuilder.builder()
                .name( productCreationRequest.name() )
                .description( productCreationRequest.description() )
                .price( productCreationRequest.price() )
                .build();

    }

    public static ProductCreationResponseDTO domainToResponse(Product product ) {

        return ProductCreationResponseDTO.builder()
                .id( product.getId() )
                .name( product.getName() )
                .ownerId( product.getOwnerId() )
                .description( product.getDescription() )
                .price( product.getPrice() )
                .build();
    }
}
