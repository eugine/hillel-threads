package ua.ithillel.bank.credit.score;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import ua.ithillel.bank.config.SquidexProperties;
import ua.ithillel.bank.credit.score.model.SquidexResponse;

import java.util.Map;

@Slf4j
public class SquidexCreditScoreService implements CreditScoreService {

    private final SquidexProperties props;
    private WebClient webClient;

    public SquidexCreditScoreService(SquidexProperties props) {
        this.props = props;
    }

    private WebClient getWebClient() {
        if (webClient == null) {
            var token = getToken(props);

            this.webClient = WebClient.builder()
                    .defaultHeader("Authorization", "Bearer " + token)
                    .build();
        }
        return webClient;
    }

    private Object getToken(SquidexProperties props) {
        return WebClient.create().post()
                .uri(props.getTokenUrl())
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .body(BodyInserters.fromFormData("grant_type", "client_credentials")
                        .with("client_id", props.getClientId())
                        .with("client_secret", props.getClientSecret())
                        .with("scope", "squidex-api")
                )
                .retrieve()
                .bodyToMono(Map.class)
                .block()
                .get("access_token");
    }

    @Override
    public int getScore(String personId) {
        log.info("Getting score from squidex");
        //TODO: implement personId to squidex id mapping
        var resourceId = "2bd7d78c-8763-480a-8492-38287bdc7d39";

        var result = getWebClient().get()
                .uri(props.getUrl() + "/" + resourceId)
                .retrieve()
                .bodyToMono(SquidexResponse.class)
                .block();

        return result.getData().getScore().getIv();
    }

}
