package hibernateSpringApp.controller;

import hibernateSpringApp.dtos.InstructorDTO;
import hibernateSpringApp.entities.Instructor;
import hibernateSpringApp.entities.InstructorDetails;
import hibernateSpringApp.entities.Students;
import hibernateSpringApp.mappers.InstructorMapper;
import hibernateSpringApp.services.InstructorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<List<InstructorDTO>> addInstructor(@RequestBody @Valid InstructorDTO instructorDTO) {
        Instructor instructorEntity = instructorMapper.toEntity(instructorDTO);
        List<Instructor> instructorsList  = instructorService.addInstructor(instructorEntity);
        return ResponseEntity.ok(instructorsList.stream()
                .map(instructorMapper::toDTO)
                .collect(Collectors.toList()));
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
    public ResponseEntity<List<InstructorDTO>> deleteInstructor(@PathVariable @Valid UUID instructorID) {
        Instructor instructor = instructorService.getInstructorById(instructorID);
        if (instructor == null) {
            return ResponseEntity.notFound().build();
        }
        List<Instructor> instructorList = instructorService.deleteInstructor(instructorID);
        return ResponseEntity.ok(instructorList.stream()
                .map(instructorMapper::toDTO)
                .collect(Collectors.toList()));
    }
}
