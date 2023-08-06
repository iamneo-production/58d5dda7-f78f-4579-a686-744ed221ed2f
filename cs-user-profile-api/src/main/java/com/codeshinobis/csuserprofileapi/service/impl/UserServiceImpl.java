package com.codeshinobis.csuserprofileapi.service.impl;


import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.codeshinobis.csuserprofileapi.client.TransactionAPI;
import com.codeshinobis.csuserprofileapi.exception.ClientException;
import com.codeshinobis.csuserprofileapi.exception.InvalidRequestException;
import com.codeshinobis.csuserprofileapi.model.ResponseDto;
import com.codeshinobis.csuserprofileapi.model.UserDetail;
import com.codeshinobis.csuserprofileapi.model.UserDetailResponse;
import com.codeshinobis.csuserprofileapi.model.UserRequest;
import com.codeshinobis.csuserprofileapi.model.UserResponse;
import com.codeshinobis.csuserprofileapi.model.UserTransaction;
import com.codeshinobis.csuserprofileapi.repo.UserRepository;
import com.codeshinobis.csuserprofileapi.repo.entity.User;
import com.codeshinobis.csuserprofileapi.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private TransactionAPI client;

    String secret = "asdfSFS34wfsdfsdfSDSD32dfsddDDerQSNCK34SOWEK5354fdgdf4";

    @Override
    public void registerUser(UserRequest user) {
        validateUser(user);
        User existingUser = repo.findByUserId(user.getUserId());
        if(existingUser != null) {
            throw new InvalidRequestException("UserId is already Exist");
        }
        // StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        // encryptor.setPassword(secret);
        // String encryptedPassword = encryptor.encrypt(user.getPassword());
        User userEntity = new User();
        userEntity.setName(user.getName());
        userEntity.setUserId(user.getUserId());
        userEntity.setPassword(user.getPassword());
        repo.save(userEntity);
    }

    @Override
    public UserResponse getUser(String userId) {
        User user = validateAndGetUser(userId);
        UserResponse userResponse = new UserResponse();
        userResponse.setName(user.getName());
        userResponse.setUserId(user.getUserId());
        userResponse.setPassword(user.getPassword());
        return userResponse;
    }

    @Override
    public UserDetailResponse getUserWithTransaction(String userId) {
        User user = validateAndGetUser(userId);
        UserDetailResponse userDetailResponse = new UserDetailResponse();
        UserDetail userDetail = new UserDetail();
        userDetail.setName(user.getName());
        userDetail.setUserId(user.getUserId());
        userDetailResponse.setUser(userDetail);
        ResponseDto<List<UserTransaction>> userTransactions = client.getUserTransactions(user.getUserId());
        if(userTransactions == null) {
            throw new ClientException("Failed in Transaction API");
        }
        userDetailResponse.setTransactions(userTransactions.getData());
        return userDetailResponse;
    }

    private void validateUser(UserRequest user) {
        if(user == null || StringUtils.isBlank(user.getUserId()) || 
            StringUtils.isBlank(user.getName()) || StringUtils.isBlank(user.getPassword())) {
                throw new InvalidRequestException("Invalid User Request");
            } 
    }

    private User validateAndGetUser(String userId) {
        if(StringUtils.isBlank(userId)) {
            throw new InvalidRequestException("Invalid User Id");
        }
        User user = repo.findByUserId(userId);
        if(user == null) {
            throw new InvalidRequestException("No User Found for User Id : " + userId);
        }
        return user;
    }

    
    
}