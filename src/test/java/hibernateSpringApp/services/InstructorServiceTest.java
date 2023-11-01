package hibernateSpringApp.services;

import hibernateSpringApp.dtos.InstructorDTO;
import hibernateSpringApp.entities.Instructor;
import hibernateSpringApp.repositories.InstructorRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class InstructorServiceTest {

    @Mock
    InstructorRepo instructorRepo;
    @InjectMocks
    InstructorService instructorService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void getAllInstructor() {
        // Arrange
        List<Instructor> instructorList = new ArrayList<>();
        instructorList.add(new Instructor());

        when(instructorRepo.findAll()).thenReturn(instructorList);

        // Act
        List<Instructor> result = instructorService.getAllInstructor();

        // Verify that the repository method was called
        verify(instructorRepo, times(1)).findAll();

        // Assert
        assertEquals(instructorList, result);
    }

    @Test
    void getInstructorById() {
        // Arrange
        Instructor mockInstructor = new Instructor();
        UUID instructorId = UUID.randomUUID();

        when(instructorRepo.findById(instructorId)).thenReturn(Optional.of(mockInstructor));

        // Act
        Instructor result = instructorService.getInstructorById(instructorId);

        // Verify that the repository method was called
        verify(instructorRepo, times(1)).findById(instructorId);

        // Assert
        assertEquals(mockInstructor, result);
    }

    @Test
    public void testAddInstructor() {
        // Arrange
        Instructor instructorToAdd = new Instructor();

        when(instructorRepo.save(instructorToAdd)).thenReturn(instructorToAdd);

        //Act
        Instructor addedInstructor = instructorService.addInstructor(instructorToAdd);

        // Verify that the repository method was called
        verify(instructorRepo, times(1)).save(instructorToAdd);

        // Assert
        assertEquals(instructorToAdd, addedInstructor);
    }

    @Test
    void updateInstructor() {
        //Arrange
        Instructor instructorToUpdate = new Instructor();
        when(instructorRepo.save(instructorToUpdate)).thenReturn(instructorToUpdate);

        //Act
        Instructor updatedInstructor = instructorService.updateInstructor(instructorToUpdate);

        // Verify that the repository method was called
        verify(instructorRepo, times(1)).save(instructorToUpdate);

        // Assert
        assertEquals(instructorToUpdate, updatedInstructor);
    }

    @Test
    void deleteInstructorSuccess() {
        //Arrange
        UUID instructorId = UUID.randomUUID();
        when(instructorRepo.existsById(instructorId)).thenReturn(true);

        // Act
        boolean result = instructorService.deleteInstructor(instructorId);

        // Verify that the repository method was called
        verify(instructorRepo, times(1)).deleteById(instructorId);

        // Assert
        assertTrue(result);
    }
    @Test
    void deleteInstructorFail() {
        // Arrange
        UUID instructorId = UUID.randomUUID();
        when(instructorRepo.existsById(instructorId)).thenReturn(false);

        // Act
        boolean result = instructorService.deleteInstructor(instructorId);

        // Verify that the repository method was Not called
        verify(instructorRepo, never()).deleteById(instructorId);

        // Assert
        assertFalse(result);
    }

}