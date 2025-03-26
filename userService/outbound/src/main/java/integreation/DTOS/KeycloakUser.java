package integreation.DTOS;

import domain.User.Credentials;
import domain.enums.UserRoles;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Builder
@Data
@AllArgsConstructor
public class KeycloakUser {

    private final String username;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final List<Credentials> credentials;
    private final List<UserRoles> clientRoles;
    private final Map<String, List<String>> attributes;

    @Builder.Default
    private final Boolean enabled = true;

    @Builder.Default
    private Boolean emailVerified = false;
}

