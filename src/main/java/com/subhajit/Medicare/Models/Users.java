package com.subhajit.Medicare.Models;

import com.subhajit.Medicare.Models.ERole;
import com.subhajit.Medicare.Models.Role;
import com.subhajit.Medicare.Tokens.Token;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "users") // Collection name in MongoDB
public class Users implements UserDetails {
    @Id
    private String UserId;

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

    private List<Token> tokens;

    @Enumerated(EnumType.STRING)
    private ERole role;
    public Users(String firstName,String lastName,String username, String email, String password) {
        this.firstName=firstName;
        this.lastName=lastName;
        this.username = username;
        this.email = email;
        this.password = password;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role.getAuthorities();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
