package ua.ithillel.utils;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;

public class DataSourceUtils {

    public static DataSource dataSource() {
        var ds = new PGSimpleDataSource();
        ds.setDatabaseName("hillel");
        ds.setUser("hillel");
        ds.setPassword("hillel");
        return ds;
    }

    public static DataSource hikariDataSource() {
        var config = new HikariConfig();
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/hillel");
        config.setUsername("hillel");
        config.setPassword("hillel");
        return new HikariDataSource(config);
    }
}
