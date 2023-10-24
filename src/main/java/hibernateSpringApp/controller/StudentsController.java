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
    public ResponseEntity<List<StudentsDTO>> addStudent(@RequestBody @Valid StudentsDTO student) {
        Students studentEntity = studentsMapper.toEntity(student);
        List<Students> studentsList = studentsService.addStudent(studentEntity);
        return ResponseEntity.ok(studentsList.stream()
                .map(studentsMapper::toDTO)
                .collect(Collectors.toList()));
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
    public ResponseEntity<List<StudentsDTO>> deleteStudent(@RequestParam @Valid UUID studentID) {
        Students student = studentsService.getStudentByID(studentID);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        List<Students> studentsList = studentsService.deleteStudent(studentID);
        return ResponseEntity.ok(studentsList.stream()
                .map(studentsMapper::toDTO)
                .collect(Collectors.toList()));
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
