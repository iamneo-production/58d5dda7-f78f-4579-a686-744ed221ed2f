package com.codeshinobis.csauthapi.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.codeshinobis.csauthapi.client.model.User;
import com.codeshinobis.csauthapi.model.ResponseDto;

@Component
@FeignClient(name = "cs-api-gateway")
public interface UserAPI {

    @GetMapping("/api/cs/user-profile/user/{userId}")
    
    ResponseEntity<ResponseDto<User>> getUser(@PathVariable String userId);
    
}
