package integreation.mappers;



import domain.User;

import java.util.List;

public class UserIntegreationKeycloakMappers {

    public static KeycloakUser domainToKeycloakUser( User user ) {

        return KeycloakUser.builder()
                .username( user.getUsername() )
                .firstName( user.getFirstName() )
                .lastName( user.getLastName() )
                .email( user.getEmail() )
                .enabled( true )
                .emailVerified( false )
                .realmRoles( List.of( user.getRoles() ) )
                .build();
    }
}
