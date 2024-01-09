package com.subhajit.Medicare.Utils;

import org.springframework.stereotype.Component;

@Component
public class Common {
    public static  String body(int otp){
        String message="Dear Customere,\n" +
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
        return message;
    }


}
