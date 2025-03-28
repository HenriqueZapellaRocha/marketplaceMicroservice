package com.example.demo.controller;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping( "/exchange" )
public class ExchangeController {


    public Mono<ExchenageResposeDTO> Exchaange( @RequestBody ExchangeRequestDTO exchangeRequestDTO ) {




    }

}
