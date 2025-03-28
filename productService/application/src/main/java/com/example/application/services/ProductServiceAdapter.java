package com.example.application.services;

import com.example.exchange.ExchangeServicePort;
import com.example.product.Product;
import com.example.product.ProductCreationMessage;
import com.example.product.repositories.ProductRepositoryPort;
import com.example.product.services.MessageServicePort;
import com.example.product.services.ProductServicePort;
import com.example.user.User;
import lombok.Data;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Data
public class ProductServiceAdapter implements ProductServicePort {

    private final ProductRepositoryPort productRepository;
    private final MessageServicePort messageService;
    private final ExchangeServicePort exchangeService;

    @Override
    public Mono<Product> createProduct( Product product, User userInfos, Integer quantity,
                                       String from, String to ) {

        product.setOwnerId( userInfos.getId() );

        return exchangeService.makeExchange( from, to , product.getPrice() )
                .flatMap( valueExchanged -> {
                    product.setPrice( valueExchanged );
                    return productRepository.save( product );
                } ).flatMap( productSaved -> messageService.produceMessage(
                                ProductCreationMessage.builder()
                                        .productId( productSaved.getId() )
                                        .quantity( quantity )
                                        .build())
                        .then( Mono.just( productSaved ) ));
    }
}
