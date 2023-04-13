package ua.ithillel.dao.student;

public record StudentDto(
        String name,
        String email,
        String major,
        int age) {

    static StudentDto from(Student student) {
        return new StudentDto(student.getName(), student.getEmail(), student.getEmail(), student.getAge());
    }
}
