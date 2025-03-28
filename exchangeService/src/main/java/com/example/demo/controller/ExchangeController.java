package com.example.demo.controller;


import com.example.demo.application.ExchangeServiceAdapter;
import lombok.Data;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

@RestController
@RequestMapping( "/exchange" )
@Data
public class ExchangeController {

    private final ExchangeServiceAdapter exchangeService;

    @GetMapping( "/{from}/{to}/{value}" )
    public Mono<ExchenageResposeDTO> Exchaange( @PathVariable String from,
                                                @PathVariable String to,
                                                @PathVariable BigDecimal value ) {


        return exchangeService.makeExchange(from, to, value);


    }

}
