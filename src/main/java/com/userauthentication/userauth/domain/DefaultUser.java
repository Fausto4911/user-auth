package com.userauthentication.userauth.domain;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class DefaultUser {

    @Autowired
    private UserService userService;


    @Bean
    public void defaulUser() {
        System.out.println("creating user ===");
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (userService.findUserByName("metra") == null) {
            User user = new User("metra", encoder.encode("password"));
            userService.createUser(user);
        }
    }

}
