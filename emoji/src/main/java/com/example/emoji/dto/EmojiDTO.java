package com.example.emoji.dto;

public class EmojiDTO {
    private String name;
    private String emojiChars;

    public EmojiDTO() {
    }

    public EmojiDTO(String name, String emojiChars) {
        this.name = name;
        this.emojiChars = emojiChars;
    }

    public String getName() {
        return name;
    }

    public String getEmojiChars() {
        return emojiChars;
    }
}
