package hibernateSpringApp.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CalcWithMockTest {
    @InjectMocks
    CalcWithMock calcWithMock;
    @Test
    public void testMockAdd(){
        assertEquals(4,calcWithMock.add(2,2));
    }

}