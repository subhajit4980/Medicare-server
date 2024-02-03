package com.subhajit.Medicare.Utils;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class Common {
    public static  String body(int otp){
        return "Dear Customer,\n" +
                "\n" +
                "We have received a request to reset the password for your account associated with on our platform. To ensure the security of your account, we have initiated the password reset process.\n" +
                "\n" +
                "Please find below the One-Time Password (OTP) required to reset your password:\n" +
                "\n" +
                "OTP: "+Integer.toString(otp)+"\n" +
                "\n" +
                "Please enter this OTP on the password reset page to verify your identity and proceed with resetting your password. This OTP is valid for 5 minutes from the time of this email. If you did not initiate this request, please ignore this email.\n" +
                "\n" +
                "For security reasons, please do not share this OTP with anyone. Our support team will never ask you for your OTP or password.\n" +
                "\n" +
                "If you have any questions or need further assistance, please don't hesitate to contact our support team at subhajit2000patra@gmail.com.\n" +
                "\n" +
                "Thank you for using our platform.\n" +
                "\n" +
                "Best regards,\n" +
                "Medicare";
    }
    public static String welComeMessage( String userName)
    {
        String websiteName = "Medicare";
        String supportEmail = "subhajitpatra498@gmail.com";
        return String.format("""
                Dear %s,

                Welcome to %s, your trusted destination for all your medical product needs! We're thrilled to have you join our community.

                At %s, we offer a wide range of high-quality medical products, from essential supplies to advanced equipment, all carefully curated to meet your healthcare needs.

                Here are a few things you can do now that you've signed up:
                - Explore our extensive catalog of medical products and discover the latest innovations.
                - Enjoy convenient and secure shopping with our user-friendly interface.
                - Stay informed about new arrivals, special offers, and promotions by subscribing to our newsletter.

                If you have any questions or need assistance, our dedicated support team is here to help. Feel free to reach out to us at %s.

                Thank you for choosing %s. We're committed to providing you with a seamless shopping experience and helping you stay healthy.

                Best regards,
                Your %s Team""", userName, websiteName, websiteName, supportEmail, websiteName, websiteName);

    }

    // Method to validate password and return missing character types
    public static List<String> validatePassword(String password) {
        List<String> missingCharTypes = new ArrayList<>();

        if (!password.matches(".*\\d.*")) missingCharTypes.add("Digit");
        if (!password.matches(".*[a-z].*")) missingCharTypes.add("Lowercase letter");
        if (!password.matches(".*[A-Z].*")) missingCharTypes.add("Uppercase letter");
        if (!password.matches(".*[@#$%^&+=!].*")) missingCharTypes.add("Special character");

        return missingCharTypes;
    }

}
