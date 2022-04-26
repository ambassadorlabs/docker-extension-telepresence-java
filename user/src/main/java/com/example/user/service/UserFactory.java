package com.example.user.service;

import com.example.user.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserFactory {

    private static List<UserDTO> USERS = Arrays.asList(
            new UserDTO("1", "Daniel", "smile"),
            new UserDTO("2", "Moby", "whale"),
            new UserDTO("3", "Harold", "smile"),
            new UserDTO("4", "Jane", "smile"),
            new UserDTO("5", "Alix", "smile")
    );

    public List<UserDTO> getAllUsers() {
        List<UserDTO> updatedUsers = new ArrayList<>();
        for (UserDTO user : USERS) {
            updatedUsers.add(new UserDTO(user.getUserId(), user.getUsername(), "whale"));
        }
        return updatedUsers;

//        return USERS;
    }
}
