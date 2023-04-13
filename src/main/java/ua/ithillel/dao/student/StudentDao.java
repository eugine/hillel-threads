package ua.ithillel.dao.student;

import java.util.List;
import java.util.Optional;

interface StudentDao {
    List<Student> findAll();
    Optional<Student> findById(Long id);
    Optional<Student> findById(String id);
    void persist(Student student);
    void update(Student student);
    boolean delete(Long id);
}
