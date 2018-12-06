package com.userauthentication.userauth.domain;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class DefaultUser {
    @Autowired
    private UserRepository userRepository;


    @Bean
    public void defaulUser() {
        System.out.println("creating user ===");
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        User user = new User("metra",encoder.encode("password"));
        userRepository.save(user);



    }

}
