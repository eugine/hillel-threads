package ua.ithillel.bank.currency;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Currency;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/currencies")
@RequiredArgsConstructor
public class CurrencyController {
    private final CurrencyConvert currencyConvert;

    @GetMapping("/convert")
    public Object convert(
            @RequestParam("from") MyCurrency from,
            @RequestParam("to") String to,
            @RequestParam("amount") double amount
    ) {
        var result = currencyConvert.convert(from, Currency.getInstance(to), amount);

        return Map.of("result", result);
    }

}
