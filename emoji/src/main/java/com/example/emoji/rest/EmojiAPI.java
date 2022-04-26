package com.example.emoji.rest;

import com.example.emoji.dto.EmojiDTO;
import com.example.emoji.service.EmojiFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
public class EmojiAPI {

    Logger logger = LoggerFactory.getLogger(EmojiAPI.class);

    @Autowired
    private EmojiFactory emojiFactory;

    @GetMapping("/emojis")
    List<EmojiDTO> all(@RequestHeader Map<String, String> headers) {
        for (String header: headers.keySet()) {
            logger.info(header + " : " + headers.get(header));
        }
        return emojiFactory.getAllEmojis();
    }
}
