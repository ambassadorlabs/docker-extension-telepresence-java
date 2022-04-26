package com.example.web.dto;

public class UserEmojiDTO {
    private String username;
    private String emojiChars;

    public UserEmojiDTO() {
    }

    public UserEmojiDTO(String username, String emojiChars) {
        this.username = username;
        this.emojiChars = emojiChars;
    }

    public String getUsername() {
        return username;
    }

    public String getEmojiChars() {
        return emojiChars;
    }
}
