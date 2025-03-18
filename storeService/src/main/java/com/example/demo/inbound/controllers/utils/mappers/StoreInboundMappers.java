package com.example.demo.inbound.controllers.utils.mappers;

import com.example.demo.domain.Store;
import com.example.demo.inbound.DTOS.requests.StoreCreationRequestDTO;

import java.util.UUID;

public class StoreInboundMappers {

    public static Store StoreCreationToDomain(StoreCreationRequestDTO storeCreationRequestDTO ) {

        return Store.StoreBuilder.Builder()
                .id( UUID.randomUUID().toString() )
                .ownerId( storeCreationRequestDTO.ownerId() )
                .name( storeCreationRequestDTO.name() )
                .description( storeCreationRequestDTO.description() )
                .address( storeCreationRequestDTO.address() )
                .city( storeCreationRequestDTO.city() )
                .state( storeCreationRequestDTO.state() )
                .build();
    }
}
