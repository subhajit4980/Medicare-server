package com.subhajit.Medicare.Payload.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ForgetPasswordRequest {
    @NotBlank
    private String email;

    private String subject="Forget Password Request";

    private String message;
}
