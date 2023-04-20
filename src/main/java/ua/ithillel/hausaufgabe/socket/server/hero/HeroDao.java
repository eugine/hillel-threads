package ua.ithillel.hausaufgabe.socket.server.hero;

import java.util.List;

public interface HeroDao {

    List<Hero> findAll();
    List<Hero> findByName(String name);
    void create(Hero hero);
    void update(Hero hero);
    boolean delete(Integer id);
}
