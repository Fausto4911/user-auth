package com.userauthentication.userauth.domain;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;


    public User findUserByName(String username) {

        for (User user : userRepository.findAll()) {
            if (user.getUsername().equals(username))
                return user;
        }
        return null;
    }


    public User findUserById(Integer id) {

        for (User user : userRepository.findAll()) {
            if (user.getId().equals(id))
                return user;
        }

        return null;
    }


    public void createUser(UserDto user) {
        User usr = new User();
        usr.setUsername(user.getUsername());
        usr.setPassword(user.getPassword());
        userRepository.save(usr);
    }


    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }


    public void deleteUserByName(String username) {
        userRepository.deleteById(findUserByName(username).getId());
    }

}