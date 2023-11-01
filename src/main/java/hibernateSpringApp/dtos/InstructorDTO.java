package hibernateSpringApp.dtos;

import hibernateSpringApp.entities.Courses;
import hibernateSpringApp.entities.InstructorDetails;
import lombok.*;

import java.util.List;
import java.util.UUID;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class InstructorDTO {
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String title;
    private InstructorDetails instructorDetails;
//    private List<Courses> courses;
}
