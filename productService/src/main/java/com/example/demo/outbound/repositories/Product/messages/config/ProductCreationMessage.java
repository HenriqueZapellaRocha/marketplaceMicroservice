package com.example.demo.outbound.repositories.Product.messages.config;

import lombok.Builder;

@Builder
public record ProductCreationMessage(

        String productId,
        Integer quantity

) {


}
