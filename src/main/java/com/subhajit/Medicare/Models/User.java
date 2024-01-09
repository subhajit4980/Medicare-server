package com.subhajit.Medicare.Models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "User")
public class User  {
    @Id
    private String id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;
    @NotBlank
    @Size(max = 20)
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(max = 120)
    private String password;

    @NotBlank
    private String creationTime;
    @DBRef
    private Set<Role> roles = new HashSet<>();
    public User(String firstName,String lastName,String username, String email, String password) {
        this.firstName=firstName;
        this.lastName=lastName;
        this.username = username;
        this.email = email;
        this.password = password;
    }

}
