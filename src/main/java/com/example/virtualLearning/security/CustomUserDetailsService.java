package com.example.virtualLearning.security;

import com.example.virtualLearning.repository.UserRepository;
import com.example.virtualLearning.tables.UserTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<UserTable> user = userRepository.findById(Long.parseLong(username));
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("User Not Found");
        }
        return new CustomUserDetails(user.get());
    }

}
