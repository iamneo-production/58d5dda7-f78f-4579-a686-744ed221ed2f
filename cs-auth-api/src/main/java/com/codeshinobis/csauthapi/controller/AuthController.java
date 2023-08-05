package com.codeshinobis.csauthapi.controller;

import com.codeshinobis.csauthapi.model.AuthRequest;
import com.codeshinobis.csauthapi.model.ResponseDto;
import com.codeshinobis.csauthapi.model.Token;
import com.codeshinobis.csauthapi.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class AuthController {

    private AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<ResponseDto<Token>> authenticate(@RequestBody AuthRequest authRequest) {

        //validate request by checking in DB
        authService.validateUser(authRequest);

        // generate access token
        Token token = authService.generateAccessToken(authRequest.getUserId());

        return ResponseEntity.status(HttpStatus.OK).body(ResponseDto.forSuccess(token));

    }

    @PostMapping("/validate")
    public ResponseEntity<ResponseDto<String>> validateToken(@RequestBody String accessToken) {

        return ResponseEntity.status(HttpStatus.OK).body(ResponseDto.forSuccess(authService.validateAccessToken(accessToken)));

    }

}
