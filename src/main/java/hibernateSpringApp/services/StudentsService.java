package hibernateSpringApp.services;

import hibernateSpringApp.entities.Students;
import hibernateSpringApp.repositories.StudentsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class StudentsService {
    @Autowired
    private StudentsRepo studentsRepo;

    public ResponseEntity<List<Students>> getAllStudents(){
        return ResponseEntity.ok(studentsRepo.findAll());
    }
}
