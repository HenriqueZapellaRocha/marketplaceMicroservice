package com.example.exchange.ports;

import com.example.exchange.ExchangeValue;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

public interface ExchangeServicePort {

    Mono<ExchangeValue> makeExchange(String from, String to, BigDecimal value );
}
