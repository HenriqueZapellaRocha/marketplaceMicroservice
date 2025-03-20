package domain.repositories.User;

import domain.User.User;
import reactor.core.publisher.Mono;

public interface UserRepositoryPort {

    Mono<Void> save( User user );
}
