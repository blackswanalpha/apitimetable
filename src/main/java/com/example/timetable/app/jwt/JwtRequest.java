package com.example.timetable.app.jwt;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class JwtRequest {
    @NotNull(message = "username shouldn't be null")
    @NotBlank(message = "user must not be blank")
    private String userName;


    @NotNull(message = "password shouldn't be null")
    @NotBlank(message = "password must not be blank")
    private String userPassword;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
