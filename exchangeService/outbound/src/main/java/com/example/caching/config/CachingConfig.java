package com.example.caching.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class CachingConfig {

    @Bean
    public ReactiveRedisTemplate<String, CachingExchangeEnity> redisOperations(ReactiveRedisConnectionFactory factory) {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule( new JavaTimeModule() );

        Jackson2JsonRedisSerializer<CachingExchangeEnity> serializer =
                new Jackson2JsonRedisSerializer<>(objectMapper, CachingExchangeEnity.class);

        RedisSerializationContext.RedisSerializationContextBuilder<String, CachingExchangeEnity> builder =
                RedisSerializationContext.newSerializationContext( new StringRedisSerializer() );

        RedisSerializationContext<String,CachingExchangeEnity> context = builder.value( serializer ).build();

        return new ReactiveRedisTemplate<>(factory, context);
    }
}
