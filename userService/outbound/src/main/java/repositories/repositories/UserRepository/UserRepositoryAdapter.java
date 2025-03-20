package repositories.repositories.UserRepository;

import domain.User.User;
import domain.repositories.User.UserRepositoryPort;
import lombok.Data;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
import repositories.entities.User.UserEntity;
import repositories.mappers.UserRepositoryMappers;

@Repository
@Data
public class UserRepositoryAdapter implements UserRepositoryPort {

    private final UserRepository userRepository;

    @Override
    public Mono<Void> save( User user ) {

        UserEntity userConverted = UserRepositoryMappers.domainToEntity( user );

        return  userRepository.save( userConverted )
                .then();
    }
}
