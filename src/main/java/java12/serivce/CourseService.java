package java12.serivce;

import java12.enitity.Course;
import java12.enitity.Student;

public interface CourseService {
    void createCourse(Course course);
    Course getCourseById(Long id);
    void updateCourse(Long id, Course course);
    void deleteCourse(Long id);

    void getCourseStudents(Long id);

    void assignStudentToCourse(Long studentId, Long courseId);
}
