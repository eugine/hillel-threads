package ua.ithillel.rest;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ua.ithillel.dao.student.StudentFactory;
import ua.ithillel.dao.student.StudentService;

import javax.sql.DataSource;

@SpringBootApplication
public class RestApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class, args);
    }

    @Bean
    public StudentService studentService() {
        return StudentFactory.createService(hikariDataSource());
    }

    private static DataSource hikariDataSource() {
        var config = new HikariConfig();
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/hillel");
        config.setUsername("hillel");
        config.setPassword("hillel");
        return new HikariDataSource(config);
    }

}
