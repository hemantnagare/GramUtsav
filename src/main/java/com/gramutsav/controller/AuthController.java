package com.gramutsav.controller;

import com.gramutsav.dto.LoginRequest;
import com.gramutsav.entity.Users;
import com.gramutsav.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    public Map<String,String> Login(@RequestBody LoginRequest request )
    {
           Users user = userRepository.FindUsersByEmail(request.getEmail());
        Map<String, String> response = new HashMap<>();

        if (user != null && user.getPassword().equals(request.getPassword())) {

            response.put("token", "dummy-jwt-token");
            response.put("message", "Login Success");

        } else {

            response.put("message", "Invalid Credentials");
        }

        return response;
    }
}
