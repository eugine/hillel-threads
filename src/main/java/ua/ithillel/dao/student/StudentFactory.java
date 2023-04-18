package ua.ithillel.dao.student;

import javax.sql.DataSource;
import java.util.List;

public class StudentFactory {

    public static StudentService createService(DataSource dataSource) {
        return new StudentService(createDao(dataSource));
    }

    private static StudentDao createDao(DataSource dataSource) {
        return new StudentDaoImpl(dataSource);
    }

    public static StudentService createDummyService(List<Student> students) {
        return new StudentService(new DummyStudentDao(students));
    }
}
