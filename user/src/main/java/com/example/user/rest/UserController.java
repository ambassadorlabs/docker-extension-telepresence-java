package com.example.user.rest;

import com.example.user.dto.UserDTO;
import com.example.user.service.UserFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserFactory userFactory;

    @GetMapping("/users")
    public List<UserDTO> getAllUsers() {
        return userFactory.getAllUsers();
    }
}
