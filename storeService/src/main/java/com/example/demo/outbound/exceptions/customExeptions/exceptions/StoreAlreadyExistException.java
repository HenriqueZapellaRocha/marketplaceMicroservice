package com.example.demo.outbound.exceptions.customExeptions.exceptions;

public class StoreAlreadyExistException extends RuntimeException {

    public StoreAlreadyExistException( String message ) {
        super(message);
    }
}
