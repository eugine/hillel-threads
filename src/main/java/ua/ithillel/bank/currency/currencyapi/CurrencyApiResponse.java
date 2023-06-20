package ua.ithillel.bank.currency.currencyapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
public class CurrencyApiResponse {

    private Map<String, CurrencyApiData> data;

    @Data
    @NoArgsConstructor
    public static class CurrencyApiData {
        private String code;
        private Double value;
    }

}
