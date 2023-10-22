package hibernateSpringApp.mappers;

import com.fasterxml.jackson.databind.ObjectMapper;
import hibernateSpringApp.dtos.StudentsDTO;
import hibernateSpringApp.entities.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentsMapper {
    @Autowired
    private ObjectMapper objectMapper;
    public StudentsDTO toDTO(Students entity){return objectMapper.convertValue(entity,StudentsDTO.class);}
    public Students toEntity(StudentsDTO dto){return objectMapper.convertValue(dto,Students.class);}
}
