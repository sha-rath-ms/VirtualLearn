package com.example.virtualLearning.entity;

import com.example.virtualLearning.service.SMSService;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Random;

@Data
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "otp")
@Slf4j
public class OtpToken {
    @Id
    @Column(name = "mobile_number")
    private String mobileNumber;
    private int Otp;

    public OtpToken(String mobileNumber) {
        Random rd = new Random();
        this.mobileNumber = mobileNumber;
        this.Otp = 1000 + rd.nextInt(8999);
        SMSService.send(mobileNumber,this.Otp);
    }
}

