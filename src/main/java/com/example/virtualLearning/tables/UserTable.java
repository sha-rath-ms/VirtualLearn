package com.example.virtualLearning.tables;

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

    public UserTable(long mobileNumber, String fullName, String username, String email, String password) {
        this.mobileNumber = mobileNumber;
        this.fullName = fullName;
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
