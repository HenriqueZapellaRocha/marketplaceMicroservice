package com.example.demo.controller;

import com.example.demo.application.utils.ProductServiceMappers;
import com.example.demo.controller.DTOS.requests.ProductCreationRequestDTO;
import com.example.demo.controller.DTOS.responses.ProductCreationResponseDTO;
import com.example.demo.domain.product.services.ProductServicePort;
import lombok.Data;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
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
    private final SecurityContext securityContext;

    @PostMapping
    @PreAuthorize( "hasRole('STORE_ADMIN')" )
    public Mono<ProductCreationResponseDTO> createProduct( @RequestBody ProductCreationRequestDTO
                                                                        productCreationRequestDTO) {
        return securityContext.getUser()
                .flatMap( user ->
                        productService.createProduct(
                                ProductServiceMappers.productRequestToDomain( productCreationRequestDTO ), user
                        )
                )
                .map( ProductServiceMappers::domainToResponse );
    }

}
