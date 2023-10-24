package hibernateSpringApp.services;

import org.springframework.stereotype.Service;

@Service
public class CalcWithMock {
    public int add(int numberA, int numberB) {
        return numberA + numberB;
    }
}
