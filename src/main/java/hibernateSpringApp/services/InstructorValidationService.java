package hibernateSpringApp.services;

import hibernateSpringApp.repositories.InstructorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Service
public class InstructorValidationService {
    @Autowired
    private InstructorRepo instructorRepo;
    private static final String EMAIL_PATTERN = "^[A-Za-z0-9+_.-]+@(.+)$";
    public boolean validatePhoneNumber(String phoneNumber){
        return instructorRepo.existsByPhone(phoneNumber);
    }
    public boolean validateEmail(String email){
        return Pattern.compile(EMAIL_PATTERN).matcher(email).matches();
    }
    protected boolean doesPhoneNumberExistWrapper(String phoneNumber){
        return validatePhoneNumber(phoneNumber);
    }
    protected boolean doesEmailValidWrapper(String email){
        return validateEmail(email);
    }
}
