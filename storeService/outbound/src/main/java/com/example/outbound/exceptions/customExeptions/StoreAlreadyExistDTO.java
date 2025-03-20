package com.example.outbound.exceptions.customExeptions;

import lombok.Builder;

@Builder
public record StoreAlreadyExistDTO(
        String error
) {

}
