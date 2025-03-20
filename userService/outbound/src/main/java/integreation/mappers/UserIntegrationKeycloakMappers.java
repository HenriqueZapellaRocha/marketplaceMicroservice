package integreation.mappers;

import domain.User.User;

import java.util.List;

public class UserIntegrationKeycloakMappers {

    public static KeycloakUser domainToKeycloakUserNoRoles( User user ) {

        return KeycloakUser.builder()
                .username( user.getUsername() )
                .firstName( user.getFirstName() )
                .lastName( user.getLastName() )
                .email( user.getEmail() )
                .enabled( true )
                .emailVerified( false )
                .build();
    }

    public static KeycloakUser domainToKeycloakUserWithRoles( User user ) {

        return KeycloakUser.builder()
                .username( user.getUsername() )
                .firstName( user.getFirstName() )
                .lastName( user.getLastName() )
                .email( user.getEmail() )
                .enabled( true )
                .emailVerified( false )
                .clientRoles( List.of( user.getRoles() ) )
                .build();
    }
}
