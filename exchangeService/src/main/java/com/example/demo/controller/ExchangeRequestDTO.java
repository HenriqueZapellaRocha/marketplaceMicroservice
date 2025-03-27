package com.example.demo.controller;

import java.math.BigDecimal;

public record ExchangeRequestDTO(

        String from,
        String to,
        BigDecimal value

) {
}
