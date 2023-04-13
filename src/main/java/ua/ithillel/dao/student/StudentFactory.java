package ua.ithillel.dao.student;

import javax.sql.DataSource;

public class StudentFactory {

    public static StudentService createService(DataSource dataSource) {
        return new StudentService(createDao(dataSource));
    }

    private static StudentDao createDao(DataSource dataSource) {
        return new StudentDaoImpl(dataSource);
    }
}
