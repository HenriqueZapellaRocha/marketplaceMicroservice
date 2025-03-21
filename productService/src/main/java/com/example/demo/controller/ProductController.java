package com.example.demo.controller;

import com.example.demo.application.utils.ProductServiceMappers;
import com.example.demo.controller.DTOS.requests.ProductCreationRequestDTO;
import com.example.demo.controller.DTOS.responses.ProductCreationResponseDTO;
import com.example.demo.domain.product.services.ProductServicePort;
import lombok.Data;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping( "/product" )
@Data
public class ProductController {

    private final ProductServicePort productService;

    @PostMapping
    public Mono<ProductCreationResponseDTO> createProduct( @RequestBody ProductCreationRequestDTO
                                                                       productCreationtRequestDTO ) {
        return productService.createProduct( ProductServiceMappers.productRequestToDomain( productCreationtRequestDTO ) )
                .map( ProductServiceMappers::domainToResponse );
    }

}
