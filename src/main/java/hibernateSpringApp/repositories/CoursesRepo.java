package hibernateSpringApp.repositories;
import hibernateSpringApp.entities.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursesRepo extends JpaRepository<Courses, Long> {
}

