package ua.ithillel.spring.data.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataStudentRepository extends JpaRepository<SpringDataStudent, Long> {
}
