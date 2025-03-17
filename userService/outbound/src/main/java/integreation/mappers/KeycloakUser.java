package integreation.mappers;

import domain.enums.UserRoles;
import lombok.Builder;

import java.util.List;

@Builder
public record KeycloakUser(

        String username,
        String firstName,
        String lastName,
        String email,
        List<UserRoles> clientRoles,
        Boolean enabled,
        Boolean emailVerified

) {
}
