package com.example.controller.DTOS.requests;

import lombok.Builder;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Builder
public record ProductCreationRequestDTO(

        String name,
        String description,
        Integer quantity,
        BigDecimal price

) {
    public ProductCreationRequestDTO {

        if ( price != null ) {
            price = price.setScale( 2, RoundingMode.HALF_UP );
        }
    }
}
