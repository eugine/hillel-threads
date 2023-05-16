package ua.ithillel.spring.mvc;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import ua.ithillel.spring.mvc.exception.SpringMvcModelNotFoundException;

@ControllerAdvice
public class SpringMvcExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleException(RuntimeException ex) {
        return "students/error";
    }

    @ExceptionHandler(SpringMvcModelNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String modelNotFound(SpringMvcModelNotFoundException ex, Model model) {
        model.addAttribute("message", ex.getMessage());
        return "students/error";
    }
}
