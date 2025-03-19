package integreation.configs.tokenAuth;

import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Instant;

@Service
@Data
public class RetriveTokenAdmin {

    private WebClient webClient;
    private String token;
    private Instant tokenExpiration = Instant.MIN;

    public String getAdminToken() {



        return null;
    }



}
