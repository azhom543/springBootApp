package hibernateSpringApp.dtos;

import lombok.*;

import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class StudentsDTO {
    private UUID studentId;
    private String firstName;
    private String lastName;
    private String studentPhone;
    private int studentAge;
    private String studentEmail;
    private String studentGender;
    private String nationalId;
}
