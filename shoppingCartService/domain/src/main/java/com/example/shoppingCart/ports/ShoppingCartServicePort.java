package com.example.shoppingCart.ports;

import com.example.shoppingCart.ShoppingCart;
import reactor.core.publisher.Mono;

public interface ShoppingCartServicePort {

    Mono<ShoppingCart> createCart( ShoppingCart shoppingCart );

    Mono<ShoppingCart> finishCart( ShoppingCart shoppingCart );
}
