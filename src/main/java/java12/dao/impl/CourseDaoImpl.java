package java12.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import java12.config.Config;
import java12.dao.CourseDao;
import java12.enitity.Course;
import java12.enitity.Student;

import java.util.ArrayList;
import java.util.List;

public class CourseDaoImpl implements CourseDao {
    EntityManagerFactory entityManagerFactory = Config.getEntityManagerFactory();

    @Override
    public void createCourse(Course course) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();

            entityManager.persist(course);

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) entityManager.getTransaction().rollback();
            System.out.println(e.getMessage());
        } finally {
            entityManager.close();
        }

        System.out.println("saved course");
    }

    @Override
    public Course getCourseById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Course course = null;

        try {
            entityManager.getTransaction().begin();

            course = entityManager.find(Course.class, id);

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) entityManager.getTransaction().rollback();
            System.out.println(e.getMessage());
        } finally {
            entityManager.close();
        }

        return course;
    }

    @Override
    public void updateCourse(Long id, Course course) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Course oldCourse = null;

        try {
            entityManager.getTransaction().begin();

            oldCourse = entityManager.find(Course.class, id);
            oldCourse.setName(course.getName());
            oldCourse.setDescription(course.getDescription());

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) entityManager.getTransaction().rollback();
            System.out.println(e.getMessage());
        } finally {
            entityManager.close();
        }

        System.out.println("updated course");
    }

    @Override
    public void deleteCourse(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Course course = null;

        try {
            entityManager.getTransaction().begin();


            course = entityManager.find(Course.class, id);
            entityManager.remove(course);

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) entityManager.getTransaction().rollback();
            System.out.println(e.getMessage());
        } finally {
            entityManager.close();
        }

        System.out.println("deleted course");
    }

    @Override
    public void getCourseStudents(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Student> students = new ArrayList<>();
        Course course = null;

        try {
            entityManager.getTransaction().begin();

            course = entityManager.find(Course.class, id);
            students = course.getStudents();

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) entityManager.getTransaction().rollback();
            System.out.println(e.getMessage());
        } finally {
            entityManager.close();
        }

        System.out.println(course);
        System.out.println(students);
    }

    @Override
    public void assignStudentToCourse(Long studentId, Long courseId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Course course = null;
        Student student = null;

        try{
            entityManager.getTransaction().begin();

            course = entityManager.find(Course.class, courseId);
            student = entityManager.find(Student.class, studentId);

            if (course != null && student != null) {
                course.getStudents().add(student);
                student.getCourses().add(course);

                entityManager.merge(course);
                entityManager.merge(student);

            }else {
                System.out.println("Not found course or student!");
            }
            entityManager.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
