package com.example.product.services;

import com.example.product.ProductCreationMessage;
import reactor.core.publisher.Mono;

public interface MessageServicePort {

    Mono<Void> produceMessage( ProductCreationMessage productCreationMessage );
}
