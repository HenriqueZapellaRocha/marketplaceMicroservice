package com.example.controller.DTOS.reponses;

import lombok.Builder;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Builder
public record ExchenageResposeDTO(
        BigDecimal value,
        String from,
        String to
) {
    public ExchenageResposeDTO {
        if (value != null) {
            value = value.setScale(2, RoundingMode.HALF_EVEN);
        }
    }
}
