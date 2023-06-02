package ua.ithillel.bank.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Configuration
@ConfigurationProperties(prefix = "squidex")
public class SquidexProperties {
    private String url;

    private String tokenUrl;
    private String clientId;
    private String clientSecret;

}
