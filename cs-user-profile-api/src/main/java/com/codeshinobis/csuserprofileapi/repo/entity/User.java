package com.codeshinobis.csuserprofileapi.repo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "USER_PROFILE")
public class User {

    @Id
    @Column(name = "USER_ID")
    private String userId;
    @Column(name = "NAME")
    private String name;
    @Column(name = "PASSWORD")
    private String password;
    
}
