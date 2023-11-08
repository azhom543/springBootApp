package hibernateSpringApp.services;

import hibernateSpringApp.config.RedisService;
import hibernateSpringApp.dtos.InstructorDTO;
import hibernateSpringApp.entities.Instructor;
import hibernateSpringApp.entities.InstructorDetails;
import hibernateSpringApp.entities.Students;
import hibernateSpringApp.repositories.InstructorRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
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
    @Autowired
    private RedisService redisService;
//    @Cacheable("instructorCache")
    public List<Instructor> getAllInstructor(){
        // Check if data is cached in Redis
        Optional<List<Instructor>> cachedData = redisService.getValueFromRedis("instructorCache");
        if (cachedData.isPresent()) {
            System.out.println("OOOOOOOOOOOOOPS");
            return cachedData.get();
        } else {
            // If not cached, fetch data from the repository and cache it
            List<Instructor> instructors = instructorRepo.findAll();
            redisService.saveExpireDataInRedis("instructorCache", instructors, 60);
            return instructors;
        }
    }
    public Instructor getInstructorById(UUID id){
        Optional<Instructor> instructor = instructorRepo.findById(id);
        return instructor.orElse(null);
    }
    @CacheEvict(value = "instructorCache", allEntries = true)  // Clear the entire cache when a new instructor is added
    public Instructor addInstructor(Instructor instructor) {
        if (!instructorValidationService.doesPhoneNumberExistWrapper(instructor.getPhone()) && instructorValidationService.doesEmailValidWrapper(instructor.getEmail())) {
            Instructor savedInstructor = instructorRepo.save(instructor);  // Save the instructor to the database
            List<Instructor> instructors = instructorRepo.findAll();
            redisService.saveExpireDataInRedis("instructorCache", instructors, 10);  // Cache the updated instructor list
            return savedInstructor;
        } else {
            throw new RuntimeException("Error Email is not Valid or Phone number already exists");
        }
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
