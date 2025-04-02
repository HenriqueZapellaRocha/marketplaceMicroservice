package com.example.integration.DTOS.responses;

import lombok.Builder;

@Builder
public record CurrencyNotFoundDTO(

        String error

) {
}
