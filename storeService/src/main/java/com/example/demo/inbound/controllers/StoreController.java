package com.example.demo.inbound.controllers;


import com.example.demo.application.StoreService;
import com.example.demo.domain.Store;
import com.example.demo.inbound.DTOS.requests.StoreCreationRequestDTO;
import com.example.demo.inbound.controllers.utils.mappers.StoreInboundMappers;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping( "/store" )
@Data
public class StoreController {

    private final StoreService storeService;

    @PostMapping
    @ResponseStatus( value = HttpStatus.CREATED )
    public Mono<Store> createStore( @RequestBody StoreCreationRequestDTO storeCreationRequestDTO ) {

        Store domainStore = StoreInboundMappers.StoreCreationToDomain( storeCreationRequestDTO );

        return  storeService.createStore( domainStore );
    }

}
