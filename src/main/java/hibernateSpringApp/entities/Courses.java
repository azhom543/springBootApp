package hibernateSpringApp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "courses")
public class Courses implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID) // Use an appropriate strategy for your database
    @Column(name = "course_id")
    private UUID course_id;

    @Column(name = "course_name")
    private String course_name;

    @Column(name = "start_date")
    private Date start_date;

    @Column(name = "end_date")
    private Date end_date;

    @Column(name = "course_level")
    private String level;

    @Column(name = "is_started")
    private boolean is_started;
    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;
    @JsonIgnore
    @ManyToMany(mappedBy = "coursesSet",cascade = CascadeType.ALL)
    private Set<Students> studentsSet = new HashSet<>();
    public void addStudent(Students student) {
        if (studentsSet == null) {
            studentsSet = new HashSet<>();
        }
        studentsSet.add(student);
        student.getCoursesSet().add(this);
    }
//    public Courses(UUID course_id, String course_name, Date start_date, Date end_date, String level, boolean is_started) {
//        this.course_id = course_id;
//        this.course_name = course_name;
//        this.start_date = start_date;
//        this.end_date = end_date;
//        this.level = level;
//        this.is_started = is_started;
//    }
}
