package hibernateSpringApp.services;

import hibernateSpringApp.entities.InstructorDetails;
import hibernateSpringApp.repositories.InstructorDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorDetailsService {
    @Autowired
    private InstructorDetailsRepo instructorDetailsRepo;

    public List<InstructorDetails> getAllDetails(){
        return instructorDetailsRepo.findAll();
    }
}
