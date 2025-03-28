package com.example.demo.application.services;

import com.example.demo.outbound.integration.exchange.integration.ExchangeIntegration;
import lombok.Data;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

@Service
@Data
public class ExchangeService {

    private final ExchangeIntegration exchangeIntegration;

    public Mono<BigDecimal> makeExchange( String from, String to, BigDecimal value ) {

        return exchangeIntegration.makeExchange( from, to, value )
                .map( BigDecimal::valueOf );
    }
}
