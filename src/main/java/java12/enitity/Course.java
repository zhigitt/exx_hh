package java12.enitity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "courses")
@Setter
@Getter
@NoArgsConstructor
@SequenceGenerator(name = "base_id", sequenceName = "course_seq", allocationSize = 1)

public class Course extends BaseEntityId{
    @Column(name = "course_name", unique = true)
    private String name;

    private String description;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Student> students;

    public Course(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Course{" +
               "name='" + name + '\'' +
               ", description='" + description + '\'' +
               '}';
    }
}
