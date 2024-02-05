<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Password Reset OTP</title>
    <style>
        body {
                font-family: Arial, sans-serif;
                line-height: 1.6;
                background-color: #f4f4f4;
                margin: 0;
                padding: 0;
                }
                .container {
                max-width: 600px;
                margin: 20px auto;
                padding: 20px;
                background-color: #fff;
                border-radius: 5px;
                box-shadow: 0 0 10px rgba(0,0,0,0.1);
                }
                h1 {
                color: #333;
                }
                p {
                margin-bottom: 20px;
                }
            </style>
</head>
<body>
<div class="container">
        <h1>Password Reset OTP</h1>
        <p>Dear ${Name},</p>
        <p>We have received a request to reset the password for your account associated with our platform. To ensure the security of your account, we have initiated the password reset process.</p>
        <p>Please find below the One-Time Password (OTP) required to reset your password:</p>
        <p style="font-weight: bold;">OTP: ${otp}</p>
        <p>Please enter this OTP on the password reset page to verify your identity and proceed with resetting your password. This OTP is valid for 5 minutes from the time of this email. If you did not initiate this request, please ignore this email.</p>
        <p>For security reasons, please do not share this OTP with anyone. Our support team will never ask you for your OTP or password.</p>
        <p>If you have any questions or need further assistance, please don't hesitate to contact our support team at <a href="mailto:subhajit2000patra@gmail.com">subhajit2000patra@gmail.com</a>.</p>
        <p>Thank you for using our platform.</p>
        <p>Best regards,<br>Medicare</p>
    </div>
</body>
</html>
