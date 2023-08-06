package com.codeshinobis.csauthapi.service.impl;

import com.codeshinobis.csauthapi.client.UserAPI;
import com.codeshinobis.csauthapi.client.model.User;
import com.codeshinobis.csauthapi.exception.InvalidRequestException;
import com.codeshinobis.csauthapi.exception.TokenException;
import com.codeshinobis.csauthapi.model.AuthRequest;
import com.codeshinobis.csauthapi.model.Token;
import com.codeshinobis.csauthapi.service.AuthService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.sql.Date;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Objects;
import java.util.UUID;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserAPI apiService;

    String secret = "asdfSFS34wfsdfsdfSDSD32dfsddDDerQSNCK34SOWEK5354fdgdf4";

    public Token generateAccessToken(String userId) {

        Key hmacKey = getKey();

        String jwtToken = Jwts.builder()
                .claim("userId", userId)
                .setSubject(userId)
                .setId(UUID.randomUUID().toString())
                .setIssuedAt(Date.from(Instant.now()))
                .setExpiration(Date.from(Instant.now().plus(15L, ChronoUnit.MINUTES)))
                .signWith(hmacKey)
                .compact();

        if(jwtToken == null) {
            throw new TokenException("Unable to generate JWT token");
        }

        Token token = new Token();
        token.setAccessToken(jwtToken);

        return token;
    }

    public String validateAccessToken(String token) {

        Key hmacKey = getKey();

        Jws<Claims> jwt = Jwts.parserBuilder()
                .setSigningKey(hmacKey)
                .build()
                .parseClaimsJws(token);

        if(jwt == null || jwt.getBody() == null || jwt.getBody().get("userId") == null) {
            throw new TokenException("Access token is invalid");
        }
        return jwt.getBody().get("userId").toString();

    }

    public boolean validateUser(AuthRequest request) {
        if(Objects.isNull(request) || StringUtils.isBlank(request.getUserId()) || StringUtils.isBlank(request.getPassword())) {
            throw new InvalidRequestException("Invalid User Request");
        }

        User user = apiService.getUser(request.getUserId());
        if(user.getPassword() != request.getPassword()) {
            throw new InvalidRequestException("Password Mismatch");
        }

        return true;
    }
    
    private Key getKey() {
        return new SecretKeySpec(Base64.getDecoder().decode(secret),
                SignatureAlgorithm.HS256.getJcaName());
    }
}
