package com.subhajit.Medicare.Services;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.subhajit.Medicare.Payload.response.MessageResponse;
import com.subhajit.Medicare.Tokens.TokenRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogoutService implements LogoutHandler {

    private final TokenRepository tokenRepository;
    @SneakyThrows
    @Override
    public void logout(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication
    ) {
        final String jwt;
        final String authHeader = request.getHeader("Authorization");
        if (authHeader == null ||!authHeader.startsWith("Bearer ")) return;
        jwt = authHeader.substring(7);
        System.out.println(jwt);
        var storedToken = tokenRepository.findByToken(jwt)
                .orElse(null);
        System.out.println(storedToken);
        if (storedToken != null) {
            storedToken.setExpired(true);
            storedToken.setRevoked(true);
            tokenRepository.save(storedToken);
            SecurityContextHolder.clearContext();
            new ObjectMapper().writeValue(response.getOutputStream(), new MessageResponse("user logged out"));
        }
    }
}
