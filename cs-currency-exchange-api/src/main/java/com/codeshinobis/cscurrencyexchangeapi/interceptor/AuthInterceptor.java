package com.codeshinobis.cscurrencyexchangeapi.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.codeshinobis.cscurrencyexchangeapi.exception.CsErrorCodes;
import com.codeshinobis.cscurrencyexchangeapi.exception.CsException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

                if(request.getHeader("token") == null) {
                    throw new CsException(CsErrorCodes.UNAUTHORIZED_USER);
                }
                
                return true;
    }
}
