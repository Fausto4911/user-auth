package com.userauthentication.userauth.security;

import com.userauthentication.userauth.domain.UserDto;
import com.userauthentication.userauth.domain.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.UserDetailsManagerConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserDetail implements UserDetailsService {

    @Autowired
    UserService userService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.userauthentication.userauth.domain.User user = userService.findUserByName(username);
        if (user != null) {
            return User.builder().password(user.getPassword())
                    .username(user.getUsername())
                    .roles("ADMIN")
                    .build();
        }
        throw new UsernameNotFoundException("User not found.");
    }




}
