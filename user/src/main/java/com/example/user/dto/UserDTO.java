package com.example.user.dto;

public class UserDTO {
    private String userId;
    private String username;
    private String emoji;

    public UserDTO() {
    }

    public UserDTO(String userId, String username, String emoji) {
        this.userId = userId;
        this.username = username;
        this.emoji = emoji;
    }

    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getEmoji() {
        return emoji;
    }
}
