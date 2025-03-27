package com.example.demo.outbound.Product.messages.config;

import lombok.Builder;

@Builder
public record ProductCreationMessage(

        String productId,
        Integer quantity

) {


}
