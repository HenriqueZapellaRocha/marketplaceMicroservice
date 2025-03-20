package services;


import domain.Store.integration.StoreServiceIntegrationPort;
import domain.User.User;
import domain.User.integration.keycloak.KeycloakIntegrationPort;
import domain.User.repository.UserRepositoryPort;
import domain.enums.UserRoles;
import domain.exceptions.UserCreationException;
import integreation.configs.tokenAuth.RetriveTokenAdmin;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;


@Slf4j
@Data
@Service
public class userService {


    private final KeycloakIntegrationPort keycloakIntegration;
    private final UserRepositoryPort userRepository;
    private final StoreServiceIntegrationPort storeServiceIntegration;
    private final RetriveTokenAdmin retriveTokenAdmin;

    public Mono<Void> createUser( User user ) {

        retriveTokenAdmin.getAdminToken();

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
                                        userRepository.save( user )
                                ));
                    }

                    return Mono.when(
                            keycloakIntegration.addRoleToUser( userId, user.getRoles() ),
                            userRepository.save( user )
                    );

                } )
                .then();
    }
}
