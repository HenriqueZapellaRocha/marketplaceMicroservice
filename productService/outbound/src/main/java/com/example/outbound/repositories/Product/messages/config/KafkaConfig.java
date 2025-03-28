package com.example.outbound.repositories.Product.messages.config;

import com.example.product.ProductCreationMessage;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate;
import org.springframework.kafka.support.serializer.JsonSerializer;
import reactor.kafka.sender.SenderOptions;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConfig {

    @Bean
    public ReactiveKafkaProducerTemplate<String, ProductCreationMessage> producerFactory() {

        Map<String, Object> props = new HashMap<>();

        props.put( ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092" );
        props.put( ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class );
        props.put( ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class );
        props.put( "schema.registry.url", "http://localhost:8081" );

        SenderOptions<String, ProductCreationMessage> senderOptions = SenderOptions.create( props );

        return new ReactiveKafkaProducerTemplate<>( senderOptions );
    }
}
