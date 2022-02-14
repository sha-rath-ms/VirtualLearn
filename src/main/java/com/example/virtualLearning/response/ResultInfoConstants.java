package com.example.virtualLearning.response;

import lombok.Data;

@Data
public class ResultInfoConstants {
    public static final ResultInfo DUPLICATE_USER = new ResultInfo("User is already present");
    public static final ResultInfo MOBILE_NUMBER_VALIDATION = new ResultInfo("Mobile number is not valid");
    public static final ResultInfo EMAIL_VALIDATION = new ResultInfo("Email is not valid,please correct email");
    public static final ResultInfo INVALID_PASSWORD= new ResultInfo("Password is not valid and authentication failed");
    public static final ResultInfo INVALID_USER = new ResultInfo("User is not valid");
    public static final ResultInfo INVALID_OTP = new ResultInfo("OTP is not valid");
    public static final ResultInfo SUCCESS = new ResultInfo("Success");
    public static final ResultInfo OTP_SENT = new ResultInfo("OTP is sent to the mobile number");
    public static final ResultInfo OTP_NOT_VALIDATED = new ResultInfo("OTP was not verified before register");
    public static final ResultInfo OTP_VERIFIED = new ResultInfo("OTP was verified successfully");
    public static final ResultInfo INVALID_ID = new ResultInfo("Invalid id");
}
