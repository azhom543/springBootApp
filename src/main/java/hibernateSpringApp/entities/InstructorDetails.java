package hibernateSpringApp.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "instructor_details")
public class InstructorDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "instructor_details_id")
    private UUID id;
    @Column(name = "youtube_channel")
    private String youtubeChannel;
    @Column(name = "hobbies")
    private String hobbies;
}
