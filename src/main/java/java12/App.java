package java12;

import java12.enitity.Course;
import java12.enitity.Student;
import java12.serivce.CourseService;
import java12.serivce.StudentService;
import java12.serivce.impl.CourseServiceImpl;
import java12.serivce.impl.StudentServiceImpl;

import java.time.LocalDate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        StudentService studentService = new StudentServiceImpl();
        CourseService courseService = new CourseServiceImpl();

        //STUDENT
//        studentService.createStudent(new Student("Nurgazy Temiraliev", "nurgazy@gmail.com", LocalDate.of(2020,01,01)));
//        System.out.println(studentService.getStudentById(1L));
//        studentService.updateStudentName(1L, "NURGAZY TEMIRALIEV");

//        studentService.deleteStudent(1L);



//        System.out.println(studentService.getStudentsByRecentEnrollments(2));



//        studentService.createStudent(new Student("Alex", "alex@gmail.com", LocalDate.of(2023, 02, 02)));
//        studentService.createStudent(new Student("Mirlan", "mirlan@gmail.com", LocalDate.of(2019, 02, 02)));
//        studentService.createStudent(new Student("Nuke", "nuke@gmail.com", LocalDate.of(2011, 02, 02)));
//        studentService.createStudent(new Student("Urmat", "urmat@gmail.com", LocalDate.of(2000, 02, 02)));
//        studentService.createStudent(new Student("Aman", "aman@gmail.com", LocalDate.of(2024, 02, 02)));








        //COURSE
//        courseService.createCourse(new Course("kotlin", "kkkkk"));
//        courseService.createCourse(new Course("c++", "oooooo"));
//        courseService.createCourse(new Course("python", "ffffff"));
//        courseService.createCourse(new Course("js", "aaaaaaa"));
//        courseService.createCourse(new Course("java", "qqqqqqqq"));

//        courseService.assignStudentToCourse(1L, 1L);
//        courseService.assignStudentToCourse(1L, 2L);
//        courseService.assignStudentToCourse(1L, 3L);


//        System.out.println(courseService.getCourseById(3L));

//        courseService.deleteCourse(3L);


//        studentService.deleteStudent(2L);



    }

}
