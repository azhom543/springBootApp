package hibernateSpringApp.controller;

import hibernateSpringApp.entities.InstructorDetails;
import hibernateSpringApp.services.InstructorDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/details-management")
public class InstructorDetailsController {
    @Autowired
    private InstructorDetailsService instructorDetailsService;

    @GetMapping("/details")
    public List<InstructorDetails> getAllInstructorsDetails(){
        return instructorDetailsService.getAllDetails();
    }
}
