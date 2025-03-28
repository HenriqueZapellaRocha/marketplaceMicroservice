package com.example.demo.outbound.integration.exchange.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ExchangeIntegrationConfig {

    @Bean( name = "exchangeClient" )
    public WebClient exchangeClient() {

        return WebClient.builder()
                .baseUrl("http://localhost:8098/exchange")
                .build();
    }
}
