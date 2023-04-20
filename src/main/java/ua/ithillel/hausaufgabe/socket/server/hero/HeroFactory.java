package ua.ithillel.hausaufgabe.socket.server.hero;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.sql.DataSource;

public class HeroFactory {

    public static HeroService createService(DataSource dataSource) {
        return new HeroService(new HeroDaoImpl(dataSource), new HeroMapper());
    }
}
