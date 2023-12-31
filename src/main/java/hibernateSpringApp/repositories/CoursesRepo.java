package hibernateSpringApp.repositories;
import hibernateSpringApp.dtos.CourseInstructorDTO;
import hibernateSpringApp.dtos.InstructorCoursesDTO;
import hibernateSpringApp.dtos.InstructorCoursesStudentsDTO;
import hibernateSpringApp.entities.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CoursesRepo extends JpaRepository<Courses, UUID> {
    @Query("SELECT NEW hibernateSpringApp.dtos.CourseInstructorDTO(c.course_name, i.firstName || ' ' || i.lastName) FROM Courses c JOIN c.instructor i")
    List<CourseInstructorDTO> getCourseNameAndInstructorNames();
    @Query("SELECT NEW hibernateSpringApp.dtos.InstructorCoursesStudentsDTO(i.firstName||' '|| i.lastName ,s.firstName||' '|| s.lastName ,c.course_id)  FROM Courses c JOIN c.instructor i JOIN studentsSet s")
    List<InstructorCoursesStudentsDTO> getInstructorCoursesStudents();
    @Query(nativeQuery = true, value = "SELECT i.first_name || ' ' || i.last_name AS instructor_name, " +
            "string_agg(c.course_name, ', ') AS course_names " +
            "FROM courses c JOIN instructor i ON c.instructor_id = i.instructor_id " +
            "GROUP BY instructor_name")
    List<Object[]> getInstructorsAndTheirCoursesRaw();
    List<Courses> findByInstructorFirstName(String firstName);
}

