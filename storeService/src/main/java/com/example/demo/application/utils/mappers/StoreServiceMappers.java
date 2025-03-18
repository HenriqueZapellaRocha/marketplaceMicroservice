package com.example.demo.application.utils.mappers;

import com.example.demo.domain.Store;
import com.example.demo.outbound.entities.Store.StoreEntity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

public class StoreServiceMappers {

    public static Store entityToDomain(StoreEntity storeEntity ) {
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

    public static StoreEntity domainToEntity(Store store ) {
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
