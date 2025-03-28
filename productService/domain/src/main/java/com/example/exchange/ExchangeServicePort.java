package com.example.exchange;

import reactor.core.publisher.Mono;

import java.math.BigDecimal;

public interface ExchangeServicePort {

    Mono<BigDecimal> makeExchange(String from, String to, BigDecimal value );
}
