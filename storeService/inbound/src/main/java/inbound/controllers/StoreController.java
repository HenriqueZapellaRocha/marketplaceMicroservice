package inbound.controllers;

import com.example.domain.Store.Store;
import com.example.domain.Store.services.StoreServicePort;
import inbound.DTOS.requests.StoreCreationRequestDTO;
import inbound.controllers.utils.mappers.StoreInboundMappers;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping( "/store" )
@Data
@Slf4j
public class StoreController {

    private final StoreServicePort storeService;

    @PostMapping
    @ResponseStatus( value = HttpStatus.CREATED )
    public Mono<Store> createStore(@RequestBody StoreCreationRequestDTO storeCreationRequestDTO ) {
        log.info("toaqui");
        Store domainStore = StoreInboundMappers.StoreCreationToDomain( storeCreationRequestDTO );

        return storeService.createStore( domainStore );
    }

}
