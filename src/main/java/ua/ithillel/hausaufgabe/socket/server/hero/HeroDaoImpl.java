package ua.ithillel.hausaufgabe.socket.server.hero;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class HeroDaoImpl implements HeroDao {
    private final DataSource dataSource;

    @Override
    public List<Hero> findAll() {
        var sql = "select * from heroes";
        try (var connection = dataSource.getConnection();
             var statement = connection.createStatement()) {
            var result = statement.executeQuery(sql);
            return mapHeroes(result);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Hero> mapHeroes(ResultSet result) throws SQLException {
        var heroes = new ArrayList<Hero>();
        while (result.next()) {
            heroes.add(Hero.builder()
                    .id(result.getInt("id"))
                    .name(result.getString("name"))
                    .gender(result.getString("gender"))
                    .eyeColor(result.getString("eye_color"))
                    .race(result.getString("race"))
                    .hairColor(result.getString("hair_color"))
                    .height(result.getInt("height"))
                    .publisher(result.getString("publisher"))
                    .skinColor(result.getString("skin_color"))
                    .alignment(result.getString("alignment"))
                    .weight(result.getInt("weight"))
                    .build());
        }
        return heroes;
    }

    @Override
    public List<Hero> findByName(String name) {
        var sql = "select * from heroes where name = '" + name + "'";
        try (var connection = dataSource.getConnection();
             var statement = connection.createStatement()) {
            var result = statement.executeQuery(sql);
            return mapHeroes(result);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void create(Hero hero) {
        var sql = "insert into heroes (id, name, gender, eye_color, race, hair_color, height, publisher, skin_color, alignment, weight) values (?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (var connection = dataSource.getConnection();
             var statement = connection.prepareStatement(sql)) {
            statement.setInt(1, hero.getId());
            statement.setString(2, hero.getName());
            statement.setString(3, hero.getGender());
            statement.setString(4, hero.getEyeColor());
            statement.setString(5, hero.getRace());
            statement.setString(6, hero.getHairColor());
            statement.setDouble(7, hero.getHeight());
            statement.setString(8, hero.getPublisher());
            statement.setString(9, hero.getSkinColor());
            statement.setString(10, hero.getAlignment());
            statement.setInt(11, hero.getWeight());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Hero hero) {
        var sql = "update heroes set weight = ?, name = ?, gender = ?, eye_color = ?, race = ?, hair_color = ?, height = ?, " +
                "publisher = ?, skin_color = ?, alignment = ? where id = ?";
        try (var connection = dataSource.getConnection();
             var statement = connection.prepareStatement(sql)) {
            statement.setInt(1, hero.getWeight());
            statement.setString(2, hero.getName());
            statement.setString(3, hero.getGender());
            statement.setString(4, hero.getEyeColor());
            statement.setString(5, hero.getRace());
            statement.setString(6, hero.getHairColor());
            statement.setDouble(7, hero.getHeight());
            statement.setString(8, hero.getPublisher());
            statement.setString(9, hero.getSkinColor());
            statement.setString(10, hero.getAlignment());
            statement.setInt(11, hero.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(Integer id) {
        var sql = "delete from heroes where id =?";
        try (var connection = dataSource.getConnection();
             var statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}