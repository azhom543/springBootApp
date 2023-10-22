package hibernateSpringApp.dtos;

import hibernateSpringApp.entities.Instructor;
import hibernateSpringApp.entities.Students;
import lombok.*;

import java.util.Date;
import java.util.Set;
import java.util.UUID;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CoursesDTO {
    private UUID course_id;
    private String course_name;
    private Date start_date;
    private Date end_date;
    private String level;
    private boolean is_started;
    private Instructor instructor;
    private Set<Students> studentsSet;
}
