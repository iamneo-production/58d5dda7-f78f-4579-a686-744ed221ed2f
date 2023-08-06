package com.codeshinobis.csauthapi.model;

import lombok.Data;

@Data
public class AuthRequest {

    private String userId;
    private String password;
}
