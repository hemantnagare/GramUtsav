package com.gramutsav.repository;

import com.gramutsav.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<Users,Integer> {

    Users FindUsersByEmail( String email);
}
