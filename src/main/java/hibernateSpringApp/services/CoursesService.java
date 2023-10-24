package hibernateSpringApp.services;

import hibernateSpringApp.dtos.CourseInstructorDTO;
import hibernateSpringApp.dtos.InstructorCoursesStudentsDTO;
import hibernateSpringApp.repositories.CoursesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hibernateSpringApp.entities.Courses;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CoursesService {
    @Autowired
    private CoursesRepo coursesRepo;
    public List<Courses> getAllCourses() {
        return coursesRepo.findAll();
    }
    public Courses getCourseById(UUID id){
        Optional<Courses> coursesOptional = coursesRepo.findById(id);
        return coursesOptional.orElse(null);
    }
    public List<Courses> addCourse(Courses courses){
        coursesRepo.save(courses);
        return coursesRepo.findAll();
    }
    public Courses updateCourse(Courses course){
        coursesRepo.save(course);
        return course;
    }
    public List<Courses> deleteCourse(UUID courseID){
        coursesRepo.deleteById(courseID);
        return coursesRepo.findAll();
    }
    public List<CourseInstructorDTO> getCourseNameAndInstructorNames() {
        return coursesRepo.getCourseNameAndInstructorNames();
    }
    public List<InstructorCoursesStudentsDTO> getInstructorCoursesStudents(){return coursesRepo.getInstructorCoursesStudents();}
    public List<Courses> getCoursesByInstructorName(String instructorName){return coursesRepo.findByInstructorFirstName(instructorName);}
}
