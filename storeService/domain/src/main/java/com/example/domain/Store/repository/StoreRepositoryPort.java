package com.example.domain.Store.repository;

import com.example.domain.Store.Store;
import reactor.core.publisher.Mono;

public interface StoreRepositoryPort {

    Mono<Store> save( Store store );
}
