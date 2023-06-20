package ua.ithillel.bank.currency;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Currency;

@Slf4j
//@Component
public class DummyCurrencyConverter implements CurrencyConvert{

    @Override
    public double convert(MyCurrency from, Currency to, double amount) {
        log.info("Converting {} {} to {}", amount, from.value(), to.getCurrencyCode());
        return 101;
    }

}
