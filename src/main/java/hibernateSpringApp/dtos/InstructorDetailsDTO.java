package hibernateSpringApp.dtos;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class InstructorDetailsDTO {
    private UUID id;
    private String youtubeChannel;
    private String hobbies;
}
