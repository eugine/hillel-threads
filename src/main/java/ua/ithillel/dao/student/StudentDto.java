package ua.ithillel.dao.student;

public record StudentDto(
        Long id,
        String name,
        String email,
        String major,
        int age) {

    static StudentDto from(Student student) {
        return new StudentDto(student.getId(), student.getName(), student.getEmail(), student.getEmail(), student.getAge());
    }
}
