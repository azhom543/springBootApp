package hibernateSpringApp.services;

import hibernateSpringApp.dtos.StudentsCoursesInfoDTO;
import hibernateSpringApp.dtos.StudentsDTO;
import hibernateSpringApp.entities.Instructor;
import hibernateSpringApp.entities.Students;
import hibernateSpringApp.repositories.StudentsRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.*;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentsServiceTest {
    @Mock
    private StudentsRepo studentsRepo;

    @InjectMocks
    private StudentsService studentsService;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllStudents() {
        // Arrange
        List<Students> studentsList = new ArrayList<>();
        studentsList.add(new Students());

        when(studentsRepo.findAll()).thenReturn(studentsList);

        // Act
        List<Students> result = studentsService.getAllStudents();

        // Verify that the repository method was called
        verify(studentsRepo, times(1)).findAll();

        // Assert
        assertEquals(studentsList, result);
    }

    @Test
    public void testGetStudentsById(){
        // Arrange
        Students mockStudent = new Students();
        UUID studentId = UUID.randomUUID();

        when(studentsRepo.findById(studentId)).thenReturn(Optional.of(mockStudent));

        // Act
        Students result = studentsService.getStudentByID(studentId);

        // Verify that the repository method was called
        verify(studentsRepo, times(1)).findById(studentId);

        // Assert
        assertEquals(mockStudent, result);
    }
    @Test
    public void testAddStudent() {
        // Arrange
        Students studentToAdd = new Students();
        when(studentsRepo.save(studentToAdd)).thenReturn(studentToAdd);

        //Act
        Students addedStudent = studentsService.addStudent(studentToAdd);

        // Verify that the repository method was called
        verify(studentsRepo, times(1)).save(studentToAdd);

        // Assert
        assertEquals(studentToAdd, addedStudent);
    }
    @Test
    void updateStudent() {
        //Arrange
        Students studentToUpdate = new Students();
        when(studentsRepo.save(studentToUpdate)).thenReturn(studentToUpdate);

        //Act
        Students updatedStudent = studentsService.updateStudent(studentToUpdate);

        // Verify that the repository method was called
        verify(studentsRepo, times(1)).save(studentToUpdate);

        // Assert
        assertEquals(studentToUpdate, updatedStudent);
    }
    @Test
    void deleteStudent_Success() {
        //Arrange
        UUID studentId = UUID.randomUUID();
        when(studentsRepo.existsById(studentId)).thenReturn(true);

        // Act
        boolean result = studentsService.deleteStudent(studentId);

        // Verify that the repository method was called
        verify(studentsRepo, times(1)).deleteById(studentId);

        // Assert
        assertTrue(result);
    }
    @Test
    void deleteStudent_Fail() {
        // Arrange
        UUID studentId = UUID.randomUUID();
        when(studentsRepo.existsById(studentId)).thenReturn(false);

        // Act
        boolean result = studentsService.deleteStudent(studentId);

        // Verify that the repository method was Not called
        verify(studentsRepo, never()).deleteById(studentId);

        // Assert
        assertFalse(result);
    }
//
}