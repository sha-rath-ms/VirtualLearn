package com.example.virtualLearning.controller;

import com.example.virtualLearning.entity.Users;
import com.example.virtualLearning.response.JwtResponse;
import com.example.virtualLearning.response.ResponseWrapper;
import com.example.virtualLearning.response.ResultInfo;
import com.example.virtualLearning.response.ResultInfoConstants;

import com.example.virtualLearning.security.CustomUserDetailsService;
import com.example.virtualLearning.security.JwtUtility;
import com.example.virtualLearning.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping("/virtual-learn/user")
@Slf4j
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final JwtUtility jwtUtility;
    private final AuthenticationManager authenticationManager;
    private final CustomUserDetailsService userDetailsService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.OK)
    public ResponseWrapper signUp(@RequestBody @Valid Users user) {
        return new ResponseWrapper(ResultInfoConstants.SUCCESS, userService.insert(user));
    }
    @PostMapping("/send-otp/{mobileNumber}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseWrapper sendOtp(@PathVariable("mobileNumber") Long mobileNumber) {
        userService.sendOtp(mobileNumber);
        return new ResponseWrapper(ResultInfoConstants.OTP_SENT,null);
    }
    @PutMapping("/verify-otp")
    @ResponseStatus(HttpStatus.OK)
    public ResponseWrapper verifyOtp(@RequestHeader("mobileNumber") Long mobileNumber,@RequestHeader("otp") Integer otp){
        userService.verifyOtp(mobileNumber,otp);
        return new ResponseWrapper(ResultInfoConstants.OTP_VERIFIED,null);
    }
    @PostMapping("/signin")
    @ResponseStatus(HttpStatus.OK)
    public JwtResponse signin(@RequestHeader("mobile-number") String mobileNumber, @RequestHeader("password") String password) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            mobileNumber,
                            password
                    )
            );
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }

        final UserDetails userDetails
                = userDetailsService.loadUserByUsername(mobileNumber);

        final String token =
                jwtUtility.generateToken(userDetails);
        return new JwtResponse(token);
    }

    @PutMapping("/forgotPassword")
    @ResponseStatus(HttpStatus.OK)
    public ResponseWrapper forgotPassword(@RequestBody long mobileNumber)
    {
        userService.forgotPassword(mobileNumber);
        return new ResponseWrapper(ResultInfoConstants.SUCCESS,null);
    }

    @PutMapping("/updatePassword")
    @ResponseStatus(HttpStatus.OK)
    public ResponseWrapper updatePassword(@RequestHeader("mobileNumber") long mobileNumber,@RequestHeader("newPassword") String newPassword)
    {
        userService.updateUser(mobileNumber,newPassword);
        return new ResponseWrapper(ResultInfoConstants.SUCCESS,null);
    }

    @PutMapping("/updateProfile")
    @ResponseStatus(HttpStatus.OK)
    public ResponseWrapper updateProfile(@RequestBody @Valid Users users,@RequestHeader("Authorization") String token)
    {
        userService.updateUserDetails(Long.parseLong(jwtUtility.getUserId(token)),users);
        return new ResponseWrapper(ResultInfoConstants.SUCCESS,null);
    }

    @PutMapping("/changePassword")
    @ResponseStatus(HttpStatus.OK)
    public ResponseWrapper changePassword(@RequestHeader("Authorization") String token,@RequestBody String password)
    {
        userService.changePassword(Long.parseLong(token),password);
        return new ResponseWrapper(ResultInfoConstants.SUCCESS,null);
    }
}
