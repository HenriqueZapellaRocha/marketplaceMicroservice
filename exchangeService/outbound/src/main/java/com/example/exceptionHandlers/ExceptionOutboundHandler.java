package com.example.exceptionHandlers;

import com.example.exceptions.CurrencyNotFoundException;
import com.example.integration.DTOS.responses.CurrencyNotFoundDTO;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.core.publisher.Mono;

@ControllerAdvice
public class ExceptionOutboundHandler {

    @ExceptionHandler( CurrencyNotFoundException.class )
    @ResponseBody
    public Mono<CurrencyNotFoundDTO> handleException( CurrencyNotFoundException e ) {
        return Mono.just( new CurrencyNotFoundDTO( e.getMessage() ) );
    }
}
