package com.codeshinobis.csauthapi.client.impl;

import org.springframework.stereotype.Component;

import com.codeshinobis.csauthapi.client.UserAPI;
import com.codeshinobis.csauthapi.client.model.User;

@Component
public class UserAPIImpl implements UserAPI {

    public User getUser(String userId) {
        return new User();
    }
    
}
