package com.example.outbound.mappers.store;

import com.example.domain.Store.Store;
import com.example.outbound.repositories.Store.entities.StoreEntity;

public class StoreOutboundMappers {


    public static StoreEntity domainToStoreEntity( Store store ) {

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

    public static Store storeEntityToDomain( StoreEntity store ) {

        return Store.StoreBuilder.Builder()
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
