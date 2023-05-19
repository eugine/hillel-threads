package ua.ithillel.spring.jdbc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTemplateExample {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(JdbcTemplateConfig.class);

        var jdbcTemplate = context.getBean(JdbcTemplate.class);
        var result = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM students", Integer.class);
        System.out.println(result);
    }
}
