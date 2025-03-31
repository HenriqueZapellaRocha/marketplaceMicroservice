package com.example.integration.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ExchangeIntegrationConfig {

    @Value( "${exchange.api.url}" )
    private String baseUrl;

    @Value( "${exchange.api.token}" )
    private String apiKey;

    @Bean( name = "test" )
    public WebClient restTemplate() {
        return WebClient.builder().baseUrl( baseUrl+apiKey ).build();
    }

}
