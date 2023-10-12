package hibernateSpringApp.controller;

import hibernateSpringApp.entities.Students;
import hibernateSpringApp.services.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students-management")
public class StudentsController {
    @Autowired
    private StudentsService studentsService;

    @GetMapping("/students")
    public ResponseEntity<List<Students>> getAllStudents(){
        return studentsService.getAllStudents();
    }


}
