package com.example.demo.application.utils;

import com.example.demo.controller.DTOS.requests.ProductCreationRequestDTO;
import com.example.demo.controller.DTOS.responses.ProductCreationResponseDTO;
import com.example.demo.controller.UserInfos;
import com.example.demo.domain.product.Product;


public class ProductServiceMappers {


    public static Product productRequestToDomain( ProductCreationRequestDTO productCreationRequest ) {

        return Product.ProductBuilder.builder()
                .name( productCreationRequest.name() )
                .description( productCreationRequest.description() )
                .price( productCreationRequest.price() )
                .build();

    }

    public static ProductCreationResponseDTO domainToResponse( Product product ) {

        return ProductCreationResponseDTO.builder()
                .id( product.getId() )
                .name( product.getName() )
                .ownerId( product.getOwnerId() )
                .description( product.getDescription() )
                .price( product.getPrice() )
                .build();
    }
}
