package hibernateSpringApp.controller;

import hibernateSpringApp.entities.Courses;
import hibernateSpringApp.services.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CoursesController {
    @Autowired
    private CoursesService coursesService;

    @GetMapping("/courses")
    public List<Courses> getAllCourses() {
        return coursesService.getAllCourses();
    }
}
