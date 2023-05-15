package ua.ithillel.hibernate;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j
public class HibernateExample {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(HibernateConfig.class);
        var sessionFactory = context.getBean(SessionFactory.class);

        try (var session = sessionFactory.openSession()) {
            var student = session.find(HibernateStudent.class, 1L);
            log.info("Found student:" + student);

            var studentName = "Test_" + UUID.randomUUID().toString().substring(0, 5);
            log.info("Creating a student with name: " + studentName);
            var id = session.save(HibernateStudent.builder()
                    .name(studentName)
                    .email(studentName + "@example.com")
                    .age(31)
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .build());

            var persistedStudent = session.find(HibernateStudent.class, id);
            log.info("Found persisted student: " + persistedStudent);

        }
    }
}
