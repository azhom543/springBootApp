package hibernateSpringApp.controller;

import hibernateSpringApp.entities.Instructor;
import hibernateSpringApp.services.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/instructor-management")
public class InstructorsController {
    private final InstructorService instructorService;

    @Autowired
    public InstructorsController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping("/instructors")
    public List<Instructor> getAllInstructors(){
        return instructorService.getAllInstructor();
    }
}
