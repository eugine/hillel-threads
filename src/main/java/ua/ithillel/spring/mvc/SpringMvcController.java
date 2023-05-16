package ua.ithillel.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.ithillel.dao.student.StudentDto;
import ua.ithillel.dao.student.StudentService;
import ua.ithillel.spring.mvc.exception.SpringMvcModelNotFoundException;

@Controller
@RequestMapping("/")
public class SpringMvcController {
    private final StudentService studentService;

    public SpringMvcController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("")
    public String students(Model model) {
        model.addAttribute("nameXXXX", "Test name");
        model.addAttribute("students", studentService.findAll());
        return "students/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("student", StudentDto.builder().build());
        return "students/create";
    }

    @PostMapping("/create")
    public String create(StudentDto studentDto, Model model) {
        studentService.persist(studentDto);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") long id, Model model) {
        var student = studentService.findById(id)
                .orElseThrow(() -> new SpringMvcModelNotFoundException("Student not found"));
        model.addAttribute("student", student);
        return "students/edit";
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable("id") long id, StudentDto studentDto, Model model) {
        studentService.update(studentDto.toBuilder()
                .id(id)
                .age(30)
                .build());
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id) {
        studentService.delete(id);
        return "redirect:/";
    }


}
