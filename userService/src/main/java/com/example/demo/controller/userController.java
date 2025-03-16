package com.example.demo.controller;


import com.example.demo.controller.DTOS.requests.UserCreationRequestDTO;
import com.example.demo.services.userService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/user")
@Data
public class userController {


    private final userService service;

    @PostMapping
    @ResponseStatus( HttpStatus.CREATED )
    public Mono<Void> createUser( @RequestBody UserCreationRequestDTO user ) {

        return service.createUser( user );

    }

}
