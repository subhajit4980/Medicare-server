package com.subhajit.Medicare.Services;

import com.subhajit.Medicare.Exceptions.UserException;
import com.subhajit.Medicare.Models.User;
import com.subhajit.Medicare.Payload.response.MessageResponse;
import com.subhajit.Medicare.Repository.UserRepository;
import com.subhajit.Medicare.Utils.AppConstant;
import com.subhajit.Medicare.Utils.Common;
import freemarker.template.Configuration;
import freemarker.template.Template;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PasswordService {
    private final UserRepository userRepository;
    private final Configuration config;
    private final EmailService emailService;
    private final HttpServletRequest request;
    private final PasswordEncoder encoder;

    public MessageResponse forgotPassword(String email) throws RuntimeException{
        if(!email.contains("@gmail.com")) throw new UserException("Email is not valid","EMAIL_NOT_VALID");
        User user = userRepository.findByEmail(email.toUpperCase(Locale.ROOT)).orElseThrow(()-> new UserException("Email is not registered","EMAIL_NOT_REGISTERED"));
        String otp= Common.generateOTP();
        HttpSession session = request.getSession();
        session.setAttribute(email.toUpperCase(Locale.ROOT)+"OTP",otp);
        long currentTimeMillis = System.currentTimeMillis();
        session.setAttribute(email.toUpperCase(Locale.ROOT)+"TIME",currentTimeMillis);
        Map<String, Object> model = new HashMap<>();
        model.put("Name",user.getFirstName()+" "+user.getLastName());
        model.put("otp", otp);
        Template t = null;
        try {
            t = config.getTemplate("otp-template.ftl");
            emailService.sendEmail(user.getEmail(),"Password Reset Request",t,model);
        } catch (Exception e) {
            throw new UserException( "OTP not send", e.getMessage().toUpperCase(Locale.ROOT));
        }
        return new MessageResponse("OTP send to the email address");
    }
    public MessageResponse verifyOtp(String email ,String otp) throws RuntimeException
    {
        HttpSession session = request.getSession();
        var se= session.getAttribute(email.toUpperCase(Locale.ROOT)+"OTP");
        var timestamp=session.getAttribute(email.toUpperCase(Locale.ROOT)+"TIME");
        long currentTimeMillis = System.currentTimeMillis();
        if (se == null || timestamp == null) throw new UserException("OTP is not a valid","OTP_NOT_VALID");
        if(otp.equals(se) && currentTimeMillis<= ((long)timestamp + (5 * 60 * 1000) )){
            return new MessageResponse("OTP Verified Successfully");
        }else throw  new UserException("OTP is not a valid","OTP_NOT_VALID");
    }
    public MessageResponse updatePassword(String password , String email) throws UserException
    {
        User user= userRepository.findByEmail(email.toUpperCase(Locale.ROOT)).orElseThrow(() -> new UserException("User not found","USER_NOT_EXIST"));
        user.setPassword(encoder.encode(password));
        userRepository.save(user);
        return new MessageResponse("Password updated successfully");
    }
}
