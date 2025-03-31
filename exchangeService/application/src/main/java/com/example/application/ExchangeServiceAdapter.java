package com.example.application;

import com.example.caching.repository.CacheRepository;
import com.example.integration.config.ExchangeIntegration;
import com.example.value.ExchangeValue;
import lombok.Data;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

@Service
@Data
public class ExchangeServiceAdapter {

    private final ExchangeIntegration exchangeIntegration;
    private final CacheRepository cacheRepository;

    public Mono<ExchangeValue> makeExchange( String from, String to, BigDecimal value ){

        return cacheRepository.get( from, to )
                .switchIfEmpty( exchangeIntegration
                        .makeExchange( from, to )
                        .flatMap( valueEchanged -> {

                        } ) )



        return exchangeIntegration.makeExchange( from, to )
                .map( exchange -> value.multiply( BigDecimal.valueOf(exchange) ) )
                .map( valueExchanged ->  new ExchangeValue( from, to, valueExchanged ) );
    }
}
