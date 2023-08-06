package com.codeshinobis.cscurrencyexchangeapi.interceptor;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.codeshinobis.cscurrencyexchangeapi.exception.CsErrorCodes;
import com.codeshinobis.cscurrencyexchangeapi.exception.CsException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;

@Component
@Slf4j
public class AuthInterceptor implements HandlerInterceptor {

    private static final String SECRET = "asdfSFS34wfsdfsdfSDSD32dfsddDDerQSNCK34SOWEK5354fdgdf4";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        String token = request.getHeader("Authorization");
        log.info("Authorization Header - {}", token);

        if(StringUtils.isBlank(token)) {
            throw new CsException(CsErrorCodes.UNAUTHORIZED_USER);
        }

        String userID = "Arun";
//        String userID = validateTokenAndGetUserID(token);
        request.setAttribute("USER_ID", userID);
        return true;
    }

    private String validateTokenAndGetUserID(String token) throws CsException {
        Key hmacKey = getKey();

        Jws<Claims> jwt = Jwts.parserBuilder()
                .setSigningKey(hmacKey)
                .build()
                .parseClaimsJws(token);

        if(jwt == null || jwt.getBody() == null || jwt.getBody().get("userId") == null) {
            throw new CsException(CsErrorCodes.UNAUTHORIZED_USER);
        }
        return jwt.getBody().get("userId").toString();
    }

    private Key getKey() {
        return new SecretKeySpec(Base64.getDecoder().decode(SECRET),
                SignatureAlgorithm.HS256.getJcaName());
    }

}
