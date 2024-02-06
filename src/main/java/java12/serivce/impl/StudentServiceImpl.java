package java12.serivce.impl;

import java12.dao.StudentDao;
import java12.dao.impl.StudentDaoImpl;
import java12.enitity.Course;
import java12.enitity.Student;
import java12.serivce.StudentService;

import java.time.LocalDate;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    StudentDao studentDao = new StudentDaoImpl();

    @Override
    public void createStudent(Student student) {
        studentDao.createStudent(student);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentDao.getStudentById(id);
    }

    @Override
    public void updateStudentName(Long id, String name) {
        studentDao.updateStudentName(id, name);
    }

    @Override
    public void deleteStudent(Long id) {
        studentDao.deleteStudent(id);
    }

    @Override
    public List<Course> getStudentCourses(Long id) {
        return studentDao.getStudentCourses(id);
    }

    @Override
    public List<Student> getStudentsByRecentEnrollments(int dateLimit) {
        return studentDao.getStudentsByRecentEnrollments(dateLimit);
    }
}
