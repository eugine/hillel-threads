package ua.ithillel.spring.mvc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.ithillel.dao.student.StudentFactory;
import ua.ithillel.dao.student.StudentService;
import ua.ithillel.utils.DataSourceUtils;

import javax.sql.DataSource;

@Configuration
public class SpringMvcConfig {

    @Bean
    public StudentService studentService() {
        return StudentFactory.createService(datasource());
    }

    @Bean
    public DataSource datasource() {
        return DataSourceUtils.hikariDataSource();
    }


}
