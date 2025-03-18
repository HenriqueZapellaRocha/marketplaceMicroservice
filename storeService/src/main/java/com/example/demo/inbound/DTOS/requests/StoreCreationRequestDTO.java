package com.example.demo.inbound.DTOS.requests;

import lombok.Builder;

@Builder
public record StoreCreationRequestDTO(

        String ownerId,
        String name,
        String description,
        String address,
        String city,
        String state

) {
}
