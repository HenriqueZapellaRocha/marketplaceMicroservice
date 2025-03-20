package domain.User.integration.keycloak;

import domain.User.User;
import domain.enums.UserRoles;
import reactor.core.publisher.Mono;

public interface KeycloakIntegrationPort {

    public Mono<String> createUser( User user );

    public Mono<Void> deleteUser( User user );

    public Mono<Void> addRoleToUser( String userId, UserRoles roleName );
}
