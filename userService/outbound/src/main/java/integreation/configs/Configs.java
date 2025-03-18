package integreation.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class Configs {

    private static final String meuToken = "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJVY0RfV1U4Q2FHbXJIMjhNY0h1T1B5VG0xX255LWx2eEtndHh5cjhMX2hNIn0.eyJleHAiOjE3NDIzNDM1NDMsImlhdCI6MTc0MjMwNzU0MywianRpIjoiM2Q3NGY2OTUtZjhkZC00NDU5LThiMmEtNzk5ZDM3YjMzMGFkIiwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDo4MDgwL3JlYWxtcy9tYXN0ZXIiLCJhdWQiOlsibWFzdGVyLXJlYWxtIiwiYWNjb3VudCJdLCJzdWIiOiJhM2QzOGQ4Ni03YWVlLTQ4N2ItYWNjMy0zNjhlMWRhN2VhNmEiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJjcmVhdGVVc2VyIiwiYWNyIjoiMSIsImFsbG93ZWQtb3JpZ2lucyI6WyIvKiJdLCJyZWFsbV9hY2Nlc3MiOnsicm9sZXMiOlsiY3JlYXRlLXJlYWxtIiwiZGVmYXVsdC1yb2xlcy1tYXN0ZXIiLCJvZmZsaW5lX2FjY2VzcyIsImFkbWluIiwidW1hX2F1dGhvcml6YXRpb24iXX0sInJlc291cmNlX2FjY2VzcyI6eyJjcmVhdGVVc2VyIjp7InJvbGVzIjpbInVtYV9wcm90ZWN0aW9uIl19LCJtYXN0ZXItcmVhbG0iOnsicm9sZXMiOlsidmlldy1pZGVudGl0eS1wcm92aWRlcnMiLCJ2aWV3LXJlYWxtIiwibWFuYWdlLWlkZW50aXR5LXByb3ZpZGVycyIsImltcGVyc29uYXRpb24iLCJjcmVhdGUtY2xpZW50IiwibWFuYWdlLXVzZXJzIiwicXVlcnktcmVhbG1zIiwidmlldy1hdXRob3JpemF0aW9uIiwicXVlcnktY2xpZW50cyIsInF1ZXJ5LXVzZXJzIiwibWFuYWdlLWV2ZW50cyIsIm1hbmFnZS1yZWFsbSIsInZpZXctZXZlbnRzIiwidmlldy11c2VycyIsInZpZXctY2xpZW50cyIsIm1hbmFnZS1hdXRob3JpemF0aW9uIiwibWFuYWdlLWNsaWVudHMiLCJxdWVyeS1ncm91cHMiXX0sImFjY291bnQiOnsicm9sZXMiOlsibWFuYWdlLWFjY291bnQiLCJtYW5hZ2UtYWNjb3VudC1saW5rcyIsInZpZXctcHJvZmlsZSJdfX0sInNjb3BlIjoiZW1haWwgcHJvZmlsZSIsImNsaWVudEhvc3QiOiIxNzIuMjEuMC4xIiwiZW1haWxfdmVyaWZpZWQiOmZhbHNlLCJwcmVmZXJyZWRfdXNlcm5hbWUiOiJzZXJ2aWNlLWFjY291bnQtY3JlYXRldXNlciIsImNsaWVudEFkZHJlc3MiOiIxNzIuMjEuMC4xIiwiY2xpZW50X2lkIjoiY3JlYXRlVXNlciJ9.DL5SCs4d4vPf56SDex4GT-P8n-diOX7svyBCxabhe1bMP8-rNUlAiMxwY4ku_4R0srWCXLL1HNcsfTF8qD6DXOKsg446bE3k5xKRKI_7cf3M3z_YZwmZH6td1AzMaDWcqZ4A-pBmWLZ8Vr1j7Pi2FIAvUFDNJWuNuBIAwg2klWZ1zfWvZl-sUm8En57Od_mOdRdqrDDG2BiI5efpuQtEeyfwquUT9Yv23-lyfpwU0wu1AUimgrgxW8ZbMY9pewULHJyZ9CPqeFX-0g8I9xDUvWhLATrnPgaY_TNEU_Plc0dTi69DQd24L50n0V6fitqIlPNkIqswA9Ip-4JQ1vAifg";
    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl("http://localhost:8080/admin/realms/master/users")
                .defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + meuToken)
                .build();
    }

    public static String getToken() {
        return meuToken;
    }
}
