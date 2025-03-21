package integreation.configs;

import integreation.configs.tokenAuth.RetriveTokenAdmin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class Configs {

    private RetriveTokenAdmin retriveTokenAdmin;


    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl("http://localhost:8080/admin/realms/master/users")
                .build();
    }

}
