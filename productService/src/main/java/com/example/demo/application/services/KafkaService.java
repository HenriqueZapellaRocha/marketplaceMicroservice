package com.example.demo.application.services;

import com.example.demo.outbound.repositories.Product.messages.config.ProductCreationMessage;
import lombok.Data;
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Data
@Service
public class KafkaService {

    private final ReactiveKafkaProducerTemplate<String, ProductCreationMessage> kafkaProducer;


    public Mono<Void> produceMessage( ProductCreationMessage productCreationMessage ) {

        return kafkaProducer.send( "products_created",
                productCreationMessage.productId(), productCreationMessage )
                .then();
    }
}
