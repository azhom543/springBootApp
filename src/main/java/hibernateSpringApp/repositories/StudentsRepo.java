package hibernateSpringApp.repositories;

import hibernateSpringApp.entities.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StudentsRepo extends JpaRepository<Students, UUID> {
}
