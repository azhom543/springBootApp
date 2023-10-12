package hibernateSpringApp.services;

import hibernateSpringApp.repositories.CoursesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hibernateSpringApp.entities.Courses;

import java.util.List;

@Service
public class CoursesService {
    @Autowired
    private CoursesRepo coursesRepo;
    public List<Courses> getAllCourses() {
        return coursesRepo.findAll();
    }
}
