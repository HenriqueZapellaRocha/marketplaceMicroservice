package com.example.demo.controller.DTOS.requests;

import java.math.BigDecimal;

public record ProductCreationtRequestDTO(

        String ownerId,
        String name,
        String description,
        BigDecimal price

) {
}
