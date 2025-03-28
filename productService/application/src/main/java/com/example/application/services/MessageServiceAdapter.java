package com.example.application.services;

import com.example.product.ProductCreationMessage;
import com.example.product.services.MessageServicePort;
import lombok.Data;
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Data
@Service
public class MessageServiceAdapter implements MessageServicePort {

    private final ReactiveKafkaProducerTemplate<String, ProductCreationMessage> kafkaProducer;


    public Mono<Void> produceMessage( ProductCreationMessage productCreationMessage ) {

        return kafkaProducer.send( "products_created",
                productCreationMessage.getProductId(), productCreationMessage )
                .then();
    }
}
