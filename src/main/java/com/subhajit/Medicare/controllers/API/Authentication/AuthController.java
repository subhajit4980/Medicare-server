package com.subhajit.Medicare.controllers.API.Authentication;

import com.subhajit.Medicare.Models.ERole;
import com.subhajit.Medicare.Models.Role;
import com.subhajit.Medicare.Models.User;
import com.subhajit.Medicare.Payload.request.LoginRequest;
import com.subhajit.Medicare.Payload.request.SignupRequest;
import com.subhajit.Medicare.Payload.response.AuthResponse;
import com.subhajit.Medicare.Payload.response.JwtResponse;
import com.subhajit.Medicare.Payload.response.MessageResponse;
import com.subhajit.Medicare.Repository.RoleRepository;
import com.subhajit.Medicare.Repository.UserRepository;
import com.subhajit.Medicare.Security.JwtUtils;
import com.subhajit.Medicare.Services.AuthService;
//import com.subhajit.Medicare.Services.Implementation.UserDetailsImpl;
import com.subhajit.Medicare.Services.LogoutService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    AuthService authService;
    @Autowired
    LogoutService logoutService;

    @PostMapping("/signUp")
    public ResponseEntity<AuthResponse> register(
            @RequestBody SignupRequest request
    ) {
        return ResponseEntity.ok(authService.register(request));
    }
   @PostMapping("/signIn")
    public ResponseEntity<AuthResponse> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
       return ResponseEntity.ok(authService.authenticate(loginRequest));
    }
    @PostMapping("/refresh-token")
    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        authService.refreshToken(request, response);
    }
    @GetMapping("/logout")
    public ResponseEntity<?> logoutUser() {
        return ResponseEntity.ok("Logout successful");
    }
}
