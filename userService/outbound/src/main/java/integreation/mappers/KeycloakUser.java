package integreation.mappers;

import lombok.Builder;

import java.util.List;

@Builder
public record KeycloakUser(

        String username,
        String firstName,
        String lastName,
        String email,
        List<String> realmRoles,
        Boolean enabled,
        Boolean emailVerified

) {
}
