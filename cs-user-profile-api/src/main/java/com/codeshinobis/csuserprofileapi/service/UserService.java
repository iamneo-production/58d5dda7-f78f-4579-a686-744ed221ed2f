package com.codeshinobis.csuserprofileapi.service;

import com.codeshinobis.csuserprofileapi.model.UserDetailResponse;
import com.codeshinobis.csuserprofileapi.model.UserRequest;
import com.codeshinobis.csuserprofileapi.model.UserResponse;

public interface UserService {
    
    void registerUser(UserRequest user);

    UserResponse getUser(String userId);

    UserDetailResponse getUserWithTransaction(String userId);
}
