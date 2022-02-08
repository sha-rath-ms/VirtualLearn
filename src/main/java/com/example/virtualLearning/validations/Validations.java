package com.example.virtualLearning.validations;

import com.example.virtualLearning.exceptions.HandleAllExceptions;
import com.example.virtualLearning.response.ResultInfoConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
@Slf4j
public class Validations {
    public void validateMobileNumber(long mobileNumber) {
        String mobile = String.valueOf(mobileNumber);
        Pattern pattern = Pattern.compile("(0/91)?[7-9][0-9]{9}");
        Matcher matcher = pattern.matcher(mobile);
        if (!matcher.matches()) {
            log.warn("User mobile number is not valid");
            throw new HandleAllExceptions(ResultInfoConstants.MOBILE_NUMBER_VALIDATION);
        }
    }

    public void validateEmail(String email){
        Pattern pattern=Pattern.compile("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$");
        Matcher matcher=pattern.matcher(email);
        if(!matcher.matches()){
            log.warn("Email is invalid");
            throw new HandleAllExceptions(ResultInfoConstants.EMAIL_VALIDATION);
        }
    }
}
