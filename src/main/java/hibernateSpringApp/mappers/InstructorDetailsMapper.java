package hibernateSpringApp.mappers;

import com.fasterxml.jackson.databind.ObjectMapper;
import hibernateSpringApp.dtos.InstructorDetailsDTO;
import hibernateSpringApp.entities.InstructorDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InstructorDetailsMapper {
    @Autowired
    private ObjectMapper objectMapper;
    public InstructorDetailsDTO toDTO(InstructorDetails entity){return objectMapper.convertValue(entity,InstructorDetailsDTO.class);}
    public InstructorDetails toEntity(InstructorDetailsDTO dto){return objectMapper.convertValue(dto,InstructorDetails.class);}
}
