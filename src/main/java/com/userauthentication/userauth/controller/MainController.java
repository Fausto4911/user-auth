package com.userauthentication.userauth.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.userauthentication.userauth.domain.User;
import com.userauthentication.userauth.domain.UserDto;
import com.userauthentication.userauth.domain.UserRepository;
import com.userauthentication.userauth.domain.quote.Quote;
import com.userauthentication.userauth.domain.quote.QuoteRepository;
import com.userauthentication.userauth.domain.quote.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
public class MainController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private QuoteService quoteService;

    @GetMapping(value = {"/", "/login"})
    public String getLogin() {
        return "login";
    }

    @GetMapping(value = "/home")
    public String home(Model model) {

        Quote q1 = new Quote("111","222", "222","222");
        Quote q2 = new Quote("222","222", "222","222");
        Quote q3 = new Quote("333","222", "222","222");
        Quote q4 = new Quote("444","222", "222","222");
        quoteService.save(q1);
        quoteService.save(q2);
        quoteService.save(q3);

        quoteService.save(q4);
       model.addAttribute("quotes", quoteService.getAllQuotes());
        return "home";
    }

    @GetMapping(value = "/test")
    public String test() {
        return "test";
    }

    @PostMapping(value = "/add")
    public ResponseEntity<String> addNewUser(@RequestBody String userJson) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            UserDto userDto = objectMapper.readValue(userJson, UserDto.class);
            User user = new User();
            user.setUsername(userDto.getUsername());
            user.setPassword(userDto.getPassword());
            userRepository.save(user);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.toString(), headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(userJson, headers, HttpStatus.OK);
    }

    @GetMapping(value = "/all")
    public @ResponseBody
    Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
}