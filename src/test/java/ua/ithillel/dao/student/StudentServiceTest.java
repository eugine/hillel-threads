package ua.ithillel.dao.student;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

class StudentServiceTest {

    private StudentService target;

    @Test
    void findAll() {
        var mockStudentDao = Mockito.mock(StudentDao.class);

        Mockito.when(mockStudentDao.findAll()).thenReturn(List.of(
                Student.builder().build(),
                Student.builder().build(),
                Student.builder().build()
        ));


        target = new StudentService(mockStudentDao);


        var students = target.findAll();

        assertThat(students.size(), equalTo(3));
    }
}