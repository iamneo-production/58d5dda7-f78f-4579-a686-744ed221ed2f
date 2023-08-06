package com.codeshinobis.csuserprofileapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeshinobis.csuserprofileapi.model.ResponseDto;
import com.codeshinobis.csuserprofileapi.model.UserDetailResponse;
import com.codeshinobis.csuserprofileapi.model.UserRequest;
import com.codeshinobis.csuserprofileapi.model.UserResponse;

@RestController
@RequestMapping(value = "/api/user-profile")
public class UserController {

    @PostMapping("/register")
    public ResponseEntity<ResponseDto<String>> register(@RequestBody UserRequest userRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(ResponseDto.forSuccess("User Register Successfully"));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<ResponseDto<UserResponse>> getUser(@PathVariable String userId) {
        return ResponseEntity.status(HttpStatus.OK).body(ResponseDto.forSuccess(new UserResponse()));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<ResponseDto<UserDetailResponse>> getUserDetails(@PathVariable String userId) {
        return ResponseEntity.status(HttpStatus.OK).body(ResponseDto.forSuccess(new UserDetailResponse()));
    }
    
}
