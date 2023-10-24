package hibernateSpringApp.services;

import org.junit.jupiter.api.function.Executable;
import org.springframework.stereotype.Service;

@Service

public class Calculator {
    public int add(int number1, int number2)
    {
        if (number2 == 0){
        throw new ArithmeticException("Any addition to zero results same number");
        }
        return number1 + number2;
    }
    public int subtract(int number1, int number2)
    {
        if (number2 > number1){
            throw new ArithmeticException("Negative Results");
        }
        return number1 - number2;
    }
    public int multiply(int number1, int number2)
    {
        if (number2 == 0 || number1 == 0){
            throw new ArithmeticException("Any Multiplication by zero results zero");
        }
        return number1 * number2;
    }
    public int divide(int number1, int number2)
    {
        if (number2 == 0){
            throw new ArithmeticException("Cannot Divide by zero");
        }
        return number1 / number2;
    }
}
