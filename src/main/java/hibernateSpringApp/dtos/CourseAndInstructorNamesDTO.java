package hibernateSpringApp.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class CourseAndInstructorNamesDTO {
        private String courseName;
        private String instructorName;
}
