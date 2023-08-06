package com.codeshinobis.csuserprofileapi.model;

import java.util.List;

import lombok.Data;

@Data
public class UserDetailResponse {

    private User user;
    private List<UserTransaction> transactions;
    
}
