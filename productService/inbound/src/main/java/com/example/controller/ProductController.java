package com.example.controller;

import com.example.controller.DTOS.requests.ProductCreationRequestDTO;
import com.example.controller.DTOS.responses.ProductCreationResponseDTO;
import com.example.product.services.MessageServicePort;
import com.example.product.services.ProductServicePort;
import com.example.utils.ProductServiceMappers;
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
    private final MessageServicePort messageService;

    @PostMapping( "/{from}/{to}" )
    @PreAuthorize( "hasRole('STORE_ADMIN')" )
    public Mono<ProductCreationResponseDTO> createProduct( @RequestBody ProductCreationRequestDTO
                                                                        productCreationRequestDTO,
                                                           @PathVariable String from,
                                                           @PathVariable String to                 ) {
        return securityContext.getUser()
                .flatMap( user ->
                        productService.createProduct(
                                ProductServiceMappers.productRequestToDomain( productCreationRequestDTO )
                                , user
                                , productCreationRequestDTO.quantity()
                                , from
                                ,to
                        ))
                .map( ProductServiceMappers::domainToResponse );
    }

}
    