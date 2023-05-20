package ua.ithillel.spring.mvc.exception;

public class SpringMvcModelNotFoundException extends RuntimeException {
    public SpringMvcModelNotFoundException(String message) {
        super(message);
    }
}
