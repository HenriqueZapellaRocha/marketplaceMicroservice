package com.example.caching.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class CachingConfig {

    @Bean
    ReactiveRedisOperations<String, CachingExchangeEnity> redisOperations(ReactiveRedisConnectionFactory factory) {

        Jackson2JsonRedisSerializer<CachingExchangeEnity> serializer =
                new Jackson2JsonRedisSerializer<>(CachingExchangeEnity.class);

        RedisSerializationContext.RedisSerializationContextBuilder<String, CachingExchangeEnity> builder =
                RedisSerializationContext.newSerializationContext(new StringRedisSerializer());

        RedisSerializationContext<String, CachingExchangeEnity> context = builder.value(serializer).build();

        return new ReactiveRedisTemplate<>(factory, context);
    }
}
