package integreation.mappers;

import domain.Store.Store;
import integreation.DTOS.StoreCreationRequestDTO;

public class StoreOutboundMappers {

    public static StoreCreationRequestDTO domainToStoreCreationDTO( Store store, String ownerId ) {

        return StoreCreationRequestDTO.builder()
                .ownerId( ownerId )
                .name( store.getName() )
                .description( store.getDescription() )
                .address( store.getAddress() )
                .city( store.getCity() )
                .state( store.getState() )
                .build();
    }
}
