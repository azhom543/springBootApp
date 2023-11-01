package hibernateSpringApp.services;

import hibernateSpringApp.dtos.InstructorDTO;
import hibernateSpringApp.entities.Instructor;
import hibernateSpringApp.entities.InstructorDetails;
import hibernateSpringApp.entities.Students;
import hibernateSpringApp.repositories.InstructorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class InstructorService {
    @Autowired
    private InstructorRepo instructorRepo;

    public List<Instructor> getAllInstructor(){
        return instructorRepo.findAll();
    }
    public Instructor getInstructorById(UUID id){
        Optional<Instructor> instructor = instructorRepo.findById(id);
        return instructor.orElse(null);
    }
    public Instructor addInstructor(Instructor instructor){
        return instructorRepo.save(instructor);
    }
    public Instructor updateInstructor(Instructor instructor){
        instructorRepo.save(instructor);
        return instructor;
    }
    public boolean deleteInstructor(UUID instructorId) {
        // Check if the instructor with the given ID exists
        if (instructorRepo.existsById(instructorId)) {
            instructorRepo.deleteById(instructorId);
            return true; // Instructor deleted successfully
        } else {
            return false; // Instructor with the given ID does not exist
        }
    }
}
