package com.example.caching.repository;

import com.example.caching.config.CachingExchangeEntity;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Map;

@Slf4j
@Repository
@Data
public class CacheRepository {

    private final ReactiveRedisTemplate<String, CachingExchangeEntity> reactiveRedisTemplate;

    public Mono<Boolean> save( String from, String to, CachingExchangeEntity cachingExchangeEnity ) {

        String key = from + "-" + to;

        return reactiveRedisTemplate.opsForValue()
                .set( key, cachingExchangeEnity )
                .then( reactiveRedisTemplate.expire( key, Duration.ofDays( 1 ) ) )
                .onErrorResume( e ->  {

                    log.error( e.getMessage() );

                    return Mono.just( false );
                });
    }

    public Mono<CachingExchangeEntity> get( String from, String to ) {

        String key = from + "-" + to;

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

    public Mono<Map<String, CachingExchangeEntity>> getAll() {

        return reactiveRedisTemplate
                .keys( "*" )
                .flatMap( keyValue ->
                        reactiveRedisTemplate .opsForValue().get( keyValue )
                        .map( value -> Map.entry( keyValue, value ) ))
                .collectMap( Map.Entry::getKey, Map.Entry::getValue );

    }

    public Mono<Void> delete( String from, String to ) {
        String key = from + "-" + to;

        return reactiveRedisTemplate.delete( key ).then();

    }

}
