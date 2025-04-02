package com.example.integration.exchange;

import com.example.exceptions.CurrencyNotFoundException;
import com.example.integration.DTOS.responses.ExchangeResponse;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@Data
public class ExchangeIntegration {

    private final WebClient webClient;

    public Mono<Double> makeExchange( String from, String to ) {

        return webClient
                .get()
                .uri( "/pair/{from}/{to}", from, to )
                .retrieve()
                .bodyToMono( ExchangeResponse.class )
                .map( ExchangeResponse::conversion_rate )
                .onErrorResume( throwable -> Mono.error( new CurrencyNotFoundException( "currency not found" ) ) );
    }

}
