package com.example.virtualLearning.tables;

import com.example.virtualLearning.entity.Users;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "user_tbl")
@NoArgsConstructor
public class UserTable {
    @Id
    @Column(name = "mobile_number")
    private long mobileNumber;
    @Column(name = "full_name")
    private String fullName;
    private String username;
    private String email;
    private String password;
    private String occupation;
    private String gender;
    private String dob;
    private String twitterLink;
    private String facebookLink;

    public UserTable(long mobileNumber, String fullName, String username, String email, String password, String occupation, String gender, String dob, String twitterLink, String facebookLink) {
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

    public Users toUsers() {
        return new Users(this.mobileNumber, this.fullName, this.username, this.email, this.password, this.occupation, this.gender, this.dob, this.twitterLink, this.facebookLink);
    }
}
