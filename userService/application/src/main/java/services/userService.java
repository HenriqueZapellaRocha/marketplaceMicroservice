package services;


import domain.User.User;
import domain.exceptions.UserCreationException;
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

                    return Mono.when(
                            keycloakIntegreation.addRoleToUser( userId,  user.getRoles() ),
                            userRepository.save( UserRepositoryMappers.domainToEntity( user )) )
//                            storeServiceIntegration.createStore( user.getStore() ))
                ;} )
                .onErrorResume( e -> Mono.error( new UserCreationException( "error creating user" ) ) )
                .then();
    }
}
