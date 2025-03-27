package integreation.integration;

import com.fasterxml.jackson.databind.JsonNode;
import domain.User.User;
import domain.User.integration.keycloak.KeycloakIntegrationPort;
import domain.enums.UserRoles;
import integreation.DTOS.KeycloakUser;
import integreation.mappers.UserIntegrationKeycloakMappers;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import integreation.DTOS.RoleRequestDTO;
import repositories.mappers.UserRepositoryMappers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.net.URI;
import java.util.Optional;


@Slf4j
@Data
@Service
public class KeycloakIntegration implements KeycloakIntegrationPort {

    private final WebClient webClient = WebClient.builder().build();
    private Map<UserRoles, String> userRolesSaved;
    private final AuthenticationClientKeycloak authenticationClient;

    public Mono<String> createUser( User user ) {

        KeycloakUser keycloakUser = UserIntegrationKeycloakMappers.domainToKeycloakUserNoRoles( user );

        return authenticationClient.getAdminToken()
                        .flatMap( token -> webClient.post()
                                .uri("http://localhost:8080/admin/realms/master/users")
                                .contentType( MediaType.APPLICATION_JSON )
                                .header("Authorization", "Bearer " + token)
                                .bodyValue( keycloakUser )
                                .retrieve()
                                .toBodilessEntity()
                        )
                .map( this::extractUserIdFromLocationHeader );

    }

    private String extractUserIdFromLocationHeader(ResponseEntity<Void> responseEntity) {
        return Optional.ofNullable(responseEntity.getHeaders().getLocation())
                .map(URI::getPath)
                .map(location -> location.split("/users/"))
                .filter(locationSplitted -> locationSplitted.length == 2)
                .map(locationSplitted -> locationSplitted[1])
                .orElse(null);
    }

    public Mono<Void> deleteUser( User user ) {

        return authenticationClient.getAdminToken()
                .flatMap( token ->
                    webClient.delete()
                    .uri( "http://localhost:8080/admin/realms/{realm}/users/{id}", "master",
                                                                                                    user.getUserId() )
                            .header("Authorization", "Bearer " + token)
                    .retrieve()
                    .bodyToMono( Void.class ))
                .then();
    }

    private Mono<String> getRoleId( UserRoles roleName ) {

        if( userRolesSaved != null && userRolesSaved.containsKey( roleName ) ) {
            return Mono.just( userRolesSaved.get( roleName ) );
        }

        return authenticationClient.getAdminToken()
                .flatMap( token -> webClient.get()
                    .uri( "http://localhost:8080/admin/realms/{realm}/roles/{roleName}", "master",
                                                                                                            roleName )
                        .header( "Authorization", "Bearer " + token )
                    .retrieve()
                    .bodyToMono( JsonNode.class )
                    .map( roleJson -> {

                        String roleId = roleJson.get( "id" ).asText();

                        if ( userRolesSaved == null ) {
                            userRolesSaved = new HashMap<>();
                        }

                        userRolesSaved.put( roleName, roleId );

                        return roleId;

                }));
    }

    public Mono<Void> addRoleToUser( String userId, UserRoles roleName ) {

        return getRoleId( roleName )
                .flatMap( roleId -> {

                    List<RoleRequestDTO> request = List.of( UserRepositoryMappers
                            .valuesToRoleRequestDTO( roleId, roleName ) );


                    return authenticationClient.getAdminToken()
                            .flatMap( token -> webClient.post()
                                .uri( "http://localhost:8080/admin/realms/{realm}/users/{userId}/role-mappings/realm",
                                        "master", userId )
                                    .header( "Authorization", "Bearer " + token )
                                .bodyValue( request )
                                .retrieve()
                                .toBodilessEntity() )
                            .then();

        } );
    }



}
