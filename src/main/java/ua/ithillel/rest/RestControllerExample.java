package ua.ithillel.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.ithillel.dao.student.StudentDto;
import ua.ithillel.dao.student.StudentService;
import ua.ithillel.hausaufgabe.socket.model.HeroDto;
import ua.ithillel.hausaufgabe.socket.server.hero.HeroService;

import java.util.List;
import java.util.Map;

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
    public StudentDto getStudent(@PathVariable("id") Long id) {
        return studentService.findById(id).orElseThrow();
    }

    @PostMapping("/students")
    public StudentDto createStudent(@RequestBody StudentCreationRequest request) {
        return studentService.create(request);
    }

    @PutMapping("/students/{id}")
    public StudentDto updateStudent(@PathVariable("id") Long id, @RequestBody StudentCreationRequest request) {
        return null;
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity deleteStudent(@PathVariable("id") Long id) {
//     return studentService.delete(id);
        return ResponseEntity.noContent().build();
    }



/*
    Create -> POST
    Read -> GET
    Update
    Delete


 */

}
