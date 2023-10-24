package hibernateSpringApp.services;

import hibernateSpringApp.dtos.StudentsCoursesInfoDTO;
import hibernateSpringApp.entities.Instructor;
import hibernateSpringApp.entities.Students;
import hibernateSpringApp.repositories.StudentsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service

public class StudentsService {
    @Autowired
    private StudentsRepo studentsRepo;

    public List<Students> getAllStudents(){
        return studentsRepo.findAll();
    }
    public Students getStudentByID(UUID studentID) {
        Optional<Students> student = studentsRepo.findById(studentID);
        return student.orElse(null);
    }
    public List<Students> addStudent(Students student){
        studentsRepo.save(student);
        return studentsRepo.findAll();
    }
    public Students updateStudent(Students student){
        studentsRepo.save(student);
        return student;
    }
    public List<Students> deleteStudent(UUID studentID){
        studentsRepo.deleteById(studentID);
        return studentsRepo.findAll();
    }
    public List<StudentsCoursesInfoDTO> getStudentCourseInfo(){
        return studentsRepo.getStudentCourseInfo();
    }
    public List<StudentsCoursesInfoDTO> getStudentsCourseLevel(){return studentsRepo.getStudentsCourseByLevel();}
}
