package ua.ithillel.bank.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ua.ithillel.bank.currency.MyCurrencyHandlerMethodArgumentResolver;

import java.util.List;

@Configuration
public class MyCurrencyHandlerMethodArgumentResolverConfiguration implements WebMvcConfigurer {
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new MyCurrencyHandlerMethodArgumentResolver());
    }
}
