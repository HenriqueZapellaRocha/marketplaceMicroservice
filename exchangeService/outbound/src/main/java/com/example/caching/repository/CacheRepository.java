package com.example.caching.repository;


import com.example.caching.config.CachingExchangeEnity;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Slf4j
@Repository
@Data
public class CacheRepository {

    private final ReactiveRedisTemplate<String, CachingExchangeEnity> reactiveRedisTemplate;

    public Mono<Boolean> save( String from, String to, CachingExchangeEnity cachingExchangeEnity ) {

        String key = from + to;

        return reactiveRedisTemplate.opsForValue()
                .set(key, cachingExchangeEnity)
                .then( reactiveRedisTemplate.expire( key, Duration.ofDays( 1 ) ) )
                .onErrorResume( e ->  {

                    log.error( e.getMessage() );

                    return Mono.just( false );
                });
    }

    public Mono<CachingExchangeEnity> get( String from, String to ) {
        String key = from + to;

        return reactiveRedisTemplate.opsForValue().get( key )
                .flatMap( oldValue -> {

                    oldValue.setViewsQuantity( oldValue.getViewsQuantity() + 1 );

                    return save( from, to , oldValue )
                            .thenReturn( oldValue );
                } )
                .onErrorResume( e -> {

                    log.error( e.getMessage() );
                     return Mono.empty();
                } );
    }

}
