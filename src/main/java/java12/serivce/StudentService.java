package java12.serivce;

import java12.enitity.Course;
import java12.enitity.Student;

import java.time.LocalDate;
import java.util.List;

public interface StudentService {
    void createStudent(Student student);
    Student getStudentById(Long id);
    void updateStudentName(Long id, String name);
    void deleteStudent(Long id);

    List<Course> getStudentCourses(Long id);
    List<Student> getStudentsByRecentEnrollments(int dateLimit);
}
