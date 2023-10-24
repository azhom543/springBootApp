package hibernateSpringApp.dtos;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class InstructorCoursesStudentsDTO {
    private String instructorName;
    private String studentName;
    private UUID courseId;
}
