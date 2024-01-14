package com.example.weberpspringbackend.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    private static final String SECRET_KEY = "Ry9IAMnY3iosaWNpJh82O/tvCM7QTRmBF6q5r93Aq2WBiSkRbhvR43zkYkjcs9T7cr8+NvjT6diCXp+123+Q5PNePV5dv5owwIbo00bPjbdHOX0wOhnLf1YfXtxOGWKnzmPi3PU04q6I1JnRjVAGC5xA2aKRZdmhWIngQMJnhmQL4Kqg7Sp1F4pd+/O2PF8dccRL7P9lYIR62uurGrm9G3B32RNoDnq6G5YWo+XDvWfasbpEGmgiXF/1xOlEDERPMoTocYhRVTtkkaw8EvtfeDmqU8X4iSH8xp2CPHz4RH2veWc/XNu1pA/OxvTOgVSm6gFs7GbrU0y9lXmo4ijkHMNEQ+ifaeYxDebm7/6A33I=";
    private static final long EXPIRATION_TIME = 1000 * 60 * 60 * 10; // 10 hours

    public static String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, userDetails.getUsername());
    }

    private static String createToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public static boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private static boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private static Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public static String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    private static <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private static Claims extractAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
