package com.example.demo.application;

import com.example.demo.controller.ExchenageResposeDTO;
import com.example.demo.outbound.integration.config.ExchangeIntegration;
import lombok.Data;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

@Service
@Data
public class ExchangeServiceAdapter {

    private final ExchangeIntegration exchangeIntegration;

    public Mono<ExchenageResposeDTO> makeExchange(String from, String to, BigDecimal value ){


        return exchangeIntegration.makeExchange( from, to )
                .map( exchange -> value.multiply( BigDecimal.valueOf(exchange) ) )
                .map( ExchangeServiceMappers::exchangeValueToResponse );
    }
}
