package com.example.firstSpringApp;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserServices {

    private final List<UserDAO> users;

    public UserServices(List<UserDAO> users) {
        this.users = users;
    }
    public List<UserDAO> getAllUsers() {
        return users;
    }

    public UserDAO getUserById(int id) {
        if (id >= 1 && id <= users.size()) {
            return users.get(id - 1);
        } else {
            throw new RuntimeException("User not found");
        }
    }

    public List<UserDAO> addUser(UserDAO user) {
        users.add(user);
        return users;
    }

    public List<UserDAO> updateUser(int id, UserDAO user) {
        if (id >= 1 && id <= users.size()) {
            UserDAO existingUser = users.get(id - 1);
            existingUser.setUserName(user.getUserName());
            return users;
        } else {
            throw new RuntimeException("User not found");
        }
    }

    public List<UserDAO> deleteUser(int id) {
        if (id >= 1 && id <= users.size()) {
            users.remove(id - 1);
            return users;
        } else {
            throw new RuntimeException("User not found");
        }
    }
}