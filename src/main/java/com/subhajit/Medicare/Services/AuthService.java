package com.subhajit.Medicare.Services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.subhajit.Medicare.Exceptions.UserException;
import com.subhajit.Medicare.Models.DTO.User;
import com.subhajit.Medicare.Payload.request.LoginRequest;
import com.subhajit.Medicare.Payload.request.SignupRequest;
import com.subhajit.Medicare.Payload.response.AuthResponse;
import com.subhajit.Medicare.Repository.UserRepository;
import com.subhajit.Medicare.Security.JwtUtils;
import com.subhajit.Medicare.Tokens.Token;
import com.subhajit.Medicare.Tokens.TokenRepository;
import com.subhajit.Medicare.Tokens.TokenType;
import com.subhajit.Medicare.Utils.AppConstant;
import com.subhajit.Medicare.Utils.Common;
import freemarker.template.Configuration;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import freemarker.template.Template;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final TokenRepository tokenRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;
    private final EmailService emailService;
    private final Configuration config;
    @SneakyThrows
    public AuthResponse register(SignupRequest request) throws RuntimeException {
        if(!request.getEmail().contains("@gmail.com")) throw new UserException("Email is not valid","EMAIL_NOT_VALID", HttpStatus.BAD_REQUEST);
        if(userRepository.existsByEmail(request.getEmail().toUpperCase(Locale.ROOT))) throw new UserException("User already registered","USER_EXIST",HttpStatus.BAD_REQUEST);
        var charlist= Common.validatePassword(request.getPassword());
        if(request.getPassword().length()<8) throw new UserException("Password  length must be greater than 8 characters","PASSWORD_LENGTH_NOT_VALID",HttpStatus.BAD_REQUEST);
        if(!charlist.isEmpty()) throw new UserException("Password is invalid. Missing character types:" + charlist.toString(),"INVALID_PASSWORD",HttpStatus.BAD_REQUEST);
        var user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail().toUpperCase(Locale.ROOT))
                .password(encoder.encode(request.getPassword()))
                .creationDate(new Date(System.currentTimeMillis()))
                .verified(false)
                .role(request.getRole())
                .build();
            var savedUser = userRepository.save(user);
            String jwtToken = jwtUtils.generateJwtToken(user);
            String refreshToken = jwtUtils.generateRefreshToken(user);
            saveUserToken(savedUser, jwtToken,refreshToken);
            Map<String, Object> model = new HashMap<>();
            model.put("Name",request.getFirstName()+" "+request.getLastName());
            model.put("medicareWebsiteUrl", "https://subhajit4980.github.io/Subhajit/");
            Template t = config.getTemplate("email-template.ftl");
            emailService.sendEmail(request.getEmail(),AppConstant.WelcomeSubject,t,model);
            return AuthResponse.builder()
                    .accessToken(jwtToken)
                    .refreshToken(refreshToken)
                    .user(savedUser)
                    .build();
    }
    public AuthResponse authenticate(LoginRequest request) {
        if(!request.getEmail().contains("@gmail.com")) throw new UserException("Email is not valid","EMAIL_NOT_VALID",HttpStatus.BAD_REQUEST);
            authentication(request.getEmail().toUpperCase(Locale.ROOT), request.getPassword());
            var user = userRepository.findByEmail(request.getEmail().toUpperCase(Locale.ROOT))
                    .orElseThrow(() -> new UserException("Email is not registered", "USER_NOT_REGISTERED",HttpStatus.BAD_REQUEST));
            var jwtToken = jwtUtils.generateJwtToken(user);
            var refreshToken = jwtUtils.generateRefreshToken(user);
            revokeAllUserTokens(user);
            saveUserToken(user, jwtToken, refreshToken);
            return AuthResponse.builder()
                    .accessToken(jwtToken)
                    .refreshToken(refreshToken)
                    .user(user)
                    .build();
    }

    public Authentication authentication(String email, String password) {
        Authentication auth = new UsernamePasswordAuthenticationToken(email.toUpperCase(Locale.ROOT), password);
        try {
            Authentication authentication = authenticationManager.authenticate(auth);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return authentication;
        } catch (org.springframework.security.core.AuthenticationException e) {
            throw new UserException("Wrong Credentials Provided", e.getMessage().toUpperCase(Locale.ROOT),HttpStatus.BAD_REQUEST);
        }
    }
    private void saveUserToken(User user, String jwtToken, String refreshToken) {
        var token = Token.builder()
                .user(user)
                .token(jwtToken)
                .refreshToken(refreshToken)
                .tokenType(TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .build();
        tokenRepository.save(token);
    }
    private void revokeAllUserTokens(User user) {
        var validUserTokens = tokenRepository.findTokensByUserId(user.getUserId());
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
                saveUserToken(user, accessToken,refreshToken);
                var authResponse = AuthResponse.builder()
                        .accessToken(accessToken)
                        .refreshToken(refreshToken)
                        .build();
                new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
            }
        }
    }
}
