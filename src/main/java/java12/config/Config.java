package java12.config;

import jakarta.persistence.EntityManagerFactory;
import java12.enitity.Course;
import java12.enitity.Student;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

public class Config {
    public static EntityManagerFactory getEntityManagerFactory(){
        Properties properties = new Properties();

        properties.put(Environment.JAKARTA_JDBC_USER, "postgres");
        properties.put(Environment.JAKARTA_JDBC_PASSWORD, "zhigit");
        properties.put(Environment.JAKARTA_JDBC_DRIVER, "org.postgresql.Driver");
        properties.put(Environment.JAKARTA_JDBC_URL, "jdbc:postgresql://localhost:5432/exxam_hibernate");
        properties.put(Environment.HBM2DDL_AUTO, "update");
        properties.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
        properties.put(Environment.SHOW_SQL, "true");
        properties.put(Environment.FORMAT_SQL, "true");

        Configuration configuration = new Configuration();
        configuration.addProperties(properties);

        configuration.addAnnotatedClass(Student.class);
        configuration.addAnnotatedClass(Course.class);

        return configuration.buildSessionFactory();
    }
}
