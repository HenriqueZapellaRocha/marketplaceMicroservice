package inbound.controllers.utils.mappers;


import com.example.domain.Store.Store;
import inbound.DTOS.requests.StoreCreationRequestDTO;
import inbound.DTOS.response.StoreOwnerInfoResponseDTO;

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

    public static StoreOwnerInfoResponseDTO domainToStoreOwnerInfoResponseDTO( Store store ) {

        return StoreOwnerInfoResponseDTO.builder()
                .ownerId( store.getOwnerId() )
                .build();
    }
}
