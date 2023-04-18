package ua.ithillel.dao.student;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

class StudentServiceIntegrationTest {

    private final List<Student> studentDb = List.of(
            Student.builder().id(1L).build(),
            Student.builder().id(2L).build(),
            Student.builder().id(3L).build());

    private final StudentService target = StudentFactory.createDummyService(studentDb);

    @Test
    void findAll() {
        var students = target.findAll();

        assertThat(students.size(), equalTo(3));
    }
}