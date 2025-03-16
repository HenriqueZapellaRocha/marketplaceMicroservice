package services;

import com.example.demo.controller.DTOS.requests.UserCreationRequestDTO;
import com.example.demo.domain.User;
import com.example.demo.integreation.integration.KeycloakIntegration;
import com.example.demo.repository.entities.UserEntity;
import com.example.demo.repository.mappers.UserRepositoryMappers;
import com.example.demo.repository.repositories.UserRepository;
import services.mappers.UserServiceMappers;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;


@Slf4j
@Data
@Service
public class userService {


    private final KeycloakIntegration keycloakIntegreation;
    private final UserRepository userRepository;

    public Mono<Void> createUser( UserCreationRequestDTO user ) {

        User domainUser = UserServiceMappers.requestToDomain( user );

        return keycloakIntegreation
                .createUser( domainUser )
                .flatMap( userId -> {

                    domainUser.setUserId( userId );
                    UserEntity userEntity = UserRepositoryMappers.domainToEntity( domainUser );



                    Mono<UserEntity> saved = userRepository.save( userEntity );

// Log dentro do fluxo reativo, sem bloqueio
                    return saved.doOnSuccess(savedEntity ->
                            log.info("User saved: " + savedEntity.toString())
                    );



                } )
                .then();

    }
}
