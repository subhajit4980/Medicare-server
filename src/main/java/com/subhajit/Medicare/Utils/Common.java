package com.subhajit.Medicare.Utils;

import lombok.experimental.UtilityClass;
import org.springframework.stereotype.Component;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import static com.subhajit.Medicare.Utils.AppConstant.OTP_LENGTH;

@UtilityClass
public class Common {
    // Method to validate password and return missing character types
    public  List<String> validatePassword(String password) {
        List<String> missingCharTypes = new ArrayList<>();
        if (!password.matches(".*\\d.*")) missingCharTypes.add("Digit");
        if (!password.matches(".*[a-z].*")) missingCharTypes.add("Lowercase letter");
        if (!password.matches(".*[A-Z].*")) missingCharTypes.add("Uppercase letter");
        if (!password.matches(".*[@#$%^&+=!].*")) missingCharTypes.add("Special character");
        return missingCharTypes;
    }

    // Generate OTP
    public  String generateOTP() {
        // Use SecureRandom for generating random numbers
        SecureRandom secureRandom = new SecureRandom();
        // Generate a random byte array
        byte[] randomBytes = new byte[OTP_LENGTH];
        secureRandom.nextBytes(randomBytes);
        // Encode the byte array to Base64
        String otp = Base64.getEncoder().encodeToString(randomBytes);
        // Trim the OTP to the desired length and remove special characters
        otp = otp.replaceAll("[^a-zA-Z0-9]", "").substring(0, OTP_LENGTH);
        return otp;
    }
}
