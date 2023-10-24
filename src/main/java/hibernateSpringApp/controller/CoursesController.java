package hibernateSpringApp.controller;

import hibernateSpringApp.dtos.CourseInstructorDTO;
import hibernateSpringApp.dtos.CoursesDTO;
import hibernateSpringApp.dtos.InstructorCoursesStudentsDTO;
import hibernateSpringApp.entities.Courses;
import hibernateSpringApp.mappers.CoursesMapper;
import hibernateSpringApp.services.CoursesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/courses")
public class CoursesController {
    @Autowired
    private CoursesService coursesService;
    @Autowired
    private CoursesMapper coursesMapper;
    @GetMapping("/courses")
    public List<CoursesDTO> getAllCourses() {
        List<Courses> courses = coursesService.getAllCourses();
        return courses.stream()
                .map(coursesMapper::toDTO)
                .collect(Collectors.toList());
    }
    @GetMapping("/courses/{courseId}")
    public ResponseEntity<CoursesDTO> getAllCourses(@PathVariable UUID courseId) {
        Courses course = coursesService.getCourseById(courseId);
        if (course == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(coursesMapper.toDTO(course));
    }
    @PostMapping("/action=add")
    public ResponseEntity<List<CoursesDTO>> addCourse(@RequestBody @Valid CoursesDTO course) {
        Courses courseEntity = coursesMapper.toEntity(course);
        List<Courses> coursesList = coursesService.addCourse(courseEntity);
        return ResponseEntity.ok(coursesList.stream()
                .map(coursesMapper::toDTO)
                .collect(Collectors.toList()));
    }
    @PutMapping("/action=update")
    public ResponseEntity<CoursesDTO> updateCourse(@RequestBody @Valid CoursesDTO course) {
        Courses coursesEntity = coursesMapper.toEntity(course);
        if (coursesEntity == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(coursesMapper.toDTO(coursesService.updateCourse(coursesEntity)));
    }
    @DeleteMapping("/action=delete/{courseID}")
    public ResponseEntity<List<CoursesDTO>> deleteCourse(@RequestBody @Valid UUID courseID) {
        List<Courses> coursesList = coursesService.deleteCourse(courseID);
        return ResponseEntity.ok(coursesList.stream()
                .map(coursesMapper::toDTO)
                .collect(Collectors.toList()));
    }
    @GetMapping("/course-names-and-instructors")
    public List<CourseInstructorDTO> getCourseNameAndInstructorNames() {
        return coursesService.getCourseNameAndInstructorNames();
    }
    @GetMapping("/instructor-courses-students")
    public List<InstructorCoursesStudentsDTO> getInstructorCoursesStudents() {
        return coursesService.getInstructorCoursesStudents();
    }
    @GetMapping("/{instructorName}")
    public List<Courses> getCoursesByInstructor(@PathVariable String instructorName) {
        return coursesService.getCoursesByInstructorName(instructorName);
    }
}
