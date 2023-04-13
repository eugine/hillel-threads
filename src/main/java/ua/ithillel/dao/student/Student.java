package ua.ithillel.dao.student;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
class Student {
    private Long id;
    private String name;
    private int age;
    private String email;
    private String major;
    private LocalDateTime createAt;
    private LocalDateTime updatedAt;
}
