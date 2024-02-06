package java12.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import java12.config.Config;
import java12.dao.StudentDao;
import java12.enitity.Course;
import java12.enitity.Student;
import org.hibernate.grammars.hql.HqlParser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    EntityManagerFactory entityManagerFactory = Config.getEntityManagerFactory();

    @Override
    public void createStudent(Student student) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();

            entityManager.persist(student);

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) entityManager.getTransaction().rollback();
            System.out.println(e.getMessage());
        } finally {
            entityManager.close();
        }

        System.out.println("saved student");
    }

    @Override
    public Student getStudentById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Student student = null;

        try {
            entityManager.getTransaction().begin();

            student = entityManager.find(Student.class, id);

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) entityManager.getTransaction().rollback();
            System.out.println(e.getMessage());
        } finally {
            entityManager.close();
        }
        return student;
    }

    @Override
    public void updateStudentName(Long id, String name) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Student student = null;

        try {
            entityManager.getTransaction().begin();

            student = entityManager.find(Student.class, id);

            if (student != null) {
                student.setFull_name(name);
                entityManager.merge(student);
            } else {
                System.out.println("Not found student ID");
            }

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) entityManager.getTransaction().rollback();
            System.out.println(e.getMessage());
        } finally {
            entityManager.close();
        }
        System.out.println(" updated");
    }

    @Override
    public void deleteStudent(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Student student = null;
        try {
            entityManager.getTransaction().begin();

            student = entityManager.find(Student.class, id);
            System.out.println("not found this id");
            for (Course cours : student.getCourses()) {
                student.getCourses().remove(cours);
            }
            entityManager.remove(student);

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) entityManager.getTransaction().rollback();
            System.out.println(e.getMessage());
        } finally {
            entityManager.close();
        }

        System.out.println("deleted student");
    }

    @Override
    public List<Course> getStudentCourses(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Student student = null;
        List<Course>  courses = new ArrayList<>();

        try {
            entityManager.getTransaction().begin();

            student = entityManager.find(Student.class, id);
             courses = student.getCourses();

            entityManager.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            entityManager.close();
        }
        return courses;
    }

    @Override
    public List<Student> getStudentsByRecentEnrollments(int dateLimit) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Student> students = new ArrayList<>();
        try{
            entityManager.getTransaction().begin();

//            String query = "select * from Student s where s.enrollment_date :limitt";
//            students = entityManager.createNativeQuery(query, Student.class)
//                            .setParameter("limit", dateLimit)
//                                    .getResultList();

            students = entityManager.createQuery("select s from Student s order by enrollment_date desc limit :limitt")
                    .setParameter("limitt", dateLimit)
                    .getResultList();

            entityManager.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return students;
    }
}
