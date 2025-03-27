package com.example.demo.controller;

import com.example.demo.application.services.KafkaService;
import com.example.demo.application.utils.ProductServiceMappers;
import com.example.demo.controller.DTOS.requests.ProductCreationRequestDTO;
import com.example.demo.controller.DTOS.responses.ProductCreationResponseDTO;
import com.example.demo.domain.product.services.ProductServicePort;
import com.example.demo.outbound.Product.messages.config.ProductCreationMessage;
import lombok.Data;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping( "/product" )
@Data
public class ProductController {

    private final ProductServicePort productService;
    private final SecurityContext securityContext;
    private final KafkaService kafkaService;

    @PostMapping
    @PreAuthorize( "hasRole('STORE_ADMIN')" )
    public Mono<ProductCreationResponseDTO> createProduct( @RequestBody ProductCreationRequestDTO
                                                                        productCreationRequestDTO) {
        return securityContext.getUser()
                .flatMap( user ->
                        productService.createProduct(
                                ProductServiceMappers.productRequestToDomain( productCreationRequestDTO )
                                , user
                                , productCreationRequestDTO.quantity()
                        ))
                .map( ProductServiceMappers::domainToResponse );
    }

}
    