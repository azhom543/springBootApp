package hibernateSpringApp.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CalcWithMockTest {
    @Mock
    private Calculator calculator;
    @Test
    public void testAdd() {

        Mockito.when(calculator.add(5, 3)).thenReturn(8);

        int result = calculator.add(5, 3);

        assertEquals(8, result);
    }

    @Test
    public void testSubtract() {

        Mockito.when(calculator.subtract(10, 4)).thenReturn(6);

        int result = calculator.subtract(10, 4);

        assertEquals(6, result);
    }

    @Test
    public void testMultiply() {

        Mockito.when(calculator.multiply(3, 2)).thenReturn(6);

        int result = calculator.multiply(3, 2);

        assertEquals(6, result);
    }

    @Test
    public void testDivide() {

        Mockito.when(calculator.divide(8, 2)).thenReturn(4);

        int result = calculator.divide(8, 2);

        assertEquals(4, result);
    }

    @Test
    public void testDivideByZero() {
        Mockito.when(calculator.divide(10, 0)).thenThrow(new ArithmeticException("Cannot Divide by zero"));
        assertThrows(ArithmeticException.class, () -> calculator.divide(10, 0));
    }
}