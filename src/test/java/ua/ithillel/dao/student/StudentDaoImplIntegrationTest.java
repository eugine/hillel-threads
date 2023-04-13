package ua.ithillel.dao.student;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


class StudentDaoImplIntegrationTest {

    private StudentDaoImpl target;

    @BeforeEach
    public void setup() {
        var datasource = hikariDataSource();
        target = new StudentDaoImpl(datasource);
    }

    private DataSource hikariDataSource() {
        var config = new HikariConfig();
        //creates in-memory DB and init it with a script
        config.setJdbcUrl("jdbc:h2:mem:test;INIT=runscript from './src/test/resources/h2-students-db.sql'");
        return new HikariDataSource(config);
    }

    @Test
    void shouldFindAllStudents() {
        var foundStudents = target.findAll();
        assertThat(foundStudents, hasSize(20));

        var johnDoe = foundStudents.stream()
                .filter(student -> "John Doe".equals(student.getName()))
                .findAny()
                .orElseThrow();

        assertJohnDoe(johnDoe);
    }

    @Test
    void shouldFindById() {
        var id = findStudentId();

        var foundStudent = target.findById(id).orElseThrow();
        assertJohnDoe(foundStudent);
    }

    @Test
    void shouldFindByName() {
        var name = "John Doe";

        var result = target.findByName(name);
        assertThat(result, hasSize(1));
        var foundStudent = result.get(0);
        assertJohnDoe(foundStudent);
    }

    @Test
    void shouldProtectFromSqlInjection() {
        target.findByName("John Doe'; DROP TABLE students; SELECT 'sql injection");

        var foundStudents = target.findAll();
        assertThat(foundStudents, hasSize(20));
    }

    private Long findStudentId() {
        return target.findAll().stream()
                .filter(student -> "John Doe".equals(student.getName()))
                .findAny()
                .map(Student::getId)
                .orElseThrow();
    }

    private void assertJohnDoe(Student johnDoe) {
        assertThat(johnDoe.getName(), equalTo("John Doe"));
        assertThat(johnDoe.getEmail(), equalTo("johndoe@example.com"));
        assertThat(johnDoe.getMajor(), equalTo("Computer Science"));
        assertThat(johnDoe.getAge(), equalTo(20));
        assertThat(johnDoe.getId(), is(notNullValue()));
        assertThat(johnDoe.getCreateAt(), is(notNullValue()));
        assertThat(johnDoe.getUpdatedAt(), is(notNullValue()));
    }
}