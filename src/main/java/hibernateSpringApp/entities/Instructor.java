package hibernateSpringApp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "instructor")
public class Instructor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "instructor_id")
    private UUID id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "phone_number")
    private String phone;
    @Column(name = "title")
    private String title;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instructor_details_id")
    private InstructorDetails instructorDetails;
    @OneToMany(mappedBy = "instructor",
            cascade = {CascadeType.ALL},fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Courses> courses;

    public void add(Courses tempCourse){
        if (courses == null){
            courses = new ArrayList<Courses>();
        }
        courses.add(tempCourse);
        tempCourse.setInstructor(this);
    }
}
