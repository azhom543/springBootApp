package hibernateSpringApp.services;

import hibernateSpringApp.entities.Courses;
import hibernateSpringApp.entities.Instructor;
import hibernateSpringApp.repositories.CoursesRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CoursesServiceTest {

    @Mock
    CoursesRepo coursesRepo;
    @InjectMocks
    CoursesService coursesService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void courseService_getAllCourses_listOfCourses() {
        // Arrange
        List<Courses> coursesList = new ArrayList<>();
        coursesList.add(new Courses());

        when(coursesRepo.findAll()).thenReturn(coursesList);

        // Act
        List<Courses> result = coursesService.getAllCourses();

        // Verify that the repository method was called
        verify(coursesRepo, times(1)).findAll();

        // Assert
        assertEquals(coursesList, result);
    }

    @Test
    void courseService_getCourseById_course() {
        // Arrange
        Courses mockCourse = new Courses();
        UUID courseId = UUID.randomUUID();

        when(coursesRepo.findById(courseId)).thenReturn(Optional.of(mockCourse));

        // Act
        Courses result = coursesService.getCourseById(courseId);

        // Verify that the repository method was called
        verify(coursesRepo, times(1)).findById(courseId);

        // Assert
        assertEquals(mockCourse, result);
    }

    @Test
    void courseService_addCourse_addedCourse() {
        // Arrange
        Courses coursesToAdd = new Courses();

        when(coursesRepo.save(coursesToAdd)).thenReturn(coursesToAdd);

        //Act
        Courses addedCourse = coursesService.addCourse(coursesToAdd);

        // Verify that the repository method was called
        verify(coursesRepo, times(1)).save(coursesToAdd);

        // Assert
        assertEquals(coursesToAdd, addedCourse);
    }

    @Test
    void courseService_updateCourse_updatedCourse() {
        //Arrange
        Courses coursesToUpdate = new Courses();
        when(coursesRepo.save(coursesToUpdate)).thenReturn(coursesToUpdate);

        //Act
        Courses updatedCourse = coursesService.updateCourse(coursesToUpdate);

        // Verify that the repository method was called
        verify(coursesRepo, times(1)).save(coursesToUpdate);

        // Assert
        assertEquals(coursesToUpdate, updatedCourse);
    }

    @Test
    void courseService_deleteCourse_true() {
        //Arrange
        UUID courseId = UUID.randomUUID();
        when(coursesRepo.existsById(courseId)).thenReturn(true);

        // Act
        boolean result = coursesService.deleteCourse(courseId);

        // Verify that the repository method was called
        verify(coursesRepo, times(1)).deleteById(courseId);

        // Assert
        assertTrue(result);
    }
    @Test
    void courseService_deleteCourse_false() {
        // Arrange
        UUID courseId = UUID.randomUUID();
        when(coursesRepo.existsById(courseId)).thenReturn(false);

        // Act
        boolean result = coursesService.deleteCourse(courseId);

        // Verify that the repository method was Not called
        verify(coursesRepo, never()).deleteById(courseId);

        // Assert
        assertFalse(result);
    }

}