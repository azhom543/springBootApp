package hibernateSpringApp.dtos;

import com.fasterxml.jackson.databind.ObjectMapper;
import hibernateSpringApp.entities.Courses;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CourseInstructorDTO {
        private String courseName;
        private String instructorName;
}
