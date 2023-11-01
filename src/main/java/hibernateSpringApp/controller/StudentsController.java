package hibernateSpringApp.controller;

import hibernateSpringApp.dtos.StudentsCoursesInfoDTO;
import hibernateSpringApp.dtos.StudentsDTO;
import hibernateSpringApp.entities.Instructor;
import hibernateSpringApp.entities.Students;
import hibernateSpringApp.mappers.StudentsMapper;
import hibernateSpringApp.services.StudentsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/students-management")
public class StudentsController {
    @Autowired
    private StudentsService studentsService;
    @Autowired
    private StudentsMapper studentsMapper;
    @GetMapping("/students")
    public ResponseEntity<List<StudentsDTO>> getAllStudents(){
        List<Students> studentsList = studentsService.getAllStudents();
        return ResponseEntity.ok(studentsList.stream()
                .map(studentsMapper::toDTO)
                .collect(Collectors.toList()));
    }
    @GetMapping("/students/{id}")
    public ResponseEntity<StudentsDTO> getByID(@PathVariable UUID id) {
        Students student = studentsService.getStudentByID(id);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentsMapper.toDTO(student));
    }
    @PostMapping("/action=add")
    public ResponseEntity<StudentsDTO> addStudent(@RequestBody @Valid StudentsDTO student) {
        Students studentEntity = studentsMapper.toEntity(student);
        StudentsDTO studentAdded = studentsMapper.toDTO(studentsService.addStudent(studentEntity));
        return ResponseEntity.ok(studentAdded);
    }
    @PutMapping("/action=update")
    public ResponseEntity<StudentsDTO> updateIStudent(@RequestBody @Valid StudentsDTO student) {
        Students studentEntity = studentsMapper.toEntity(student);
        if (studentEntity == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentsMapper.toDTO(studentsService.updateStudent(studentEntity)));
    }
    @DeleteMapping("/action=delete/{id}")
    public ResponseEntity deleteStudent(@RequestParam @Valid UUID studentID) {
        boolean found = studentsService.deleteStudent(studentID);
        if (!found) {
            return ResponseEntity.notFound().build();
        }else return ResponseEntity.ok().build();
    }
    @GetMapping("/student-course-info")
    public ResponseEntity<List<StudentsCoursesInfoDTO>> getStudentCourseInfo(){
        return ResponseEntity.ok(studentsService.getStudentCourseInfo());
    }
    @GetMapping("/student-course-level")
    public ResponseEntity<List<StudentsCoursesInfoDTO>> getStudentsCourseByLevel(){
        return ResponseEntity.ok(studentsService.getStudentsCourseLevel());
    }
}
