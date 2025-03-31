package com.example.application;

import com.example.caching.config.CachingExchangeEnity;
import com.example.caching.repository.CacheRepository;
import com.example.integration.config.ExchangeIntegration;
import com.example.value.ExchangeValue;
import lombok.Data;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@Data
public class ExchangeServiceAdapter {

    private final ExchangeIntegration exchangeIntegration;
    private final CacheRepository cacheRepository;

    public Mono<ExchangeValue> makeExchange( String from, String to, BigDecimal value ){

        return cacheRepository.get( from, to )
                .map( CachingExchangeEnity::getValue )
                .switchIfEmpty( exchangeIntegration
                        .makeExchange( from, to )
                        .flatMap( exchangeRate -> cacheRepository.save( from, to, CachingExchangeEnity.builder()
                                        .value( exchangeRate )
                                        .cachingMoment( LocalDateTime.now() )
                                .build() )
                                .thenReturn( exchangeRate )) )
                .map( exchangeRate -> new ExchangeValue( from, to,
                        value.multiply( BigDecimal.valueOf( exchangeRate ) )  ) );

    }
}
