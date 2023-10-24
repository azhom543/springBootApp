package hibernateSpringApp.dtos;

import lombok.*;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentsCoursesInfoDTO {
    private String courseName;
    private Date startDate;
    private String studentName;
}