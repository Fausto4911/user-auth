package com.userauthentication.userauth.domain;

public class UserDto {

    private String username;

    private String password;

    public UserDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserDto() {
        
    }

    public String getUsername() {
        return username;
    }

    public void setName(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
