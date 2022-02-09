package com.example.virtualLearning.service;

import com.example.virtualLearning.entity.Users;
import com.example.virtualLearning.exceptions.CustomExceptions;
import com.example.virtualLearning.repository.UserRepository;
import com.example.virtualLearning.response.ResultInfoConstants;
import com.example.virtualLearning.validations.Validations;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@Data
@RequiredArgsConstructor
public class UserService {

    private final Validations validations;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

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
}
