package com.example.web.rest;

import com.example.web.Aggregator;
import com.example.web.dto.UserEmojiDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;

@Controller
public class WebController {

    @Autowired
    private Aggregator aggregator;

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("userEmojis", aggregator.aggregateUserEmojis());
        return "welcome";
    }
}
