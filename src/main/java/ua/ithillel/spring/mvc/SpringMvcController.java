package ua.ithillel.spring.mvc;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.ithillel.dao.student.StudentDto;
import ua.ithillel.dao.student.StudentService;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class SpringMvcController {
    private final StudentService studentService;

    @GetMapping
    public String students(Model model) {
        model.addAttribute("name", "Test name");
        model.addAttribute("students", studentService.findAll());
        return "students/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("student", StudentDto.builder().build());
        return "students/create";
    }

    @PostMapping("/add")
    public String create(StudentDto studentDto, Model model) {
        studentService.persist(studentDto);
        return "redirect:/index";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") long id, Model model) {
        var student = studentService.findById(id)
                .orElseThrow();

        model.addAttribute("student", student);
        return "students/edit";
    }


}
