package com.example.controller.controllers;


import com.example.application.ExchangeServiceAdapter;
import com.example.controller.DTOS.reponses.ExchenageResposeDTO;
import com.example.controller.mappers.ExchangeOutboundMappers;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

@RestController
@RequestMapping( "/exchange" )
@Data
public class ExchangeController {

    private final ExchangeServiceAdapter exchangeService;

    @GetMapping( "/{from}/{to}/{value}" )
    public Mono<ExchenageResposeDTO> Exchange(  @PathVariable String from,
                                                @PathVariable String to,
                                                @PathVariable BigDecimal value ) {


        return exchangeService.makeExchange( from, to, value )
                .map( exchangeValue -> ExchangeOutboundMappers
                                        .exchangeValueToResponse( exchangeValue.getFrom(),
                                                exchangeValue.getTo() , exchangeValue.getValue() ) );


    }

}
