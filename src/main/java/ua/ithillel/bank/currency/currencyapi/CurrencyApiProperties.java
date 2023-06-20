package ua.ithillel.bank.currency.currencyapi;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@NoArgsConstructor
@Configuration
@ConfigurationProperties(prefix = "currencyapi")
public class CurrencyApiProperties {
    private String url;
    private String key;
}
