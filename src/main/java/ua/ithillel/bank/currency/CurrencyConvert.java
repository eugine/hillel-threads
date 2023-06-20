package ua.ithillel.bank.currency;


import java.util.Currency;

public interface CurrencyConvert {

    double convert(MyCurrency from, Currency to, double amount);

}
