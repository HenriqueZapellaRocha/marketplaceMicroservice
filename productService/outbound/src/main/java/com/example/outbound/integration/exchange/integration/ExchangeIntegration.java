package com.example.outbound.integration.exchange.integration;

import com.example.outbound.integration.exchange.integration.DTO.ExchangeResponseDTO;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

@Service
@Data
public class ExchangeIntegration {

    @Autowired
    @Qualifier("exchangeClient")
    private WebClient webClient;

    public Mono<Double> makeExchange(String from, String to, BigDecimal value ) {

         return webClient.get()
                 .uri( "/"+from + "/"+to+ "/" + value.toPlainString() )
                 .retrieve()
                 .bodyToMono(ExchangeResponseDTO.class)
                 .map( ExchangeResponseDTO::value );
    }

}
