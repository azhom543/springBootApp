package hibernateSpringApp.repositories;
import hibernateSpringApp.dtos.CourseInstructorDTO;
import hibernateSpringApp.dtos.InstructorCoursesStudentsDTO;
import hibernateSpringApp.entities.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CoursesRepo extends JpaRepository<Courses, UUID> {
    @Query("SELECT NEW hibernateSpringApp.dtos.CourseInstructorDTO(c.course_name, i.firstName || ' ' || i.last_name) FROM Courses c JOIN c.instructor i")
    List<CourseInstructorDTO> getCourseNameAndInstructorNames();
    @Query("SELECT NEW hibernateSpringApp.dtos.InstructorCoursesStudentsDTO(i.firstName||' '|| i.last_name ,s.firstName||' '|| s.lastName ,c.course_id)  FROM Courses c JOIN c.instructor i JOIN studentsSet s")
    List<InstructorCoursesStudentsDTO> getInstructorCoursesStudents();

    List<Courses> findByInstructorFirstName(String firstName);
}

