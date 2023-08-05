package com.codeshinobis.csuserprofileapi.model;

import lombok.Data;

@Data
public class UserRequest {

    private String userId;
    private String name;
    private String password;
    
}
