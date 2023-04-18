package ua.ithillel.dao.student;

import java.util.List;
import java.util.Optional;

public class StudentService {
    private final StudentDao dao;

    protected StudentService(StudentDao dao) {
        this.dao = dao;
    }

    public List<StudentDto> findAll() {
        return dao.findAll().stream()
                .map(StudentDto::from)
                .toList();
    }

    public Optional<StudentDto> findById(Long id) {
        return dao.findById(id)
                .map(StudentDto::from);
    }

    public List<StudentDto> findByName(String name) {
        return dao.findByName(name).stream()
                .map(StudentDto::from)
                .toList();
    }

}
