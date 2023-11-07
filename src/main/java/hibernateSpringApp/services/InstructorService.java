package hibernateSpringApp.services;

import hibernateSpringApp.dtos.InstructorDTO;
import hibernateSpringApp.entities.Instructor;
import hibernateSpringApp.entities.InstructorDetails;
import hibernateSpringApp.entities.Students;
import hibernateSpringApp.repositories.InstructorRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class InstructorService {
    @Autowired
    private InstructorRepo instructorRepo;
    @Autowired
    private InstructorValidationService instructorValidationService;

    @Cacheable("instructorCache")
    public List<Instructor> getAllInstructor(){
        return instructorRepo.findAll();
    }
    public Instructor getInstructorById(UUID id){
        Optional<Instructor> instructor = instructorRepo.findById(id);
        return instructor.orElse(null);
    }
    public Instructor addInstructor(Instructor instructor){
        if(!instructorValidationService.doesPhoneNumberExistWrapper(instructor.getPhone()) && instructorValidationService.doesEmailValidWrapper(instructor.getEmail())){
            return instructorRepo.save(instructor);
        }else
            throw new RuntimeException("Error Email is not Valid or Phone number already exists");
    }
    public Instructor updateInstructor(Instructor instructor){
        if(!instructorValidationService.doesPhoneNumberExistWrapper(instructor.getPhone()) && instructorValidationService.doesEmailValidWrapper(instructor.getEmail())){
            instructorRepo.save(instructor);
            return instructor;
        }else
            throw new RuntimeException("Error Email is not Valid or Phone number already exists");

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
