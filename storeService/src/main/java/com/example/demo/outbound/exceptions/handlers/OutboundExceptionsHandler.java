package com.example.demo.outbound.exceptions.handlers;

import com.example.demo.outbound.exceptions.customExeptions.StoreAlreadyExistDTO;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import reactor.core.publisher.Mono;

@RestControllerAdvice
public class OutboundExceptionsHandler {

    @ExceptionHandler( DuplicateKeyException.class )
    @ResponseStatus( HttpStatus.CONFLICT )
    public Mono<StoreAlreadyExistDTO> storeAlreadyExistException( DuplicateKeyException e ) {
        return Mono.just( new StoreAlreadyExistDTO( "Store already exist" ) );
    }
}
