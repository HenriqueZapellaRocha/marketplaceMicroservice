package com.example.demo.application.services;

import com.example.demo.controller.UserInfos;
import com.example.demo.domain.product.Product;
import com.example.demo.domain.product.repositories.ProductRepositoryPort;
import com.example.demo.domain.product.services.ProductServicePort;
import com.example.demo.outbound.repositories.Product.messages.config.ProductCreationMessage;
import lombok.Data;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Data
public class ProductServiceAdapter implements ProductServicePort {

    private final ProductRepositoryPort productRepository;
    private final KafkaService kafkaService;
    private final ExchangeService exchangeService;

    @Override
    public Mono<Product> createProduct( Product product, UserInfos userInfos, Integer quantity,
                                                                        String from, String to ) {

        product.setOwnerId( userInfos.id() );

        return exchangeService.makeExchange( from, to , product.getPrice() )
                .flatMap( valueExchanged -> {
                    product.setPrice( valueExchanged );
                    return productRepository.save( product );
                } ).flatMap( productSaved -> kafkaService.produceMessage(
                                ProductCreationMessage.builder()
                                        .productId( productSaved.getId() )
                                        .quantity( quantity )
                                        .build())
                        .then( Mono.just( productSaved ) ));
    }
}
