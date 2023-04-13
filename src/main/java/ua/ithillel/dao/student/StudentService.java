package ua.ithillel.dao.student;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class StudentService {
    private final StudentDao dao;

    public List<StudentDto> findAll() {
        return dao.findAll().stream()
                .map(StudentDto::from)
                .toList();
    }

    public Optional<StudentDto> findById(Long id) {
        return dao.findById(id)
                .map(StudentDto::from);
    }

    public Optional<StudentDto> findById(String id) {
        return dao.findById(id)
                .map(StudentDto::from);
    }

}
