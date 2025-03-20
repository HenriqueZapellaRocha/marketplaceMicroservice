package services;


import domain.User.User;
import domain.enums.UserRoles;
import domain.exceptions.UserCreationException;
import integreation.integration.KeycloakIntegration;
import integreation.integration.StoreServiceIntegration;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import repositories.mappers.UserRepositoryMappers;
import repositories.repositories.UserRepository.UserRepository;


@Slf4j
@Data
@Service
public class userService {


    private final KeycloakIntegration keycloakIntegration;
    private final UserRepository userRepository;
    private final StoreServiceIntegration storeServiceIntegration;

    public Mono<Void> createUser( User user ) {


        return keycloakIntegration
                .createUser( user )
                .flatMap( userId -> {

                    user.setUserId( userId );

                    if( user.getRoles() == UserRoles.STORE_ADMIN ) {

                        return storeServiceIntegration.createStore( user.getStore(), userId )
                                .onErrorResume( e ->
                                         keycloakIntegration.deleteUser( user )
                                        .then( Mono.error( new UserCreationException( "store already exist" ) ) )
                                )
                                .then( Mono.when(
                                        keycloakIntegration.addRoleToUser( userId, user.getRoles() ),
                                        userRepository.save( UserRepositoryMappers.domainToEntity( user ) )
                                ));
                    }

                    return Mono.when(
                            keycloakIntegration.addRoleToUser( userId, user.getRoles() ),
                            userRepository.save( UserRepositoryMappers.domainToEntity( user ) )
                    );

                } )
                .then();
    }
}
