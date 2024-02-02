package com.subhajit.Medicare.Security;

import com.subhajit.Medicare.Models.User;
//import com.subhajit.Medicare.Services.Implementation.UserDetailsImpl;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtils {
    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

    @Value("${Medicare.app.jwtSecret}")
    private String jwtSecret;

    @Value("${Medicare.app.jwtExpirationMs}")
    private Long jwtExpirationMs;
    @Value("${Medicare.app.refresh-token-expiration}")
    private Long refresh_token_expiration;

    public  String generateRefreshToken(UserDetails userDetails) {
        return  token(userDetails,refresh_token_expiration);
    }
    public String generateJwtToken(UserDetails userDetails) {
        return  token(userDetails,jwtExpirationMs);
    }
    public  String token(UserDetails userDetails, Long expiration) {
        return Jwts.builder()
                .setSubject((userDetails.getUsername()))
                .claim("password", userDetails.getPassword())
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + expiration))
                .signWith(key(), SignatureAlgorithm.HS256)
                .compact();
    }
    private Key key() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
    }

    public String getEmailFromJwtToken(String token) {
        return Jwts.parserBuilder().setSigningKey(key()).build()
                .parseClaimsJws(token).getBody().getSubject();
    }
    public String getPasswordFromJwtToken(String token) {
        Claims claims= Jwts.parserBuilder().setSigningKey(key()).build()
                .parseClaimsJws(token).getBody();
        return String.valueOf(claims.get("password"));
    }
    private boolean isTokenExpired(String token) {
        return claims(token).getExpiration().before(new Date());
    }
    private Claims claims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = getEmailFromJwtToken(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }
    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parserBuilder().setSigningKey(key()).build().parse(authToken);
            return true;
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            logger.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty: {}", e.getMessage());
        }

        return false;
    }

}

