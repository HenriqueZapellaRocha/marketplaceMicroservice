package com.example.demo.controller;

import com.example.demo.controller.DTOS.requests.ProductCreationtRequestDTO;
import com.example.demo.controller.DTOS.responses.ProductCreationResponseDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/product" )
public class ProductController {


    public ProductCreationResponseDTO createProduct( ProductCreationtRequestDTO productCreationtRequestDTO ) {
        return null;
    }

}
