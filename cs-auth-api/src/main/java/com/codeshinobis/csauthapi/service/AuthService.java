package com.codeshinobis.csauthapi.service;

import com.codeshinobis.csauthapi.model.AuthRequest;
import com.codeshinobis.csauthapi.model.Token;

public interface AuthService {

    Token generateAccessToken(String userId);

    boolean validateUser(AuthRequest request);

    String validateAccessToken(String token);
}
