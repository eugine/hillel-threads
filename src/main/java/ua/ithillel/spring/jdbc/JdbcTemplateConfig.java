package ua.ithillel.spring.jdbc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import ua.ithillel.utils.DataSourceUtils;

import javax.sql.DataSource;

@Configuration
@ComponentScan("ua.ithillel.spring.jdbc")
public class JdbcTemplateConfig {

    @Bean
    public DataSource dataSource() {
        return DataSourceUtils.hikariDataSource();
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

}
