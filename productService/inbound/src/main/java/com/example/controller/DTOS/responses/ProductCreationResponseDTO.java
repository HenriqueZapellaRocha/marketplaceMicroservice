package com.example.controller.DTOS.responses;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record ProductCreationResponseDTO(

        String id,
        String ownerId,
        String name,
        String description,
        BigDecimal price

) {
}
