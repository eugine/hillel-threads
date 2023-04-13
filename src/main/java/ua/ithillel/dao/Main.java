package ua.ithillel.dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.postgresql.ds.PGSimpleDataSource;
import ua.ithillel.dao.student.StudentFactory;

import javax.sql.DataSource;

public class Main {

    public static void main(String[] args) {
//        var dataSource = dataSource();
        var dataSource = hikariDataSource();
        var service = StudentFactory.createService(dataSource);

//        service.findAll().forEach(System.out::println);

//        System.out.println(service.findById(2L).orElseThrow());
        System.out.println(service.findByName("John Doe"));
//        what is the issue with a string?

    }

    private static DataSource dataSource() {
        var ds = new PGSimpleDataSource();
//        ds.setServerNames(new String[]{"localhost"});
        ds.setDatabaseName("postgres");
        ds.setUser("hillel");
        ds.setPassword("hillel");
        return ds;
    }

    private static DataSource hikariDataSource() {
        var config = new HikariConfig();
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres");
        config.setUsername("hillel");
        config.setPassword("hillel");
        return new HikariDataSource(config);
    }
}
