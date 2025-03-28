package com.example.demo.application;

import com.example.demo.controller.ExchenageResposeDTO;

import java.math.BigDecimal;

public class ExchangeServiceMappers {

    public static ExchenageResposeDTO exchangeValueToResponse( BigDecimal value ) {
        return ExchenageResposeDTO.builder()
                .value( value )
                .build();
    }
}
