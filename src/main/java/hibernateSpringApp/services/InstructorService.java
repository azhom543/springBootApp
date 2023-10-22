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
    public List<Instructor> addInstructor(Instructor instructor){
        instructorRepo.save(instructor);
        return instructorRepo.findAll();
    }
    public Instructor updateInstructor(Instructor instructor){
        instructorRepo.save(instructor);
        return instructor;
    }
    public List<Instructor> deleteInstructor(UUID instructorID){
        instructorRepo.deleteById(instructorID);
        return instructorRepo.findAll();
    }
}
