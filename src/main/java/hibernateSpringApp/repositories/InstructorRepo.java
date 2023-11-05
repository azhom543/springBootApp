package hibernateSpringApp.repositories;

import hibernateSpringApp.entities.Instructor;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface InstructorRepo extends JpaRepository<Instructor, UUID> {
    public boolean existsByPhone(String phone);
}
