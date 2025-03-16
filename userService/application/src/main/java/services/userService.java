package services;


import domain.User;
import integreation.integration.KeycloakIntegration;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import repository.entities.UserEntity;
import repository.mappers.UserRepositoryMappers;
import repository.repositories.UserRepository;


@Slf4j
@Data
@Service
public class userService {


    private final KeycloakIntegration keycloakIntegreation;
    private final UserRepository userRepository;

    public Mono<Void> createUser( User user ) {


        return keycloakIntegreation
                .createUser( user )
                .flatMap( userId -> {

                    user.setUserId( userId );
                    UserEntity userEntity = UserRepositoryMappers.domainToEntity( user );



                    Mono<UserEntity> saved = userRepository.save( userEntity );

                    return saved.doOnSuccess(savedEntity ->
                            log.info("User saved: " + savedEntity.toString())
                    );



                } )
                .then();

    }
}
