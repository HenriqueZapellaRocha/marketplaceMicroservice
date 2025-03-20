package com.example.application.utils.mappers;


import com.example.domain.Store.Store;
import com.example.outbound.repositories.Store.entities.StoreEntity;

public class StoreServiceMappers {

    public static Store entityToDomain( StoreEntity storeEntity ) {

        return Store.StoreBuilder.Builder()
                .id( storeEntity.getId() )
                .ownerId( storeEntity.getOwnerId() )
                .name( storeEntity.getName() )
                .description( storeEntity.getDescription() )
                .address( storeEntity.getAddress() )
                .city( storeEntity.getCity() )
                .state( storeEntity.getState() )
                .build();

    }

    public static StoreEntity domainToEntity( Store store ) {
        return StoreEntity.builder()
                .id( store.getId() )
                .ownerId( store.getOwnerId() )
                .name( store.getName() )
                .description( store.getDescription() )
                .address( store.getAddress() )
                .city( store.getCity() )
                .state( store.getState() )
                .build();

    }
}
