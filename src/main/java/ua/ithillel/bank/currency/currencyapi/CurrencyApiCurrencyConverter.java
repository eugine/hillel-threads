package ua.ithillel.bank.currency.currencyapi;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import ua.ithillel.bank.currency.CurrencyConvert;
import ua.ithillel.bank.currency.MyCurrency;

import java.util.Currency;
import java.util.Map;

@Service
public class CurrencyApiCurrencyConverter implements CurrencyConvert {
    private final WebClient webClient;
    private final CurrencyApiProperties config;

    public CurrencyApiCurrencyConverter(CurrencyApiProperties config) {
        this.webClient = WebClient.builder().build();
        this.config = config;
    }

    @Override
    public double convert(MyCurrency from, Currency to, double amount) {

        try {
            var result = webClient.get()
                    .uri(config.getUrl(), uri -> uri.queryParam("apikey", config.getKey())
                            .queryParam("base_currency", from.value())
                            .queryParam("currencies", to.getCurrencyCode())
                            .build())
                    .retrieve()
                    .bodyToMono(CurrencyApiResponse.class)
                    .block();
            Double value = result.getData().get(to.getCurrencyCode()).getValue();
            return amount * value;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Currency conversion error");
        }
    }

}
