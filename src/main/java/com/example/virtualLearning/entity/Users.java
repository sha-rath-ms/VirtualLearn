package com.example.virtualLearning.entity;

import com.example.virtualLearning.tables.UserTable;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Data
public class Users {
    @Id
    private long mobileNumber;
    @NotBlank
    private String fullName;
    @NotBlank
    private String username;
    @NotBlank
    private String email;
    @NotBlank
    private String password;

    public Users(long mobileNumber, String fullName, String username, String email, String password) {
        this.mobileNumber = mobileNumber;
        this.fullName = fullName;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public UserTable toUserTable(PasswordEncoder passwordEncoder) {
        return new UserTable(this.mobileNumber, this.fullName, this.username, this.email, passwordEncoder.encode(this.password));
    }
}
