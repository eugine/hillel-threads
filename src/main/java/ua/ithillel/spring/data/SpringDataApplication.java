package ua.ithillel.spring.data;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ua.ithillel.spring.data.entity.SpringDataStudentRepository;

@Slf4j
@SpringBootApplication
@RequiredArgsConstructor
public class SpringDataApplication implements CommandLineRunner {

    private final SpringDataStudentRepository studentRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Students: {}", studentRepository.findAll());
    }
}
