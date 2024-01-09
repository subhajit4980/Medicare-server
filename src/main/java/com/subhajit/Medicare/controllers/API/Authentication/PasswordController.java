package com.subhajit.Medicare.controllers.API.Authentication;

import com.subhajit.Medicare.Models.User;
import com.subhajit.Medicare.Payload.request.ForgetPasswordRequest;
import com.subhajit.Medicare.Payload.request.UpdatePasswordRequest;
import com.subhajit.Medicare.Payload.response.MessageResponse;
import com.subhajit.Medicare.Repository.UserRepository;
import com.subhajit.Medicare.Security.services.EmailService;
import com.subhajit.Medicare.Utils.Common;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.context.HttpRequestResponseHolder;
import org.springframework.web.bind.annotation.*;
import javax.mail.Session;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Properties;
import java.util.Random;

@RestController
@RequestMapping("/api/auth")
public class PasswordController  {
    @Autowired
    EmailService emailService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    HttpServletRequest request;
    @Autowired
    Common common;
    @Autowired
    PasswordEncoder encoder;
    @PostMapping("/forget_password")
    public ResponseEntity<?> forgetPassword(@Valid @RequestBody ForgetPasswordRequest forget){
        boolean f=false;
        if (userRepository.existsByEmail(forget.getEmail())) {
            int min = 100000;
            int max = 999999;
            int randomNumber = new Random().nextInt(max - min + 1) + min;
            String message= Common.body(randomNumber);
            HttpSession session = request.getSession();
            session.setAttribute(forget.getEmail()+"OTP",randomNumber);
            long currentTimeMillis = System.currentTimeMillis();
            session.setAttribute(forget.getEmail()+"time",currentTimeMillis);
            f= emailService.sendMail( forget.getSubject(),message,forget.getEmail());
        }else {
            return new ResponseEntity<>("User Email Not Found",HttpStatus.NOT_FOUND);
        }
        return f ?new ResponseEntity<>("OTP sent to the registered email", HttpStatus.OK):new ResponseEntity<>("OTP not sent", HttpStatus.BAD_REQUEST);
    }
    @PostMapping("/verify_OTP")
    public ResponseEntity<?> verifyOTP(@Valid @RequestParam(required = false) String otp, String userEmail){
        HttpSession session = request.getSession();
        String se= Integer.toString((Integer) session.getAttribute(userEmail+"OTP")) ;
        long timestamp= (long) session.getAttribute(userEmail+"time")+ (5 * 60 * 1000);
        long currentTimeMillis = System.currentTimeMillis();
        if(otp.equals(se) && currentTimeMillis<= timestamp ){
            return new ResponseEntity<>("OTP Verified Successfully",HttpStatus.FOUND);
        }
        return new ResponseEntity<>("OTP is invalid"+se, HttpStatus.BAD_REQUEST);
    }
    @PostMapping("/update_Password")
    public ResponseEntity<?> updatePassword(@Valid @RequestBody UpdatePasswordRequest request){
        try {
            User user= userRepository.findByEmail(request.getEmail()).orElseThrow(() -> new UsernameNotFoundException("User Not Found with email: " + request.getEmail()));;
            user.setPassword(encoder.encode(request.getPassword()));
            userRepository.save(user);
            return new ResponseEntity<>(user,HttpStatus.OK);

        }catch (Exception e)
        {
            MessageResponse messageResponse = new MessageResponse("Error while updating password");
            return new ResponseEntity<>(messageResponse,HttpStatus.BAD_REQUEST);
        }
    }
}
