package com.example.application;

import com.example.caching.config.CachingExchangeEntity;
import com.example.caching.repository.CacheRepository;
import com.example.exchange.ports.ExchangeServicePort;
import com.example.integration.exchange.ExchangeIntegration;
import com.example.exchange.ExchangeValue;
import lombok.Data;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@Data
public class ExchangeServiceAdapter implements ExchangeServicePort {

    private final ExchangeIntegration exchangeIntegration;
    private final CacheRepository cacheRepository;

    public Mono<ExchangeValue> makeExchange( String from, String to, BigDecimal value ){

        return cacheRepository.get( from, to )
                .map( CachingExchangeEntity::getValue )
                .switchIfEmpty( exchangeIntegration
                        .makeExchange( from, to )
                        .flatMap( exchangeRate -> cacheRepository.save( from, to, CachingExchangeEntity.builder()
                                        .value( exchangeRate )
                                        .cachingMoment( LocalDateTime.now() )
                                .build() )
                                .thenReturn( exchangeRate )) )
                .map( exchangeRate -> new ExchangeValue( from, to,
                        value.multiply( BigDecimal.valueOf( exchangeRate ) )  ) );

    }
}
