package java12.enitity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "students")
@Setter @Getter
@NoArgsConstructor
@SequenceGenerator(name = "base_id", sequenceName = "student_seq", allocationSize = 1)

public class Student extends BaseEntityId{
    private String full_name;

    @Column(unique = true)
    private String email;

    @Column(nullable = false)
    private LocalDate enrollment_date;

    @ManyToMany(mappedBy = "students", fetch = FetchType.EAGER)
    private List<Course> courses;

    public Student(String full_name, String email, LocalDate enrollment_date) {
        this.full_name = full_name;
        this.email = email;
        this.enrollment_date = enrollment_date;
    }

    @Override
    public String toString() {
        return "Student{" +
               "full_name='" + full_name + '\'' +
               ", email='" + email + '\'' +
               ", enrollment_date=" + enrollment_date +
               '}';
    }
}
