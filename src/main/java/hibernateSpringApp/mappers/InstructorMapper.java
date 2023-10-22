package hibernateSpringApp.mappers;
import com.fasterxml.jackson.databind.ObjectMapper;
import hibernateSpringApp.dtos.InstructorDTO;
import hibernateSpringApp.entities.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InstructorMapper {
    @Autowired
    private ObjectMapper objectMapper;

    public InstructorDTO toDTO(Instructor entity) {
        return objectMapper.convertValue(entity, InstructorDTO.class);
    }

    public Instructor toEntity(InstructorDTO dto) {
        return objectMapper.convertValue(dto, Instructor.class);
    }
}
