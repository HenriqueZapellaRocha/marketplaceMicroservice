package com.example.demo.controller.DTOS.responses;

import java.math.BigDecimal;

public record ProductCreationResponseDTO(

        String id,
        String ownerId,
        String name,
        String description,
        BigDecimal price

) {
}
