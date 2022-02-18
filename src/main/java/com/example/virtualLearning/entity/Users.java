package com.example.virtualLearning.entity;

import com.example.virtualLearning.tables.UserTable;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Data

public class Users {
    @Id
    private Long mobileNumber;
    @NotBlank
    private String fullName;
    @NotBlank
    private String username;
    @NotBlank
    private String email;
    @NotBlank
    private String password;
    private String occupation;
    private String gender;
    private String dob;
    private String twitterLink;
    private String facebookLink;

    public Users(Long mobileNumber, String fullName, String username, String email, String password, String occupation, String gender, String dob, String twitterLink, String facebookLink) {
        this.mobileNumber = mobileNumber;
        this.fullName = fullName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.occupation = occupation;
        this.gender = gender;
        this.dob = dob;
        this.twitterLink = twitterLink;
        this.facebookLink = facebookLink;
    }

    public UserTable toUserTable(PasswordEncoder passwordEncoder) {
        return new UserTable(this.mobileNumber, this.fullName, this.username, this.email, passwordEncoder.encode(this.password), this.occupation, this.gender, this.dob, this.twitterLink, this.facebookLink);
    }

    public UserTable toUpdateUserTable() {
        return new UserTable(this.mobileNumber, this.fullName, this.username, this.email,this.password, this.occupation, this.gender, this.dob, this.twitterLink, this.facebookLink);
    }
}
