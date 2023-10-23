package hibernateSpringApp.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
//@SpringBootTest //performance issues as it will start the whole program first
class CalculatorTest {
    private Calculator calculator = new Calculator();
    @Test
    public void testAdd(){
        assertEquals(4,calculator.add(2,2));
    }
    @Test
    public void testSubtraction(){
        assertEquals(0,calculator.subtract(2,2));
    }
    @Test
    public void testMultiplication(){
        assertEquals(24,calculator.multiply(3,8));
    }
    @Test
    public void testDivision(){
        assertEquals(5,calculator.divide(25,5));
    }
}