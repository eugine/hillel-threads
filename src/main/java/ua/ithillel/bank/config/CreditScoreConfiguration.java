package ua.ithillel.bank.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.ithillel.bank.credit.score.CreditScoreService;
import ua.ithillel.bank.credit.score.DummyCreditScoreService;
import ua.ithillel.bank.credit.score.SquidexCreditScoreService;

@Configuration
public class CreditScoreConfiguration {

    @Configuration
    @ConditionalOnProperty(name = "credit.score.provider", havingValue = "squidex")
    public static class SquidexCreditScoreConfiguration {
        @Bean
        public CreditScoreService creditScoreService(SquidexProperties squidexProperties) {
            return new SquidexCreditScoreService(squidexProperties);
        }
    }

    @Configuration
    @ConditionalOnProperty(name = "credit.score.provider", havingValue = "dummy")
    public static class DummyCreditScoreConfiguration {
        @Bean
        public CreditScoreService creditScoreService() {
            return new DummyCreditScoreService();
        }
    }


}
