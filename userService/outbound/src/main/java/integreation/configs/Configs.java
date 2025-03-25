package integreation.configs;

import integreation.configs.tokenAuth.RetriveTokenAdmin;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@Configuration
@Data
public class Configs {

    private final RetriveTokenAdmin retriveTokenAdmin;


    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl("http://localhost:8080/admin/realms/master/users")
                .filter(((request, next) -> retriveTokenAdmin.getAdminToken()
                        .flatMap( retriveTokenAdmin -> {
                            log.info(retriveTokenAdmin.toString());
                    ClientRequest authorizedRequest = ClientRequest.from(request)
                            .header("Authorization", "Bearer " + retriveTokenAdmin)
                            .build();
                    return next.exchange(authorizedRequest);
                } )))
                .build();
    }

}
