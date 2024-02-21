package com.subhajit.Medicare.Payload.request;

import com.subhajit.Medicare.Models.ERole;
import com.subhajit.Medicare.Models.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Set;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class SignupRequest {
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;
    private ERole role;
    @NotBlank
    @Size(min = 6, max = 40)
    private String password;
}
