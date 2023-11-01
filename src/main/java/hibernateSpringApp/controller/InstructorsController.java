package hibernateSpringApp.controller;

import hibernateSpringApp.dtos.InstructorDTO;
import hibernateSpringApp.entities.Instructor;
import hibernateSpringApp.entities.InstructorDetails;
import hibernateSpringApp.entities.Students;
import hibernateSpringApp.mappers.InstructorMapper;
import hibernateSpringApp.services.InstructorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/instructor-management")
public class InstructorsController {
    @Autowired
    private InstructorService instructorService;
    @Autowired
    private InstructorMapper instructorMapper;
    @GetMapping("/instructors")
    public List<InstructorDTO> getAllInstructors(){
        List<Instructor> instructors = instructorService.getAllInstructor();
        // Convert entities to DTOs using the mapper
        return instructors.stream()
                .map(instructorMapper::toDTO)
                .collect(Collectors.toList());
    }
    @GetMapping("/instructor/{id}")
    public ResponseEntity<InstructorDTO> getInstructorById(@PathVariable UUID id){
        Instructor instructor = instructorService.getInstructorById(id);
        if (instructor == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(instructorMapper.toDTO(instructor));
    }
    @PostMapping("/action=add")
    public ResponseEntity<InstructorDTO> addInstructor(@RequestBody @Valid InstructorDTO instructorDTO) {
        Instructor instructorEntity = instructorMapper.toEntity(instructorDTO);
        InstructorDTO instructordto  = instructorMapper.toDTO(instructorService.addInstructor(instructorEntity));
        return ResponseEntity.ok(instructordto);
    }
    @PutMapping("/action=update")
    public ResponseEntity<InstructorDTO> updateInstructor(@RequestBody @Valid InstructorDTO instructor) {
        Instructor searchInstructor = instructorMapper.toEntity(instructor);
        if (searchInstructor == null)
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(instructorMapper.toDTO(instructorService.updateInstructor(searchInstructor)));
    }
    @DeleteMapping("/action=delete/{InstructorID}")
    public ResponseEntity deleteInstructor(@PathVariable @Valid UUID instructorID) {
        boolean found = instructorService.deleteInstructor(instructorID);
        if (!found) {
            return ResponseEntity.notFound().build();
        }else return new ResponseEntity<>("Instructor deleted successfully", HttpStatus.OK);
    }
}
