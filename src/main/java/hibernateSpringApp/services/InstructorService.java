package hibernateSpringApp.services;

import hibernateSpringApp.entities.Instructor;
import hibernateSpringApp.repositories.InstructorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorService {
    private final InstructorRepo instructorRepo;

    @Autowired
    public InstructorService(InstructorRepo instructorRepository) {
        this.instructorRepo = instructorRepository;
    }

    public List<Instructor> getAllInstructor(){
        return instructorRepo.findAll();
    }
}
