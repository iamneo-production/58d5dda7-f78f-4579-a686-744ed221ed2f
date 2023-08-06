package com.codeshinobis.csuserprofileapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codeshinobis.csuserprofileapi.repo.entity.User;

public interface UserRepository extends JpaRepository<User, String> {

    User findByUserId(String userId);
    
}
