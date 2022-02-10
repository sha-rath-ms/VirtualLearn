package com.example.virtualLearning.service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SMSService {
    public static void send(String mobileNumber,Integer data){
        Twilio.init("AC849b4de5cefc44a4b064a71bc7d17c1d", "a21047a2ee609d0c4e8c719ca594e13d");
        Message message = Message.creator(
                        new PhoneNumber("+91"+mobileNumber),
                        new PhoneNumber("+18507539398"),
                        "Virtual learn OTP: "+data)
                .create();
    }
}
