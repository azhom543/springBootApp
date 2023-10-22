package hibernateSpringApp.mappers;

import com.fasterxml.jackson.databind.ObjectMapper;
import hibernateSpringApp.dtos.CoursesDTO;
import hibernateSpringApp.entities.Courses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CoursesMapper {
    @Autowired
    private ObjectMapper objectMapper;

    public Courses toEntity(CoursesDTO dto){
        return objectMapper.convertValue(dto,Courses.class);
    }

    public CoursesDTO toDTO(Courses entity){return objectMapper.convertValue(entity,CoursesDTO.class);}

}
