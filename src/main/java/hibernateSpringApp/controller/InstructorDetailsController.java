package hibernateSpringApp.controller;

import hibernateSpringApp.entities.Courses;
import hibernateSpringApp.entities.InstructorDetails;
import hibernateSpringApp.mappers.InstructorDetailsMapper;
import hibernateSpringApp.services.InstructorDetailsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/details-management")
public class InstructorDetailsController {
    @Autowired
    private InstructorDetailsService instructorDetailsService;
    @Autowired
    private InstructorDetailsMapper instructorDetailsMapper;
    @GetMapping("/details")
    public List<InstructorDetails> getAllInstructorsDetails(){
        return instructorDetailsService.getAllDetails();
    }
    @PostMapping("/action=add")
    public ResponseEntity<List<InstructorDetails>> addInstructorDetails(@RequestBody @Valid InstructorDetails instructorDetails) {
        return ResponseEntity.ok(instructorDetailsService.addInstructorDetails(instructorDetails));
    }
    @PutMapping("/action=update")
    public ResponseEntity<List<InstructorDetails>> updateInstructorDetails(@RequestBody @Valid InstructorDetails instructorDetails) {
        return ResponseEntity.ok(instructorDetailsService.updateInstructorDetails(instructorDetails));
    }
    @DeleteMapping("/action=delete")
    public ResponseEntity<List<InstructorDetails>> deleteInstructorDetails(@RequestBody @Valid UUID InstructorDetailsID) {
        return ResponseEntity.ok(instructorDetailsService.deleteInstructorDetails(InstructorDetailsID));
    }
}
