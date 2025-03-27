package com.example.domain.Store.services;

import com.example.domain.Store.Store;
import reactor.core.publisher.Mono;

public interface StoreServicePort {

    public Mono<Store> createStore( Store store );
    public Mono<Store> getStoreIByOwnerId( String ownerId );
}
