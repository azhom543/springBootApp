package hibernateSpringApp.repositories;

import hibernateSpringApp.dtos.StudentsCoursesInfoDTO;
import hibernateSpringApp.entities.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface StudentsRepo extends JpaRepository<Students, UUID> {
    @Query("SELECT NEW hibernateSpringApp.dtos.StudentsCoursesInfoDTO(c.course_name, c.start_date, s.firstName ||' '|| s.lastName) FROM Students s JOIN s.coursesSet c")
    List<StudentsCoursesInfoDTO> getStudentCourseInfo();
    @Query("SELECT NEW hibernateSpringApp.dtos.StudentsCoursesInfoDTO(c.course_name, c.start_date, s.firstName ||' '|| s.lastName) FROM Students s JOIN s.coursesSet c where c.level ='Medium'")
    List<StudentsCoursesInfoDTO> getStudentsCourseByLevel();
}
