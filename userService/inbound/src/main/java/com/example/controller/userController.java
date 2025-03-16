package com.example.controller;


import com.example.controller.DTOS.requests.UserCreationRequestDTO;
import com.example.controller.mappers.UserInboundMappers;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import services.userService;

@RestController
@RequestMapping("/user")
@Data
public class userController {


    private final userService service;

    @PostMapping
    @ResponseStatus( HttpStatus.CREATED )
    public Mono<Void> createUser( @RequestBody UserCreationRequestDTO user ) {

        return service.createUser( UserInboundMappers.requestToDomain( user ) );

    }

}
