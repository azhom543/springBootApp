package hibernateSpringApp;

import hibernateSpringApp.dtos.InstructorDTO;
import hibernateSpringApp.entities.Instructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class HibernateSpringAppApplication {
	public static void main(String[] args) {
		SpringApplication.run(HibernateSpringAppApplication.class, args);
	}
}
