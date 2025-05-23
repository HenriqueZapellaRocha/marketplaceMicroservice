package com.example.application;

import com.example.caching.config.CachingExchangeEntity;
import com.example.caching.repository.CacheRepository;
import com.example.integration.exchange.ExchangeIntegration;
import com.example.schedule.ports.ScheduleServicePort;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
@Data
@Slf4j
public class ScheduleServiceAdapter implements ScheduleServicePort {

    private final CacheRepository cacheRepository;
    private final ExchangeIntegration exchangeIntegration;


    @Scheduled( cron = "0 10 0 * * *" )
    public Mono<Void> updateExchangeRateCache() {
        return cacheRepository.getAll()
                .flatMapMany( mapEntries -> Flux.fromIterable( mapEntries.entrySet() ) )
                .flatMap( mapEntry -> {

                    CachingExchangeEntity cachingValue = mapEntry.getValue();
                    String[] fromTo = mapEntry.getKey().split( "-" );

                    if( fromTo.length != 2 )
                        return Mono.empty();

                    if( cachingValue.getViewsQuantity() < 10 )
                        return cacheRepository.delete( fromTo[0], fromTo[1] ).then();

                    return exchangeIntegration.makeExchange( fromTo[0], fromTo[1] )
                            .flatMap( exchangeRate ->  {

                                cachingValue.setValue( exchangeRate );

                                return cacheRepository.save( fromTo[0], fromTo[1], cachingValue );

                            } ).then();
                } ).then();
    }
}
