package com.example.controller.DTOS.requests;

import domain.Store.Store;
import domain.enums.UserRoles;
import lombok.Builder;



@Builder
public record UserCreationRequestDTO (

        String username,
        String firstName,
        String lastName,
        String email,
        UserRoles roles,
        String userId,
        String country,
        String city,
        String cpf,
        Store store

) {
}
