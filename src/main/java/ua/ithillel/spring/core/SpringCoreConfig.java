package ua.ithillel.spring.core;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("ua.ithillel.spring.core")
@PropertySource("classpath:application.properties")
public class SpringCoreConfig {

    @Value("${my.property}")
    private String myProperty;

}
