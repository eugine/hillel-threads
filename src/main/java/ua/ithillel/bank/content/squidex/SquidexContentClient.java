package ua.ithillel.bank.content.squidex;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Slf4j
@Component
public class SquidexContentClient {

    private final WebClient webClient;

    public SquidexContentClient() {
        var token = WebClient.create().post()
                .uri("https://cloud.squidex.io/identity-server/connect/token")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .body(BodyInserters.fromFormData("grant_type", "client_credentials")
                        .with("client_id", "hillel:development")
                        .with("client_secret", "9cmplvvlspjiwvfiqwcfyg8vydx6niredgc4vxgzevix")
                        .with("scope", "squidex-api")
                )
                .retrieve()
                .bodyToMono(Map.class)
                .block()
                .get("access_token");

        this.webClient = WebClient.builder()
                .defaultHeader("Authorization", "Bearer " + token)
                .build();

    }

    public String getContent() {
        Map response = webClient.get()
                .uri("https://cloud.squidex.io/api/content/hillel/demo/6a72cfba-2aa7-4aa6-a483-d543434f84cb")
                .retrieve()
                .bodyToMono(Map.class)
                .block();
        return ((Map) response.get("data")).get("json").toString();
    }

    public static void main(String[] args) {
        var client = new SquidexContentClient();

        log.info(client.getContent());
    }
}
