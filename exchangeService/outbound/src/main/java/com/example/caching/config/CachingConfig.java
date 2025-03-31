package com.example.caching.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
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
    public ReactiveRedisTemplate<String, CachingExchangeEnity> reactiveRedisTemplate(
            ReactiveRedisConnectionFactory factory) {

        ObjectMapper objectMapper = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS); // importante!

        Jackson2JsonRedisSerializer<CachingExchangeEnity> serializer =
                new Jackson2JsonRedisSerializer<>(CachingExchangeEnity.class);
        serializer.setObjectMapper(objectMapper);

        RedisSerializationContext<String, CachingExchangeEnity> context =
                RedisSerializationContext
                        .<String, CachingExchangeEnity>newSerializationContext(new StringRedisSerializer())
                        .value(serializer)
                        .build();

        return new ReactiveRedisTemplate<>(factory, context);
    }
}
