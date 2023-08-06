package com.codeshinobis.csuserprofileapi.service.impl;

import com.codeshinobis.csuserprofileapi.model.UserDetailResponse;
import com.codeshinobis.csuserprofileapi.model.UserRequest;
import com.codeshinobis.csuserprofileapi.model.UserResponse;
import com.codeshinobis.csuserprofileapi.service.UserService;

public class UserServiceImpl implements UserService {

    @Override
    public void registerUser(UserRequest user) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public UserResponse getUser(String userId) {
        // TODO Auto-generated method stub
        return new UserResponse();
    }

    @Override
    public UserDetailResponse getUserWithTransaction(String userId) {
        // TODO Auto-generated method stub
        return new UserDetailResponse();
    }

    
    
}