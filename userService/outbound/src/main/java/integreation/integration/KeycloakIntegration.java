package integreation.integration;



import com.fasterxml.jackson.databind.JsonNode;
import domain.User.User;
import domain.enums.UserRoles;
import domain.exceptions.UserCreationException;
import integreation.configs.Configs;
import integreation.mappers.KeycloakUser;
import integreation.mappers.UserIntegreationKeycloakMappers;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import repository.entities.User.RoleRequestDTO;
import repository.mappers.UserRepositoryMappers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Slf4j
@Data
@Service
public class KeycloakIntegration {

    private final WebClient webClient;
    private Map<UserRoles, String> userRolesSaved;

    public Mono<String> createUser( User user ) {

        KeycloakUser keycloakUser = UserIntegreationKeycloakMappers.domainToKeycloakUserNoRoles( user );

        return webClient.post()
                .contentType( MediaType.APPLICATION_JSON )
                .bodyValue( keycloakUser )
                .exchangeToMono( clientResponse -> {

                    if( clientResponse.statusCode() != HttpStatus.CREATED )
                        return Mono.error( new RuntimeException( "Error creating user" ) );

                    String headerIdUser = clientResponse.headers()
                            .asHttpHeaders()
                            .getFirst( "Location" );


                    if( headerIdUser == null )
                        return  Mono.empty();

                    String regex = "[^/]+$";


                    Pattern pattern = Pattern.compile(regex);
                    Matcher matcher = pattern.matcher(headerIdUser);

                    if( matcher.find() ) {

                        String lastPart = matcher.group();

                        return Mono.just( lastPart );
                    }
                    else {
                        return Mono.empty();
                    }


                } ).onErrorResume( e -> Mono.error( new UserCreationException( "Error creating user" ) ) );
    }

    public Mono<String> getRoleId( UserRoles roleName ) {

        if( userRolesSaved != null && userRolesSaved.containsKey( roleName ) ) {
            return Mono.just( userRolesSaved.get( roleName ) );
        }

        return webClient.get()
                .uri("http://localhost:8080/admin/realms/{realm}/roles/{roleName}", "master", roleName )
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + Configs.getToken())
                .retrieve()
                .bodyToMono( JsonNode.class )
                .map( roleJson -> {

                    String roleId = roleJson.get("id").asText();

                    if (userRolesSaved == null) {
                        userRolesSaved = new HashMap<>();
                    }

                    userRolesSaved.put(roleName, roleId);

                    return roleId;

                });
    }

    public Mono<Void> addRoleToUser( String userId, UserRoles roleName ) {

        return getRoleId( roleName )
                .flatMap( roleId -> {

                    List<RoleRequestDTO> request = List.of( UserRepositoryMappers
                            .valuesToRoleRequestDTO( roleId, roleName ) );


            return webClient.post()
                    .uri("http://localhost:8080/admin/realms/{realm}/users/{userId}/role-mappings/realm",
                            "master", userId)
                    .header(HttpHeaders.AUTHORIZATION, "Bearer " + Configs.getToken())
                    .bodyValue( request )
                    .retrieve()
                    .toBodilessEntity()
                    .then();

        } );
    }



}
