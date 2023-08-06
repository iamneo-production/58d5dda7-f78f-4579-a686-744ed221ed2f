package com.codeshinobis.csuserprofileapi.service.impl;


import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeshinobis.csuserprofileapi.exception.InvalidRequestException;
import com.codeshinobis.csuserprofileapi.model.UserDetailResponse;
import com.codeshinobis.csuserprofileapi.model.UserRequest;
import com.codeshinobis.csuserprofileapi.model.UserResponse;
import com.codeshinobis.csuserprofileapi.repo.UserRepository;
import com.codeshinobis.csuserprofileapi.repo.entity.User;
import com.codeshinobis.csuserprofileapi.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repo;

    @Override
    public void registerUser(UserRequest user) {
        validateUser(user);
        User existingUser = repo.findByUserId(user.getUserId());
        if(existingUser != null) {
            throw new InvalidRequestException("UserId is already Exist");
        }
        User userEntity = new User();
        userEntity.setName(user.getName());
        userEntity.setUserId(user.getUserId());
        userEntity.setPassword(user.getPassword());
        repo.save(userEntity);
    }

    @Override
    public UserResponse getUser(String userId) {
        if(StringUtils.isBlank(userId)) {
            throw new InvalidRequestException("Invalid User Id");
        }
        User user = repo.findByUserId(userId);
        UserResponse userResponse = new UserResponse();
        userResponse.setName(user.getName());
        userResponse.setUserId(user.getUserId());
        userResponse.setPassword(user.getPassword());
        return userResponse;
    }

    @Override
    public UserDetailResponse getUserWithTransaction(String userId) {
        return new UserDetailResponse();
    }

    private void validateUser(UserRequest user) {
        if(user == null || StringUtils.isBlank(user.getUserId()) || 
            StringUtils.isBlank(user.getName()) || StringUtils.isBlank(user.getPassword())) {
                throw new InvalidRequestException("Invalid User Request");
            } 
    }

    
    
}