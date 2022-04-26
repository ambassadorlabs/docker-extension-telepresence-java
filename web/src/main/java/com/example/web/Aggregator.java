package com.example.web;

import com.example.web.dto.EmojiDTO;
import com.example.web.dto.UserDTO;
import com.example.web.dto.UserEmojiDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Aggregator {

    Logger logger = LoggerFactory.getLogger(Aggregator.class);

    @Autowired
    private RestTemplate restTemplate;

    @Value("${user.url}")
    private String userURL;

    @Value("${emoji.url}")
    private String emojisURL;

    private Map<String, EmojiDTO> findEmojis() {
        ResponseEntity<List<EmojiDTO>> rateResponse =
                restTemplate.exchange(emojisURL, HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<EmojiDTO>>() {
                        });

        Map<String, EmojiDTO> emojiMap = new HashMap<>();
        for (EmojiDTO emoji : rateResponse.getBody()) {
            emojiMap.put(emoji.getName(), emoji);
        }
        return emojiMap;
    }

    private List<UserDTO> findUsers() {
        ResponseEntity<List<UserDTO>> rateResponse =
                restTemplate.exchange(userURL, HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<UserDTO>>() {
                        });
        return rateResponse.getBody();
    }

    public List<UserEmojiDTO> aggregateUserEmojis() {
        List<UserEmojiDTO> results = new ArrayList<>();

        List<UserDTO> users = findUsers();
        Map<String, EmojiDTO> emojis = findEmojis();

        for (UserDTO user : users) {
            results.add(new UserEmojiDTO(user.getUsername(), emojis.get(user.getEmoji()).getEmojiChars()));
        }
        return results;
    }
}
