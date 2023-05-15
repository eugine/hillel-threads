package ua.ithillel.dao.student;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class StudentDaoImpl implements StudentDao {
    private final DataSource dataSource;

    @Override
    public List<Student> findAll() {
        var sql = "select * from students";
        try (var connection = dataSource.getConnection();
             var statement = connection.createStatement()) {
            var result = statement.executeQuery(sql);
            return mapStudents(result);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private ArrayList<Student> mapStudents(ResultSet result) throws SQLException {
        var students = new ArrayList<Student>();
        while (result.next()) {
            students.add(Student.builder()
                    .id(result.getLong("id"))
                    .name(result.getString("name"))
                    .age(result.getInt("age"))
                    .major(result.getString("major"))
                    .email(result.getString("email"))
                    .createAt(result.getTimestamp("created_at").toLocalDateTime())
                    .updatedAt(result.getTimestamp("updated_at").toLocalDateTime())
                    .build());
        }
        return students;
    }

    @Override
    public List<Student> findByName(String name) {
        var sql = "select * from students where name = '" + name + "'";
        try (var connection = dataSource.getConnection();
             var statement = connection.createStatement()) {
            var result = statement.executeQuery(sql);
            return mapStudents(result);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Student> findById(Long id) {
        var sql = "select * from students where id = ?";
        try (var conn = dataSource.getConnection();
             var statement = conn.prepareStatement(sql)) {
            statement.setLong(1, id);
            var result = statement.executeQuery();
            return mapStudents(result).stream().findFirst();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void persist(Student student) {
        var sql = """
                insert into students(name, age, email, major, created_at, updated_at) 
                values(?,?,?,?, now(), now())
                """;
        try (var conn = dataSource.getConnection();
             var statement = conn.prepareStatement(sql)) {
            statement.setString(1, student.getName());
            statement.setInt(2, student.getAge());
            statement.setString(3, student.getEmail());
            statement.setString(4, student.getMajor());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Student student) {
        var sql = """
                update students set name=?, age=?, email=?, major=?, updated_at = now() 
                where id = ?
                """;
        try (var conn = dataSource.getConnection();
             var statement = conn.prepareStatement(sql)) {
            statement.setString(1, student.getName());
            statement.setInt(2, student.getAge());
            statement.setString(3, student.getEmail());
            statement.setString(4, student.getMajor());
            statement.setLong(5, student.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
