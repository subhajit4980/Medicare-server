package com.subhajit.Medicare.controllers.API.Authentication;

import com.subhajit.Medicare.Models.User;
import com.subhajit.Medicare.Payload.request.UpdatePasswordRequest;
import com.subhajit.Medicare.Payload.response.MessageResponse;
import com.subhajit.Medicare.Repository.UserRepository;
import com.subhajit.Medicare.Services.PasswordService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class PasswordController  {
   private final UserRepository userRepository;
   private final HttpServletRequest request;
   private final PasswordEncoder encoder;
   private final PasswordService passwordService;
    @PostMapping("/forget_password")
    public ResponseEntity<MessageResponse> forgetPassword(@Valid @RequestParam String email){
        return ResponseEntity.ok(passwordService.forgotPassword(email));
         }
    @PostMapping("/verify_OTP")
    public ResponseEntity<?> verifyOTP(@Valid @RequestParam(required = true) String otp, String userEmail){

        return ResponseEntity.ok(passwordService.verifyOtp(userEmail,otp));
    }
    @PostMapping("/update_Password")
    public ResponseEntity<?> updatePassword(@Valid @RequestBody UpdatePasswordRequest request){
        return  ResponseEntity.ok(passwordService.updatePassword(request.getPassword(),request.getEmail()));
    }
}
