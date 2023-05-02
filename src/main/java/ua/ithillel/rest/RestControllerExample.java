package ua.ithillel.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.ithillel.dao.student.StudentDto;
import ua.ithillel.dao.student.StudentService;
import ua.ithillel.hausaufgabe.socket.model.HeroDto;
import ua.ithillel.hausaufgabe.socket.server.hero.HeroService;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class RestControllerExample {
    private final StudentService studentService;

    @GetMapping("/students")
    public List<StudentDto> getStudents() {
        return studentService.findAll();
    }

    @GetMapping("/students/{id}")
    public StudentDto getStudent(@PathVariable("id") Long studentId) {
        return studentService.findById(studentId).orElseThrow();
    }

}
