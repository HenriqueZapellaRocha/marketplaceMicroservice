package integreation.mappers;

import domain.User.User;
import integreation.DTOS.KeycloakUser;

import java.util.List;
import java.util.Map;

public class UserIntegrationKeycloakMappers {

    public static KeycloakUser domainToKeycloakUserNoRoles( User user ) {

        return KeycloakUser.builder()
                .username( user.getUsername() )
                .firstName( user.getFirstName() )
                .lastName( user.getLastName() )
                .email( user.getEmail() )
                .credentials( List.of( user.getCredentials() ) )
                .attributes( Map.of(
                        "country",List.of( user.getCountry() ),
                        "city", List.of( user.getCity() ),
                        "cpf", List.of( user.getCpf() )
                ) )
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
