package com.example.virtualLearning.security;

import com.example.virtualLearning.exceptions.CustomExceptions;
import com.example.virtualLearning.repository.UserRepository;
import com.example.virtualLearning.response.ResultInfoConstants;
import com.example.virtualLearning.tables.UserTable;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@Data
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserTable> users = userRepository.findById(Long.parseLong(username));
        if (!users.isPresent()) {
            log.warn("User is not found");
            throw new CustomExceptions(ResultInfoConstants.INVALID_USER);
        }
        return users.map(MyUserDetails::new).get();
    }
}
