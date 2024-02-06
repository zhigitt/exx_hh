package java12.dao;

import java12.enitity.Course;
import java12.enitity.Student;
import org.hibernate.loader.ast.spi.Loadable;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

public interface StudentDao {
    void createStudent(Student student);
    Student getStudentById(Long id);
    void updateStudentName(Long id, String name);
    void deleteStudent(Long id);

    List<Course> getStudentCourses(Long id);
    List<Student> getStudentsByRecentEnrollments(int dateLimit);
}
