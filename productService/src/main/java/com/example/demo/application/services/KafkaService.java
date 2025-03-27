package com.example.demo.application.services;

import com.example.demo.outbound.Product.messages.config.ProductCreationMessage;
import lombok.Data;
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate;
import reactor.core.publisher.Mono;

@Data
public class KafkaService {

    private final ReactiveKafkaProducerTemplate<String, ProductCreationMessage> kafkaProducer;


    public Mono<Void> produceMessage( ProductCreationMessage productCreationMessage ) {

        return kafkaProducer.send( "products_created",
                productCreationMessage.productId(), productCreationMessage )
                .then();
    }
}
