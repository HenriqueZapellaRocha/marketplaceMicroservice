package services;


import domain.User.User;
import domain.enums.UserRoles;
import integreation.DTOS.StoreCreationRequestDTO;
import integreation.integration.KeycloakIntegration;
import integreation.integration.StoreServiceIntegration;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import repository.mappers.UserRepositoryMappers;
import repository.repositories.UserRepository;


@Slf4j
@Data
@Service
public class userService {


    private final KeycloakIntegration keycloakIntegreation;
    private final UserRepository userRepository;
    private final StoreServiceIntegration storeServiceIntegration;

    public Mono<Void> createUser( User user ) {


        return keycloakIntegreation
                .createUser( user )
                .flatMap( userId -> {

                    user.setUserId( userId );

                    if( user.getRoles() == UserRoles.STORE_ADMIN ) {

                        return storeServiceIntegration.createStore(StoreCreationRequestDTO.builder()
                                .ownerId(user.getUserId())
                                .name(user.getStore().getName())
                                .description(user.getStore().getDescription())
                                .address(user.getStore().getAddress())
                                .city(user.getStore().getCity())
                                .state(user.getStore().getState())
                                .build())
                                .then(Mono.when(
                                        keycloakIntegreation.addRoleToUser( userId, user.getRoles() ),
                                        userRepository.save( UserRepositoryMappers.domainToEntity( user ) )
                                ));
                    }

                    return Mono.when(
                            keycloakIntegreation.addRoleToUser( userId, user.getRoles() ),
                            userRepository.save( UserRepositoryMappers.domainToEntity( user ) )
                    );

                } )
                .then();
    }
}
