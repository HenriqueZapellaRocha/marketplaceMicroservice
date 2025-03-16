package com.example.demo.controller.DTOS.requests;

import lombok.Builder;



@Builder
public record UserCreationRequestDTO (

        String username,
        String firstName,
        String lastName,
        String email,
        String roles,
        String userId,
        String country,
        String city,
        String cpf

) {
}
