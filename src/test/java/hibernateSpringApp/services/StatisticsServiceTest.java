package hibernateSpringApp.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class StatisticsServiceTest {


    @Mock
    UserService userServiceMock;


    @InjectMocks
    StatisticsService statisticsService;


    @Test
    void user_count_percent_is_20() {


        System.out.println("user_count_percent_is_20 test");


        doReturn(10).when(userServiceMock).getUsersCount();


        double actual = statisticsService.usersCountPercent();


        assertEquals(20,actual);
    }


    @Test
    void say_hello_successfully() {
        System.out.println("say_hello_successfully test");
        String actual = statisticsService.sayHello();
        assertEquals("hello",actual);
    }
}

