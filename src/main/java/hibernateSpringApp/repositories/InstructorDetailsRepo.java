package hibernateSpringApp.repositories;

import hibernateSpringApp.entities.InstructorDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface InstructorDetailsRepo extends JpaRepository<InstructorDetails, UUID> {
}
