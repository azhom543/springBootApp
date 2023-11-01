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
    public Students addStudent(Students student){
        return studentsRepo.save(student);
    }
    public Students updateStudent(Students student){
        studentsRepo.save(student);
        return student;
    }
    public boolean deleteStudent(UUID studentID){
        if (studentsRepo.existsById(studentID)) {
            studentsRepo.deleteById(studentID);
            return true;
        } else {
            return false;
        }
    }
    public List<StudentsCoursesInfoDTO> getStudentCourseInfo(){
        return studentsRepo.getStudentCourseInfo();
    }
    public List<StudentsCoursesInfoDTO> getStudentsCourseLevel(){return studentsRepo.getStudentsCourseByLevel();}
}
