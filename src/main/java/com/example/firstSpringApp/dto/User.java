package com.example.firstSpringApp.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

public class User {
    @Valid

    @NotNull(message = "User ID should not be null")
    private String userId;
    @Size(min = 3,max = 10,message = "User Name must be between 5 and 10")
    private String userName;
    @Valid
    @Min(value = 1)
    @Max(value = 1000000)
    private int number;

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", number=" + number +
                '}';
    }
    public User(String userId, String userName, int number) {
        this.userId = userId;
        this.userName = userName;
        this.number = number;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
