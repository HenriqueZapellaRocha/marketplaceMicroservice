package inbound.controllers;

import com.example.domain.Store.Store;
import com.example.domain.Store.Store.services.StoreServicePort;
import inbound.DTOS.requests.StoreCreationRequestDTO;
import inbound.controllers.utils.mappers.StoreInboundMappers;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping( "/store" )
@Data
public class StoreController {

    private final StoreServicePort storeService;

    @PostMapping
    @ResponseStatus( value = HttpStatus.CREATED )
    public Mono<Store> createStore(@RequestBody StoreCreationRequestDTO storeCreationRequestDTO ) {

        Store domainStore = StoreInboundMappers.StoreCreationToDomain( storeCreationRequestDTO );

        return  storeService.createStore( domainStore );
    }

}
