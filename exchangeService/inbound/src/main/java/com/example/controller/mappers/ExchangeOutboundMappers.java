package com.example.controller.mappers;


import com.example.controller.DTOS.reponses.ExchenageResposeDTO;

import java.math.BigDecimal;

public class ExchangeOutboundMappers {

    public static ExchenageResposeDTO exchangeValueToResponse( String from, String to,
                                                               BigDecimal value ) {
        return ExchenageResposeDTO.builder()
                .value( value )
                .from( from )
                .to( to )
                .build();
    }
}
