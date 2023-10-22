package hibernateSpringApp.services;

import hibernateSpringApp.entities.Courses;
import hibernateSpringApp.entities.InstructorDetails;
import hibernateSpringApp.repositories.InstructorDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class InstructorDetailsService {
    @Autowired
    private InstructorDetailsRepo instructorDetailsRepo;

    public List<InstructorDetails> getAllDetails(){
        return instructorDetailsRepo.findAll();
    }
    public List<InstructorDetails> addInstructorDetails(InstructorDetails instructorDetails){
        instructorDetailsRepo.save(instructorDetails);
        return instructorDetailsRepo.findAll();
    }
    public List<InstructorDetails> updateInstructorDetails(InstructorDetails instructorDetails){
        instructorDetailsRepo.save(instructorDetails);
        return instructorDetailsRepo.findAll();
    }
    public List<InstructorDetails> deleteInstructorDetails(UUID instructorDetailsID){
        instructorDetailsRepo.deleteById(instructorDetailsID);
        return instructorDetailsRepo.findAll();
    }
}
