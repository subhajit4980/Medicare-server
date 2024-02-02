package com.subhajit.Medicare.Payload.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class SignUpEmailRequest {
    @NotBlank
    @Email
    String email;
    @NotBlank
    String subject = "";
    @NotBlank
    String message;
}
