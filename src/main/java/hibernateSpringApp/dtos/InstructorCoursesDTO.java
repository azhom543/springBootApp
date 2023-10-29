package hibernateSpringApp.dtos;

import lombok.*;

import java.util.List;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class InstructorCoursesDTO {
    private String instructorName;
    private List<String> courses;
}
