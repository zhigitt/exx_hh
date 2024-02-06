package java12.serivce.impl;

import java12.dao.CourseDao;
import java12.dao.impl.CourseDaoImpl;
import java12.enitity.Course;
import java12.enitity.Student;
import java12.serivce.CourseService;

public class CourseServiceImpl implements CourseService {

    CourseDao courseDao = new CourseDaoImpl();

    @Override
    public void createCourse(Course course) {
        courseDao.createCourse(course);
    }

    @Override
    public Course getCourseById(Long id) {
        return courseDao.getCourseById(id);
    }

    @Override
    public void updateCourse(Long id, Course course) {
        courseDao.updateCourse(id, course);
    }

    @Override
    public void deleteCourse(Long id) {
        courseDao.deleteCourse(id);
    }

    @Override
    public void getCourseStudents(Long id) {
        courseDao.getCourseStudents(id);
    }

    @Override
    public void assignStudentToCourse(Long studentId, Long courseId) {
        courseDao.assignStudentToCourse(studentId, courseId);
    }
}
