package com.example.emoji.service;

import com.example.emoji.dto.EmojiDTO;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class EmojiFactory {

    private static List<EmojiDTO> EMOJIS = Arrays.asList(
            new EmojiDTO("whale", "&#128011;"),
            new EmojiDTO("smile", "&#128512;"));

    public List<EmojiDTO> getAllEmojis() {
        return EMOJIS;
    }
}
