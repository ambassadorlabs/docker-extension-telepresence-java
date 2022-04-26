package com.example.web.rest;

import com.example.web.Aggregator;
import com.example.web.dto.UserEmojiDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.Map;

@RestController
public class ApiController {

    Logger logger = LoggerFactory.getLogger(ApiController.class);

    @Autowired
    private Aggregator aggregator;

    @GetMapping("/api")
    public List<UserEmojiDTO> getAllUsers(@RequestHeader Map<String, String> headers) {
        logger.info("Entry!");
//        return Arrays.asList(new UserEmojiDTO("Daniel", "&#128512;"), new UserEmojiDTO("Moby", "&#128011;"));
        return aggregator.aggregateUserEmojis();
    }
}
