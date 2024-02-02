package com.subhajit.Medicare.Services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.subhajit.Medicare.Models.User;
import com.subhajit.Medicare.Payload.request.LoginRequest;
import com.subhajit.Medicare.Payload.request.SignupRequest;
import com.subhajit.Medicare.Payload.response.AuthResponse;
import com.subhajit.Medicare.Repository.UserRepository;
import com.subhajit.Medicare.Security.JwtUtils;
import com.subhajit.Medicare.Tokens.Token;
import com.subhajit.Medicare.Tokens.TokenRepository;
import com.subhajit.Medicare.Tokens.TokenType;
import com.subhajit.Medicare.Utils.Common;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final TokenRepository tokenRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;
    private final EmailService emailService;
    private final Common common;
    public AuthResponse register(SignupRequest request) throws RuntimeException {
        if(userRepository.existsByEmail(request.getEmail())) throw new RuntimeException;
        var user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(encoder.encode(request.getPassword()))
                .role(request.getRole())
                .build();
            var savedUser = userRepository.save(user);
            String jwtToken = jwtUtils.generateJwtToken(user);
            String refreshToken = jwtUtils.generateRefreshToken(user);
            saveUserToken(savedUser, jwtToken);
            emailService.sendMail(common.WelcomeSubject,common.welComeMessage(request.getFirstName()+" "+request.getLastName()),request.getEmail());
            return AuthResponse.builder()
                    .accessToken(jwtToken)
                    .refreshToken(refreshToken)
                    .build();
    }
    public AuthResponse authenticate(LoginRequest request) {
        authentication(request.getEmail(), request.getPassword());
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtUtils.generateJwtToken(user);
        var refreshToken = jwtUtils.generateRefreshToken(user);
        revokeAllUserTokens(user);
        saveUserToken(user, jwtToken);
        return AuthResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .build();
    }
    public Authentication authentication(String email, String password)
    {
        Authentication auth = new UsernamePasswordAuthenticationToken(email, password);
        Authentication authentication = authenticationManager.authenticate(auth);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return authentication;
    }
    private void saveUserToken(User user, String jwtToken) {
        var token = Token.builder()
                .user(user)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .build();
        tokenRepository.save(token);
    }
    private void revokeAllUserTokens(User user) {
        var validUserTokens = tokenRepository.findAllValidTokenByUser(user.getUserId());
        if (validUserTokens.isEmpty())
            return;
        validUserTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        tokenRepository.saveAll(validUserTokens);
    }
    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        final String refreshToken;
        final String userEmail;
        if (authHeader == null ||!authHeader.startsWith("Bearer ")) {
            return;
        }
        refreshToken = authHeader.substring(7);
        userEmail = jwtUtils.getEmailFromJwtToken(refreshToken);
        if (userEmail != null) {
            var user = this.userRepository.findByEmail(userEmail)
                    .orElseThrow();
            if (jwtUtils.validateJwtToken(refreshToken)) {
                var accessToken = jwtUtils.generateJwtToken(user);
                revokeAllUserTokens(user);
                saveUserToken(user, accessToken);
                var authResponse = AuthResponse.builder()
                        .accessToken(accessToken)
                        .refreshToken(refreshToken)
                        .build();
                new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
            }
        }
    }
}
