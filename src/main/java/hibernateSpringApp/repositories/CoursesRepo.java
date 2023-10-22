package hibernateSpringApp.repositories;
import hibernateSpringApp.dtos.CourseAndInstructorNamesDTO;
import hibernateSpringApp.entities.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CoursesRepo extends JpaRepository<Courses, UUID> {
    @Query("SELECT c.course_name, i.first_name||' '|| i.last_name FROM Courses c JOIN c.instructor i")
    List<CourseAndInstructorNamesDTO> getCourseNameAndInstructorNames();
    @Query("SELECT i.first_name||' '|| i.last_name ,s.firstName||' '|| s.lastName ,c.course_id  FROM Courses c JOIN c.instructor i JOIN studentsSet s")
    List<Object[]> getInstructorCoursesStudents();
}

