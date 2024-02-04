package com.subhajit.Medicare.config;

import com.subhajit.Medicare.Security.AuthEntryPointJwt;
import com.subhajit.Medicare.Security.AuthTokenFilter;
//import com.subhajit.Medicare.Services.Implementation.UserDetailsServiceImpl;
import com.subhajit.Medicare.Utils.AppConstant;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;

@Configuration
@EnableMethodSecurity // Enables method-level security annotations
@RequiredArgsConstructor // Lombok annotation to generate constructor with required fields
@EnableWebSecurity // Enables Spring Security for web applications
public class SecurityConfig {

    // Injecting dependencies via constructor
    private final AppConfig appConfig; // Application configuration bean
    private final AuthEntryPointJwt point; // Authentication entry point for JWT
    private final LogoutHandler logoutHandler; // Logout handler
    private final AuthTokenFilter authTokenFilter; // JWT authentication filter

    // Bean for AuthenticationManager
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    // Bean for defining security filter chain
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // Configuring exception handling, session management, and authorization rules
        http.exceptionHandling(exception -> exception.authenticationEntryPoint(point))
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(AppConstant.PUBLIC_URLS).permitAll() // Permit access to public URLs
                        .requestMatchers("/api/Admin/**").hasAuthority("ADMIN") // Require ADMIN authority for admin API
                        .anyRequest().authenticated() // Require authentication for any other requests
                );

        // Adding custom authentication provider and JWT filter
        http.authenticationProvider(appConfig.authenticationProvider());
        http.addFilterBefore(authTokenFilter, UsernamePasswordAuthenticationFilter.class);

        // Configuring CSRF and CORS
        http.csrf(AbstractHttpConfigurer::disable).cors(cors -> new CorsConfig());

        // Configuring logout endpoint and handlers
        http.logout(logout ->
                logout.logoutUrl("/api/auth/logout")
                        .addLogoutHandler(logoutHandler)
                        .logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext())
        );

        // Building and returning the configured security filter chain
        return http.build();
    }
}
