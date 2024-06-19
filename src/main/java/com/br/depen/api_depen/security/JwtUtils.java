package com.br.depen.api_depen.security;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.br.depen.api_depen.entities.Login;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;

@Component
public class JwtUtils {


    @Value("${secret.key}")
    private String secret;

    @Value("${secret.time}")
    private String expirationTime; //configurado para 1 minuto

    private Key key;

    @PostConstruct
    public void init() {
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
    }

    public Claims getAllClaimsFromToken(String token) {
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
    }

    public String getEmailFromToken(String token) {
        return getAllClaimsFromToken(token).getSubject();
    }

    public Date getExpirationDateFromToken(String token) {
        return getAllClaimsFromToken(token).getExpiration();
    }

    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    public String generate(Login user, String type) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", user.getId());
        claims.put("role", user.getRole());
        return doGenerateToken(claims, user.getUsername(), type);
    }

    private String doGenerateToken(Map<String, Object> claims, String username, String type) {
        long expirationTimeLong;
        if ("RECOVERY".equals(type)) {
            expirationTimeLong = Long.parseLong(expirationTime) * 30; //30 minutos
        } else if ("ACCESS".equals(type)) {
            expirationTimeLong = Long.parseLong(expirationTime) * 300; //5 horas
        } else {
            expirationTimeLong = Long.parseLong(expirationTime) * 60; // 1 hora
        }
        final Date createdDate = new Date();
        final Date expirationDate = new Date(createdDate.getTime() + expirationTimeLong);
        return Jwts.builder().setClaims(claims).setSubject(username).setIssuedAt(createdDate)
                .setExpiration(expirationDate).signWith(key).compact();
    }

    public Boolean validateToken(String token) {
        return !isTokenExpired(token);
    }
}