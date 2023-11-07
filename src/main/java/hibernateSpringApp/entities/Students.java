package hibernateSpringApp.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "students")
public class Students implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "student_id")
    private UUID studentId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "student_phone")
    private String studentPhone;
    @Column(name = "student_age")
    private int studentAge;
    @Column(name = "student_email")
    private String studentEmail;
    @Column(name = "student_gender")
    private String studentGender;
    @Column(name = "national_id")
    private String nationalId;
    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(
            name = "students_courses",
            joinColumns = @JoinColumn (name = "student_id"),
            inverseJoinColumns = @JoinColumn (name = "course_id")
    )
    private Set<Courses> coursesSet = new HashSet<>();
    public void addCourse(Courses course) {
        if (coursesSet == null) {
            coursesSet = new HashSet<>();
        }
        coursesSet.add(course);
        course.getStudentsSet().add(this);
    }
}
