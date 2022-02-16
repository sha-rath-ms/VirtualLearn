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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@Data
@RequiredArgsConstructor
public class UserService {

    private final Validations validations;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final OtpRepository otpRepository;

    public void sendOtp(Long mobileNumber) {
        validations.validateMobileNumber(mobileNumber);
        try {
            otpRepository.deleteById(mobileNumber);
        } catch (Exception ignored) {

        }
        otpRepository.save(new OtpToken(mobileNumber));

    }

    public void verifyOtp(Long mobileNumber, int otp) {
       OtpToken otpToken = otpRepository.findById(mobileNumber).orElseThrow();
       boolean verification=otpToken.getOtp() == otp;
       if(verification){
           otpToken.setVerification(true);
           otpRepository.save(otpToken);

       }
       else{
           throw new CustomExceptions(ResultInfoConstants.INVALID_OTP);
       }


    }

    public boolean insert(Users users) {
        if (userRepository.existsById(users.getMobileNumber())) {
            log.warn("User is already present with id:{}", users.getMobileNumber());
            throw new CustomExceptions(ResultInfoConstants.DUPLICATE_USER);
        }
        validations.validateMobileNumber(users.getMobileNumber());
        validations.validateEmail(users.getEmail());
        OtpToken otpToken = otpRepository.findById(users.getMobileNumber()).orElseThrow();
        if(otpToken.getVerification()){
            userRepository.save(users.toUserTable(passwordEncoder));
            otpRepository.deleteById(users.getMobileNumber());
        }
        else{
            throw new CustomExceptions(ResultInfoConstants.OTP_NOT_VALIDATED);
        }
        return true;
    }
    public void forgotPassword(Long mobileNumber) {

        Optional<UserTable> inBase = userRepository.findById(mobileNumber);
        if (inBase.isEmpty()) {
            throw new CustomExceptions(ResultInfoConstants.INVALID_USER);
        }
        sendOtp(mobileNumber);
    }

    public void updateUser(Long mobileNumber,String newPassword) {
        if(otpRepository.getById(mobileNumber).getVerification()){
            UserTable oldUser = userRepository.findById(mobileNumber).orElseThrow();
            oldUser.setPassword(passwordEncoder.encode(newPassword));
            userRepository.save(oldUser);
        }
       else{
           throw new CustomExceptions(ResultInfoConstants.OTP_NOT_VALIDATED);
        }

    }

    public void updateUserDetails(Users users)
    {
        Optional<UserTable> oldUser = userRepository.findById(users.getMobileNumber());
        if(!oldUser.isPresent())
        {
            throw new CustomExceptions(ResultInfoConstants.INVALID_ID);
        }
        users.setPassword(oldUser.get().getPassword());
        userRepository.save(users.toUpdateUserTable());
    }

    public void changePassword(long userId,String password)
    {
        Optional<UserTable> oldUser = userRepository.findById(userId);
        if(!oldUser.isPresent())
        {
            throw new CustomExceptions(ResultInfoConstants.INVALID_ID);
        }
        Users newUser = oldUser.get().toUsers();
        newUser.setPassword(password);
        userRepository.save(newUser.toUserTable(passwordEncoder));
    }
}
