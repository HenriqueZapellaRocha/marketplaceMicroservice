package com.example.controller.DTOS.requests;

import java.math.BigDecimal;

public record ExchangeRequestDTO(

        String from,
        String to,
        BigDecimal value

) {
}
