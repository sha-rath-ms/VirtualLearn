package com.example.virtualLearning.service;

import com.example.virtualLearning.entity.OtpToken;
import com.example.virtualLearning.entity.Users;
import com.example.virtualLearning.exceptions.CustomExceptions;
import com.example.virtualLearning.repository.OtpRepository;
import com.example.virtualLearning.repository.UserRepository;
import com.example.virtualLearning.response.ResultInfoConstants;
import com.example.virtualLearning.tables.UserTable;
import com.example.virtualLearning.validations.Validations;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Pattern;
import java.util.Optional;

@Service
@Slf4j
@Data
@RequiredArgsConstructor
public class UserService {

    private final Validations validations;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    private final OtpRepository otpRepository;

    public void sendOtp(String mobileNumber) {

        try {
            otpRepository.deleteById(mobileNumber);
        } catch (Exception ignored) {

        }
        otpRepository.save(new OtpToken(mobileNumber));

    }

    private boolean verifyOtp(String mobileNumber, int otp) {
       OtpToken otpToken = otpRepository.findById(mobileNumber).orElseThrow();
        return otpToken.getOtp() == otp;
    }


    public boolean insert(Users users) {
        if (userRepository.existsById(users.getMobileNumber())) {
            log.warn("User is already present with id:{}", users.getMobileNumber());
            throw new CustomExceptions(ResultInfoConstants.DUPLICATE_USER);
        }
        validations.validateMobileNumber(users.getMobileNumber());
        validations.validateEmail(users.getEmail());
        userRepository.save(users.toUserTable(passwordEncoder));
        return true;
    }
    public void forgotPassword(Long mobileNumber) {

        Optional<UserTable> inBase = userRepository.findById(mobileNumber);
        if (inBase.isEmpty()) {
            throw new CustomExceptions(ResultInfoConstants.INVALID_USER);
        }
        sendOtp(mobileNumber.toString());
    }

    public void updateUser(Users user, int otp) {
        if (verifyOtp(user.getMobileNumber().toString(), otp)) {
            UserTable updatedUser = user.toUserTable(passwordEncoder);
            //TODO: ADD equalent of userrepository.updateuser(mobilenumber,password)
            otpRepository.deleteById(user.getMobileNumber().toString());
        } else {
            throw new CustomExceptions(ResultInfoConstants.INVALID_USER);
        }

    }
}
